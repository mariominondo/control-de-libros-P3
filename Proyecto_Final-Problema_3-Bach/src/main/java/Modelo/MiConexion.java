
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class MiConexion {
    
    private final String bd = "control_de_libros";
    private final String user = "root";
    private final String password = "";    
    private final String url = "jdbc:mysql://localhost/" + bd;
    
    private Connection con = null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (Exception e) {
            System.err.println(e);
        }
        return con;
    }
}
