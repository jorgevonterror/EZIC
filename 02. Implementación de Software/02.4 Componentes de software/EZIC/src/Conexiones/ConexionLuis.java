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

import Clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexionLuis {
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
    
    public boolean GuardarUser(User mUser) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("INSERT INTO Login (Username, Nombre, Pass, Tipo)"
                    + "VALUES('" + mUser.getUsername() + "',"
                    + "'" + mUser.getNombre() + "',"
                    + "'" + mUser.getPass() + "',"
                    + "'" + mUser.getTipo() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean ExisteUser(User mUser) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("SELECT Username FROM Login WHERE Username = '"
                    + mUser.getUsername() + "';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean ExisteLogin(User mUser) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            ResultSet res = consulta.executeQuery("SELECT count(*) as existe FROM Login WHERE (Pass = '"
                    + mUser.getPass() + "' AND Username = '" + mUser.getUsername() + "');");
            if (res.first()) {
                int i = res.getInt("existe");
                if (i > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String ConsultaTipoUsuario(String Nombre, String Pass) {
        String Tipo = "";
        Statement consulta;
        ResultSet resultado;

        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Login where Username = '" + Nombre + "'and Pass = '" + Pass +"';");
            while (resultado.next()) {
                Tipo = resultado.getString("Tipo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Tipo;
    }
}
