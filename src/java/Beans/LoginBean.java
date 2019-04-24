/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.SNMPExceptions;
import Model.Persona;
import Model.PersonaDB;
import Model.Rol;
import Model.RolDB;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pablo Mora
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    String identificacion;
    String contrasena;
    int roll;
    LinkedList<Rol> otraLista = new LinkedList<Rol>();
    PersonaDB persona;
    Persona obj;
    String usuarioLogueado;
    String pagina = "";

    /*Mensajes de erro*/
    String errorUsuario;
    String errorContrasenna;

    public LoginBean() {
        persona = new PersonaDB();
    }

    public String getUsuario() {
        return identificacion;
    }

    public void setUsuario(String usuario) {
        this.identificacion = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public LinkedList<Rol> getOtraLista() throws SNMPExceptions, SQLException {

        LinkedList<Rol> lista = new LinkedList<Rol>();
        RolDB SDB = new RolDB();

//        lista = persona.SelecionarRolles_Por_Persona(roll);
        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setOtraLista(LinkedList<Rol> otraLista) {
        this.otraLista = otraLista;
    }

    public PersonaDB getPersona() {
        return persona;
    }

    public void setPersona(PersonaDB persona) {
        this.persona = persona;
    }

    public String getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(String usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public Persona getObj() {
        return obj;
    }

    public void setObj(Persona obj) {
        this.obj = obj;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getErrorUsuario() {
        return errorUsuario;
    }

    public void setErrorUsuario(String errorUsuario) {
        this.errorUsuario = errorUsuario;
    }

    public String getErrorContrasenna() {
        return errorContrasenna;
    }

    public void setErrorContrasenna(String errorContrasenna) {
        this.errorContrasenna = errorContrasenna;
    }

    public void Validar() throws SNMPExceptions, SQLException {

        boolean encontrado = false;
//        int idpersona = 0;

        LinkedList<Persona> lista = new LinkedList<Persona>();
        lista = persona.SeleccionaTodos();
        for (Persona pers : lista) {
            if (pers.identificacion.equals(identificacion) && pers.contrasenna.equals(contrasena)) {
                encontrado = true;
                roll = pers.id;
                obj = pers;
            }
        }

        if (encontrado) {
//            otraLista = persona.SelecionarRolles_Por_Persona(idpersona);

            pagina = "mantenimientos.xhtml";
            autenticar();
            this.setUsuarioLogueado(obj.getNombre());
            this.consultarSesion();

        } else {
            this.setErrorUsuario("Datos incorectos");
        }

//        return pagina;
    }

    public void autenticar() throws SNMPExceptions, SQLException {
        try {

            if (obj != null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);

                this.setUsuarioLogueado(obj.nombre);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("obj", obj);

            }
        } catch (Exception e) {
            e.toString();
        }
    }

    public void consultarSesion() throws SNMPExceptions, SQLException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("obj");

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        final Map<String, Object> session = context.getSessionMap();
        final Persona user = (Persona) session.get("obj");

        if (user != null) {
            try {
                this.setUsuarioLogueado(user.nombre);
            } catch (ClassCastException e) {
                e.toString();
            }
        } else {
            context.invalidateSession();
        }
    }

}
