/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import datos.ArticuloDao;
import datos.CategoriaDao;
import entidades.Articulos;
import entidades.Categoria;


/**
 *
 * @author leopc
 */
public class ArticuloControl {
    private final ArticuloDao DATOS;
    private final CategoriaDao DATOSCAT;
    private Articulos obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public ArticuloControl() {
        this.DATOS = new ArticuloDao();
        this.DATOSCAT= new CategoriaDao();
        this.obj = new Articulos();
        this.registrosMostrados = 0;
    }

   public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Articulos> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));
        String[] titulos = {"Id", "Categoria ID", "Categoria", "Código", "Nombre", "Precio Venta", "Stock", "Descripción", "Imagen", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        String estado;
        String[] registro = new String[10];
        this.registrosMostrados = 0;
        for (Articulos item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getCategoriaId());
            registro[2] = item.getCategoriaNombre();
            registro[3] = item.getCodigo();
            registro[4] = item.getNombre();
            registro[5] = Double.toString(item.getPrecioVenta());
            registro[6] = Integer.toString(item.getStock());
            registro[7] = item.getDescripcion();
            registro[8] = item.getImagen();
            registro[9] = estado;            
            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;              
    }

    public DefaultComboBoxModel seleccionar() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Categoria> lista = new ArrayList();
        lista = DATOSCAT.seleccionar();
        for (Categoria item : lista) {
            items.addElement(new Categoria(item.getId(), item.getNombre()));
        }
        return items;
    }


    public String insertar(int categoriaId, String codigo, String nombre, double precioVenta, int stock, String descripcion, String imagen) {

        if (DATOS.existe(nombre)) {
            return "El registro ya existe.";
        } else {
            obj.setCategoriaId(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecioVenta(precioVenta);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro.";
            }
        }              
    }

    public String actualizar(int id, int categoriaId, String codigo, String nombre,String nombreAnt, double precioVenta, int stock, String descripcion, String imagen) {

        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setCategoriaId(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecioVenta(precioVenta);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);

          
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización.";
            }
        } else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe.";
            } else {
                obj.setId(id);
                obj.setCategoriaId(categoriaId);
                obj.setCodigo(codigo);
                obj.setNombre(nombre);
                obj.setPrecioVenta(precioVenta);
                obj.setStock(stock);
                obj.setDescripcion(descripcion);
                obj.setImagen(imagen);   
                      
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
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
