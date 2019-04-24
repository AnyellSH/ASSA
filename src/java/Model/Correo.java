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
public class Correo {
    public int id;
    public String correo;    
    public int idUsuRegistra;
    public String feRegistra;
    public int idUsuEdita;
    public String feEdita;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public Correo(int id, String correo, int idUsuRegistra, String feRegistra, int idUsuEdita, String feEdita) {
        this.id = id;
        this.correo = correo;
        this.idUsuRegistra = idUsuRegistra;
        this.feRegistra = feRegistra;
        this.idUsuEdita = idUsuEdita;
        this.feEdita = feEdita;
    }

    public Correo(String correo, int idUsuRegistra, String feRegistra, int idUsuEdita, String feEdita) {
        this.correo = correo;
        this.idUsuRegistra = idUsuRegistra;
        this.feRegistra = feRegistra;
        this.idUsuEdita = idUsuEdita;
        this.feEdita = feEdita;
    }
    
    public Correo() {
    }
}
