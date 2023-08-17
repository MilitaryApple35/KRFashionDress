package Codigo;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author asder
 */
public class Conexion {
    private String user, password;
    private Connection cnx = null;
    public Connection conexion() {
       if (cnx == null) {
          try {
             Class.forName("com.mysql.jdbc.Driver");
             cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/kr_fashion", "root", "Chochias0404/");
          }
          catch(ClassNotFoundException e){
              JOptionPane.showMessageDialog(null, "Error Conexion Class: "+ e.getMessage());
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null, "Error Conexion SQL: "+ e.getMessage());
          }
          catch(HeadlessException e){
              JOptionPane.showMessageDialog(null, "Error Conexion head: "+ e.getMessage());
          }
       }
       return cnx;
    }
    
    public void cerrar() throws SQLException {
       if (cnx != null) {
          cnx.close();
       }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
