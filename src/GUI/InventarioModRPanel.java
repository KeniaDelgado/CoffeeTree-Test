
package GUI;

import java.awt.EventQueue;
import java.beans.Beans;
import javax.swing.JFrame;
import javax.swing.JPanel;
//
import controladores.Ingredientes;
import controladores.Productos;
import controladores.Recetas;
import datos.Ingrediente;
import datos.Producto;
import datos.Receta;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oraclegeneral.Conexion;

/**
 *
 * @author Hector
 */
public class InventarioModRPanel extends JPanel {
    
    
    private List<Productos> prod = new ArrayList<Productos>();
    private List<Producto> prodd = new ArrayList<Producto>();
    private List<Ingrediente> ingrediente = new ArrayList<Ingrediente>();
    private List<Ingrediente> ing = new ArrayList<Ingrediente>();
    private List<Receta> cant = new ArrayList<Receta>();
    
     private List<Ingrediente> med = new ArrayList<Ingrediente>();
    DefaultTableModel mod;
    DefaultTableModel cantidades_reg;
    
    
    public InventarioModRPanel() {
        initComponents();
        cargarProductos();
        cargarIngredientes();
        Medidas();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        int[] anchos = {300,50,50};
        for(int i = 0;i<tblRecetas.getColumnCount(); i++) {
        tblRecetas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        newButton.setEnabled(false);
        deleteButton.setEnabled(false);
        btnCancelar.setEnabled(false);
        refreshButton.setEnabled(false);
        saveButton.setEnabled(false); 
        //txtCant.setEnabled(false);
        
        

txtCant.addKeyListener(new KeyAdapter() {

@Override
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_DELETE)&& (c != '.')) {
e.consume();
}
if (c == '.' && txtCant.getText().contains(".")) {
e.consume();
}
}
});
tblRecetas.setDefaultEditor(Object.class, null);
cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();
tblRecetas.addMouseListener(new MouseAdapter() {

    
public void mouseClicked(MouseEvent evento) { 
int fil = tblRecetas.getSelectedRow();
String in = tblRecetas.getValueAt(fil, 0).toString();
String m = tblRecetas.getValueAt(fil, 2).toString();
if(btnCancelar.isEnabled()){

}else{
for(int i=0;i<lstIngredientes.getItemCount();i++){
        lstIngredientes.setSelectedIndex(i);
        if(in.equals(lstIngredientes.getSelectedItem().toString())){
        lstIngredientes.setSelectedIndex(i);
        i=lstIngredientes.getItemCount();
        }
    
    }
for(int i=0;i<ltsMedidas.getItemCount();i++){
        ltsMedidas.setSelectedIndex(i);
        if(m.equals(ltsMedidas.getSelectedItem().toString())){
        ltsMedidas.setSelectedIndex(i);
        i=ltsMedidas.getItemCount();
        }
    
    }
    lstIngredientes.setEnabled(false);
    deleteButton.setEnabled(true);
    txtCant.setEnabled(true);
    newButton.setEnabled(true);
    txtCant.setText(tblRecetas.getValueAt(tblRecetas.getSelectedRow(),1).toString());
}
}

});
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@localhost:1521:XEPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Ingredientes i");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        nombreLabel = new javax.swing.JLabel();
        cantDispLabel = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lstProductos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecetas = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        lstIngredientes = new javax.swing.JComboBox<>();
        ltsMedidas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnCambios = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setLayout(null);

        saveButton.setText("Guardar nuevo");
        saveButton.addActionListener(formListener);
        add(saveButton);
        saveButton.setBounds(400, 280, 120, 20);

        refreshButton.setText("Update");
        refreshButton.addActionListener(formListener);
        add(refreshButton);
        refreshButton.setBounds(320, 290, 71, 23);

        newButton.setText("Nuevo");
        newButton.addActionListener(formListener);
        add(newButton);
        newButton.setBounds(60, 290, 71, 23);

        deleteButton.setText("Borrar");
        deleteButton.addActionListener(formListener);
        add(deleteButton);
        deleteButton.setBounds(140, 290, 71, 23);

        nombreLabel.setText("Ingrediente:");
        add(nombreLabel);
        nombreLabel.setBounds(50, 250, 60, 14);

        cantDispLabel.setText("Cantidad:");
        add(cantDispLabel);
        cantDispLabel.setBounds(340, 230, 47, 14);

        txtCant.addActionListener(formListener);
        txtCant.addKeyListener(formListener);
        add(txtCant);
        txtCant.setBounds(340, 250, 60, 20);

        jLabel1.setText("Producto");
        add(jLabel1);
        jLabel1.setBounds(80, 10, 60, 14);

        lstProductos.addActionListener(formListener);
        add(lstProductos);
        lstProductos.setBounds(150, 10, 210, 20);

        jLabel2.setText("Receta");
        add(jLabel2);
        jLabel2.setBounds(50, 50, 60, 14);

        tblRecetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingrediente", "Cantidad", "Medida"
            }
        ));
        jScrollPane1.setViewportView(tblRecetas);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 70, 460, 150);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(formListener);
        add(btnAceptar);
        btnAceptar.setBounds(390, 10, 71, 23);

        lstIngredientes.addActionListener(formListener);
        add(lstIngredientes);
        lstIngredientes.setBounds(120, 250, 210, 20);

        ltsMedidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(ltsMedidas);
        ltsMedidas.setBounds(410, 250, 56, 20);

        jLabel3.setText("Medida:");
        add(jLabel3);
        jLabel3.setBounds(410, 230, 40, 14);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(formListener);
        add(btnCancelar);
        btnCancelar.setBounds(220, 290, 90, 23);

        btnCambios.setText("Guardar Cambios");
        btnCambios.addActionListener(formListener);
        add(btnCambios);
        btnCambios.setBounds(400, 310, 120, 20);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                InventarioModRPanel.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                InventarioModRPanel.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                InventarioModRPanel.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                InventarioModRPanel.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == txtCant) {
                InventarioModRPanel.this.txtCantActionPerformed(evt);
            }
            else if (evt.getSource() == lstProductos) {
                InventarioModRPanel.this.lstProductosActionPerformed(evt);
            }
            else if (evt.getSource() == btnAceptar) {
                InventarioModRPanel.this.btnAceptarActionPerformed(evt);
            }
            else if (evt.getSource() == lstIngredientes) {
                InventarioModRPanel.this.lstIngredientesActionPerformed(evt);
            }
            else if (evt.getSource() == btnCancelar) {
                InventarioModRPanel.this.btnCancelarActionPerformed(evt);
            }
            else if (evt.getSource() == btnCambios) {
                InventarioModRPanel.this.btnCambiosActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == txtCant) {
                InventarioModRPanel.this.txtCantKeyPressed(evt);
            }
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == txtCant) {
                InventarioModRPanel.this.txtCantKeyTyped(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        lstProductos.setEnabled(true);
        newButton.setEnabled(true);
        deleteButton.setEnabled(true);
        btnCancelar.setEnabled(false);
        refreshButton.setEnabled(false);
        saveButton.setEnabled(true); 
        tblRecetas.setDefaultEditor(Object.class, null);
        cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();       
                    
        
              
                String selected = lstProductos.getSelectedItem().toString();
                System.out.println("Lols");

                prodd = (List<Producto>) Productos.select(Conexion.getDBConexion(), "select producto_id from productos where nombre like '" + selected + "'", Producto.class);
                System.out.println("Producto seleccionado: " + prodd.get(0).getProducto_id());
                Producto por = (Producto) prodd.get(0);
                System.out.println("Antes del delete");
                // DELETE
                Recetas.executeQuery(Conexion.getDBConexion(), String.format("delete from recetas where producto_id = %s",prodd.get(0).getProducto_id()));            
                cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();
                // Eliminar todo lo del producto
                //Ingredientes del producto
               
                   for(int i=0;i<cantidades_reg.getRowCount();i++){
                System.out.println("Row count: " + cantidades_reg.getRowCount()); 
                String ingT = cantidades_reg.getValueAt(i, 0).toString();
                String cantT = cantidades_reg.getValueAt(i, 1).toString();
                ing = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select ingrediente_id from ingredientes where nombre like '" + ingT + "'", Ingrediente.class);
                Ingrediente in = (Ingrediente) ing.get(0);
                //inserts de tablasy
                    System.out.println("producto_id:" + por.getProducto_id());
                    System.out.println("ingrediente_id:" + in.getIngrediente_id());
                    System.out.println("cantidad" + cantT);
                Recetas.executeQuery(Conexion.getDBConexion(), String.format("insert into recetas(producto_id, ingrediente_id, cant) values(%s,%s,%s)",prodd.get(0).getProducto_id(),in.getIngrediente_id(),cantT));
                   
                   }
                   JOptionPane.showConfirmDialog(null,"listo","Alerta",JOptionPane.YES_NO_OPTION);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        refreshButton.setEnabled(true);
        tblRecetas.setDefaultEditor(Object.class, null);
        cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();
        
        int opc = JOptionPane.showConfirmDialog(null,"¿Seguro?","Alerta",JOptionPane.YES_NO_OPTION);
        if(opc == JOptionPane.YES_OPTION){
        if((this.cantidades_reg.getRowCount()!=0)&&(this.tblRecetas.getSelectedRowCount() > 0)){
        cantidades_reg.removeRow(this.tblRecetas.getSelectedRow());
        txtCant.setText("");
        txtCant.setEnabled(false);
       }else{
       JOptionPane.showMessageDialog(null,"¡¡No hay nada seleccionado!!");
       }
        cantidades_reg.fireTableDataChanged();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        lstIngredientes.setEnabled(true);
        newButton.setEnabled(false);
        deleteButton.setEnabled(false);
        btnCancelar.setEnabled(true);
        refreshButton.setEnabled(false);
        saveButton.setEnabled(true);
        tblRecetas.setDefaultEditor(Object.class, null);
        cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();
        int filas = tblRecetas.getRowCount();
        cantidades_reg.addRow(new Object[filas]);
        
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Aqui nomas debo validar que este habilitado el boton de cancelar y no haya vacios o ceros
        
        
        if(btnCancelar.isEnabled())
        {
            if(txtCant.getText().isEmpty()!=true)
            {
                if(Float.parseFloat(txtCant.getText())>0)
                {
                    
                    int fila = cantidades_reg.getRowCount()-1;
                    int bandera = 0;
                    tblRecetas.setDefaultEditor(Object.class, null);
                    cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();       
                    String in = lstIngredientes.getSelectedItem().toString();

                     //Ciclo para revisar que no se repitan cosillas
                    for(int i=0;i<cantidades_reg.getRowCount()-1;i++){
                    cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();

                    if((cantidades_reg.getValueAt(i, 0).toString().equals(in) && btnCancelar.isEnabled())){
                        JOptionPane.showMessageDialog(null,"¡¡El ingrediente ya esta!!\n Cancela y selecciona para modificar");
                        i=cantidades_reg.getRowCount();
                        bandera = 1;
                        System.out.println("bandera a:" + bandera);
                    }
                    }
                    if(bandera!=1){
                    String selIng = lstIngredientes.getSelectedItem().toString();
                    cantidades_reg.setValueAt(selIng, fila, 0);
                    String[] medidas = {"lb","fl.oz.","oz","gal","ml","gr","kg","lt"};
                    //Por unidad de medida a la tabla
                    double conv=0;
                    conversion(conv,ltsMedidas.getSelectedItem().toString(),cantidades_reg.getRowCount()-1);
                    refreshButton.setEnabled(true);
                    newButton.setEnabled(true);
                    btnCancelar.setEnabled(false);
                    txtCant.setEnabled(true);
                    }
                   
                }else
                {
                JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor a 0");
                }
            }else
            {
            JOptionPane.showMessageDialog(null,"Cantidad esta vacío");
            }
                         
            
        }else{
        
            JOptionPane.showMessageDialog(null,"Agregue un nuevo ingrediente");
                
        }
        
        
        
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void lstProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstProductosActionPerformed

    }//GEN-LAST:event_lstProductosActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Habilitar botones de nuevo y guardar nadamas
        tblRecetas.setDefaultEditor(Object.class, null);
        cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();
        newButton.setEnabled(true);
        deleteButton.setEnabled(false);
        btnCancelar.setEnabled(false);
        refreshButton.setEnabled(false);
        saveButton.setEnabled(true);
        ingrediente = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select i.nombre from ingredientes i inner join recetas r"
                                                                         + " on r.ingrediente_id = i.ingrediente_id inner join productos p "
                                                                         + "on p.producto_id = r.producto_id where p.nombre like '"+ lstProductos.getSelectedItem().toString() +"'", Ingrediente.class);
        cant = (List<Receta>) Recetas.select(Conexion.getDBConexion(), "select r.cant from ingredientes i inner join recetas r"
                                                                         + " on r.ingrediente_id = i.ingrediente_id inner join productos p "
                                                                         + "on p.producto_id = r.producto_id where p.nombre like '"+ lstProductos.getSelectedItem().toString() +"'", Receta.class);
        med = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select i.medida from ingredientes i inner join recetas r"
                                                                         + " on r.ingrediente_id = i.ingrediente_id inner join productos p "
                                                                         + "on p.producto_id = r.producto_id where p.nombre like '"+ lstProductos.getSelectedItem().toString() +"'", Ingrediente.class);
        
        
        int largoI = ingrediente.size();
        int largoC = cant.size();
        int largoM = med.size();
        //Lipia la tabla
        int filas = tblRecetas.getRowCount();
        for(int l=0;l<filas;l++){
        cantidades_reg.removeRow(0);
        }
        for(int l=0;l<largoI;l++){
             Ingrediente in = (Ingrediente) ingrediente.get(l);
             cantidades_reg.addRow(new Object[l]);
             cantidades_reg.setValueAt(in.getNombre(),l,0);
          }
        for(int l=0;l<largoC;l++){
             Receta in = (Receta) cant.get(l);
             cantidades_reg.setValueAt(in.getCant(),l,1);
          }
        for(int l=0;l<largoM;l++){
             Ingrediente in = (Ingrediente) med.get(l);
             cantidades_reg.setValueAt(in.getMedida(),l,2);
          }
        

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void lstIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstIngredientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lstIngredientesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        newButton.setEnabled(true);
        deleteButton.setEnabled(true);
        btnCancelar.setEnabled(false);
        refreshButton.setEnabled(false);
        saveButton.setEnabled(true);
        tblRecetas.setDefaultEditor(Object.class, null);
        cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();
        int filas = cantidades_reg.getRowCount();
        cantidades_reg.removeRow(filas-1);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)&& (caracter !='.')){
         /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
    }
        evt.consume();

    }//GEN-LAST:event_txtCantKeyPressed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        
    }//GEN-LAST:event_txtCantActionPerformed

    private void txtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyTyped
            
    char c = evt.getKeyChar();
if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
&& (c != '.')) {
evt.consume();
}
if (c == '.' && txtCant.getText().contains(".")) {
evt.consume();
   }

    }//GEN-LAST:event_txtCantKeyTyped

    private void btnCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiosActionPerformed
        if(btnCancelar.isEnabled()!=true){ 
        if(txtCant.getText().isEmpty()!=true)
            {
                if(Float.parseFloat(txtCant.getText())>0)
                {
                    
                    refreshButton.setEnabled(true);
                    tblRecetas.setDefaultEditor(Object.class, null);
                    cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();       
                    String in = lstIngredientes.getSelectedItem().toString();

                    String selIng = lstIngredientes.getSelectedItem().toString();
                    cantidades_reg.setValueAt(selIng, tblRecetas.getSelectedRow(), 0);
                    String[] medidas = {"lb","fl.oz.","oz","gal","ml","g","kg","lt"};
                    //Por unidad de medida a la tabla
                    double conv=0;
                    int filas = 0;
                    for(int i=0;i<cantidades_reg.getRowCount();i++){
                        if(in.equals(cantidades_reg.getValueAt(i, 0))){
                            filas = tblRecetas.getSelectedRow();
                            System.out.println("fila seleccionmada : " + filas);
                        }
                    }
                    conversion(conv,ltsMedidas.getSelectedItem().toString(),filas);
                    
                
                }else
                {
                JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor a 0");
                }
            }else
            {
            JOptionPane.showMessageDialog(null,"Cantidad esta vacío");
            }
        
        }else{
        JOptionPane.showMessageDialog(null,"Nada seleccionado");
        } 
    }//GEN-LAST:event_btnCambiosActionPerformed

    public void cargarIngredientes(){
        DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
        lstIngredientes.setModel(mdlCombo);
        ing = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select nombre from ingredientes", Ingrediente.class);
        
        for(int i=0;i<ing.size();i++){
            
            Ingrediente in = (Ingrediente) ing.get(i);
            mdlCombo.addElement(in.getNombre());
        }
    }
    public void cargarProductos(){
        DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
        lstProductos.setModel(mdlCombo);
        prod = Productos.productosRecetas();
        for(int i=0;i<prod.size();i++){
            mdlCombo.addElement(prod.get(i));
        }
    }
    public void Medidas(){
        DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
        ltsMedidas.setModel(mdlCombo);
        String[] medidas = {"lb","fl.oz.","oz","gal","ml","g","kg","lt"};
        for(int i = 0;i<medidas.length; i++) {
        mdlCombo.addElement(medidas[i]);
        }
    }
    public void sel(){
        
    }
    
    public void conversion(double conv,String st,int filas){
    switch(st) {
            case "lb":
            conv = Float.parseFloat(txtCant.getText())*453.592;
            cantidades_reg.setValueAt(conv,filas,1);
            cantidades_reg.setValueAt("g",filas,2);
                break;
            case "fl.oz.":
            conv = Float.parseFloat(txtCant.getText())*29.5735;
            cantidades_reg.setValueAt(conv,filas,1);
            cantidades_reg.setValueAt("ml",filas,2);
                break;
            case "oz":
            conv = Float.parseFloat(txtCant.getText())*29.5735;
            cantidades_reg.setValueAt(conv,filas,1);
            cantidades_reg.setValueAt("ml",filas,2);
                break;
            case "gal":
            conv = Float.parseFloat(txtCant.getText())*3785.41;
            cantidades_reg.setValueAt(conv,filas,1);
            cantidades_reg.setValueAt("ml",filas,2);
                break;
            case "ml":
            cantidades_reg.setValueAt(Float.parseFloat(txtCant.getText()),filas,1);
            cantidades_reg.setValueAt("ml",filas,2);    
                break;
            case "g":
            cantidades_reg.setValueAt(Float.parseFloat(txtCant.getText()),filas,1);
            cantidades_reg.setValueAt("g",filas,2);
                break;
            case "kg":
            conv = Float.parseFloat(txtCant.getText())*1000;
            cantidades_reg.setValueAt(conv,filas,1);
            cantidades_reg.setValueAt("g",filas,2);
                break;
            case "lt":
            conv = Float.parseFloat(txtCant.getText())*1000;
            cantidades_reg.setValueAt(conv,filas,1);
            cantidades_reg.setValueAt("ml",filas,2);
                break;
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCambios;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel cantDispLabel;
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<GUI.Ingredientes> list;
    private javax.swing.JComboBox<String> lstIngredientes;
    private javax.swing.JComboBox<String> lstProductos;
    private javax.swing.JComboBox<String> ltsMedidas;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel nombreLabel;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable tblRecetas;
    private javax.swing.JTextField txtCant;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventarioModRPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioModRPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioModRPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioModRPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new InventarioModRPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
