/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import DAO.SNMPExceptions;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import Model.Barrio;
import Model.BarrioDB;
import Model.Canton;
import Model.CantonDB;
import Model.Distrito;
import Model.DistritoDB;
import Model.Provincia;
import Model.ProvinciaDB;
/**
 *
 * @author Anyel
 */
@Named(value = "provCantDistBarrBean")
@SessionScoped
public class ProvCantDistBarrBean implements Serializable {


  /**
     * Creates a new instance of ProvCantDistBarrBean
     */
        float cod_provincia;
        String dsc_corta_provincia;
        String dsc_provincia;
        float log_activo;
         LinkedList<SelectItem> listaPro = new LinkedList<>(); 
         LinkedList<SelectItem> listaCant = new LinkedList<>(); 
         LinkedList<SelectItem> listaDist = new LinkedList<>(); 
         LinkedList<SelectItem> listaBarr = new LinkedList<>(); 
         float valorP;
         float valorC;
         float valorD;
         float valorB;
         
         public ProvCantDistBarrBean(){
             
         }

    public LinkedList<SelectItem> getListaPro() throws SNMPExceptions, SQLException {
        String dscCortaProvincia="";
        float codigoProvincia=0;
        
        LinkedList<Provincia> lista = new LinkedList<Provincia>();
        ProvinciaDB pDB = new ProvinciaDB();
        
        lista = pDB.todosProvincias();
        
        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, "Seleccione Provincia"));

        for (Iterator iter= lista.iterator();iter.hasNext();) {
            
            Provincia pro = (Provincia) iter.next();
            dscCortaProvincia=pro.getDSC_PROVINCIA();
            codigoProvincia=pro.getCOD_PROVINCIA();
            resultList.add(new SelectItem(codigoProvincia, dscCortaProvincia));
         }         
         return resultList; 
    }

    public void setListaPro(LinkedList<SelectItem> listaPro) {
        this.listaPro = listaPro;
    }

    public LinkedList<SelectItem> getListaCant() throws SNMPExceptions, SQLException {
        String dscCanton="";
        float codigoCanton=0;
        
        LinkedList<Canton> lista = new LinkedList<Canton>();
        CantonDB cDB = new CantonDB();
        
        lista = cDB.todosCantones(this.getValorP());
        
        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, "Seleccione Canton"));
        
        for (Iterator iter= lista.iterator();iter.hasNext();) {
        
            Canton cant = (Canton) iter.next();
            dscCanton=cant.getDSC_CANTON();
            codigoCanton=cant.getCOD_CANTON();
            resultList.add(new SelectItem(codigoCanton,dscCanton));
         }         
         return resultList; 
    }

    public void setListaCant(LinkedList<SelectItem> listaCant) {
        this.listaCant = listaCant;
    }

    public LinkedList<SelectItem> getListaDist() throws SNMPExceptions, SQLException {
         String dscDistrito="";
        float codigoDistrito=0;
        
        LinkedList<Distrito> lista = new LinkedList<Distrito>();
        DistritoDB dDB = new DistritoDB();
        
        lista = dDB.todosDistritos(this.getValorC(),this.getValorP());
        
        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, "Seleccione Distrito"));
        
        for (Iterator iter= lista.iterator();iter.hasNext();) {
        
            Distrito dis = (Distrito) iter.next();
            dscDistrito=dis.getDSC_DISTRITO();
            codigoDistrito=dis.getCOD_DISTRITO();
            resultList.add(new SelectItem(codigoDistrito, dscDistrito));
         }         
         return resultList; 
    }

    public void setListaDist(LinkedList<SelectItem> listaDist) {
        this.listaDist = listaDist;
    }

    public LinkedList<SelectItem> getListaBarr() throws SNMPExceptions, SQLException {
        String dscBarrio="";
        float codigoBarrio=0;
        
        LinkedList<Barrio> lista = new LinkedList<Barrio>();
        BarrioDB dDB = new BarrioDB();
        
        lista = dDB.todosBarrios(this.getValorC(),this.getValorP(),this.getValorD());
        
        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, "Seleccione Barrio"));
        
        for (Iterator iter= lista.iterator();iter.hasNext();) {
        
            Barrio barr = (Barrio) iter.next();
            dscBarrio=barr.getDSC_BARRIO();
            codigoBarrio=barr.getCOD_BARRIO();
            resultList.add(new SelectItem(codigoBarrio, dscBarrio));
         }         
         return resultList;
    }

    public void setListaBarr(LinkedList<SelectItem> listaBarr) {
        this.listaBarr = listaBarr;
    }

    public float getValorP() {
        return valorP;
    }

    public void setValorP(float valorP) {
        this.valorP = valorP;
    }

    public float getValorC() {
        return valorC;
    }

    public void setValorC(float valorC) {
        this.valorC = valorC;
    }

    public float getValorD() {
        return valorD;
    }

    public void setValorD(float valorD) {
        this.valorD = valorD;
    }

    public float getValorB() {
        return valorB;
    }

    public void setValorB(float valorB) {
        this.valorB = valorB;
    }

    public float getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(float cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public String getDsc_corta_provincia() {
        return dsc_corta_provincia;
    }

    public void setDsc_corta_provincia(String dsc_corta_provincia) {
        this.dsc_corta_provincia = dsc_corta_provincia;
    }

    public String getDsc_provincia() {
        return dsc_provincia;
    }

    public void setDsc_provincia(String dsc_provincia) {
        this.dsc_provincia = dsc_provincia;
    }

    public float getLog_activo() {
        return log_activo;
    }

    public void setLog_activo(float log_activo) {
        this.log_activo = log_activo;
    }
         
         
    
}
