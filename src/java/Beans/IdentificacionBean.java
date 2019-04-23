/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.SNMPExceptions;
import Model.Identificacion;
import Model.IdentificacionDB;
import Model.Tipo_Identificacion;
import Model.Tipo_IdentificacionDB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.mail.internet.MailDateFormat;
import javax.naming.NamingException;

/**
 *
 * @author Pablo Mora
 */
@Named(value = "identificacionBean")
@SessionScoped
public class IdentificacionBean implements Serializable {
    
    LinkedList<Tipo_Identificacion> listatip_Identi = new LinkedList<Tipo_Identificacion>();
    
    SimpleDateFormat date = null;
    Date now = new Date(System.currentTimeMillis());
    LinkedList<Identificacion> listaActivos = new LinkedList<Identificacion>();
    LinkedList<Identificacion> listaInactivos = new LinkedList<Identificacion>();
    
    int id;
    String identificacion;
    int estado;
    Tipo_Identificacion tipoIden;
    
    String tipoDes;
    int idUsuReg;
    String fechaR;
    int idUsuEdi;
    String fechaE;
    Boolean estadoV;
    Boolean estadoF;
    
    Tipo_IdentificacionDB TIPODB;
    IdentificacionDB IDB;
    /*MENSAJES DE ERROR*/
    String errorid;
    
    public IdentificacionBean() {
        date = new MailDateFormat();
        TIPODB = new Tipo_IdentificacionDB();
        IDB = new IdentificacionDB();
    }
    
    public LinkedList<Tipo_Identificacion> getListatip_Identi() throws SNMPExceptions, SQLException {
        LinkedList<Tipo_Identificacion> lista = new LinkedList<Tipo_Identificacion>();
        
        lista = TIPODB.SeleccionarTodos();
        
        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }
    
    public void setListatip_Identi(LinkedList<Tipo_Identificacion> listatip_Identi) {
        this.listatip_Identi = listatip_Identi;
    }
    
    public LinkedList<Identificacion> getListaActivos() throws SNMPExceptions, SQLException {
        LinkedList<Identificacion> lista = new LinkedList<Identificacion>();
        
        lista = IDB.SeleccionaTodos();
        
        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }
    
    public void setListaActivos(LinkedList<Identificacion> listaActivos) {
        this.listaActivos = listaActivos;
    }
    
    public LinkedList<Identificacion> getListaInactivos() throws SNMPExceptions, SQLException {
        LinkedList<Identificacion> lista = new LinkedList<Identificacion>();
        
        lista = IDB.SeleccionaTodosDesactivados();
        
        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }
    
    public void setListaInactivos(LinkedList<Identificacion> listaInactivos) {
        this.listaInactivos = listaInactivos;
    }
    
    public SimpleDateFormat getDate() {
        return date;
    }
    
    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }
    
    public Date getNow() {
        return now;
    }
    
    public void setNow(Date now) {
        this.now = now;
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
    
    public Tipo_Identificacion getTipoIden() {
        return tipoIden;
    }
    
    public void setTipoIden(Tipo_Identificacion tipoIden) {
        this.tipoIden = tipoIden;
    }
    
    public String getTipoDes() {
        return tipoDes;
    }
    
    public void setTipoDes(String tipoDes) {
        this.tipoDes = tipoDes;
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
    
    public Tipo_IdentificacionDB getTIPODB() {
        return TIPODB;
    }
    
    public void setTIPODB(Tipo_IdentificacionDB TIPODB) {
        this.TIPODB = TIPODB;
    }
    
    public IdentificacionDB getIDB() {
        return IDB;
    }
    
    public void setIDB(IdentificacionDB IDB) {
        this.IDB = IDB;
    }
    
    public String getErrorid() {
        return errorid;
    }
    
    public void setErrorid(String errorid) {
        this.errorid = errorid;
    }
    
    public void Limpiar() {
        this.setId(0);
        this.setIdentificacion("");
        this.setEstado(0);
        this.setTipoIden(null);
        this.setIdUsuReg(0);
        this.setFechaR("");
        this.setIdUsuEdi(0);
        this.setFechaE("");
    }

    /*GUARDAR EN LA BD*/
    public void Guardar() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        
        this.setId((int) Math.random());
        
        try {
            if (estadoV) {
                estado = 1;
            } else {
                if (estadoF) {
                    estado = 0;
                }
            }
            
            Identificacion obj = new Identificacion(this.getId(), this.getIdentificacion(), this.getEstado(), this.getTipoIden(),
                    this.getIdUsuReg(), this.getDate().format(now), this.getIdUsuEdi(), this.getDate().format(now));
            if (IDB.SeleccionarUno(obj.id) == null) {
                IDB.Guardar(obj);               
            } else {
                 IDB.Actualizar(obj);
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
            
            Identificacion obj = new Identificacion(id, identificacion, estado, tipoIden, idUsuReg, fechaR, idUsuEdi, this.getDate().format(now));
            IDB.Actualizar(obj);
            
            this.Limpiar();
            this.getListaActivos();
        } catch (Exception e) {
            e.toString();
        }
    }

    /*TABLA DE PERFILES ACTIVOS*/
    public void Activo(int idp, int estp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        
        IDB.Desactivar(idp, estp);
        this.getListaActivos();
        this.getListaInactivos();
        
    }

    /*TABLA DE PERFILES INACTIVOS*/
    public void Inactivo(int idp, int estp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        
        IDB.Desactivar(idp, estp);
        this.getListaActivos();
        this.getListaInactivos();
        
    }

    /*ASIGNAR VALORES*/
    public void asignaValores(Identificacion obj) {
        this.setIdentificacion(obj.getIdentificacion());
        this.setTipoIden(obj.getIdTipIdentificacion());
    }
}
