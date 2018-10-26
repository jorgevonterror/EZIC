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
    String Nombre, Carrera; int Expediente_idExpediente, Asesor_idAsesor, idEstudiante;
    
    public Estudiante() {
        Nombre = "";
        Carrera = "";
        Expediente_idExpediente = 0;
        Asesor_idAsesor = 0;
        idEstudiante = 0;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public int getExpediente_idExpediente() {
        return Expediente_idExpediente;
    }

    public void setExpediente_idExpediente(int Expediente_idExpediente) {
        this.Expediente_idExpediente = Expediente_idExpediente;
    }

    public int getAsesor_idAsesor() {
        return Asesor_idAsesor;
    }

    public void setAsesor_idAsesor(int Asesor_idAsesor) {
        this.Asesor_idAsesor = Asesor_idAsesor;
    }
    
    
}
