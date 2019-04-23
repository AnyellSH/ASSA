/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
/**
 *
 * @author Anyel
 */
public class CantonDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;  
    LinkedList<Canton> listaCantones= new LinkedList<Canton>();
    
    public CantonDB(Connection conn) {
        accesoDatos = new AccesoDatos();    
        accesoDatos.setDbConn(conn);
    }
    
    public CantonDB(){
        super();
    }
    
        public LinkedList<Canton> todosCantones(float codPro) throws SNMPExceptions, SQLException {
           
            LinkedList<Canton> listaCant = new LinkedList<Canton>();
            String select="";
            try{
            
            AccesoDatos accesoDatos = new AccesoDatos();
                  
            select = "Select COD_CANTON, DSC_CANTON, LOG_ACTIVO FROM cantones where COD_PROVINCIA="+codPro;
            
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
                
            while(rsPA.next()){
                    float codCan = rsPA.getFloat("COD_CANTON");
                    String descCant = rsPA.getString("DSC_CANTON");
                    float logAct = rsPA.getFloat("LOG_ACTIVO");
                  
                    
                    Canton cant = new Canton(codPro, codCan, descCant, logAct);
                    
                    listaCant.add(cant);
                    
                }
               rsPA.close();
            } catch (SQLException e) {
                throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                        e.getMessage(), e.getErrorCode());
            }catch (Exception e) {
                throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                        e.getMessage());
            } finally {
            }
        return listaCant;
    }
        
        public LinkedList<Canton> unCant(float codPro,float codCant) throws SNMPExceptions, SQLException {
           
            LinkedList<Canton> listaCant = new LinkedList<Canton>();
            String select="";
            try{
            
            AccesoDatos accesoDatos = new AccesoDatos();
                  
            select = "Select COD_CANTON, DSC_CANTON, LOG_ACTIVO FROM cantones where COD_PROVINCIA="+codPro+"and COD_CANTON="+
                    codCant;
            
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
                
            while(rsPA.next()){
                    float codCan = rsPA.getFloat("COD_CANTON");
                    String descCant = rsPA.getString("DSC_CANTON");
                    float logAct = rsPA.getFloat("LOG_ACTIVO");
                  
                    
                    Canton cant = new Canton(codPro, codCan, descCant, logAct);
                    
                    listaCant.add(cant);
                    
                }
               rsPA.close();
            } catch (SQLException e) {
                throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                        e.getMessage(), e.getErrorCode());
            }catch (Exception e) {
                throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                        e.getMessage());
            } finally {
            }
        return listaCant;
    }
}
