/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloPersona;
import modelo.Persona;
import vista.VistaPersonas;


/**
 *
 * @author Patricio
 */
public class ControlPersona {
    
    private ModeloPersona modelo;
    private VistaPersonas vista;

    public ControlPersona(ModeloPersona modelo, VistaPersonas vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
//Aprovecho Constr Visible a mi vista
    }
    public void iniciaControl(){
     vista.getBtnActualizar().addActionListener(l->cargaPersonas());
     vista.getBntCrear().addActionListener(l->abrirDialogo(1));
     vista.getBtnEditar().addActionListener(l->abrirDialogo(2));
     vista.getBtnAceptar().addActionListener(l->crearEditarPersona());
    }
    private void cargaPersonas(){
    //Control para consultar al modelo
    // Y luego en la vista.
        List<Persona> listap=ModeloPersona.listaPersonas();
        DefaultTableModel mTabla;
        mTabla=(DefaultTableModel)vista.getTblPersonas().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(pe->{
           String[] filanueva={pe.getIdPersona(),pe.getNombre() + " " + pe.getApellido(),pe.getTelefono(),pe.getCorreo()};
           mTabla.addRow(filanueva);
        });
        
        
    }
    
     private void abrirDialogo(int ce){
        String title;
        if (ce==1){
          title="Crear nueva Persona";
          vista.getDlgCrud().setName("crear");
        }else{
          title="Editar Persona";
          vista.getDlgCrud().setName("editar");
        }
        
        vista.getDlgCrud().setLocationRelativeTo(vista);
        vista.getDlgCrud().setSize(600,300);
        vista.getDlgCrud().setTitle(title);
        vista.getDlgCrud().setVisible(true);
        
    }
    private void crearEditarPersona(){
        if (vista.getDlgCrud().getName()=="crear"){
            //INSERTAR
            String cedula=vista.getTxtId().getText();
            String nombres=vista.getTxtNombres().getText();
            String apellidos=vista.getTxtApellidos().getText();
            String correo = vista.getTxtCorreo().getText();
            String telefono= vista.getTxtTelefono().getText();
            
            ModeloPersona persona = new ModeloPersona();
            persona.setIdPersona(cedula);
            persona.setNombre(nombres);
            persona.setApellido(apellidos);
            persona.setTelefono(telefono);
            persona.setCorreo(correo);
                       
           if( persona.grabaPersona()==null){
               vista.getDlgCrud().setVisible(false);
               JOptionPane.showMessageDialog(vista, "Persona Creada Satisfactoriamente");
           }else{
               JOptionPane.showMessageDialog(vista, "No se pudo crear la persona");
           }
            
        }//else hacemos el editar
        //Actualizar
        cargaPersonas();
    }
    
}


















