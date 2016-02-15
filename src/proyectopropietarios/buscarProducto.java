/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopropietarios;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ging
 */
public class buscarProducto extends javax.swing.JFrame {

    /**
     * Creates new form buscarCliente
     */
    public buscarProducto() {
        initComponents();
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
    try{
        conexion conectar = new conexion();
        Statement st = conectar.Conectar();

      tablaUsuario.addColumn("Codigo Producto");
       tablaUsuario.addColumn("Nombre Producto");
        tablaUsuario.addColumn("Proveedor");
       tablaUsuario.addColumn("Descripcion");
       tablaUsuario.addColumn("Stock");
       tablaUsuario.addColumn("Stock Medio");
       tablaUsuario.addColumn("Stock Minimo");
       tablaUsuario.addColumn("iva");
       tablaUsuario.addColumn("ice");
       tablaUsuario.addColumn("Precio compra");
       tablaUsuario.addColumn("Precio venta");
       CallableStatement cst;
     
          ResultSet rs= st.executeQuery("SELECT * from producto");
          while (rs.next()){
          Object dato[]=new  Object[11];
          for (int i=0; i<11; i++){
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

        buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buscar.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel1.setText("BUSCAR POR NOMBRE:");

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton2.setText("ACEPTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String cod=this.buscar.getText();
        DefaultTableModel tablaUsuario= new DefaultTableModel();
        try{
            conexion conectar = new conexion();
            Statement st = conectar.Conectar();

             tablaUsuario.addColumn("Codigo Producto");
       tablaUsuario.addColumn("Nombre Producto");
        tablaUsuario.addColumn("Proveedor");
       tablaUsuario.addColumn("Descripcion");
       tablaUsuario.addColumn("Stock");
       tablaUsuario.addColumn("Stock Medio");
       tablaUsuario.addColumn("Stock Minimo");
       tablaUsuario.addColumn("iva");
       tablaUsuario.addColumn("ice");
       tablaUsuario.addColumn("Precio compra");
       tablaUsuario.addColumn("Precio venta");
            CallableStatement cst;

            ResultSet rs= st.executeQuery("SELECT * from producto where nombre_producto ='" + cod + "'");
            while (rs.next()){
                Object dato[]=new  Object[11];
                for (int i=0; i<11; i++){
                    dato[i]=rs.getString(i+1);

                }
                tablaUsuario.addRow(dato);
            }
            this.tabla.setModel(tablaUsuario);

        }catch (Exception e){}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String cod=this.buscar.getText();
        try{
            conexion conectar = new conexion();
            Statement st = conectar.Conectar();

            CallableStatement cst;

            ResultSet rs= st.executeQuery("SELECT * from producto where nombre_producto ='" + cod + "'");
            while (rs.next()){
                Object dato[]=new  Object[11];
                for (int i=0; i<11; i++){
                    dato[i]=rs.getString(i+1);
                    Cod=dato[0]+"";
                    Nomb =dato[1]+"".toString().trim();
                    String ci=dato[2]+"";
                    String stock=dato[4]+"";
                    String precio=dato[10]+"";
                     
                  AlmacenFerreteria.codpro.setText(Cod);
                  AlmacenFerreteria.nombrepro.setText(Nomb);
                  AlmacenFerreteria.stock.setText(stock);
                  AlmacenFerreteria.precio.setText(precio);


                    this.hide();

                }
            }

        }
        catch (Exception e){}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        String cod;

        int fila= tabla.getSelectedRow();
        if(fila>=0){
            buscar.setText(tabla.getValueAt(fila, 1).toString());

        }
        else{
            JOptionPane.showMessageDialog(null,"no seleciono fila");
        }

    }//GEN-LAST:event_tablaMouseClicked

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
            java.util.logging.Logger.getLogger(buscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
