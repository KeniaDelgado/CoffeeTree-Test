package GUI;

public class Administrar extends javax.swing.JFrame {

    public Administrar() {
        setUndecorated(true);
            initComponents();
            this.setSize(1086, 726);
            this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBdR = new javax.swing.JButton();
        btnBd = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnCon_vent = new javax.swing.JButton();
        btnMod_Inv = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnBdR.setBorderPainted(false);
        btnBdR.setContentAreaFilled(false);
        btnBdR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBdR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBdRActionPerformed(evt);
            }
        });
        getContentPane().add(btnBdR);
        btnBdR.setBounds(600, 460, 370, 150);

        btnBd.setBorderPainted(false);
        btnBd.setContentAreaFilled(false);
        btnBd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBdActionPerformed(evt);
            }
        });
        getContentPane().add(btnBd);
        btnBd.setBounds(120, 460, 370, 150);

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

        btnCon_vent.setBorderPainted(false);
        btnCon_vent.setContentAreaFilled(false);
        btnCon_vent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCon_vent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCon_ventActionPerformed(evt);
            }
        });
        getContentPane().add(btnCon_vent);
        btnCon_vent.setBounds(590, 130, 370, 300);

        btnMod_Inv.setBorderPainted(false);
        btnMod_Inv.setContentAreaFilled(false);
        btnMod_Inv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMod_Inv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMod_InvActionPerformed(evt);
            }
        });
        getContentPane().add(btnMod_Inv);
        btnMod_Inv.setBounds(120, 130, 370, 300);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administrar.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1127, 725);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
        MenuInicioAdmin m = new MenuInicioAdmin();
        m.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnMod_InvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMod_InvActionPerformed

        Inventario in = new Inventario();
        in.setVisible(true);
    }//GEN-LAST:event_btnMod_InvActionPerformed

    private void btnCon_ventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCon_ventActionPerformed
        InventarioNo in = new InventarioNo();
        in.setVisible(true);
    }//GEN-LAST:event_btnCon_ventActionPerformed

    private void btnBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBdActionPerformed
        InventarioMod im = new InventarioMod();
        im.setVisible(true);
    }//GEN-LAST:event_btnBdActionPerformed

    private void btnBdRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBdRActionPerformed
        InventarioModR im = new InventarioModR();
        im.setVisible(true);
    }//GEN-LAST:event_btnBdRActionPerformed

    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(Administrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBd;
    private javax.swing.JButton btnBdR;
    private javax.swing.JButton btnCon_vent;
    private javax.swing.JButton btnMod_Inv;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
