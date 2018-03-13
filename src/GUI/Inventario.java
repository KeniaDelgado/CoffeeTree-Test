
package GUI;

import controladores.Ingredientes;
import datos.Ingrediente;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import oraclegeneral.Conexion;


public class Inventario extends javax.swing.JFrame {
    int largo=0;
    DefaultTableModel cantidades_reg;
    private List<Ingrediente> cant_disp = new ArrayList<Ingrediente>();
   
    public Inventario() {
            setUndecorated(true);
            initComponents();
            this.setSize(488, 352);
            this.setLocationRelativeTo(null);
        //Cantidades disponibles de los ingredientes
        
        cantidades_reg = (DefaultTableModel)this.tableCant_Disp.getModel();
        List<Ingredientes> ing= new ArrayList<>();
        cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select * from Ingredientes", Ingrediente.class);
        largo = cant_disp.size();
        int l=0;
        for(int i=0;i<largo;i++){
        Ingrediente in = (Ingrediente) cant_disp.get(i);
            System.out.println("in.getCant_disp() = " + in.getCant_disp());
        int fila = cantidades_reg.getRowCount();
        if(Float.parseFloat(in.getCant_disp().toString())<1000){
        cantidades_reg.addRow(new Object[fila]);
        cantidades_reg.setValueAt(in.getIngrediente_id(),fila,0);
        cantidades_reg.setValueAt(in.getNombre(),fila,1);
        cantidades_reg.setValueAt(in.getCant_disp(),fila,2);
        }
        
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCant_Disp = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        txtCantRes = new javax.swing.JTextField();
        btnResurtir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tableCant_Disp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableCant_Disp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cant_disp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableCant_Disp.setRowHeight(25);
        tableCant_Disp.setSelectionBackground(new java.awt.Color(161, 212, 212));
        tableCant_Disp.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tableCant_Disp.setShowVerticalLines(false);
        tableCant_Disp.getTableHeader().setResizingAllowed(false);
        tableCant_Disp.getTableHeader().setReorderingAllowed(false);
        tableCant_Disp.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tableCant_Disp);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(32, 191, 433, 140);

        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras);
        btnAtras.setBounds(20, 30, 70, 40);

        txtCantRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantResActionPerformed(evt);
            }
        });
        txtCantRes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantResKeyTyped(evt);
            }
        });
        getContentPane().add(txtCantRes);
        txtCantRes.setBounds(110, 130, 154, 33);

        btnResurtir.setBorderPainted(false);
        btnResurtir.setContentAreaFilled(false);
        btnResurtir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResurtirActionPerformed(evt);
            }
        });
        getContentPane().add(btnResurtir);
        btnResurtir.setBounds(351, 93, 80, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -10, 490, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantResActionPerformed

    private void txtCantResKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantResKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
{
     Toolkit.getDefaultToolkit().beep();
     evt.consume();
 }
    }//GEN-LAST:event_txtCantResKeyTyped

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnResurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResurtirActionPerformed
        
        List<Ingrediente> ing_r = new ArrayList<>();
        int cont=0;
        float cant_r = 0;
        int slc_row = 0;
        String ide = "";
        try{
        cant_r = Float.parseFloat(txtCantRes.getText());
        }catch(Exception E){
            JOptionPane.showMessageDialog(rootPane, "No hay cantidad ingresada", "Advertencia", WARNING_MESSAGE);
        }
        int opc = JOptionPane.showConfirmDialog(null,"¿Seguro?","Alerta",JOptionPane.YES_NO_OPTION);
        if(opc == JOptionPane.YES_OPTION){
        try{
        slc_row = tableCant_Disp.getSelectedRow();
        ide = tableCant_Disp.getValueAt(slc_row, 0).toString();
        try{
            System.out.println("slc_row = " + slc_row);
        ing_r = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select cant_disp from ingredientes where ingrediente_id = " + ide, Ingrediente.class);
        Ingrediente i = (Ingrediente) ing_r.get(0);
        float sugerencia = 20000 - i.getCant_disp().floatValue();
        if(cant_r+(Float.parseFloat(i.getCant_disp().toString()))>20000){
            JOptionPane.showMessageDialog(rootPane, "Maximo se puede tener 20000 unidades por producto!\n"
                                                    +"Ingrese un cantidad menor o igual a : " + sugerencia);
        }else{
          Ingredientes.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp=cant_disp+%s,fecha_ped=(select to_date(sysdate,'dd/mm/yyyy')from dual) where ingrediente_id = " + ide,cant_r));
          }
         
        cantidades_reg = (DefaultTableModel)this.tableCant_Disp.getModel();
        int fil = cantidades_reg.getRowCount();
        for(int r = 0; r<fil;r++){
            cantidades_reg.removeRow(0);
            }
        List<Ingredientes> ing= new ArrayList<>();
        cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select * from Ingredientes", Ingrediente.class);;
        largo = cant_disp.size();
        int l=0;
        String[] array = new String[100]; 
        for(int z=0;z<largo;z++){
        Ingrediente in = (Ingrediente) cant_disp.get(z);
        int fila = cantidades_reg.getRowCount();
        if(Float.parseFloat(in.getCant_disp().toString())<1000){
        cantidades_reg.addRow(new Object[fila]);
        cantidades_reg.setValueAt(in.getIngrediente_id(),fila,0);
        cantidades_reg.setValueAt(in.getNombre(),fila,1);
        cantidades_reg.setValueAt(in.getCant_disp(),fila,2);
        cont++;
        }
        }
        if(cont==0){
            JOptionPane.showMessageDialog(rootPane, "Todo resurtido", "Woah", INFORMATION_MESSAGE);
        }
        }catch(Exception E){
            JOptionPane.showMessageDialog(rootPane, "Hubo error en la base de datos", "Advertencia", WARNING_MESSAGE);
        }
        }catch(Exception E){
            JOptionPane.showMessageDialog(rootPane, "Nada seleccionado", "Advertencia", WARNING_MESSAGE);
        }
        }else{
          JOptionPane.showMessageDialog(rootPane, "Ok", ":D", INFORMATION_MESSAGE);
        }
          
        
    }//GEN-LAST:event_btnResurtirActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnResurtir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCant_Disp;
    private javax.swing.JTextField txtCantRes;
    // End of variables declaration//GEN-END:variables
}
