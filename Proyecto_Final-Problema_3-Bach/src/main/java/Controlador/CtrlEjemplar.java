
package Controlador;

import Modelo.ConsultasEjemplar;
import Modelo.Ejemplar;
import Modelo.MiConexion;
import Vista.FormEjemplar;
import Vista.FormMenuPrincipal;
import Vista.FormTablaEjemplares;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        this.frmTablaEjemplares.txtBuscar.setText("Buscar...");
        
        this.frmEjemplar.btnCrear.addActionListener(this);
        this.frmEjemplar.btnModificar.addActionListener(this);
        this.frmEjemplar.btnEliminar.addActionListener(this);
    }
    
    public void actualizaTablaEjemplares() {        
        DefaultTableModel tModelo = new DefaultTableModel();
        this.frmTablaEjemplares.jtEjemplares.setModel(tModelo);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        MiConexion miCon = new MiConexion();
        
        Connection con = miCon.getConnection();
        String sql = "SELECT numero, referencia_libro FROM ejemplares;";
        
        try {     
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();

            tModelo.addColumn("Número");
            tModelo.addColumn("Referencia de Libro");

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
        
        if(e.getSource() == this.frmMenuPrincipal.btnEjemplares){
            this.frmTablaEjemplares.setVisible(true);
            actualizaTablaEjemplares();
        }
        
        if(e.getSource() == this.frmTablaEjemplares.btnCrear){
            this.frmEjemplar.setVisible(true);
        }
        
       if(e.getSource() == this.frmEjemplar.btnCrear){
           this.modEjemplar.setNumero(Integer.parseInt(this.frmEjemplar.txtNumero.getText()));
           this.modEjemplar.setReferencia_libro(Integer.parseInt(this.frmEjemplar.txtReferenciaLibro.getText()));
           
           if(this.modConsultasEjemplar.crear(this.modEjemplar)) {               
            JOptionPane.showMessageDialog(null, "Ejemplar creado exitosamente!");
            actualizaTablaEjemplares();
           } else {
               JOptionPane.showMessageDialog(null, "Error al Agregar.");
           }
       }
       
       if(e.getSource() == this.frmEjemplar.btnEliminar) {
           if(this.modConsultasEjemplar.eliminar(this.modEjemplar)) {
               JOptionPane.showMessageDialog(null, "Ejemplar Eliminado Correctamente.");
               actualizaTablaEjemplares();
           } else {
               JOptionPane.showMessageDialog(null, "El ejemplar no se puedo eliminar.");
           }
       }
       
        
    }
    
}
