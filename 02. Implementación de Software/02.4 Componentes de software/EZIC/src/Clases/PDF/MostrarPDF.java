/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.PDF;

import Conexiones.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardogarcia
 */
public class MostrarPDF {

    ConexionEduardo mCE = new ConexionEduardo();
    String nombre;
    File archivo1, archivo2;
    OutputStream out;

    public void renombrararchivo(String archivofuente) {

        archivo1 = new File(archivofuente);

        String archivoNuevoPDF = "/Users/eduardogarcia/Downloads/PruebaDoc.pdf";

        archivo2 = new File(archivoNuevoPDF);

        boolean renombrado = archivo1.renameTo(archivo2);

        if (renombrado) {

            JOptionPane.showMessageDialog(null, "Archivo Renombrado con éxito");

        } else {

            JOptionPane.showMessageDialog(null, "No se pudo renombrar el archivo");

        }

        //PARA ABRIR PDF
        try {

            Runtime.getRuntime().exec("open " + archivoNuevoPDF);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void abrir() {
        String fileLocal = new String("/Users/eduardogarcia/Downloads/archivo2.pdf");
        try {

            Runtime.getRuntime().exec("open " + fileLocal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean escribirArchivo() {
        String ArchivoPDF = "/Users/eduardogarcia/Downloads/PruebaDoc.pdf";
        boolean correcto = false;
        try {
            out = new FileOutputStream(ArchivoPDF);
            if (mCE.conectar()) {
                out.write(mCE.MandarPDF("Documento v01"));
                mCE.desconectar();
                out.close();
                correcto = true;
                try {

                    Runtime.getRuntime().exec("open " + ArchivoPDF);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return correcto;

    }
}
