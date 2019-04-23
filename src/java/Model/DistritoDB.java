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
public class DistritoDB {
     private AccesoDatos accesoDatos = new AccesoDatos();
     private Connection conn;  
     LinkedList<Distrito> listaDistritos = new LinkedList<Distrito>();
     
     public DistritoDB(Connection conn) {
        accesoDatos = new AccesoDatos();    
        accesoDatos.setDbConn(conn);
     }
     
     public DistritoDB(){
         super();
     }
    
        public LinkedList<Distrito> todosDistritos(float codC,float codP) throws SNMPExceptions, SQLException {
           
            LinkedList<Distrito> listaDist = new LinkedList<Distrito>();
            String select="";
            try{
            
            AccesoDatos accesoDatos = new AccesoDatos(); 
                
            select = "Select COD_DISTRITO,DSC_DISTRITO,LOG_ACTIVO from distritos where COD_CANTON="+codC+" and COD_PROVINCIA="+codP;
            
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);  
                
            while(rsPA.next()){
                 
                    float codDist = rsPA.getFloat("COD_DISTRITO");
                    String dscDist = rsPA.getString("DSC_DISTRITO");
                    float logAct = rsPA.getFloat("LOG_ACTIVO");
                  
                    Distrito dist = new Distrito(codP, codC, codDist,dscDist, logAct);
                    
                    listaDist.add(dist);
                    
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
        return listaDist;
    }
        
        public LinkedList<Distrito> unDist(float codC,float codP, float codD) throws SNMPExceptions, SQLException {
           
            LinkedList<Distrito> listaDist = new LinkedList<Distrito>();
            String select="";
            try{
            
            AccesoDatos accesoDatos = new AccesoDatos(); 
                
            select = "Select COD_DISTRITO,DSC_DISTRITO,LOG_ACTIVO from distritos where COD_CANTON="+codC+" and COD_PROVINCIA="+codP+
                    "and COD_DISTRITO ="+codD;
            
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);  
                
            while(rsPA.next()){
                 
                    float codDist = rsPA.getFloat("COD_DISTRITO");
                    String dscDist = rsPA.getString("DSC_DISTRITO");
                    float logAct = rsPA.getFloat("LOG_ACTIVO");
                  
                    Distrito dist = new Distrito(codP, codC, codDist,dscDist, logAct);
                    
                    listaDist.add(dist);
                    
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
        return listaDist;
    }
}
