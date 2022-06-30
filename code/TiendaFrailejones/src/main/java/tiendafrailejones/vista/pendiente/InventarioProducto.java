package tiendafrailejones.vista.pendiente;

import tiendafrailejones.vista.b_administrador.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Array;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import tiendafrailejones.controlador.ControladorProducto;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Deuda;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.Login;
import tiendafrailejones.modelo.Producto;
import tiendafrailejones.modelo.consultas.ConsultaDeuda;
import tiendafrailejones.modelo.consultas.ConsultaProducto;
import tiendafrailejones.modelo.consultas.ConsultasCliente;
import tiendafrailejones.modelo.consultas.ConsultasEmpleado;
import tiendafrailejones.modelo.consultas.ConsultasLogin;
import tiendafrailejones.utils.ExportToExcel;


public class InventarioProducto extends javax.swing.JFrame {

    //private Empleado empleado = new Empleado();
    //private final ConsultasEmpleado consultasEmpleado = new ConsultasEmpleado();
    //private final ControladorEmpleado controladorEmpleado = new ControladorEmpleado(consultasEmpleado);
    
    private Producto producto = new Producto();
    private final ConsultaProducto consultaProducto =  new ConsultaProducto();
    private final ControladorProducto controladorProducto = new ControladorProducto(consultaProducto);

    //private Login login = new Login();
    //private final ConsultasLogin consultasLogin = new ConsultasLogin();
    //private final ControladorLogin controladorLogin = new ControladorLogin(consultasLogin);

    //private Cliente cliente = new Cliente();
    //private final ConsultasCliente consultasCliente = new ConsultasCliente();
    //private final ControladorCliente controladorCliente = new ControladorCliente(consultasCliente);

    //private ConsultaDeuda consultaDeuda = new ConsultaDeuda();
    //private ControladorDeuda controladorDeuda = new ControladorDeuda(consultaDeuda);

    private boolean actualizar = false;
    private String tipoCategoria;
    private Long categoria = null;
    private String tipoUsuario;
    Calendar fecha = new GregorianCalendar();
    private Integer activo = 1;

    private DefaultTableModel defaultTableModel;
    //private BigDecimal totalDeudas = BigDecimal.ZERO;
    //private BigDecimal totalAbono = BigDecimal.ZERO;

    public InventarioProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        initTable();
        llenarTabla();
        llenarJcombox();
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
        defaultTableModel.addColumn("Categoria");
        defaultTableModel.addColumn("Precio de Compra");
        defaultTableModel.addColumn("Precio de Venta");
        defaultTableModel.addColumn("Cantidad");
        defaultTableModel.addColumn("Marca");
        defaultTableModel.addColumn("Proveedor");
        
        this.tablaProductos.setModel(defaultTableModel);
    }

    private void datosPredeterminados() {
        btnEliminar.setEnabled(false);
        tipoUsuario = "CLIENTE";
    }

    private void llenarTabla() {
        vaciarTabla();
        List<Producto> productos = controladorProducto.obtenerTodosLosProductos();
        llenarDatos(productos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        inputNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputPrecioCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputPrecioVenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcomboxTipoCategoriaId = new javax.swing.JComboBox<>();
        inputNombreProveedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        inputMarca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inputCantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Información del Producto"));

        inputNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Nombre ");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Categoria");

        inputPrecioCompra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPrecioCompraActionPerformed(evt);
            }
        });
        inputPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputPrecioCompraKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Precio de Compra");

        inputPrecioVenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputPrecioVentaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Precio de Venta");

        jcomboxTipoCategoriaId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcomboxTipoCategoriaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jcomboxTipoCategoriaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboxTipoCategoriaIdActionPerformed(evt);
            }
        });

        inputNombreProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNombreProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreProveedorActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("Proveedor");

        btnCrearActualizar.setBackground(new java.awt.Color(51, 153, 0));
        btnCrearActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearActualizar.setForeground(new java.awt.Color(204, 255, 255));
        btnCrearActualizar.setText("Guardar/Actualizar");
        btnCrearActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCategorias.setBackground(new java.awt.Color(51, 51, 255));
        btnCategorias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCategorias.setForeground(new java.awt.Color(204, 255, 255));
        btnCategorias.setText("Categorías");
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });

        inputMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMarcaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Marca");

        inputCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCantidadActionPerformed(evt);
            }
        });
        inputCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputCantidadKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel10.setText("Cantidad");

        btnCancelar.setBackground(new java.awt.Color(204, 153, 0));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(204, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inputPrecioCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(inputPrecioVenta)
                                .addComponent(jLabel8)
                                .addComponent(inputNombreProveedor))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jcomboxTipoCategoriaId, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(inputCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCrearActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcomboxTipoCategoriaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategorias))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(1, 1, 1)
                .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(7, 7, 7)
                .addComponent(inputCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos Registrados"));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Categoria", "Precio de Compra", "Precio de Venta", "Proveedor"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

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

        btnBuscar.setBackground(new java.awt.Color(102, 102, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(204, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnQuitar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Yellow"));
        btnQuitar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(204, 255, 255));
        btnQuitar.setText("Quitar filtros");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        bntVerMas.setBackground(new java.awt.Color(102, 102, 255));
        bntVerMas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntVerMas.setForeground(new java.awt.Color(204, 255, 255));
        bntVerMas.setText("Ver mas");
        bntVerMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVerMasActionPerformed(evt);
            }
        });

        btnExportExcel.setBackground(new java.awt.Color(102, 102, 255));
        btnExportExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportExcel.setForeground(new java.awt.Color(204, 255, 255));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
                .addComponent(jLabel_LogoW, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel_LogoW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVerMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVerMasActionPerformed
        
    }//GEN-LAST:event_bntVerMasActionPerformed

    

  

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }


    private void inputBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBuscarActionPerformed
        //String evento = jComboBoxOrdenar.getSelectedItem().toString();
        //ordenar(evento);
    }//GEN-LAST:event_inputBuscarActionPerformed
/*
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
*/
    private void llenarDatos(List<Producto> productos) {
        for (Producto pro : productos) {
            String[] productoDatos = new String[9];
            productoDatos[0] = String.valueOf(pro.getId());
            productoDatos[1] = pro.getNombre();
            productoDatos[2] = pro.getNombreCategoria();
            productoDatos[3] = String.valueOf(pro.getPrecioCompra());
            productoDatos[4] = String.valueOf(pro.getPrecioVenta());
            productoDatos[5] = String.valueOf(pro.getStock());
            productoDatos[6] = pro.getMarca();
            productoDatos[7] = pro.getNombreProveedor();
            productoDatos[8] =(pro.getActivo().equals(1)) ? "ACTIVO" : "INACTIVO";
            defaultTableModel.addRow(productoDatos);
        }
    }

    private void vaciarTabla() {
        defaultTableModel.setRowCount(0);
    }

    private void inputNombreProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreProveedorActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int fila = tablaProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Cliente no seleccionado");
        } else {
            
            String nombre = String.valueOf(tablaProductos.getValueAt(fila, 1));
            String marca = String.valueOf(tablaProductos.getValueAt(fila, 6));
            producto = getProducto(nombre, marca);
            inputNombre.setText(producto.getNombre());
            inputPrecioCompra.setText(String.valueOf(producto.getPrecioCompra()));
            inputPrecioVenta.setText(String.valueOf(producto.getPrecioVenta()));
            inputNombreProveedor.setText(producto.getNombreProveedor());
            inputMarca.setText(producto.getMarca());
            jcomboxTipoCategoriaId.setSelectedItem(producto.getIdCategoria());
            inputCantidad.setText(String.valueOf(producto.getStock()));
            actualizar = true;
            inputPrecioCompra.setEnabled(false);
            btnCrearActualizar.setText("Actualizar");
            habilitarBotonEliminar();
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (inputBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre marca o categoría");
            return;
        }

        List<Producto> productos = controladorProducto.buscar(inputBuscar.getText());
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay coincidencias");
            return;
        } else {
            vaciarTabla();
            llenarDatos(productos);
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        inputBuscar.setText("");
        llenarTabla();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        try {
            
            System.out.println(fecha.getTime());
            System.out.println("cantidad campo" + Integer.valueOf(inputCantidad.getText()));
            
            verificarCampos();     
            
            Producto prod = controladorProducto.existePorNombre(inputNombre.getText(),inputMarca.getText());
            

            if (!actualizar && prod != null && Objects.equals(prod.getNombre(), inputNombre.getText()) && Objects.equals(prod.getMarca(), inputMarca.getText())) {
                JOptionPane.showMessageDialog(null, "Producto ya existe con ese nombre y marca");
            } else if (producto.getNombre()!= null && actualizar) {  // Actualizar
                categoria = controladorProducto.obtenerCategoriaIdPorNombre((String) jcomboxTipoCategoriaId.getSelectedItem());

                producto.setId(producto.getId());
                producto.setNombre(inputNombre.getText());
                producto.setIdCategoria(controladorProducto.obtenerCategoriaIdPorNombre((String) jcomboxTipoCategoriaId.getSelectedItem()));
                producto.setNombreCategoria((String) jcomboxTipoCategoriaId.getSelectedItem());
                producto.setPrecioCompra(Integer.valueOf(inputPrecioCompra.getText()));
                producto.setPrecioVenta(Integer.valueOf(inputPrecioVenta.getText()));
                producto.setFechaIngreso(fecha.getTime());
                producto.setStock(Integer.valueOf(inputCantidad.getText()));
                producto.setMarca(inputMarca.getText());
                producto.setNombreProveedor(inputNombreProveedor.getText());
              
              
                
                if(((Integer.valueOf(inputCantidad.getText())) == (controladorProducto.obtenerCantidadPorId(producto)) )){
                    System.out.println("Entré al if, campo y base iguales");
                    controladorProducto.actualizar(producto,categoria);
                btnCrearActualizar.setText("Guardar");
                limpiarCampos();
                inputPrecioCompra.setEnabled(true);
                llenarTabla();
                deshabilitarBotonEliminar();
                JOptionPane.showMessageDialog(null, "Se ha actualizado el registro");
                
                }else{
                    System.out.println("estoy al otro lado del al if, campo y base diferentes");
                    controladorProducto.actualizar(producto,categoria);
                controladorProducto.elementosTablaRegistro(producto, categoria);
                btnCrearActualizar.setText("Guardar");
                limpiarCampos();
                inputPrecioCompra.setEnabled(true);
                llenarTabla();
                deshabilitarBotonEliminar();
                JOptionPane.showMessageDialog(null, "Se ha actualizado el registro");
                }
                
            } else { // Crear
                
                System.out.println("CREACIOOOOOOOOOOM");
                categoria = controladorProducto.obtenerCategoriaIdPorNombre((String) jcomboxTipoCategoriaId.getSelectedItem());
                System.out.println(categoria);
                producto.setNombre(inputNombre.getText());
                producto.setIdCategoria(controladorProducto.obtenerCategoriaIdPorNombre((String) jcomboxTipoCategoriaId.getSelectedItem()));
                producto.setNombreCategoria((String) jcomboxTipoCategoriaId.getSelectedItem());
                producto.setPrecioCompra(Integer.valueOf(inputPrecioCompra.getText()));
                producto.setPrecioVenta(Integer.valueOf(inputPrecioVenta.getText()));
                producto.setFechaIngreso(fecha.getTime());
                producto.setStock(Integer.valueOf(inputCantidad.getText()));
                producto.setMarca(inputMarca.getText());
                producto.setNombreProveedor(inputNombreProveedor.getText());
               
                controladorProducto.crear(producto, categoria);
                
                llenarTabla();
                limpiarCampos();
                deshabilitarBotonEliminar();

                JOptionPane.showMessageDialog(null, "Se ha guardado el registro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void inputPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPrecioCompraKeyTyped
        verificarSiEsDigito(evt);
    }//GEN-LAST:event_inputPrecioCompraKeyTyped

    private void inputPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPrecioVentaKeyTyped
        verificarSiEsDigito(evt);
    }//GEN-LAST:event_inputPrecioVentaKeyTyped

    
    private void jComboBoxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdenarActionPerformed
        //String evento = jComboBoxOrdenar.getSelectedItem().toString();
        //ordenar(evento);
    }//GEN-LAST:event_jComboBoxOrdenarActionPerformed

    private void inputPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPrecioCompraActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        ExportToExcel.export(defaultTableModel);
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        b_Menu adminMenu = new b_Menu();
        adminMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jcomboxTipoCategoriaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboxTipoCategoriaIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboxTipoCategoriaIdActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        producto.setActivo(0);
        controladorProducto.eliminar(producto.getId());
        limpiarCampos();
        llenarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        ba_GestionCategorias categoriasMenu = new ba_GestionCategorias();
        categoriasMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void inputMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMarcaActionPerformed

    private void inputCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCantidadActionPerformed
    }//GEN-LAST:event_inputCantidadActionPerformed

    private void inputCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCantidadKeyTyped
    verificarSiEsDigito(evt);
    }//GEN-LAST:event_inputCantidadKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
        deshabilitarBotonEliminar();
        btnCrearActualizar.setText("Guardar");
        inputPrecioCompra.setEnabled(true);
        jcomboxTipoCategoriaId.setEnabled(true);       // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void verificarSiEsDigito(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    private Producto getProducto(String nombre, String marca) {
        return controladorProducto.existePorNombre(nombre, marca);
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
            new InventarioProducto().setVisible(true);
        });
    }
 private void llenarJcombox(){
        List<String> catego = controladorProducto.obtenerTodasLasCategorias();
        
        for(String categoria : catego){
            jcomboxTipoCategoriaId.addItem(categoria);
        }
        
        }


    

    private void limpiarCampos() {
        inputNombre.setText("");
        inputCantidad.setText("");
        inputPrecioCompra.setText("");
        inputMarca.setText("");
       
        inputPrecioVenta.setText("");
        inputNombreProveedor.setText("");
        actualizar = false;
        producto = new Producto();
    }

    private void habilitarBotonEliminar() {
        btnEliminar.setEnabled(true);
    }

    private void deshabilitarBotonEliminar() {
        btnEliminar.setEnabled(false);
    }



    private void verificarCampos() throws Exception {
        if (inputNombre.getText().isEmpty()) {
            throw new Exception("nombre");
        } else if (inputPrecioCompra.getText().isEmpty()) {
            throw new Exception("precioCompra");
        } else if (inputPrecioVenta.getText().isEmpty()) {
            throw new Exception("precioVenta");
        } else if (inputNombreProveedor.getText().isEmpty()) {
            throw new Exception("NombreProveedor");
        }else if (inputCantidad.getText().isEmpty()) {
            throw new Exception("Cantidad");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVerMas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnQuitar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inputBuscar;
    private javax.swing.JTextField inputCantidad;
    private javax.swing.JTextField inputMarca;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputNombreProveedor;
    private javax.swing.JTextField inputPrecioCompra;
    private javax.swing.JTextField inputPrecioVenta;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBoxOrdenar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_LogoW;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcomboxTipoCategoriaId;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables

    private void disposse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
