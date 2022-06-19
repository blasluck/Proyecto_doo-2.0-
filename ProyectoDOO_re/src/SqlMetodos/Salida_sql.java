/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import BOL.Entrada;
import BOL.Productos;
import BOL.Salida;
import BOL.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Salida_sql {
    
    Conexiones conexion = new Conexiones();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    
    static int id_salida;
    static String cod_salida;
    static String salida_temp;
    static int stock_prod;
    static int stock_new;
    public DefaultTableModel listar_salida(){
        DefaultTableModel modelo_entrada = new DefaultTableModel();
        String[] columnas={"Codigo","Producto", "Tipo", "Encargado","Almacen","Cantidad","Fecha"};
        modelo_entrada.setColumnIdentifiers(columnas);
            try {
                ps = con.prepareStatement("SELECT * FROM persona, trabajadores, producto, sistema_salida WHERE persona.id_persona = trabajadores.cod_persona AND"
                        + " trabajadores.id_trabajador = sistema_salida.cod_trabajador AND producto.id_producto = sistema_salida.cod_producto");
                rs = ps.executeQuery();
                while(rs.next()){
                    Object[] ob = new Object[7];
                    ob[0] = rs.getString("sistema_salida.id_salida");
                    ob[1] = rs.getString("producto.nombre_producto");
                    ob[2] = rs.getString("producto.tipo");
                    ob[3] = rs.getString("persona.nombres");
                    ob[4] = rs.getString("producto.almacen");
                    ob[5] = rs.getString("sistema_salida.cantidad_salida");
                    ob[6] = rs.getString("sistema_salida.f_salida");
                    modelo_entrada.addRow(ob);
                }
                ps.close();
                rs.close();
                list_salida();
            } catch (SQLException e) {
                    System.out.println("Error al listar Sistema de salida: " +e);
            }
        return modelo_entrada;
    }
    
    
    
    /*METODOS NUEVA ENTRADA*/
  
  
    public void add_Sistema_salida(Salida salida){
        int total = stock_prod - salida.getCant_ingreso();
        System.out.println("El total de stock ahora es: "+ total);
        try {
            ps = con.prepareStatement("INSERT INTO sistema_salida VALUES(?,?,?,?,?)");
            ps.setString(1,cod_salida);
            ps.setString(2, salida.getProducto());
            ps.setString(3, salida.getTrabajador());
            ps.setInt(4, salida.getCant_ingreso());
            ps.setString(5, salida.getF_Salida());
            ps.executeUpdate();
            ps.close();
            
            ps = con.prepareStatement("UPDATE producto SET cantidad=? WHERE id_producto = ?");
            ps.setInt(1, total);
            ps.setString(2,salida.getProducto());
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
                System.out.println("Error al encontrar trabajador:" + e.getMessage());
            }
        return t;
    }
    
    
    
    
    
    
    
    
    //Este metodo nos mostrara si es apto el ingreso de mas cantidad
    public boolean cant_limite(String cod_prod, int cantidad){
        int stock=0, total;
        boolean aprobado= true;
        try {
            ps = con.prepareStatement("SELECT * FROM producto WHERE id_producto=?");
            ps.setString(1, cod_prod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                stock = rs.getInt("cantidad");
                stock_new = stock;
                total = stock - cantidad;
                System.out.println("total: "+ total );
                if(total<0){
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
        Salida s = new Salida();
  
        try {
            ps = con.prepareStatement("SELECT * FROM persona, trabajadores, producto, sistema_salida WHERE persona.id_persona = trabajadores.cod_persona"
                    + " AND trabajadores.id_trabajador = sistema_salida.cod_trabajador AND producto.id_producto = sistema_salida.cod_producto AND sistema_salida.id_salida = ?");
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
                s.setCant_ingreso(rs.getInt("sistema_salida.cantidad_salida"));
                
                //Obtencion del trabajador ingresado
                t.setId(rs.getString("trabajadores.id_trabajador"));
                t.setNombres(rs.getString("persona.nombres"));
                t.setCargo(rs.getString("persona.cargo"));
                
                //Obtencion de la fecha 
                s.setId_salida(rs.getString("sistema_salida.id_salida"));
                s.setF_Salida(rs.getString("sistema_salida.f_salida"));
                
                ob[0] = p;
                ob[1] = t;
                ob[2] = s;
            }else{
                System.out.println("ERROR AL ENCONTRAR LA Salida");
            }
            
        } catch (SQLException eX) {
            System.out.println("Error al capturar datos del sistema de salida: " + eX.getMessage());
        }
        
        return ob;
    }
    
    
    
    
    //Metodo para validar si son iguales los codigos ha actualizar

    
    public void update_CodEquals(Object[] antiguo, Object[] nuevo){
        System.out.println("Actualisado igual entrando");
        Productos p_nuevo = (Productos) nuevo[0];
        Trabajador t_nuevo = (Trabajador) nuevo[1];
        Salida s_antiguo = (Salida) antiguo[2];
        Salida s_nuevo = (Salida) nuevo[2];   
        System.out.println("UWU: " + s_nuevo.getCant_ingreso());
        System.out.println("uwoow 2"+ s_antiguo.getId_salida());
        /*Actualizado producto*/
        try {
            ps = con.prepareStatement("UPDATE producto SET cantidad =? WHERE id_producto=?");
            ps.setInt(1, p_nuevo.getCantidad());
            ps.setString(2, p_nuevo.getCodigoProducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
                System.out.println("Error al actualizar productos Salida: " + e.getMessage());
        }
        
        /*Actualizado entrada*/
        try {
            ps = con.prepareStatement("UPDATE sistema_salida SET cod_trabajador=?, cantidad_salida=?, f_salida = ? WHERE id_salida=?");
            ps.setString(1, t_nuevo.getId());
            ps.setInt(2, s_nuevo.getCant_ingreso());
            ps.setString(3, s_nuevo.getF_Salida());
            ps.setString(4, s_antiguo.getId_salida());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
                System.out.println("Error al actualizar Salida: " + e.getMessage());
        }
        
    }
    
    
    public void update_CodDiferent(Object[] antiguo, Object[] nuevo){
        System.out.println("El NUEVO STOCK A MODIFICAR ES: " + stock_new);
        Productos p_nuevo = (Productos) nuevo[0];
        Productos p_antiguo = (Productos) antiguo[0];
        Trabajador t_nuevo = (Trabajador) nuevo[1];
        Salida s_antiguo = (Salida) antiguo[2];
        Salida s_nuevo = (Salida) nuevo[2];   
        int total = stock_new - s_nuevo.getCant_ingreso();
        
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
            
            ps = con.prepareStatement("UPDATE sistema_salida SET cod_producto=?, cod_trabajador=?, cantidad_salida=?, f_salida = ? WHERE id_salida=?");
            
            ps.setString(1, p_nuevo.getCodigoProducto());
            ps.setString(2, t_nuevo.getId());
            ps.setInt(3, s_nuevo.getCant_ingreso());
            ps.setString(4, s_nuevo.getF_Salida());
            ps.setString(5, s_antiguo.getId_salida());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
                System.out.println("Error al actualizar Salida: " + e.getMessage());
        }
        
    }
    
    
    
    
    
    /*METODOS ELIMINAR ENTRADA*/
    public void delete_Salida(Object[] antiguo){
        Productos p_antiguo =(Productos) antiguo[0];
        Salida s_antiguo = (Salida) antiguo[2];
        System.out.println("Cantidad actualizada luego de elimnar: " +p_antiguo.getCantidad());
        /*Actualizado de producto*/
        try {
            ps = con.prepareStatement("UPDATE producto SET cantidad=? WHERE id_producto=?");
            ps.setInt(1, p_antiguo.getCantidad());
            ps.setString(2, p_antiguo.getCodigoProducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar salida: "+ e);
        }
        
        /*Eliminado de entrada*/
        try {
            ps = con.prepareStatement("DELETE FROM sistema_salida  WHERE id_salida = ?");
            ps.setString(1, s_antiguo.getId_salida());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar salida: " +e);
        }
        
        
    }
    
    
    
    /*METODOS DE CODIGO PARA ENTRADA*/
    
    public void count_Table(){
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM sistema_salida");
            rs = ps.executeQuery();
            if(rs.next()){
                id_salida = rs.getInt("count(*)");
                System.out.println("El nuevo id es: " + id_salida);
            }else{
                System.out.println("NO hay nada en la tabla producto");
                id_salida = 0;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el numero del sistema de salida:"+e);
        }
    }
    
    
    public String id_Entrada(String ultim_salida){
        String defin="", id_pe="";
        int long_p = ultim_salida.length();
        /*Almacenamiento de la ultima persona*/
            defin+= ultim_salida.charAt(long_p-2);
            defin+= ultim_salida.charAt(long_p-1);
            System.out.println("DEFIN: "+defin);
        int new_pers = Integer.parseInt(defin);
        
        if(new_pers<10){
               id_pe = "salid_0"+(new_pers+1);
           }else{
               id_pe = "salid_"+(new_pers+1);
        }
        System.out.println("ELEMENTO TRASNFORMADO: " +id_pe );
        return id_pe;
    }
    
    
    public void list_salida(){
        try {
            count_Table();
            ps = con.prepareStatement("SELECT * FROM sistema_salida");
            rs = ps.executeQuery();
            int i=1;
            while(rs.next()){
                if(i==id_salida){
                        cod_salida = id_Entrada(rs.getString("id_salida"));//Metemos el ultimo elemento
                        System.out.println("ELEMENTO CAPTURADO EN LA LISTA: "+ rs.getString("id_salida"));
                }
                i++;
            }   
            if(id_salida < 1){
                System.out.println("LLegue a saber que no hay ningun producto");
                cod_salida = "salid_01";
                System.out.println("COD SALIDA: " +cod_salida);
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL LISTAR SISTEMA DE SALIDA: "+ e.getMessage());
        }   
    }
    
    
    /*METODO BUSQUEDA POR FECHA*/
    public DefaultTableModel search_Fecha(String fecha){
        DefaultTableModel modelo_entrada = new DefaultTableModel();
        String[] columnas={"Codigo","Producto", "Tipo", "Encargado","Almacen","Cantidad","Fecha"};
        modelo_entrada.setColumnIdentifiers(columnas);
            try {
                ps = con.prepareStatement("SELECT * FROM persona, trabajadores, producto, sistema_salida WHERE persona.id_persona = trabajadores.cod_persona AND"
                        + " trabajadores.id_trabajador = sistema_salida.cod_trabajador AND producto.id_producto = sistema_salida.cod_producto");
                rs = ps.executeQuery();
                while(rs.next()){
                    if(rs.getString("sistema_salida.f_salida").substring(0,10).equals(fecha)){
                        Object[] ob = new Object[7];
                        ob[0] = rs.getString("sistema_salida.id_salida");
                        ob[1] = rs.getString("producto.nombre_producto");
                        ob[2] = rs.getString("producto.tipo");
                        ob[3] = rs.getString("persona.nombres");
                        ob[4] = rs.getString("producto.almacen");
                        ob[5] = rs.getString("sistema_salida.cantidad_salida");
                        ob[6] = rs.getString("sistema_salida.f_salida");
                        modelo_entrada.addRow(ob);
                    }
                }
                ps.close();
                rs.close();
            } catch (SQLException e) {
                    System.out.println("Error al listar Sistema de salida: " +e);
            }
        return modelo_entrada;
    }

}
