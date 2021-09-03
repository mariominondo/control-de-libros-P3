
package Modelo;

import java.sql.Date;

public class Libro {
    
    private int codigo_libro;
    private String titulo;
    private String genero_literario;
    private String editorial;
    private String autor;
    private Date anio_edicion;
    private int numero_edicion;
    private String pais_origen;
    private int numero_paginas;
    private int cantidad_ejemplares;
    private Double precio;

    public int getCodigo_libro() {
        return codigo_libro;
    }

    public void setCodigo_libro(int codigo_libro) {
        this.codigo_libro = codigo_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero_literario() {
        return genero_literario;
    }

    public void setGenero_literario(String genero_literario) {
        this.genero_literario = genero_literario;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getAnio_edicion() {
        return anio_edicion;
    }

    public void setAnio_edicion(Date anio_edicion) {
        this.anio_edicion = anio_edicion;
    }

    public int getNumero_edicion() {
        return numero_edicion;
    }

    public void setNumero_edicion(int numero_edicion) {
        this.numero_edicion = numero_edicion;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public int getCantidad_ejemplares() {
        return cantidad_ejemplares;
    }

    public void setCantidad_ejemplares(int cantidad_ejemplares) {
        this.cantidad_ejemplares = cantidad_ejemplares;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
    
}
