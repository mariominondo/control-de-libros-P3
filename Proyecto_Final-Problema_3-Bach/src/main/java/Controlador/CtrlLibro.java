
package Controlador;

import Modelo.ConsultasLibro;
import Modelo.Libro;
import Modelo.MiConexion;
import Vista.FormLibro;
import Vista.FormMenuPrincipal;
import Vista.FormTablaLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlLibro implements ActionListener {

    private Libro modLibro;
    private ConsultasLibro modConsultasLibro;
    private FormMenuPrincipal frmMenuPrincipal;
    private FormTablaLibros frmTablaLibros;
    private FormLibro frmLibro;
    
    public CtrlLibro (Libro modLibro, ConsultasLibro modConsultasLibro, FormMenuPrincipal frmMenuPrincipal, FormTablaLibros frmTablaLibros, FormLibro frmLibro) {
        this.modLibro = modLibro;
        this.modConsultasLibro = modConsultasLibro;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmTablaLibros = frmTablaLibros;
        this.frmLibro = frmLibro;
        
        this.frmMenuPrincipal.btnLibros.addActionListener(this);
                
        this.frmTablaLibros.btnCrear.addActionListener(this);
        this.frmTablaLibros.btnBuscar.addActionListener(this);
        this.frmTablaLibros.txtBuscar.setText("Buscar...");
        
        // Agregar otros Botones
        this.frmLibro.btnAgregar.addActionListener(this);
        this.frmLibro.btnModificar.addActionListener(this);
        this.frmLibro.btnEliminar.addActionListener(this);
    }
    
    public void iniciar() {    
        this.frmMenuPrincipal.setTitle("Menú Principal");
    }
    
    public void actualizaTabla() {        
        DefaultTableModel tModelo = new DefaultTableModel();
        this.frmTablaLibros.jtTablaLibros.setModel(tModelo);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        MiConexion miCon = new MiConexion();
        
        Connection con = miCon.getConnection();
        
        String sql = "SELECT codigo_libro, titulo, genero_literario, editorial, \n"+
                "autor, anio_edicion, numero_edicion, pais_origen, numero_paginas, \n" +
                "cantidad_ejemplares, precio FROM libros;";
        
        try {        
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            
            tModelo.addColumn("codigo_libro");
            tModelo.addColumn("titulo");
            tModelo.addColumn("genero_literario");
            tModelo.addColumn("editorial");
            tModelo.addColumn("autor");
            tModelo.addColumn("anio_edicion");
            tModelo.addColumn("numero_edicion");
            tModelo.addColumn("pais_origen");
            tModelo.addColumn("cantidad_ejemplares");
            tModelo.addColumn("numero_paginas");
            tModelo.addColumn("precio");
            
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                
                for(int i=0; i<cantidadColumnas; i++){
                    filas[i] = rs.getObject(i + 1);
                }
                
                tModelo.addRow(filas);
            }
                
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // ex.toString()
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.frmMenuPrincipal.btnLibros){
            this.frmTablaLibros.setVisible(true);
            actualizaTabla();
        }
        
        if(e.getSource() == this.frmTablaLibros.btnCrear){
            this.frmLibro.setVisible(true);
        }
        
        if(e.getSource() == this.frmLibro.btnAgregar){           
           this.modLibro.setCodigo_libro(Integer.parseInt(this.frmLibro.tfCodigo.getText()));
           this.modLibro.setTitulo(this.frmLibro.tfTitulo.getText());
           this.modLibro.setGenero_literario(this.frmLibro.tfGeneroLiterario.getText());
           this.modLibro.setEditorial(this.frmLibro.tfEditorial.getText());
           this.modLibro.setAutor(this.frmLibro.tfAutor.getText());
           this.modLibro.setAnio_edicion(this.frmLibro.tYearAnioEdicion.getYear());
           this.modLibro.setNumero_edicion(Integer.parseInt(this.frmLibro.tfNoEdicion.getText()));
           this.modLibro.setPais_origen(this.frmLibro.tfPaisOrigen.getText());
           this.modLibro.setNumero_paginas(Integer.parseInt(this.frmLibro.tfNoPaginas.getText()));
           this.modLibro.setCantidad_ejemplares(Integer.parseInt(this.frmLibro.tfCantidadEjemplares.getText()));
           this.modLibro.setPrecio(Double.parseDouble(this.frmLibro.tfPrecioVenta.getText()));
           if(this.modConsultasLibro.crear(this.modLibro)) {
                JOptionPane.showMessageDialog(null, "Libro guardado correctamente.");  
                actualizaTabla();               
           } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar.");
           }
        }
       
        if(e.getSource() == this.frmLibro.btnModificar){           
//           this.modLibro.setCodigo_libro(Integer.parseInt(this.frmLibro.tfCodigo.getText()));
           this.modLibro.setTitulo(this.frmLibro.tfTitulo.getText());
           this.modLibro.setGenero_literario(this.frmLibro.tfGeneroLiterario.getText());
           this.modLibro.setEditorial(this.frmLibro.tfEditorial.getText());
           this.modLibro.setAutor(this.frmLibro.tfAutor.getText());
           this.modLibro.setAnio_edicion(this.frmLibro.tYearAnioEdicion.getYear());
           this.modLibro.setNumero_edicion(Integer.parseInt(this.frmLibro.tfNoEdicion.getText()));
           this.modLibro.setPais_origen(this.frmLibro.tfPaisOrigen.getText());
           this.modLibro.setNumero_paginas(Integer.parseInt(this.frmLibro.tfNoPaginas.getText()));
           this.modLibro.setCantidad_ejemplares(Integer.parseInt(this.frmLibro.tfCantidadEjemplares.getText()));
           this.modLibro.setPrecio(Double.parseDouble(this.frmLibro.tfPrecioVenta.getText()));
           if(this.modConsultasLibro.crear(this.modLibro)) {
                JOptionPane.showMessageDialog(null, "Libro guardado correctamente.");  
                actualizaTabla();               
           } else {
                 JOptionPane.showMessageDialog(null, "Error al Guardar.");
           }
        }
        
        if(e.getSource() == this.frmTablaLibros.btnBuscar){  
           // txtBuscar ----
           // this.modLibro.setCodigo_libro(Integer.parseInt(this.frmLibro.tfCodigo.getText()));
           
           this.modLibro.setCodigo_libro(Integer.parseInt(this.frmTablaLibros.txtBuscar.getText()));

//           this.frmLibro.tfTitulo.setText(this.modLibro.getTitulo());
//           this.frmLibro.tfGeneroLiterario.setText(this.modLibro.getGenero_literario());
//           this.frmLibro.tfEditorial.setText(this.modLibro.getEditorial());
//           this.frmLibro.tfAutor.setText(this.modLibro.getAutor());
//           this.frmLibro.tYearAnioEdicion.setYear(this.modLibro.getAnio_edicion());
//           this.frmLibro.tfNoEdicion.setText(String.valueOf(this.modLibro.getNumero_edicion()));
//           this.frmLibro.tfPaisOrigen.setText(this.modLibro.getPais_origen());
//           this.frmLibro.tfNoPaginas.setText(String.valueOf(this.modLibro.getNumero_paginas()));
//           this.frmLibro.tfCantidadEjemplares.setText(String.valueOf(this.modLibro.getCantidad_ejemplares()));
//           this.frmLibro.tfPrecioVenta.setText(String.valueOf(this.modLibro.getPrecio()));
           if(this.modConsultasLibro.buscar(this.modLibro)) {
                JOptionPane.showMessageDialog(null, "Libro encontrado correctamente.");  
                this.frmLibro.setVisible(true);             
           } else {
                JOptionPane.showMessageDialog(null, "No se encontró el libro.");
           }
        }
       
        
    }
    
}
