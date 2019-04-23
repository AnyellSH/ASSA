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
public class Tipo_Perfil_EmpleadoDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
//    private Connection conn;
//    LinkedList<Tipo_Perfil_Empleado> lista = new LinkedList<Tipo_Perfil_Empleado>();

    public Tipo_Perfil_EmpleadoDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public Tipo_Perfil_EmpleadoDB() {
    }

    /*SELECCIONAR TODOS*/
    public LinkedList<Tipo_Perfil_Empleado> SeleccionarTodos() throws SNMPExceptions, SQLException {

        LinkedList<Tipo_Perfil_Empleado> otraLista = new LinkedList<Tipo_Perfil_Empleado>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id, Descripcion, Estado, ID_PERSONA, ID_PERFIL_EMPLEADO,"
                    + "Id_Usu_Registra, Fecha_Registra, Id_Usu_Edita,Fecha_Edita"
                    + "from Tipo_Perfil_Empleado";

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");
                int est = rsPA.getInt("Estado");
                int idper = rsPA.getInt("ID_PERSONA");
                int idPerfEmpleado = rsPA.getInt("ID_PERFIL_EMPLEADO");

                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                Date feRegistra = rsPA.getDate("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                Date feEdita = rsPA.getDate("Fecha_Edita");

                Tipo_Perfil_Empleado Obj = new Tipo_Perfil_Empleado(id, desc, est, idper, idPerfEmpleado, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
    public Tipo_Perfil_Empleado SeleccionarUno(int idp) throws SNMPExceptions, SQLException {

        Tipo_Perfil_Empleado Obj = null;
        String select = "";
        try {
            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id, Descripcion, Estado, ID_PERSONA, ID_PERFIL_EMPLEADO,"
                    + "Id_Usu_Registra, Fecha_Registra, Id_Usu_Edita,Fecha_Edita"
                    + "from Tipo_Perfil_Empleado where id=" + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                String desc = rsPA.getString("Descripcion");
                int est = rsPA.getInt("Estado");
                int idper = rsPA.getInt("ID_PERSONA");
                int idPerfEmpleado = rsPA.getInt("ID_PERFIL_EMPLEADO");
                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                Date feRegistra = rsPA.getDate("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                Date feEdita = rsPA.getDate("Fecha_Edita");

                Obj = new Tipo_Perfil_Empleado(id, desc, est, idper, idPerfEmpleado, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
/*GUARDAR EN LA TABLA*/
    public void Guardar(Tipo_Perfil_Empleado Objp) throws SNMPExceptions, SQLException {

       
        String insert = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            insert = "INSERT INTO Tipo_Perfil_Empleado (Id,Descripcion, Estado, ID_PERSONA, ID_PERFIL_EMPLEADO, ID_USU_REGISTRA, FECHA_REGISTRA, ID_USU_EDITA, FECHA_EDITA )"
                    + "VALUES (" + Objp.getId() + ",'" + Objp.getDescripcion()+ "'," + Objp.getEstado()
                    +","
                    +")";

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
    }
    /*ACTUALIZAR UNO DE LA TABLA ID*/
    public void Actualizar(Tipo_Perfil_Empleado Obj) throws SNMPExceptions, SQLException {

        String update = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            update = "Update Tipo_Perfil_Empleado Set Descripcion='" + Obj.getDescripcion()
                    + "',Id_Usu_Edita =" + Obj.getIdUsuEdita()
                    + ",Fecha_Edita ='" + Obj.getFeEdita()
                    + "'where id= " + Obj.getId();

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

    /*DESACTIVAR UNO DE LA TABLA POR ID*/
    public void Desactivar(Tipo_Perfil_Empleado obj) throws SNMPExceptions, SQLException {

        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Tipo_Perfil_Empleado set estado=" + obj.getEstado()
                    + " where id= " + obj.getId();

            accesoDatos.ejecutaSQL(select);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
    }

}
