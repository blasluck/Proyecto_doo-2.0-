/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanel;

import BOL.Trabajador;
import SqlMetodos.Trabajadores_sql;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sub_jpanel.Trabajadores_buscar;
import sub_jpanel.Trabajadores_ingresooo;
import sub_jpanel.Trabajadores_propiedad;

/**
 *
 * @author Julio Ramirez
 */
public class Lista_Trbj extends javax.swing.JPanel {
     int width=890, height=630;
     int row_select;
     String codigo;
     boolean seleccion= false;
     Date ingreso, nacimiento;
     Trabajadores_sql  metodos_trbj= new Trabajadores_sql();
     DefaultTableModel modelo = new DefaultTableModel();
     Trabajador t = new Trabajador();
    /**
     * Creates new form Inicio
     */
    public Lista_Trbj() {
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

        jTextField1 = new javax.swing.JTextField();
        fondo = new javax.swing.JPanel();
        list_jpnael = new javax.swing.JPanel();
        panelito = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA_TRABAJADORES = new javax.swing.JTable();
        jlabel_nuevo_trabajador = new javax.swing.JLabel();
        jlabel_buscar_trabajador = new javax.swing.JLabel();
        jlabel_editar_trabajador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        jTextField1.setText("jTextField1");

        setMaximumSize(new java.awt.Dimension(890, 660));
        setMinimumSize(new java.awt.Dimension(890, 660));
        setPreferredSize(new java.awt.Dimension(890, 660));

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list_jpnael.setBackground(new java.awt.Color(43, 43, 43));
        list_jpnael.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelito.setBackground(new java.awt.Color(255, 255, 255));

        TABLA_TRABAJADORES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombres", "Apellidos", "Cargo", "Fecha de nacimiento", "Fecha de Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLA_TRABAJADORES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLA_TRABAJADORESMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLA_TRABAJADORES);

        jlabel_nuevo_trabajador.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_nuevo_trabajador.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_nuevo_trabajador.setForeground(new java.awt.Color(51, 51, 51));
        jlabel_nuevo_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trbjadores.png"))); // NOI18N
        jlabel_nuevo_trabajador.setText("NUEVO TRABAJADOR");
        jlabel_nuevo_trabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_nuevo_trabajadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_nuevo_trabajadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_nuevo_trabajadorMouseExited(evt);
            }
        });

        jlabel_buscar_trabajador.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_buscar_trabajador.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_buscar_trabajador.setForeground(new java.awt.Color(51, 51, 51));
        jlabel_buscar_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/buscar_trbj.png"))); // NOI18N
        jlabel_buscar_trabajador.setText("BUSCAR TRABAJADOR");
        jlabel_buscar_trabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_buscar_trabajadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_buscar_trabajadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_buscar_trabajadorMouseExited(evt);
            }
        });

        jlabel_editar_trabajador.setBackground(new java.awt.Color(153, 153, 153));
        jlabel_editar_trabajador.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jlabel_editar_trabajador.setForeground(new java.awt.Color(51, 51, 51));
        jlabel_editar_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_prod.png"))); // NOI18N
        jlabel_editar_trabajador.setText("EDITAR TRABAJADOR");
        jlabel_editar_trabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_editar_trabajadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlabel_editar_trabajadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlabel_editar_trabajadorMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRABAJADORES");

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelitoLayout = new javax.swing.GroupLayout(panelito);
        panelito.setLayout(panelitoLayout);
        panelitoLayout.setHorizontalGroup(
            panelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelitoLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jlabel_nuevo_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel_buscar_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelitoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelitoLayout.createSequentialGroup()
                        .addComponent(jlabel_editar_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(360, 360, 360))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelitoLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelitoLayout.createSequentialGroup()
                        .addGroup(panelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
            .addGroup(panelitoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelitoLayout.setVerticalGroup(
            panelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelitoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(panelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_nuevo_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_buscar_trabajador))
                .addGap(18, 18, 18)
                .addComponent(jlabel_editar_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        list_jpnael.add(panelito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 660));

        fondo.add(list_jpnael, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 660));

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

    private void jlabel_editar_trabajadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_editar_trabajadorMouseExited
        jlabel_editar_trabajador.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_editar_trabajadorMouseExited

    private void jlabel_editar_trabajadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_editar_trabajadorMouseEntered
        jlabel_editar_trabajador.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_editar_trabajadorMouseEntered

    private void jlabel_editar_trabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_editar_trabajadorMouseClicked
        System.out.println("row select::::: "+ row_select);
        if(seleccion == true){
            Trabajadores_propiedad traba = new Trabajadores_propiedad();
            addConatiner(traba, width, height, panelito);
            traba.rellenado(t, ingreso, nacimiento);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un Trabajador de la tabla", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jlabel_editar_trabajadorMouseClicked

    private void jlabel_buscar_trabajadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_buscar_trabajadorMouseExited
        jlabel_buscar_trabajador.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_buscar_trabajadorMouseExited

    private void jlabel_buscar_trabajadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_buscar_trabajadorMouseEntered
        jlabel_buscar_trabajador.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_buscar_trabajadorMouseEntered

    private void jlabel_buscar_trabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_buscar_trabajadorMouseClicked
        Trabajadores_buscar traba = new Trabajadores_buscar();
        addConatiner(traba, width, height, panelito);
    }//GEN-LAST:event_jlabel_buscar_trabajadorMouseClicked

    private void jlabel_nuevo_trabajadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_nuevo_trabajadorMouseExited
        jlabel_nuevo_trabajador.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_nuevo_trabajadorMouseExited

    private void jlabel_nuevo_trabajadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_nuevo_trabajadorMouseEntered
        jlabel_nuevo_trabajador.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_nuevo_trabajadorMouseEntered

    private void jlabel_nuevo_trabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_nuevo_trabajadorMouseClicked
        Trabajadores_ingresooo traba = new Trabajadores_ingresooo();
        addConatiner(traba, width, height, panelito);
    }//GEN-LAST:event_jlabel_nuevo_trabajadorMouseClicked

    private void TABLA_TRABAJADORESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_TRABAJADORESMouseClicked
        seleccion =true;
        row_select = TABLA_TRABAJADORES.getSelectedRow();
        
        t.setId(TABLA_TRABAJADORES.getValueAt(row_select, 0).toString());
        t.setNombres(TABLA_TRABAJADORES.getValueAt(row_select, 1).toString());
        t.setApellidos(TABLA_TRABAJADORES.getValueAt(row_select, 2).toString());
        t.setCargo(TABLA_TRABAJADORES.getValueAt(row_select, 3).toString());
        String f_n = TABLA_TRABAJADORES.getValueAt(row_select , 4).toString(); //Seleccion d ela fecha en la tabla
        String f_i = TABLA_TRABAJADORES.getValueAt(row_select , 5).toString(); //Seleccion d ela fecha en la tabla
            try {
                nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(f_n);
                ingreso =new SimpleDateFormat("yyyy-MM-dd").parse(f_i) ;               
            } catch (ParseException ex) {
                System.out.println("Error al parsear:" + ex);
            }     
    }//GEN-LAST:event_TABLA_TRABAJADORESMouseClicked

    
     public void addConatiner(JPanel p,int width, int height,JPanel c){
        p.setSize(width,height);
        p.setLocation(0,0);
        c.removeAll();
        c.add(p,BorderLayout.CENTER);
        c.revalidate();
        c.repaint();
    }
    
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
    private javax.swing.JTable TABLA_TRABAJADORES;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlabel_buscar_trabajador;
    private javax.swing.JLabel jlabel_editar_trabajador;
    private javax.swing.JLabel jlabel_nuevo_trabajador;
    private javax.swing.JPanel list_jpnael;
    private javax.swing.JPanel panelito;
    // End of variables declaration//GEN-END:variables
    
    
    private void listar(){
        modelo = metodos_trbj.listar_Trbj();
        TABLA_TRABAJADORES.setModel(modelo);
    }
}
