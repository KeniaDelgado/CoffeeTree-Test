
package GUI;

import controladores.Ingredientes;
import controladores.Productos;
import controladores.Recetas;
import datos.Ingrediente;
import datos.Producto;
import datos.Receta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oraclegeneral.Conexion;


public class Recetario extends javax.swing.JFrame {

    private List<Productos> prod = new ArrayList<Productos>();
    private List<Ingrediente> ingrediente = new ArrayList<Ingrediente>();
    private List<Receta> cant = new ArrayList<Receta>();
    private List<Ingrediente> med = new ArrayList<Ingrediente>();
    DefaultTableModel mod;
    DefaultTableModel cantidades_reg;

    public Recetario() {
        setUndecorated(true);
        initComponents();
        this.setSize(514, 261);
        this.setLocationRelativeTo(null);
        cargarProductos();

        int[] anchos = {300,50,50};
        for(int i = 0;i<tblRecetas.getColumnCount(); i++) {
        tblRecetas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lstProductos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecetas = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Producto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 40, 60, 14);

        lstProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstProductosActionPerformed(evt);
            }
        });
        getContentPane().add(lstProductos);
        lstProductos.setBounds(110, 40, 210, 20);

        jLabel2.setText("Receta");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 80, 60, 14);

        tblRecetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingrediente", "Cantidad", "Medida"
            }
        ));
        jScrollPane1.setViewportView(tblRecetas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 480, 150);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(360, 40, 71, 23);

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras);
        btnAtras.setBounds(0, 0, 59, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstProductosActionPerformed



    }//GEN-LAST:event_lstProductosActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        ingrediente = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select i.nombre from ingredientes i inner join recetas r"
                                                                         + " on r.ingrediente_id = i.ingrediente_id inner join productos p "
                                                                         + "on p.producto_id = r.producto_id where p.nombre like '"+ lstProductos.getSelectedItem().toString() +"'", Ingrediente.class);
        cant = (List<Receta>) Recetas.select(Conexion.getDBConexion(), "select r.cant from ingredientes i inner join recetas r"
                                                                         + " on r.ingrediente_id = i.ingrediente_id inner join productos p "
                                                                         + "on p.producto_id = r.producto_id where p.nombre like '"+ lstProductos.getSelectedItem().toString() +"'", Receta.class);
        med = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select i.medida from ingredientes i inner join recetas r"
                                                                         + " on r.ingrediente_id = i.ingrediente_id inner join productos p "
                                                                         + "on p.producto_id = r.producto_id where p.nombre like '"+ lstProductos.getSelectedItem().toString() +"'", Ingrediente.class);
        
        tblRecetas.setDefaultEditor(Object.class, null);
        cantidades_reg = (DefaultTableModel)this.tblRecetas.getModel();
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

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Recetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recetario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recetario().setVisible(true);
            }
        });
    }

    public void cargarProductos(){
        DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
        lstProductos.setModel(mdlCombo);
        prod = Productos.productosRecetas();
        for(int i=0;i<prod.size();i++){
            mdlCombo.addElement(prod.get(i));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstProductos;
    private javax.swing.JTable tblRecetas;
    // End of variables declaration//GEN-END:variables
}
