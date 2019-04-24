/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.SNMPExceptions;
import Model.Correo;
import Model.CorreoDB;
import Model.Persona;
import Model.PersonaDB;
import Model.Producto;
import Model.ProductoDB;
import Model.Rol;
import Model.RolDB;
import Model.Telefono;
import Model.TelefonoDB;
import Model.Tipo_Identificacion;
import Model.Tipo_IdentificacionDB;
import Model.Tipo_Telefono;
import Model.Tipo_TelefonoDB;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

/**
 *
 * @author Anyel
 */
@Named(value = "personaBean")
@SessionScoped
public class PersonaBean implements Serializable {

    int id;
    SimpleDateFormat date = null;
    int idPersona;
    int idTipoIdentificacion;
    String identificacion;
    String nombre;
    String pApellido;
    String sApellido;
    String contrasenna;
    String confcontrasenna;
    int idRol;
    String rolPersona;
    int estado;
    int idUsuRegistra;
    String feRegistra;
    int idUsuEdita;
    String feEdita;
    Date now = new Date(System.currentTimeMillis());
    int idTipoTelefono;
    String numeroTel;
    String tipoTelefono;
    int idTelefono;
    int idCorreo;
    String Correo;
    Persona obj;
    String cssClass = "hidden";
    String hideButtons;
    String deshabilitarCampo = "disabled";
    Persona per;
    LinkedList<Telefono> numerosTelefono = new LinkedList<Telefono>();
    LinkedList<Persona> listaTablaPersonas = new LinkedList<Persona>();
    LinkedList<Persona> listaTablaPersonasDesactivados = new LinkedList<Persona>();
    LinkedList<Telefono> listaTablaTelefonos = new LinkedList<Telefono>();
    LinkedList<Telefono> listaTablaTelefonosEdit = new LinkedList<Telefono>();
    LinkedList<Tipo_Identificacion> listaTipoIdentificacion = new LinkedList<Tipo_Identificacion>();
    LinkedList<Tipo_Telefono> tiposTelefono = new LinkedList<Tipo_Telefono>();
    LinkedList<Rol> listaRoles = new LinkedList<Rol>();
    LinkedList<Correo> listaTablaCorreos = new LinkedList<Correo>();
    LinkedList<Correo> listaTablaCorreosEdit = new LinkedList<Correo>();

    /*Mensajes de error*/
    String error1;
    String error2;
    String error3;
    String error4;
    String error5;
    String error6;
    String error7;
    String error8;
    String error9;
    String error10;
    String error11;

    /*GET Y SET MENSAJES DE ERROR*/
    public String getError1() {
        return error1;
    }

    public void setError1(String error1) {
        this.error1 = error1;
    }

    public String getError2() {
        return error2;
    }

    public void setError2(String error2) {
        this.error2 = error2;
    }

    public String getError3() {
        return error3;
    }

    public void setError3(String error3) {
        this.error3 = error3;
    }

    public String getError4() {
        return error4;
    }

    public void setError4(String error4) {
        this.error4 = error4;
    }

    public String getError5() {
        return error5;
    }

    public void setError5(String error5) {
        this.error5 = error5;
    }

    public String getError6() {
        return error6;
    }

    public void setError6(String error6) {
        this.error6 = error6;
    }

    public String getError7() {
        return error7;
    }

    public void setError7(String error7) {
        this.error7 = error7;
    }

    public String getError8() {
        return error8;
    }

    public void setError8(String error8) {
        this.error8 = error8;
    }

    public String getError9() {
        return error9;
    }

    public void setError9(String error9) {
        this.error9 = error9;
    }

    public String getError10() {
        return error10;
    }

    public void setError10(String error10) {
        this.error10 = error10;
    }

    public String getError11() {
        return error11;
    }

    public void setError11(String error11) {
        this.error11 = error11;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Telefono> getListaTablaTelefonosEdit(int id) throws SNMPExceptions, SQLException {
        LinkedList<Telefono> lista = new LinkedList<Telefono>();
        lista = getTablaTelefonos(id);
        return lista;
    }

    public void setListaTablaTelefonosEdit(LinkedList<Telefono> listaTablaTelefonosEdit) {
        this.listaTablaTelefonosEdit = listaTablaTelefonosEdit;
    }

    public LinkedList<Correo> getListaTablaCorreosEdit(int id) throws SNMPExceptions, SQLException {
        LinkedList<Correo> lista = new LinkedList<Correo>();
        lista = this.getListaCorreos(id);
        return lista;
    }

    public void setListaTablaCorreosEdit(LinkedList<Correo> listaTablaCorreosEdit) {
        this.listaTablaCorreosEdit = listaTablaCorreosEdit;
    }

    public Persona getPer() {
        return per;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    public String getRolPersona(int id) {
        String rol = "";
        if (id == 1) {
            rol = "Administrador";
        } else if (id == 2) {
            rol = "Empleado";
        } else if (id == 3) {
            rol = "Cliente";
        }
        return rol;
    }

    public void setRolPersona(String rolPersona) {
        this.rolPersona = rolPersona;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getIdCorreo() throws SNMPExceptions, SQLException {
        CorreoDB cDB = new CorreoDB();
        return cDB.obtenerIdCorreo();
    }

    public void setIdCorreo(int idCorreo) {
        this.idCorreo = idCorreo;
    }

    public LinkedList<Correo> getListaTablaCorreos() throws SNMPExceptions, SQLException {
        int id = this.getIdPersona();
        LinkedList<Correo> lista = new LinkedList<Correo>();
        lista = getListaCorreos(id);
        return lista;
    }

    public LinkedList<Correo> getListaCorreos(int idPersona) throws SNMPExceptions, SQLException {
        LinkedList<Correo> lista = new LinkedList<Correo>();
        CorreoDB cDB = new CorreoDB();
        lista = cDB.SeleccionarTodos(id);
        return lista;
    }

    public void setListaTablaCorreos(LinkedList<Correo> listaTablaCorreos) {
        this.listaTablaCorreos = listaTablaCorreos;
    }

    public int getIdTelefono() throws SNMPExceptions, SQLException {
        TelefonoDB telDB = new TelefonoDB();
        return telDB.obtenerIdTelefono();
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTipoTelefono(int id) {
        String tipo = "";
        if (id == 1) {
            tipo = "Casa";
        } else if (id == 2) {
            tipo = "Celular";
        } else if (id == 3) {
            tipo = "Trabajo";
        }
        return tipo;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public String getDeshabilitarCampo() {
        return deshabilitarCampo;
    }

    public void setDeshabilitarCampo(String deshabilitarCampo) {
        this.deshabilitarCampo = deshabilitarCampo;
    }

    public int getIdPersona() throws SNMPExceptions, SQLException {
        PersonaDB perDB = new PersonaDB();
        return perDB.obtenerIdPersona();
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public LinkedList<Telefono> getNumerosTelefono() {
        return numerosTelefono;
    }

    public void setNumerosTelefono(LinkedList<Telefono> numerosTelefono) {
        this.numerosTelefono = numerosTelefono;
    }

    public int getIdTipoTelefono() {
        return idTipoTelefono;
    }

    public void setIdTipoTelefono(int idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    public LinkedList<Tipo_Telefono> getTiposTelefono() throws SNMPExceptions, SQLException {
        LinkedList<Tipo_Telefono> lista = new LinkedList<Tipo_Telefono>();
        Tipo_TelefonoDB tipoTel = new Tipo_TelefonoDB();
        Tipo_Telefono tip = new Tipo_Telefono(0, "");

        lista = tipoTel.SeleccionarTodos();
        lista.offerFirst(tip);

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setTiposTelefono(LinkedList<Tipo_Telefono> tiposTelefono) {
        this.tiposTelefono = tiposTelefono;
    }

    public LinkedList<Telefono> getListaTablaTelefonos() throws SNMPExceptions, SQLException {
        int id = this.getIdPersona();
        LinkedList<Telefono> lista = new LinkedList<Telefono>();
        lista = getTablaTelefonos(id);
        return lista;
    }

    public LinkedList<Telefono> getTablaTelefonos(int idPersona) throws SNMPExceptions, SQLException {
        LinkedList<Telefono> lista = new LinkedList<Telefono>();
        TelefonoDB telDB = new TelefonoDB();
        lista = telDB.SeleccionarTodos(idPersona);
        return lista;
    }

    public void setListaTablaTelefonos(LinkedList<Telefono> listaTablaTelefonos) {
        this.listaTablaTelefonos = listaTablaTelefonos;
    }

    public String getHideButtons() {
        return hideButtons;
    }

    public void setHideButtons(String hideButtons) {
        this.hideButtons = hideButtons;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public LinkedList<Rol> getListaRoles() throws SNMPExceptions, SQLException {
        LinkedList<Rol> lista = new LinkedList<Rol>();
        RolDB rolDB = new RolDB();
        Rol rol = new Rol(0, "");

        lista = rolDB.SeleccionarTodos();
        lista.offerFirst(rol);

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setListaRoles(LinkedList<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public String getConfcontrasenna() {
        return confcontrasenna;
    }

    public void setConfcontrasenna(String confcontrasenna) {
        this.confcontrasenna = confcontrasenna;
    }

    public LinkedList<Tipo_Identificacion> getListaTipoIdentificacion() throws SNMPExceptions, SQLException {
        LinkedList<Tipo_Identificacion> lista = new LinkedList<Tipo_Identificacion>();
        Tipo_IdentificacionDB tipoDB = new Tipo_IdentificacionDB();
        Tipo_Identificacion tipo = new Tipo_Identificacion(0, "");

        lista = tipoDB.SeleccionarTodos();
        lista.offerFirst(tipo);

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setListaTipoIdentificacion(LinkedList<Tipo_Identificacion> listaTipoIdentificacion) {
        this.listaTipoIdentificacion = listaTipoIdentificacion;
    }

    public LinkedList<Persona> getListaTablaPersonasDesactivados() throws SNMPExceptions, SQLException {
        LinkedList<Persona> lista = new LinkedList<Persona>();
        PersonaDB sDB = new PersonaDB();

        lista = sDB.SeleccionaTodosDesactivados();

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setListaTablaPersonasDesactivados(LinkedList<Persona> listaTablaPersonasDesactivados) {
        this.listaTablaPersonasDesactivados = listaTablaPersonasDesactivados;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    int Estado;

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public void setListaTablaPersonas(LinkedList<Persona> listaTablaPersonas) {
        this.listaTablaPersonas = listaTablaPersonas;
    }

    public Persona getObj() {
        return obj;
    }

    public void setObj(Persona obj) {
        this.obj = obj;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(int idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdUsuRegistra() {
        return idUsuRegistra;
    }

    public void setIdUsuRegistra(int idUsuRegistra) {
        this.idUsuRegistra = idUsuRegistra;
    }

    public String getFeRegistra() {
        return this.getDate().format(now);
    }

    public void setFeRegistra(String feRegistra) {
        this.feRegistra = feRegistra;
    }

    public int getIdUsuEdita() {
        return idUsuEdita;
    }

    public void setIdUsuEdita(int idUsuEdita) {
        this.idUsuEdita = idUsuEdita;
    }

    public String getFeEdita() {
        return this.getDate().format(now);
    }

    public void setFeEdita(String feEdita) {
        this.feEdita = feEdita;
    }

    public PersonaBean() {
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public LinkedList<Persona> getListaTablaPersonas() throws SNMPExceptions, SQLException {
        LinkedList<Persona> lista = new LinkedList<Persona>();
        PersonaDB sDB = new PersonaDB();

        lista = sDB.SeleccionaTodos();

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void limpia() {
        this.setIdTipoIdentificacion(0);
        this.setIdentificacion("");
        this.setNombre("");
        this.setContrasenna("");
        this.setsApellido("");
        this.setpApellido("");
        this.setContrasenna("");
        this.setIdRol(0);
        this.setEstado(0);
        this.setIdUsuRegistra(0);
        this.setFeRegistra("");
        this.setIdUsuEdita(0);
        this.setFeEdita("");

    }

    public void eliminarPersona(Persona obj) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        PersonaDB pDB = new PersonaDB();
        pDB.Desactivar(obj.id, obj.estado);

        this.getListaTablaPersonas();
        this.getListaTablaPersonasDesactivados();
    }

    public String activarPesona(int idp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        PersonaDB pDB = new PersonaDB();
        pDB.Desactivar(obj.id, obj.estado);

        return "/usuarioMant.xhtml?faces-redirect=true";
    }

    public void consultarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        final Map<String, Object> session = context.getSessionMap();
        final Object user = session.get("Usuario");

        if (user != null) {
            try {
                String userId = user.toString();
                this.setIdUsuRegistra(idUsuRegistra);

            } catch (ClassCastException e) {

            }
        } else {
            context.invalidateSession();
        }
    }

    public void llenarCampos(Persona per) throws SNMPExceptions, SQLException {
        this.setId(per.getId());
        this.setIdTipoIdentificacion(per.getIdTipoIdentificacion());
        this.setIdentificacion(per.getIdentificacion());
        this.setNombre(per.getNombre());
        this.setIdRol(per.getIdRol());
        this.setpApellido(per.getpApellido());
        this.setsApellido(per.getsApellido());
        this.setContrasenna(per.getContrasenna());
        this.setConfcontrasenna(per.getContrasenna());
        /*this.setListaTablaTelefonos(this.getTablaTelefonos(per.getId()));
        this.setListaTablaCorreos(this.getListaCorreos(per.getId()));*/
        this.setHideButtons("hidden");
        this.setCssClass("");
    }

    public String verPersona(Persona per) throws SNMPExceptions, SQLException {
        this.llenarCampos(per);
        return "/usuarioEditar.xhtml?faces-redirect=true&includeViewParams=true";
    }

    public String actualizaDatos() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        Persona obj = new Persona(this.getId(), this.getIdTipoIdentificacion(), this.getIdentificacion(), this.getNombre(), this.getpApellido(), this.getsApellido(),
                this.getContrasenna(), this.getIdRol(), this.getEstado(), this.getIdUsuRegistra(), this.getFeRegistra(), this.getIdUsuEdita(), this.getFeEdita());
        PersonaDB pDB = new PersonaDB();
        pDB.Actualizar(obj);

        return "/usuarioMant.xhtml?faces-redirect=true";
    }

    public String agregarPersona() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        if (ValidarCamposNulos()) {
            return "";
        }
        Estado = 0;
        this.setIdRol(3);
        Persona obj = new Persona(this.getId(), this.getIdTipoIdentificacion(), this.getIdentificacion(), this.getNombre(), this.getpApellido(), this.getsApellido(),
                this.getContrasenna(), this.getIdRol(), this.getEstado(), this.getIdUsuRegistra(), this.getFeRegistra(), this.getIdUsuEdita(), this.getFeEdita());

        PersonaDB pDB = new PersonaDB();

        pDB.Guardar(obj);

        //this.limpia();
        this.setCssClass("");
        this.setHideButtons("hidden");
        this.setDeshabilitarCampo("disabled");
        return "/usuarioRegistro.xhtml?faces-redirect=true";
    }

    public String agregarTelefono() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        Telefono obj = new Telefono(this.getNumeroTel(), this.getIdTipoTelefono(), this.getIdUsuRegistra(), this.getFeRegistra(), this.getIdUsuEdita(), this.getFeEdita());

        TelefonoDB telDB = new TelefonoDB();

        telDB.Guardar(obj);
        int idPersonaAgregada = this.getIdPersona();
        telDB.GuardarTelefonoPersona(this.getIdTelefono(), idPersonaAgregada);
        this.limpiaCamposTelefono();
        this.setListaTablaTelefonos(this.getListaTablaTelefonos());
        return "/usuarioRegistro.xhtml?faces-redirect=true";
    }

    public String agregarCorreo() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        Correo obj = new Correo(this.getCorreo(), this.getIdUsuRegistra(), this.getFeRegistra(), this.getIdUsuEdita(), this.getFeEdita());

        CorreoDB cDB = new CorreoDB();

        cDB.Guardar(obj);
        int idPersonaAgregada = this.getIdPersona();
        cDB.guardarCorreoPersona(idPersonaAgregada, this.getIdCorreo());
        this.limpiaCamposCorreo();
        this.setListaTablaCorreos(this.getListaTablaCorreos());
        return "/usuarioRegistro.xhtml?faces-redirect=true";
    }

    public void limpiaCamposTelefono() {
        this.setIdTipoTelefono(0);
        this.setNumeroTel("");
    }

    public void limpiaCamposCorreo() {
        this.setCorreo("");
    }

    public void cierraSesion() throws IOException {

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void asignaValores(Persona per) {
        this.setIdTipoIdentificacion(per.getIdTipoIdentificacion());
        this.setIdentificacion(per.getIdentificacion());
        this.setNombre(per.getNombre());
        this.setpApellido(per.getpApellido());
        this.setsApellido(per.getsApellido());
        this.setContrasenna(per.getContrasenna());
        this.setIdRol(per.getIdRol());
        this.setEstado(per.getEstado());
        this.setIdUsuRegistra(per.getIdUsuRegistra());
        this.setFeRegistra(per.getFeEdita());
        this.setIdUsuEdita(per.getIdUsuEdita());
        this.setFeEdita(per.getFeEdita());
    }

    public String eliminarTelefono(Telefono tel) throws SNMPExceptions, SQLException {
        TelefonoDB telDB = new TelefonoDB();
        telDB.eliminar(tel);
        return "usuarioRegistro.xhtml?faces-redirect=true&includeViewParams=true";
    }

    public String eliminarCorreo(Correo cor) throws SNMPExceptions, SQLException {
        CorreoDB corDB = new CorreoDB();
        corDB.eliminar(cor);
        return "usuarioRegistro.xhtml?faces-redirect=true&includeViewParams=true";
    }

    public String irARegistro() {
        this.limpia();
        this.limpiaCamposTelefono();
        this.cssClass = "hidden";
        this.hideButtons = "";
        return "usuarioRegistro.xhtml?faces-redirect=true";
    }
    
    public String verDirecciones(Persona per){
        this.setPer(per);
        return "direccionMant.xhtml?faces-redirect=true&includeViewParams=true";
    }
    
    public String cancelar(){
        return "usuarioMant.xhtml?faces-redirect=true";
    }

    public String atras() {
        return "iniciarSesion.xhtml?faces-redirect=true";
    }

    public boolean ValidarCamposNulos() {
        boolean bandera = false;
        if (idTipoIdentificacion == 0) {
            this.setError1("Dato invalido");
            bandera = true;
        } else {
            this.setError1("");
        }
        if (identificacion.equals("")) {
            this.setError2("Dato invalido");
            bandera = true;
        } else {
            this.setError2("");
        }
        if (nombre.equals("")) {
            this.setError3("Dato invalido");
            bandera = true;
        } else {
            this.setError3("");
        }
        if (pApellido.equals("")) {
            this.setError4("Dato invalido");
            bandera = true;
        } else {
            this.setError4("");
        }
        if (sApellido.equals("")) {
            this.setError5("Dato invalido");
            bandera = true;
        } else {
            this.setError5("");
        }
        if (contrasenna.equals("")) {
            this.setError6("Dato invalido");
            bandera = true;
        } else {
            this.setError6("");
        }
        if (confcontrasenna.equals("")) {
            this.setError7("Dato invalido");
            bandera = true;
        } else {
            this.setError7("");
        }
        if (!confcontrasenna.equals(confcontrasenna)) {
            this.setError8("Contraseñas diferentes");
            bandera = true;
        } else {
            this.setError8("");
        }
        return bandera;
                
    }
}
