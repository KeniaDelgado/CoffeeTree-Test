
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


public class BebidasCalientes extends javax.swing.JFrame {

    private List<Productos> prod = new ArrayList<Productos>();
    DefaultTableModel mod;
    MenuInicio tabla = new MenuInicio(); 
    JFrame frame = new JFrame("Tamaño producto");
    
    public BebidasCalientes() {
            setUndecorated(true);
            initComponents();
            this.setSize(1086, 726);
            this.setLocationRelativeTo(null);
            
            
    }
    
     public BebidasCalientes(DefaultTableModel mod) {
            setUndecorated(true);
            initComponents();
            this.setSize(1086, 726);
            this.setLocationRelativeTo(null);
            tabla.mod = mod;
            System.out.println("mod.getRowCount() = " + mod.getRowCount());
            
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        btnBloquear = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnChocolate = new javax.swing.JButton();
        btnMoka = new javax.swing.JButton();
        btnChocolateB = new javax.swing.JButton();
        btnMokaBlanco = new javax.swing.JButton();
        btnLatte = new javax.swing.JButton();
        btnExpresso = new javax.swing.JButton();
        btnTe = new javax.swing.JButton();
        btnCappuccino = new javax.swing.JButton();
        btnCafeAm = new javax.swing.JButton();
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

        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar);
        btnRegresar.setBounds(40, 20, 120, 80);

        btnChocolate.setBorderPainted(false);
        btnChocolate.setContentAreaFilled(false);
        btnChocolate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChocolate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChocolateActionPerformed(evt);
            }
        });
        getContentPane().add(btnChocolate);
        btnChocolate.setBounds(38, 502, 206, 120);

        btnMoka.setBorderPainted(false);
        btnMoka.setContentAreaFilled(false);
        btnMoka.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMokaActionPerformed(evt);
            }
        });
        getContentPane().add(btnMoka);
        btnMoka.setBounds(38, 380, 206, 120);

        btnChocolateB.setBorderPainted(false);
        btnChocolateB.setContentAreaFilled(false);
        btnChocolateB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChocolateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChocolateBActionPerformed(evt);
            }
        });
        getContentPane().add(btnChocolateB);
        btnChocolateB.setBounds(247, 502, 206, 118);

        btnMokaBlanco.setBorderPainted(false);
        btnMokaBlanco.setContentAreaFilled(false);
        btnMokaBlanco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMokaBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMokaBlancoActionPerformed(evt);
            }
        });
        getContentPane().add(btnMokaBlanco);
        btnMokaBlanco.setBounds(247, 380, 206, 118);

        btnLatte.setBorderPainted(false);
        btnLatte.setContentAreaFilled(false);
        btnLatte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLatteActionPerformed(evt);
            }
        });
        getContentPane().add(btnLatte);
        btnLatte.setBounds(247, 260, 206, 120);

        btnExpresso.setBorderPainted(false);
        btnExpresso.setContentAreaFilled(false);
        btnExpresso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpressoActionPerformed(evt);
            }
        });
        getContentPane().add(btnExpresso);
        btnExpresso.setBounds(458, 502, 208, 120);

        btnTe.setBorderPainted(false);
        btnTe.setContentAreaFilled(false);
        btnTe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeActionPerformed(evt);
            }
        });
        getContentPane().add(btnTe);
        btnTe.setBounds(458, 380, 208, 120);

        btnCappuccino.setBorderPainted(false);
        btnCappuccino.setContentAreaFilled(false);
        btnCappuccino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCappuccino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCappuccinoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCappuccino);
        btnCappuccino.setBounds(458, 260, 208, 120);

        btnCafeAm.setBorderPainted(false);
        btnCafeAm.setContentAreaFilled(false);
        btnCafeAm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCafeAm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafeAmActionPerformed(evt);
            }
        });
        getContentPane().add(btnCafeAm);
        btnCafeAm.setBounds(38, 260, 206, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bebidas_calientes.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1089, 726);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        MenuInicio m = new MenuInicio(tabla.mod);
        m.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCafeAmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafeAmActionPerformed
        prod = Productos.productosMostrar("Americano");
        get(prod);
    }//GEN-LAST:event_btnCafeAmActionPerformed

    private void btnLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLatteActionPerformed
        prod = Productos.productosMostrarNo("Latte","Latte frio");
        get(prod);
    }//GEN-LAST:event_btnLatteActionPerformed

    private void btnCappuccinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCappuccinoActionPerformed
        prod = Productos.productosMostrar("Capuccino");
        get(prod);
    }//GEN-LAST:event_btnCappuccinoActionPerformed

    private void btnMokaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMokaActionPerformed
        prod = Productos.productosMostrarNo("Moka","Moka blanco");
        get(prod);
    }//GEN-LAST:event_btnMokaActionPerformed

    private void btnMokaBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMokaBlancoActionPerformed
        prod = Productos.productosMostrar("Moka blanco");
        get(prod);
    }//GEN-LAST:event_btnMokaBlancoActionPerformed

    private void btnTeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeActionPerformed
        prod = Productos.productosMostrarNo("Te chai","Te chai helado");
        get(prod);
    }//GEN-LAST:event_btnTeActionPerformed

    private void btnChocolateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChocolateActionPerformed
        prod = Productos.productosMostrarNo("Chocolate","Chocolate blanco");
        get(prod);
    }//GEN-LAST:event_btnChocolateActionPerformed

    private void btnChocolateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChocolateBActionPerformed
        prod = Productos.productosMostrar("Chocolate blanco");
        get(prod);
    }//GEN-LAST:event_btnChocolateBActionPerformed

    private void btnExpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpressoActionPerformed
        prod = Productos.productosMostrar("Expresso");
        get(prod);
    }//GEN-LAST:event_btnExpressoActionPerformed

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
            java.util.logging.Logger.getLogger(BebidasCalientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BebidasCalientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BebidasCalientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BebidasCalientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BebidasCalientes().setVisible(true);
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
    };    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnCafeAm;
    private javax.swing.JButton btnCappuccino;
    private javax.swing.JButton btnChocolate;
    private javax.swing.JButton btnChocolateB;
    private javax.swing.JButton btnExpresso;
    private javax.swing.JButton btnLatte;
    private javax.swing.JButton btnMoka;
    private javax.swing.JButton btnMokaBlanco;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTe;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
