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
public class PerfilDB {

    public AccesoDatos accesoDatos = new AccesoDatos();
//    LinkedList<Producto> listaProductos = new LinkedList<Producto>();

    public void Guardar(Perfil obj) throws SNMPExceptions, SQLException {

        String strSQL = "";
        try {
            strSQL = "INSERT INTO [dbo].[Perfiles]([Id],[Descripcion],"
                    + "[Estado],"
                    + "[Id_Usu_Registra],[Fecha_Registra],"
                    + "[Id_Usu_Edita],[Fecha_Edita])"
                    + "VALUES("
                    + obj.getId() + ",'"
                    + obj.getDescripcion() + "',"
                    + obj.getEstado() + ","
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

    public LinkedList<Perfil> SeleccionaTodos() throws SNMPExceptions, SQLException {
        String select = "";

        LinkedList<Perfil> lista = new LinkedList<Perfil>();

        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se instancia la clase de acceso a datos
//            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT Id,Descripcion,"
                    + "Estado,"
                    + "Id_Usu_Registra, Fecha_Registra,"
                    + "Id_Usu_Edita,Fecha_Edita "
                    + "from dbo.Perfiles";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los catálogos   
            while (rsPA.next()) {

                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Descripcion");
                int estado = rsPA.getInt("Estado");

                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                Perfil obj = new Perfil(idPro, nombre, estado, usuarioI, fechaI, usuarioM, fechaM);
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

    public LinkedList<Perfil> SeleccionaTodosDesactivados() throws SNMPExceptions, SQLException {
        String select = "";

        LinkedList<Perfil> lista = new LinkedList<Perfil>();

        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se instancia la clase de acceso a datos
//            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT Id,Descripcion,"
                    + "Estado,"
                    + "Id_Usu_Registra, Fecha_Registra,"
                    + "Id_Usu_Edita,Fecha_Edita "
                    + "from dbo.Perfiles";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los catálogos   
            while (rsPA.next()) {

                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Descripcion");
                int estado = rsPA.getInt("Estado");

                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                Perfil obj = new Perfil(idPro, nombre, estado, usuarioI, fechaI, usuarioM, fechaM);
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

    public Perfil SeleccionarUno(int idp) throws SNMPExceptions, SQLException {

        String select = "";
        Perfil obj = null;
        try {

            select = "Select * from Perfiles where Id =" + idp;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            while (rsPA.next()) {
                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Descripcion");
                int estado = rsPA.getInt("Estado");

                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                obj = new Perfil(idPro, nombre, estado, usuarioI, fechaI, usuarioM, fechaM);

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
        desactivar = "UPDATE Perfiles SET Estado=" + estp + " Where id = " + idProduct;
        accesoDatos.ejecutaSQL(desactivar);

    }

    public void Actualizar(Perfil obj) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        //Se crea la sentencia de actualización
        String update = "";
        try {
            update = "UPDATE Perfiles SET Descripcion = '" + obj.getDescripcion()                  
                    + "',Fecha_Edita = '" + obj.getFeEdita()
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
