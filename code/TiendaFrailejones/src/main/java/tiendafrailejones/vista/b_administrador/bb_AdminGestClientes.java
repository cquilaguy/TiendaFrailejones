package tiendafrailejones.vista.b_administrador;

import com.formdev.flatlaf.FlatLightLaf;
import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import tiendafrailejones.controlador.ControladorCliente;
import tiendafrailejones.controlador.ControladorDeuda;
import tiendafrailejones.controlador.ControladorEmpleado;
import tiendafrailejones.controlador.ControladorLogin;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Deuda;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.Login;
import tiendafrailejones.modelo.consultas.ConsultaDeuda;
import tiendafrailejones.modelo.consultas.ConsultasCliente;
import tiendafrailejones.modelo.consultas.ConsultasEmpleado;
import tiendafrailejones.modelo.consultas.ConsultasLogin;
import tiendafrailejones.vista.c_empleado.c_Menu;

public class bb_AdminGestClientes extends javax.swing.JFrame {

    private Empleado empleado = new Empleado();
    private final ConsultasEmpleado consultasEmpleado = new ConsultasEmpleado();
    private final ControladorEmpleado controladorEmpleado = new ControladorEmpleado(consultasEmpleado);

    private Login login = new Login();
    private final ConsultasLogin consultasLogin = new ConsultasLogin();
    private final ControladorLogin controladorLogin = new ControladorLogin(consultasLogin);

    private Cliente cliente = new Cliente();
    private final ConsultasCliente consultasCliente = new ConsultasCliente();
    private final ControladorCliente controladorCliente = new ControladorCliente(consultasCliente);

    private ConsultaDeuda consultaDeuda = new ConsultaDeuda();
    private ControladorDeuda controladorDeuda = new ControladorDeuda(consultaDeuda);

    private boolean actualizar = false;
    private String tipoDocumento;
    private String tipoUsuario;
    private Integer activo = 1;

    private DefaultTableModel defaultTableModel;
    private BigDecimal totalDeudas = BigDecimal.ZERO;
    private BigDecimal totalAbono = BigDecimal.ZERO;

    public bb_AdminGestClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        initTable();
        llenarTabla();
        datosPredeterminados();
    }

    private void initTable() {
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
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
        defaultTableModel.addColumn("Permitir");
        defaultTableModel.addColumn("Total Deuda");

        this.tablaClientes.setModel(defaultTableModel);
    }

    private void datosPredeterminados() {
        btnEliminar.setEnabled(false);
        tipoUsuario = "CLIENTE";
        tipoDocumento = "CÉDULA";
    }

    private void llenarTabla() {
        vaciarTabla();
        List<Cliente> clientes = controladorCliente.obtenetTodosLosCliente();
        llenarDatos(clientes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        inputNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputIdentificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcomboxTipoID = new javax.swing.JComboBox<>();
        inputDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jComboBoxPermitirDeuda = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        bntVerMas = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        inputBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxOrdenar = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();

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
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Información de Cliente"));

        jLabel2.setText("Nombre Completo");

        jLabel3.setText("Tipo de Documento");

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

        inputDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDireccionActionPerformed(evt);
            }
        });

        jLabel8.setText("Dirección");

        jButton4.setText("BTN_VOLVER (reubicar)");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBoxPermitirDeuda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        jComboBoxPermitirDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPermitirDeudaActionPerformed(evt);
            }
        });

        jLabel7.setText("Permitir Deuda");

        bntVerMas.setBackground(new java.awt.Color(130, 188, 0));
        bntVerMas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntVerMas.setForeground(new java.awt.Color(255, 255, 255));
        bntVerMas.setText("Ver mas");
        bntVerMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVerMasActionPerformed(evt);
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

        jButton3.setBackground(new java.awt.Color(255, 255, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCrearActualizar.setBackground(new java.awt.Color(130, 188, 0));
        btnCrearActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearActualizar.setText("Guardar");
        btnCrearActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxPermitirDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcomboxTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnCrearActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
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
                    .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jComboBoxPermitirDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcomboxTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes Registrados"));

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
        jScrollPane1.setViewportView(tablaClientes);

        inputBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBuscarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Buscar");

        jComboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenar por nombre Ascendete", "Ordenar por nombre Descendente" }));
        jComboBoxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdenarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar filtros");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24)
                        .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnQuitar))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVerMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVerMasActionPerformed
        if (isClienteSeleccionado()) {
            showDialog("Seleccione un cliente primero");
        } else {
            bba_VerMasCliente adminGestClientsDeuda = new bba_VerMasCliente();
            adminGestClientsDeuda.setVisible(true);
            adminGestClientsDeuda.setCliente(cliente);
            this.dispose();
        }
    }//GEN-LAST:event_bntVerMasActionPerformed

    private boolean isClienteSeleccionado() {
        return cliente.getId() == null;
    }

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        b_Menu bMenu = new b_Menu();
        bMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void inputBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBuscarActionPerformed
        String evento = jComboBoxOrdenar.getSelectedItem().toString();
        ordenar(evento);
    }//GEN-LAST:event_inputBuscarActionPerformed

    private void ordenar(String seleccion) {

        List<Cliente> clientes = new ArrayList<>();
        if (seleccion.equalsIgnoreCase("Ordenar por nombre Ascendete")) {
            clientes = consultasCliente.ordenarPorNombreAsc();
        } else if (seleccion.equalsIgnoreCase("Ordenar por nombre Descendente")) {
            clientes = consultasCliente.ordenarPorNombreDesc();
        }

        vaciarTabla();
        llenarDatos(clientes);
    }

    private void llenarDatos(List<Cliente> clientes) {
        for (Cliente cli : clientes) {
            String[] clienteDatos = new String[10];
            clienteDatos[0] = String.valueOf(cli.getId());
            clienteDatos[1] = cli.getNombre();
            clienteDatos[2] = cli.getTelefono();
            clienteDatos[3] = cli.getIdentificacion();
            clienteDatos[4] = cli.getTipoIdentificacion();
            clienteDatos[5] = cli.getTipoUsuario();
            clienteDatos[6] = (cli.getActivo().equals(1)) ? "ACTIVO" : "INACTIVO";
            clienteDatos[7] = cli.getDireccion();
            clienteDatos[8] = cli.getPermitirDeuda().equalsIgnoreCase("S") ? "Sí" : "No";
            clienteDatos[9] = calcularTotalAbono(cli.getId());
            defaultTableModel.addRow(clienteDatos);
        }
    }

    private void vaciarTabla() {
        defaultTableModel.setRowCount(0);
    }

    private void inputDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDireccionActionPerformed

    private void jComboBoxPermitirDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPermitirDeudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPermitirDeudaActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int fila = tablaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Cliente no seleccionado");
        } else {
            Long id = Long.valueOf((String) tablaClientes.getValueAt(fila, 3));
            cliente = getCliente(id);
            inputNombre.setText(cliente.getNombre());
            inputDireccion.setText(cliente.getDireccion());
            inputTelefono.setText(cliente.getTelefono());
            inputIdentificacion.setText(cliente.getIdentificacion());
            jcomboxTipoID.setSelectedItem(cliente.getTipoIdentificacion());
            actualizar = true;
            btnCrearActualizar.setText("Actualizar");
            habilitarBotonEliminar();
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

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
            vaciarTabla();
            llenarDatos(clientes);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        inputBuscar.setText("");
        llenarTabla();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        verificarSeleccionCliente();

        // TODO add your handling code here:
        cliente.setActivo(0);
        controladorCliente.eliminar(cliente.getId());
        limpiarCampos();
        llenarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiarCampos();
        deshabilitarBotonEliminar();
        btnCrearActualizar.setText("Guardar");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        try {

            verificarCampos();

            Cliente cliente = controladorCliente.existePorId(Long.valueOf(inputIdentificacion.getText()));

            if (!actualizar && cliente != null && Objects.equals(cliente.getIdentificacion(), inputIdentificacion.getText())) {
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
                cliente.setPermitirDeuda(jComboBoxPermitirDeuda.getSelectedItem().toString().equalsIgnoreCase("Sí") ? "S"  : "N");
                controladorCliente.actualizar(cliente);
                btnCrearActualizar.setText("Guardar");
                deshabilitarBotonEliminar();
                limpiarCampos();
                llenarTabla();

                JOptionPane.showMessageDialog(null, "Se ha actualizado el registro");
            } else { // Crear

                cliente.setNombre(inputNombre.getText());
                cliente.setTelefono(inputTelefono.getText());
                cliente.setIdentificacion(inputIdentificacion.getText());
                cliente.setTipoIdentificacion(tipoDocumento.toUpperCase());
                cliente.setTipoUsuario(tipoUsuario.toUpperCase());
                cliente.setActivo(activo);
                cliente.setDireccion(inputDireccion.getText());
                cliente.setPermitirDeuda(jComboBoxPermitirDeuda.getSelectedItem().toString().equalsIgnoreCase("Sí") ? "S"  : "N");
                
                controladorCliente.crear(cliente);
                llenarTabla();
                limpiarCampos();
                deshabilitarBotonEliminar();

                JOptionPane.showMessageDialog(null, "Se ha guardado el registro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

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

    private void verificarSiEsDigito(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    private Cliente getCliente(Long id) {
        return controladorCliente.existePorId(id);
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
            new bb_AdminGestClientes().setVisible(true);
        });
    }

    private List<Deuda> getDeudas(Long idCliente) {
        return controladorDeuda.obtenerDeudas(idCliente);
    }

    private void calcularTotalDeuda(List<Deuda> deudas) {
        for (Deuda deuda : deudas) {
            if (deuda.getAbonoDeuda().contains("D")) {
                totalDeudas = totalDeudas.add(deuda.getTodalDeuda());
            }
        }

    }

    private String calcularTotalAbono(Long idCliente) {
        resetDeudaAbono();
        List<Deuda> deudas = getDeudas(idCliente);
        calcularTotalDeuda(deudas);
        for (Deuda deuda : deudas) {
            if (deuda.getAbonoDeuda().contains("A")) {
                totalAbono = totalAbono.add(deuda.getTodalDeuda());
            }
        }
        totalDeudas = totalDeudas.subtract(totalAbono);
        return totalDeudas.toString();
    }

    private void resetDeudaAbono() {
        totalAbono = BigDecimal.ZERO;
        totalDeudas = BigDecimal.ZERO;
    }

    private void limpiarCampos() {
        inputNombre.setText("");
        inputIdentificacion.setText("");
        inputTelefono.setText("");
        inputDireccion.setText("");
        actualizar = false;
        cliente = new Cliente();
    }
    
    private void habilitarBotonEliminar(){
        btnEliminar.setEnabled(true);
    }
    
    private void deshabilitarBotonEliminar(){
        btnEliminar.setEnabled(false);
    }
    

    private void verificarSeleccionCliente() {
        if (cliente == null || cliente.getId() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario ");
            return;
        }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVerMas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inputBuscar;
    private javax.swing.JTextField inputDireccion;
    private javax.swing.JTextField inputIdentificacion;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBoxOrdenar;
    private javax.swing.JComboBox<String> jComboBoxPermitirDeuda;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcomboxTipoID;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
