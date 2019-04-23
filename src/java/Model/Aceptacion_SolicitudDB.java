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
 * @author Pablo Mora
 */
public class Aceptacion_SolicitudDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;
    LinkedList<Aceptacion_Solicitud> lista = new LinkedList<Aceptacion_Solicitud>();

    public Aceptacion_SolicitudDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public Aceptacion_SolicitudDB() {
    }

    public LinkedList<Aceptacion_Solicitud> SeleccionarTodos() throws SNMPExceptions, SQLException {

        LinkedList<Aceptacion_Solicitud> otraLista = new LinkedList<Aceptacion_Solicitud>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id,Descripcion from Aceptacion_Solicitud";

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");

                Aceptacion_Solicitud barr = new Aceptacion_Solicitud(id, desc);

                otraLista.add(barr);

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
        return otraLista;
    }

}
