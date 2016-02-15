/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopropietarios;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ging
 */
public class detalles extends javax.swing.JFrame {

    /**
     * Creates new form buscarCliente
     */
    public detalles() {
        initComponents();
          String iddetalle=buscarfactura.COD.trim();
           JOptionPane.showMessageDialog(null, iddetalle);
        mostrardatos();
        
        
    }
   
public String Nomb;
public String Cod;

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
    String iddetalle=buscarfactura.COD.trim();
    try{
        conexion conectar = new conexion();
        Statement st = conectar.Conectar();

        tablaUsuario.addColumn("Numero de Factura");
        tablaUsuario.addColumn("nombre_producto");
       tablaUsuario.addColumn("precio_producto");
         tablaUsuario.addColumn("cantidad");
          tablaUsuario.addColumn("preciototal");
       CallableStatement cst;
     
                 ResultSet rs= st.executeQuery("SELECT id_factura,nombre_producto,precio_producto,cantidad,preciototal from detalle where id_factura='"+iddetalle+"'  ");

          while (rs.next()){
          Object dato[]=new  Object[5];
          for (int i=0; i<5; i++){
           dato[i]=rs.getString(i+1);

       }
       tablaUsuario.addRow(dato);
       }
       this.tabla.setModel(tablaUsuario);

       }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);}
              
        
    
    
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked


    }//GEN-LAST:event_tablaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detalles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
