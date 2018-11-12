/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrames;

/**
 *
 * @author kevincruz
 */
public class DatosAsesor {
    private int idAsesor;
    private String Nombre;
    private String Puesto;
    private String Emp_Inst;
    
    public DatosAsesor() {
        idAsesor = 0;
        Nombre = "";
        Puesto = "";
        Emp_Inst = "";
    }

    public int getIdAsesor() {
        return idAsesor;
    }

    public void setIdAsesor(int idAsesor) {
        this.idAsesor = idAsesor;
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
