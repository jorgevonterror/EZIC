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
    int ID_Asesor;
    String Nombre;
    String Puesto;
    String Emp_Inst;
    
    public Asesor() {
        ID_Asesor = 0;
        Nombre = "";
        Puesto = "";
        Emp_Inst = "";
    }

    public int getID_Asesor() {
        return ID_Asesor;
    }

    public void setID_Asesor(int ID_Asesor) {
        this.ID_Asesor = ID_Asesor;
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
