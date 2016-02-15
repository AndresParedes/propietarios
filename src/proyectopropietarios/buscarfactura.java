/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopropietarios;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ging
 */
public class buscarfactura extends javax.swing.JFrame {

    /**
     * Creates new form buscarCliente
     */
    public buscarfactura() {
        initComponents();
        mostrardatos();
    }
public String Nomb;
public String Cod;
public static String COD;

    public String getNomb() {
        return Nomb;
    }

    public void setNomb(String Nomb) {
        this.Nomb = Nomb;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String Cod) {
        this.Cod = Cod;
    }
    
    
    void mostrardatos(){
    DefaultTableModel tablaUsuario= new DefaultTableModel();
    try{
        conexion conectar = new conexion();
        Statement st = conectar.Conectar();

        tablaUsuario.addColumn("Numero de Factura");
        tablaUsuario.addColumn("Fecha");
       tablaUsuario.addColumn("Nombre Cliente");
         tablaUsuario.addColumn("Comentario");
       CallableStatement cst;
     
                 ResultSet rs= st.executeQuery("SELECT numero_factura,fecha_emision,nombre_cliente,comentario from factura ");

          while (rs.next()){
          Object dato[]=new  Object[4];
          for (int i=0; i<4; i++){
           dato[i]=rs.getString(i+1);

       }
       tablaUsuario.addRow(dato);
       }
       this.tabla.setModel(tablaUsuario);

       }catch (Exception e){}
              
        
    
    
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        buscar = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel1.setText("BUSCAR POR FECHA");

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int año=0;
        int mes=0;
        int dia=0;
         año=this.buscar.getCalendar().get(Calendar.YEAR);
         mes=this.buscar.getCalendar().get(Calendar.MONTH);
         mes =mes+1;
         dia=this.buscar.getCalendar().get(Calendar.DATE);
         String Fecha=dia+"-"+mes+"-"+año;
        
        DefaultTableModel tablaUsuario= new DefaultTableModel();
        try{
            conexion conectar = new conexion();
            Statement st = conectar.Conectar();

            tablaUsuario.addColumn("Numero de Factura");
        tablaUsuario.addColumn("Fecha");
       tablaUsuario.addColumn("Nombre Cliente");
         tablaUsuario.addColumn("Comentario");
       
            CallableStatement cst;

            ResultSet rs= st.executeQuery("SELECT numero_factura,fecha_emision,nombre_cliente,comentario from factura where fecha_emision ='" + Fecha + "'");
            while (rs.next()){
                Object dato[]=new  Object[4];
                for (int i=0; i<4; i++){
                    dato[i]=rs.getString(i+1);

                }
                tablaUsuario.addRow(dato);
            }
            this.tabla.setModel(tablaUsuario);

        }catch (Exception e){}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
    
int fila= tabla.getSelectedRow();
        if(fila>=0){
        COD=tabla.getValueAt(fila, 0).toString().trim();
        
        }
       detalles p1= new detalles();
        p1.setVisible(true);
    }//GEN-LAST:event_tablaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscarfactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
