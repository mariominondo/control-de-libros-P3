
package Controlador;

import Modelo.ConsultasEjemplar;
import Modelo.Ejemplar;
import Vista.FormEjemplar;
import Vista.FormMenuPrincipal;
import Vista.FormTablaEjemplares;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlEjemplar implements ActionListener {

    private Ejemplar modEjemplar;
    private ConsultasEjemplar modConsultasEjemplar;
    private FormMenuPrincipal frmMenuPrincipal;
    private FormTablaEjemplares frmTablaEjemplares;
    private FormEjemplar frmEjemplar;
    
    public CtrlEjemplar (Ejemplar modEjemplar, ConsultasEjemplar modConsultasEjemplar, FormMenuPrincipal frmMenuPrincipal, FormTablaEjemplares frmTablaEjemplares, FormEjemplar frmEjemplar) {
        this.modEjemplar = modEjemplar;
        this.modConsultasEjemplar = modConsultasEjemplar;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmTablaEjemplares = frmTablaEjemplares;
        this.frmEjemplar = frmEjemplar;
        
        this.frmMenuPrincipal.btnEjemplares.addActionListener(this);
                
        this.frmTablaEjemplares.btnCrear.addActionListener(this);
        this.frmTablaEjemplares.btnBuscar.addActionListener(this);
    }
    
//    public void iniciar() {    
//        frmMenuPrincipal.setTitle("Menú Principal");
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.frmMenuPrincipal.btnEjemplares){
            frmTablaEjemplares.setVisible(true);
        }
        
        if(e.getSource() == this.frmTablaEjemplares.btnCrear){
            frmEjemplar.setVisible(true);
        }
        
       if(e.getSource() == this.frmEjemplar.btnCrear){
           
       }
       
        
    }
    
}
