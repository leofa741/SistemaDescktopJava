
package presentacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import negocio.IngresoControl;

import negocio.PersonaControl;



/**
 *
 * @author leopc
 */
public class FrmIngreso extends javax.swing.JInternalFrame {
    
    private final IngresoControl CONTROL;
    private String accion;
    private String emailAnt;   
    private int totalPorPagina = 10;
    private boolean primeraCarga = true;
    private int numPagina = 1;
    private int totalRegistros;
    
    public DefaultTableModel modeloDetalles;

    public FrmIngreso() {
        initComponents();        
        this.CONTROL= new IngresoControl();
        this.paginar();
        this.listar("",false);
        this.primeraCarga = false;
        tabgeneral.setEnabledAt(1, false);
        this.accion="guardar";
        this.crearDetalles();
       
    }
    
    
    private void paginar(){
        int totalPaginas;
        this.totalRegistros = this.CONTROL.total();
        this.totalPorPagina = Integer.parseInt(cboTotalPorPaginas.getSelectedItem().toString());

        totalPaginas = (int)(Math.ceil((double)this.totalRegistros/this.totalPorPagina));
        if (totalPaginas == 0) {
            totalPaginas = 1;
        }
        cboNumPagina.removeAllItems();
        for (int i = 1; i <= totalPaginas; i++) {
            cboNumPagina.addItem(Integer.toString(i));
        }
        cboNumPagina.setSelectedIndex(0);    
    }

    private void listar(String texto,boolean paginar){
            this.totalPorPagina = Integer.parseInt(cboTotalPorPaginas.getSelectedItem().toString());
            if (cboNumPagina.getSelectedItem() != null) {
                this.numPagina = Integer.parseInt(cboNumPagina.getSelectedItem().toString());
            }
            if (paginar == true) {
                tablaListado.setModel(this.CONTROL.listar(texto, this.totalPorPagina, this.numPagina));
            } else {
                tablaListado.setModel(this.CONTROL.listar(texto, this.totalPorPagina, 1));
            }            

        TableRowSorter orden = new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);   
        this.ocultarColumnas();
        lblTotalRegistros.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total() + " registros");
    }
    
    
    private void ocultarColumnas() {
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        
        tablaListado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(3).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
    }
    
    private void crearDetalles(){

         modeloDetalles = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                }
                if (column == 4) {
                    return column == 4;
                }
                return column == 3;
            }

            @Override
             public Object getValueAt(int row, int column) {
                 
            
                if (column == 5) {
                    Double cantd;
                    try{
                        cantd = Double.parseDouble(String.valueOf(super.getValueAt(row, 3)));
                    } catch (Exception e) {
                        cantd = 1.0;
                    }               
                Double preciod = Double.parseDouble(String.valueOf(super.getValueAt(row, 4)));
                if(cantd  != null && preciod != null){
                    return String.format("%.2f", cantd * preciod);
            }else{
                    return 0.0;
                }
                }
                return super.getValueAt(row, column);
         }

            @Override
            public void setValueAt(Object aValue, int row, int column) {
              
             
                super.setValueAt(aValue, row, column);
            }
        };

           modeloDetalles.setColumnIdentifiers(new Object[]{"Id","Codigo","Articulo","Cantidad","Precio","Subtotal"});
            tablaDetalles.setModel(modeloDetalles);

    }

   private void calcularTotales(){

        double subtotal = 0;
        double impuesto = 0;
        double total = 0;

        for (int i = 0; i < tablaDetalles.getRowCount(); i++) {
            double valor = Double.parseDouble(String.valueOf(tablaDetalles.getValueAt(i, 5)));
            subtotal = subtotal + valor;
        }

        impuesto = subtotal * Double.parseDouble(txtImpuesto.getText());
        total = subtotal + impuesto;

        txtSubTotal.setText(String.format("%.2f", subtotal));
        txtTotalImpuesto.setText(String.format("%.2f", impuesto));
        txtTotal.setText(String.format("%.2f", total));

    }






    private void limpiar() {
       this.accion="guardar";
       
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
        btnDesactivar = new javax.swing.JButton();
        cboTotalPorPaginas = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboNumPagina = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        btnSeleccionarProveedor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboTipoComprobante = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtSerieComprobante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoBarra = new javax.swing.JTextField();
        btnVerArticulos = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtTotalImpuesto = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingresos Almacen");

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

        btnDesactivar.setText("Anular");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        cboTotalPorPaginas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "50", "100", "500" }));
        cboTotalPorPaginas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTotalPorPaginasActionPerformed(evt);
            }
        });

        jLabel11.setText("Num de paginas");

        jLabel12.setText("Total de registros");

        cboNumPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNumPaginaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboNumPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel12)
                                .addGap(55, 55, 55)
                                .addComponent(cboTotalPorPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(lblTotalRegistros)))))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboNumPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(cboTotalPorPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesactivar)
                    .addComponent(lblTotalRegistros))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        tabgeneral.addTab("Listado", jPanel1);

        jLabel2.setText("Proveedor(*)");

        jLabel4.setText("(*)Campos Obligatorios");

        txtIdProveedor.setEditable(false);

        txtNombreProveedor.setEditable(false);

        btnSeleccionarProveedor.setText("...");

        jLabel3.setText("Impuesto(*)");

        txtImpuesto.setText("0.18");

        jLabel5.setText("Tipo de Comprobante(*)");

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Ticket", "Guia" }));

        jLabel6.setText("Serie de Comprobante");

        jLabel7.setText("Num. de Comprobante");

        jLabel8.setText("Articulo");

        txtCodigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarraActionPerformed(evt);
            }
        });

        btnVerArticulos.setText("Ver Articulos");

        btnGuardar.setText("Guardar");
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

        tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDetalles);

        jLabel9.setText("Sub total");

        jLabel10.setText("Impuesto");

        jLabel13.setText("Total");

        txtSubTotal.setEditable(false);

        txtTotalImpuesto.setEditable(false);

        txtTotal.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(33, 33, 33)
                        .addComponent(txtCodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnVerArticulos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSerieComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnSeleccionarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel3)
                                .addGap(40, 40, 40)
                                .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 22, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumComprobante)))))
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(42, 42, 42)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(415, 415, 415)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTotalImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addComponent(txtSubTotal)))
                .addGap(196, 196, 196))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarProveedor)
                    .addComponent(jLabel3)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtSerieComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerArticulos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotalImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18))
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
       this.listar(txtBuscar.getText(),true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
          tabgeneral.setSelectedIndex(1);
        
         tabgeneral.setEnabledAt(1, true);
         tabgeneral.setEnabledAt(0, false);
            this.accion="guardar";

            btnGuardar.setText("Guardar");

    }//GEN-LAST:event_btnNuevoActionPerformed

    


    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
         if (tablaListado.getSelectedRowCount() == 1) {
                 String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
                 String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
                 if (JOptionPane.showConfirmDialog(this, "¿Deseas desactivar el registro: " + nombre + "?", "Desactivar", JOptionPane.YES_NO_OPTION) == 0) {
                      String resp = this.CONTROL.anular(Integer.parseInt(id));
                      if (resp.equals("OK")) {
                            this.mensajeOk("Registro desactivado");
                            this.listar("",false);
                      } else {
                            this.mensajeError(resp);
                      }
                 }
    
                } else {
                 this.mensajeError("Seleccione un registro para desactivar");
                }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void cboNumPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNumPaginaActionPerformed
     if (this.primeraCarga == false) {
            this.listar("",true);
        } else {
            this.primeraCarga = false;
        }        // TODO add your handling code here:

    }//GEN-LAST:event_cboNumPaginaActionPerformed

    private void cboTotalPorPaginasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTotalPorPaginasActionPerformed
        this.paginar();
    }//GEN-LAST:event_cboTotalPorPaginasActionPerformed

    private void txtCodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarraActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      

      
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
           tabgeneral.setSelectedIndex(0);
            tabgeneral.setEnabledAt(1, false);
            tabgeneral.setEnabledAt(0, true);
            this.limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

                                            



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSeleccionarProveedor;
    private javax.swing.JButton btnVerArticulos;
    private javax.swing.JComboBox<String> cboNumPagina;
    private javax.swing.JComboBox<String> cboTipoComprobante;
    private javax.swing.JComboBox<String> cboTotalPorPaginas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTabbedPane tabgeneral;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigoBarra;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNumComprobante;
    private javax.swing.JTextField txtSerieComprobante;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalImpuesto;
    // End of variables declaration//GEN-END:variables
}
