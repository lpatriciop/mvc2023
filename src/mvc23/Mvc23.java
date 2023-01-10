/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc23;

import controlador.ControlPersona;
import controlador.ControladorMenuPrincipal;
import modelo.ModeloPersona;
import vista.ViewPersonas;
import vista.VistaPersonas;
import vista.VistaPrincipal;

/**
 *
 * @author Patricio
 */
public class Mvc23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        VistaPrincipal vista = new VistaPrincipal();
        ControladorMenuPrincipal control=new ControladorMenuPrincipal(vista);
        control.iniciaControl();
        
    }
    
}






























