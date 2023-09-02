
package presentacion;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import negocio.ArticuloControl;

import java.awt.*;
import java.io.*;


/**
 *
 * @author leopc
 */
public class FrmArticulo extends javax.swing.JInternalFrame {
    
    private final ArticuloControl CONTROL;
    private String accion;
    private String nombreAnt;

    private String rutaOrigen;
    private String rutaDestino;
    private final String DIRECTORIO = "src/files/articulos/";
    private String imagen = "";



    public FrmArticulo() {
        initComponents();
        
        this.CONTROL= new ArticuloControl();
        this.listar("");
        tabgeneral.setEnabledAt(1, false);
        this.accion="guardar";
        txtId.setVisible(false);
        this.cargarCategorias();
        
    }
    
    private void ocultarColumnas() {
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
      
    }

    private void listar(String texto) {
        tablaListado.setModel(this.CONTROL.listar(texto, 10, 1));    
        TableRowSorter orden = new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);            
        this.ocultarColumnas(); 
        lblTotalRegistros.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total() + " registros");

    }


    private void cargarCategorias() {
        DefaultComboBoxModel items = this.CONTROL.seleccionar();
        cboCategoria.setModel(items);
    }
    
    private void subirImagenes() {
      File origen = new File(this.rutaOrigen);
      File destino = new File(this.rutaDestino);

      try {
          InputStream in = new FileInputStream(origen);
          OutputStream out = new FileOutputStream(destino);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
              out.write(buf, 0, len);
            }
            in.close();
            out.close();
            
      } catch (Exception e) {
          JOptionPane.showMessageDialog(this, e.getMessage());
      }
    }

    


    private void limpiar() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        this.accion = "guardar";
    }

    private void mensajeError(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Sistema", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    private void mensajeOk(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Sistema", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

  


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabgeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtStock = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        btnAgregarImagen = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Articulos");

        tabgeneral.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombre");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        lblTotalRegistros.setText("Registros");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDesactivar.setText("Desactivar");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        btnActivar.setText("Activar");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros)
                .addGap(193, 193, 193))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRegistros)
                    .addComponent(btnDesactivar)
                    .addComponent(btnActivar))
                .addContainerGap())
        );

        tabgeneral.addTab("Listado", jPanel1);

        jLabel2.setText("Nombre(*)");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel3.setText("Descripción");

        jLabel4.setText("(*)Campos Obligatorios");

        btnGuardar.setText("Gardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria (*)");

        jLabel6.setText("Codigo");

        jLabel7.setText("Precio de venta(*)");

        txtPrecioVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel8.setText("Stock (*)");

        txtStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel9.setText("Imagen");

        lblImagen.setBackground(new java.awt.Color(255, 255, 51));
        lblImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnAgregarImagen.setText("Agregar Imagen");
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboCategoria, 0, 440, Short.MAX_VALUE)
                                .addComponent(txtCodigo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAgregarImagen)
                                            .addComponent(jButton1))))
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(35, 35, 35)
                                .addComponent(btnCancelar))
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregarImagen)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(15, 15, 15))
        );

        tabgeneral.addTab("Mantenimiento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabgeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabgeneral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       this.listar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
         tabgeneral.setSelectedIndex(1);
         txtNombre.requestFocus();
         tabgeneral.setEnabledAt(1, true);
         tabgeneral.setEnabledAt(0, false);
            this.accion="guardar";

            btnGuardar.setText("Guardar");


    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            tabgeneral.setSelectedIndex(0);
            tabgeneral.setEnabledAt(1, false);
            tabgeneral.setEnabledAt(0, true);
            this.limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
            if (txtNombre.getText().length() == 0 || txtNombre.getText().length() > 100) {
                JOptionPane.showMessageDialog(this, "Debes ingresar un nombre y no debe ser mayor a 50 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE);
                txtNombre.requestFocus();
                return;
            }

            if (txtPrecioVenta.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Debes ingresar un precio de venta, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE);
                txtPrecioVenta.requestFocus();
                return;
            }

            if (txtStock.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Debes ingresar un stock, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE);
                txtStock.requestFocus();
                return;
            }


            if (txtDescripcion.getText().length() > 256) {
                JOptionPane.showMessageDialog(this, "Debes ingresar una descripción no mayor a 256 caracteres", "Sistema", JOptionPane.WARNING_MESSAGE);
                txtDescripcion.requestFocus();
                return;
            }

            String resp;
            if (this.accion.equals("editar")) {
                //editar
                resp="OK";
               // resp = this.CONTROL.actualizar(Integer.parseInt(txtId.getText()), this.nombreAnt, txtNombre.getText(), txtDescripcion.getText());
                if (resp.equals("OK")) {
                    this.mensajeOk("Actualizado correctamente");
                    this.limpiar();
                    this.listar("");
                    tabgeneral.setSelectedIndex(0);
                    tabgeneral.setEnabledAt(1, false);
                    tabgeneral.setEnabledAt(0, true);
                } else {
                    this.mensajeError(resp);
                }
            } else {
                //guardar
                  resp="OK";
                //resp = this.CONTROL.insertar(txtNombre.getText(), txtDescripcion.getText());
                if (resp.equals("OK")) {
                    this.mensajeOk("Registrado correctamente");
                    tabgeneral.setSelectedIndex(0);
                    this.limpiar();
                    this.listar("");                 

                } else {
                    this.mensajeError(resp);
                }
            }
            


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            if (tablaListado.getSelectedRowCount() == 1) {
                String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
                String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
                this.nombreAnt = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
                String descripcion = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));

                txtId.setText(id);
                txtNombre.setText(nombre);
                txtDescripcion.setText(descripcion);

                tabgeneral.setSelectedIndex(1);
                tabgeneral.setEnabledAt(0, false);
                tabgeneral.setEnabledAt(1, true);

                this.accion = "editar";
                btnGuardar.setText("Editar");

            } else {
                this.mensajeError("Seleccione un registro para editar");
            }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
         if (tablaListado.getSelectedRowCount() == 1) {
                 String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
                 String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
                 if (JOptionPane.showConfirmDialog(this, "¿Deseas desactivar el registro: " + nombre + "?", "Desactivar", JOptionPane.YES_NO_OPTION) == 0) {
                      String resp = this.CONTROL.desactivar(Integer.parseInt(id));
                      if (resp.equals("OK")) {
                            this.mensajeOk("Registro desactivado");
                            this.listar("");
                      } else {
                            this.mensajeError(resp);
                      }
                 }
    
                } else {
                 this.mensajeError("Seleccione un registro para desactivar");
                }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
            if (tablaListado.getSelectedRowCount() == 1) {
                    String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
                    String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
                    if (JOptionPane.showConfirmDialog(this, "¿Deseas activar el registro: " + nombre + "?", "Activar", JOptionPane.YES_NO_OPTION) == 0) {
                        String resp = this.CONTROL.activar(Integer.parseInt(id));
                        if (resp.equals("OK")) {
                                this.mensajeOk("Registro activado");
                                this.listar("");
                        } else {
                                this.mensajeError(resp);
                        }
                    }
        
                    } else {
                    this.mensajeError("Seleccione un registro para activar");
                    }   
    }//GEN-LAST:event_btnActivarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.subirImagenes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser file = new JFileChooser();
        int estado = file.showOpenDialog(this);
        if (estado == JFileChooser.APPROVE_OPTION) {
            this.rutaOrigen = file.getSelectedFile().getAbsolutePath();
            this.rutaDestino = this.DIRECTORIO + file.getSelectedFile().getName();
            this.imagen = file.getSelectedFile().getName();
            ImageIcon imagen = new ImageIcon(this.rutaOrigen);
            lblImagen.setIcon(imagen);
            lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
            
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTabbedPane tabgeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtPrecioVenta;
    private javax.swing.JFormattedTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
