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
public class Evaluación {
    int id_Evaluacion, Puntaje, id_Expediente;
    String Criterios;
    
    public Evaluación() {
        id_Evaluacion = 0;
        Puntaje = 0;
        id_Expediente = 0;
        Criterios = "";
    }

    public int getId_Evaluacion() {
        return id_Evaluacion;
    }

    public void setId_Evaluacion(int id_Evaluacion) {
        this.id_Evaluacion = id_Evaluacion;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }

    public int getId_Expediente() {
        return id_Expediente;
    }

    public void setId_Expediente(int id_Expediente) {
        this.id_Expediente = id_Expediente;
    }

    public String getCriterios() {
        return Criterios;
    }

    public void setCriterios(String Criterios) {
        this.Criterios = Criterios;
    }
    
    
}
