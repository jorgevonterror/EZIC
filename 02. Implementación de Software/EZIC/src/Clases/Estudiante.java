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
public class Estudiante {
    int id_Estudiante, id_Expediente, id_Asesor;
    String Nombre, Carrera;
    
    public Estudiante() {
        id_Estudiante = 0; 
        id_Expediente = 0; 
        id_Asesor = 0;
        Nombre = "";
        Carrera = "";
    }

    public int getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public int getId_Expediente() {
        return id_Expediente;
    }

    public void setId_Expediente(int id_Expediente) {
        this.id_Expediente = id_Expediente;
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

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
    
    
}
