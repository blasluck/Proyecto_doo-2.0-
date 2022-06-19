/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import BOL.Productos;
import BOL.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BOL.Entrada;
/**
 *
 * @author Daniel
 */
public class Entrada_sql {
    
    Conexiones conexion = new Conexiones();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    
    static int id_entrada;
    static String cod_entrada;
    static String entrada_temp;
    static int stock_prod;
    static int stock_new;
    public DefaultTableModel listar_entrada(){
        DefaultTableModel modelo_entrada = new DefaultTableModel();
        String[] columnas={"Codigo","Producto", "Tipo", "Encargado","Almacen","Cantidad","Fecha"};
        modelo_entrada.setColumnIdentifiers(columnas);
            try {
                ps = con.prepareStatement("SELECT * FROM persona, trabajadores, producto, sistema_entrada WHERE persona.id_persona = trabajadores.cod_persona AND"
                        + " trabajadores.id_trabajador = sistema_entrada.cod_trabajador AND producto.id_producto = sistema_entrada.cod_producto");
                rs = ps.executeQuery();
                while(rs.next()){
                    Object[] ob = new Object[7];
                    ob[0] = rs.getString("sistema_entrada.id_entrada");
                    ob[1] = rs.getString("producto.nombre_producto");
                    ob[2] = rs.getString("producto.tipo");
                    ob[3] = rs.getString("persona.nombres");
                    ob[4] = rs.getString("producto.almacen");
                    ob[5] = rs.getString("sistema_entrada.cantidad_ingreso");
                    ob[6] = rs.getString("sistema_entrada.f_ingreso");
                    modelo_entrada.addRow(ob);
                }
                ps.close();
                rs.close();
                list_entrada();
            } catch (SQLException e) {
                    System.out.println("Error al listar Sistema de entradas: " +e);
            }
        return modelo_entrada;
    }
    
    
    
    /*METODOS NUEVA ENTRADA*/
  
  
    public void add_Sistema_entrada(Entrada entrada){
        int total = entrada.getCant_ingreso() + stock_prod;
        System.out.println("El total de stock ahora es: "+ total);
        try {
            ps = con.prepareStatement("INSERT INTO sistema_entrada VALUES(?,?,?,?,?)");
            ps.setString(1,cod_entrada);
            ps.setString(2, entrada.getProducto());
            ps.setString(3, entrada.getTrabajador());
            ps.setInt(4, entrada.getCant_ingreso());
            ps.setString(5, entrada.getF_Ingreso());
            ps.executeUpdate();
            ps.close();
            
            ps = con.prepareStatement("UPDATE producto SET cantidad=? WHERE id_producto = ?");
            ps.setInt(1, total);
            ps.setString(2,entrada.getProducto());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println("Error al ingresar el sistema de entrada"+ e.getMessage());
        }
    }
    
    
    public Productos search_Prod(String cod_prod){
        Productos p = new Productos();
        try {
            ps = con.prepareStatement("SELECT * FROM producto WHERE id_producto=?");
            ps.setString(1, cod_prod);
            rs= ps.executeQuery();
            if(rs.next()){
                p.setNombreProducto(rs.getString("nombre_producto"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setAlmacen(rs.getInt("almacen"));
                p.setTipo(rs.getString("tipo"));
            }else{
               JOptionPane.showMessageDialog(null, "Producto no encotrado", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
                System.out.println("Producto no encontrado: "+ e.getMessage());
        }
        return p;
    }
    
    
    public Trabajador search_Trabj(String cod_trbj){
        Trabajador t = new Trabajador();
            try {
                ps = con.prepareStatement("SELECT * FROM persona, trabajadores WHERE persona.id_persona = trabajadores.cod_persona AND id_trabajador=?");
                ps.setString(1, cod_trbj);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    t.setNombres(rs.getString("persona.nombres"));
                    t.setCargo(rs.getString("persona.cargo"));
                }else{
                    JOptionPane.showMessageDialog(null, "Trabajador no encotrado", "", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                System.out.println("Erro al encontrar trabajador:" + e.getMessage());
            }
        return t;
    }
    
    
    
    
    
    
    
    
    //Este metodo nos mostrara si es apto el ingreso de mas cantidad
    public boolean cant_limite(String cod_prod, int cantidad){
        int limite=0, stock=0, total;
        boolean aprobado= true;
        try {
            ps = con.prepareStatement("SELECT * FROM producto WHERE id_producto=?");
            ps.setString(1, cod_prod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                stock = rs.getInt("cantidad");
                limite = rs.getInt("cant_limite");
                stock_new = stock;
                total = cantidad + stock;
                System.out.println("Limite: " +limite+" total: "+ total );
                if(total>limite){
                    aprobado = false;
                }else{
                    aprobado = true;
                    stock_prod = rs.getInt("cantidad");
                }   
            }
            System.out.println("DEVOLVI CANT LIMITE:: "+ aprobado);
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al comparar el limite: " + e.getMessage());
        }
        return aprobado;
    }
    
    
    /*METODOS ACTUALIZAR ENTRADA*/
    
    
    public Object[] obtencion_Datos(String cod_entrada){  
        Object[] ob = new Object[3];
        /*Datos a almacenar*/
        Trabajador t = new Trabajador();
        Productos p = new Productos();
        Entrada e = new Entrada();
  
        try {
            ps = con.prepareStatement("SELECT * FROM persona, trabajadores, producto, sistema_entrada WHERE persona.id_persona = trabajadores.cod_persona"
                    + " AND trabajadores.id_trabajador = sistema_entrada.cod_trabajador AND producto.id_producto = sistema_entrada.cod_producto AND sistema_entrada.id_entrada = ?");
            ps.setString(1, cod_entrada);
            rs = ps.executeQuery();
            
            if(rs.next()){
                //Obtencion del producto ingresado
                p.setCodigoProducto(rs.getString("producto.id_producto"));
                System.out.println("Codigo de prod obtenido:  "+ rs.getString("producto.id_producto") );
                p.setNombreProducto(rs.getString("producto.nombre_producto"));
                p.setLimite(rs.getInt("producto.cant_limite"));
                p.setCantidad(rs.getInt("producto.cantidad"));
                p.setTipo(rs.getString("producto.tipo"));
                p.setAlmacen(rs.getInt("producto.almacen"));
                e.setCant_ingreso(rs.getInt("sistema_entrada.cantidad_ingreso"));
                
                //Obtencion del trabajador ingresado
                t.setId(rs.getString("trabajadores.id_trabajador"));
                t.setNombres(rs.getString("persona.nombres"));
                t.setCargo(rs.getString("persona.cargo"));
                
                //Obtencion de la fecha 
                e.setId_entrada(rs.getString("sistema_entrada.id_entrada"));
                e.setF_Ingreso(rs.getString("sistema_entrada.f_ingreso"));
                
                ob[0] = p;
                ob[1] = t;
                ob[2] = e;
            }else{
                System.out.println("ERROR AL ENCONTRAR LA ENTRADA");
            }
            
        } catch (SQLException eX) {
            System.out.println("Error al capturar datos: " + eX.getMessage());
        }
        
        return ob;
    }
    
    
    
    
    //Metodo para validar si son iguales los codigos ha actualizar

    
    public void update_CodEquals(Object[] antiguo, Object[] nuevo){
        System.out.println("Actualisado igual entrando");
        Productos p_nuevo = (Productos) nuevo[0];
        Trabajador t_nuevo = (Trabajador) nuevo[1];
        Entrada e_antiguo = (Entrada) antiguo[2];
        Entrada e_nuevo = (Entrada) nuevo[2];   
        System.out.println("UWU: " + e_nuevo.getCant_ingreso());
        System.out.println("uwoow 2"+ e_antiguo.getId_entrada());
        /*Actualizado producto*/
        try {
            ps = con.prepareStatement("UPDATE producto SET cantidad =? WHERE id_producto=?");
            ps.setInt(1, p_nuevo.getCantidad());
            ps.setString(2, p_nuevo.getCodigoProducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
                System.out.println("Error al actualizar productos Entrada: " + e.getMessage());
        }
        
        /*Actualizado entrada*/
        try {
            ps = con.prepareStatement("UPDATE sistema_entrada SET cod_trabajador=?, cantidad_ingreso=?, f_ingreso = ? WHERE id_entrada=?");
            ps.setString(1, t_nuevo.getId());
            ps.setInt(2, e_nuevo.getCant_ingreso());
            ps.setString(3, e_nuevo.getF_Ingreso());
            ps.setString(4, e_antiguo.getId_entrada());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
                System.out.println("Error al actualizar Entrada: " + e.getMessage());
        }
        
    }
    
    
    public void update_CodDiferent(Object[] antiguo, Object[] nuevo){
        System.out.println("El NUEVO STOCK A MODIFICAR ES: " + stock_new);
        Productos p_nuevo = (Productos) nuevo[0];
        Productos p_antiguo = (Productos) antiguo[0];
        Trabajador t_nuevo = (Trabajador) nuevo[1];
        Entrada e_antiguo = (Entrada) antiguo[2];
        Entrada e_nuevo = (Entrada) nuevo[2];   
        int total = stock_new + e_nuevo.getCant_ingreso();
        
         /*Actualizado antiguo producto*/
        try {
            ps = con.prepareStatement("UPDATE producto SET cantidad =? WHERE id_producto=?");
            ps.setInt(1, p_antiguo.getCantidad());
            ps.setString(2, p_antiguo.getCodigoProducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
                System.out.println("Error al actualizar productos Entrada: " + e.getMessage());
        }
        
        /*Actualizado nuevo producto*/
        try {
            
            ps = con.prepareStatement("UPDATE producto SET cantidad =? WHERE id_producto=?");
            ps.setInt(1, total);
            ps.setString(2, p_nuevo.getCodigoProducto());
            ps.executeUpdate();
            ps.close();
            
            ps = con.prepareStatement("UPDATE sistema_entrada SET cod_producto=?, cod_trabajador=?, cantidad_ingreso=?, f_ingreso = ? WHERE id_entrada=?");
            
            ps.setString(1, p_nuevo.getCodigoProducto());
            ps.setString(2, t_nuevo.getId());
            ps.setInt(3, e_nuevo.getCant_ingreso());
            ps.setString(4, e_nuevo.getF_Ingreso());
            ps.setString(5, e_antiguo.getId_entrada());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
                System.out.println("Error al actualizar Entrada: " + e.getMessage());
        }
        
    }
    
    
    
    
    
    /*METODOS ELIMINAR ENTRADA*/
    public void delete_Entrad(Object[] antiguo){
        Productos p_antiguo =(Productos) antiguo[0];
        Entrada e_antiguo = (Entrada) antiguo[2];
        System.out.println("Cantidad actualizada luego de elimnar: " +p_antiguo.getCantidad());
        /*Actualizado de producto*/
        try {
            ps = con.prepareStatement("UPDATE producto SET cantidad=? WHERE id_producto=?");
            ps.setInt(1, p_antiguo.getCantidad());
            ps.setString(2, p_antiguo.getCodigoProducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar entrada: "+ e);
        }
        
        /*Eliminado de entrada*/
        try {
            ps = con.prepareStatement("DELETE FROM sistema_entrada  WHERE id_entrada = ?");
            ps.setString(1, e_antiguo.getId_entrada());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar entrada: " +e);
        }
        
        
    }
    
    
    
    /*METODOS DE CODIGO PARA ENTRADA*/
    
    public void count_Table(){
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM sistema_entrada");
            rs = ps.executeQuery();
            if(rs.next()){
                id_entrada = rs.getInt("count(*)");
                System.out.println("El nuevo id es: " + id_entrada);
            }else{
                System.out.println("NO hay nada en la tabla producto");
                id_entrada = 0;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el numero del sistema de entrada:"+e);
        }
    }
    
    
    public String id_Entrada(String ultim_entrada){
        String defin="", id_pe="";
        int long_p = ultim_entrada.length();
        /*Almacenamiento de la ultima persona*/
            defin+= ultim_entrada.charAt(long_p-2);
            defin+= ultim_entrada.charAt(long_p-1);
            System.out.println("DEFIN: "+defin);
        int new_pers = Integer.parseInt(defin);
        
        if(new_pers<10){
               id_pe = "entrd_0"+(new_pers+1);
           }else{
               id_pe = "entrd_"+(new_pers+1);
        }
        System.out.println("ELEMENTO TRASNFORMADO: " +id_pe );
        return id_pe;
    }
    
    
    public void list_entrada(){
        try {
            count_Table();
            ps = con.prepareStatement("SELECT * FROM sistema_entrada");
            rs = ps.executeQuery();
            int i=1;
            while(rs.next()){
                if(i==id_entrada){
                        cod_entrada = id_Entrada(rs.getString("id_entrada"));//Metemos el ultimo elemento
                        System.out.println("ELEMENTO CAPTURADO EN LA LISTA: "+ rs.getString("id_entrada"));
                }
                i++;
            }   
            if(id_entrada < 1){
                System.out.println("LLegue a saber que no hay ningun producto");
                cod_entrada = "entrd_01";
                System.out.println("COD ENTRADA: " +cod_entrada);
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR AL LISTAR SISTEMA DE ENTRADA: "+ e.getMessage());
        }   
    }
    
    
    /*METODO BUSQUEDA POR FECHA*/
    
    public DefaultTableModel search_Fecha(String fecha){
        DefaultTableModel modelo_entrada = new DefaultTableModel();
        String[] columnas={"Codigo","Producto", "Tipo", "Encargado","Almacen","Cantidad","Fecha"};
        modelo_entrada.setColumnIdentifiers(columnas);
            try {
                ps = con.prepareStatement("SELECT * FROM persona, trabajadores, producto, sistema_entrada WHERE persona.id_persona = trabajadores.cod_persona AND"
                        + " trabajadores.id_trabajador = sistema_entrada.cod_trabajador AND producto.id_producto = sistema_entrada.cod_producto");
                rs = ps.executeQuery();
                while(rs.next()){
                    if(rs.getString("sistema_entrada.f_ingreso").substring(0,10).equals(fecha)){
                        Object[] ob = new Object[7];
                        ob[0] = rs.getString("sistema_entrada.id_entrada");
                        ob[1] = rs.getString("producto.nombre_producto");
                        ob[2] = rs.getString("producto.tipo");
                        ob[3] = rs.getString("persona.nombres");
                        ob[4] = rs.getString("producto.almacen");
                        ob[5] = rs.getString("sistema_entrada.cantidad_ingreso");
                        ob[6] = rs.getString("sistema_entrada.f_ingreso");
                        modelo_entrada.addRow(ob);
                    }
                }
                ps.close();
                rs.close();
            } catch (SQLException e) {
                    System.out.println("Error al listar Sistema de entradas: " +e);
            }
        return modelo_entrada;
    }
    
    
    
}
