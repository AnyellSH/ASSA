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
public class TelefonoDB {

    private AccesoDatos accesoDatos = new AccesoDatos();

    public TelefonoDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public TelefonoDB() {
    }

    /*SELECCIONAR TODOS*/
    public LinkedList<Telefono> SeleccionarTodos(int idPersona) throws SNMPExceptions, SQLException {

        LinkedList<Telefono> otraLista = new LinkedList<Telefono>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select tel.Id as Id, tel.Numero as Numero, tel.ID_TIPO_TELEFONO as ID_TIPO_TELEFONO, "
                    + "tel.Id_Usu_Registra as Id_Usu_Registra, tel.Fecha_Registra as Fecha_Registra, "
                    + "tel.Id_Usu_Edita as Id_Usu_Edita, tel.Fecha_Edita as Fecha_Edita "
                    + "from Telefono tel "
                    + "INNER JOIN PERSONA_TELEFONO pertel on  tel.Id = pertel.ID_TELEFONO "
                    + "INNER JOIN PERSONA per on per.Id = pertel.ID_PERSONA "
                    + "where per.Id = " + idPersona;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String num = rsPA.getString("Numero");
                int idtpTel = rsPA.getInt("ID_TIPO_TELEFONO");
                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                String feRegistra = rsPA.getString("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                String feEdita = rsPA.getString("Fecha_Edita");

                Telefono Obj = new Telefono(id, num, idtpTel, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
    public LinkedList<Telefono> SeleccionarUno(int idp) throws SNMPExceptions, SQLException {
        LinkedList<Telefono> otraLista = new LinkedList<Telefono>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id, Numero, ID_TIPO_TELEFONO"
                    + "Id_Usu_Registra, Fecha_Registra, Id_Usu_Edita,Fecha_Edita"
                    + "from Telefono where id=" + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String num = rsPA.getString("Numero");
                int idtpTel = rsPA.getInt("ID_TIPO_TELEFONO");

                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                String feRegistra = rsPA.getString("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                String feEdita = rsPA.getString("Fecha_Edita");

                Telefono Obj = new Telefono(id, num, idtpTel, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
    public void Guardar(Telefono telefono) throws SNMPExceptions, SQLException {

        String error = "";
        String insert = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            insert = "INSERT INTO Telefono(Numero, ID_TIPO_TELEFONO, Id_Usu_Registra, "
                    + "Fecha_Registra, Id_Usu_Edita, Fecha_Edita) "
                    + "VALUES ('" + telefono.getNumero()
                    + "'," + telefono.getIdTipoTelefono()
                    + "," + telefono.getIdUsuRegistra() + ",'"
                    + telefono.getFeRegistra() + "',"
                    + telefono.getIdUsuEdita() + ",'"
                    + telefono.getFeEdita() + "')";

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

    public int obtenerIdTelefono() throws SNMPExceptions, SQLException {
        int id = 0;
        String select = "";
        try {

            select = "SELECT MAX(Id) FROM telefono";
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
    public void GuardarTelefonoPersona(int idTelefono, int idPersona) throws SNMPExceptions, SQLException {

        String insert = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            insert = "INSERT INTO PERSONA_TELEFONO (ID_PERSONA, ID_TELEFONO) "
                    + "VALUES (" + idPersona + ","
                    + +idTelefono + ")";

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
    public LinkedList<Telefono> Actualizar(int idp, String nump, int tipp, int usup, Date fecp) throws SNMPExceptions, SQLException {

        LinkedList<Telefono> otraLista = new LinkedList<Telefono>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Telefono set Numero = " + nump + ",set ID_TIPO_TELEFONO =" + tipp
                    + ", set Id_Usu_Edit =" + usup + ", set Fecha_Edita = " + fecp
                    + "from Telefono where id=" + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String num = rsPA.getString("Numero");
                int idtpTel = rsPA.getInt("ID_TIPO_TELEFONO");

                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                String feRegistra = rsPA.getString("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                String feEdita = rsPA.getString("Fecha_Edita");

                Telefono Obj = new Telefono(id, num, idtpTel, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
    public LinkedList<Telefono> Desactivar(int idp, int estp) throws SNMPExceptions, SQLException {

        LinkedList<Telefono> otraLista = new LinkedList<Telefono>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Telefono set estado=" + estp + " where id= " + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String num = rsPA.getString("Numero");
                int idtpTel = rsPA.getInt("ID_TIPO_TELEFONO");

                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                String feRegistra = rsPA.getString("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                String feEdita = rsPA.getString("Fecha_Edita");

                Telefono Obj = new Telefono(id, num, idtpTel, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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

    public void eliminar(Telefono tel) throws SNMPExceptions, SQLException {
        String delete = "";
        
        try {

            AccesoDatos accesoDatos = new AccesoDatos();
            delete = "DELETE FROM PERSONA_TELEFONO where ID_TELEFONO = " + tel.getId();
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
            delete = "DELETE FROM Telefono where id = " + tel.getId();
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
