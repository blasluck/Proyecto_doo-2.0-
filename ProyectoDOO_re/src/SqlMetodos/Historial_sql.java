/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Historial_sql {
    Conexiones conexion = new Conexiones();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    
    
    public DefaultTableModel listar_historial(){
        DefaultTableModel modelo_h = new DefaultTableModel();
        
        return modelo_h;
    }
    
    
}
