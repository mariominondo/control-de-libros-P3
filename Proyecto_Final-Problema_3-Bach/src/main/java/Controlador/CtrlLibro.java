
package Controlador;

import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.FormLibro;
import Vista.FormMenuPrincipal;
import Vista.FormTablaLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        this.frmMenuPrincipal.btnLibros;
        
        this.frmTablaLibros.btnCrear;
        this.frmTablaLibros.btnBuscar;
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
    }
    
}
