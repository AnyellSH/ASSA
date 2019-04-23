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
public class Distrito {
   public float COD_PROVINCIA;
    public float COD_CANTON;
    public float COD_DISTRITO;
    public String DSC_DISTRITO;
    public float LOG_ACTIVO;

    public Distrito(float COD_PROVINCIA, float COD_CANTON, float COD_DISTRITO, String DSC_DISTRITO, float LOG_ACTIVO) {
        this.setCOD_PROVINCIA(COD_PROVINCIA);
        this.setCOD_CANTON(COD_CANTON);
        this.setCOD_DISTRITO(COD_DISTRITO);
        this.setDSC_DISTRITO(DSC_DISTRITO);
        this.setLOG_ACTIVO(LOG_ACTIVO);
    }

    public Distrito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getDSC_DISTRITO() {
        return DSC_DISTRITO;
    }

    public void setDSC_DISTRITO(String DSC_DISTRITO) {
        this.DSC_DISTRITO = DSC_DISTRITO;
    }

    public float getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(float LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
    
}
