/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tiendafrailejones.vista.b_administrador;

import tiendafrailejones.vista.a_general.ab_AbonoDeuda;
import tiendafrailejones.vista.b_administrador.bb_AdminGestClientes;
import UI.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import tiendafrailejones.controlador.ControladorDeuda;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Deuda;
import tiendafrailejones.modelo.consultas.ConsultaDeuda;
import tiendafrailejones.modelo.interfaces.IDeudaAbonarListener;
import tiendafrailejones.modelo.interfaces.IDeudaCrearListener;
import tiendafrailejones.vista.a_general.ab_AgregarDeuda;

/**
 *
 * @author JnerdQ
 */
public class bba_VerMasCliente extends javax.swing.JFrame
        implements IDeudaCrearListener, IDeudaAbonarListener {

    private ConsultaDeuda consultaDeuda = new ConsultaDeuda();
    private ControladorDeuda controladorDeuda = new ControladorDeuda(consultaDeuda);
    private Cliente cliente;
    private DefaultTableModel defaultTableModel;
    private List<Deuda> deudas;
    private BigDecimal totalDeudas = BigDecimal.ZERO;
    private BigDecimal totalAbono = BigDecimal.ZERO;

    public bba_VerMasCliente() {
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
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        nombreCliente = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnAbonar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelTotalDeuda = new javax.swing.JLabel();
        labelTotalAbono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FraileStore");
        setBackground(new java.awt.Color(209, 217, 180));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("FraileStore"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(166, 85, 15));

        jButton5.setText("Perfil");

        jLabel1.setText("logo (eliminar esto)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnVolver.setText("BTN_VOLVER (reubicar)");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

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

        nombreCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreCliente.setText("Nombre cliente");

        jButton1.setBackground(new java.awt.Color(255, 67, 56));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Nueva Deuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAbonar.setBackground(new java.awt.Color(130, 188, 0));
        btnAbonar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAbonar.setForeground(new java.awt.Color(255, 255, 255));
        btnAbonar.setText("Pagar Deuda");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });

        jLabel2.setText("TOTAL DEUDA");

        jLabel3.setText("Nombre Cliente");

        jLabel4.setText("TOTAL ABONO");

        labelTotalDeuda.setFont(new java.awt.Font("League Spartan SemiBold", 0, 24)); // NOI18N
        labelTotalDeuda.setForeground(new java.awt.Color(255, 0, 0));
        labelTotalDeuda.setText("jLabel5");

        labelTotalAbono.setFont(new java.awt.Font("League Spartan SemiBold", 0, 24)); // NOI18N
        labelTotalAbono.setForeground(new java.awt.Color(51, 102, 0));
        labelTotalAbono.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalAbono)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTotalDeuda)
                                    .addComponent(jLabel2))))))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(nombreCliente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(215, 215, 215))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreCliente)
                            .addComponent(btnVolver))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(labelTotalDeuda)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel4)
                        .addGap(19, 19, 19)
                        .addComponent(labelTotalAbono)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ab_AgregarDeuda deudaCliente = new ab_AgregarDeuda(this, rootPaneCheckingEnabled);
        deudaCliente.setIdCliente(cliente.getId());
        deudaCliente.setiDeudaCrearListener(this);
        deudaCliente.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        bb_AdminGestClientes adminGestClients = new bb_AdminGestClientes();
        adminGestClients.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
        ab_AbonoDeuda abonoDeuda = new ab_AbonoDeuda(this, rootPaneCheckingEnabled);
        abonoDeuda.setIdCliente(cliente.getId());
        abonoDeuda.setiDeudaAbonarListener(this);
        abonoDeuda.setVisible(true);
    }//GEN-LAST:event_btnAbonarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new bba_VerMasCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
