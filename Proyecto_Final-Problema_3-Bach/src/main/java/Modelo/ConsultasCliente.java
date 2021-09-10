
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasCliente extends MiConexion{
    
    public boolean crear(Cliente cliente){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO clientes (?,?,?,?,?);";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getId_cliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente!");
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
    
    public boolean modificar (Cliente cliente){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE clientes SET (id_cliente=?, nombre=?, direccion=?, telefono=?, email=? WHERE id_cliente=?;";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion());            
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
            ps.setInt(6, cliente.getId_cliente());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente!");
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
    
    public boolean eliminar (Cliente cliente){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM cliente WHERE id_cliente=?;";   
                
        try {
            ps = con.prepareStatement(sql);          
            ps.setInt(1, cliente.getId_cliente());  
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente!");
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
     
    public boolean buscar (Cliente cliente){
      PreparedStatement ps = null;
      ResultSet rs = null;
      Connection con = getConnection();

      String sql = "SELECT * FROM clientes WHERE id_cliente=?;";   

      try {
          ps = con.prepareStatement(sql);          
          ps.setInt(1, cliente.getId_cliente()); 
          rs = ps.executeQuery();
          
          if(rs.next()){
              cliente.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
              cliente.setNombre(rs.getString("nombre"));
              cliente.setDireccion(rs.getString('direccion'));
              cliente.setTelefono(rs.getString('telefono'));
              cliente.setEmail(rs.getString('email'));
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
