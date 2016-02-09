/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectopropietarios;


// Importar libreria de itext todo eso
import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author 
 */
public class AlmacenFerreteria extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    // Un Arreglo para Varios Variables 
     double valor = 0;
     int cant = 0;
     double n = 0;
     double subtotal=0;
    // Valor de Productos
     double precioLadrillofarol = 9.50;
     double precioLadrillocaravista = 10.00;
     double precioLadrilloestructural = 4.80;
     double precioCementoblanco40 = 4.60;
     double precioCementoblanco20 = 23.50;
     double precioCementogris = 25.50;
     double precioMastick = 10.00;
     double precioCarreta = 8.35;
     double precioPala = 25.00;
     double precioAzadon = 36.00;
     double precioPica = 50.00;
     double precioMartillo = 1.00;
     double precioBrocha = 2.00;
     double precioPinturasCondor = 4.00;
     double precioPinturasUnidas = 3.00;
     double precioTubosRival = 12.00;
     double precioVarilla12pulagadas = 2.10;
     double precioVarilla14pulagadas = 2.10;
     double precioVarilla18pulagadas = 2.10;
     double precioMarcillaTarro = 5.00;
     
     
     // Variable Nombre
     String nombreProductos;     
     DefaultTableModel modelo;
     // Valor de Nuevo Productos
     String producto;
     double precios=0;
     double posicion = 20;
     double codnew=0;
     
     
    public AlmacenFerreteria() {
        initComponents();
        this.setLocationRelativeTo(null);
       
        // default tabla
        modelo = new DefaultTableModel();
        // Agrega fila
        modelo.addColumn("Nº");
        modelo.addColumn("Cod.");
        modelo.addColumn("Productos");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unit.");
        modelo.addColumn("Importe");
        this.JTableProduct.setModel(modelo);
        
        // CONFIGURAR TMAÑO Y ANCHO DE LA TABLA
        int[] anchos = {37,35,255,65,73,64};
        for(int i = 0; i < JTableProduct.getColumnCount(); i++) {
        JTableProduct.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
        
        // Agrega en JCombox de Productos
        JComboxProducto.addItem("");
        JComboxProducto.addItem("Ladrillo Farol");
        JComboxProducto.addItem("Ladrillo caravista");
        JComboxProducto.addItem("Ladrillo estrucutral");
        JComboxProducto.addItem("Cemento blanco 40kl");
        JComboxProducto.addItem("Cemento blanco 20kl");
        JComboxProducto.addItem("Cemento Gris");
        JComboxProducto.addItem("Mastick (Masilla)");
        JComboxProducto.addItem("Carretilla");
        JComboxProducto.addItem("Pala");
        JComboxProducto.addItem("Azadon");
        JComboxProducto.addItem("Pica");
        JComboxProducto.addItem("Martillo");
        JComboxProducto.addItem("Brocha");
        JComboxProducto.addItem("Pintura Unidas");
        JComboxProducto.addItem("Pintura Condor");
        JComboxProducto.addItem("Tubos Rival");
        JComboxProducto.addItem("Varilla 12 pulgadas");
        JComboxProducto.addItem("Varilla 14 pulgadas");
        JComboxProducto.addItem("Varilla 18 pulgadas");
        JComboxProducto.addItem("Marcilla Tarro");
        
        // Leer la fecha de computador y colocarlo el cuadro de fecha
        //-------------------------------------
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formateador.format(fechaActual);
        jTextFieldFecha.setText(fecha);
        jTextFieldFecha.setEditable(false);
        //-------------------------------------------
        
        
    }
    
    // Parte de Llamada de Ventana de PDF
    private void llamarJDialogPDF() {


        //Centramos nuestro jDialog
        jDialog.setLocation(615,300);//null
        
        //La hacemos modal
        jDialog.setModal(true);
        
        //Establecemos dimensiones.
        jDialog.setMinimumSize(new Dimension(393, 265));
        
        //Establecemos un título para el jDialog
        jDialog.setTitle("Imprimir Factura en PDF");
        
        //La hacemos visible.
        jDialog.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog = new javax.swing.JDialog();
        ubic = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFactura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        JComboxProducto = new javax.swing.JComboBox();
        jTextFieldCodProducto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        xcant = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldNo = new javax.swing.JTextField();
        jTextFieldCant = new javax.swing.JTextField();
        jTextFieldImporte = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableProduct = new javax.swing.JTable();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldImpuesto = new javax.swing.JTextField();
        jTextFieldSubtotal = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Generar PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/acrobat pdf.png"))); // NOI18N

        javax.swing.GroupLayout jDialogLayout = new javax.swing.GroupLayout(jDialog.getContentPane());
        jDialog.getContentPane().setLayout(jDialogLayout);
        jDialogLayout.setHorizontalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton3)
                .addGap(50, 50, 50)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ubic, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(19, 19, 19))
        );
        jDialogLayout.setVerticalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton3)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA FERRETERIA CUEVA ---VERSIÓN 2.0---");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ferreteria Javelar ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DATOS DE VENTA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Valor $");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        jTextFieldFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(jTextFieldFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cliente");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, 20));

        jTextFieldNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Fecha");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, 20));

        jTextFieldFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(jTextFieldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 90, -1));

        JComboxProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JComboxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboxProductoActionPerformed(evt);
            }
        });
        jPanel2.add(JComboxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 170, -1));

        jTextFieldCodProducto.setEditable(false);
        jTextFieldCodProducto.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCodProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodProductoActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 40, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 500, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("No. Fact:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cant.");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jTextFieldValor.setEditable(false);
        jTextFieldValor.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 60, -1));

        xcant.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        xcant.setModel(new javax.swing.SpinnerNumberModel(1, 0, 30, 1));
        xcant.setToolTipText("");
        jPanel2.add(xcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 50, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("COD");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button-add.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setPreferredSize(new java.awt.Dimension(107, 42));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 130, 32));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Productos");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));
        jPanel2.add(jTextFieldNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, -1));
        jPanel2.add(jTextFieldCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 50, -1));
        jPanel2.add(jTextFieldImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 60, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eliminar.png"))); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imagen1.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imagen2.png"))); // NOI18N

        JTableProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTableProduct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(JTableProduct);

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldTotal.setForeground(new java.awt.Color(0, 153, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("IVA 12%");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Total: $");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Subtotal $");

        jTextFieldImpuesto.setEditable(false);
        jTextFieldImpuesto.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldImpuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldImpuesto.setForeground(new java.awt.Color(51, 51, 51));

        jTextFieldSubtotal.setEditable(false);
        jTextFieldSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSubtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/archivo.png"))); // NOI18N
        jMenu1.setText("ARCHIVOS");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document-new (1).png"))); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout (2).png"))); // NOI18N
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ajustes.png"))); // NOI18N
        jMenu2.setText("OPCIONES");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        jMenu5.setText("Cambiar Precios");

        jMenuItem8.setText("Ladrillo Farol");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem19.setText("Ladrillo caravista");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem19);

        jMenuItem20.setText("Ladrillo estructural");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem20);

        jMenuItem9.setText("Cemento blanco 20 kl");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem11.setText("Cemento blanco 40 kl");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("Cemento Grisl");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem10.setText("Mastick (masilla)");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem16.setText("Carreta");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuItem17.setText("Pala");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem17);

        jMenuItem18.setText("Azadon");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem18);

        jMenuItem13.setText("Pica");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem3.setText("Martillo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem14.setText("Brocha");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem15.setText("Pinturas Condor");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem21.setText("Pinturas Unidas");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem21);

        jMenuItem22.setText("Tubos Rival");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem22);

        jMenuItem23.setText("Varilla 12 pulgadas");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem23);

        jMenuItem24.setText("Varilla 14 pulgadas ");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem24);

        jMenuItem25.setText("Varilla 18 pulgadas");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem25);

        jMenuItem26.setText("Marcilla Tarro");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem26);

        jMenu2.add(jMenu5);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shipping.png"))); // NOI18N
        jMenuItem5.setText("Agregar Nuevo Productos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimirdatos.png"))); // NOI18N
        jMenu4.setText("IMPRIMIR");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Printer InkJet.png"))); // NOI18N
        jMenuItem6.setText("Imprimir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf.png"))); // NOI18N
        jMenuItem7.setText("Generar PDF");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldTotal)
                            .addComponent(jTextFieldImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JComboxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboxProductoActionPerformed
           
        // Valor de que haya seleccionado la posicion
        int n = JComboxProducto.getSelectedIndex();

        if(n==1)
        {
            valor = (double) precioLadrillofarol; 
            jTextFieldCodProducto.setText(String.valueOf(1));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Ladrillo Farol";
        }
        if(n==2)
        {
            valor = (double) precioLadrillocaravista; 
            jTextFieldCodProducto.setText(String.valueOf(2));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Ladrillo caravista";
        }
        if(n==3)
        {
            valor = (double) precioLadrilloestructural; 
            jTextFieldCodProducto.setText(String.valueOf(3));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Ladrillo estructural";
        }
         if(n==4)
        {
            valor = (double) precioCementoblanco20; 
            jTextFieldCodProducto.setText(String.valueOf(4));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Cemento blanco 20 kl";
        }
         if(n==5)
        {
            valor = (double) precioCementoblanco40; 
            jTextFieldCodProducto.setText(String.valueOf(5));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Cemento blanco 40 kl";
        }
        if(n==6)
        {
            valor = (double) precioCementogris; 
            jTextFieldCodProducto.setText(String.valueOf(6));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Cemento gris";
        }
        if(n==7)
        {
            valor = (double) precioMastick; 
            jTextFieldCodProducto.setText(String.valueOf(7));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Mastick (Masilla)";
        }
        if(n==8)
        {
            valor = (double) precioCarreta; 
            jTextFieldCodProducto.setText(String.valueOf(8));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Carreta";
        }
        if(n==9)
        {
            valor = (double) precioPala; 
            jTextFieldCodProducto.setText(String.valueOf(9));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Pala";
        }
        if(n==10)
        {
            valor = (double) precioAzadon; 
            jTextFieldCodProducto.setText(String.valueOf(10));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Azadom";
        }
        if(n==11)
        {
            valor = (double) precioPica; 
            jTextFieldCodProducto.setText(String.valueOf(11));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Pica";
        }
        if(n==12)
        {
            valor = (double) precioMartillo; 
            jTextFieldCodProducto.setText(String.valueOf(12));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Martillo";
        }
        if(n==13)
        {
            valor = (double) precioBrocha; 
            jTextFieldCodProducto.setText(String.valueOf(13));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Brocha";
        }
        if(n==14)
        {
            valor = (double) precioPinturasCondor; 
            jTextFieldCodProducto.setText(String.valueOf(14));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Pinturas Condor";
        }
        if(n==15)
        {
            valor = (double) precioPinturasUnidas; 
            jTextFieldCodProducto.setText(String.valueOf(15));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Pinturas Unidas";
        }
         if(n==16)
        {
            valor = (double) precioTubosRival; 
            jTextFieldCodProducto.setText(String.valueOf(16));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Tubos Rival";
        }
         if(n==17)
        {
            valor = (double) precioVarilla12pulagadas; 
            jTextFieldCodProducto.setText(String.valueOf(17));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Varilla 12 pulagadas";
        }
         if(n==18)
        {
            valor = (double) precioVarilla14pulagadas; 
            jTextFieldCodProducto.setText(String.valueOf(18));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Varilla 14 pulagadas";
        }
          if(n==19)
        {
            valor = (double) precioVarilla18pulagadas; 
            jTextFieldCodProducto.setText(String.valueOf(19));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Varilla 18 pulagadas";
        }
          if(n==20)
        {
            valor = (double) precioMarcillaTarro; 
            jTextFieldCodProducto.setText(String.valueOf(20));
            jTextFieldValor.setText(String.valueOf(valor));
            nombreProductos = "Marcilla Tarro";
        }
    }//GEN-LAST:event_JComboxProductoActionPerformed

    private void jTextFieldCodProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodProductoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //dispose();
        AlmacenFerreteria.main(null);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // BOTON DE AGREGAR COMPRAS
           
        //sumar contador
          n = 1+n;
          jTextFieldNo.setText(String.valueOf(n));
        // leer la cantidad pedidas
       cant = (int) xcant.getValue();

        // Calcular la cantidad por valor
        double importe = valor*cant;
        
        //problema de obrtener valor de spinner toca dar vuelta
        jTextFieldCant.setText(String.valueOf(cant));
        jTextFieldImporte.setText(String.valueOf(importe));
       
        
        //Agregar datos a la tabla        
        String datos [] = new String [6];
        datos [0] = jTextFieldNo.getText();
        datos [1]  = jTextFieldCodProducto.getText();
        datos [2] = nombreProductos;
        datos [3] = jTextFieldCant.getText();
        datos [4] = jTextFieldValor.getText();
        datos [5] = jTextFieldImporte.getText();
        modelo.addRow(datos);
        
        // subtotal
        subtotal = subtotal+importe;
        jTextFieldSubtotal.setText(String.valueOf(subtotal));
        // cojer subtotal para impuesto
        double subtotals = Double.parseDouble(jTextFieldSubtotal.getText());
        double imp = subtotals * 0.12;
        // enviar valor de impuesto
        jTextFieldImpuesto.setText(String.valueOf(imp));
        // sumar total
        double total = imp+subtotals;
        jTextFieldTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        // seleccion la fila
        double i = JTableProduct.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else//de lo contrario si se selecciono la fila 
        {
            // coje variable de importe que elimino
            String nums = (String) JTableProduct.getValueAt((int) i, 5);//i solita iba aqui
            double entero = Double.parseDouble(nums);
           
        // cambiarlo de subtotalas que va eliminar 
        // cojer subtotal 
        double subtotals = Double.parseDouble(jTextFieldSubtotal.getText());
        // volver calcular valor de impuesto
        subtotal = subtotal-entero;
        double imp = subtotal * 0.12;       
        jTextFieldImpuesto.setText(String.valueOf(imp));
        // sumar total
        double total = imp+subtotal;
        jTextFieldSubtotal.setText(String.valueOf(subtotal));
        jTextFieldTotal.setText(String.valueOf(total));
        
        // eliminar fila
            this.modelo.removeRow((int) i);//i solita iba aqui
            // restar un aticulos
            n = n - 1;
            // poner nuevo ciclo
            double num = 1;
            for (int w = 0; w < n; w = w + 1) {
                //agregado de nuevo 
                JTableProduct.setValueAt(num, w, 0);
                num = num + 1;
            }
           
        

        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         
         codnew = Double.parseDouble(JOptionPane.showInputDialog("Introduce el codigo de nuevo productos."));
         producto = JOptionPane.showInputDialog("¿Cual es el nuevo producto?");
         JComboxProducto.addItem(producto);
         posicion = posicion+21;
         precios = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto cuesta el prodcuto "+producto+" ?"));
         JOptionPane.showMessageDialog(null, "Producto agregado");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
        // IMPRIMIR POR IMPRESORA
        String Cliente = jTextFieldNombre.getText();
        try {
            //Mensaje de encabezado
            MessageFormat  headerFormat = new MessageFormat("LISTA DE COMPRAS DE CLIENTE :"+Cliente);           
            //Mensaje en el pie de pagina
            MessageFormat footerFormat = new MessageFormat("ALMACEN FERRETERIA JAVELAR @ 2015");
            //Imprimir JTable
            JTableProduct.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            Logger.getLogger(AlmacenFerreteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        llamarJDialogPDF();  
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       precioLadrillofarol = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Ladrillo Farol"));
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        precioLadrillocaravista = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Ladrillo Caravista"));
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
       precioLadrilloestructural = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Ladrillo estructural"));
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        precioCementoblanco20 = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Cemento balnco 20 kl"));
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
         precioCementoblanco40 = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Cemento balnco 40 kl"));
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       precioCementogris = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Cemento Gris"));
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
         precioMastick = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Mastick (masilla)"));
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
         precioCarreta = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Carreta"));
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        precioPala = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Pala"));
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
         precioAzadon = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Azadon"));
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
       precioPica = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de Pica"));
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String dic = ubic.getText();
        String fact = jTextFieldFactura.getText();
        String Cliente = jTextFieldNombre.getText();
        String Fecha = jTextFieldFecha.getText();
        String totals = jTextFieldTotal.getText();
        Image imagen,publicidad;
        
        // CREA DOCUMENTOS CON TAMAÑO CARTAS Y MARGENE DE TODO LADO DE 50   
        Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);
        
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dic+".pdf"));
            document.open();
            
            imagen = Image.getInstance("cuevaferreteria.png");
            imagen.setAlignment(Element.ALIGN_CENTER);
            imagen.scalePercent(60f);
            
            //publicidad
            publicidad = Image.getInstance("cementos.png");
            publicidad.setAlignment(Element.ALIGN_CENTER);
            publicidad.scalePercent(40f);
            
            document.add(imagen);
            document.add(new Paragraph("---------------------------------------------------------"));
            document.add(new Paragraph("|    FACTURAS FERRETERIA JAVELAR    |"));
            document.add(new Paragraph("---------------------------------------------------------"));
            document.add(new Paragraph("RUC: 1890075564001 "));
            document.add(new Paragraph("Numero Fact: "+fact));
            document.add(new Paragraph("Cliente : "+Cliente));
            document.add(new Paragraph("Fecha   : [ "+Fecha+" ] - Total a Pagar : $ "+totals+"  Dolares"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(""));
            document.add(new Paragraph("| Nº.  | COD. |    PRODUCTOS                                              | CANT | VALOR UNIT"
                                   + "| IMPORTE |"));
            document.add(new Paragraph("----------------------------------------------------------------------"
                     + "--------------------------------------------------------"));
            // parte de dibujo la tabla
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(500, 500);
            Graphics2D g2;
            g2 = tp.createGraphicsShapes(500, 500);
            // g2 = tp.createGraphics(500, 500);
            JTableProduct.print(g2);
            g2.dispose();
            cb.addTemplate(tp, 50, 15);
            
            
            
            // PARA COLOCAR FOOTER
            Font font = new Font();
            font.setColor(BaseColor.GRAY);
            font.setStyle(Font.UNDERLINE);
            font.setStyle(Font.BOLD);
            Paragraph paragraph = new Paragraph();
            paragraph.setLeading(0, 37);
            
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);           
            paragraph.add("- ALMACEN FERRETERIA JAVELAR ®  2015 -");
            paragraph.add(publicidad);
            document.add(paragraph);
            document.close();
            JOptionPane.showMessageDialog(null,"Generado PDF Exitoso");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        JFileChooser dialog = new JFileChooser();
        int opcion = dialog.showSaveDialog(this);

        if(opcion == JFileChooser.APPROVE_OPTION){

            File dir = dialog.getSelectedFile();
            String fl = dir.toString();

            ubic.setText(fl);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      precioMartillo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el pecio del Martillo"));  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
      precioBrocha = Double.parseDouble(JOptionPane.showInputDialog("Introduce el pecio de la Brocha"));  // TODO add your handling code here:
       // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
     precioPinturasCondor = Double.parseDouble(JOptionPane.showInputDialog("Introduce el pecio de la Pinturas Condor"));  // TODO add your handling code here:
         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
      precioPinturasUnidas = Double.parseDouble(JOptionPane.showInputDialog("ntroduce el pecio de la Pinturas Unidas"));  // TODO add your handling code here:
           // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        precioVarilla12pulagadas = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de la Varilla de 12 pulgadas"));// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        precioVarilla14pulagadas = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de la Varilla de 14 pulgadas"));// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        precioTubosRival = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de los tubos"));// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        precioVarilla18pulagadas = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de la Varilla de 18 pulgadas"));// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
         precioMarcillaTarro = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de la Marcilla de tarro"));// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem26ActionPerformed

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
            java.util.logging.Logger.getLogger(AlmacenFerreteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlmacenFerreteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlmacenFerreteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlmacenFerreteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlmacenFerreteria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JComboxProducto;
    public static javax.swing.JTable JTableProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldCant;
    private javax.swing.JTextField jTextFieldCodProducto;
    private javax.swing.JTextField jTextFieldFactura;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldImporte;
    private javax.swing.JTextField jTextFieldImpuesto;
    private javax.swing.JTextField jTextFieldNo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldSubtotal;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField ubic;
    private javax.swing.JSpinner xcant;
    // End of variables declaration//GEN-END:variables
}