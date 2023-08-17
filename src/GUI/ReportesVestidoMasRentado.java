/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Codigo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chochias
 */
public class ReportesVestidoMasRentado extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection con = cc.conexion();
    
    public ReportesVestidoMasRentado() {
        initComponents();
        fullscreen();
        llenarTabla();
    }
    
    public void fullscreen(){
        super.dispose();
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setUndecorated(!super.isUndecorated());
        super.setVisible(true);
    }

    private int privileges;

    public int getPrivileges() {
        return privileges;
    }

    public void setPrivileges(int privileges) {
        this.privileges = privileges;
    }
    
    public void llenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet res = null;
        try {
            String mostrarClientesSQL = "call reporteVestidosMasRentados()";
            PreparedStatement psMostrarClientes = con.prepareStatement(mostrarClientesSQL);
            res = psMostrarClientes.executeQuery();
            modelo.setColumnIdentifiers(new Object[]{"Codigo de vestido", "Caracteristicas", "Talla", "Color", "Veces rentado"});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
        
        try {
            while (res.next()){
                modelo.addRow(new Object[]{res.getString("Vestido"), res.getString("Caracteristicas"), res.getString("Talla"), res.getString("Color"), res.getString("VecesRentado")});
            }
            tblReportesVestidos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTopVentana = new javax.swing.JPanel();
        imgLogo3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpTablaReportesEmpleado = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReportesVestidos = new javax.swing.JTable();
        jpBotones = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpTopVentana.setBackground(new java.awt.Color(164, 55, 123));

        imgLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/LogoChico.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("REPORTES DE VESTIDO MAS RENTADO");

        javax.swing.GroupLayout jpTopVentanaLayout = new javax.swing.GroupLayout(jpTopVentana);
        jpTopVentana.setLayout(jpTopVentanaLayout);
        jpTopVentanaLayout.setHorizontalGroup(
            jpTopVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopVentanaLayout.createSequentialGroup()
                .addComponent(imgLogo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(933, Short.MAX_VALUE))
        );
        jpTopVentanaLayout.setVerticalGroup(
            jpTopVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopVentanaLayout.createSequentialGroup()
                .addComponent(imgLogo3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpTablaReportesEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        jpTablaReportesEmpleado.setPreferredSize(new java.awt.Dimension(1920, 100));

        tblReportesVestidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblReportesVestidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha de renta", "Numero de factura", "Vestidos", "Cliente", "Empleado", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReportesVestidos.setRowHeight(24);
        jScrollPane3.setViewportView(tblReportesVestidos);

        javax.swing.GroupLayout jpTablaReportesEmpleadoLayout = new javax.swing.GroupLayout(jpTablaReportesEmpleado);
        jpTablaReportesEmpleado.setLayout(jpTablaReportesEmpleadoLayout);
        jpTablaReportesEmpleadoLayout.setHorizontalGroup(
            jpTablaReportesEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        jpTablaReportesEmpleadoLayout.setVerticalGroup(
            jpTablaReportesEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.setActionCommand("btnSalir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotonesLayout = new javax.swing.GroupLayout(jpBotones);
        jpBotones.setLayout(jpBotonesLayout);
        jpBotonesLayout.setHorizontalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpTopVentana, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpTablaReportesEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTopVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 866, Short.MAX_VALUE)
                .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(jpTablaReportesEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(114, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        GestionReportes gesReportes = new GestionReportes();
        gesReportes.setLayout(null);
        gesReportes.setLocationRelativeTo(null);
        gesReportes.setVisible(true);
        gesReportes.setPrivileges(privileges);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportesVestidoMasRentado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportesVestidoMasRentado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportesVestidoMasRentado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportesVestidoMasRentado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesVestidoMasRentado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel imgLogo3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpTablaReportesEmpleado;
    private javax.swing.JPanel jpTopVentana;
    private javax.swing.JTable tblReportesVestidos;
    // End of variables declaration//GEN-END:variables
}
