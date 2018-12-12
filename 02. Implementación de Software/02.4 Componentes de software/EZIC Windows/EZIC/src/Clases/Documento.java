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
public class Documento {
    int id_Documento, id_Expediente, id_Estudiante;
    String Titulo, Tipo;    //Falta la variable "Contenido" de tipo blob
    
    public Documento() {
        id_Documento = 0;
        id_Expediente = 0;
        id_Estudiante = 0;
        Titulo = "";
        Tipo = "";
    }

    public int getId_Documento() {
        return id_Documento;
    }

    public void setId_Documento(int id_Documento) {
        this.id_Documento = id_Documento;
    }

    public int getId_Expediente() {
        return id_Expediente;
    }

    public void setId_Expediente(int id_Expediente) {
        this.id_Expediente = id_Expediente;
    }

    public int getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}
