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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Clases.*;

public class ConexionCinthia {

    public Connection conexion;
    ResultSet rs = null;
    Statement statement = null;
    Estudiante mEstudiante;

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

    public boolean AltaEstudianteBasico(Estudiante mEstudiante) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Estudiante "
                    + "values (null,'" + mEstudiante.getNombre() + "',"
                    + "'" + mEstudiante.getCarrera() + "',"
                    + "null , null," + mEstudiante.getNC() + ");");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean EliminarEstudiante(Estudiante mEstudiante) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("delete from Estudiante "
                    + " where NC = " + mEstudiante.getNC() + ";");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ModificarEstudiante(String NC, String Nombre, String Carrera) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("update Estudiante set "
                    + "Nombre = '" + Nombre + "',"
                    + "Carrera = '" + Carrera + "'"
                    + " where NC = '" + NC + "';");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            return false;
        }
    }

    public ArrayList ConsultarEstudiantes() {
        ArrayList mListaEstudiantes = new ArrayList();
        Estudiante mEstudiante = null;
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Estudiante;");
            while (resultado.next()) {
                mEstudiante = new Estudiante();
                mEstudiante.setId_Estudiante(resultado.getInt("idEstudiante"));
                mEstudiante.setNombre(resultado.getString("Nombre"));
                mEstudiante.setCarrera(resultado.getString("Carrera"));
                mEstudiante.setId_Expediente(resultado.getInt("Expediente_idExpediente"));
                mEstudiante.setId_Asesor(resultado.getInt("Asesor_idAsesor"));
                mEstudiante.setNC(resultado.getString("NC"));
                mListaEstudiantes.add(mEstudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaEstudiantes;
    }

    public ArrayList ConsultaNombresAsesores() {
        ArrayList mListaNombresAsesores = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Asesor;");
            while (resultado.next()) {
                mListaNombresAsesores.add(resultado.getString("Nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaNombresAsesores;
    }

    public ArrayList ConsultaNombresExpedientes() {
        ArrayList mListaNombresExpedientes = new ArrayList();
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Expediente;");
            while (resultado.next()) {
                mListaNombresExpedientes.add(resultado.getString("Nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaNombresExpedientes;
    }

    public int ConsultarIDAsesores(String NombreAsesor) {
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

    public int ConsultarIDExpediente(String NombreExpediente) {
        Statement consulta;
        ResultSet resultado;
        int IDExpediente = 0;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT idExpediente FROM Expediente WHERE Nombre = '" + NombreExpediente + "';");
            while (resultado.next()) {
                IDExpediente = resultado.getInt("idExpediente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDExpediente;
    }
    public int ConsultarIDExpedienteUltimo() {
        Statement consulta;
        ResultSet resultado;
        int IDExpediente = 0;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT MAX(idExpediente) FROM Expediente;");
            while (resultado.next()) {
                IDExpediente = resultado.getInt("MAX(idExpediente)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDExpediente;
    }
    
    public boolean ModificarExpedienteEstudiante(int idEstudiante, int idExpediente) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("update Estudiante set "
                    + "Expediente_idExpediente = " + idExpediente 
                    + " where idEstudiante = " + idEstudiante + ";");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            return false;
        }
        //update Estudiante set Expediente_idExpediente = 11 where idEstudiante = 12
    }
    
    public boolean AltaEstudianteLogin(Estudiante mEstudiante) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Login "
                    + "values (null, '" + mEstudiante.getNC() + "',"
                    + "'" + mEstudiante.getNombre() + "','"
                    +  mEstudiante.getNC() + "', 'Estudiante'" + ");");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean AltaEstudianteExpediente(Estudiante mEstudiante) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Expediente "
                    + "values (null, '001_" + mEstudiante.getNC() + "', 'Expediente_" +
                            mEstudiante.getNC() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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

}
