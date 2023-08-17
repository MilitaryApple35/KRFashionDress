/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Codigo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chuyr
 */
public class Reportes extends javax.swing.JFrame {
    
    Conexion cc = new Conexion();
    Connection con = cc.conexion();
    
    public Reportes() {
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
            String mostrarClientesSQL = "call reporteRentasGeneral()";
            PreparedStatement psMostrarClientes = con.prepareStatement(mostrarClientesSQL);
            res = psMostrarClientes.executeQuery();
            modelo.setColumnIdentifiers(new Object[]{"Numero de factura", "Vestidos", "Cliente", "Empleado", "Fecha de renta", "Fecha de entrega", "Fecha de devolucion", "Identificacion", "Estatus de renta", "Total"});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
        
        try {
            while (res.next()){
                modelo.addRow(new Object[]{res.getString("numFactura"), res.getString("vestidos"), res.getString("cliente"), res.getString("empleado"), res.getString("fechaRenta"), res.getString("fechaEntrega"), res.getString("fechaDevolucion"), res.getString("identificacion"), res.getString("estatusRenta"), res.getString("total")});
            }
            tblReportesGeneral.setModel(modelo);
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
        jpTablaReportesGeneral = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReportesGeneral = new javax.swing.JTable();
        jpBotones = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jpTopVentana.setBackground(new java.awt.Color(164, 55, 123));

        imgLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/LogoChico.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("REPORTES GENERAL DE RENTAS");

        org.jdesktop.layout.GroupLayout jpTopVentanaLayout = new org.jdesktop.layout.GroupLayout(jpTopVentana);
        jpTopVentana.setLayout(jpTopVentanaLayout);
        jpTopVentanaLayout.setHorizontalGroup(
            jpTopVentanaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpTopVentanaLayout.createSequentialGroup()
                .add(imgLogo3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel4)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTopVentanaLayout.setVerticalGroup(
            jpTopVentanaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpTopVentanaLayout.createSequentialGroup()
                .add(imgLogo3)
                .add(0, 0, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpTablaReportesGeneral.setBackground(new java.awt.Color(255, 255, 255));
        jpTablaReportesGeneral.setPreferredSize(new java.awt.Dimension(1920, 100));

        tblReportesGeneral.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tblReportesGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "numFactura", "vestidos", "cliente", "empleado", "fechaRenta", "fechaEntrega", "fechaDevolucion", "identificacion", "estatusRenta", "total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReportesGeneral.setRowHeight(24);
        jScrollPane3.setViewportView(tblReportesGeneral);

        org.jdesktop.layout.GroupLayout jpTablaReportesGeneralLayout = new org.jdesktop.layout.GroupLayout(jpTablaReportesGeneral);
        jpTablaReportesGeneral.setLayout(jpTablaReportesGeneralLayout);
        jpTablaReportesGeneralLayout.setHorizontalGroup(
            jpTablaReportesGeneralLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        jpTablaReportesGeneralLayout.setVerticalGroup(
            jpTablaReportesGeneralLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
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

        org.jdesktop.layout.GroupLayout jpBotonesLayout = new org.jdesktop.layout.GroupLayout(jpBotones);
        jpBotones.setLayout(jpBotonesLayout);
        jpBotonesLayout.setHorizontalGroup(
            jpBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .add(btnSalir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpBotonesLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .add(btnSalir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpTopVentana, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jpTablaReportesGeneral, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jpBotones, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jpTopVentana, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpTablaReportesGeneral, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 860, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jpBotones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel imgLogo3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpTablaReportesGeneral;
    private javax.swing.JPanel jpTopVentana;
    private javax.swing.JTable tblReportesGeneral;
    // End of variables declaration//GEN-END:variables
}
