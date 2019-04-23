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
 * @author Anyel
 */
public class ProductoDB {

    public AccesoDatos accesoDatos = new AccesoDatos();
//    LinkedList<Producto> listaProductos = new LinkedList<Producto>();

    public void Guardar(Producto obj) throws SNMPExceptions, SQLException {

        String strSQL = "";
        try {
            strSQL = "INSERT INTO [dbo].[PRODUCTO]([Nombre],"
                    + "[Cantidad_Min_Compra],[Precio],[Fotografia],[Estado],"
                    + "[Id_Usu_Registra],[Fecha_Registra],[Id_Usu_Edita],[Fecha_Edita])"
                    + "VALUES('" + obj.getNombreProducto() + "',"
                    + obj.getCantidadMinima() + "," + obj.getPrecio() + ",'"
                    + obj.getImagen() + "'," + obj.getEstado() + ","
                    + obj.getUsuarioRegistra() + ",'"
                    + obj.getFechaRegistro() + "',"
                    + obj.getUsuarioModifica() + ",'"
                    + obj.getFechaModificacion() + "')";

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

    public LinkedList<Producto> SeleccionaTodos() throws SNMPExceptions, SQLException {
        String select = "";

        LinkedList<Producto> lista = new LinkedList<Producto>();
        String errors;
        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se instancia la clase de acceso a datos
//            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT Id,Nombre,Cantidad_Min_Compra,Precio,"
                    + "Fotografia,Estado,"
                    + "Id_Usu_Registra, Fecha_Registra,"
                    + "Id_Usu_Edita,Fecha_Edita "
                    + "from dbo.Producto";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los catálogos   
            while (rsPA.next()) {

                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Nombre");
                int cantidadM = rsPA.getInt("Cantidad_Min_Compra");
                float precio = rsPA.getFloat("Precio");
                String img = rsPA.getString("Fotografia");
                int estado = rsPA.getInt("Estado");

                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                Producto pro = new Producto(idPro, nombre, estado, precio, cantidadM, usuarioI, fechaI, usuarioM, fechaM, img);
                if (pro.getEstado() == 1) {
                    lista.add(pro);
                }
            }
            rsPA.close();

        } catch (SQLException e) {
            errors = e.toString();
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            errors = e.toString();
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
            
        } finally {

        }

        return lista;
    }

    public LinkedList<Producto> SeleccionaTodosDesactivados() throws SNMPExceptions, SQLException {
        String select = "";

        LinkedList<Producto> lista = new LinkedList<Producto>();

        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se instancia la clase de acceso a datos
//            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT Id,Nombre,Cantidad_Min_Compra,Precio,"
                    + "Fotografia,Estado,"
                    + "Id_Usu_Registra, Fecha_Registra,"
                    + "Id_Usu_Edita,Fecha_Edita "
                    + "from dbo.Producto";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los catálogos   
            while (rsPA.next()) {

                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Nombre");
                int cantidadM = rsPA.getInt("Cantidad_Min_Compra");
                float precio = rsPA.getFloat("Precio");
                String img = rsPA.getString("Fotografia");
                int estado = rsPA.getInt("Estado");

                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                Producto pro = new Producto(idPro, nombre, estado, precio, cantidadM, usuarioI, fechaI, usuarioM, fechaM, img);
                if (pro.getEstado() == 0) {
                    lista.add(pro);
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
    public Producto SeleccionarUno(int idProduct) throws SNMPExceptions, SQLException {

        String select = "";
        Producto obj = null;
        try {

            select = "Select * from Producto where Id =" + idProduct;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            while (rsPA.next()) {
                int idPro = rsPA.getInt("id");
                String nombre = rsPA.getString("Nombre");
                int cantidadM = rsPA.getInt("Cantidad_Min_Compra");
                float precio = rsPA.getFloat("Precio");
                String img = rsPA.getString("Fotografia");
                int estado = rsPA.getInt("Estado");

                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                obj = new Producto(idPro, nombre, estado, precio, cantidadM, usuarioI, fechaI, usuarioM, fechaM, img);

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
        return obj;
    }

    public void Desactivar(int idProduct, int estp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String desactivar = "";
        desactivar = "UPDATE Producto SET Estado=" + estp + " Where id = " + idProduct;
        accesoDatos.ejecutaSQL(desactivar);

    }

    public void Actualizar(Producto obj) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        //Se crea la sentencia de actualización
        String update = "";
        String errors;
        try {
            update = "UPDATE Producto SET Nombre = '" + obj.getNombreProducto()
                    + "',Precio = " + obj.getPrecio()
                    + ",Cantidad_Min_Compra = " + obj.getCantidadMinima()
                    + ",Fecha_Edita = '" + obj.getFechaModificacion()
                    + "',Id_Usu_Edita = " + obj.getUsuarioModifica()
                    + ",Fotografia = '" + obj.getImagen()
                    + "'where Id = " + obj.getIdProducto();
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(update);

        } catch (SQLException e) {
            errors = e.toString();
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
