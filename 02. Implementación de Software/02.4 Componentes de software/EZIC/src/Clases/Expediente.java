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
public class Expediente {
    int id_Expediente;
    String Folio, Nombre;
    
    public Expediente() {
        id_Expediente = 0;
        Folio = "";
        Nombre = "";
    }

    public int getId_Expediente() {
        return id_Expediente;
    }

    public void setId_Expediente(int id_Expediente) {
        this.id_Expediente = id_Expediente;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String Folio) {
        this.Folio = Folio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
