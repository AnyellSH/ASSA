/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.SNMPExceptions;
import Model.Barrio;
import Model.Canton;
import Model.CantonDB;
import Model.Direccion;
import Model.DireccionDB;
import Model.Distrito;
import Model.Persona;
import Model.Provincia;
import Model.ProvinciaDB;
import Model.Tipo_Direccion;
import Model.Tipo_DireccionDB;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Anyel
 */
@Named(value = "direccionBean")
@SessionScoped
public class DireccionBean implements Serializable {
    
    Persona per;
    SimpleDateFormat date = null;
    int id;
    String otrasSennas;
    String horarios;
    int estado;
    int idUsuRegistra;
    String feRegistra;
    int idUsuEdita;
    String feEdita;
    int idTipoDireccion;
    int idProvincia;
    int idCanton;
    int idDistrito;
    int idBarrio;
    Date now = new Date(System.currentTimeMillis());
    String esconderFormulario = "hidden";
    String esconderBotones;
    LinkedList<Tipo_Direccion> listaTipos = new LinkedList<Tipo_Direccion>();
    LinkedList<Direccion> listaDirecciones = new LinkedList<Direccion>();
    LinkedList<Provincia> listaProvincias = new LinkedList<Provincia>();
    LinkedList<Canton> listaCantones = new LinkedList<Canton>();
    LinkedList<Distrito> listaDistritos = new LinkedList<Distrito>();
    LinkedList<Barrio> listaBarrios = new LinkedList<Barrio>();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public int getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }

    public int getIdTipoDireccion() {
        return idTipoDireccion;
    }

    public void setIdTipoDireccion(int idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
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
        return this.getDate().format(now);
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
        return this.getDate().format(now);
    }

    public void setFeEdita(String feEdita) {
        this.feEdita = feEdita;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    
    public String getEsconderFormulario() {
        return esconderFormulario;
    }

    public void setEsconderFormulario(String esconderFormulario) {
        this.esconderFormulario = esconderFormulario;
    }

    public Persona getPer() {
        return per;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    public LinkedList<Tipo_Direccion> getListaTipos() throws SNMPExceptions, SQLException {
        LinkedList<Tipo_Direccion> lista = new LinkedList<Tipo_Direccion>();
        Tipo_DireccionDB tipoDB = new Tipo_DireccionDB();
        lista = tipoDB.SeleccionarTodos();
        Tipo_Direccion td = new Tipo_Direccion(0, "");
        lista.offerFirst(td);
        return lista;
    }

    public void setListaTipos(LinkedList<Tipo_Direccion> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public String getEsconderBotones() {
        return esconderBotones;
    }

    public void setEsconderBotones(String esconderBotones) {
        this.esconderBotones = esconderBotones;
    }

    public LinkedList<Direccion> getListaDirecciones(int id) throws SNMPExceptions, SQLException {
        LinkedList<Direccion> lista = new LinkedList<Direccion>();
        DireccionDB dirDB = new DireccionDB();
        lista = dirDB.SeleccionarTodos(id);
        return lista;
    }

    public void setListaDirecciones(LinkedList<Direccion> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }

    public String getOtrasSennas() {
        return otrasSennas;
    }

    public void setOtrasSennas(String otrasSennas) {
        this.otrasSennas = otrasSennas;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
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

    public LinkedList<Provincia> getListaProvincias() throws SNMPExceptions, SQLException {
        LinkedList<Provincia> lista = new LinkedList<Provincia>();
        ProvinciaDB proDB = new ProvinciaDB(); 
        lista = proDB.todosProvincias();
        return lista;
    }

    public void setListaProvincias(LinkedList<Provincia> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    public LinkedList<Canton> getListaCantones() throws SNMPExceptions, SQLException {
        LinkedList<Canton> lista = new LinkedList<Canton>();
        CantonDB canDB = new CantonDB();
        lista = canDB.todosCantones(this.getIdProvincia());
        return lista;
    }

    public void setListaCantones(LinkedList<Canton> listaCantones) {
        this.listaCantones = listaCantones;
    }

    public LinkedList<Distrito> getListaDistritos() {
        return listaDistritos;
    }

    public void setListaDistritos(LinkedList<Distrito> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }

    public LinkedList<Barrio> getListaBarrios() {
        return listaBarrios;
    }

    public void setListaBarrios(LinkedList<Barrio> listaBarrios) {
        this.listaBarrios = listaBarrios;
    }
       
    public void cargarPagina(){
    }
    
    
    public String irARegistroDireccion(Persona per){
        this.setPer(per);
        return "direccionAgregar.xhtml?faces-redirect=true&includeViewParams=true";
    }
    
    
    public String ocultarFormulario(){
        this.setEsconderFormulario("hidden");
        this.setEsconderBotones("");
        return "direccionMant.xhtml?faces-redirect=true";
    }
    
    public void cargarComboCanton() throws SQLException, SNMPExceptions{
        this.getListaCantones();
    }
    
}
