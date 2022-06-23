/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import BOL.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import jpanel.Producto;

/**
 *
 * @author Daniel
 */
public class Producto_sql {
    Conexiones conexion = new Conexiones();
    
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int id_prod;
    String cod_prod;
    String prod_temp;
    
    
    public DefaultTableModel listar_Prod(){
        DefaultTableModel modelo_prod = new DefaultTableModel();
        String[] columnas = {"Codigo", "Nombre", "Tipo", "Almacen" , "Cantidad","Limite"};
        modelo_prod.setColumnIdentifiers(columnas);
            try {
                ps = con.prepareStatement("SELECT * FROM producto");
                rs = ps.executeQuery();
                while(rs.next()){
                    Object[] ob = new Object[6];
                    ob[0] = rs.getString("id_producto");
                    ob[1] = rs.getString("nombre_producto");
                    ob[2] = rs.getString("tipo");
                    ob[3] = rs.getString("almacen");
                    ob[4] = rs.getString("cantidad");
                    ob[5]= rs.getString("cant_limite");
                    modelo_prod.addRow(ob);
                }            
                ps.close();
                rs.close();
                list_producto();
            } catch (SQLException e) {
                System.out.println("Error al listar productos");
            }
        return modelo_prod;
    }
    
    
    public void add_Prod(Productos p){
        try {
            ps = con.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?)");
            ps.setString(1, cod_prod);
            ps.setString(2, p.getNombreProducto());
            ps.setString(3, p.getTipo());
            ps.setInt(4, p.getAlmacen());
            ps.setInt(5, p.getCantidad());
            ps.setInt(6,p.getLimite());
            ps.executeUpdate();
            ps.close();
            
            
        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " +e.getMessage());
        }
    }
    
    public void update_Prod(Productos p){
        try {
            ps = con.prepareStatement("UPDATE producto SET nombre_producto=?, tipo=?, almacen=?, cantidad=?, cant_limite=? WHERE id_producto=?");
            ps.setString(1, p.getNombreProducto());
            ps.setString(2, p.getTipo());
            ps.setInt(3, p.getAlmacen());
            ps.setInt(4, p.getCantidad());
            ps.setInt(5, p.getLimite());
            ps.setString(6, p.getCodigoProducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualisar producto: " +e.getMessage());
        }
    }
    

    public void delete_prod(String codigo){    
        eliminar_Entrada(codigo);
        eliminar_Salida(codigo );
        try {
            ps = con.prepareStatement("DELETE FROM producto WHERE id_producto=?");
            ps.setString(1, codigo);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " +e.getMessage());
        }
    }
    
    
    
    
    
    public void eliminar_Entrada(String cod_prod){
        try {
             ps = con.prepareStatement("DELETE FROM sistema_entrada WHERE cod_producto=?");
             ps.setString(1, cod_prod);
             ps.executeUpdate();
             ps.close();            
        } catch (Exception e) {
            System.out.println("Error al eliminar entradas del producto"+e);
        }
       
    }
    
    public void eliminar_Salida(String cod_prod){
        try {
             ps = con.prepareStatement("DELETE FROM sistema_salida WHERE cod_producto=?");
             ps.setString(1, cod_prod);
             ps.executeUpdate();
             ps.close();
            
        } catch (Exception e) {
            System.out.println("Error al eliminar salidas"+ e);
        }
       
    }
    
    
    
    
    /*METODO PARA GENERAR CODIGO SUCESIVO*/
    public void count_Table(){
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM producto");
            rs = ps.executeQuery();
            if(rs.next()){
                id_prod = rs.getInt("count(*)");
                System.out.println("El nuevo id es: " + id_prod);
            }else{
                System.out.println("NO hay nada en la tabla producto");
                id_prod = 0;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el numero de productos:"+e);
        }
    }
    
    
    public String id_prod(String ultim_prod){
        String defin="", id_pe="";
        int long_p = ultim_prod.length();
        /*Almacenamiento de la ultima persona*/
            defin+= ultim_prod.charAt(long_p-2);
            defin+= ultim_prod.charAt(long_p-1);
            System.out.println("DEFIN: "+defin);
        int new_pers = Integer.parseInt(defin);
        
        if(new_pers<10){
               id_pe = "prod_0"+(new_pers+1);
           }else{
               id_pe = "prod_"+(new_pers+1);
        }
        System.out.println("ELEMENTO TRASNFORMADO: " +id_pe );
        return id_pe;
    }
    
    
    public void list_producto(){
        try {
            count_Table();
            ps = con.prepareStatement("SELECT * FROM producto");
            rs = ps.executeQuery();
            int i=1;
            while(rs.next()){
                if(i==id_prod){
                        cod_prod= id_prod(rs.getString("id_producto"));//Metemos el ultimo elemento
                        System.out.println("ELEMENTO CAPTURADO EN LA LISTA: "+ rs.getString("id_producto"));
                }
                i++;
            }   
            
            if(id_prod < 1){
                System.out.println("LLegue a saber que no hay ningun producto");
                cod_prod = "prod_01";
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR AL LISTAR PRODUCTO: "+ e.getMessage());
        }   
    }
    
    
    
    
    
    
    
}
