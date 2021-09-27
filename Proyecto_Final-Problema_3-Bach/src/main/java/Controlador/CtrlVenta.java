
package Controlador;

import Modelo.ConsultasVenta;
import Modelo.MiConexion;
import Modelo.Venta;
import Vista.FormVenta;
import Vista.FormMenuPrincipal;
import Vista.FormTablaVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlVenta implements ActionListener {

    private Venta modVenta;
    private ConsultasVenta modConsultasVenta;
    private FormMenuPrincipal frmMenuPrincipal;
    private FormTablaVentas frmTablaVentas;
    private FormVenta frmVenta;
    
    public CtrlVenta (Venta modVenta, ConsultasVenta modConsultasVenta, FormMenuPrincipal frmMenuPrincipal, FormTablaVentas frmTablaVentas, FormVenta frmVenta) {
        this.modVenta = modVenta;
        this.modConsultasVenta = modConsultasVenta;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmTablaVentas = frmTablaVentas;
        this.frmVenta = frmVenta;
        
        this.frmMenuPrincipal.btnVentas.addActionListener(this);
                
        this.frmTablaVentas.btnCrear.addActionListener(this);
        this.frmTablaVentas.btnBuscar.addActionListener(this);
        this.frmTablaVentas.txtBuscar.setText("Buscar...");
        
        this.frmVenta.btnCrear.addActionListener(this);
        this.frmVenta.btnModificar.addActionListener(this);
        this.frmVenta.btnEliminar.addActionListener(this);
    }
    
    public void iniciar() {    
        frmMenuPrincipal.setTitle("Menú Principal");
    }
    
    public void actualizaTablaVentas() {
        DefaultTableModel tModelo = new DefaultTableModel();
        this.frmTablaVentas.jtTablaVentas.setModel(tModelo);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        MiConexion miCon = new MiConexion();
        
        Connection con = miCon.getConnection();
        
        String sql = "SELECT numero_pedido, fecha_pedido, referencia_libro, \n " +
                     "referencia_cliente, cantidad_compra, monto_total \n " +
                     "FROM ventas;";
        
        try {        
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            
            tModelo.addColumn("numero_pedido");
            tModelo.addColumn("fecha_pedido");
            tModelo.addColumn("referencia_libro");
            tModelo.addColumn("referencia_cliente");
            tModelo.addColumn("cantidad_compra");
            tModelo.addColumn("monto_total");
            
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
        
        if(e.getSource() == this.frmMenuPrincipal.btnVentas){
            frmTablaVentas.setVisible(true);
            actualizaTablaVentas();
        }
        
        if(e.getSource() == this.frmTablaVentas.btnCrear){
            frmVenta.setVisible(true);
        }
        
       if(e.getSource() == this.frmVenta.btnCrear){
           java.util.Date jdate = this.frmVenta.jdateFechaPedido.getDate();
           SimpleDateFormat formatedDate = new SimpleDateFormat("yyyy-MM-dd");
           String stringDate = formatedDate.format(jdate);
           java.sql.Date sqlDate = java.sql.Date.valueOf(stringDate);
           
           
           this.modVenta.setFechaPedido(sqlDate);
           this.modVenta.setReferencia_libro(Integer.parseInt(this.frmVenta.txtReferenciaLibro.getText()));
           this.modVenta.setReferencia_cliente(Integer.parseInt(this.frmVenta.txtReferenciaCliente.getText()));
           this.modVenta.setCantidad_compra(Integer.parseInt(this.frmVenta.txtCantidad.getText()));
           this.modVenta.setMonto_total(Double.parseDouble(this.frmVenta.txtMonto.getText()));
           
           this.modVenta.setNumero_pedido(Integer.parseInt(this.frmVenta.txtNoDePedido.getText()));

           if (this.modConsultasVenta.crear(this.modVenta)) {
               JOptionPane.showMessageDialog(null, "Venta Creada correctamente");
               actualizaTablaVentas();
           } else {
               JOptionPane.showMessageDialog(null, "Error al crear la Venta");
           }
       }
       
       if (e.getSource() == this.frmVenta.btnModificar) {
           java.util.Date jdate = this.frmVenta.jdateFechaPedido.getDate();
           SimpleDateFormat formatedDate = new SimpleDateFormat("yyyy-MM-dd");
           String stringDate = formatedDate.format(jdate);
           java.sql.Date sqlDate = java.sql.Date.valueOf(stringDate);
           
           this.modVenta.setFechaPedido(sqlDate);
           this.modVenta.setNumero_pedido(Integer.parseInt(this.frmVenta.txtNoDePedido.getText()));
           this.modVenta.setReferencia_libro(Integer.parseInt(this.frmVenta.txtReferenciaLibro.getText()));
           this.modVenta.setReferencia_cliente(Integer.parseInt(this.frmVenta.txtReferenciaCliente.getText()));
           this.modVenta.setCantidad_compra(Integer.parseInt(this.frmVenta.txtCantidad.getText()));
           this.modVenta.setMonto_total(Double.parseDouble(this.frmVenta.txtMonto.getText()));
           
           if (this.modConsultasVenta.modificar(this.modVenta)) {
               JOptionPane.showMessageDialog(null, "Venta Modificada correctamente");
               actualizaTablaVentas();
           } else {
               JOptionPane.showMessageDialog(null, "Error al modificar la Venta");
           }
       }
       
       if (e.getSource() == this.frmVenta.btnEliminar) {
           this.modVenta.setNumero_pedido(Integer.parseInt(this.frmVenta.txtNoDePedido.getText()));
           
           if(this.modConsultasVenta.eliminar(this.modVenta)) {
                JOptionPane.showMessageDialog(null, "Venta eliminada");
                actualizaTablaVentas();
           } else {
               JOptionPane.showMessageDialog(null, "Error al Eliminar");
           }
       }
       
        
    }
    
}
