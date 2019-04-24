/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Anyel
 */
public class PersonaDB {

    public AccesoDatos accesoDatos = new AccesoDatos();

    public void Guardar(Persona obj) throws SNMPExceptions, SQLException {

        String strSQL = "";
        try {
            strSQL = "INSERT INTO [dbo].[Persona]([ID_TIPO_IDENTIFICACION],[Identificacion],[Nombre],"
                    + "[P_Apellido],[S_Apellido],[Contrasenna],[ID_ROL],[Estado],"
                    + "[Id_Usu_Registra],[Fecha_Registra],[Id_Usu_Edita],[Fecha_Edita]) "
                    + "VALUES (" + obj.getIdTipoIdentificacion() + ",'" + obj.getIdentificacion() + "'"
                    + ",'" + obj.getNombre() + "','" + obj.getpApellido() + "','" + obj.getsApellido() + "','"
                    + obj.getContrasenna() + "'," + obj.getIdRol() + "," + obj.getEstado() + ","
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

    public LinkedList<Persona> SeleccionaTodos() throws SNMPExceptions, SQLException {
        String select = "";

        LinkedList<Persona> lista = new LinkedList<Persona>();

        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se instancia la clase de acceso a datos
//            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT Id,ID_TIPO_IDENTIFICACION,Identificacion,"
                    + "Nombre,P_Apellido,S_Apellido,"
                    + "Contrasenna,ID_ROL,Estado,"
                    + "Id_Usu_Registra, Fecha_Registra,"
                    + "Id_Usu_Edita,Fecha_Edita "
                    + "from dbo.Persona";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los catálogos   
            while (rsPA.next()) {

                int idPro = rsPA.getInt("Id");
                int idTipoIdentificacion = rsPA.getInt("ID_TIPO_IDENTIFICACION");
                String identificacion = rsPA.getString("Identificacion");
                String nombre = rsPA.getString("Nombre");
                String p_Apellido = rsPA.getString("P_Apellido");
                String s_Apellido = rsPA.getString("S_Apellido");
                String contrasenna = rsPA.getString("Contrasenna");
                int idRol = rsPA.getInt("ID_ROL");
                int estado = rsPA.getInt("Estado");
                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                Persona per = new Persona(idPro, idTipoIdentificacion, identificacion,
                        nombre, p_Apellido, s_Apellido, contrasenna, idRol, estado,
                        usuarioI, fechaI, usuarioM, fechaM);

                lista.add(per);

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

    public Persona SeleccionarUno(int idPersona) throws SNMPExceptions, SQLException {

        String select = "";
        Persona obj = null;
        try {

            select = "Select * from Producto where Id =" + idPersona;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            while (rsPA.next()) {
                int idPro = rsPA.getInt("Id");
                int idTipoIdentificacion = rsPA.getInt("ID_TIPO_IDENTIFICACION");
                String identificacion = rsPA.getString("Identificacion");
                String nombre = rsPA.getString("Nombre");
                String p_Apellido = rsPA.getString("P_Apellido");
                String s_Apellido = rsPA.getString("S_Apellido");
                String contrasenna = rsPA.getString("Contrasenna");
                int idRol = rsPA.getInt("ID_ROL");
                int estado = rsPA.getInt("Estado");
                int usuarioI = rsPA.getInt("Id_Usu_Registra");
                String fechaI = rsPA.getString("Fecha_Registra");
                int usuarioM = rsPA.getInt("Id_Usu_Edita");
                String fechaM = rsPA.getString("Fecha_Edita");

                obj = new Persona(idPro, idTipoIdentificacion, identificacion,
                        nombre, p_Apellido, s_Apellido, contrasenna, idRol, estado,
                        usuarioI, fechaI, usuarioM, fechaM);

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
    
    public int obtenerIdPersona() throws SNMPExceptions, SQLException {
        int id = 0;
        String select = "";
        try {

            select = "SELECT MAX(Id) FROM persona";
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

    public void Desactivar(int idPer, int estp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String desactivar = "";
        desactivar = "UPDATE Persona SET Estado=" + estp + " Where id = " + idPer;
        accesoDatos.ejecutaSQL(desactivar);
    }

    public void Actualizar(Persona obj) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        //Se crea la sentencia de actualización
        String update = "";
        try {
            update = "UPDATE Persona "
                    + "SET ID_TIPO_IDENTIFICACION = " + obj.getIdTipoIdentificacion()
                    + ", Identificacion = '" + obj.getIdentificacion()
                    + "', Nombre = '" + obj.getNombre()
                    + "', P_Apellido = '" + obj.getpApellido()
                    + "', S_Apellido = '" + obj.getsApellido()
                    + "', contrasenna = '" + obj.getContrasenna()
                    + "', ID_ROL = " + obj.getIdRol()
                    + ",Estado = " + obj.getEstado()
                    + ", Id_Usu_Edita = " + obj.getIdUsuEdita()
                    + ", Fecha_Edita = '" + obj.getFeEdita()
                    + "' where Id = " + obj.getId();
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
