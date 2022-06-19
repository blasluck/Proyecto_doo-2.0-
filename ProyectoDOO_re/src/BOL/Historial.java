/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOL;

/**
 *
 * @author Favio Jeb
 */
public class Historial {
    private String fech_ingreso;
    private Trabajador trabajadores;
    private Productos producto;

    public Historial() {
    }

    public Historial(String fech_ingreso, Trabajador trabajadores, Productos producto) {
        this.fech_ingreso = fech_ingreso;
        this.trabajadores = trabajadores;
        this.producto = producto;
    }

    public String getFech_ingreso() {
        return fech_ingreso;
    }

    public void setFech_ingreso(String fech_ingreso) {
        this.fech_ingreso = fech_ingreso;
    }

    public Trabajador getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajador trabajadores) {
        this.trabajadores = trabajadores;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

}
