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
public class Persona {

    public int id;
    public int idTipoIdentificacion;
    public String identificacion;
    public String nombre;
    public String pApellido;
    public String sApellido;
    public String contrasenna;
    public int idRol;
    public int estado;
    public int idUsuRegistra;
    public String feRegistra;
    public int idUsuEdita;
    public String feEdita;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Persona() {
    }

    public Persona(int id, int idTipoIdentificacion, String identificacion, String nombre, String pApellido, String sApellido, String contrasenna, 
            int idRol, int estado, int idUsuRegistra, String feRegistra, int idUsuEdita, String feEdita) {
        this.id = id;
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.contrasenna = contrasenna;
        this.idRol = idRol;
        this.estado = estado;
        this.idUsuRegistra = idUsuRegistra;
        this.feRegistra = feRegistra;
        this.idUsuEdita = idUsuEdita;
        this.feEdita = feEdita;
    }

    public Persona(int idTipoIdentificacion, String identificacion, String nombre, String pApellido, String sApellido, String contrasenna, 
            int idRol, int estado, int idUsuRegistra, String feRegistra, int idUsuEdita, String feEdita) {
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.contrasenna = contrasenna;
        this.idRol = idRol;
        this.estado = estado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(int idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
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
