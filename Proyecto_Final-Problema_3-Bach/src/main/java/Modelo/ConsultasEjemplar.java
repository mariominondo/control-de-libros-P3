
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasEjemplar extends MiConexion{
    
    public boolean crear(Ejemplar ejemplar){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO ejemplares (?,?);";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ejemplar.getNumero());
            ps.setInt(2, ejemplar.getReferencia_libro());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Ejemplar creado exitosamente!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public boolean modificar (Ejemplar ejemplar){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE ejemplares SET (numero=?, referencia_libro=? WHERE numero=? AND referencia_libro=?;";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ejemplar.getNumero());
            ps.setInt(2, ejemplar.getReferencia_libro());
            ps.setDouble(3, ejemplar.getNumero());            
            ps.setInt(4, ejemplar.getReferencia_libro());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Ejemplar modificado exitosamente!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public boolean eliminar (Ejemplar ejemplar){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM ejemplares WHERE numero=? AND referencia_libro=?;";   
                
        try {
            ps = con.prepareStatement(sql);          
            ps.setInt(1, ejemplar.getNumero());  
            ps.setInt(2, ejemplar.getReferencia_libro());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
     
    public boolean buscar (Ejemplar ejemplar){
      PreparedStatement ps = null;
      ResultSet rs = null;
      Connection con = getConnection();

      String sql = "SELECT * FROM ejemplares WHERE numero=? AND referencia_libro=?;";   

      try {
          ps = con.prepareStatement(sql);          
          ps.setInt(1, ejemplar.getNumero()); 
          ps.setInt(2, ejemplar.getReferencia_libro());
          rs = ps.executeQuery();
          
          if(rs.next()){
              ejemplar.setNumero(Integer.parseInt(rs.getString("numero")));
              ejemplar.setReferencia_libro(Integer.parseInt(rs.getString("referencia_libro")));
              //libro.setTitulo(rs.get);
          }
          return true;
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
          return false;
      } finally {
          try {
              con.close();
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);
          }
      }
  }
}
