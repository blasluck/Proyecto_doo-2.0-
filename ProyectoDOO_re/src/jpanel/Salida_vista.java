/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanel;

import SqlMetodos.Entrada_sql;
import SqlMetodos.Salida_sql;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sub_jpanel.Salida_Buscar;
import sub_jpanel.Salida_Editar;
import sub_jpanel.Salida_Nueva;
import sub_jpanel.Salida_Editar;

/**
 *
 * @author Julio Ramirez
 */
public class Salida_vista extends javax.swing.JPanel {
    int width=890, height=630;
    boolean seleccion= false;
    Salida_sql metodos_entradas= new Salida_sql();
    String codigo;
    Date f_ingreso;
    
    /**
     * Creates new form Inicio
     */
    public Salida_vista() {
        initComponents();
        listar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jpanel_salida = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA_SALIDA = new javax.swing.JTable();
        jlabel_buscar_salida = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jlabel_nueva_SALIDA = new javax.swing.JLabel();
        jlabel_editar_salida = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(890, 660));
        setMinimumSize(new java.awt.Dimension(890, 660));
        setPreferredSize(new java.awt.Dimension(890, 660));

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanel_salida.setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SALIDA DE PRODUCTOS");

        TABLA_SALIDA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Tipo", "Encargado", "Almacen", "Cantidad", "Fecha"
            }
        ));
        TABLA_SALIDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLA_SALIDAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLA_SALIDA);
        if (TABLA_SALIDA.getColumnModel().getColumnCount() > 0) {
            TABLA_SALIDA.getColumnModel().getColumn(5).setMinWidth(60);
            TABLA_SALIDA.getColumnModel().getColumn(5).setPreferredWidth(60);
            TABLA_SALIDA.getColumnModel().getColumn(5).setMaxWidth(60);
            TABLA_SALIDA.getColumnModel().getColumn(6).setMinWidth(90);
            TABLA_SALIDA.getColumnModel().getColumn(6).setPreferredWidth(90);
            TABLA_SALIDA.getColumnModel().getColumn(6).setMaxWidth(90);
        }

        jlabel_buscar_salida.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_buscar_salida.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_buscar_salida.setForeground(new java.awt.Color(153, 153, 153));
        jlabel_buscar_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/buscar_inventario.png"))); // NOI18N
        jlabel_buscar_salida.setText("BUSCAR SALIDAS (FECHA)");
        jlabel_buscar_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_buscar_salidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_buscar_salidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_buscar_salidaMouseExited(evt);
            }
        });

        jlabel_nueva_SALIDA.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_nueva_SALIDA.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_nueva_SALIDA.setForeground(new java.awt.Color(153, 153, 153));
        jlabel_nueva_SALIDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nueva_entrada.png"))); // NOI18N
        jlabel_nueva_SALIDA.setText("NUEVA SALIDA");
        jlabel_nueva_SALIDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_nueva_SALIDAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_nueva_SALIDAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_nueva_SALIDAMouseExited(evt);
            }
        });

        jlabel_editar_salida.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_editar_salida.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_editar_salida.setForeground(new java.awt.Color(153, 153, 153));
        jlabel_editar_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Editar_producto.png"))); // NOI18N
        jlabel_editar_salida.setText("EDITAR SALIDA");
        jlabel_editar_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_editar_salidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_editar_salidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_editar_salidaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpanel_salidaLayout = new javax.swing.GroupLayout(jpanel_salida);
        jpanel_salida.setLayout(jpanel_salidaLayout);
        jpanel_salidaLayout.setHorizontalGroup(
            jpanel_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpanel_salidaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpanel_salidaLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jlabel_nueva_SALIDA)
                .addGap(360, 360, 360)
                .addComponent(jlabel_buscar_salida))
            .addGroup(jpanel_salidaLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jlabel_editar_salida))
            .addGroup(jpanel_salidaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpanel_salidaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpanel_salidaLayout.setVerticalGroup(
            jpanel_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_salidaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jpanel_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_salidaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlabel_nueva_SALIDA, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlabel_buscar_salida))
                .addGap(21, 21, 21)
                .addComponent(jlabel_editar_salida)
                .addGap(28, 28, 28)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fondo.add(jpanel_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_editar_salidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_editar_salidaMouseEntered
       jlabel_editar_salida.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_editar_salidaMouseEntered

    private void jlabel_editar_salidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_editar_salidaMouseExited
        jlabel_editar_salida.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_editar_salidaMouseExited

    private void jlabel_buscar_salidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_buscar_salidaMouseEntered
        jlabel_buscar_salida.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_buscar_salidaMouseEntered

    private void jlabel_buscar_salidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_buscar_salidaMouseExited
         jlabel_buscar_salida.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_buscar_salidaMouseExited

    private void jlabel_nueva_SALIDAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_nueva_SALIDAMouseExited
        jlabel_nueva_SALIDA.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_nueva_SALIDAMouseExited

    private void jlabel_nueva_SALIDAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_nueva_SALIDAMouseEntered
        jlabel_nueva_SALIDA.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_nueva_SALIDAMouseEntered

    private void jlabel_nueva_SALIDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_nueva_SALIDAMouseClicked
        Salida_Nueva salida = new Salida_Nueva();
        addConatiner(salida, width, height, jpanel_salida);
    }//GEN-LAST:event_jlabel_nueva_SALIDAMouseClicked

    private void jlabel_editar_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_editar_salidaMouseClicked
        if(seleccion == true){
            Salida_Editar salida = new Salida_Editar();
            addConatiner(salida, width, height, jpanel_salida);
            /*Metodo de captura de datos*/
            salida.captura_Datos(codigo, f_ingreso);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_jlabel_editar_salidaMouseClicked

    private void jlabel_buscar_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_buscar_salidaMouseClicked
        Salida_Buscar salida = new Salida_Buscar();
        addConatiner(salida, width, height, jpanel_salida);
    }//GEN-LAST:event_jlabel_buscar_salidaMouseClicked

    private void TABLA_SALIDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_SALIDAMouseClicked
        seleccion = true;
        
        int row_select = TABLA_SALIDA.getSelectedRow();
        codigo = TABLA_SALIDA.getValueAt(row_select, 0).toString();
        String f_i = TABLA_SALIDA.getValueAt(row_select , 6).toString(); //Seleccion d ela fecha en la tabla
        String conversion_f = f_i.substring(0, 10);
        System.out.println("Fecha obtenida: "+ conversion_f);
        try {
                f_ingreso =new SimpleDateFormat("yyyy-MM-dd").parse(conversion_f) ;               
        } catch (ParseException ex) {
                System.out.println("Erro al parsear:" + ex);
        }  
        System.out.println("Selecione la fila: " + row_select+"Codigo obtenido: " +codigo);
    }//GEN-LAST:event_TABLA_SALIDAMouseClicked

    public void Look() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {

        } catch (InstantiationException ex) {

        } catch (IllegalAccessException ex) {

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLA_SALIDA;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlabel_buscar_salida;
    private javax.swing.JLabel jlabel_editar_salida;
    private javax.swing.JLabel jlabel_nueva_SALIDA;
    private javax.swing.JPanel jpanel_salida;
    // End of variables declaration//GEN-END:variables
     public void addConatiner(JPanel p,int width, int height,JPanel c){
        p.setSize(width,height);
        p.setLocation(0,0);
        c.removeAll();
        c.add(p,BorderLayout.CENTER);
        c.revalidate();
        c.repaint();
    }
     
    public void listar(){
        TABLA_SALIDA.setModel(metodos_entradas.listar_salida());    
    } 
}
