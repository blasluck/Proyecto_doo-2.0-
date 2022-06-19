/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import BOL.Usuarios;
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
public class Usuarios_sql {
    
    Conexiones conexion = new Conexiones();
    Connection con = conexion.getConnection();
    PreparedStatement ps = null;
    ResultSet rs =null;
    int id_persona;
    String cod_p;
    String p_temp;
    
    public boolean login(String user, String password){
        boolean conexion_b = false;     
        try {
            ps = con.prepareStatement("SELECT * FROM usuario WHERE usuario=?");
            ps.setString(1, user);
            rs = ps.executeQuery();
            if(rs.next()){
                /*Encuentro de la lista de Usuarios*/
                System.out.println("LLegue a encontrar el Usuario");
                if(password.equals(rs.getString("contrasena"))){
                    conexion_b = true;
                }else{
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                } 
            }else{
                JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error busqueda!",JOptionPane.ERROR_MESSAGE);
            }
            //No se sierra la conexion por el llamado de las demas listas
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al encontrar la tabla: "+ e.getMessage());
        }
        return conexion_b;
    }
    
    public boolean see_User(String admin){//Ingreso de contraseña administrativa
        boolean next = false;
        try {
           ps = con.prepareStatement("SELECT persona.cargo FROM persona, usuario WHERE usuario.contrasena=? AND persona.id_persona = usuario.cod_persona");
           ps.setString(1, admin);
           
           rs = ps.executeQuery();
           if(rs.next()){
               if(rs.getString("persona.cargo").equals("Administrador")){
                   next = true;
               }else{
                   JOptionPane.showMessageDialog(null, "Solo puede acceder un administrador al registro", "Error!",JOptionPane.ERROR_MESSAGE);  
               }
           }else{
             JOptionPane.showMessageDialog(null, "La contraseña no esta registrada", "Error busqueda!",JOptionPane.ERROR_MESSAGE);  
           }
        } catch (SQLException e) {
            System.out.println("Error al traer los usuarios: "+ e.getMessage());
        }
        return next;
    }
    
    
    
    public DefaultTableModel listar(){
        DefaultTableModel modelo_usuarios = new DefaultTableModel();
        String[] columnas = {"Codigo","Nombres","Apellidos","Cargo","Usuario","Contraseña"};
        modelo_usuarios.setColumnIdentifiers(columnas);
            try {
                ps =con.prepareStatement(" SELECT * FROM persona, usuario WHERE persona.id_persona=usuario.cod_persona");
                rs = ps.executeQuery();  
                while(rs.next()){                
                    Object[] ob = new Object[6];
                    ob[0]= rs.getString("usuario.id_usuario");
                    ob[1]= rs.getString("persona.nombres");
                    ob[2]= rs.getString("persona.apellidos");
                    ob[3]= rs.getString("persona.cargo");
                    ob[4]= rs.getString("usuario.usuario");
                    ob[5]= rs.getString("usuario.contrasena");
                    modelo_usuarios.addRow(ob);
                }      
                rs.close();
                ps.close();
                list_persona();
                System.out.println("Liste todo correcto");
            } catch (SQLException e) {
                    System.out.println("Error al listar usuarios: "+ e.getMessage());
            }
           
        return modelo_usuarios;
    }
    
    public void add_User(Usuarios u){
        try {
            /*Agrego de persona*/
            ps = con.prepareStatement("INSERT INTO persona VALUES(?,?,?,?)");
            ps.setString(1, cod_p);
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getApellidos());
            ps.setString(4, u.getCargo());
            ps.executeUpdate();
            ps.close();//cierre del primer agrego
            
            /*Agrego de persona*/
            ps = con.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?)");
            ps.setString(1, u.getId_usuario());
            ps.setString(2, cod_p);
            ps.setString(3, u.getUsario());
            ps.setString(4, u.getContraseña());
            ps.executeUpdate();
            ps.close();  
            
            
        } catch (Exception e) {
            System.out.println("Error al agregar Usuario" + e.getMessage());
        }
    }
    
    public void update_User(Usuarios u, String codigo){    
        try {
            ps = con.prepareStatement("UPDATE persona, usuario SET persona.nombres=?, persona.apellidos=?, persona.cargo=?, usuario.id_usuario=?, usuario.usuario=?" +
                                        ", usuario.contrasena=? WHERE persona.id_persona=usuario.cod_persona AND id_usuario=?");
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getCargo());
            ps.setString(4, u.getId_usuario());
            ps.setString(5, u.getUsario());
            ps.setString(6, u.getContraseña());
            ps.setString(7, codigo);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar Usuario: " +e.getMessage());
        }        
    }
    
    public void delete_User(String codigo){
        try {            
            ps = con.prepareStatement("SELECT * FROM usuario WHERE id_usuario= ?") ;
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if(rs.next()){
                p_temp = rs.getString("cod_persona");
                System.out.println("Obtuve el codigo temporal: "+ p_temp);
            }    
            /*Eliminacion del usuario*/
            ps = con.prepareStatement("DELETE FROM usuario WHERE id_usuario=?");
            ps.setString(1, codigo);
            ps.executeUpdate();
            ps.close();            
            /*Eliminacion de la contraseña*/
            ps = con.prepareStatement("DELETE FROM persona WHERE id_persona=?");
            ps.setString(1, p_temp);
            ps.executeUpdate();
            ps.close();      
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: "+ e);
        }   
    }
    
    
    public void count_Table(){
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM persona");
            rs = ps.executeQuery();
            if(rs.next()){
                id_persona = rs.getInt("count(*)");
            }else{
                id_persona = 0;
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
        
        if(new_pers<10){
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
                        System.out.println("ELEMENTO CAPTURADO EN AL LISTA: "+ rs.getString("id_persona"));
                }
                i++;
            }   
            if(id_persona < 1){
                System.out.println("LLegue a saber que no hay ningun producto");
                cod_p  = "pers_01";
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR AL LISTAR PERSONA: "+ e.getMessage());
        }   
    }
    
    
    
}
