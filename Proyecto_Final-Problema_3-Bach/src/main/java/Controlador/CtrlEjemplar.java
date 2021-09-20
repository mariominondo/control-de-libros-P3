
package Controlador;

import Modelo.ConsultasEjemplar;
import Modelo.Ejemplar;
import Vista.FormEjemplar;
import Vista.FormMenuPrincipal;
import Vista.FormTablaEjemplares;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
        
        this.frmEjemplar.btnCrear.addActionListener(this);
        this.frmEjemplar.btnEliminar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.frmMenuPrincipal.btnEjemplares){
            this.frmTablaEjemplares.setVisible(true);
        }
        
        if(e.getSource() == this.frmTablaEjemplares.btnCrear){
            this.frmEjemplar.setVisible(true);
        }
        
       if(e.getSource() == this.frmEjemplar.btnCrear){
           this.modEjemplar.setNumero(Integer.parseInt(this.frmEjemplar.txtNumero.getText()));
           this.modEjemplar.setReferencia_libro(Integer.parseInt(this.frmEjemplar.txtReferenciaLibro.getText()));
           
           if(this.modConsultasEjemplar.crear(this.modEjemplar)) {               
            JOptionPane.showMessageDialog(null, "Ejemplar creado exitosamente!");
           } else {
               JOptionPane.showMessageDialog(null, "Error al Agregar.");
           }
       }
       
       if(e.getSource() == this.frmEjemplar.btnEliminar) {
           if(this.modConsultasEjemplar.eliminar(this.modEjemplar)) {
               JOptionPane.showMessageDialog(null, "Ejemplar Eliminado Correctamente.");
           } else {
               JOptionPane.showMessageDialog(null, "El ejemplar no se puedo eliminar.");
           }
       }
       
        
    }
    
}
