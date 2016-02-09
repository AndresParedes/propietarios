/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopropietarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ging
 */
public class conexion {
     public String usuario = "sa";
    public String password = "sa";
    public String url = "jdbc:sqlserver://ANDRES:1433;databaseName=jventas";
    
    public Connection cn = null;
    public Statement st = null;
    
    public Statement Conectar(){
        try{
           
            Connection cn = DriverManager.getConnection(url,usuario,password);
            
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return st;
            
        }
}
