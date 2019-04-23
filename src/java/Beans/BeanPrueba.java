/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Anyel
 */
@Named(value = "beanPrueba")
@SessionScoped
public class BeanPrueba implements Serializable {

    /**
     * Creates a new instance of BeanPrueba
     */
    public BeanPrueba() {
    }
    
}
