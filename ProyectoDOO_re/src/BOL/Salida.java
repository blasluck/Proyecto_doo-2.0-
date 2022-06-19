/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOL;

/**
 *
 * @author Daniel
 */
public class Salida {
    String id_salida;
    String producto;
    String tipo;
    String trabajador;
    int almacen;
    int cant_ingreso;
    String f_Salida;

    public Salida(String id_salida, String producto, String tipo, String trabajador, int almacen, int cant_ingreso, String f_Salida) {
        this.id_salida = id_salida;
        this.producto = producto;
        this.tipo = tipo;
        this.trabajador = trabajador;
        this.almacen = almacen;
        this.cant_ingreso = cant_ingreso;
        this.f_Salida = f_Salida;
    }

    public Salida(){
        //Constructor por defecto
    }    
    
    public String getId_salida() {
        return id_salida;
    }

    public void setId_salida(String id_salida) {
        this.id_salida = id_salida;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public int getCant_ingreso() {
        return cant_ingreso;
    }

    public void setCant_ingreso(int cant_ingreso) {
        this.cant_ingreso = cant_ingreso;
    }

    public String getF_Salida() {
        return f_Salida;
    }

    public void setF_Salida(String f_Salida) {
        this.f_Salida = f_Salida;
    }

    
    
}
