package GUI;

import controladores.Ingredientes;
import controladores.Productos;
import controladores.Recetas;
import datos.Ingrediente;
import datos.Producto;
import datos.Receta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;
import oraclegeneral.Conexion;


public class Crepas extends javax.swing.JFrame {

    private List<Productos> prod = new ArrayList<Productos>();
    
    MenuInicio tabla = new MenuInicio(); 
    
    JFrame frame = new JFrame("Tamaño producto");
    public Crepas() {
         setUndecorated(true);
            initComponents();
            this.setSize(1086, 726);
            this.setLocationRelativeTo(null);
    }

    public Crepas(DefaultTableModel mod) {
            setUndecorated(true);
            initComponents();
            this.setSize(1086, 726);
            this.setLocationRelativeTo(null);
            tabla.mod = mod;
            
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        btnBloquear = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnSaladas_dos = new javax.swing.JButton();
        btnSaladas_uno = new javax.swing.JButton();
        btnDulce_uno = new javax.swing.JButton();
        btnDulce_dos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(490, 650, 210, 80);

        btnBloquear.setBorderPainted(false);
        btnBloquear.setContentAreaFilled(false);
        btnBloquear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloquearActionPerformed(evt);
            }
        });
        getContentPane().add(btnBloquear);
        btnBloquear.setBounds(250, 650, 210, 80);

        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras);
        btnAtras.setBounds(40, 20, 120, 80);

        btnSaladas_dos.setBorderPainted(false);
        btnSaladas_dos.setContentAreaFilled(false);
        btnSaladas_dos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaladas_dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaladas_dosActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaladas_dos);
        btnSaladas_dos.setBounds(370, 490, 300, 80);

        btnSaladas_uno.setBorderPainted(false);
        btnSaladas_uno.setContentAreaFilled(false);
        btnSaladas_uno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaladas_uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaladas_unoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaladas_uno);
        btnSaladas_uno.setBounds(370, 380, 300, 80);

        btnDulce_uno.setBorderPainted(false);
        btnDulce_uno.setContentAreaFilled(false);
        btnDulce_uno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDulce_uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDulce_unoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDulce_uno);
        btnDulce_uno.setBounds(50, 380, 300, 80);

        btnDulce_dos.setBorderPainted(false);
        btnDulce_dos.setContentAreaFilled(false);
        btnDulce_dos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDulce_dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDulce_dosActionPerformed(evt);
            }
        });
        getContentPane().add(btnDulce_dos);
        btnDulce_dos.setBounds(50, 490, 300, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/crepas.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1089, 725);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
        MenuInicio m = new MenuInicio(tabla.mod);
        m.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnDulce_unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDulce_unoActionPerformed
        prod = Productos.crepasUnDul();
        get(prod);
    }//GEN-LAST:event_btnDulce_unoActionPerformed

    private void btnSaladas_unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaladas_unoActionPerformed
        prod = Productos.crepasUnSal();
        get(prod);
    }//GEN-LAST:event_btnSaladas_unoActionPerformed

    private void btnSaladas_dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaladas_dosActionPerformed
        prod = Productos.crepasDosSal();
        get(prod);
    }//GEN-LAST:event_btnSaladas_dosActionPerformed

    private void btnDulce_dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDulce_dosActionPerformed
        prod = Productos.crepasDosDul();
        get(prod);          
    }//GEN-LAST:event_btnDulce_dosActionPerformed

    private void btnBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloquearActionPerformed
        int opc = JOptionPane.showConfirmDialog(null,"¿Seguro?","Alerta",JOptionPane.YES_NO_OPTION);
        if(opc == JOptionPane.YES_OPTION){
            this.setVisible(false);
            Inicio i = new Inicio();
            i.setVisible(true);
        }
        else if(opc == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Ok");
        }
    }//GEN-LAST:event_btnBloquearActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if(this.tabla.mod.getColumnCount()>0){
            int opc = JOptionPane.showConfirmDialog(null,"Aun hay una venta en proceso\n¿Seguro que quiere salir?","Alerta",JOptionPane.YES_NO_OPTION);
            if(opc == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(rootPane, "¡Hasta la proxima!", "Saliendo", INFORMATION_MESSAGE);
                System.exit(0);
            }
            else if(opc == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Ok");
            }
        }else{
            int opc = JOptionPane.showConfirmDialog(null,"¿Seguro que quiere salir?","Alerta",JOptionPane.YES_NO_OPTION);
            if(opc == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(rootPane, "¡Hasta la proxima!", "Saliendo", INFORMATION_MESSAGE);
                System.exit(0);
            }
            else if(opc == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Ok");
            }
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Crepas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crepas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crepas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crepas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crepas().setVisible(true);
            }
        });
    }

    public void get(List<Productos> prod){
        int cant = 0;
        int banSal=0;
        String val = "";
        Producto tam_prod = (Producto) JOptionPane.showInputDialog(frame, 
        "Tamaño",
        "Tamaño Producto",
        JOptionPane.QUESTION_MESSAGE, 
        null,
        prod.toArray(), prod.get(0)); 
        
        if(tam_prod == null){
        
        }else{
         boolean bandera=false;
          do{
          try{
          val = JOptionPane.showInputDialog("Cantidad"); 
          System.out.println("val = " + val);
          if(val == null){
              bandera=true;
          }else{
              
              if(Integer.parseInt(val)>0){
                cant = Integer.parseInt(val);
                List<Receta> rec = new ArrayList<>();
                List<Ingrediente> cantI = new ArrayList<>();
                rec= (List<Receta>) Recetas.select(Conexion.getDBConexion(), String.format("select ingrediente_id,cant from recetas where producto_id = %s",tam_prod.getProducto_id()), Receta.class);
                for(int up=0;up<rec.size();up++){  
                Receta cant_rec = (Receta) rec.get(up);
                System.out.println("cant_rec = " + cant_rec.getIngrediente_id() + cant_rec.getCant());
                cantI= (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), String.format("select cant_disp from ingredientes where ingrediente_id like '%s'",cant_rec.getIngrediente_id()), Ingrediente.class);
                
                Ingrediente cant_ing = (Ingrediente) cantI.get(0);
                System.out.println("cant_ing = " + cant_ing.getNombre());
                float cant_ingrediente = Float.parseFloat(cant_ing.getCant_disp().toString());
                float cant_receta = Float.parseFloat(cant_rec.getCant().toString());
                float cant_ingresada = cant;
                if(cant_ingrediente-(cant_receta*cant_ingresada)>0){
                cant = Integer.parseInt(val);
                bandera=true; 
                }else{
                val=null;
                if(banSal==0){
                JOptionPane.showMessageDialog(null,"No hay ingredientes suficientes");
                bandera=true;
                banSal++;
                } 
                }
                }  
                 bandera=true; 
              }else{
                JOptionPane.showMessageDialog(null,"Catidad no valida");
                bandera=false;
              }
          }
          }
          catch(NumberFormatException e){
          javax.swing.JOptionPane.showMessageDialog(null,"!!!!");
          bandera=false;
          }
          }while(!bandera);
  
        
        if(val == null){
           
        }else{
        int fila = tabla.mod.getRowCount();
        tabla.mod.addRow(new Object[fila]);
        for(int x = 0;x<this.tabla.mod.getColumnCount()-1;x++){
            tabla.mod.setValueAt(tam_prod.getProducto_id(),fila,0);
            tabla.mod.setValueAt(tam_prod.getNombre(),fila,1);
            tabla.mod.setValueAt(cant,fila,2);
            tabla.mod.setValueAt(tam_prod.getPrecio(),fila,3);
            tabla.mod.setValueAt(0,fila,4);
        }
        }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnDulce_dos;
    private javax.swing.JButton btnDulce_uno;
    private javax.swing.JButton btnSaladas_dos;
    private javax.swing.JButton btnSaladas_uno;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
