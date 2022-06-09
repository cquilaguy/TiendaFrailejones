/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tiendafrailejones.vista.pendiente;

import tiendafrailejones.vista.b_administrador.b_Menu;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import tiendafrailejones.controlador.ControladorCliente;
import tiendafrailejones.controlador.ControladorEmpleado;
import tiendafrailejones.controlador.ControladorLogin;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.Login;
import tiendafrailejones.modelo.consultas.ConsultasCliente;
import tiendafrailejones.modelo.consultas.ConsultasEmpleado;
import tiendafrailejones.modelo.consultas.ConsultasLogin;
import tiendafrailejones.utils.AES;
import tiendafrailejones.utils.DataUser;
import tiendafrailejones.utils.TipoDocumentos;

/**
 *
 * @author dfquintero
 */
public class AdminGestCustomer extends javax.swing.JFrame {

    private Empleado e = new Empleado();
    private final ConsultasEmpleado consultasEmpleado = new ConsultasEmpleado();
    private final ControladorEmpleado controladorEmpleado = new ControladorEmpleado(consultasEmpleado);

    private Login login = new Login();
    private final ConsultasLogin consultasLogin = new ConsultasLogin();
    private final ControladorLogin controladorLogin = new ControladorLogin(consultasLogin);
    private DefaultTableModel defaultTableModel;

    private Cliente cliente = new Cliente();
    private final ConsultasCliente consultasCliente = new ConsultasCliente();
    private final ControladorCliente controladorCliente = new ControladorCliente(consultasCliente);

    private boolean actualizar = false;
    private String tipoDocumento;
    private String tipoUsuario;
    private Integer activo = 1;

    public AdminGestCustomer() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnEliminar.setEnabled(false);
        tipoUsuario = "CLIENTE";
        tipoDocumento = "CÉDULA";

        initTable();
        llenarTabla();
        System.out.println(DataUser.getDataUser().getIdUser());
    }

    private void initTable() {
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
        };

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Nombre");
        defaultTableModel.addColumn("Telefono");
        defaultTableModel.addColumn("Identificación");
        defaultTableModel.addColumn("Tipo de indentificación");
        defaultTableModel.addColumn("Tipo Usuario");
        defaultTableModel.addColumn("Activo");
        defaultTableModel.addColumn("Direccion");

        this.tablaClientes.setModel(defaultTableModel);

    }

    private void llenarTabla() {
        defaultTableModel.setRowCount(0);
        List<Cliente> clientes = controladorCliente.obtenetTodosLosCliente();
        for (Cliente cli : clientes) {
            String[] clienteDatos = new String[8];
            clienteDatos[0] = String.valueOf(cli.getId());
            clienteDatos[1] = cli.getNombre();
            clienteDatos[2] = cli.getTelefono();
            clienteDatos[3] = cli.getIdentificacion();
            clienteDatos[4] = cli.getTipoIdentificacion();
            clienteDatos[5] = cli.getTipoUsuario();
            clienteDatos[6] = (cli.getActivo().equals(1)) ? "ACTIVO" : "INACTIVO";
            clienteDatos[7] = cli.getDireccion();
            defaultTableModel.addRow(clienteDatos);
        }
    }

    private void ordenar(String seleccion){
        
        List<Cliente> clientes = new ArrayList<>();
        if (seleccion.equalsIgnoreCase("Ordenar por nombre Ascendete")) {
            clientes = consultasCliente.ordenarPorNombreAsc();
        } else if (seleccion.equalsIgnoreCase("Ordenar por nombre Descendente")) {
            clientes = consultasCliente.ordenarPorNombreDesc();
        } 
        
        defaultTableModel.setRowCount(0);
        for (Cliente cli : clientes) {
            String[] clienteDatos = new String[8];
            clienteDatos[0] = String.valueOf(cli.getId());
            clienteDatos[1] = cli.getNombre();
            clienteDatos[2] = cli.getTelefono();
            clienteDatos[3] = cli.getIdentificacion();
            clienteDatos[4] = cli.getTipoIdentificacion();
            clienteDatos[5] = cli.getTipoUsuario();
            clienteDatos[6] = (cli.getActivo().equals(1)) ? "ACTIVO" : "INACTIVO";
            clienteDatos[7] = cli.getDireccion();
            defaultTableModel.addRow(clienteDatos);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        inputNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputIdentificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcomboxTipoID = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        inputDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jcomboxTipoUsuario = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        inputBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxOrdenar = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        jButton4.setText("BTN_VOLVER (reubicar)");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(24, 24, 24)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Usuario"));

        jLabel2.setText("Nombre Completo");

        jLabel3.setText("Tipo de Documento");

        inputIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdentificacionActionPerformed(evt);
            }
        });
        inputIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputIdentificacionKeyTyped(evt);
            }
        });

        jLabel4.setText("Número de Documento");

        inputTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setText("Telefono");

        jcomboxTipoID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CÉDULA", "CÉDULA DE EXTRANJERIA", "PASAPORTE" }));
        jcomboxTipoID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcomboxTipoIDItemStateChanged(evt);
            }
        });
        jcomboxTipoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboxTipoIDActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de Usuario");

        jLabel8.setText("Direccion");

        btnCrearActualizar.setBackground(new java.awt.Color(130, 188, 0));
        btnCrearActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearActualizar.setText("Crear / Actualizar");
        btnCrearActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 67, 56));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jcomboxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CLIENTE" }));
        jcomboxTipoUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcomboxTipoUsuarioItemStateChanged(evt);
            }
        });
        jcomboxTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboxTipoUsuarioActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Ver Más");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jcomboxTipoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, 0, 446, Short.MAX_VALUE)
                            .addComponent(inputDireccion, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inputTelefono)
                                .addComponent(inputIdentificacion)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jcomboxTipoID, 0, 300, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnCrearActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcomboxTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcomboxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnCrearActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios Registrados"));

        inputBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBuscarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Buscar");

        jComboBoxOrdenar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenar por nombre Ascendete", "Ordenar por nombre Descendente" }));
        jComboBoxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdenarActionPerformed(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaClientes);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton2.setText("Quitar filtros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(38, 38, 38))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 225, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        try {

            verificarCampos();

            Cliente cli = controladorCliente.existePorId(Long.valueOf(inputIdentificacion.getText()));

            if (!actualizar && cli != null && Objects.equals(cli.getIdentificacion(), inputIdentificacion.getText())) {
                JOptionPane.showMessageDialog(null, "Usuario ya existe con ese numero de identificación");
            } else if (cliente.getId() != null && actualizar) {  // Actualizar

                cliente.setId(cliente.getId());
                cliente.setNombre(inputNombre.getText());
                cliente.setTelefono(inputTelefono.getText());
                cliente.setIdentificacion(inputIdentificacion.getText());
                cliente.setTipoIdentificacion(jcomboxTipoID.getPrototypeDisplayValue());
                cliente.setTipoUsuario(cliente.getTipoUsuario().toUpperCase());
                cliente.setTipoIdentificacion(tipoDocumento);
                cliente.setDireccion(inputDireccion.getText());
                controladorCliente.actualizar(cliente);
                btnCrearActualizar.setText("Guardar");
                btnEliminar.setEnabled(false);
                limpiarCampos();
                llenarGuardarTabla();

                JOptionPane.showMessageDialog(null, "Se ha actualizado el registro");
            } else { // Crear

                cliente.setNombre(inputNombre.getText());
                cliente.setTelefono(inputTelefono.getText());
                cliente.setIdentificacion(inputIdentificacion.getText());
                cliente.setTipoIdentificacion(tipoDocumento.toUpperCase());
                cliente.setTipoUsuario(tipoUsuario.toUpperCase());
                cliente.setActivo(activo);
                cliente.setDireccion(inputDireccion.getText());

                controladorCliente.crear(cliente);

                llenarGuardarTabla();
                limpiarCampos();

                JOptionPane.showMessageDialog(null, "Se ha guardado el registro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        verificarSeleccionCliente();

        // TODO add your handling code here:
        cliente.setActivo(0);
        controladorCliente.eliminar(cliente.getId());
        limpiarCampos();
        llenarGuardarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        b_Menu adminMenu = new b_Menu();
        adminMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void inputBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputBuscarActionPerformed

    private void jcomboxTipoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboxTipoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboxTipoIDActionPerformed

    private void jcomboxTipoIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcomboxTipoIDItemStateChanged
        // TODO add your handling code here:
        tipoDocumento = jcomboxTipoID.getSelectedItem().toString();
    }//GEN-LAST:event_jcomboxTipoIDItemStateChanged

    private void verificarSeleccionCliente() {
        if (cliente == null || cliente.getId() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario ");
            return;
        }
    }

    private void jcomboxTipoUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcomboxTipoUsuarioItemStateChanged
        // TODO add your handling code here:
        tipoUsuario = jcomboxTipoUsuario.getSelectedItem().toString();
    }//GEN-LAST:event_jcomboxTipoUsuarioItemStateChanged

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:
        int fila = tablaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Usuario seleccionado");
        } else {
            actualizar = true;
            Long id = Long.valueOf((String) tablaClientes.getValueAt(fila, 3));
            cliente = controladorCliente.existePorId(id);
            Login loginTemp = new Login();
            loginTemp.setIdUsuario(Long.valueOf(cliente.getIdentificacion()));
            login = controladorLogin.existeLoginPorId(loginTemp);
            inputNombre.setText(cliente.getNombre());
            inputDireccion.setText(cliente.getDireccion());
            inputIdentificacion.setText(cliente.getIdentificacion());
            inputTelefono.setText(cliente.getTelefono());
            jcomboxTipoID.setSelectedItem(cliente.getTipoIdentificacion());
            jcomboxTipoUsuario.setSelectedItem(cliente.getTipoUsuario());

            btnEliminar.setEnabled(true);

        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarCampos();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcomboxTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboxTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboxTipoUsuarioActionPerformed
    /**/
    private void inputIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdentificacionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (inputBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar número de identificación o nombre");
            return;
        }

        List<Cliente> clientes = controladorCliente.buscar(inputBuscar.getText());
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay coincidencias");
            return;
        } else {
            defaultTableModel.setRowCount(0);
            for (Cliente cli : clientes) {
                String[] clienteDatos = new String[8];
                clienteDatos[0] = String.valueOf(cli.getId());
                clienteDatos[1] = cli.getNombre();
                clienteDatos[2] = cli.getTelefono();
                clienteDatos[3] = cli.getIdentificacion();
                clienteDatos[4] = cli.getTipoIdentificacion();
                clienteDatos[5] = cli.getTipoUsuario();
                clienteDatos[6] = (cli.getActivo().equals(1)) ? "ACTIVO" : "INACTIVO";
                clienteDatos[7] = cli.getDireccion();
                defaultTableModel.addRow(clienteDatos);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llenarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void inputIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputIdentificacionKeyTyped
        verificarSiEsDigito(evt);
    }//GEN-LAST:event_inputIdentificacionKeyTyped

    private void inputTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelefonoKeyTyped
        verificarSiEsDigito(evt);
    }//GEN-LAST:event_inputTelefonoKeyTyped

    private void jComboBoxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdenarActionPerformed
        String evento = jComboBoxOrdenar.getSelectedItem().toString();
        ordenar(evento);
    }//GEN-LAST:event_jComboBoxOrdenarActionPerformed

    
    private void verificarSiEsDigito(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }
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
            new AdminGestCustomer().setVisible(true);
        });
    }

    private void verificarCampos() throws Exception {
        if (inputNombre.getText().isEmpty()) {
            throw new Exception("nombre");
        } else if (inputTelefono.getText().isEmpty()) {
            throw new Exception("telefono");
        } else if (inputIdentificacion.getText().isEmpty()) {
            throw new Exception("identificacion");
        } else if (tipoDocumento.isEmpty()) {
            throw new Exception("tipo de id vacío");
        } else if (inputDireccion.getText().isEmpty()) {
            throw new Exception("Direccion vacío");
        }
    }

    private void verificarCorreo() throws Exception {
        String verificarCorreo = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(verificarCorreo);
        Matcher matcher = pattern.matcher(inputDireccion.getText());
        Boolean match = matcher.matches();
        if (!match) {
            throw new Exception("Correo invalido. Formato: corre@gmail.com");
        }
    }

    private void limpiarCampos() {
        inputNombre.setText("");
        inputIdentificacion.setText("");
        inputTelefono.setText("");

        inputDireccion.setText("");

//        jcomboxTipoID.cl;
        actualizar = false;
        cliente = new Cliente();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    public javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTextField inputBuscar;
    private javax.swing.JTextField inputDireccion;
    private javax.swing.JTextField inputIdentificacion;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBoxOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox<String> jcomboxTipoID;
    private javax.swing.JComboBox<String> jcomboxTipoUsuario;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables

    private void llenarGuardarTabla() {
        llenarTabla();
    }

}
