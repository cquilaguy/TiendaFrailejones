/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tiendafrailejones.vista.c_empleado;

import tiendafrailejones.vista.b_administrador.*;
import tiendafrailejones.vista.a_general.ab_AbonoDeuda;
import tiendafrailejones.vista.b_administrador.bb_AdminGestClientes;
import UI.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import tiendafrailejones.controlador.ControladorCliente;
import tiendafrailejones.controlador.ControladorDeuda;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Deuda;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.consultas.ConsultaDeuda;
import tiendafrailejones.modelo.consultas.ConsultasCliente;
import tiendafrailejones.modelo.interfaces.IDeudaAbonarListener;
import tiendafrailejones.modelo.interfaces.IDeudaCrearListener;
import tiendafrailejones.vista.a_general.ab_AgregarDeuda;

/**
 *
 * @author JnerdQ
 */
public class cc_VerMasCliente extends javax.swing.JFrame
        implements IDeudaCrearListener, IDeudaAbonarListener {

    private Cliente cliente = new Cliente();
    private ConsultasCliente consultasCliente = new ConsultasCliente();
    private ControladorCliente controladorCliente = new ControladorCliente(consultasCliente);

    private ConsultaDeuda consultaDeuda = new ConsultaDeuda();
    private ControladorDeuda controladorDeuda = new ControladorDeuda(consultaDeuda);

    private DefaultTableModel defaultTableModel;
    private List<Deuda> deudas;
    private BigDecimal totalDeudas = BigDecimal.ZERO;
    private BigDecimal totalAbono = BigDecimal.ZERO;

    public cc_VerMasCliente() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initTable();
    }

    private void initTable() {
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Fecha");
        defaultTableModel.addColumn("Descripción");
        defaultTableModel.addColumn("Deuda");
        defaultTableModel.addColumn("Tipo");

        this.tabla.setModel(defaultTableModel);
    }

    private void llenarTabla() {
        defaultTableModel.setRowCount(0);

        for (Deuda deuda : getDeudas()) {
            String[] deudasDatos = new String[5];
            deudasDatos[0] = String.valueOf(deuda.getId());
            deudasDatos[1] = deuda.getFecha();
            deudasDatos[2] = deuda.getDescripcion();
            deudasDatos[3] = String.valueOf(deuda.getTodalDeuda());
            deudasDatos[4] = String.valueOf(deuda.getAbonoDeuda());

            defaultTableModel.addRow(deudasDatos);
        }
    }

    private void setBackgrounFila() {
        this.tabla.setDefaultRenderer(Object.class, new TableCellRenderer() {

            private DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    c.setBackground(Color.YELLOW);
                } else {
                    if (row % 2 == 0) {
                        c.setBackground(Color.WHITE);

                    } else {
                        c.setBackground(Color.LIGHT_GRAY);
                    }
                }

                return c;
            }
        });
    }

    private List<Deuda> getDeudas() {
        deudas = controladorDeuda.obtenerDeudas(Long.valueOf(cliente.getId()));
        return deudas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLabel_LogoW = new javax.swing.JLabel();
        inputIdentificacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        identificacionCliente = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JLabel();
        labelTotalDeuda = new javax.swing.JLabel();
        labelTotalAbono = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnAbonar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FraileStore");
        setBackground(new java.awt.Color(209, 217, 180));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("FraileStore"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(2, 125, 68));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 100));

        btnVolver.setText("INICIO");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel_LogoW.setFont(new java.awt.Font("Segoe UI Historic", 1, 48)); // NOI18N
        jLabel_LogoW.setForeground(new java.awt.Color(249, 241, 241));
        jLabel_LogoW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/isologo_w.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_LogoW, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_LogoW, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );

        inputIdentificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputIdentificacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar documento"));

        btnBuscar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        btnBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        identificacionCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        identificacionCliente.setText(".");
        identificacionCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No. de Identificación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N

        nombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreCliente.setText(".");
        nombreCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N

        labelTotalDeuda.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        labelTotalDeuda.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        labelTotalDeuda.setText(" ");
        labelTotalDeuda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Deuda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semilight", 0, 18))); // NOI18N

        labelTotalAbono.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        labelTotalAbono.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        labelTotalAbono.setText(" ");
        labelTotalAbono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semilight", 0, 18))); // NOI18N

        tabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Nueva Deuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAbonar.setBackground(new java.awt.Color(51, 153, 0));
        btnAbonar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnAbonar.setForeground(new java.awt.Color(255, 255, 255));
        btnAbonar.setText("Pagar Deuda");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(inputIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(identificacionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotalAbono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotalDeuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputIdentificacion)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(identificacionCliente)
                        .addGap(7, 7, 7)
                        .addComponent(nombreCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotalDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotalAbono))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (existeCliente()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente primero");
        } else if (cliente.getPermitirDeuda().equalsIgnoreCase("N")) {
            JOptionPane.showMessageDialog(null, "El usuario no tiene permitido crear deuda");
        } else {
            usuarioNoHabilitadoParaDeuda();

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuarioNoHabilitadoParaDeuda() {
        if (cliente.getPermitirDeuda().equalsIgnoreCase("N")) {
            JOptionPane.showMessageDialog(null, "Usuario no habilitado para generar deuda");
            return;
        } else {
            ab_AgregarDeuda deudaCliente = new ab_AgregarDeuda(this, rootPaneCheckingEnabled);
            deudaCliente.setCliente(cliente);
            deudaCliente.setiDeudaCrearListener(this);
            deudaCliente.setVisible(true);
        }
    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        c_Menu cMenu = new c_Menu();
        cMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed

        if (existeCliente()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente primero");
        } else {
            ab_AbonoDeuda abonoDeuda = new ab_AbonoDeuda(this, rootPaneCheckingEnabled);
            abonoDeuda.setCliente(cliente);
            abonoDeuda.setiDeudaAbonarListener(this);
            abonoDeuda.setTotalAbono(totalAbono);
            abonoDeuda.setTotalDeuda(totalDeudas);
            abonoDeuda.setVisible(true);
        }

    }//GEN-LAST:event_btnAbonarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (inputIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El id no puede ser vacío");
        }

        cliente = controladorCliente.existePorId(Long.valueOf(inputIdentificacion.getText()));
        if (cliente.getId() == null) {
            JOptionPane.showMessageDialog(null, "Cliente con el id " + inputIdentificacion.getText() + " no existe");
        } else {
            nombreCliente.setText(cliente.getNombre());
            identificacionCliente.setText(cliente.getIdentificacion());
            llenarTabla();
            calcularTotalAbono();
            setBackgrounFila();
        }
    }
    
    public boolean existeCliente() {
        return cliente == null || cliente.getId() == null;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new cc_VerMasCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel identificacionCliente;
    private javax.swing.JTextField inputIdentificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel_LogoW;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotalAbono;
    private javax.swing.JLabel labelTotalDeuda;
    private javax.swing.JLabel nombreCliente;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        nombreCliente.setText(cliente.getNombre());
        llenarTabla();
        calcularTotalAbono();
        setBackgrounFila();
    }

    @Override
    public void crearDeuda(Deuda deuda) {
        controladorDeuda.crear(deuda);
        llenarTabla();
        calcularTotalAbono();
        setBackgrounFila();
    }

    @Override
    public void abonar(Deuda deuda) {
        controladorDeuda.crear(deuda);
        llenarTabla();
        calcularTotalAbono();
        setBackgrounFila();
    }

    private void calcularTotalDeuda() {
        for (Deuda deuda : deudas) {
            if (deuda.getAbonoDeuda().contains("D")) {
                totalDeudas = totalDeudas.add(deuda.getTodalDeuda());
            }
        }

    }

    private void calcularTotalAbono() {
        resetDeudaAbono();
        calcularTotalDeuda();
        for (Deuda deuda : deudas) {
            if (deuda.getAbonoDeuda().contains("A")) {
                totalAbono = totalAbono.add(deuda.getTodalDeuda());
            }
        }
        totalDeudas = totalDeudas.subtract(totalAbono);
        llenarDeudaAbono();
    }

    private void llenarDeudaAbono() {
        labelTotalAbono.setText("$ " + totalAbono.toString());
        labelTotalDeuda.setText("$ " + totalDeudas.toString());
    }

    private void resetDeudaAbono() {
        totalAbono = BigDecimal.ZERO;
        totalDeudas = BigDecimal.ZERO;
    }

}
