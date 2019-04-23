/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Tipo_Perfil_Empleado;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Pablo Mora
 */
@Named(value = "tipo_Perfil_EmpleadoBean")
@SessionScoped
public class Tipo_Perfil_EmpleadoBean implements Serializable {

    LinkedList<Tipo_Perfil_Empleado> listaTablaProductos = new LinkedList<Tipo_Perfil_Empleado>();
    int id;
    String descripcion;
    int estado;
    int idPersona;
    int idPerfEmpleado;
    int idUsuRegistra;
    Date feRegistra;
    int idUsuEdita;
    Date feEdita;

    public Tipo_Perfil_EmpleadoBean() {
    }

}
