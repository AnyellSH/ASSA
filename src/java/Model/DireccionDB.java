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
import javax.naming.NamingException;

/**
 *
 * @author Anyel
 */
public class DireccionDB {

    private AccesoDatos accesoDatos = new AccesoDatos();

    public DireccionDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public DireccionDB() {
    }

    /*SELECCIONAR TODOS*/
    public LinkedList<Direccion> SeleccionarTodos(int idPersona) throws SNMPExceptions, SQLException {

        LinkedList<Direccion> otraLista = new LinkedList<Direccion>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "select d.Id as Id, d.Otras_Sennas as Otras_Sennas, d.Horarios as Horarios, d.Estado as Estado, "
                    + "d.Id_Usu_Registra as Id_Usu_Registra, d.Fecha_Registra as Fecha_Registra, "
                    + "d.Id_Usu_Edita as Id_Usu_Edita, d.Fecha_Edita as Fecha_Edita, d.ID_TIPO_DIRECCION as ID_TIPO_DIRECCION, "
                    + "d.COD_PROVINCIA as COD_PROVINCIA, d.COD_CANTON as COD_CANTON, d.COD_DISTRITO as COD_DISTRITO, "
                    + "d.COD_BARRIO as COD_BARRIO from DIRECCION d "
                    + "inner join PERSONA_DIRECCION pd on pd.ID_DIRECCION = d.Id "
                    + "where pd.ID_PERSONA = " + idPersona;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String otrasSennas = rsPA.getString("Otras_Sennas");
                String horarios = rsPA.getString("Horarios");
                int estado = rsPA.getInt("Estado");
                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                String feRegistra = rsPA.getString("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                String feEdita = rsPA.getString("Fecha_Edita");
                int idTipoDireccion = rsPA.getInt("ID_TIPO_DIRECCION");
                int idProvincia = rsPA.getInt("COD_PROVINCIA");
                int idCanton = rsPA.getInt("COD_CANTON");
                int idDistrito = rsPA.getInt("COD_DISTRITO");
                int idBarrio = rsPA.getInt("COD_BARRIO");

                Direccion Obj = new Direccion(id, otrasSennas, horarios, estado, idUsuRegistra, feRegistra, idUsuEdita, 
                        feEdita, idTipoDireccion, idProvincia, idCanton, idDistrito, idBarrio);

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

    /*GUARDAR EN LA TABLA*/
    public void Guardar(Direccion dir) throws SNMPExceptions, SQLException {

        String error = "";
        String insert = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            insert = "INSERT INTO [dbo].[DIRECCION] ([Otras_Sennas],[Horarios],[Estado], "
                    + "[Id_Usu_Registra],[Fecha_Registra],[Id_Usu_Edita], "
                    + "[Fecha_Edita],[ID_TIPO_DIRECCION],[COD_PROVINCIA], "
                    + "[COD_CANTON],[COD_DISTRITO],[ID_BARRIO]) "
                    + "VALUES ('" + dir.getOtrasSennas()
                    + "','" + dir.getHorarios()
                    + "'," + dir.getEstado()
                    + "," + dir.getIdUsuRegistra() + ",'"
                    + dir.getFeRegistra() + "',"
                    + dir.getIdUsuEdita() + ",'"
                    + dir.getFeEdita() + "',"
                    + dir.getIdTipoDirreccion()+ ","
                    + dir.getIdProvincia()+ ","
                    + dir.getIdCanton()+ ","
                    + dir.getIdDistrito()+ ","
                    + dir.getIdBarrio()+ ")";

            accesoDatos.ejecutaSQL(insert);
            
        } catch (SQLException e) {
            error += e.toString() + e.getMessage() + e.getErrorCode();
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            error += e.toString() + e.getMessage();
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }
    }

    public int obtenerIdDireccion() throws SNMPExceptions, SQLException {
        int id = 0;
        String select = "";
        try {

            select = "SELECT MAX(Id) FROM Direccion";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            if (rsPA.next()) {
                id = rsPA.getInt(1);
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
        return id;
    }

    /*GUARDAR EN LA TABLA*/
    public void GuardarDireccionPersona(int idDireccion, int idPersona) throws SNMPExceptions, SQLException {

        String insert = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            insert = "INSERT INTO PERSONA_DIRECCION (ID_PERSONA, ID_DIRECCION) "
                    + "VALUES (" + idPersona + ","
                    + +idDireccion + ")";

            accesoDatos.ejecutaSQL(insert);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }
    }


    /*ACTUALIZAR UNO DE LA TABLA ID*/
    public void Actualizar(Direccion obj) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        //Se crea la sentencia de actualización
        String update = "";
        try {
            update = "UPDATE DIRECCION SET Otras_Sennas = '" + obj.getOtrasSennas()
                    + "', Horarios = '" + obj.getHorarios()
                    + "', Estado = " + obj.getEstado()
                    + ""
                    + ", Fecha_Edita = '" + obj.getFeEdita()
                    + "', Id_Usu_Edita = " + obj.getIdUsuEdita()
                    + ", ID_TIPO_DIRECCION = " + obj.getIdTipoDirreccion()
                    + ", COD_PROVINCIA = " + obj.getIdProvincia()
                    + ", COD_CANTON = " + obj.getIdCanton()
                    + ", COD_DISTRITO = " + obj.getIdDistrito()
                    + ", COD_BARRIO = " + obj.getIdBarrio()
                    + " where Id = " + obj.getId();
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(update);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }

    }

    public void eliminar(Direccion dir) throws SNMPExceptions, SQLException {
        String delete = "";

        try {

            AccesoDatos accesoDatos = new AccesoDatos();
            delete = "DELETE FROM PERSONA_DIRECCION where ID_DIRECCION = " + dir.getId();
            accesoDatos.ejecutaSQL(delete);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }

        try {

            AccesoDatos accesoDatos = new AccesoDatos();
            delete = "DELETE FROM Direccion where id = " + dir.getId();
            accesoDatos.ejecutaSQL(delete);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }

    }
}
