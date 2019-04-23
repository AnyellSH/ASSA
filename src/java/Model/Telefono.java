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
public class Telefono {

    public int id;
    public int estado;
    public String numero;
    public int idTipoTelefono;
    public int idUsuRegistra;
    public String feRegistra;
    public int idUsuEdita;
    public String feEdita;

    public Telefono() {
    }

    public Telefono(int id, String numero, int idTipoTelefono, int idUsuRegistra, String feRegistra, int idUsuEdita, String feEdita) {
        this.id = id;
        this.estado = estado;
        this.numero = numero;
        this.idTipoTelefono = idTipoTelefono;
        this.idUsuRegistra = idUsuRegistra;
        this.feRegistra = feRegistra;
        this.idUsuEdita = idUsuEdita;
        this.feEdita = feEdita;
    }
    
    public Telefono(String numero, int idTipoTelefono, int idUsuRegistra, String feRegistra, int idUsuEdita, String feEdita) {
        this.numero = numero;
        this.idTipoTelefono = idTipoTelefono;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIdTipoTelefono() {
        return idTipoTelefono;
    }

    public void setIdTipoTelefono(int idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
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
