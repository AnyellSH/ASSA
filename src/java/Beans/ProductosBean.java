/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import Model.ProductoDB;
import Model.Producto;
import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.naming.NamingException;

/**
 *
 * @author Anyel
 */
@Named(value = "productosBean")
@SessionScoped
public class ProductosBean implements Serializable {

    SimpleDateFormat date = null;
    Date now = new Date(System.currentTimeMillis());
    LinkedList<Producto> listaTablaProductos = new LinkedList<Producto>();
    LinkedList<Producto> listaTablaProductosDesactivados = new LinkedList<Producto>();
    Producto obj;

    int idProducto;
    String nombreProducto;
    float precio;
    int cantidadMinima;
    int estado;
    String fechaRegistro;
    String fechaModificacion;
    int usuarioRegistro;
    int usuarioModifica;
    String imagen;
    String rutaRecibida = "";
    Part file;
    String usuarioIng;
    Boolean estadoV;
    Boolean estadoF;

    /**
     * Creates a new instance of ProductosBean
     */
    public ProductosBean() {
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public LinkedList<Producto> getListaTablaProductos() throws SNMPExceptions, SQLException {
        LinkedList<Producto> lista = new LinkedList<Producto>();
        ProductoDB sDB = new ProductoDB();

        lista = sDB.SeleccionaTodos();

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setListaTablaProductos(LinkedList<Producto> listaTablaProductos) {
        this.listaTablaProductos = listaTablaProductos;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUsuarioIng() {
        return usuarioIng;
    }

    public void setUsuarioIng(String usuarioIng) {
        this.usuarioIng = usuarioIng;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(int usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getRutaRecibida() {
        return rutaRecibida;
    }

    public void setRutaRecibida(String rutaRecibida) {
        this.rutaRecibida = rutaRecibida;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public int getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(int usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public Boolean getEstadoV() {
        return estadoV;
    }

    public void setEstadoV(Boolean estadoV) {
        this.estadoV = estadoV;
    }

    public Boolean getEstadoF() {
        return estadoF;
    }

    public void setEstadoF(Boolean estadoF) {
        this.estadoF = estadoF;
    }

    public LinkedList<Producto> getListaTablaProductosDesactivados() throws SNMPExceptions, SQLException {
        LinkedList<Producto> lista = new LinkedList<Producto>();
        ProductoDB sDB = new ProductoDB();

        lista = sDB.SeleccionaTodosDesactivados();

        LinkedList resultlista = new LinkedList();
        resultlista = lista;
        return resultlista;
    }

    public void setListaTablaProductosDesactivados(LinkedList<Producto> listaTablaProductosDesactivados) {
        this.listaTablaProductosDesactivados = listaTablaProductosDesactivados;
    }

    public Producto getObj() {
        return obj;
    }

    public void setObj(Producto obj) {
        this.obj = obj;
    }

    public void limpia() {
        this.setIdProducto(0);
        this.setNombreProducto("");
        this.setCantidadMinima(0);
        this.setFechaRegistro("");
        this.setFechaModificacion("");
        this.setPrecio(0);
        this.setUsuarioRegistro(0);
        this.setUsuarioModifica(0);
        this.setImagen("");
        this.setRutaRecibida("");
        this.setEstadoV(false);
    }

    public void asignaURL() throws MessagingException, IOException {

        imagen = file.toString();
        String i = file.getFileName();
//        i = this.getFile().getFileName();

        if (this.getImagen().equals("")) {
            this.setImagen("../img/" + i);
        }
        this.setRutaRecibida("../img/" + i);
    }

    public void eliminarProducto(Producto obj) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        ProductoDB pDB = new ProductoDB();
        if (obj.estado == 1) {
            obj.estado = 0;
        }
        pDB.Desactivar(obj.getIdProducto(), obj.getEstado());

        this.getListaTablaProductos();
        this.getListaTablaProductosDesactivados();

    }

    public void activarProducto(int idp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        ProductoDB pDB = new ProductoDB();

        obj = pDB.SeleccionarUno(idp);
        obj.estado = 1;
        pDB.Desactivar(obj.getIdProducto(), obj.getEstado());

        this.getListaTablaProductos();
        this.getListaTablaProductosDesactivados();

    }

    public void consultarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        final Map<String, Object> session = context.getSessionMap();
        final Object user = session.get("Usuario");

        if (user != null) {
            try {
                String userId = user.toString();
                this.setUsuarioRegistro(usuarioRegistro);

            } catch (ClassCastException e) {

            }
        } else {
            context.invalidateSession();
        }
    }

    public String actualizaDatos() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
            
        String img = "";

        if (this.getRutaRecibida().equals("")) {
            img = this.getImagen();
        } else {
            img = this.getRutaRecibida();
        }

        Producto obj = new Producto(this.getIdProducto(), this.getNombreProducto(), this.getEstado(), this.getPrecio(),
                this.getCantidadMinima(), this.getUsuarioRegistro(), this.getFechaRegistro(),
                this.getUsuarioModifica(), this.getDate().format(now), this.getImagen());

        ProductoDB pDB = new ProductoDB();

        pDB.Actualizar(obj);

        this.limpia();
        //this.getListaTablaProductos();
        return "/productoMant.xhtml?faces-redirect=true";
    }

    public String agregarProducto() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException, MessagingException, IOException {
        if (estadoV) {
            estado = 1;
        } else {
            if (estadoF) {
                estado = 0;
            }
        }
        
        //String s = new Scanner(this.getFile().getInputStream()).useDelimiter("\\A").next();
                
        Producto obj = new Producto(this.getNombreProducto(), this.getEstado(), this.getPrecio(),
                this.getCantidadMinima(), this.getUsuarioRegistro(), this.getDate().format(now),
                this.getUsuarioModifica(), this.getDate().format(now), this.getImagen());

        ProductoDB pDB = new ProductoDB();

        pDB.Guardar(obj);

        this.limpia();
        //this.getListaTablaProductos();
        return "/productoMant.xhtml?faces-redirect=true";
    }
    
    public String verProducto(Producto pro){
        this.asignaValores(pro);
        return "/productoEditar.xhtml?faces-redirect=true&includeViewParams=true";
    }

    public void cierraSesion() throws IOException {

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void asignaValores(Producto pro) {
        this.setIdProducto(pro.getIdProducto());
        this.setNombreProducto(pro.getNombreProducto());
        this.setCantidadMinima(pro.getCantidadMinima());
//        this.setFechaRegistro(date.toString());
        this.setFechaModificacion(this.getDate().format(now));
        this.setPrecio(pro.getPrecio());
        
        if(pro.getEstado()==1){
            this.setEstadoV(true);
        }
        else {
            this.setEstadoF(false);
        }
        this.setEstado(pro.getEstado());
//        this.setUsuarioRegistro(pro.getUsuarioRegistra());
        this.setUsuarioModifica(pro.getUsuarioModifica());
        this.setImagen(pro.getImagen());
    }
    
    public String cancelar() {
        this.limpia();
        return "productoMant.xhtml?faces-redirect=true";
    }
}
