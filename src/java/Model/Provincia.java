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
public class Provincia {
   public float COD_PROVINCIA;
    public String DSC_CORTA_PROVINCIA;
    public String DSC_PROVINCIA;
    public float LOG_ACTIVO;

    public Provincia(float COD_PROVINCIA, String DSC_CORTA_PROVINCIA, String DSC_PROVINCIA, float LOG_ACTIVO) {
        this.setCOD_PROVINCIA(COD_PROVINCIA);
        this.setDSC_CORTA_PROVINCIA(DSC_CORTA_PROVINCIA);
        this.setDSC_PROVINCIA(DSC_PROVINCIA);
        this.setLOG_ACTIVO(LOG_ACTIVO);
    }

    public Provincia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float getCOD_PROVINCIA() {
        return COD_PROVINCIA;
    }

    public void setCOD_PROVINCIA(float COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }

    public String getDSC_CORTA_PROVINCIA() {
        return DSC_CORTA_PROVINCIA;
    }

    public void setDSC_CORTA_PROVINCIA(String DSC_CORTA_PROVINCIA) {
        this.DSC_CORTA_PROVINCIA = DSC_CORTA_PROVINCIA;
    }

    public String getDSC_PROVINCIA() {
        return DSC_PROVINCIA;
    }

    public void setDSC_PROVINCIA(String DSC_PROVINCIA) {
        this.DSC_PROVINCIA = DSC_PROVINCIA;
    }

    public float getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(float LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
    
}
