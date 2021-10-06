
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasLibro extends MiConexion{
    
    public boolean crear(Libro libro){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO libros VALUES(?,?,?,?,?,?,?,?,?,?,?);";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getCodigo_libro());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getGenero_literario());
            ps.setString(4, libro.getEditorial());
            ps.setString(5, libro.getAutor());
            ps.setInt(6, libro.getAnio_edicion());
            ps.setInt(7, libro.getNumero_edicion());
            ps.setString(8, libro.getPais_origen());
            ps.setInt(9, libro.getNumero_paginas());
            ps.setInt(10, libro.getCantidad_ejemplares());
            ps.setDouble(11, libro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public boolean modificar (Libro libro){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE libros SET titulo=?, genero_literario=?, editorial=?, autor=?, anio_edicion=?, numero_edicion=?, pais_origen=?, numero_paginas=?, cantidad_ejemplares=?, precio=? WHERE codigo_libro=?;";   
                
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getGenero_literario());
            ps.setString(3, libro.getEditorial());
            ps.setString(4, libro.getAutor());
            ps.setInt(5, libro.getAnio_edicion());
            ps.setInt(6, libro.getNumero_edicion());
            ps.setString(7, libro.getPais_origen());
            ps.setInt(8, libro.getNumero_paginas());
            ps.setInt(9, libro.getCantidad_ejemplares());
            ps.setDouble(10, libro.getPrecio());            
            ps.setInt(11, libro.getCodigo_libro());
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
    
    public boolean eliminar (Libro libro){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM libros WHERE codigo_libro=?;";   
                
        try {
            ps = con.prepareStatement(sql);          
            ps.setInt(1, libro.getCodigo_libro());
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
     
    public boolean buscar (Libro libro){
      PreparedStatement ps = null;
      ResultSet rs = null;
      Connection con = getConnection();

      String sql = "SELECT * FROM libros WHERE codigo_libro=?;";   

      try {
          ps = con.prepareStatement(sql);          
          ps.setInt(1, libro.getCodigo_libro());
          rs = ps.executeQuery();
          
          if(rs.next()){
              libro.setCodigo_libro(Integer.parseInt(rs.getString("codigo_libro")));
              libro.setTitulo(rs.getString("titulo"));
              libro.setGenero_literario(rs.getString("genero_literario"));
              libro.setEditorial(rs.getString("editorial"));
              libro.setAutor(rs.getString("autor"));
              libro.setAnio_edicion(rs.getInt("anio_edicion"));
              libro.setNumero_edicion(Integer.parseInt(rs.getString("numero_edicion")));
              libro.setPais_origen(rs.getString("pais_origen"));
              libro.setNumero_paginas(Integer.parseInt(rs.getString("numero_paginas")));
              libro.setCantidad_ejemplares(Integer.parseInt(rs.getString("cantidad_ejemplares")));
              libro.setPrecio(Double.parseDouble(rs.getString("precio")));
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
