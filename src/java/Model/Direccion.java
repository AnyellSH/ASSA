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
public class Direccion {

    public int id;
    public String otrasSennas;
    public String horarios;
    public int estado;
    public int idUsuRegistra;
    public String feRegistra;
    public int idUsuEdita;
    public String feEdita;
    public int idTipoDirreccion;
    public int idProvincia;
    public int idCanton;
    public int idDistrito;
    public int idBarrio;

    public Direccion() {
    }

    public Direccion(int id, String otrasSennas, String horarios, int estado, int idUsuRegistra, String feRegistra, 
            int idUsuEdita, String feEdita, int idTipoDirreccion, int idProvincia, int idCanton, int idDistrito, int idBarrio) {
        this.id = id;
        this.otrasSennas = otrasSennas;
        this.horarios = horarios;
        this.estado = estado;
        this.idUsuRegistra = idUsuRegistra;
        this.feRegistra = feRegistra;
        this.idUsuEdita = idUsuEdita;
        this.feEdita = feEdita;
        this.idTipoDirreccion = idTipoDirreccion;
        this.idProvincia = idProvincia;
        this.idCanton = idCanton;
        this.idDistrito = idDistrito;
        this.idBarrio = idBarrio;
    }
    
    public Direccion(String otrasSennas, String horarios, int estado, int idUsuRegistra, String feRegistra, 
            int idUsuEdita, String feEdita, int idTipoDirreccion, int idProvincia, int idCanton, int idDistrito, int idBarrio) {
        this.otrasSennas = otrasSennas;
        this.horarios = horarios;
        this.estado = estado;
        this.idUsuRegistra = idUsuRegistra;
        this.feRegistra = feRegistra;
        this.idUsuEdita = idUsuEdita;
        this.feEdita = feEdita;
        this.idTipoDirreccion = idTipoDirreccion;
        this.idProvincia = idProvincia;
        this.idCanton = idCanton;
        this.idDistrito = idDistrito;
        this.idBarrio = idBarrio;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOtrasSennas() {
        return otrasSennas;
    }

    public void setOtrasSennas(String otrasSennas) {
        this.otrasSennas = otrasSennas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public int getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }

    public int getIdTipoDirreccion() {
        return idTipoDirreccion;
    }

    public void setIdTipoDirreccion(int idTipoDirreccion) {
        this.idTipoDirreccion = idTipoDirreccion;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }
    
    
}
