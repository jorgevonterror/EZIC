/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

/**
 *
 * @author eduardogarcia
 */

import Clases.Asesor;
import Clases.Estudiante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexionEduardo {
    public Connection conexion;
    ResultSet rs = null;
    Statement statement = null;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:8889/BD_EZIC", "root", "root");
            if (conexion != null) {
                //JOptionPane.showMessageDialog(null, "Conectado");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "NO Conectado");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void desconectar() {
        try {
            this.conexion.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public ArrayList ConsultaPuestoAsesores() {
        ArrayList mListaNomAsesores = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select Puesto from Asesor group by Puesto;");
            while (resultado.next()) {
                mListaNomAsesores.add(resultado.getString("Puesto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaNomAsesores;
    }
    
    public ArrayList ConsultaNombresAsesores() {
        ArrayList mListaNomAsesores = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Asesor;");
            while (resultado.next()) {
                mListaNomAsesores.add(resultado.getString("Nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaNomAsesores;
    }
    
    public int ConsultaIDAsesor(String Nombre) {
        int IDAsesor = 0;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select idAsesor from Asesor where Nombre = '" + Nombre + "';");
            while (resultado.next()) {
                IDAsesor = resultado.getInt("idAsesor");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDAsesor;
    }
    
    public ArrayList ConsultaInstitucionAsesores() {
        ArrayList mListaInstAsesores = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select Emp_Inst from Asesor group by Emp_Inst;");
            while (resultado.next()) {
                mListaInstAsesores.add(resultado.getString("Emp_Inst"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaInstAsesores;
    }
    
    public ArrayList ConsultaInstitucionAsesoresPorPuesto(String Puesto) {
        ArrayList mListaInstAsesores = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Asesor where Puesto = '" + Puesto +"'; ");
            while (resultado.next()) {
                mListaInstAsesores.add(resultado.getString("Emp_Inst"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaInstAsesores;
    }
    
    public ArrayList ConsultarAsesores(String PuestoAsesor, String InstitucionAsesor) {
        ArrayList mListaAsesores = new ArrayList();
        Asesor mAsesor = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * from Asesor where Puesto = '" + PuestoAsesor + "' and Emp_Inst = '"+ InstitucionAsesor +"';");
            while (resultado.next()) {
                mAsesor = new Asesor();
                mAsesor.setId_Asesor(resultado.getInt("idAsesor"));
                mAsesor.setNombre(resultado.getString("Nombre"));
                mAsesor.setPuesto(resultado.getString("Puesto"));
                mAsesor.setEmp_Inst(resultado.getString("Emp_Inst"));
                
                mListaAsesores.add(mAsesor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAsesores;
    }
    
    public ArrayList ConsultarAlumnos(int idAsesor, String Carrera, String Tipo, String NC) {
        ArrayList mListaAlumnos = new ArrayList();
        Estudiante mEstudiante = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            if ("Sin asesor".equals(Tipo)) {
                resultado = consulta.executeQuery("SELECT * from Estudiante where Carrera = '" + Carrera + "' and Asesor_idAsesor is null;");
            } else {
                if ("Cualquiera".equals(Tipo)) {
                    resultado = consulta.executeQuery("SELECT * from Estudiante where Carrera = '" + Carrera + "';");
                } else {
                    resultado = consulta.executeQuery("SELECT * from Estudiante where Asesor_idAsesor = '" + idAsesor + "' and Carrera = '" + Carrera + "' and NC = '" + NC + "';");
                }
                
            }           
            while (resultado.next()) {
                mEstudiante = new Estudiante();
                mEstudiante.setId_Estudiante(resultado.getInt("idEstudiante"));
                mEstudiante.setNombre(resultado.getString("Nombre"));
                mEstudiante.setCarrera(resultado.getString("Carrera"));
                mEstudiante.setId_Expediente(resultado.getInt("Expediente_idExpediente"));
                mEstudiante.setId_Asesor(resultado.getInt("Asesor_idAsesor"));
                mEstudiante.setNC(resultado.getString("NC"));

                mListaAlumnos.add(mEstudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAlumnos;
    }
    
    public ArrayList ConsultarTodosAlumnos() {
        ArrayList mListaAlumnos = new ArrayList();
        Estudiante mEstudiante = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * from Estudiante;");
            while (resultado.next()) {
                mEstudiante = new Estudiante();
                mEstudiante.setId_Estudiante(resultado.getInt("idEstudiante"));
                mEstudiante.setNombre(resultado.getString("Nombre"));
                mEstudiante.setCarrera(resultado.getString("Carrera"));
                mEstudiante.setId_Expediente(resultado.getInt("Expediente_idExpediente"));
                mEstudiante.setId_Asesor(resultado.getInt("Asesor_idAsesor"));
                mEstudiante.setNC(resultado.getString("NC"));

                mListaAlumnos.add(mEstudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAlumnos;
    }
    
    public ArrayList ConsultarTodosAsesores() {
        ArrayList mListaAsesores = new ArrayList();
        Asesor mAsesor = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * from Asesor;");
            while (resultado.next()) {
                mAsesor = new Asesor();
                mAsesor.setId_Asesor(resultado.getInt("idAsesor"));
                mAsesor.setNombre(resultado.getString("Nombre"));
                mAsesor.setPuesto(resultado.getString("Puesto"));
                mAsesor.setEmp_Inst(resultado.getString("Emp_Inst"));
                
                mListaAsesores.add(mAsesor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAsesores;
    }
    
    public boolean ModificarAsesores(int idAsesor, String NombreAsesorNuevo, String PuestoAsesorNuevo, String Emp_InstAsesorNuevo) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("update Asesor set " +
                    "Nombre = '" + NombreAsesorNuevo + "', Puesto = '" + PuestoAsesorNuevo  +  "', Emp_Inst = '" + Emp_InstAsesorNuevo + "' where idAsesor = '" + idAsesor + "';");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            return false;
        }
    }
    
    public ArrayList ConsultaCarreraEstudiantes() {
        ArrayList mListaCarreras = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select Carrera from Estudiante group by Carrera;");
            while (resultado.next()) {
                mListaCarreras.add(resultado.getString("Carrera"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaCarreras;
    }
    
    public ArrayList ConsultaAsesorEstudiantes() {
        ArrayList mListaCarreras = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select Asesor.Nombre from Estudiante,Asesor group by Asesor.Nombre");
            while (resultado.next()) {
                mListaCarreras.add(resultado.getString("Nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaCarreras;
    }
    
    public ArrayList ConsultarTodosAlumnosSinAsig() {
        ArrayList mListaAlumnos = new ArrayList();
        Estudiante mEstudiante = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * from Estudiante where Asesor_idAsesor is null;");
            while (resultado.next()) {
                mEstudiante = new Estudiante();
                mEstudiante.setId_Estudiante(resultado.getInt("idEstudiante"));
                mEstudiante.setNombre(resultado.getString("Nombre"));
                mEstudiante.setCarrera(resultado.getString("Carrera"));
                mEstudiante.setId_Expediente(resultado.getInt("Expediente_idExpediente"));
                mEstudiante.setId_Asesor(resultado.getInt("Asesor_idAsesor"));

                mListaAlumnos.add(mEstudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAlumnos;
    }
    
    public ArrayList ConsultarAlumnosEspecificosSinAsig(String Carrera) {
        ArrayList mListaAlumnos = new ArrayList();
        Estudiante mEstudiante = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            //resultado = consulta.executeQuery("SELECT * from Estudiante where Asesor_idAsesor is null;");
            resultado = consulta.executeQuery("SELECT * from Estudiante where Carrera = '"+ Carrera +"' and Asesor_idAsesor is null;");
            while (resultado.next()) {
                mEstudiante = new Estudiante();
                mEstudiante.setId_Estudiante(resultado.getInt("idEstudiante"));
                mEstudiante.setNombre(resultado.getString("Nombre"));
                mEstudiante.setCarrera(resultado.getString("Carrera"));
                mEstudiante.setId_Expediente(resultado.getInt("Expediente_idExpediente"));
                mEstudiante.setId_Asesor(resultado.getInt("Asesor_idAsesor"));

                mListaAlumnos.add(mEstudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAlumnos;
    }
  
    public boolean AsignarAsesorAEstudiante(int idEstudiante,int idAsesor) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("update Estudiante set " +
                    "Asesor_idAsesor = '" + idAsesor + "' where idEstudiante = '" + idEstudiante + "';");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            return false;
        }
    }
    public int ConsultarIDAsesor(String NombreAsesor) {
        Statement consulta;
        ResultSet resultado;
        int IDAsesor = 0;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT idAsesor from Asesor where Nombre = '" + NombreAsesor + "';");
            while (resultado.next()) {
                IDAsesor = resultado.getInt("idAsesor");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDAsesor;
    }
    
    //Para Alta de documentos
    public ArrayList ConsultaNombreExpedientes() {
        ArrayList mListaExpedientes = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select Nombre from Expediente;");
            while (resultado.next()) {
                mListaExpedientes.add(resultado.getString("Nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaExpedientes;
    }
    public int ConsultarIDExpediente(String NombreExpediente) {
        Statement consulta;
        ResultSet resultado;
        int IDAsesor = 0;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT idExpediente from Expediente where Nombre = '" + NombreExpediente + "';");
            while (resultado.next()) {
                IDAsesor = resultado.getInt("idExpediente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDAsesor;
    }
    
    public ArrayList ConsultarAlumnosEspecificosConAsig() {
        ArrayList mListaAlumnos = new ArrayList();

        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * from Estudiante where Asesor_idAsesor is not null;");
            while (resultado.next()) {
                mListaAlumnos.add(resultado.getString("Nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAlumnos;
    }
    public int ConsultarIDAlumnos(String NC) {
        Statement consulta;
        ResultSet resultado;
        int IDAlumno = 0;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT idEstudiante from Estudiante where NC = '" + NC + "';");
            while (resultado.next()) {
                IDAlumno = resultado.getInt("idEstudiante");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDAlumno;
    }
    
    public int ConsultarIDUltimoDoc() {
        Statement consulta;
        ResultSet resultado;
        int IDAlumno = 0;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select idDocumento from Documento order by idDocumento DESC limit 1;");
            while (resultado.next()) {
                IDAlumno = resultado.getInt("idDocumento");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDAlumno;
    }
    
    public boolean ModificarDocumentos(int idDocumento, int idExpediente, int idEstudiante, String Status) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("update Documento set " +
                    "Expediente_idExpediente = '" + idExpediente + "', Estudiante_idEstudiante = '" + idEstudiante  +  "', Status= '" + Status +"' where idDocumento = '"+ idDocumento +"';");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            return false;
        }
    }
    //Hasta Aqui para Alta de Documentos
    public byte[] MandarPDF(String NombreDoc) {
        Statement consulta;
        ResultSet resultado;
        byte[] ArrayBites = null;
        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("Select Contenido from Documento where Titulo = '" + NombreDoc + "';");
            while (resultado.next()) {
                ArrayBites = resultado.getBytes("Contenido");
            }
            return ArrayBites;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            return ArrayBites;
        }
    }
    public ArrayList ConsultarDocumentosAlumnos(int idExp) {
        ArrayList mListaDocAlumnos = new ArrayList();

        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT Titulo from Documento where Expediente_idExpediente = "+ idExp +";");
            while (resultado.next()) {
                mListaDocAlumnos.add(resultado.getString("Titulo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaDocAlumnos;
    }
    public ArrayList ConsultarStatusAlumnos(int idExp) {
        ArrayList mListaDocAlumnos = new ArrayList();

        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT Status from Documento where Expediente_idExpediente = "+ idExp +";");
            while (resultado.next()) {
                mListaDocAlumnos.add(resultado.getString("Status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaDocAlumnos;
    }
    
    public ArrayList ConsultarAlumnosParaAsesor(int idAsesor, String Carrera) {
        ArrayList mListaAlumnos = new ArrayList();
        Estudiante mEstudiante = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * from Estudiante where Asesor_idAsesor = " + idAsesor + " and Carrera = '" + Carrera + "';");
          
            while (resultado.next()) {
                mEstudiante = new Estudiante();
                mEstudiante.setId_Estudiante(resultado.getInt("idEstudiante"));
                mEstudiante.setNombre(resultado.getString("Nombre"));
                mEstudiante.setCarrera(resultado.getString("Carrera"));
                mEstudiante.setId_Expediente(resultado.getInt("Expediente_idExpediente"));
                mEstudiante.setId_Asesor(resultado.getInt("Asesor_idAsesor"));
                mEstudiante.setNC(resultado.getString("NC"));

                mListaAlumnos.add(mEstudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAlumnos;
    }
    public ArrayList ConsultarTodosAlumnosParaAsesor(int idAsesor) {
        ArrayList mListaAlumnos = new ArrayList();
        Estudiante mEstudiante = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * from Estudiante where Asesor_idAsesor = " + idAsesor + ";");
          
            while (resultado.next()) {
                mEstudiante = new Estudiante();
                mEstudiante.setId_Estudiante(resultado.getInt("idEstudiante"));
                mEstudiante.setNombre(resultado.getString("Nombre"));
                mEstudiante.setCarrera(resultado.getString("Carrera"));
                mEstudiante.setId_Expediente(resultado.getInt("Expediente_idExpediente"));
                mEstudiante.setId_Asesor(resultado.getInt("Asesor_idAsesor"));
                mEstudiante.setNC(resultado.getString("NC"));

                mListaAlumnos.add(mEstudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaAlumnos;
    }
    
    public ArrayList ConsultaCarreraEstudiantesAsignadosAsesor(int idAsesor) {
        ArrayList mListaCarreras = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select Carrera from Estudiante where Asesor_idAsesor = " + idAsesor + " group by Carrera;");
            while (resultado.next()) {
                mListaCarreras.add(resultado.getString("Carrera"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaCarreras;
    }
    
    public boolean ModificarEstadoDocumento(String Titulo, String Status) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("update Documento set " +
                    "Status= '" + Status +"' where Titulo = '"+ Titulo +"';");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            return false;
        }
    }
    
    public boolean AltaEvaluacion(int Puntaje, int idExpediente) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Evaluacion "
                    + "values (null, "
                    + "'Cuestionario',"
                    + "" + Puntaje + ","
                    + "" + idExpediente + ");");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
