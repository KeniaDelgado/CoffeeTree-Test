package GUI;

import controladores.Recetas;
import controladores.Ventas;
import datos.Producto;
import datos.Receta;
import datos.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import oraclegeneral.Conexion;

public class PagoAdmin extends javax.swing.JFrame {
    float total=0;
    int z=0;
    int banderaE = 0;
    int banderaC = 0;
    int banderaCom = 0;
    DefaultTableModel mod;
    DefaultTableModel cant;
    MenuInicioAdmin tabla = new MenuInicioAdmin() ; 
    private final static String id = "ventas_seq.nextval";
    private static List<Producto> productos = new ArrayList<Producto>();
    private static String fechaEntrega;
    
    public PagoAdmin() {
        setUndecorated(true);
            initComponents();
            this.setSize(1086, 726);
            this.setLocationRelativeTo(null);
         mod = (DefaultTableModel)this.model.getModel();
         cant = (DefaultTableModel)this.tableCant_Disp.getModel();
    }
    
     public PagoAdmin(DefaultTableModel mod,DefaultTableModel cant) {
            setUndecorated(true);
            initComponents();
            this.setSize(1086, 726);
            this.setLocationRelativeTo(null);
            this.mod = mod;
            this.model.setModel(mod);
            this.cant = cant;
            this.tableCant_Disp.setModel(cant);
            System.out.println("mod.getRowCount() = " + mod.getRowCount());
            mod = (DefaultTableModel)this.model.getModel();
            if(mod.getRowCount()!=0){
           System.out.println(String.valueOf(mod.getValueAt(z,2)));
           for(z = 0;z<=mod.getRowCount()-1;z++){
           mod.setValueAt((Float.parseFloat(String.valueOf(mod.getValueAt(z,2)))*(Float.parseFloat(String.valueOf(mod.getValueAt(z,3))))), z , 4);
           total = Float.parseFloat(String.valueOf(mod.getValueAt(z,4))) + total;
        }
        }
        lblTotal.setText(String.valueOf(total));    
        lblTotalFinal.setText(String.valueOf(total));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCant_Disp = new javax.swing.JTable();
        btnBloquear = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnRegistroVenta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        model = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        lblTotalFinal = new javax.swing.JLabel();
        btnCredito = new javax.swing.JButton();
        btnEfectivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblMetodoPago = new javax.swing.JLabel();

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

        tableCant_Disp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cant_disp"
            }
        ));
        jScrollPane2.setViewportView(tableCant_Disp);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(-110, 700, 140, 402);

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

        btnRegistroVenta.setBorderPainted(false);
        btnRegistroVenta.setContentAreaFilled(false);
        btnRegistroVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistroVenta);
        btnRegistroVenta.setBounds(700, 570, 190, 150);

        jPanel1.setOpaque(false);

        model.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Cant", "S", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        model.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        model.setShowVerticalLines(false);
        jScrollPane1.setViewportView(model);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(706, 208, 380, 356);

        lblTotal.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");
        getContentPane().add(lblTotal);
        lblTotal.setBounds(930, 635, 140, 50);

        lbl.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setText("$");
        getContentPane().add(lbl);
        lbl.setBounds(900, 640, 30, 40);

        lblTotalFinal.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTotalFinal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalFinal.setText("0");
        getContentPane().add(lblTotalFinal);
        lblTotalFinal.setBounds(430, 460, 160, 70);

        btnCredito.setBorderPainted(false);
        btnCredito.setContentAreaFilled(false);
        btnCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCredito);
        btnCredito.setBounds(180, 330, 440, 100);

        btnEfectivo.setBorderPainted(false);
        btnEfectivo.setContentAreaFilled(false);
        btnEfectivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEfectivo);
        btnEfectivo.setBounds(180, 160, 440, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/metodo_pago.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1089, 725);

        lblMetodoPago.setText("jLabel2");
        getContentPane().add(lblMetodoPago);
        lblMetodoPago.setBounds(370, 580, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
     
        if(lblTotal.getText().equals("0")){
        this.setVisible(false);
        MenuInicioAdmin m = new MenuInicioAdmin();
        m.setVisible(true);
        }else{
        if((Float.parseFloat(lblTotalFinal.getText().toString())<Float.parseFloat(lblTotal.getText()))&&(Float.parseFloat(lblTotal.getText().toString())!=0)){
            JOptionPane.showMessageDialog(null,"Hay una venta en proceso, volver ahora ya no es posible hasta que se termine");
        }else{
        this.setVisible(false);
        MenuInicioAdmin m = new MenuInicioAdmin(mod,cant);
        m.setVisible(true);
        }
        
        }
        
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed

        if(Float.parseFloat(lblTotalFinal.getText())<=0){
        
        }else{
        banderaCom++;
        float total=0,totalFinal=0;
        banderaE++;
        totalFinal = Float.parseFloat(lblTotalFinal.getText());
        String val;
        boolean bandera=false;
          do{
          try{
          val = JOptionPane.showInputDialog("Cantidad otorgada");
          if(val == null){
              bandera=true;
          }else{
              if(Integer.parseInt(val)>0){
                total = Float.parseFloat(val);
                if(total > totalFinal){
                    total = totalFinal - total;
                    lblTotalFinal.setText(String.valueOf(total));
                    if(total<0){
                    total = total*-1;
                    }
                    JOptionPane.showMessageDialog(null,"Cambio = " + total);
                }else{
                    if(total<=totalFinal){
                    totalFinal = totalFinal-total;
                    lblTotalFinal.setText(String.valueOf(totalFinal));
                    }
                }
                bandera=true; 
              }else{
                JOptionPane.showMessageDialog(null,"Catidad no valida");
                bandera=false;
              }
          }
          }catch(NumberFormatException e){
          javax.swing.JOptionPane.showMessageDialog(null,"Solo se permiten numeros positivos");
          bandera=false;
          }
          }while(!bandera);
          
          
        if(total > Float.parseFloat(lblTotal.getText())){
        total = total -  totalFinal;
        lblTotal.setText(String.valueOf(total));
        JOptionPane.showMessageDialog(null,"Cambio = " + total);
        }else{
        
        } 
        
        }
        
    }//GEN-LAST:event_btnEfectivoActionPerformed

    private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed
        if(Float.parseFloat(lblTotalFinal.getText())<=0){
        
        }else{
        banderaCom++;
        float total=0,totalFinal=0;
        totalFinal = Float.parseFloat(lblTotalFinal.getText());
        String val;
        boolean bandera=false;
          do{
          try{
          val = JOptionPane.showInputDialog("Cantidad a cubrir");
          if(val == null){
              bandera=true;
          }else{
              if(Float.parseFloat(val)>0){
                total = Float.parseFloat(val);
                if(total == totalFinal){
                    banderaC++;
                    totalFinal = totalFinal - total;
                    lblTotalFinal.setText(String.valueOf(totalFinal));
                    bandera=true;
                }else{
                    if(total < totalFinal){
                    banderaC++;
                    totalFinal = totalFinal - total;
                    lblTotalFinal.setText(String.valueOf(totalFinal));
                    JOptionPane.showMessageDialog(null,"Falta = " + totalFinal);
                    bandera=true;
                }else{
                 if(total > totalFinal){
                JOptionPane.showMessageDialog(null,"¡No es necesario pagar tanto!");
                bandera=false;
                }   
                    }
                }
                 
              }else{
                JOptionPane.showMessageDialog(null,"Catidad no valida");
                bandera=false;
              }
          }
          }catch(NumberFormatException e){
          javax.swing.JOptionPane.showMessageDialog(null,"Solo se permiten numeros positivos");
          bandera=false;
          }
          }while(!bandera);
          
        }
        
    }//GEN-LAST:event_btnCreditoActionPerformed

    private void btnRegistroVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroVentaActionPerformed
        banderaCom=0;
        if(((Float.parseFloat(lblTotalFinal.getText())==0)&&(Float.parseFloat(lblTotal.getText()))==0)){
        JOptionPane.showMessageDialog(null,"¡Pago ya fue realizado!");
        }else{
        
        
        if((Float.parseFloat(lblTotalFinal.getText())<=0)&&(Float.parseFloat(lblTotal.getText()))>0){
           //Definir el metodo de pago
           String metod="";
           if((banderaE>0)&&(banderaC==0)){
            metod="EFEC";
           }else{
            if((banderaC>0)&&(banderaE==0)){
            metod="CRED";
           }else{
                metod="MIXT";
           }
           }
           
            List<Venta> ventas= new ArrayList<>();
            List<Receta> upd = new ArrayList<>();
            List<Receta> ide = new ArrayList<>();
            total = Float.parseFloat(lblTotal.getText());
            ventas= (List<Venta>) Ventas.select(Conexion.getDBConexion(), "select MAX(venta_id) as MAX from ventas", Venta.class);
            
            if(ventas.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Primer venta!!!");
            Ventas.executeQuery(Conexion.getDBConexion(), String.format("insert into ventas(usuario_id, total, venta_id, hora , fecha, metodo_clave) values(1, %s, %s ,(select to_char(sysdate,'hh24:mi:ss') from dual),(select to_date(sysdate,'dd/mm/yyyy') from dual), '%s')",total,1,metod));
            for(int x=0;x<this.mod.getRowCount();x++){
                Ventas.executeQuery(Conexion.getDBConexion(), String.format("insert into ticket(venta_id, producto_id,cant) values(%s, %s, %s)",1,this.mod.getValueAt(x, 0),mod.getValueAt(x, 2)));
                upd= (List<Receta>) Recetas.select(Conexion.getDBConexion(), String.format("select cant from recetas where producto_id like '%s'",this.mod.getValueAt(x, 0)), Receta.class);
                ide= (List<Receta>) Recetas.select(Conexion.getDBConexion(), String.format("select ingrediente_id from recetas where producto_id like '%s'",this.mod.getValueAt(x, 0)), Receta.class);
               for(int up=0;up<upd.size();up++){  
                Receta update = (Receta) upd.get(up);
                Receta ing_id = (Receta) ide.get(up);
                Recetas.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp=cant_disp-(%s*%s) where ingrediente_id like '%s'",mod.getValueAt(x, 2),update.getCant(),ing_id.getIngrediente_id()));
               
                }
            }
            
            }else{
            Venta ven = (Venta) ventas.get(0);
            
            Ventas.executeQuery(Conexion.getDBConexion(), String.format("insert into ventas(usuario_id, total, venta_id, hora , fecha, metodo_clave) values(1, %s, %s ,(select to_char(sysdate,'hh24:mi:ss') from dual),(select to_date(sysdate,'dd/mm/yyyy') from dual), '%s')",total,Integer.parseInt(ven.getMax().toString())+1,metod));
            
            
            ventas= (List<Venta>) Ventas.select(Conexion.getDBConexion(), "select MAX(venta_id) as MAX from ventas", Venta.class);
            Venta veni = (Venta) ventas.get(0);
            for(int x=0;x<this.mod.getRowCount();x++){
                Ventas.executeQuery(Conexion.getDBConexion(), String.format("insert into ticket(venta_id, producto_id,cant) values(%s, %s, %s)",veni.getMax(),this.mod.getValueAt(x, 0),mod.getValueAt(x, 2)));
                upd= (List<Receta>) Recetas.select(Conexion.getDBConexion(), String.format("select cant from recetas where producto_id like '%s'",this.mod.getValueAt(x, 0)), Receta.class);
                ide= (List<Receta>) Recetas.select(Conexion.getDBConexion(), String.format("select ingrediente_id from recetas where producto_id like '%s'",this.mod.getValueAt(x, 0)), Receta.class);
               for(int up=0;up<upd.size();up++){  
                Receta update = (Receta) upd.get(up);
                Receta ing_id = (Receta) ide.get(up);
                Recetas.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp=cant_disp-(%s*%s) where ingrediente_id like '%s'",mod.getValueAt(x, 2),update.getCant(),ing_id.getIngrediente_id()));
               
                }
            }
            } 
            
            JOptionPane.showMessageDialog(rootPane, "Venta realizada");
            lblTotal.setText("0");
            
         
        }else{
        JOptionPane.showMessageDialog(null,"Falta por pagar:\n" + lblTotalFinal.getText());
        }
        }
    }//GEN-LAST:event_btnRegistroVentaActionPerformed

    private void btnBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloquearActionPerformed
        if((Float.parseFloat(lblTotalFinal.getText())<=0)||(Float.parseFloat(lblTotalFinal.getText())<Float.parseFloat(lblTotal.getText()))){
        JOptionPane.showMessageDialog(rootPane, "¡Venta en proceso final, no se puede bloquear!", "!!!!", WARNING_MESSAGE);
        }else{
        int opc = JOptionPane.showConfirmDialog(null,"¿Seguro?","Alerta",JOptionPane.YES_NO_OPTION);
        if(opc == JOptionPane.YES_OPTION){
            this.setVisible(false);
            Inicio i = new Inicio();
            i.setVisible(true);
        }
        else if(opc == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Ok");
        }
        }
    }//GEN-LAST:event_btnBloquearActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
            if((Float.parseFloat(lblTotalFinal.getText())<=0)||(Float.parseFloat(lblTotalFinal.getText())<Float.parseFloat(lblTotal.getText()))){
                JOptionPane.showMessageDialog(rootPane, "¡Venta en proceso final, no se puede salir!", "!!!!", WARNING_MESSAGE);
            }else{
            if(Float.parseFloat(lblTotal.getText())>0){
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
            java.util.logging.Logger.getLogger(PagoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagoAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnCredito;
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JButton btnRegistroVenta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblMetodoPago;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalFinal;
    private javax.swing.JTable model;
    private javax.swing.JTable tableCant_Disp;
    // End of variables declaration//GEN-END:variables
}
