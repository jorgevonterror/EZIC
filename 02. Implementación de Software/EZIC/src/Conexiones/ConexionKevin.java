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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexionKevin {
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
    
        public boolean AltaAsesor(Asesor mAsesor) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Asesor "
                    + "values (null, "
                    + "'" + mAsesor.getNombre() + "',"
                    + "'" + mAsesor.getPuesto() + "',"
                    + "'" + mAsesor.getEmp_Inst() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarAsesor(Asesor mAsesor) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
            consulta.execute("delete from Asesor "
                    + " where idAsesor = " + mAsesor.getId_Asesor()+ ";");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
