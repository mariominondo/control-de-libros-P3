
package Controlador;

import Modelo.ConsultasCliente;
import Modelo.Cliente;
import Modelo.MiConexion;
import Vista.FormCliente;
import Vista.FormMenuPrincipal;
import Vista.FormTablaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        this.frmTablaClientes.txtBuscar.setText("Buscar...");
        
        this.frmCliente.btnCrear.addActionListener(this);
        this.frmCliente.btnModificar.addActionListener(this);
        this.frmCliente.btnEliminar.addActionListener(this);
    }
    
    public void actualizaTablaClientes() {        
        DefaultTableModel tModelo = new DefaultTableModel();
        this.frmTablaClientes.jtClientes.setModel(tModelo);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        MiConexion miCon = new MiConexion();
        
        Connection con = miCon.getConnection();
        
        String sql = "SELECT id_cliente, nombre, direccion, telefono, email FROM clientes;";
        
        try {        
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            
            tModelo.addColumn("ID Cliente");
            tModelo.addColumn("Nombre");
            tModelo.addColumn("Dirección");
            tModelo.addColumn("Teléfono");
            tModelo.addColumn("Email");
            
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
        
        if(e.getSource() == this.frmMenuPrincipal.btnClientes){
            frmTablaClientes.setVisible(true);
            actualizaTablaClientes();
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
               actualizaTablaClientes();
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
               actualizaTablaClientes();
           } else {
               JOptionPane.showMessageDialog(null, "Error al Modificar");
           }
       }   
       
       if (e.getSource() == this.frmCliente.btnEliminar) {
           this.modCliente.setId_cliente(Integer.parseInt(this.frmCliente.txtCodigoDeUsuario.getText()));
           
           if(this.modConsultasCliente.eliminar(this.modCliente)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                actualizaTablaClientes();
           } else {
               JOptionPane.showMessageDialog(null, "Error al Eliminar");
           }
       }
        
    }
    
}
