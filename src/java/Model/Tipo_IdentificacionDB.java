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
public class Tipo_IdentificacionDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
//    private Connection conn;
//    LinkedList<Tipo_Identificacion> lista = new LinkedList<Tipo_Identificacion>();

    public Tipo_IdentificacionDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public Tipo_IdentificacionDB() {
    }

    /*SELECCIONAR TODOS*/
    public LinkedList<Tipo_Identificacion> SeleccionarTodos() throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Identificacion> otraLista = new LinkedList<Tipo_Identificacion>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id,Descripcion from Tipo_Identificacion";

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");

                Tipo_Identificacion Obj = new Tipo_Identificacion(id, desc);

                otraLista.add(Obj);

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

    /*SELECCIONAR UNO DE TABLA ID*/
    public Tipo_Identificacion SeleccionarUno(int idp) throws SNMPExceptions, SQLException {
        Tipo_Identificacion obj = null;
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id,Descripcion from Tipo_Identificacion where id= " + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");

                //obj = new Tipo_Identificacion(id, desc, est);

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
        return obj;
    }

    /*ACTUALIZAR UNO DE LA TABLA ID*/
    public LinkedList<Tipo_Identificacion> Actualizar(int idp, String desp) throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Identificacion> otraLista = new LinkedList<Tipo_Identificacion>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Tipo_Identificacion set Descripcion=" + desp + " where id= " + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");
                int est = rsPA.getInt("Estado");

                Tipo_Identificacion Obj = new Tipo_Identificacion(id, desc);

                otraLista.add(Obj);

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

    /*DESACTIVAR UNO DE LA TABLA POR ID*/
    public LinkedList<Tipo_Identificacion> Desactivar(int idp, int estp) throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Identificacion> otraLista = new LinkedList<Tipo_Identificacion>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Tipo_Identificacion set estado=" + estp + " where id= " + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");
                int est = rsPA.getInt("Estado");

                Tipo_Identificacion Obj = new Tipo_Identificacion(id, desc);

                otraLista.add(Obj);

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
