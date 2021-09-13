
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasVenta extends MiConexion{
    
    public boolean crear(Venta venta){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO ventas (?,?,?,?,?,?);";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getNumero_pedido());
            ps.setDate(2, venta.getFecha_pedido());
            ps.setInt(3, venta.getReferencia_libro());
            ps.setInt(4, venta.getReferencia_cliente());
            ps.setInt(5, venta.getCantidad_compra());
            ps.setDouble(6, venta.getMonto_total());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Venta realizada exitosamente!");
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
    
    public boolean modificar (Venta venta){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE ventas SET (numero_pedido=?, fecha_pedido=?, referencia_libro=?, referencia_cliente=?, cantidad_compra=?, monto_total=?, WHERE numero_pedido=?;";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getNumero_pedido());
            ps.setDate(2, venta.getFecha_pedido());
            ps.setInt(3, venta.getReferencia_libro());
            ps.setInt(4, venta.getReferencia_cliente());
            ps.setInt(5, venta.getCantidad_compra());
            ps.setDouble(6, venta.getMonto_total());
            ps.setInt(7, venta.getNumero_pedido());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Venta modificada exitosamente!");
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
    
    public boolean eliminar (Venta venta){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM ventas WHERE numero_pedido=?;";   
                
        try {
            ps = con.prepareStatement(sql);          
            ps.setInt(1, venta.getNumero_pedido());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente!");
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
     
    public boolean buscar (Venta venta){
      PreparedStatement ps = null;
      ResultSet rs = null;
      Connection con = getConnection();

      String sql = "SELECT * FROM ventas WHERE numero_pedido=?;";   

      try {
          ps = con.prepareStatement(sql);          
          ps.setInt(1, venta.getNumero_pedido());
          rs = ps.executeQuery();
          
          if(rs.next()){
              venta.setNumero_pedido(Integer.parseInt(rs.getString("numero_pedido")));
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
