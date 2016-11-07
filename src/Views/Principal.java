package Views;

import Controllers.cContacto;
import Models.mContacto;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Principal extends javax.swing.JFrame {
    
    public Principal() {
        initComponents();
        //Colocar favicon
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/favicon.png"));
        setIconImage(icon);
        
        //Mostrar datos en la tabla de contacto
        listar("");
        
        //Botones inhabilitados
        inhabilitar();
        btnBuscar.setEnabled(false);
        btnBackup.setEnabled(false);
        
        //Imagenes desactivadas
        imageGrupo.setEnabled(false);
        imageTelefono.setEnabled(false);
        imageEmail.setEnabled(false);
    }
    
    public void inhabilitar() {
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void habilitar() {
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    
    public void listar(String buscar) {
        try {
            DefaultTableModel modelo;
            mContacto func = new mContacto();
            modelo = func.listar(buscar);

            tblContactos.setModel(modelo);
            
            //Cabecera centrada
            TableCellRenderer rendererFromHeader = tblContactos.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) rendererFromHeader;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            
            //Ajustar ancho de columnas
            TableColumnModel columnModel = tblContactos.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(5);
            columnModel.getColumn(1).setPreferredWidth(150);
            columnModel.getColumn(2).setPreferredWidth(150);
            columnModel.getColumn(3).setPreferredWidth(70);
            columnModel.getColumn(4).setPreferredWidth(70);
            columnModel.getColumn(5).setPreferredWidth(70);
            columnModel.getColumn(6).setPreferredWidth(200);
            columnModel.getColumn(7).setPreferredWidth(200);
            columnModel.getColumn(8).setPreferredWidth(50);
            
            lblTotalRegistros.setText("Total Registros: " + Integer.toString(func.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }    
    
    public void listarGrupo(String buscar) {
        try {
            DefaultTableModel modelo;
            mContacto func = new mContacto();
            modelo = func.listarGrupo(buscar);

            tblContactos.setModel(modelo);
            
            //Cabecera centrada
            TableCellRenderer rendererFromHeader = tblContactos.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) rendererFromHeader;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            
            //Ajustar ancho de columnas
            TableColumnModel columnModel = tblContactos.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(5);
            columnModel.getColumn(1).setPreferredWidth(150);
            columnModel.getColumn(2).setPreferredWidth(150);
            columnModel.getColumn(3).setPreferredWidth(70);
            columnModel.getColumn(4).setPreferredWidth(70);
            columnModel.getColumn(5).setPreferredWidth(70);
            columnModel.getColumn(6).setPreferredWidth(200);
            columnModel.getColumn(7).setPreferredWidth(200);
            columnModel.getColumn(8).setPreferredWidth(50);
            
            lblTotalRegistros.setText("Total Registros: " + Integer.toString(func.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }    
    
    public void backup() {
        int resp;
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int annio = calendar.get(Calendar.YEAR);

        JFileChooser seleccion = new JFileChooser();
        resp = seleccion.showSaveDialog(this);

        if (resp == JFileChooser.APPROVE_OPTION) {
            try {
                Runtime runtime = Runtime.getRuntime();
                File archivo = new File(String.valueOf(seleccion.getSelectedFile().toString()) + "_" + dia + "-" + mes + "-" + annio + ".sql");
                InputStreamReader irs;
                BufferedReader br;

                try (FileWriter fw = new FileWriter(archivo)) {
                    Process child = runtime.exec("mysqldump --user=root --password=yasme123 agenda -B > ");
                    irs = new InputStreamReader(child.getInputStream());
                    br = new BufferedReader(irs);
                    String line;
                    
                    while ((line = br.readLine()) != null) {
                        fw.write(line + "\n");
                    }
                }
                irs.close();
                br.close();
                JOptionPane.showMessageDialog(rootPane, "Copia de Seguridad creada satisfactoriamente");

            } catch (IOException | HeadlessException ex) {
            }

        } else if (resp == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(rootPane, "Ha sido cancelada la operación");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        acerca = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        NuevoContacto = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cboGrupo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JLabel();
        btnCrear = new javax.swing.JLabel();
        EditarContacto = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtNombreEditar = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtApellidoEditar = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtAliasEditar = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtTelefono1Editar = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtTelefono2Editar = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtEmail1Editar = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtEmail2Editar = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cboGrupoEditar = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        btnCancelarEditar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JLabel();
        lblIdContactoEditar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JLabel();
        btnAcerca = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContactos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblIdContacto = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblAlias = new javax.swing.JLabel();
        imageTelefono = new javax.swing.JLabel();
        lblTelefono1 = new javax.swing.JLabel();
        imageEmail = new javax.swing.JLabel();
        lblEmail1 = new javax.swing.JLabel();
        lblEmail2 = new javax.swing.JLabel();
        imageGrupo = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();
        lblTelefono2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        cboGrupoBuscar = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        btnRecargar = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btnBackup = new javax.swing.JButton();
        box = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();

        acerca.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        acerca.setTitle("Acerca de");
        acerca.getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/favicon.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setText("Agenda Personal");

        jLabel15.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(95, 95, 95));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Ver. 1.0");

        jLabel16.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(78, 78, 78));
        jLabel16.setText("Desarrollado por: Ing. José A. Méndez S.");

        jLabel17.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(95, 95, 95));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(67, 160, 238));
        jLabel18.setText("www.alodor.com.ve");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addGap(125, 125, 125)))
                        .addComponent(jLabel17)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel17))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );

        acerca.getContentPane().add(jPanel4);

        NuevoContacto.setTitle("Nuevo Contacto");

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nuevo Contacto");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre");

        txtNombre.setBackground(new java.awt.Color(254, 254, 254));
        txtNombre.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(143, 143, 143));
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtNombre.setCaretColor(new java.awt.Color(67, 160, 238));
        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombre.setMinimumSize(new java.awt.Dimension(16, 35));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Grupo");

        txtApellido.setBackground(new java.awt.Color(254, 254, 254));
        txtApellido.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(143, 143, 143));
        txtApellido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtApellido.setCaretColor(new java.awt.Color(67, 160, 238));
        txtApellido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtApellido.setMinimumSize(new java.awt.Dimension(16, 35));
        txtApellido.setPreferredSize(new java.awt.Dimension(16, 35));
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Alías");

        txtAlias.setBackground(new java.awt.Color(254, 254, 254));
        txtAlias.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtAlias.setForeground(new java.awt.Color(143, 143, 143));
        txtAlias.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtAlias.setCaretColor(new java.awt.Color(67, 160, 238));
        txtAlias.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAlias.setMinimumSize(new java.awt.Dimension(16, 35));
        txtAlias.setPreferredSize(new java.awt.Dimension(16, 35));
        txtAlias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAliasKeyTyped(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Teléfono 1");

        txtTelefono1.setBackground(new java.awt.Color(254, 254, 254));
        txtTelefono1.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtTelefono1.setForeground(new java.awt.Color(143, 143, 143));
        txtTelefono1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtTelefono1.setCaretColor(new java.awt.Color(67, 160, 238));
        txtTelefono1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTelefono1.setMinimumSize(new java.awt.Dimension(16, 35));
        txtTelefono1.setPreferredSize(new java.awt.Dimension(16, 35));
        txtTelefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono1KeyTyped(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Teléfono 2");

        txtTelefono2.setBackground(new java.awt.Color(254, 254, 254));
        txtTelefono2.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtTelefono2.setForeground(new java.awt.Color(143, 143, 143));
        txtTelefono2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtTelefono2.setCaretColor(new java.awt.Color(67, 160, 238));
        txtTelefono2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTelefono2.setMinimumSize(new java.awt.Dimension(16, 35));
        txtTelefono2.setPreferredSize(new java.awt.Dimension(16, 35));
        txtTelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono2KeyTyped(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Email 1");

        txtEmail1.setBackground(new java.awt.Color(254, 254, 254));
        txtEmail1.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtEmail1.setForeground(new java.awt.Color(143, 143, 143));
        txtEmail1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtEmail1.setCaretColor(new java.awt.Color(67, 160, 238));
        txtEmail1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail1.setMinimumSize(new java.awt.Dimension(16, 35));
        txtEmail1.setPreferredSize(new java.awt.Dimension(16, 35));
        txtEmail1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmail1KeyTyped(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Email 2");

        txtEmail2.setBackground(new java.awt.Color(254, 254, 254));
        txtEmail2.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtEmail2.setForeground(new java.awt.Color(143, 143, 143));
        txtEmail2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtEmail2.setCaretColor(new java.awt.Color(67, 160, 238));
        txtEmail2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail2.setMinimumSize(new java.awt.Dimension(16, 35));
        txtEmail2.setPreferredSize(new java.awt.Dimension(16, 35));
        txtEmail2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmail2KeyTyped(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/phone.png"))); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/envelope.png"))); // NOI18N

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Apellido");

        cboGrupo.setBackground(new java.awt.Color(67, 160, 238));
        cboGrupo.setForeground(new java.awt.Color(67, 160, 238));
        cboGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Amigos", "Clientes", "Conocidos", "Estudios", "Familia", "Trabajo", "Vecinos", "Otros" }));
        cboGrupo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        cboGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel6.setBackground(new java.awt.Color(215, 221, 228));

        btnCancelar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(67, 160, 238));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setText("CANCELAR");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnCrear.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(67, 160, 238));
        btnCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrear.setText("CREAR");
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtAlias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboGrupo, 0, 198, Short.MAX_VALUE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAlias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(51, 51, 51))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout NuevoContactoLayout = new javax.swing.GroupLayout(NuevoContacto.getContentPane());
        NuevoContacto.getContentPane().setLayout(NuevoContactoLayout);
        NuevoContactoLayout.setHorizontalGroup(
            NuevoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        NuevoContactoLayout.setVerticalGroup(
            NuevoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoContactoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EditarContacto.setTitle("Editar Contacto");

        jPanel9.setBackground(new java.awt.Color(254, 254, 254));

        jLabel35.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(1, 1, 1));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Editar Contacto");

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Nombre");

        txtNombreEditar.setBackground(new java.awt.Color(254, 254, 254));
        txtNombreEditar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtNombreEditar.setForeground(new java.awt.Color(143, 143, 143));
        txtNombreEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtNombreEditar.setCaretColor(new java.awt.Color(67, 160, 238));
        txtNombreEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreEditar.setMinimumSize(new java.awt.Dimension(16, 35));
        txtNombreEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreEditarKeyTyped(evt);
            }
        });

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Grupo");

        txtApellidoEditar.setBackground(new java.awt.Color(254, 254, 254));
        txtApellidoEditar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtApellidoEditar.setForeground(new java.awt.Color(143, 143, 143));
        txtApellidoEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtApellidoEditar.setCaretColor(new java.awt.Color(67, 160, 238));
        txtApellidoEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtApellidoEditar.setMinimumSize(new java.awt.Dimension(16, 35));
        txtApellidoEditar.setPreferredSize(new java.awt.Dimension(16, 35));
        txtApellidoEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoEditarKeyTyped(evt);
            }
        });

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Alías");

        txtAliasEditar.setBackground(new java.awt.Color(254, 254, 254));
        txtAliasEditar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtAliasEditar.setForeground(new java.awt.Color(143, 143, 143));
        txtAliasEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtAliasEditar.setCaretColor(new java.awt.Color(67, 160, 238));
        txtAliasEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAliasEditar.setMinimumSize(new java.awt.Dimension(16, 35));
        txtAliasEditar.setPreferredSize(new java.awt.Dimension(16, 35));
        txtAliasEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAliasEditarKeyTyped(evt);
            }
        });

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Teléfono 1");

        txtTelefono1Editar.setBackground(new java.awt.Color(254, 254, 254));
        txtTelefono1Editar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtTelefono1Editar.setForeground(new java.awt.Color(143, 143, 143));
        txtTelefono1Editar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtTelefono1Editar.setCaretColor(new java.awt.Color(67, 160, 238));
        txtTelefono1Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTelefono1Editar.setMinimumSize(new java.awt.Dimension(16, 35));
        txtTelefono1Editar.setPreferredSize(new java.awt.Dimension(16, 35));
        txtTelefono1Editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono1EditarKeyTyped(evt);
            }
        });

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Teléfono 2");

        txtTelefono2Editar.setBackground(new java.awt.Color(254, 254, 254));
        txtTelefono2Editar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtTelefono2Editar.setForeground(new java.awt.Color(143, 143, 143));
        txtTelefono2Editar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtTelefono2Editar.setCaretColor(new java.awt.Color(67, 160, 238));
        txtTelefono2Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTelefono2Editar.setMinimumSize(new java.awt.Dimension(16, 35));
        txtTelefono2Editar.setPreferredSize(new java.awt.Dimension(16, 35));
        txtTelefono2Editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono2EditarKeyTyped(evt);
            }
        });

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("Email 1");

        txtEmail1Editar.setBackground(new java.awt.Color(254, 254, 254));
        txtEmail1Editar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtEmail1Editar.setForeground(new java.awt.Color(143, 143, 143));
        txtEmail1Editar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtEmail1Editar.setCaretColor(new java.awt.Color(67, 160, 238));
        txtEmail1Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail1Editar.setMinimumSize(new java.awt.Dimension(16, 35));
        txtEmail1Editar.setPreferredSize(new java.awt.Dimension(16, 35));
        txtEmail1Editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmail1EditarKeyTyped(evt);
            }
        });

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("Email 2");

        txtEmail2Editar.setBackground(new java.awt.Color(254, 254, 254));
        txtEmail2Editar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtEmail2Editar.setForeground(new java.awt.Color(143, 143, 143));
        txtEmail2Editar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtEmail2Editar.setCaretColor(new java.awt.Color(67, 160, 238));
        txtEmail2Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail2Editar.setMinimumSize(new java.awt.Dimension(16, 35));
        txtEmail2Editar.setPreferredSize(new java.awt.Dimension(16, 35));
        txtEmail2Editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmail2EditarKeyTyped(evt);
            }
        });

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/phone.png"))); // NOI18N

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/envelope.png"))); // NOI18N

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Apellido");

        cboGrupoEditar.setBackground(new java.awt.Color(67, 160, 238));
        cboGrupoEditar.setForeground(new java.awt.Color(67, 160, 238));
        cboGrupoEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Amigos", "Clientes", "Conocidos", "Estudios", "Familia", "Trabajo", "Vecinos", "Otros" }));
        cboGrupoEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        cboGrupoEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel11.setBackground(new java.awt.Color(215, 221, 228));

        btnCancelarEditar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnCancelarEditar.setForeground(new java.awt.Color(67, 160, 238));
        btnCancelarEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelarEditar.setText("CANCELAR");
        btnCancelarEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarEditarMouseClicked(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(67, 160, 238));
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setText("ACEPTAR");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(btnCancelarEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblIdContactoEditar.setBackground(new java.awt.Color(254, 254, 254));
        lblIdContactoEditar.setFont(new java.awt.Font("Cantarell", 1, 13)); // NOI18N
        lblIdContactoEditar.setForeground(new java.awt.Color(254, 254, 254));
        lblIdContactoEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTelefono1Editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtAliasEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail1Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono2Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail2Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboGrupoEditar, 0, 198, Short.MAX_VALUE)
                            .addComponent(txtApellidoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblIdContactoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdContactoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAliasEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboGrupoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(51, 51, 51))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTelefono2Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono1Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail1Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail2Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout EditarContactoLayout = new javax.swing.GroupLayout(EditarContacto.getContentPane());
        EditarContacto.getContentPane().setLayout(EditarContactoLayout);
        EditarContactoLayout.setHorizontalGroup(
            EditarContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        EditarContactoLayout.setVerticalGroup(
            EditarContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditarContactoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Personal");
        setPreferredSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(215, 221, 228));

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book.png"))); // NOI18N
        jLabel2.setText("Agenda Personal");

        btnNuevo.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnAcerca.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnAcerca.setForeground(new java.awt.Color(67, 160, 238));
        btnAcerca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAcerca.setText("Acerca de");
        btnAcerca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcerca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAcercaMouseClicked(evt);
            }
        });

        lblTotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalRegistros.setText("Registros");

        tblContactos.setBorder(null);
        tblContactos.setForeground(new java.awt.Color(78, 143, 207));
        tblContactos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblContactos.setSelectionBackground(new java.awt.Color(67, 160, 238));
        tblContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContactosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContactos);

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)), "Información del Contacto"));

        lblIdContacto.setBackground(new java.awt.Color(254, 254, 254));
        lblIdContacto.setFont(new java.awt.Font("Cantarell", 1, 13)); // NOI18N
        lblIdContacto.setForeground(new java.awt.Color(67, 160, 238));
        lblIdContacto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblNombre.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblAlias.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblAlias.setForeground(new java.awt.Color(67, 160, 238));
        lblAlias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        imageTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/phone.png"))); // NOI18N

        lblTelefono1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblTelefono1.setForeground(new java.awt.Color(143, 143, 143));
        lblTelefono1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        imageEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/envelope.png"))); // NOI18N

        lblEmail1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblEmail1.setForeground(new java.awt.Color(143, 143, 143));
        lblEmail1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblEmail2.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblEmail2.setForeground(new java.awt.Color(143, 143, 143));
        lblEmail2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        imageGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bubbles-alt.png"))); // NOI18N

        lblGrupo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblGrupo.setForeground(new java.awt.Color(143, 143, 143));
        lblGrupo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblTelefono2.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblTelefono2.setForeground(new java.awt.Color(143, 143, 143));
        lblTelefono2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 81, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblIdContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(imageEmail)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblEmail2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(imageTelefono)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(imageGrupo)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(215, 215, 215)))
                                .addGap(66, 66, 66))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAlias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIdContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageGrupo)
                    .addComponent(lblGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageTelefono)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(imageEmail)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnEliminar.setBackground(new java.awt.Color(254, 254, 254));
        btnEliminar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(67, 160, 238));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        btnEliminar.setBorderPainted(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(254, 254, 254));
        btnEditar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(67, 160, 238));
        btnEditar.setText("EDITAR");
        btnEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(254, 254, 254));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)), "Buscar Contacto"));

        btnBuscar.setBackground(new java.awt.Color(254, 254, 254));
        btnBuscar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(67, 160, 238));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setBackground(new java.awt.Color(254, 254, 254));
        txtBuscar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(143, 143, 143));
        txtBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 1, true));
        txtBuscar.setCaretColor(new java.awt.Color(67, 160, 238));
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.setMinimumSize(new java.awt.Dimension(16, 35));
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Cantarell", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(67, 160, 238));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Listar contactos por grupo");

        cboGrupoBuscar.setBackground(new java.awt.Color(67, 160, 238));
        cboGrupoBuscar.setForeground(new java.awt.Color(67, 160, 238));
        cboGrupoBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Amigos", "Clientes", "Conocidos", "Estudios", "Familia", "Trabajo", "Vecinos", "Otros" }));
        cboGrupoBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        cboGrupoBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboGrupoBuscar.setVerifyInputWhenFocusTarget(false);
        cboGrupoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGrupoBuscarActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Cantarell", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(67, 160, 238));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Ingrese dato de contacto");

        btnRecargar.setBackground(new java.awt.Color(254, 254, 254));
        btnRecargar.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnRecargar.setForeground(new java.awt.Color(67, 160, 238));
        btnRecargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sign-sync.png"))); // NOI18N
        btnRecargar.setText("MOSTRAR CONTACTOS");
        btnRecargar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        btnRecargar.setBorderPainted(false);
        btnRecargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnRecargar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboGrupoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGrupoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(254, 254, 254));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)), "Copia de Seguridad"));

        btnBackup.setBackground(new java.awt.Color(254, 254, 254));
        btnBackup.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        btnBackup.setForeground(new java.awt.Color(67, 160, 238));
        btnBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/carton.png"))); // NOI18N
        btnBackup.setText("BACKUP");
        btnBackup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        btnBackup.setBorderPainted(false);
        btnBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackupMouseClicked(evt);
            }
        });
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });

        box.setText("Marque la casilla para desbloquear el botón");
        box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Cantarell", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(67, 160, 238));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Realizar una copia de seguridad ahora");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(box)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBackup, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9)
                        .addComponent(box)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnAcerca, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAcerca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI("http://www.alodor.com.ve"));
                }
            }
        } catch (URISyntaxException | IOException e) {
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        inhabilitar();
        
        //Seteando los campos
        txtNombre.setText("");
        txtApellido.setText("");
        txtAlias.setText("");
        txtTelefono1.setText("");
        txtTelefono2.setText("");
        txtEmail1.setText("");
        txtEmail2.setText("");
        cboGrupo.setSelectedIndex(0);
        
        //Mostrar la ventana nuevo contacto
        NuevoContacto.pack();
        NuevoContacto.setModal(true);
        NuevoContacto.setLocationRelativeTo(null);
        NuevoContacto.setVisible(true);
        
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        acerca.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void btnAcercaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcercaMouseClicked
        //Codigo para mostrar la ventana acerca de la aplicacion
        acerca.pack();
        acerca.setModal(true);
        acerca.setLocationRelativeTo(null);
        acerca.setVisible(true);
    }//GEN-LAST:event_btnAcercaMouseClicked

    private void tblContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactosMouseClicked
        //Desabilitar boton buscar
        btnBuscar.setEnabled(false);
        
        habilitar();
        imageGrupo.setEnabled(true);
        imageTelefono.setEnabled(true);
        imageEmail.setEnabled(true);
        
        //Selecciona fila de la tabla
        int fila = tblContactos.getSelectedRow();
        
        lblIdContacto.setText(tblContactos.getValueAt(fila, 0).toString());
        lblNombre.setText(tblContactos.getValueAt(fila, 1).toString() + " " +tblContactos.getValueAt(fila, 2).toString());
        lblAlias.setText(tblContactos.getValueAt(fila, 3).toString());        
        lblTelefono1.setText(tblContactos.getValueAt(fila, 4).toString());
        lblTelefono2.setText(tblContactos.getValueAt(fila, 5).toString());
        lblEmail1.setText(tblContactos.getValueAt(fila, 6).toString());
        lblEmail2.setText(tblContactos.getValueAt(fila, 7).toString());
        lblGrupo.setText(tblContactos.getValueAt(fila, 8).toString());
    }//GEN-LAST:event_tblContactosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        inhabilitar();
        
        //Mostrar la ventana editar contacto
        EditarContacto.pack();
        EditarContacto.setModal(true);
        EditarContacto.setLocationRelativeTo(null);
        
        //Pasar datos de la fila seleccionada a los campos de la ventana editar
        int fila = tblContactos.getSelectedRow();
        
        lblIdContactoEditar.setText(tblContactos.getValueAt(fila, 0).toString());
        txtNombreEditar.setText(tblContactos.getValueAt(fila, 1).toString());
        txtApellidoEditar.setText(tblContactos.getValueAt(fila, 2).toString());
        txtAliasEditar.setText(tblContactos.getValueAt(fila, 3).toString());
        txtTelefono1Editar.setText(tblContactos.getValueAt(fila, 4).toString());
        txtTelefono2Editar.setText(tblContactos.getValueAt(fila, 5).toString());
        txtEmail1Editar.setText(tblContactos.getValueAt(fila, 6).toString());
        txtEmail2Editar.setText(tblContactos.getValueAt(fila, 7).toString());
        
        EditarContacto.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if (!lblIdContacto.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro de eliminar este contacto?", "Mensaje", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE);

            if (confirmacion == 0) {
                mContacto func = new mContacto();
                cContacto dts = new cContacto();

                dts.setId_contacto(Integer.parseInt(lblIdContacto.getText()));
                func.eliminar(dts);
                listar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        NuevoContacto.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        //Validacion de campos requeridos
        if (txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Nombre");
            txtNombre.requestFocus();
            return;
        }

        if (txtTelefono1.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Número Teléfonico");
            txtTelefono1.requestFocus();
            return;
        }

        if (cboGrupo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un Grupo");
            cboGrupo.requestFocus();
            return;
        }

        if (!(txtNombre.getText().length() == 0) && !(txtTelefono1.getText().length() == 0) && !(cboGrupo.getSelectedIndex() == 0)) {
            cContacto dts = new cContacto();
            mContacto func = new mContacto();

            dts.setNombre(txtNombre.getText());
            dts.setApellido(txtApellido.getText());
            dts.setAlias(txtAlias.getText());
            dts.setTelefono1(txtTelefono1.getText());
            dts.setTelefono2(txtTelefono2.getText());
            dts.setEmail1(txtEmail1.getText());
            dts.setEmail2(txtEmail2.getText());

            int seleccionado = cboGrupo.getSelectedIndex();
            dts.setGrupo((String) cboGrupo.getItemAt(seleccionado));

            //Se utiliza la funcion crear para registrar el contacto
            func.crear(dts);
            JOptionPane.showMessageDialog(rootPane, "Contacto registrado satisfactoriamente");
            listar("");
            NuevoContacto.dispose();
        }
    }//GEN-LAST:event_btnCrearMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        //Validar que solo se inserte letras
        char caracter = evt.getKeyChar();
        
        if(Character.isDigit(caracter)) {
            evt.consume();
        }

        //Limitar el número de carácteres
        int limit = 30;
        
        if(txtNombre.getText().length() == limit) {
            evt.consume();
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        //Validar que solo se inserte letras
        char caracter = evt.getKeyChar();
        
        if(Character.isDigit(caracter)) {
            evt.consume();
        }

        //Limitar el número de carácteres
        int limit = 30;
        
        if(txtApellido.getText().length() == limit) {
            evt.consume();
            txtApellido.requestFocus();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtAliasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAliasKeyTyped
        //Validar que solo se inserte letras
        char caracter = evt.getKeyChar();
        
        if(Character.isDigit(caracter)) {
            evt.consume();
        }

        //Limitar el número de carácteres
        int limit = 30;
        
        if(txtAlias.getText().length() == limit) {
            evt.consume();
            txtAlias.requestFocus();
        }
    }//GEN-LAST:event_txtAliasKeyTyped

    private void txtTelefono1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono1KeyTyped
        //Validar que solo se inserte números
        char caracter = evt.getKeyChar();
        
        if(Character.isLetter(caracter)) {
            evt.consume();
        }

        //Limitar el número de carácteres
        int limit = 11;
        
        if(txtTelefono1.getText().length() == limit) {
            evt.consume();
            txtTelefono1.requestFocus();
        }
    }//GEN-LAST:event_txtTelefono1KeyTyped

    private void txtTelefono2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono2KeyTyped
        //Validar que solo se inserte números
        char caracter = evt.getKeyChar();
        
        if(Character.isLetter(caracter)) {
            evt.consume();
        }

        //Limitar el número de carácteres
        int limit = 11;
        
        if(txtTelefono2.getText().length() == limit) {
            evt.consume();
            txtTelefono2.requestFocus();
        }
    }//GEN-LAST:event_txtTelefono2KeyTyped

    private void txtEmail1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmail1KeyTyped
        //Limitar el número de carácteres
        int limit = 45;
        
        if(txtEmail1.getText().length() == limit) {
            evt.consume();
            txtEmail1.requestFocus();
        }
    }//GEN-LAST:event_txtEmail1KeyTyped

    private void txtEmail2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmail2KeyTyped
        //Limitar el número de carácteres
        int limit = 45;
        
        if(txtEmail2.getText().length() == limit) {
            evt.consume();
            txtEmail2.requestFocus();
        }
    }//GEN-LAST:event_txtEmail2KeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        inhabilitar();
        
        if((txtBuscar.getText().length() == 0) && (cboGrupoBuscar.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(rootPane, "Debe introducir información de contacto");
        }
        
        if(!(txtBuscar.getText().length() == 0) && !(cboGrupoBuscar.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(rootPane, "No puede usar ambos métodos de búsqueda a la vez");
        }
        
        if(!(txtBuscar.getText().length() == 0) && (cboGrupoBuscar.getSelectedIndex() == 0)) {
            
            if(tblContactos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(rootPane, "No existen datos para mostrar");
            } else {
                listar(txtBuscar.getText());
            }
            
        }
        
        if((txtBuscar.getText().length() == 0) && !(cboGrupoBuscar.getSelectedIndex() == 0)) {
            if(tblContactos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(rootPane, "No existen datos para mostrar");
            } else {
                int seleccionado = cboGrupoBuscar.getSelectedIndex();
                listarGrupo((String) cboGrupoBuscar.getItemAt(seleccionado));
            }
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        //Activar boton buscar
        btnBuscar.setEnabled(true);
        
        //Realizar consulta al presionar ENTER
        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        //Activar boton buscar
        btnBuscar.setEnabled(true);
        inhabilitar();
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void btnBackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackupMouseClicked

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        backup();
    }//GEN-LAST:event_btnBackupActionPerformed

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
        //Comprobar si el checkbox esta marcado
        if(box.isSelected()) {
            btnBackup.setEnabled(true);
        } else {
            btnBackup.setEnabled(false);
        }
    }//GEN-LAST:event_boxActionPerformed

    private void cboGrupoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGrupoBuscarActionPerformed
         btnBuscar.setEnabled(true);
    }//GEN-LAST:event_cboGrupoBuscarActionPerformed

    private void txtNombreEditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEditarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEditarKeyTyped

    private void txtApellidoEditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoEditarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoEditarKeyTyped

    private void txtAliasEditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAliasEditarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAliasEditarKeyTyped

    private void txtTelefono1EditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono1EditarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono1EditarKeyTyped

    private void txtTelefono2EditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono2EditarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono2EditarKeyTyped

    private void txtEmail1EditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmail1EditarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail1EditarKeyTyped

    private void txtEmail2EditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmail2EditarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail2EditarKeyTyped

    private void btnCancelarEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarEditarMouseClicked
        EditarContacto.dispose();
        habilitar();
    }//GEN-LAST:event_btnCancelarEditarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        //Validacion de campos requeridos
        if (txtNombreEditar.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Nombre");
            txtNombreEditar.requestFocus();
            return;
        }

        if (txtTelefono1Editar.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Número Teléfonico");
            txtTelefono1Editar.requestFocus();
            return;
        }

        if (cboGrupoEditar.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un Grupo");
            cboGrupoEditar.requestFocus();
            return;
        }

        if (!(txtNombreEditar.getText().length() == 0) && !(txtTelefono1Editar.getText().length() == 0) && !(cboGrupoEditar.getSelectedIndex() == 0)) {
            cContacto dts = new cContacto();
            mContacto func = new mContacto();

            dts.setId_contacto(Integer.parseInt(lblIdContactoEditar.getText()));
            dts.setNombre(txtNombreEditar.getText());
            dts.setApellido(txtApellidoEditar.getText());
            dts.setAlias(txtAliasEditar.getText());
            dts.setTelefono1(txtTelefono1Editar.getText());
            dts.setTelefono2(txtTelefono2Editar.getText());
            dts.setEmail1(txtEmail1Editar.getText());
            dts.setEmail2(txtEmail2Editar.getText());
            int seleccionado = cboGrupoEditar.getSelectedIndex();
            dts.setGrupo((String) cboGrupoEditar.getItemAt(seleccionado));

            //Se utiliza la funcion editar para actualizar datos del contacto
            func.editar(dts);
            listar("");
            JOptionPane.showMessageDialog(rootPane, "Datos actualizados satisfactoriamente");
            EditarContacto.dispose();
            inhabilitar();
        }
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        listar("");
    }//GEN-LAST:event_btnRecargarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog EditarContacto;
    private javax.swing.JDialog NuevoContacto;
    private javax.swing.JDialog acerca;
    private javax.swing.JCheckBox box;
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnAcerca;
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnCancelarEditar;
    private javax.swing.JLabel btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel btnNuevo;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JComboBox<String> cboGrupo;
    private javax.swing.JComboBox<String> cboGrupoBuscar;
    private javax.swing.JComboBox<String> cboGrupoEditar;
    private javax.swing.JLabel imageEmail;
    private javax.swing.JLabel imageGrupo;
    private javax.swing.JLabel imageTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlias;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblIdContacto;
    private javax.swing.JLabel lblIdContactoEditar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTelefono2;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tblContactos;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtAliasEditar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEditar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail1Editar;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtEmail2Editar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEditar;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTelefono1Editar;
    private javax.swing.JTextField txtTelefono2;
    private javax.swing.JTextField txtTelefono2Editar;
    // End of variables declaration//GEN-END:variables
}
