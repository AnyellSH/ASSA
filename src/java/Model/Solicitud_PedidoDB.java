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
public class Solicitud_PedidoDB {

    private AccesoDatos accesoDatos = new AccesoDatos();

    public Solicitud_PedidoDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public Solicitud_PedidoDB() {
    }

    /*SELECCIONAR TODOS*/
    public LinkedList<Solicitud_Pedido> SeleccionarTodos() throws SNMPExceptions, SQLException {

        LinkedList<Solicitud_Pedido> otraLista = new LinkedList<Solicitud_Pedido>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id, Fecha, ID_PERSONA, ID_DIRECCION, Cantidad, Precio_Prod_Pedido"
                    + "ID_ACEPTACION_SOLICITUD, ID_MEDIO_DESPACHO, ID_TIPO_PAGO, "
                    + "Id_Usu_Registra, Fecha_Registra, Id_Usu_Edita,Fecha_Edita"
                    + "from Solicitud_Pedido";

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                Date fecha = rsPA.getDate("Fecha");
                int idpersona = rsPA.getInt("ID_PERSONA");
                int iddirec = rsPA.getInt("ID_DIRECCION");
                int cat = rsPA.getInt("Cantidad");
                double precio = rsPA.getDouble("Precio_Prod_Pedido");
                int idacep = rsPA.getInt("ID_ACEPTACION_SOLICITUD");
                int idmedi = rsPA.getInt("ID_MEDIO_DESPACHO");
                int idtip = rsPA.getInt("ID_TIPO_PAGO");

                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                Date feRegistra = rsPA.getDate("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                Date feEdita = rsPA.getDate("Fecha_Edita");

                Solicitud_Pedido Obj = new Solicitud_Pedido(id, fecha, idpersona, iddirec, cat, precio, idacep, idmedi, idtip, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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

    /*SELECCIONAR UNO DE LA TABLA POR ID*/
    public LinkedList<Solicitud_Pedido> SeleccionarUno(int idp) throws SNMPExceptions, SQLException {

        LinkedList<Solicitud_Pedido> otraLista = new LinkedList<Solicitud_Pedido>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Select Id, Fecha, ID_PERSONA, ID_DIRECCION, Cantidad, Precio_Prod_Pedido"
                    + "ID_ACEPTACION_SOLICITUD, ID_MEDIO_DESPACHO, ID_TIPO_PAGO, "
                    + "Id_Usu_Registra, Fecha_Registra, Id_Usu_Edita,Fecha_Edita"
                    + "from Solicitud_Pedido where id=" + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                Date fecha = rsPA.getDate("Fecha");
                int idpersona = rsPA.getInt("ID_PERSONA");
                int iddirec = rsPA.getInt("ID_DIRECCION");
                int cat = rsPA.getInt("Cantidad");
                double precio = rsPA.getDouble("Precio_Prod_Pedido");
                int idacep = rsPA.getInt("ID_ACEPTACION_SOLICITUD");
                int idmedi = rsPA.getInt("ID_MEDIO_DESPACHO");
                int idtip = rsPA.getInt("ID_TIPO_PAGO");

                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                Date feRegistra = rsPA.getDate("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                Date feEdita = rsPA.getDate("Fecha_Edita");

                Solicitud_Pedido Obj = new Solicitud_Pedido(id, fecha, idpersona, iddirec, cat, precio, idacep, idmedi, idtip, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
    public LinkedList<Solicitud_Pedido> Actualizar(int idp, Date fecp, int idper, int dirp, int catp, int idsolp, int idmedp, int idtopp, int idedp, Date fedp) throws SNMPExceptions, SQLException {

        LinkedList<Solicitud_Pedido> otraLista = new LinkedList<Solicitud_Pedido>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Solicitud_Pedido "
                    + "set Fecha = " + fecp
                    + ",set ID_PERSONA = " + idper
                    + ",set ID_DIRECCION = " + dirp
                    + ",set Cantidad = " + catp
                    + ",set ID_MEDIO_DESPACHO = " + idmedp
                    + ",set ID_TIPO_PAGO =" + idtopp
                    + ",set Id_Usu_Edita = " + idedp
                    + ",set Fecha_Edita = " + fedp
                    + " where id=" + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                Date fecha = rsPA.getDate("Fecha");
                int idpersona = rsPA.getInt("ID_PERSONA");
                int iddirec = rsPA.getInt("ID_DIRECCION");
                int cat = rsPA.getInt("Cantidad");
                double precio = rsPA.getDouble("Precio_Prod_Pedido");
                int idacep = rsPA.getInt("ID_ACEPTACION_SOLICITUD");
                int idmedi = rsPA.getInt("ID_MEDIO_DESPACHO");
                int idtip = rsPA.getInt("ID_TIPO_PAGO");

                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                Date feRegistra = rsPA.getDate("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                Date feEdita = rsPA.getDate("Fecha_Edita");

                Solicitud_Pedido Obj = new Solicitud_Pedido(id, fecha, idpersona, iddirec, cat, precio, idacep, idmedi, idtip, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
    public LinkedList<Solicitud_Pedido> Desactivar(int idp, int estp) throws SNMPExceptions, SQLException {

        LinkedList<Solicitud_Pedido> otraLista = new LinkedList<Solicitud_Pedido>();
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "Update Solicitud_Pedido set ID_ACEPTACION_SOLICITUD=" + estp + " where id= " + idp;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsPA.next()) {

                int id = rsPA.getInt("Id");
                Date fecha = rsPA.getDate("Fecha");
                int idpersona = rsPA.getInt("ID_PERSONA");
                int iddirec = rsPA.getInt("ID_DIRECCION");
                int cat = rsPA.getInt("Cantidad");
                double precio = rsPA.getDouble("Precio_Prod_Pedido");
                int idacep = rsPA.getInt("ID_ACEPTACION_SOLICITUD");
                int idmedi = rsPA.getInt("ID_MEDIO_DESPACHO");
                int idtip = rsPA.getInt("ID_TIPO_PAGO");

                int idUsuRegistra = rsPA.getInt("Id_Usu_Registra");
                Date feRegistra = rsPA.getDate("Fecha_Registra");
                int idUsuEdita = rsPA.getInt("Id_Usu_Edita");
                Date feEdita = rsPA.getDate("Fecha_Edita");

                Solicitud_Pedido Obj = new Solicitud_Pedido(id, fecha, idpersona, iddirec, cat, precio, idacep, idmedi, idtip, idUsuRegistra, feRegistra, idUsuEdita, feEdita);

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
