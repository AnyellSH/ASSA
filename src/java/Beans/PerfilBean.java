/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.SNMPExceptions;
import Model.Perfil;
import Model.PerfilDB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author Pablo Mora
 */
@Named(value = "perfilBean")
@SessionScoped
public class PerfilBean implements Serializable {

    SimpleDateFormat date = null;
    Date now = new Date(System.currentTimeMillis());
    LinkedList<Perfil> listaActivos = new LinkedList<Perfil>();
    LinkedList<Perfil> listaInactivos = new LinkedList<Perfil>();

    int id;
    String descripcion;
    int estado;
    int idUsuReg;
    String fechaR;
    int idUsuEdi;
    String fechaE;
    Boolean estadoV;
    Boolean estadoF;

    PerfilDB PDB;
    /*MENSAJES DE ERROR*/
    String errorid;

    public PerfilBean() {
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PDB = new PerfilDB();
    }

    public LinkedList<Perfil> getListaActivos() throws SNMPExceptions, SQLException {
        LinkedList<Perfil> lista = new LinkedList<Perfil>();
        PerfilDB sDB = new PerfilDB();

        lista = sDB.SeleccionaTodos();

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setListaActivos(LinkedList<Perfil> listaActivos) {
        this.listaActivos = listaActivos;
    }

    public LinkedList<Perfil> getListaInactivos() throws SNMPExceptions, SQLException {
        LinkedList<Perfil> lista = new LinkedList<Perfil>();
        PerfilDB sDB = new PerfilDB();

        lista = sDB.SeleccionaTodosDesactivados();

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setListaInactivos(LinkedList<Perfil> listaInactivos) {
        this.listaInactivos = listaInactivos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdUsuReg() {
        return idUsuReg;
    }

    public void setIdUsuReg(int idUsuReg) {
        this.idUsuReg = idUsuReg;
    }

    public String getFechaR() {
        return fechaR;
    }

    public void setFechaR(String fechaR) {
        this.fechaR = fechaR;
    }

    public int getIdUsuEdi() {
        return idUsuEdi;
    }

    public void setIdUsuEdi(int idUsuEdi) {
        this.idUsuEdi = idUsuEdi;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }

    public Boolean getEstadoV() {
        return estadoV;
    }

    public void setEstadoV(Boolean estadoV) {
        this.estadoV = estadoV;
    }

    public Boolean getEstadoF() {
        return estadoF;
    }

    public void setEstadoF(Boolean estadoF) {
        this.estadoF = estadoF;
    }

    public String getErrorid() {
        return errorid;
    }

    public void setErrorid(String errorid) {
        this.errorid = errorid;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public void Limpiar() {
        this.setId(0);
        this.setDescripcion("");
        this.setEstado(0);
        this.setIdUsuReg(0);
        this.setFechaR("");
        this.setIdUsuEdi(0);
        this.setFechaE("");
    }

    /*GUARDAR EN LA BD*/
    public void Guardar() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        if (id <= -1) {
            this.setErrorid("Codigo incorrecto");
        } else {
            this.setErrorid("");
        }

        try {
            if (estadoV) {
                estado = 1;
            } else {
                if (estadoF) {
                    estado = 0;
                }
            }

            Perfil obj = new Perfil(this.getId(), this.getDescripcion(), this.getEstado(),
                    this.getIdUsuReg(), this.getDate().format(now), this.getIdUsuEdi(), this.getDate().format(now));
            if (PDB.SeleccionarUno(obj.id) == null) {
                PDB.Guardar(obj);
            } else {
                PDB.Actualizar(obj);
            }

            this.Limpiar();
            this.getListaActivos();
        } catch (Exception e) {
            e.toString();
        }
    }

    /*ACTUALIZAR EN LA BD*/
    public void Actualizar() {
        try {
            if (estadoV) {
                estado = 1;
            } else {
                if (estadoF) {
                    estado = 0;
                }
            }

            Perfil obj = new Perfil(id, descripcion, estado, idUsuReg, fechaR, idUsuEdi, this.getDate().format(now));
            PDB.Actualizar(obj);

            this.Limpiar();
            this.getListaActivos();
        } catch (Exception e) {
            e.toString();
        }
    }

    /*TABLA DE PERFILES ACTIVOS*/
    public void Activo(int idp, int estp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        PDB.Desactivar(idp, estp);
        this.getListaActivos();
        this.getListaInactivos();

    }

    /*TABLA DE PERFILES INACTIVOS*/
    public void Inactivo(int idp, int estp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        PDB.Desactivar(idp, estp);
        this.getListaActivos();
        this.getListaInactivos();

    }

    /*ASIGNAR VALORES*/
    public void asignaValores(Perfil obj) {
        this.setId(obj.getId());
        this.setDescripcion(obj.getDescripcion());
    }
}
