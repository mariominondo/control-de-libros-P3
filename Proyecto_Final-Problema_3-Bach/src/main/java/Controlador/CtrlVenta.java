
package Controlador;

import Modelo.ConsultasVenta;
import Modelo.Venta;
import Vista.FormVenta;
import Vista.FormMenuPrincipal;
import Vista.FormTablaVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;

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
        
        this.frmVenta.btnCrear.addActionListener(this);
        this.frmVenta.btnModificar.addActionListener(this);
        this.frmVenta.btnEliminar.addActionListener(this);
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
           this.modVenta.setNumero_pedido(Integer.parseInt(this.frmVenta.txtNoDePedido.getText()));
           this.modVenta.setFechaPedido(Date.valueOf(this.frmVenta.txtFechaDePedido.getText()));
           this.modVenta.setReferencia_libro(Integer.parseInt(this.frmVenta.txtReferenciaLibro.getText()));
           this.modVenta.setReferencia_cliente(Integer.parseInt(this.frmVenta.txtReferenciaCliente.getText()));
           this.modVenta.setCantidad_compra(Integer.parseInt(this.frmVenta.txtCantidad.getText()));
           this.modVenta.setMonto_total(Double.parseDouble(this.frmVenta.txtMonto.getText()));
           
           if (this.modConsultasVenta.crear(this.modVenta)) {
               JOptionPane.showMessageDialog(null, "Venta Creada correctamente");
           } else {
               JOptionPane.showMessageDialog(null, "Error al crear la Venta");
           }
       }
       
       if (e.getSource() == this.frmVenta.btnModificar) {
           this.modVenta.setNumero_pedido(Integer.parseInt(this.frmVenta.txtNoDePedido.getText()));
           this.modVenta.setFechaPedido(Date.valueOf(this.frmVenta.txtFechaDePedido.getText()));
           this.modVenta.setReferencia_libro(Integer.parseInt(this.frmVenta.txtReferenciaLibro.getText()));
           this.modVenta.setReferencia_cliente(Integer.parseInt(this.frmVenta.txtReferenciaCliente.getText()));
           this.modVenta.setCantidad_compra(Integer.parseInt(this.frmVenta.txtCantidad.getText()));
           this.modVenta.setMonto_total(Double.parseDouble(this.frmVenta.txtMonto.getText()));
           
           if (this.modConsultasVenta.modificar(this.modVenta)) {
               JOptionPane.showMessageDialog(null, "Venta Modificada correctamente");
           } else {
               JOptionPane.showMessageDialog(null, "Error al modificar la Venta");
           }
       }
       
       if (e.getSource() == this.frmVenta.btnEliminar) {
           this.modVenta.setNumero_pedido(Integer.parseInt(this.frmVenta.txtNoDePedido.getText()));
       }
       
        
    }
    
}
