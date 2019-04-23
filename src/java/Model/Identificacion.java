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
public class Identificacion {

    public int id;
    public String identificacion;
    public int estado;
    public Tipo_Identificacion idTipIdentificacion;
    public int idUsuRegistra;
    public String feRegistra;
    public int idUsuEdita;
    public String feEdita;

    public Identificacion() {
    }

    public Identificacion(int id, String identificacion, int estado, Tipo_Identificacion idTipIdentificacion, int idUsuRegistra, String feRegistra, int idUsuEdita, String feEdita) {
        this.id = id;
        this.identificacion = identificacion;
        this.estado = estado;
        this.idTipIdentificacion = idTipIdentificacion;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Tipo_Identificacion getIdTipIdentificacion() {
        return idTipIdentificacion;
    }

    public void setIdTipIdentificacion(Tipo_Identificacion idTipIdentificacion) {
        this.idTipIdentificacion = idTipIdentificacion;
    }

    public int getIdUsuRegistra() {
        return idUsuRegistra;
    }

    public void setIdUsuRegistra(int idUsuRegistra) {
        this.idUsuRegistra = idUsuRegistra;
    }

    public String getFeRegistra() {
        return feRegistra;
    }

    public void setFeRegistra(String feRegistra) {
        this.feRegistra = feRegistra;
    }

    public int getIdUsuEdita() {
        return idUsuEdita;
    }

    public void setIdUsuEdita(int idUsuEdita) {
        this.idUsuEdita = idUsuEdita;
    }

    public String getFeEdita() {
        return feEdita;
    }

    public void setFeEdita(String feEdita) {
        this.feEdita = feEdita;
    }
    
    
    

}
