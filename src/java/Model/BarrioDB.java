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
public class BarrioDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;
    LinkedList<Barrio> listaBarrios = new LinkedList<Barrio>();

    public BarrioDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public BarrioDB() {
    }

    public LinkedList<Barrio> todosBarrios(float codC, float codP, float codD) throws SNMPExceptions, SQLException {

        LinkedList<Barrio> listaBarr = new LinkedList<Barrio>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select COD_BARRIO,DSC_BARRIO,LOG_ACTIVO from Barrios where COD_CANTON=" + codC + " and COD_PROVINCIA=" + codP + " and COD_DISTRITO=" + codD;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                float codB = rsPA.getFloat("COD_BARRIO");
                String dscDist = rsPA.getString("DSC_BARRIO");
                float logAct = rsPA.getFloat("LOG_ACTIVO");

                Barrio barr = new Barrio(codP, codC, codD, codB, dscDist, logAct);

                listaBarr.add(barr);

            }
            rsPA.close();
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
        return listaBarr;
    }

    public LinkedList<Barrio> unBarrio(float codC, float codP, float codD, float codB) throws SNMPExceptions, SQLException {

        LinkedList<Barrio> listaBarr = new LinkedList<Barrio>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select COD_BARRIO,DSC_BARRIO,LOG_ACTIVO from Barrios where COD_CANTON=" + codC + " and COD_PROVINCIA=" + codP + " and COD_DISTRITO=" + codD
                    + "and COD_BARRIO =" + codB;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                float cdB = rsPA.getFloat("COD_BARRIO");
                String dscDist = rsPA.getString("DSC_BARRIO");
                float logAct = rsPA.getFloat("LOG_ACTIVO");

                Barrio barr = new Barrio(codP, codC, codD, codB, dscDist, logAct);

                listaBarr.add(barr);

            }
            rsPA.close();
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
        return listaBarr;
    }
}
