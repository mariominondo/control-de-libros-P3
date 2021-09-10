
package Modelo;

import java.sql.Date;

public class Libro {
    
    private int numero_pedido;
    private Date fecha_pedido;
    private int referencia_libro;
    private int referencia_cliente;
    private int cantidad_compra;
    private Double monto_total;

    public int getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(int numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFechaPedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public int getReferencia_libro() {
        return referencia_libro;
    }

    public void setReferencia_libro(int referencia_libro) {
        this.referencia_libro = referencia_libro;
    }

    public int getReferencia_cliente() {
        return referencia_cliente;
    }

    public void setReferencia_cliente(int referencia_cliente) {
        this.referencia_cliente = referencia_cliente;
    }

    public int getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(int cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }

    public Double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }
    
    
}
