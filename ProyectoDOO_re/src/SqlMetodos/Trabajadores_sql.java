/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import BOL.Trabajador;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.String.valueOf;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Trabajadores_sql {
    
    Conexiones conexion = new Conexiones();
    PreparedStatement ps=null;
    Connection con = conexion.getConnection();
    ResultSet rs= null;
    static int id_persona;
    static String cod_p;
    static String p_temp;
    FileInputStream fi=null;
    /******************************METODOS LISTAR*******************************************/
    public DefaultTableModel listar_Trbj(){
        DefaultTableModel modelo_trbj = new DefaultTableModel();
        String[] columnas ={"Codigo","Nombres","Apellidos","Cargo","Fecha de nacimiento","Fecha de ingreso" };
        modelo_trbj.setColumnIdentifiers(columnas);
        try {
             ps =con.prepareStatement("SELECT * FROM persona, trabajadores WHERE trabajadores.cod_persona = persona.id_persona");
             rs = ps.executeQuery();  
                while(rs.next()){                
                    Object[] ob = new Object[6];
                    ob[0]= rs.getString("trabajadores.id_trabajador");
                    ob[1]= rs.getString("persona.nombres");
                    ob[2]= rs.getString("persona.apellidos");
                    ob[3]= rs.getString("persona.cargo");
                    ob[4]= rs.getString("trabajadores.f_nacimiento_trabajador");
                    ob[5]= rs.getString("trabajadores.f_ingreso_trabajador");
                    modelo_trbj.addRow(ob);
                }      
              rs.close();
              ps.close();
              list_persona();
              System.out.println("Liste todo correcto Trabajadores");
        } catch (SQLException e) {
            System.out.println("Error al listar trabajadores: "+ e.getMessage());           
        }        
        return modelo_trbj;
    }
    

    /******************************METODOS TRABAJADOR*******************************************/
    
    public void add_Trbj(Trabajador t, String ruta_f){    
        try {
            File file = new File(ruta_f);
            fi= new FileInputStream(file);
            /*INGRESO DE NUEVA PERSONA*/
            ps = con.prepareStatement("INSERT INTO persona VALUES(?,?,?,?)");
            ps.setString(1, cod_p);
            ps.setString(2, t.getNombres());
            ps.setString(3, t.getApellidos());
            ps.setString(4, t.getCargo());
            ps.executeUpdate();
            ps.close();
            
            /*INGRESO DE NUEVO TRABAJADOR*/
            ps = con.prepareStatement("INSERT INTO trabajadores VALUES(?,?,?,?,?)");
            System.out.println("ID LLENADO: "+t.getId());
            ps.setString(1, t.getId());
            ps.setString(2, cod_p);
            ps.setString(3, t.getNacimiento());
            ps.setString(4, t.getFecha_ingreso());
            System.out.println("FI INGRESADO>" + fi);
            ps.setBinaryStream(5, fi);
            ps.executeUpdate();
            ps.close();

            System.out.println("Trabajador agregado");
        } catch (Exception e) {
            System.out.println("Error al agregar trabajador: " +e.getMessage());
        }
    }
    
    public void update_Trbj(Trabajador t, String codigo_trbj, String ruta_f){
        try {
            File file = new File(ruta_f);
            fi= new FileInputStream(file);
            ps = con.prepareStatement("UPDATE  persona, trabajadores SET persona.nombres=?, persona.apellidos=?, persona.cargo=? , trabajadores.id_trabajador=?, trabajadores.f_nacimiento_trabajador=?,"
                    + "trabajadores.f_ingreso_trabajador=?, trabajadores.foto_trabajador=? WHERE "
                    + "persona.id_persona = trabajadores.cod_persona AND trabajadores.id_trabajador=?");            
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setString(3, t.getCargo());
            ps.setString(4, t.getId());
            ps.setString(5, t.getNacimiento());
            ps.setString(6, t.getFecha_ingreso());
            ps.setBinaryStream(7, fi);
            ps.setString(8, codigo_trbj);
            ps.executeUpdate();
            ps.close();
            System.out.println("Trabajador actualisado");
        } catch (Exception e) {
            System.out.println("Error al actualisar trabajador: " +e.getMessage());
        }
    }   
    
    public void delete_Trbj(String codigo_trbj){
        try {
            ps = con.prepareStatement("SELECT * FROM trabajadores WHERE id_trabajador= ?") ;
            ps.setString(1, codigo_trbj);
            rs = ps.executeQuery();
            if(rs.next()){
                p_temp = rs.getString("cod_persona");
                System.out.println("Obtuve el codigo temporal del trabajador: "+ p_temp);
            }    
            /*Eliminacion del trabajador*/
            ps = con.prepareStatement("DELETE FROM trabajadores WHERE id_trabajador=?");
            ps.setString(1, codigo_trbj);
            ps.executeUpdate();
            ps.close();            
            /*Eliminacion de la persona*/
            ps = con.prepareStatement("DELETE FROM persona WHERE id_persona=?");
            ps.setString(1, p_temp);
            ps.executeUpdate();
            ps.close();      
        } catch (Exception e) {
            System.out.println("Error al eliminar Trabajador: "+ e.getMessage());
        }
    }
    
    
    /******************************METODO DE  IMAGEN*****************************************/
    public ImageIcon search_img(String codigo){        
        ImageIcon imagen = null;
        try {
            ps = con.prepareStatement("SELECT * FROM trabajadores WHERE id_trabajador =?");
            ps.setString(1, codigo);
            rs = ps.executeQuery(); 
            if(rs.next()){
                Blob blob = rs.getBlob("foto_trabajador");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage leer_img = null;
                try {
                    leer_img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception e) {
                    System.out.println("Error al traer la imagen: "+ e.getMessage());
                }
                System.out.println("LEET IMG :l"+ leer_img);
                imagen = new ImageIcon(leer_img);//Le pasamos el valor transformado 
            }
        } catch (SQLException e) {
            System.out.println("Error al traspasar Imagen: "+ e.getMessage());
        }
        return imagen;
    }
    
    public  ResultSet search_Trbj(String date){
        try {
            System.out.println("DATE PASADO: "+ date);
            ps = con.prepareStatement("SELECT * FROM persona, trabajadores WHERE persona.id_persona = trabajadores.cod_persona AND trabajadores.f_ingreso_trabajador=?");
            ps.setString(1, date);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al encontrar los elementos del trabajador: "+ e.getMessage());
        }       
        return rs;
    }
    
    public ResultSet listar(){
        try {
            ps = con.prepareStatement("SELECT * FROM persona, trabajadores WHERE persona.id_persona = trabajadores.cod_persona");
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al encontrar los elementos del trabajador: "+ e.getMessage());
        }       
        return rs;
    }
    
    public void llenar_tabla(JTable tabla){
        ResultSet rs = listar();
        /*
        **Modificacmos el diseño de la tabla para que adminita jlabels
        */
        tabla.setDefaultRenderer(Object.class,new LLenar_Tabla());
        DefaultTableModel modelo_trbj = new DefaultTableModel();
        String[] Columnas ={"Id","Nombres","Apellidos","Cargo","Fecha de inscripcion","Foto"};
        modelo_trbj.setColumnIdentifiers(Columnas);//Agrego de columnas
        
        try {
            while(rs.next()){
                Object[] fila = new Object[6];
                fila[0] = rs.getObject("trabajadores.id_trabajador");
                fila[1] = rs.getObject("persona.nombres");
                fila[2] = rs.getObject("persona.apellidos");
                fila[3] = rs.getObject("persona.cargo");
                fila[4] = rs.getObject("trabajadores.f_ingreso_trabajador");
                
                Blob blob = rs.getBlob("trabajadores.foto_trabajador");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage leer_imagen = null;
                    try {
                        leer_imagen = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (Exception e) {
                        System.out.println("Error al parsear img: "+ e.getMessage());
                    }
                /*Traspaso de iamgen al jlabel de la tabla*/
                ImageIcon icono = new ImageIcon(leer_imagen);
                fila[5] = new JLabel(icono);
                
                modelo_trbj.addRow(fila);
            }
            
            tabla.setModel(modelo_trbj);
            tabla.setRowHeight(160);
            
        } catch (SQLException e) {
            System.out.println("Error al llenar tabla trbj: "+ e.getMessage());
        }
    }
    
    
    
    public void llenar_Busqueda(JTable tabla){
        System.out.println("LLEGUE A ALA BSUQEUDA");
        /*
        **Modificacmos el diseño de la tabla para que adminita jlabels
        */
        tabla.setDefaultRenderer(Object.class,new LLenar_Tabla());
        DefaultTableModel modelo_trbj = new DefaultTableModel();
        String[] Columnas ={"Id","Nombres","Apellidos","Cargo","Fecha de inscripcion","Foto"};
        modelo_trbj.setColumnIdentifiers(Columnas);//Agrego de columnas
        
        try {
            while(rs.next()){
                Object[] fila = new Object[6];
                fila[0] = rs.getObject("trabajadores.id_trabajador");
                fila[1] = rs.getObject("persona.nombres");
                fila[2] = rs.getObject("persona.apellidos");
                fila[3] = rs.getObject("persona.cargo");
                fila[4] = rs.getObject("trabajadores.f_ingreso_trabajador");
                
                Blob blob = rs.getBlob("trabajadores.foto_trabajador");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage leer_imagen = null;
                    try {
                        leer_imagen = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (Exception e) {
                        System.out.println("Error al parsear img: "+ e.getMessage());
                    }
                /*Traspaso de iamgen al jlabel de la tabla*/
                ImageIcon icono = new ImageIcon(leer_imagen);
                fila[5] = new JLabel(icono);
                
                modelo_trbj.addRow(fila);
            }
            
            tabla.setModel(modelo_trbj);
            tabla.setRowHeight(160);
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar tabla trbj: "+ e.getMessage());
        }
    }
    
    
    
    
    
    /*Metodos sql persona*/
     public void count_Table(){
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM persona");
            rs = ps.executeQuery();
            if(rs.next()){
                id_persona = rs.getInt("count(*)");
            }
            System.out.println("Obtuve el numero de tabla: "+ id_persona);
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el numero de usuarios:"+e);
        }
    }
    
    
    public String id_pers(String ultima_pers){
        String defin="", id_pe="";
        int long_p = ultima_pers.length();
        /*Almacenamiento de la ultima persona*/
            defin+= ultima_pers.charAt(long_p-2);
            defin+= ultima_pers.charAt(long_p-1); 
            System.out.println("DEFIN: "+defin);
        int new_pers = Integer.parseInt(defin);
        
        if(new_pers<9){
               id_pe = "pers0"+(new_pers+1);
           }else{
               id_pe = "pers"+(new_pers+1);
        }
        System.out.println("ELEMENTO TRASNFORMADO: " +id_pe );
        return id_pe;
    }
    
    public void list_persona(){
        try {
            count_Table();
            ps = con.prepareStatement("SELECT * FROM persona");
            rs = ps.executeQuery();
            int i=1;
            while(rs.next()){
                if(i==id_persona){
                        cod_p = id_pers(rs.getString("id_persona"));//Metemso el ultimo elemento
                        System.out.println("ELEMENTO CAPTURADO EN AL LISTA: "+cod_p);
                }
                i++;
            }   
        } catch (SQLException e) {
            System.out.println("ERROR AL LISTAR PERSONA: "+ e.getMessage());
        }   
    }
    
    
    
    
 
}
