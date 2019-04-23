/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author Pablo Mora
 */
public class IdentificacionDB {

    public AccesoDatos accesoDatos = new AccesoDatos();
//    LinkedList<Producto> listaProductos = new LinkedList<Producto>();

    public void Guardar(Identificacion obj) throws SNMPExceptions, SQLException {

        String strSQL = "";
        try {
            strSQL = "INSERT INTO [dbo].[Identificacion]([Id],[Identificacion],"
                    + "[Estado],ID_TIPO_IDENTIFICACION,"
                    + "[Id_Usu_Registra],[Fecha_Registra],"
                    + "[Id_Usu_Edita],[Fecha_Edita])"
                    + "VALUES("
                    + obj.getId() + ",'"
                    + obj.getIdentificacion() + "',"
                    + obj.getEstado() + ","
                    + obj.getIdTipIdentificacion().id + ","
                    + obj.getIdUsuRegistra() + ",'"
                    + obj.getFeRegistra() + "',"
                    + obj.getIdUsuEdita() + ",'"
                    + obj.getFeEdita() + "')";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
    }

    public LinkedList<Identificacion> SeleccionaTodos() throws SNMPExceptions, SQLException {
        Tipo_IdentificacionDB tipoDB = new Tipo_IdentificacionDB();
        String select = "";

        LinkedList<Identificacion> lista = new LinkedList<Identificacion>();

        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se instancia la clase de acceso a datos
//            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT Id,Identificacion,"
                    + "Estado,ID_TIPO_IDENTIFICACION,"
                    + "Id_Usu_Registra, Fecha_Registra,"
                    + "Id_Usu_Edita,Fecha_Edita "
                    + "from dbo.Identificacion";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los catálogos   
            while (rsPA.next()) {

                int idPro = rsPA.getInt("id");
                String identificacion = rsPA.getString("Identificacion");
                int estado = rsPA.getInt("Estado");
                int tipo = rsPA.getInt("ID_TIPO_IDENTIFICACION");

                Tipo_Identificacion tipoId = tipoDB.SeleccionarUno(tipo);
                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                Identificacion obj = new Identificacion(idPro, identificacion, estado, tipoId, usuarioI, fechaI, usuarioM, fechaM);
                if (obj.getEstado() == 1) {
                    lista.add(obj);
                }
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

    public LinkedList<Identificacion> SeleccionaTodosDesactivados() throws SNMPExceptions, SQLException {
        Tipo_IdentificacionDB tipoDB = new Tipo_IdentificacionDB();
        String select = "";

        LinkedList<Identificacion> lista = new LinkedList<Identificacion>();

        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se instancia la clase de acceso a datos
//            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT Id,Identificacion,"
                    + "Estado,ID_TIPO_IDENTIFICACION,"
                    + "Id_Usu_Registra, Fecha_Registra,"
                    + "Id_Usu_Edita,Fecha_Edita "
                    + "from dbo.Identificacion";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los catálogos   
            while (rsPA.next()) {

                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Identificacion");
                int estado = rsPA.getInt("Estado");
                int tipo = rsPA.getInt("ID_TIPO_IDENTIFICACION");

                Tipo_Identificacion tipoId = tipoDB.SeleccionarUno(tipo);
                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                Identificacion obj = new Identificacion(idPro, nombre, estado, tipoId, usuarioI, fechaI, usuarioM, fechaM);
                if (obj.getEstado() == 0) {
                    lista.add(obj);
                }
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

    public Identificacion SeleccionarUno(int idp) throws SNMPExceptions, SQLException {
        Tipo_IdentificacionDB tipoDB = new Tipo_IdentificacionDB();
        String select = "";
        Identificacion obj = null;
        try {

            select = "Select * from Identificacion where Id =" + idp;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            while (rsPA.next()) {
                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Identificacion");
                int estado = rsPA.getInt("Estado");
                int tipo = rsPA.getInt("ID_TIPO_IDENTIFICACION");
                Tipo_Identificacion tipoId = tipoDB.SeleccionarUno(tipo);

                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                obj = new Identificacion(idPro, nombre, estado, tipoId, usuarioI, fechaI, usuarioM, fechaM);

            }
            rsPA.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
            accesoDatos.cerrarConexion();
        }
        return obj;
    }

    public void Desactivar(int idProduct, int estp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String desactivar = "";
        desactivar = "UPDATE Identificacion SET Estado=" + estp + " Where id = " + idProduct;
        accesoDatos.ejecutaSQL(desactivar);

    }

    public void Actualizar(Identificacion obj) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        //Se crea la sentencia de actualización
        String update = "";
        try {
            update = "UPDATE Identificacion SET identificacion = '" + obj.getIdentificacion()
                    + "',ID_TIPO_IDENTIFICACION = " + obj.getIdTipIdentificacion().getId()
                    + ",Fecha_Edita = '" + obj.getFeEdita()
                    + "',Id_Usu_Edita = " + obj.getIdUsuEdita()
                    + "where Id = " + obj.getId();
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
}
