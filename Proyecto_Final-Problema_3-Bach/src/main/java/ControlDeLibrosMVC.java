
import Controlador.CtrlLibro;
import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.FormLibro;
import Vista.FormMenuPrincipal;
import Vista. FormTablaLibros;

public class ControlDeLibrosMVC {
    
    public static void main(String[] args) {
        
        Libro modLibro = new Libro();
        ConsultasLibro modConsultasLibro = new ConsultasLibro();
        FormMenuPrincipal frmMenuPrincipal = new FormMenuPrincipal();
        FormTablaLibros frmTablaLibros = new FormTablaLibros();
        FormLibro frmLibro = new FormLibro();

        CtrlLibro controladorLibro = new CtrlLibro(modLibro, modConsultasLibro, frmMenuPrincipal, frmTablaLibros, frmLibro);
        controladorLibro.iniciar();

        frmMenuPrincipal.setVisible(true);
    }
    
}
