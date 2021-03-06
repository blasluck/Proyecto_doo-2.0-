/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanel;

import SqlMetodos.Historial_sql;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import sub_jpanel.Historial_Propiedades;


/**
 *
 * @author Julio Ramirez
 */
public class Historial_vista extends javax.swing.JPanel {
     int width=890, height=630;
     Historial_sql metodos_historial = new Historial_sql();
    /**
     * Creates new form Inicio
     */
    public Historial_vista() {
        initComponents();
        graficar();
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
        jPanel_fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlabel_propiedadesHistorial = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jpanel_chartArt = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(890, 660));
        setMinimumSize(new java.awt.Dimension(890, 660));
        setPreferredSize(new java.awt.Dimension(890, 660));

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_fondo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HISTORIAL");

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

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));

        jSeparator3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jpanel_chartArtLayout = new javax.swing.GroupLayout(jpanel_chartArt);
        jpanel_chartArt.setLayout(jpanel_chartArtLayout);
        jpanel_chartArtLayout.setHorizontalGroup(
            jpanel_chartArtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanel_chartArtLayout.setVerticalGroup(
            jpanel_chartArtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel_fondoLayout = new javax.swing.GroupLayout(jPanel_fondo);
        jPanel_fondo.setLayout(jPanel_fondoLayout);
        jPanel_fondoLayout.setHorizontalGroup(
            jPanel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addComponent(jpanel_chartArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(jlabel_propiedadesHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_fondoLayout.setVerticalGroup(
            jPanel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_fondoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_propiedadesHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanel_chartArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );

        fondo.add(jPanel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 660));

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

    private void jlabel_propiedadesHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_propiedadesHistorialMouseExited
        jlabel_propiedadesHistorial.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jlabel_propiedadesHistorialMouseExited

    private void jlabel_propiedadesHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_propiedadesHistorialMouseEntered
        jlabel_propiedadesHistorial.setForeground(new Color(45,130,215));
    }//GEN-LAST:event_jlabel_propiedadesHistorialMouseEntered

    private void jlabel_propiedadesHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_propiedadesHistorialMouseClicked
        Historial_Propiedades nuevo = new Historial_Propiedades();
        addConatiner(nuevo, width, height, jPanel_fondo);
        JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla para ver sus propiedades");
    }//GEN-LAST:event_jlabel_propiedadesHistorialMouseClicked

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
    private javax.swing.JPanel jPanel_fondo;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jlabel_propiedadesHistorial;
    private javax.swing.JPanel jpanel_chartArt;
    // End of variables declaration//GEN-END:variables
    
    
    
    
    /*METODOS DE GRAFICA*/
    public void graficar(){
        ArrayList ob_productos = metodos_historial.consumo_Mayor();
        
        DefaultCategoryDataset datos_barra = new DefaultCategoryDataset();
        System.out.println("Tamna: " +ob_productos.size());
        if(ob_productos.size()<3){
            System.out.println("Hay pocos productos");
        }else{
            for(int i=ob_productos.size()-1; i>ob_productos.size()-4; i--){
                Object[] ob = (Object[]) ob_productos.get(i);
                datos_barra.addValue(Integer.parseInt(ob[1].toString()), "Entradas", ob[3].toString());
                datos_barra.addValue(Integer.parseInt(ob[2].toString()), "Salidas", ob[3].toString());
            }
        }
        
        JFreeChart grafica = ChartFactory.createBarChart3D("Productos Consumidos", "", "Cantidad", datos_barra, PlotOrientation.VERTICAL, true, false, false);
        
        ChartPanel panel = new ChartPanel(grafica);
        jpanel_chartArt.setLayout(new java.awt.BorderLayout());
        jpanel_chartArt.add(panel);
        jpanel_chartArt.validate();
    
    }
    
    
    
    
    
    
    
    
    
    
    public void addConatiner(JPanel p,int width, int height,JPanel c){
        p.setSize(width,height);
        p.setLocation(0,0);
        c.removeAll();
        c.add(p,BorderLayout.CENTER);
        c.revalidate();
        c.repaint();
    }
}
