/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Conexion;
import datos.interfaces.CrudInterface;
import entidades.Categoria;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author leopc
 */
public class CategoriaDao implements CrudInterface<Categoria>{
    
    
private final Conexion CON;
private PreparedStatement ps;
private ResultSet rs;
private boolean resp;

public CategoriaDao(){
    
    CON=Conexion.getInstancia();
}

    @Override
    public List<Categoria> listar(String texto) {
        List<Categoria> registros =new ArrayList<>();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM categoria WHERE nombre LIKE ?");
            ps.setString(1, "%"+texto+"%");
            rs=ps.executeQuery();
            while (rs.next()) {
                registros.add(new Categoria(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4)));
            }
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;    
     }    
    
    
     public List<Categoria> seleccionar() {
        List<Categoria> registros =new ArrayList<>();
        try {
            ps=CON.conectar().prepareStatement("SELECT id, nombre FROM categoria ORDER BY nombre ASC");
            rs=ps.executeQuery();
            while (rs.next()) {
                registros.add(new Categoria(rs.getInt(1),rs.getString(2)));
            }
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;    
     }

    
    
    @Override
    public boolean insertar(Categoria obj) {

        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO categoria (nombre,descripcion,activo) VALUES (?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
          
            if (ps.executeUpdate()>0) {
                resp=true;
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;

    }

    @Override
    public boolean actualizar(Categoria obj) {

        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categoria SET nombre=?,descripcion=? WHERE id=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getId());
          
            if (ps.executeUpdate()>0) {
                resp=true;
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
   }

    @Override
    public boolean desactivar(int id) {

        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categoria SET activo=0 WHERE id=?");
            ps.setInt(1, id);
          
            if (ps.executeUpdate()>0) {
                resp=true;
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;

   }

    @Override
    public boolean activar(int id) {

        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categoria SET activo=1 WHERE id=?");
            ps.setInt(1, id);
          
            if (ps.executeUpdate()>0) {
                resp=true;
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
   }

    @Override
    public int total() {

     int totalRegistros=0;

        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM categoria");
            rs=ps.executeQuery();
            while (rs.next()) {
                totalRegistros=rs.getInt("total");
            }
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }

        return totalRegistros ;

    }
  
      

    @Override
    public boolean existe(String texto) {

        resp=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT nombre FROM categoria WHERE nombre=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
           if (rs.getRow()>0) {
               resp=true;
           }
            rs.close();
            ps.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }

        return resp;

    }
    
    
    
}
