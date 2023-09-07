package datos;

import database.Conexion;
import entidades.Categoria;
import entidades.Rol;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolDao {

    private final Conexion CON;

    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public RolDao(){
        CON=Conexion.getInstancia();
    }



    public List<Rol> listar() {
        List<Rol> registros =new ArrayList<>();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM rol ");
            
            rs=ps.executeQuery();
            while (rs.next()) {
                registros.add(new Rol(rs.getInt(1),rs.getString(2),rs.getString(3)));
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


    public List<Rol> seleccionar() {
        List<Rol> registros =new ArrayList<>();
        try {
            ps=CON.conectar().prepareStatement("SELECT id , nombre FROM rol  ORDER BY id ASC");
            rs=ps.executeQuery();
            while (rs.next()) {
                registros.add(new Rol(rs.getInt(1),rs.getString(2)));
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


    public int total() {

        int totalRegistros=0;

        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) as total FROM rol");
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



}
