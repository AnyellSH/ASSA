/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Anyel
 */
public class Barrio {
    
    public float COD_PROVINCIA;
    public float COD_CANTON;
    public float COD_DISTRITO;
    public float COD_BARRIO;
    public String DSC_BARRIO;
    public float LOG_ACTIVO;

    public Barrio(float COD_PROV, float COD_CANT, float COD_DIST, float COD_BARR, String DSC_BARR, float LOG_ACT) {
        this.setCOD_PROVINCIA(COD_PROV);
        this.setCOD_CANTON(COD_CANT);
        this.setCOD_DISTRITO(COD_DIST);
        this.setCOD_BARRIO(COD_BARR);
        this.setDSC_BARRIO(DSC_BARR);
        this.setLOG_ACTIVO(LOG_ACT);
    }
    
    public Barrio(){
        super();
    }

    public float getCOD_PROVINCIA() {
        return COD_PROVINCIA;
    }

    public void setCOD_PROVINCIA(float COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }

    public float getCOD_CANTON() {
        return COD_CANTON;
    }

    public void setCOD_CANTON(float COD_CANTON) {
        this.COD_CANTON = COD_CANTON;
    }

    public float getCOD_DISTRITO() {
        return COD_DISTRITO;
    }

    public void setCOD_DISTRITO(float COD_DISTRITO) {
        this.COD_DISTRITO = COD_DISTRITO;
    }

    public float getCOD_BARRIO() {
        return COD_BARRIO;
    }

    public void setCOD_BARRIO(float COD_BARRIO) {
        this.COD_BARRIO = COD_BARRIO;
    }

    public String getDSC_BARRIO() {
        return DSC_BARRIO;
    }

    public void setDSC_BARRIO(String DSC_BARRIO) {
        this.DSC_BARRIO = DSC_BARRIO;
    }

    public float getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(float LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
    
}
