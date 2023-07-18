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
             cnx = DriverManager.getConnection("jdbc:mysql://localhost/java_mysql", getUser(), getPassword());
             JOptionPane.showMessageDialog(null, "Conexion exitosa");
          }
          catch(ClassNotFoundException | SQLException | HeadlessException e){
              JOptionPane.showMessageDialog(null, "Error Conexion: "+ e.getMessage());
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
