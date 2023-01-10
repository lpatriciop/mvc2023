/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patricio
 */
public class ModeloPersona extends Persona{

    public ModeloPersona() {
    }

    public ModeloPersona(String idPersona, String nombre, String apellido, String telefono, String correo) {
        super(idPersona, nombre, apellido, telefono, correo);
    }

    static public List<Persona> listaPersonas(){
    
        try {
            List<Persona> lista=new ArrayList<Persona>();
            String sql="select idpersona as id,nombres,apellidos,telefono,correo from persona";
            ConectPG conpg=new ConectPG();
            ResultSet rs=conpg.consulta(sql);
            while(rs.next()){
                Persona persona=new Persona();
                persona.setIdPersona(rs.getString("id"));
                persona.setNombre(rs.getString("nombres"));
                persona.setApellido(rs.getString("apellidos"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                lista.add(persona);
            }
            rs.close();//IMPORTANTISIMO!!!!!!!
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SQLException grabaPersona(){
            String sql="INSERT INTO persona (idpersona,nombres,apellidos,telefono,correo)" ;
                   sql+=" VALUES('"+ getIdPersona() +"','"+ getNombre()+"','"+ getApellido()+"','" + getTelefono() +"','"+getCorreo()+"')";
            ConectPG conpg=new ConectPG();
            SQLException ex=conpg.accion(sql);     
            return ex;
            
    }
    
}
