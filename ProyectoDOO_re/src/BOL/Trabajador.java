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
public class Trabajador {
    private String id;
    private String nombres;
    private String apellidos;
    private String cargo;
    private String sexo;
    private String nacimiento;
    private String fecha_ingreso;
    
    public Trabajador(){
            
    }

    public Trabajador(String id, String nombres, String apellidos, String cargo, String sexo, String nacimiento, String fecha_ingreso) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.fecha_ingreso = fecha_ingreso;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

   
}
