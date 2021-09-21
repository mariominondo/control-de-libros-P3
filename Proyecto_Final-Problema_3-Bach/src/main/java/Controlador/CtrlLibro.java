
package Controlador;

import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.FormLibro;
import Vista.FormMenuPrincipal;
import Vista.FormTablaLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;

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
        
        // Agregar otros Botones
        this.frmLibro.btnAgregar.addActionListener(this);
    }
    
    public void iniciar() {    
        this.frmMenuPrincipal.setTitle("Menú Principal");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.frmMenuPrincipal.btnLibros){
            this.frmTablaLibros.setVisible(true);
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
           
           
           System.out.println("Boton Agregar presionado");
           if(this.modConsultasLibro.crear(this.modLibro)) {
               JOptionPane.showMessageDialog(null, "Libro guardado correctamente.");   
           } else {
               JOptionPane.showMessageDialog(null, "Error al Guardar.");
           }
       }
       
        
    }
    
}
