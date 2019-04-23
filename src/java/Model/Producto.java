/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Anyel
 */
public class Producto {
    public int idProducto;
    public String nombreProducto;
    public float precio;
    public int cantidadMinima;
    public int estado;
    public String fechaRegistro;
    public String fechaModificacion;
    public int usuarioRegistra;
    public int usuarioModifica;
    public String imagen;

    public Producto(/*int idProducto, */String nombreProducto, int estadop, float precio,
            int cantidadMinima, int usuarioRegistra, String fechaRegistro,
            int usuarioModifica, String fechaModificacion,
            String imagen) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidadMinima = cantidadMinima;
        this.estado = estadop;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.usuarioRegistra = usuarioRegistra;
        this.usuarioModifica = usuarioModifica;
        this.imagen = imagen;
    }
    
    public Producto(int idProducto, String nombreProducto, int estadop, float precio,
            int cantidadMinima, int usuarioRegistra, String fechaRegistro,
            int usuarioModifica, String fechaModificacion,
            String imagen) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidadMinima = cantidadMinima;
        this.estado = estadop;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.usuarioRegistra = usuarioRegistra;
        this.usuarioModifica = usuarioModifica;
        this.imagen = imagen;
    }

    public Producto() {
       
    }

    Producto(/*int idPro, */String nombre, int estadop, float precio, int cantidadE, int cantidadM, String descripcion, String fechaI, String fechaM, int usuarioI, int usuarioM, int idCat, String img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getUsuarioRegistra() {
        return usuarioRegistra;
    }

    public void setUsuarioRegistra(int usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
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

    String getDescripcion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
