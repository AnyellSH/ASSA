/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Pablo Mora
 */
public class Detalle_Factura {

    public int id;
    public double subTotal;
    public double descTotal;
    public double impTotal;
    public double totalFactura;
    public String descripcion;
    public int idCuerpoFactura;

    public Detalle_Factura() {
    }

    public Detalle_Factura(int id, double subTotal, double descTotal, double impTotal, double totalFactura, String descripcion, int idCuerpoFactura) {
        this.id = id;
        this.subTotal = subTotal;
        this.descTotal = descTotal;
        this.impTotal = impTotal;
        this.totalFactura = totalFactura;
        this.descripcion = descripcion;
        this.idCuerpoFactura = idCuerpoFactura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescTotal() {
        return descTotal;
    }

    public void setDescTotal(double descTotal) {
        this.descTotal = descTotal;
    }

    public double getImpTotal() {
        return impTotal;
    }

    public void setImpTotal(double impTotal) {
        this.impTotal = impTotal;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCuerpoFactura() {
        return idCuerpoFactura;
    }

    public void setIdCuerpoFactura(int idCuerpoFactura) {
        this.idCuerpoFactura = idCuerpoFactura;
    }
    
}
