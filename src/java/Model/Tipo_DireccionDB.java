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
public class Tipo_DireccionDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
//    private Connection conn;
//    LinkedList<Tipo_Direccion> lista = new LinkedList<Tipo_Direccion>();

    public Tipo_DireccionDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public Tipo_DireccionDB() {
    }

    
    /*SELECCIONAR TODOS*/
    public LinkedList<Tipo_Direccion> SeleccionarTodos() throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Direccion> otraLista = new LinkedList<Tipo_Direccion>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id,Descripcion from Tipo_Direccion";

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");

                Tipo_Direccion Obj = new Tipo_Direccion(id, desc);

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
    public LinkedList<Tipo_Direccion> SeleccionarUno(int idp) throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Direccion> otraLista = new LinkedList<Tipo_Direccion>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id,Descripcion from Tipo_Direccion where id= "+idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");

                Tipo_Direccion Obj = new Tipo_Direccion(id, desc);

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
    public LinkedList<Tipo_Direccion> Actualizar(int idp,String desp) throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Direccion> otraLista = new LinkedList<Tipo_Direccion>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Tipo_Direccion set Descripcion="+desp+" where id= "+idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");

                Tipo_Direccion Obj = new Tipo_Direccion(id, desc);

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