/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sub_jpanel;

import java.awt.BorderLayout;
import jpanel.*;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Julio Ramirez
 */
public class Historial_Buscar extends javax.swing.JPanel {
     int width=890, height=630;
    /**
     * Creates new form Inicio
     */
    public Historial_Buscar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        fondo = new javax.swing.JPanel();
        jPanel_fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jlabel_buscar_producto = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jlabel_lista_Historial = new javax.swing.JLabel();
        jlabel_propiedadesHistorial = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(890, 660));
        setMinimumSize(new java.awt.Dimension(890, 660));
        setPreferredSize(new java.awt.Dimension(890, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_fondo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BUSQUEDA DE HISTORIAL");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Tipo", "Encargado", "Almacen", "Cantidad", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setMinWidth(60);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(6).setMinWidth(90);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(90);
        }

        jPanel3.setBackground(new java.awt.Color(30, 30, 30));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 68, 54), 2, true));

        jlabel_buscar_producto.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_buscar_producto.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_buscar_producto.setForeground(new java.awt.Color(153, 153, 153));
        jlabel_buscar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/buscar_inventario.png"))); // NOI18N
        jlabel_buscar_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_buscar_productoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_buscar_productoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabel_buscar_producto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel_buscar_producto)
                .addContainerGap())
        );

        txt_codigo.setBackground(new java.awt.Color(255, 255, 255));
        txt_codigo.setForeground(new java.awt.Color(51, 51, 51));
        txt_codigo.setText("Ingrese el codigo a buscar");
        txt_codigo.setBorder(null);
        txt_codigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_codigoMouseClicked(evt);
            }
        });
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));

        jlabel_lista_Historial.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_lista_Historial.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_lista_Historial.setForeground(new java.awt.Color(51, 51, 51));
        jlabel_lista_Historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list.png"))); // NOI18N
        jlabel_lista_Historial.setText("LISTA DE HISTORIAL");
        jlabel_lista_Historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_lista_HistorialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_lista_HistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_lista_HistorialMouseExited(evt);
            }
        });

        jlabel_propiedadesHistorial.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_propiedadesHistorial.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_propiedadesHistorial.setForeground(new java.awt.Color(51, 51, 51));
        jlabel_propiedadesHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_prod.png"))); // NOI18N
        jlabel_propiedadesHistorial.setText("PROPIEDADES");
        jlabel_propiedadesHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_propiedadesHistorialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_propiedadesHistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_propiedadesHistorialMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel_fondoLayout = new javax.swing.GroupLayout(jPanel_fondo);
        jPanel_fondo.setLayout(jPanel_fondoLayout);
        jPanel_fondoLayout.setHorizontalGroup(
            jPanel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jlabel_propiedadesHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270)
                .addComponent(jlabel_lista_Historial))
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_fondoLayout.setVerticalGroup(
            jPanel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_propiedadesHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_lista_Historial))
                .addGap(20, 20, 20)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fondo.add(jPanel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 670));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_buscar_productoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_buscar_productoMouseEntered
        jlabel_buscar_producto.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_buscar_productoMouseEntered

    private void jlabel_buscar_productoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_buscar_productoMouseExited
         jlabel_buscar_producto.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_buscar_productoMouseExited

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void jlabel_lista_HistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_lista_HistorialMouseClicked
        Historial_vista nueva= new Historial_vista();
        addConatiner(nueva, width, height, jPanel_fondo);
    }//GEN-LAST:event_jlabel_lista_HistorialMouseClicked

    private void jlabel_lista_HistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_lista_HistorialMouseEntered
        System.out.println("Entre");
        jlabel_lista_Historial.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_lista_HistorialMouseEntered

    private void jlabel_lista_HistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_lista_HistorialMouseExited
        jlabel_lista_Historial.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_lista_HistorialMouseExited

    private void jlabel_propiedadesHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_propiedadesHistorialMouseClicked
        Historial_vista nueva= new Historial_vista();
        addConatiner(nueva, width, height, jPanel_fondo);
    }//GEN-LAST:event_jlabel_propiedadesHistorialMouseClicked

    private void jlabel_propiedadesHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_propiedadesHistorialMouseEntered
        jlabel_propiedadesHistorial.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_propiedadesHistorialMouseEntered

    private void jlabel_propiedadesHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_propiedadesHistorialMouseExited
        jlabel_propiedadesHistorial.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_propiedadesHistorialMouseExited

    private void txt_codigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_codigoMouseClicked
        if(txt_codigo.getText().equals("Ingrese el codigo a buscar")){
            txt_codigo.setText("");
        }
        
        
    }//GEN-LAST:event_txt_codigoMouseClicked

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
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel_buscar_producto;
    private javax.swing.JLabel jlabel_lista_Historial;
    private javax.swing.JLabel jlabel_propiedadesHistorial;
    private javax.swing.JTextField txt_codigo;
    // End of variables declaration//GEN-END:variables
    public void addConatiner(JPanel p,int width, int height,JPanel c){
        p.setSize(width,height);
        p.setLocation(0,0);
        c.removeAll();
        c.add(p,BorderLayout.CENTER);
        c.revalidate();
        c.repaint();
    }
}
