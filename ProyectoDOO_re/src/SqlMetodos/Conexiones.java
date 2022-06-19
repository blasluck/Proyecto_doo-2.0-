/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Favio Jeb
 */
public class Conexiones {

    public static String USER = "root";
    public static String PASSWORD = "12345Dy890+";
    //El host usa el local nms;
    public static String URL = "jdbc:mysql://localhost:3306/bd_inventario"+"?useTimezone=true&serverTimezone=UTC";
    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public Conexiones() {
    }

    public Conexiones(String user, String pass) {
        this.USER=user;
        this.PASSWORD=pass;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        Conexiones.USER = USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        Conexiones.PASSWORD = PASSWORD;
    }

    /**
     * Conecta la Base de datos
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("CONECTADO");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+ e.getMessage());
        }

        return con;
    }
    
    
}
