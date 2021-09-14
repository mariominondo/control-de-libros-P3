
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
    
    public CtrlVenta (Venta modLibro, ConsultasVenta modConsultasVenta, FormMenuPrincipal frmMenuPrincipal, FormTablaVentas frmTablaVentas, FormVenta frmVenta) {
        this.modVenta = modVenta;
        this.modConsultasVenta = modConsultasVenta;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmTablaVentas = frmTablaVentas;
        this.frmVenta = frmVenta;
        
        this.frmMenuPrincipal.btnVentas.addActionListener(this);
                
        this.frmTablaVentas.btnCrear.addActionListener(this);
        this.frmTablaVentas.btnBuscar.addActionListener(this);
    }
    
    public void iniciar() {    
        frmMenuPrincipal.setTitle("Menú Principal");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.frmMenuPrincipal.btnVentas){
            frmTablaVentas.setVisible(true);
        }
        
        if(e.getSource() == this.frmTablaVentas.btnCrear){
            frmVenta.setVisible(true);
        }
        
       if(e.getSource() == this.frmVenta.btnCrear){
       }
       
        
    }
    
}
