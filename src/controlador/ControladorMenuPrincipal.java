/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloPersona;
import vista.VistaPersonas;
import vista.VistaPrincipal;

/**
 *
 * @author Patricio
 */
public class ControladorMenuPrincipal {
    VistaPrincipal vistaPrincipal;

    public ControladorMenuPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }
    
    public void iniciaControl(){
        vistaPrincipal.getMnuPersonas().addActionListener(l->crudPersonas());
        vistaPrincipal.getTlbPersonas().addActionListener(l->crudPersonas());
    }
    
    private void crudPersonas(){
    
        VistaPersonas vista=new VistaPersonas();
        ModeloPersona modelo=new ModeloPersona();
        vistaPrincipal.getDspPrincipal().add(vista);
        ControlPersona control= new ControlPersona(modelo, vista);
        control.iniciaControl();
    }
    
    
}






























