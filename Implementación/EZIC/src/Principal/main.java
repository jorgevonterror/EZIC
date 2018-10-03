/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Conexion.Conexion;

/**
 *
 * @author jorgeantoniogarciagomez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //LoginNuevo LN = new LoginNuevo();
        //LN.show();
        Conexion mCon = new Conexion();
        mCon.conectar();
    }

}
