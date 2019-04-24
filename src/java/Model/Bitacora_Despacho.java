/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
//import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import java.util.Date;
/**
 *
 * @author Pablo Mora
 */
public class Bitacora_Despacho {
    public int id;
    public Date fechahora;
    public int idEmpleado;
    public int idEncFactura;
    public String medioDespacho;
    public int idUsuRegistra;
    public Date feRegistra;
    public int idUsuEdita;
    public Date feEdita;

    public Bitacora_Despacho() {
    }

    public Bitacora_Despacho(int id, Date fechahora, int idEmpleado, int idEncFactura, String medioDespacho, int idUsuRegistra, Date feRegistra, int idUsuEdita, Date feEdita) {
        this.id = id;
        this.fechahora = fechahora;
        this.idEmpleado = idEmpleado;
        this.idEncFactura = idEncFactura;
        this.medioDespacho = medioDespacho;
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

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEncFactura() {
        return idEncFactura;
    }

    public void setIdEncFactura(int idEncFactura) {
        this.idEncFactura = idEncFactura;
    }

    public String getMedioDespacho() {
        return medioDespacho;
    }

    public void setMedioDespacho(String medioDespacho) {
        this.medioDespacho = medioDespacho;
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
