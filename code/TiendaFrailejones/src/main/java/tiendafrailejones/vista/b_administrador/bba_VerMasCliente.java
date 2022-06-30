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
import javax.swing.JOptionPane;
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
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel_LogoW = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FraileStore");
        setBackground(new java.awt.Color(209, 217, 180));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("FraileStore"); // NOI18N
        setResizable(false);

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

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Nueva Deuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAbonar.setBackground(new java.awt.Color(51, 153, 0));
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

        jPanel1.setBackground(new java.awt.Color(12, 91, 99));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 100));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_volver.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 764, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_LogoW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotalAbono)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalDeuda)
                            .addComponent(jLabel2))))
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(nombreCliente)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreCliente)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(labelTotalDeuda)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel4)
                        .addGap(19, 19, 19)
                        .addComponent(labelTotalAbono)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cliente.getPermitirDeuda().equalsIgnoreCase("N")) {
            JOptionPane.showMessageDialog(null, "EL usuario no tiene permitido crear deuda");
        } else {
            ab_AgregarDeuda deudaCliente = new ab_AgregarDeuda(this, rootPaneCheckingEnabled);
            deudaCliente.setCliente(cliente);
            deudaCliente.setiDeudaCrearListener(this);
            deudaCliente.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
        ab_AbonoDeuda abonoDeuda = new ab_AbonoDeuda(this, rootPaneCheckingEnabled);
        abonoDeuda.setCliente(cliente);
        abonoDeuda.setiDeudaAbonarListener(this);
        abonoDeuda.setTotalAbono(totalAbono);
        abonoDeuda.setTotalDeuda(totalDeudas);
        abonoDeuda.setVisible(true);
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        b_Menu adminMenu = new b_Menu();
        adminMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
        setBackgrounFila();
        calcularTotalAbono();

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
