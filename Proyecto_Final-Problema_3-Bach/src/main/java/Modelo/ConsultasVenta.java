
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasVenta extends MiConexion{
    
    public boolean crear(Venta venta){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO ventas VALUES(?,?,?,?,?,?);";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getNumero_pedido());
            ps.setDate(2, venta.getFecha_pedido());
            ps.setInt(3, venta.getReferencia_libro());
            ps.setInt(4, venta.getReferencia_cliente());
            ps.setInt(5, venta.getCantidad_compra());
            ps.setDouble(6, venta.getMonto_total());
            ps.execute();
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
        
        String sql = "UPDATE ventas SET numero_pedido=?, fecha_pedido=?, \n " +
                "referencia_libro=?, referencia_cliente=?, cantidad_compra=?, \n "+
                "monto_total=? WHERE numero_pedido=?;";   
                
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
              venta.setFechaPedido(Date.valueOf(rs.getString("fecha_pedido")));
              venta.setReferencia_libro(Integer.parseInt(rs.getString("referencia_libro")));
              venta.setReferencia_cliente(Integer.parseInt(rs.getString("referencia_cliente")));
              venta.setCantidad_compra(Integer.parseInt(rs.getString("cantidad_compra")));
              venta.setMonto_total(Double.parseDouble(rs.getString("monto_total")));
              return true;
          }          
          return false;
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
