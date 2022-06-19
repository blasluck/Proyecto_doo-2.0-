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
public class Entrada {
    
    String id_entrada;
    String producto;
    String tipo;
    String trabajador;
    int almacen;
    int cant_ingreso;
    String f_Ingreso;

    
    
    public Entrada(String id_entrada, String producto, String tipo, String trabajador, int almacen, int cant_ingreso, String f_Ingreso) {
        this.id_entrada = id_entrada;
        this.producto = producto;
        this.tipo = tipo;
        this.trabajador = trabajador;
        this.almacen = almacen;
        this.cant_ingreso = cant_ingreso;
        this.f_Ingreso = f_Ingreso;
    }
    
    
    public Entrada(){
        //Constructor por defecto
    }
    

    public String getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(String id_entrada) {
        this.id_entrada = id_entrada;
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

    public String getF_Ingreso() {
        return f_Ingreso;
    }

    public void setF_Ingreso(String f_Ingreso) {
        this.f_Ingreso = f_Ingreso;
    }
    
    
    
}
