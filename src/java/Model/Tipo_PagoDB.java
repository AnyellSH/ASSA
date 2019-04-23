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
public class Tipo_PagoDB {

    private AccesoDatos accesoDatos  = new AccesoDatos();
//    private Connection conn;
//    LinkedList<Tipo_Pago> lista = new LinkedList<Tipo_Pago>();

    public Tipo_PagoDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public Tipo_PagoDB() {
    }

    /*SELECCIONAR TODOS*/
    public LinkedList<Tipo_Pago> SeleccionarTodos() throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Pago> otraLista = new LinkedList<Tipo_Pago>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id,Descripcion, Estado from Tipo_Pago";

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");
                int est = rsPA.getInt("Estado");

                Tipo_Pago Obj = new Tipo_Pago(id, desc, est);

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
    public LinkedList<Tipo_Pago> SeleccionarUno(int idp) throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Pago> otraLista = new LinkedList<Tipo_Pago>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id,Descripcion, Estado from Tipo_Pago where id= "+idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");
                int est = rsPA.getInt("Estado");

                Tipo_Pago Obj = new Tipo_Pago(id, desc, est);

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
    
    /*ACTUALIZAR UNO DE LA TABLA ID*/
    public LinkedList<Tipo_Pago> Actualizar(int idp,String desp) throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Pago> otraLista = new LinkedList<Tipo_Pago>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Tipo_Pago set Descripcion="+desp+" where id= "+idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");
                int est = rsPA.getInt("Estado");

                Tipo_Pago Obj = new Tipo_Pago(id, desc, est);

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
    public LinkedList<Tipo_Pago> Desactivar(int idp,int estp) throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Pago> otraLista = new LinkedList<Tipo_Pago>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Tipo_Pago set estado="+estp+" where id= "+idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");
                int est = rsPA.getInt("Estado");

                Tipo_Pago barr = new Tipo_Pago(id, desc, est);

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
