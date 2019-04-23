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
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Pablo Mora
 */
public class RolDB {

    private AccesoDatos accesoDatos = new AccesoDatos();

    public RolDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public RolDB() {
    }

    /*SELECCIONAR TODOS*/
    public LinkedList<Rol> SeleccionarTodos() throws SNMPExceptions, SQLException {

        LinkedList<Rol> otraLista = new LinkedList<Rol>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select * from Rol";

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String descrip = rsPA.getString("Descripcion");
                
                Rol Obj = new Rol(id, descrip);
                
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
    public Rol SeleccionarUno(int idp) throws SNMPExceptions, SQLException {
        Rol Obj = null;
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select * from Rol where id = " + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String decrip = rsPA.getString("Descripcion");

                Obj = new Rol(id, decrip);
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
        return Obj;

    }

    /*SELECCIONAR TODOS LOS DESACTIVADOS*/
    public LinkedList<Rol> SeleccionaTodosDesactivados() throws SNMPExceptions, SQLException   {
        String select = "";

        LinkedList<Rol> lista = new LinkedList<Rol>();

        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se instancia la clase de acceso a datos
//            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT * from dbo.Rol";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los catálogos   
            while (rsPA.next()) {

                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Descripcion");

                Rol obj = new Rol(idPro, nombre);
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

        return lista;
    }

    /*GUARDAR EN LA TABLA*/
    /*public void Guardar(Rol roll) throws SNMPExceptions, SQLException {

        LinkedList<Rol> otraLista = new LinkedList<Rol>();
        String insert = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            insert = "INSERT INTO ROLL(Id, Estado, Descripcion, Id_Usu_Registra, Fecha_Registra, Id_Usu_Edita,Fecha_Edita)"
                    + "VALUES (" + roll.getId()
                    + "," + roll.getEstado() + ",'"
                    + roll.getDescripcion() + "',"
                    + roll.getIdUsuRegistra() + ",'"
                    + roll.getFeRegistra() + "',"
                    + roll.getIdUsuEdita() + ",'"
                    + roll.getFeEdita() + "')";

            accesoDatos.ejecutaSQLRetornaRS(insert);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }
    }*/

    /*ACTUALIZAR UNO DE LA TABLA ID*/
    /*public void Actualizar(Rol roll) throws SNMPExceptions, SQLException {

        LinkedList<Rol> otraLista = new LinkedList<Rol>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update dbo.ROLL SET Descripcion = '" + roll.getDescripcion()
                    + "',Id_Usu_Edita =" + roll.getIdUsuEdita()
                    + ",Fecha_Edita = '" + roll.getFeEdita()
                    + "' where id = " + roll.getId();

            accesoDatos.ejecutaSQLRetornaRS(select);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }
    }*/

    /*DESACTIVAR UNO DE LA TABLA POR ID*/
    /*public void Desactivar(int idp, int estp) throws SNMPExceptions, SQLException {

        LinkedList<Telefono> otraLista = new LinkedList<Telefono>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Roll set estado=" + estp + " where id= " + idp;
            accesoDatos.ejecutaSQL(select);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }
    }*/
}
