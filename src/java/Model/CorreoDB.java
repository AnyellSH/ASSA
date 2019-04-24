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
 * @author Anyell
 */
public class CorreoDB {

    private AccesoDatos accesoDatos = new AccesoDatos();

    public CorreoDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public CorreoDB() {
    }

    /*SELECCIONAR TODOS*/
    public LinkedList<Correo> SeleccionarTodos(int idPersona) throws SNMPExceptions, SQLException {

        LinkedList<Correo> otraLista = new LinkedList<Correo>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select cor.Id as Id, cor.Correo as Correo, "
                    + "cor.Id_Usu_Registra as Id_Usu_Registra, "
                    + "cor.Fecha_Registra as Fecha_Registra, "
                    + "cor.Id_Usu_Edita as Id_Usu_Edita, "
                    + "cor.Fecha_Edita as Fecha_Edita "
                    + "from correo cor "
                    + "INNER JOIN PERSONA_CORREO percor on  cor.Id = percor.ID_CORREO "
                    + "INNER JOIN PERSONA per on per.Id = percor.ID_PERSONA "
                    + "where percor.ID_PERSONA = " + idPersona;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String correo = rsPA.getString("Correo");
                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                String feRegistra = rsPA.getString("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                String feEdita = rsPA.getString("Fecha_Edita");

                Correo Obj = new Correo(id, correo, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
    public void Guardar(Correo correo) throws SNMPExceptions, SQLException {

        String insert = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            insert = "INSERT INTO Correo (Correo, Id_Usu_Registra, "
                    + "Fecha_Registra, Id_Usu_Edita, Fecha_Edita) "
                    + "VALUES ('" + correo.getCorreo() + "',"
                    + correo.getIdUsuRegistra() + ",'"
                    + correo.getFeRegistra() + "',"
                    + correo.getIdUsuEdita() + ",'"
                    + correo.getFeEdita() + "')";

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
    
    public int obtenerIdCorreo() throws SNMPExceptions, SQLException {
        int id = 0;
        String select = "";
        try {

            select = "SELECT MAX(Id) FROM correo";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            if(rsPA.next()){
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
    
    public void guardarCorreoPersona(int idPersona, int idCorreo) throws SNMPExceptions, SQLException {
        String insert = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            insert = "INSERT INTO PERSONA_CORREO (ID_PERSONA, ID_CORREO) "
                    + "VALUES (" + idPersona + "," +
                    + idCorreo + ")";

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
    
    public void eliminar(Correo cor) throws SNMPExceptions, SQLException {
        String delete = "";
        
        try {

            AccesoDatos accesoDatos = new AccesoDatos();
            delete = "DELETE FROM PERSONA_CORREO where ID_CORREO = " + cor.getId();
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
            delete = "DELETE FROM Correo where id = " + cor.getId();
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
