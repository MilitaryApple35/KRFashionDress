/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Codigo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asder
 */
public class CrearRenta extends javax.swing.JFrame {

    /**
     * Creates new form CrearRenta
     */
    public CrearRenta() {
        initComponents();
        fullscreen();
        llenarTabla();
    }
    private float total;
    Conexion cc=new Conexion();
    Connection con= cc.conexion();
    private int idCliente;
    private int privileges;
    private String user;
    private String password;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getPrivileges() {
        return privileges;
    }

    public void setPrivileges(int privileges) {
        this.privileges = privileges;
    }
    public int getIdEmpleado(){
        try {
            String idEmpleadoSQL="call buscarIdEmpleado(?);";
            PreparedStatement stmt=con.prepareStatement(idEmpleadoSQL);
            ResultSet rs;
            stmt.setString(1, user);
            rs = stmt.executeQuery();
            return rs.getInt(1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
        return -1;
    }
    
    public int getIdVestido(String nombre){
        try {
            String idVestidoSQL="call buscarIdVestido(?);";
            PreparedStatement stmt=con.prepareStatement(idVestidoSQL);
            ResultSet rs;
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            return rs.getInt(1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
        return -1;
    }
    
    public void fullscreen(){
        super.dispose();
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setUndecorated(!super.isUndecorated());
        super.setVisible(true);
    }
    
    public void llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
        // Hacer que todas las celdas no sean editables
                return false;
            }
        };
        ResultSet res = null;
        try {
            String SQL="call mostrarVestidosDisponibles()";
            PreparedStatement pst= con.prepareStatement(SQL);
            res= pst.executeQuery();
            modelo.setColumnIdentifiers(new Object[]{"Vestido", "Caracteristicas", "Talla", "Color", "Precio", "Estatus"});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
        try {
            while (res.next()){
                modelo.addRow(new Object[]{res.getString("nombreVes"), res.getString("caractVes"), res.getString("tallaVes"), res.getString("colorVes"), res.getString("precioVes"), res.getString("estatus")});
            }
            tblListaVestidos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }
    
    public void actualizarListaActual(String vestido, String caracteristicas, float precio){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
        // Hacer que todas las celdas no sean editables
                return false;
            }
        };
        modelo.setColumnIdentifiers(new Object[]{"Vestido", "Caracteristicas", "Precio"});
        int y=1;
        while(y<tblListaActual.getRowCount()){
            modelo.addRow(new Object[]{tblListaActual.getValueAt(y, 1), tblListaActual.getValueAt(y, 2), tblListaActual.getValueAt(y, 3)});
            y++;
        }
        modelo.addRow(new Object[]{vestido,caracteristicas, precio});
        tblListaActual.setModel(modelo);
    }
    
    public void actualizarListaAnotaciones(String Anotaciones){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
        // Hacer que todas las celdas no sean editables
                return false;
            }
        };
        modelo.setColumnIdentifiers(new Object[]{"Anotaciones"});
        int y=1;
        while(y<tblListaActual.getRowCount()){
            modelo.addRow(new Object[]{tblListaAnotaciones.getValueAt(y, 1)});
            y++;
        }
        modelo.addRow(new Object[]{Anotaciones});
        tblListaActual.setModel(modelo);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbFechaRenta = new javax.swing.JLabel();
        lbFechaEntrega = new javax.swing.JLabel();
        lbListaActual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaActual = new javax.swing.JTable();
        lbAnotaciones = new javax.swing.JLabel();
        spnDiaFR = new javax.swing.JSpinner();
        spnMesFR = new javax.swing.JSpinner();
        spnAnioFR = new javax.swing.JSpinner();
        lbSlash = new javax.swing.JLabel();
        lbSlash1 = new javax.swing.JLabel();
        lbSlash2 = new javax.swing.JLabel();
        lbSlash3 = new javax.swing.JLabel();
        spnDiaFE = new javax.swing.JSpinner();
        spnMesFE = new javax.swing.JSpinner();
        spnAnioFE = new javax.swing.JSpinner();
        lbTelefono1 = new javax.swing.JLabel();
        rdioINE = new javax.swing.JRadioButton();
        rdioLicencia = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblListaAnotaciones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbListaVestidos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListaVestidos = new javax.swing.JTable();
        btnRentar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(164, 55, 123));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/LogoChico.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREAR RENTA");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(imgLogo)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 373, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1453, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(imgLogo)
            .add(jPanel2Layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(jLabel1))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbFechaRenta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbFechaRenta.setText("Fecha de Entrega");

        lbFechaEntrega.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbFechaEntrega.setText("Fecha de Regreso");

        lbListaActual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbListaActual.setText("Lista Actual");

        tblListaActual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tblListaActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Vestido", "Caracteristicas", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaActual.setRowHeight(24);
        tblListaActual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaActualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaActual);

        lbAnotaciones.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAnotaciones.setText("Lista Anotaciones");

        spnDiaFR.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        spnMesFR.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        spnAnioFR.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lbSlash.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbSlash.setText("/");

        lbSlash1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbSlash1.setText("/");

        lbSlash2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbSlash2.setText("/");

        lbSlash3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbSlash3.setText("/");

        spnDiaFE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        spnMesFE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        spnAnioFE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lbTelefono1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTelefono1.setText("Identificacion");

        buttonGroup1.add(rdioINE);
        rdioINE.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rdioINE.setText("INE");
        rdioINE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioINEActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdioLicencia);
        rdioLicencia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rdioLicencia.setText("Licencia de conducir");
        rdioLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioLicenciaActionPerformed(evt);
            }
        });

        tblListaAnotaciones.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tblListaAnotaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Anotacion"
            }
        ));
        tblListaAnotaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaAnotacionesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblListaAnotaciones);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(lbTelefono1)
                                .add(32, 32, 32)
                                .add(rdioINE)
                                .add(18, 18, 18)
                                .add(rdioLicencia))
                            .add(lbListaActual)
                            .add(lbAnotaciones))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(lbFechaRenta)
                                    .add(lbFechaEntrega))
                                .add(18, 18, 18)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(spnDiaFR, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(spnDiaFE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(40, 40, 40)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(lbSlash)
                                    .add(lbSlash2))
                                .add(41, 41, 41)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jPanel3Layout.createSequentialGroup()
                                        .add(spnMesFE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(lbSlash3))
                                    .add(jPanel3Layout.createSequentialGroup()
                                        .add(spnMesFR, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(38, 38, 38)
                                        .add(lbSlash1)))
                                .add(38, 38, 38)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(spnAnioFR, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(spnAnioFE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(0, 287, Short.MAX_VALUE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane4))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lbFechaRenta, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, spnDiaFR)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, spnAnioFR)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, spnMesFR, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lbSlash)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lbSlash1))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbFechaEntrega)
                    .add(lbSlash2)
                    .add(lbSlash3)
                    .add(spnDiaFE)
                    .add(spnMesFE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(spnAnioFE))
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbTelefono1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(rdioINE)
                    .add(rdioLicencia))
                .add(45, 45, 45)
                .add(lbListaActual)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 336, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(lbAnotaciones)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 336, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(52, 52, 52))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lbListaVestidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbListaVestidos.setText("Lista Vestidos");

        tblListaVestidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tblListaVestidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Vestido", "Caracteristicas", "Color", "Talla", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaVestidos.setRowHeight(24);
        tblListaVestidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaVestidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListaVestidos);

        btnRentar.setBackground(new java.awt.Color(0, 204, 0));
        btnRentar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRentar.setForeground(new java.awt.Color(255, 255, 255));
        btnRentar.setText("Rentar");
        btnRentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setText("$$");

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(lbTotal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(lbTotal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lbListaVestidos)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 955, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnRentar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(40, 40, 40)
                        .add(btnCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(58, 58, 58))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(lbListaVestidos)
                .add(18, 18, 18)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 662, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnCancelar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(btnRentar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentarActionPerformed
        String fechaRegreso=spnAnioFR.getValue().toString().concat("-".concat(spnMesFR.getValue().toString().concat("-".concat(spnDiaFR.getValue().toString()))));
        String fechaEntrega=spnAnioFE.getValue().toString().concat("-".concat(spnMesFE.getValue().toString().concat("-".concat(spnDiaFE.getValue().toString()))));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(fechaRegreso);
            sdf.parse(fechaEntrega);
            try {
                String SQL="call altaRentas(?,?,?,?,?,?,?);";
                PreparedStatement ppst= con.prepareStatement(SQL);
                ppst.setInt(1, idCliente);
                if(getIdEmpleado()==-1){
                    int a = 1/0;
                }
                ppst.setInt(2, getIdEmpleado());
                Date fecha = new Date();
                String fechaRenta = Integer.toString(fecha.getYear()).concat("-".concat(Integer.toString(fecha.getMonth()).concat("-".concat(Integer.toString(fecha.getDay())))));
                ppst.setString(3, fechaRenta);
                ppst.setString(4, fechaEntrega);
                ppst.setString(5, fechaRegreso);
                if(buttonGroup1.getSelection().equals(rdioINE.getModel())==true){
                    ppst.setInt(6, 0);
                }
                else{
                    ppst.setInt(6, 1);
                }
                ppst.setInt(7, 0);
                int y=1;
                String anSQL="call altaDetallesRenta(?,?)";
                PreparedStatement pst= con.prepareStatement(anSQL);
                while(y<tblListaActual.getRowCount()){
                    if(getIdVestido(tblListaActual.getValueAt(y, 1).toString())==-1){
                        int a = 1/0;
                    }
                    pst.setInt(1,getIdVestido(tblListaActual.getValueAt(y, 1).toString()));
                    pst.setString(2, tblListaAnotaciones.getValueAt(y, 1).toString());
                    y++;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la alta " + e.getMessage());
            }

            if(getPrivileges()==1){
                Empleados emp= new Empleados();
                emp.setLayout(null);
                emp.setLocationRelativeTo(null);
                emp.setVisible(true);
                this.setVisible(false);
            }
            else if(getPrivileges()==2){
                Gerente ger = new Gerente();
                ger.setLayout(null);
                ger.setLocationRelativeTo(null);
                ger.setVisible(true);
                ger.setPrivileges(privileges);
                this.setVisible(false);
            }
        }catch(java.text.ParseException e){
            JOptionPane.showMessageDialog(null, "La fecha ingresada es invalidad", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e.toString() + e.getMessage());
        }
    }//GEN-LAST:event_btnRentarActionPerformed

    private void rdioINEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioINEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdioINEActionPerformed

    private void rdioLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioLicenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdioLicenciaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(getPrivileges()==1){
            Empleados emp= new Empleados();
            emp.setLayout(null);
            emp.setLocationRelativeTo(null);
            emp.setVisible(true);
            emp.setPrivileges(privileges);
            this.setVisible(false);
        }
        else if(getPrivileges()==2){
            Gerente ger = new Gerente();
            ger.setLayout(null);
            ger.setLocationRelativeTo(null);
            ger.setVisible(true);
            ger.setPrivileges(privileges);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblListaVestidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaVestidosMouseClicked
        int filaSeleccionada = tblListaVestidos.getSelectedRow();
        int columnaSeleccionada = tblListaVestidos.getSelectedColumn();

        if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
            actualizarListaActual(tblListaVestidos.getValueAt(filaSeleccionada, 1).toString(), tblListaVestidos.getValueAt(filaSeleccionada, 2).toString(), Float.parseFloat(tblListaVestidos.getValueAt(filaSeleccionada, 3).toString()));
            total= total+ Float.parseFloat(tblListaVestidos.getValueAt(filaSeleccionada, 3).toString());
            lbTotal.setText("$$ "+total);
            String anotaciones = JOptionPane.showInputDialog(null, "Introduzca las anotaciones pertinentes");
            actualizarListaAnotaciones(anotaciones);
        }
    }//GEN-LAST:event_tblListaVestidosMouseClicked

    private void tblListaActualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaActualMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblListaActual.getModel();
        int selectedRow = tblListaActual.getSelectedRow();
        total= total- Float.parseFloat(tblListaVestidos.getValueAt(selectedRow, 3).toString());
        lbTotal.setText("$$ "+total);
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        }
        DefaultTableModel anotacion = (DefaultTableModel) tblListaAnotaciones.getModel();
        if(selectedRow!=-1){
            anotacion.removeRow(selectedRow);
        }
    }//GEN-LAST:event_tblListaActualMouseClicked

    private void tblListaAnotacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaAnotacionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListaAnotacionesMouseClicked

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
            java.util.logging.Logger.getLogger(CrearRenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearRenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearRenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearRenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearRenta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRentar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbAnotaciones;
    private javax.swing.JLabel lbFechaEntrega;
    private javax.swing.JLabel lbFechaRenta;
    private javax.swing.JLabel lbListaActual;
    private javax.swing.JLabel lbListaVestidos;
    private javax.swing.JLabel lbSlash;
    private javax.swing.JLabel lbSlash1;
    private javax.swing.JLabel lbSlash2;
    private javax.swing.JLabel lbSlash3;
    private javax.swing.JLabel lbTelefono1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JRadioButton rdioINE;
    private javax.swing.JRadioButton rdioLicencia;
    private javax.swing.JSpinner spnAnioFE;
    private javax.swing.JSpinner spnAnioFR;
    private javax.swing.JSpinner spnDiaFE;
    private javax.swing.JSpinner spnDiaFR;
    private javax.swing.JSpinner spnMesFE;
    private javax.swing.JSpinner spnMesFR;
    private javax.swing.JTable tblListaActual;
    private javax.swing.JTable tblListaAnotaciones;
    private javax.swing.JTable tblListaVestidos;
    // End of variables declaration//GEN-END:variables
}
