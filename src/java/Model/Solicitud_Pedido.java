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
public class Solicitud_Pedido {

    public int id;
    public Date fecha;
    public int idPersona;
    public int idDireccion;
    public int cantidad;
    public double precioProd;
    public int idAcepPedido;
    public int idMedDespacho;
    public int idTipoPago;
    public int idUsuRegistra;
    public Date feRegistra;
    public int idUsuEdita;
    public Date feEdita;

    public Solicitud_Pedido() {
    }

    public Solicitud_Pedido(int id, Date fecha, int idPersona, int idDireccion, int cantidad, double precioProd, int idAcepPedido, int idMedDespacho, int idTipoPago, int idUsuRegistra, Date feRegistra, int idUsuEdita, Date feEdita) {
        this.id = id;
        this.fecha = fecha;
        this.idPersona = idPersona;
        this.idDireccion = idDireccion;
        this.cantidad = cantidad;
        this.precioProd = precioProd;
        this.idAcepPedido = idAcepPedido;
        this.idMedDespacho = idMedDespacho;
        this.idTipoPago = idTipoPago;
        this.idUsuRegistra = idUsuRegistra;
        this.feRegistra = feRegistra;
        this.idUsuEdita = idUsuEdita;
        this.feEdita = feEdita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public int getIdAcepPedido() {
        return idAcepPedido;
    }

    public void setIdAcepPedido(int idAcepPedido) {
        this.idAcepPedido = idAcepPedido;
    }

    public int getIdMedDespacho() {
        return idMedDespacho;
    }

    public void setIdMedDespacho(int idMedDespacho) {
        this.idMedDespacho = idMedDespacho;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public int getIdUsuRegistra() {
        return idUsuRegistra;
    }

    public void setIdUsuRegistra(int idUsuRegistra) {
        this.idUsuRegistra = idUsuRegistra;
    }

    public Date getFeRegistra() {
        return feRegistra;
    }

    public void setFeRegistra(Date feRegistra) {
        this.feRegistra = feRegistra;
    }

    public int getIdUsuEdita() {
        return idUsuEdita;
    }

    public void setIdUsuEdita(int idUsuEdita) {
        this.idUsuEdita = idUsuEdita;
    }

    public Date getFeEdita() {
        return feEdita;
    }

    public void setFeEdita(Date feEdita) {
        this.feEdita = feEdita;
    }
    
    
}
