
package Controlador;

import Modelo.ConsultasCliente;
import Modelo.Cliente;
import Vista.FormCliente;
import Vista.FormMenuPrincipal;
import Vista.FormTablaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
        
        this.frmCliente.btnCrear.addActionListener(this);
        this.frmCliente.btnModificar.addActionListener(this);
        this.frmCliente.btnEliminar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.frmMenuPrincipal.btnClientes){
            frmTablaClientes.setVisible(true);
        }
        
        if(e.getSource() == this.frmTablaClientes.btnCrear){
            frmCliente.setVisible(true);
        }
        
       if(e.getSource() == this.frmCliente.btnCrear){
           this.modCliente.setId_cliente(Integer.parseInt(this.frmCliente.txtCodigoDeUsuario.getText()));
           this.modCliente.setNombre(this.frmCliente.txtNombre.getText());
           this.modCliente.setDireccion(this.frmCliente.txtDireccion.getText());
           this.modCliente.setTelefono(this.frmCliente.txtTelefono.getText());
           this.modCliente.setEmail(this.frmCliente.txtEmail.getText());
           
           if(this.modConsultasCliente.crear(this.modCliente)) {
               JOptionPane.showMessageDialog(null, "Cliente creado exitosamente!");
           } else {
               JOptionPane.showMessageDialog(null, "Error al Crear");
           }
       }
       
       if (e.getSource() == this.frmCliente.btnModificar) {
           this.modCliente.setId_cliente(Integer.parseInt(this.frmCliente.txtCodigoDeUsuario.getText()));
           this.modCliente.setNombre(this.frmCliente.txtNombre.getText());
           this.modCliente.setDireccion(this.frmCliente.txtDireccion.getText());
           this.modCliente.setTelefono(this.frmCliente.txtTelefono.getText());
           this.modCliente.setEmail(this.frmCliente.txtEmail.getText());
           
           if(this.modConsultasCliente.modificar(this.modCliente)) {
               JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente!");
           } else {
               JOptionPane.showMessageDialog(null, "Error al Modificar");
           }
       }   
       
       if (e.getSource() == this.frmCliente.btnEliminar) {
           this.modCliente.setId_cliente(Integer.parseInt(this.frmCliente.txtCodigoDeUsuario.getText()));
           
           if(this.modConsultasCliente.eliminar(this.modCliente)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
           } else {
               JOptionPane.showMessageDialog(null, "Error al Eliminar");
           }
       }
        
    }
    
}
