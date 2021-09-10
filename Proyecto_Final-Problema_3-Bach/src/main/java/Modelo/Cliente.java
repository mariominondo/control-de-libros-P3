
package Modelo;

import java.sql.Date;

public class Cliente {
    
    private int id_cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre() {
        this.nombre = nombre;
    }
    
    public int getDireccion() {
        return direccion;
    }

    public void setDireccion() {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono() {
        this.telefono = telefono;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }
    
    
}
