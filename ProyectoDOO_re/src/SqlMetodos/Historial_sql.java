/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Historial_sql {
    Conexiones conexion = new Conexiones();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    /*Almacen de productos 
        con sus entradas y salidas*/
    ArrayList <Object> ob_prods = new ArrayList<Object>();
    int n_entrada =0, n_salida=0; 
    
    
    /***********************************************************************METODOS DE GRAFICA****************************************************/
    public ArrayList consumo_Mayor(){
        /*Otencion de todo los codigos de productos*/
        obtencion_Productos(); //Solo obtiene los codigos de los productos
            for(int i = 0; i<ob_prods.size();i++){
                Object[] ob = new Object[4];
                ob = (Object[]) ob_prods.get(i);
                System.out.println("OBTUVE DEL OBJETO "+ i+ "ob: "+ ob[0]);
                ob[1] = num_Entradas(ob[0].toString());
                ob[2] = num_Salidas(ob[0].toString());
                ob_prods.set(i, ob);
            }
        /*ORDENAMIENTO DE DATOS*/
        ob_prods = ordenamiento_Consumo(ob_prods);
        return ob_prods;
    }
    
    
    
    public void obtencion_Productos(){
        try {
            ps = con.prepareStatement("SELECT * FROM producto");
            rs = ps.executeQuery();
            while(rs.next()){
                Object[] ob = new Object[4];
                    ob[0] = rs.getString("id_producto");
                    ob[3] = rs.getString("nombre_producto");
                ob_prods.add(ob);  
            }      
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los codigos de los productos: "+ e.getMessage());
        }
    }

    
    
    public ArrayList ordenamiento_Consumo(ArrayList ob){
          Object[] aux = new Object[4];      
            for(int i=0; i< ob.size()-1; i++){
                for(int j =0; j<ob.size()-i-1; j++){
                    Object[] o_r = (Object[]) ob.get(j+1);
                    Object[] o_aux = (Object[]) ob.get(j);
                    int j_1 = Integer.parseInt(valueOf(o_r[1])) + Integer.parseInt(valueOf(o_r[2]));
                    int j_2 = Integer.parseInt(valueOf(o_aux[1])) + Integer.parseInt(valueOf(o_aux[2]));
                    if(j_1 < j_2){
                        aux = (Object[]) ob.get(j+1);
                        ob.set(j+1, ob.get(j));
                        ob.set(j, aux);
                    }
                }
            }
        return ob;
    }
   
    
    
    /**************************************************LISTADO DE TABLA PROPIEDADES************************************************/
    
    public DefaultTableModel listar_Tabla_Propiedades(){
        DefaultTableModel modelo_h = new DefaultTableModel();
        String[] columnas = {"Codigo","Producto","Entradas","Salidas","Stock"};
        modelo_h.setColumnIdentifiers(columnas);
        try {
                ps = con.prepareStatement("SELECT * FROM producto");
                rs = ps.executeQuery();
                while(rs.next()){
                    Object[] ob = new Object[5];
                    ob[0] = rs.getString("id_producto");
                    ob[1] = rs.getString("nombre_producto");
                    ob[4] = rs.getString("cantidad"); 
                    modelo_h.addRow(ob);
                }
                ps.close();
                rs.close();
                /*OBTENCION DE ENTRADAS Y SALIDAS*/
                for(int i=0; i<modelo_h.getRowCount(); i++){
                    modelo_h.setValueAt(num_Entradas(modelo_h.getValueAt(i, 0).toString()), i, 2);
                    modelo_h.setValueAt(num_Salidas(modelo_h.getValueAt(i, 0).toString()), i, 3);
                }     
        } catch (SQLException e) {
            System.out.println("Error al listar la tabla Propiedades: " + e.getMessage());
        }
        return modelo_h;
    }
    
    
    /*****************************************************METODOS DE PROPIEDADES DE SALIDA Y ENTRADA**********************************************************************/
     
    public DefaultTableModel sistema_Entrada(String producto){
            System.out.println("El code en entradaes: " +producto);
            DefaultTableModel modelo_entrada =  new DefaultTableModel();
            String[] columnas = {"Cantidad ingresada","Fecha de ingreso"};
            modelo_entrada.setColumnIdentifiers(columnas);
            try {
                ps = con.prepareStatement("SELECT * FROM sistema_entrada WHERE cod_producto=?");
                ps.setString(1, producto);
                rs = ps.executeQuery();
                    while(rs.next()){
                        Object[] ob = new Object[2];
                        ob[0] = rs.getString("cantidad_ingreso");
                        ob[1] = rs.getString("f_ingreso");
                        System.out.println("OBTUVE DE ENTRADA: " +ob[0] +" : "+ ob[1]);
                        modelo_entrada.addRow(ob);
                    }
                ps.close();
                rs.close();
            } catch (SQLException e) {
                    System.out.println("Error al listar propiedad de entradas: "+ e);
            }
            return modelo_entrada;
    }
     
    public DefaultTableModel sistema_Salida(String producto){    
            System.out.println("El code en salida es: " +producto);
            DefaultTableModel modelo_salida =  new DefaultTableModel();
            String[] columnas = {"Cantidad extraida","Fecha de salida"};
            modelo_salida.setColumnIdentifiers(columnas);
            try {
                ps = con.prepareStatement("SELECT * FROM sistema_salida WHERE cod_producto=?");
                ps.setString(1, producto);
                rs = ps.executeQuery();
                    while(rs.next()){
                        System.out.println("LLEGUE A ENCONTRAR SALIDA");
                        Object[] ob = new Object[2];
                        ob[0] = rs.getString("cantidad_salida");
                        ob[1] = rs.getString("f_salida");
                        System.out.println("OBTUVE DE SALIDA: " +ob[0] +" : "+ ob[1]);
                        modelo_salida.addRow(ob);
                    }
                ps.close();
                rs.close();
            } catch (SQLException e) {
                    System.out.println("Error al listar propiedad de salidas: "+ e);
            }
            return modelo_salida;
    } 
     

    /********************************************************************************METODOS DE CONTEO*********************************************************************/
    
     public int num_Entradas(String cod_prod){
        n_entrada = 0;
            try {
                ps = con.prepareStatement("SELECT * FROM sistema_entrada WHERE cod_producto=?");
                ps.setString(1, cod_prod);
                rs = ps.executeQuery();
                    while(rs.next()){
                        n_entrada++;
                        System.out.println("Econtre una entrada: " + rs.getString("cod_producto"));
                    } 
                ps.close();
                rs.close();
            } catch (SQLException e) {
                    System.out.println("Error al contar entradas: " +e);
            }           
        return n_entrada;
    }
    
     
     
     public int num_Salidas(String cod_prod){
       n_salida = 0;
            try {
                ps = con.prepareStatement("SELECT * FROM sistema_salida WHERE cod_producto=?");
                ps.setString(1, cod_prod);
                rs = ps.executeQuery();
                    while(rs.next()){
                        n_salida++;
                        System.out.println("Econtre una salida: " + rs.getString("cod_producto"));
                    }   
                ps.close();
                rs.close();
            } catch (SQLException e) {
                    System.out.println("Error al contar salidas: " +e);
            }    
        return n_salida;
    }
    
}
