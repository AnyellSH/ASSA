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
public class ProvinciaDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;
    LinkedList<Provincia> listaProvincias = new LinkedList<Provincia>();

    public ProvinciaDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public ProvinciaDB() {
        super();
    }

    public LinkedList<Provincia> todosProvincias() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Provincia> listaPro = new LinkedList<Provincia>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA,DSC_CORTA_PROVINCIA,DSC_PROVINCIA,LOG_ACTIVO FROM provincias";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float codigoProvincia = rsPA.getFloat("COD_PROVINCIA");
                String dscCortaProvincia = rsPA.getString("DSC_CORTA_PROVINCIA");
                String dscProvincia = rsPA.getString("DSC_PROVINCIA");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                Provincia perProvincia = new Provincia(codigoProvincia, dscCortaProvincia, dscProvincia, logActivo);
                listaPro.add(perProvincia);
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

        return listaPro;
    }

    public LinkedList<Provincia> unaPro(float valorP) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Provincia> listaPro = new LinkedList<Provincia>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA,DSC_CORTA_PROVINCIA,DSC_PROVINCIA,LOG_ACTIVO FROM provincias where COD_PROVINCIA =" + valorP;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float codigoProvincia = rsPA.getFloat("COD_PROVINCIA");
                String dscCortaProvincia = rsPA.getString("DSC_CORTA_PROVINCIA");
                String dscProvincia = rsPA.getString("DSC_PROVINCIA");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                Provincia perProvincia = new Provincia(codigoProvincia, dscCortaProvincia, dscProvincia, logActivo);
                listaPro.add(perProvincia);
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

        return listaPro;
    }
}
