/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Pablo Mora
 */
public class Cuerpo_Factura {
    public int id;
    public int idFactura;
    public int idSolicitudPedido;
    public String direccion;    
    public int cantFacturar;
    public String descripcion;
    public double impuesto;
    public double descuento;

    public Cuerpo_Factura() {
    }

    public Cuerpo_Factura(int id, int idFactura, int idSolicitudPedido, String direccion, int cantFacturar, String descripcion, double impuesto, double descuento) {
        this.id = id;
        this.idFactura = idFactura;
        this.idSolicitudPedido = idSolicitudPedido;
        this.direccion = direccion;
        this.cantFacturar = cantFacturar;
        this.descripcion = descripcion;
        this.impuesto = impuesto;
        this.descuento = descuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdSolicitudPedido() {
        return idSolicitudPedido;
    }

    public void setIdSolicitudPedido(int idSolicitudPedido) {
        this.idSolicitudPedido = idSolicitudPedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantFacturar() {
        return cantFacturar;
    }

    public void setCantFacturar(int cantFacturar) {
        this.cantFacturar = cantFacturar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
}
