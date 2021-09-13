
package Controlador;

import Modelo.ConsultasCliente;
import Modelo.Cliente;
import Vista.FormCliente;
import Vista.FormMenuPrincipal;
import Vista.FormTablaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlCliente implements ActionListener {

    private Cliente modCliente;
    private ConsultasCliente modConsultasCliente;
    private FormMenuPrincipal frmMenuPrincipal;
    private FormTablaClientes frmTablaClientes;
    private FormCliente frmCliente;
    
    public CtrlCliente (Cliente modCliente, ConsultasCliente modConsultasCliente, FormMenuPrincipal frmMenuPrincipal, FormTablaClientes frmTablaClientes, FormCliente frmCliente) {
        this.modCliente = modCliente;
        this.modConsultasCliente = modConsultasCliente;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmTablaClientes = frmTablaClientes;
        this.frmCliente = frmCliente;
        
        this.frmMenuPrincipal.btnClientes.addActionListener(this);
                
        this.frmTablaClientes.btnCrear.addActionListener(this);
        this.frmTablaClientes.btnBuscar.addActionListener(this);
    }
    
//    public void iniciar() {    
//        frmMenuPrincipal.setTitle("Menú Principal");
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.frmMenuPrincipal.btnClientes){
            frmTablaClientes.setVisible(true);
        }
        
        if(e.getSource() == this.frmTablaClientes.btnCrear){
            frmCliente.setVisible(true);
        }
        
       if(e.getSource() == this.frmCliente.btnCrear){
       }
       
        
    }
    
}
