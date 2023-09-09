/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import datos.RolDao;
import datos.UsuarioDao;

 
import entidades.Rol;
import entidades.Usuario;


/**
 *
 * @author leopc
 */
public class UsuarioControl {
    private final UsuarioDao DATOS;
    private final RolDao DATOSROL;
    private Usuario obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public UsuarioControl() {
        this.DATOS = new UsuarioDao();
        this.DATOSROL= new RolDao();
        this.obj = new Usuario();
        this.registrosMostrados = 0;
        
    }

   public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Usuario> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));
        String[] titulos = {"Id", "Rol Id", "Rol Nombre", "Nombre", "Tipo Documento", "Num Documento", "Dirección", "Teléfono", "Email", "Clave", "Activo"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        String estado;
        String[] registro = new String[11];
        this.registrosMostrados = 0;
        for (Usuario item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
                registro[0] = Integer.toString(item.getId());
                registro[1] = Integer.toString(item.getRolId());
                registro[2] = item.getRolNombre();
                registro[3] = item.getNombre();
                registro[4] = item.getTipoDocumento();
                registro[5] = item.getNumDocumento();
                registro[6] = item.getDireccion();
                registro[7] = item.getTelefono();
                registro[8] = item.getEmail();
                registro[9] = item.getClave();
                registro[10] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }


    public String login(String email, String clave) {
        String respuesta = "0";
        Usuario usuario = DATOS.login(email, encriptar(clave));

        if (usuario != null) {
            if (usuario.isActivo()) {
                Variables.usuarioId = usuario.getId();
                Variables.rolId = usuario.getRolId();
                Variables.rolNombre = usuario.getRolNombre();
                Variables.usuarioNombre = usuario.getNombre();
                Variables.usuarioEmail = usuario.getEmail();
                respuesta = "1";
            } else {
                respuesta = "2";
            }

       }
        return respuesta;
    }



    public DefaultComboBoxModel seleccionar() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Rol> lista = DATOSROL.seleccionar();
        lista = DATOSROL.seleccionar();
        for (Rol item : lista) {
            items.addElement(new Rol(item.getId(), item.getNombre(), item.getDescripcion()));
        }
        return items;
    }

    private static String encriptar (String valor){

        MessageDigest md;

        try {
            md=MessageDigest.getInstance("MD5");
            byte[] valorMD5=md.digest(valor.getBytes());
            StringBuilder sb=new StringBuilder();
            for(byte b: valorMD5){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            return null;
        }

    }


    public String insertar(int RolId, String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String email, String clave) {

        if (DATOS.existe(email)) {
            return "El registro ya existe.";
        } else {
            obj.setRolId(RolId);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            obj.setClave(encriptar(clave));
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro.";
            }
        }              
    }


    public String actualizar(int id,int RolId, String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String email, String emailAnt, String clave){
        if (email.equals(emailAnt)){
            obj.setId(id);
            obj.setRolId(RolId);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);

            String encriptado;
            if (clave.length()==64){
                encriptado=clave;
            }else{
                encriptado=this.encriptar(clave);
            }
            obj.setClave(encriptado);

            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "Error en la actualización.";
            }
        }else{
            if (DATOS.existe(email)){
                return "El registro ya existe.";
            }else{
                obj.setId(id);
                obj.setRolId(RolId);
                obj.setNombre(nombre);
                obj.setTipoDocumento(tipoDocumento);
                obj.setNumDocumento(numDocumento);
                obj.setDireccion(direccion);
                obj.setTelefono(telefono);
                obj.setEmail(email);

                String encriptado;
                if (clave.length() == 64) {
                    encriptado = clave;
                } else {
                    encriptado = this.encriptar(clave);
                }
                obj.setClave(encriptado);

                if (DATOS.actualizar(obj)){
                    return "OK";
                }else{
                    return "Error en la actualización.";
                }
            }
        }
    }


    public String desactivar(int id) {

        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "Error al desactivar, el registro tiene dependencia.";

        }

    }

    public String activar(int id) {

        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "Error al activar.";
        }
    }

    public int total() {
        return DATOS.total();      
    }


    public int totalMostrados() {
        return this.registrosMostrados; 

    }

}
