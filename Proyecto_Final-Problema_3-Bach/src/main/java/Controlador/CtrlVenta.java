
package Controlador;

import Modelo.ConsultasVenta;
import Modelo.Venta;
import Vista.FormVenta;
import Vista.FormMenuPrincipal;
import Vista.FormTablaVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlVenta implements ActionListener {

    private Venta modVenta;
    private ConsultasVenta modConsultasVenta;
    private FormMenuPrincipal frmMenuPrincipal;
    private FormTablaVentas frmTablaVentas;
    private FormVenta frmVenta;
    
    public CtrlVenta (Libro modLibro, ConsultasLibro modConsultasLibro, FormMenuPrincipal frmMenuPrincipal, FormTablaLibros frmTablaLibros, FormLibro frmLibro) {
        this.modLibro = modLibro;
        this.modConsultasLibro = modConsultasLibro;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmTablaLibros = frmTablaLibros;
        this.frmLibro = frmLibro;
        
        this.frmMenuPrincipal.btnLibros.addActionListener(this);
                
        this.frmTablaLibros.btnCrear.addActionListener(this);
        this.frmTablaLibros.btnBuscar.addActionListener(this);
    }
    
    public void iniciar() {    
        frmMenuPrincipal.setTitle("Menú Principal");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.frmMenuPrincipal.btnLibros){
            frmTablaLibros.setVisible(true);
        }
        
        if(e.getSource() == this.frmTablaLibros.btnCrear){
            frmLibro.setVisible(true);
        }
        
       if(e.getSource() == this.frmLibro.btnAgregar){
       }
       
        
    }
    
}
