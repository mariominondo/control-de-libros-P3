
import Controlador.CtrlCliente;
import Controlador.CtrlEjemplar;
import Controlador.CtrlLibro;
import Controlador.CtrlVenta;
import Modelo.Cliente;
import Modelo.ConsultasCliente;
import Modelo.ConsultasEjemplar;
import Modelo.ConsultasLibro;
import Modelo.ConsultasVenta;
import Modelo.Ejemplar;
import Modelo.Libro;
import Modelo.Venta;
import Vista.FormCliente;
import Vista.FormEjemplar;
import Vista.FormLibro;
import Vista.FormMenuPrincipal;
import Vista.FormTablaClientes;
import Vista.FormTablaEjemplares;
import Vista.FormTablaLibros;
import Vista.FormTablaVentas;
import Vista.FormVenta;

public class ControlDeLibrosMVC {
    
    public static void main(String[] args) {
        
        FormMenuPrincipal frmMenuPrincipal = new FormMenuPrincipal();
        
        Libro modLibro = new Libro();
        ConsultasLibro modConsultasLibro = new ConsultasLibro();
        FormTablaLibros frmTablaLibros = new FormTablaLibros();
        FormLibro frmLibro = new FormLibro();
        
        Ejemplar modEjemplar = new Ejemplar();
        ConsultasEjemplar modConsultasEjemplar = new ConsultasEjemplar();
        FormTablaEjemplares frmTablaEjemplares = new FormTablaEjemplares();
        FormEjemplar frmEjemplar = new FormEjemplar();
        
        Cliente modCliente = new Cliente();
        ConsultasCliente modConsultasCliente = new ConsultasCliente();
        FormTablaClientes frmTablaClientes = new FormTablaClientes();
        FormCliente frmCliente = new FormCliente();
        
        Venta modVenta = new Venta();
        ConsultasVenta modConsultasVenta = new ConsultasVenta();
        FormTablaVentas frmTablaVentas = new FormTablaVentas();
        FormVenta frmVenta = new FormVenta();

        CtrlLibro controladorLibro = new CtrlLibro(modLibro, modConsultasLibro, frmMenuPrincipal, frmTablaLibros, frmLibro);
        controladorLibro.iniciar();
        
        CtrlEjemplar controladorEjemplar = new CtrlEjemplar(modEjemplar, modConsultasEjemplar, frmMenuPrincipal, frmTablaEjemplares, frmEjemplar);

        CtrlCliente controladorCliente = new CtrlCliente(modCliente, modConsultasCliente, frmMenuPrincipal, frmTablaClientes, frmCliente);
        
        CtrlVenta controladorVenta = new CtrlVenta(modVenta, modConsultasVenta, frmMenuPrincipal, frmTablaVentas, frmVenta);
        
        frmMenuPrincipal.setVisible(true);
    }
    
}
