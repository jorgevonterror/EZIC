/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author eduardogarcia
 */
public class Asesor {
    int id_Asesor;
    String Nombre, Puesto, Emp_Inst;
    
    public Asesor() {
        id_Asesor = 0;
        Nombre = "";
        Puesto = "";
        Emp_Inst = "";
    }

    public int getId_Asesor() {
        return id_Asesor;
    }

    public void setId_Asesor(int id_Asesor) {
        this.id_Asesor = id_Asesor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public String getEmp_Inst() {
        return Emp_Inst;
    }

    public void setEmp_Inst(String Emp_Inst) {
        this.Emp_Inst = Emp_Inst;
    }
    
}
