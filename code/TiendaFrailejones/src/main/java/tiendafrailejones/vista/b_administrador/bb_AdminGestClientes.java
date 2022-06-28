package tiendafrailejones.vista.b_administrador;

import com.formdev.flatlaf.FlatLightLaf;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import tiendafrailejones.utils.ExportToExcel;
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
        jComboBoxPermitirDeuda = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
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
        bntVerMas = new javax.swing.JButton();
        btnExportExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel_LogoW = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FraileStore");
        setBackground(new java.awt.Color(209, 217, 180));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("FraileStore"); // NOI18N
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Información de Cliente"));

        inputNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Nombre Completo");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Tipo de Documento");

        inputIdentificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Número de Documento");

        inputTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Telefono");

        jcomboxTipoID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcomboxTipoID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CÉDULA", "CÉDULA DE EXTRANJERIA", "PASAPORTE" }));

        inputDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDireccionActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("Dirección");

        jComboBoxPermitirDeuda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxPermitirDeuda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        jComboBoxPermitirDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPermitirDeudaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Permitir Deuda");

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCrearActualizar.setBackground(new java.awt.Color(51, 153, 0));
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jcomboxTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                            .addComponent(inputIdentificacion)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(inputTelefono)
                            .addComponent(jLabel8)
                            .addComponent(inputDireccion)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxPermitirDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCrearActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcomboxTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPermitirDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(btnCrearActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
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

        jComboBoxOrdenar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenar por nombre Ascendete", "Ordenar por nombre Descendente" }));
        jComboBoxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdenarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnQuitar.setBackground(new java.awt.Color(255, 204, 0));
        btnQuitar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("Quitar filtros");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        bntVerMas.setBackground(new java.awt.Color(51, 153, 255));
        bntVerMas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntVerMas.setForeground(new java.awt.Color(255, 255, 255));
        bntVerMas.setText("Ver mas");
        bntVerMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVerMasActionPerformed(evt);
            }
        });

        btnExportExcel.setBackground(new java.awt.Color(51, 153, 255));
        btnExportExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExportExcel.setText("Exportar excel");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnQuitar))
                            .addComponent(jLabel6)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(12, 91, 99));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 100));

        jButton6.setText("Volver");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVerMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVerMasActionPerformed
        if (isClienteSeleccionado()) {
            showDialog("Seleccione un cliente primero");
        } else {
            usuarioNoHabilitadoParaDeuda();
        }
    }//GEN-LAST:event_bntVerMasActionPerformed

    private void usuarioNoHabilitadoParaDeuda() {

        bba_VerMasCliente adminGestClientsDeuda = new bba_VerMasCliente();
        adminGestClientsDeuda.setVisible(true);
        adminGestClientsDeuda.setCliente(cliente);
        this.dispose();

    }

    private boolean isClienteSeleccionado() {
        return cliente.getId() == null;
    }

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }


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
            jComboBoxPermitirDeuda.setSelectedItem(cliente.getPermitirDeuda().equalsIgnoreCase("S") ? "Sí" : "No");
            actualizar = true;
            inputIdentificacion.setEnabled(false);
            jcomboxTipoID.setEnabled(false);
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
        inputIdentificacion.setEnabled(true);
        jcomboxTipoID.setEnabled(true);
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
                cliente.setPermitirDeuda(jComboBoxPermitirDeuda.getSelectedItem().toString().equalsIgnoreCase("Sí") ? "S" : "N");
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
                cliente.setPermitirDeuda(jComboBoxPermitirDeuda.getSelectedItem().toString().equalsIgnoreCase("Sí") ? "S" : "N");

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

    private void inputIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdentificacionActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        ExportToExcel.export(defaultTableModel);
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        b_Menu adminMenu = new b_Menu();
        adminMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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

    private void habilitarBotonEliminar() {
        btnEliminar.setEnabled(true);
    }

    private void deshabilitarBotonEliminar() {
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
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnQuitar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inputBuscar;
    private javax.swing.JTextField inputDireccion;
    private javax.swing.JTextField inputIdentificacion;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBoxOrdenar;
    private javax.swing.JComboBox<String> jComboBoxPermitirDeuda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_LogoW;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcomboxTipoID;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
