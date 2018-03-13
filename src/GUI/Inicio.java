
package GUI;

import controladores.Ingredientes;
import datos.Ingrediente;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import oraclegeneral.Conexion;


public class Inicio extends javax.swing.JFrame {
    private String usr;
    private String pass;
    private Connection cnn;
    private Statement st;
    private ResultSet rs;
    private DefaultTableModel dtmUsuarios;
    private List<Ingrediente> cant_disp = new ArrayList<Ingrediente>();
    int largo;
    
    public Inicio() {
            setUndecorated(true);
            initComponents();
            this.setSize(1086, 726);
            this.setLocationRelativeTo(null);
 
    }
     
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        inicio = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraKeyPressed(evt);
            }
        });
        getContentPane().add(txtContra);
        txtContra.setBounds(260, 370, 220, 50);

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(210, 300, 270, 50);

        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false);
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk);
        btnOk.setBounds(420, 440, 80, 50);

        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/índice.jpg"))); // NOI18N
        inicio.setText("jLabel2");
        getContentPane().add(inicio);
        inicio.setBounds(0, -10, 1127, 726);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        usr = txtUsuario.getText();
        pass = txtContra.getText();
        if(controladores.Usuarios.checkUsuario(usr, pass).equals("admin")){
            List<Ingredientes> ing= new ArrayList<>();
        cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select cant_Disp,nombre from Ingredientes", Ingrediente.class);;
        
        largo = cant_disp.size();
        int l=0;
        String[] array = new String[100]; 
        for(int i=0;i<largo;i++){
        Ingrediente in = (Ingrediente) cant_disp.get(i);
        System.out.println("cant_disp = " + in.getCant_disp());
        
            if(Float.parseFloat(in.getCant_disp().toString())<=1000){
            array[i] = "-" + in.getNombre();
            l++;
            }
        }
        if(l>=8){
                   JOptionPane.showMessageDialog(null, "¡Tiempo de resurtir!", "Advertencia", WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, array, "Ingredientes Conflicto", WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "¡Porfavor resurta!\n"
                                                          + "O no se podra realizar ninguna venta :C", "Advertencia", WARNING_MESSAGE);
                MenuInicioAdmin menuAdmin = new MenuInicioAdmin(1);
                menuAdmin.setVisible(true);
                this.dispose();
        }else{
            if(l>0){
                JOptionPane.showMessageDialog(null, "¡Hay ingredientes a punto de acabarce o sin existencias!", "Advertencia", WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, array, "Ingredientes Conflicto", WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, "¡Porfavor revise la disponibilidad!", "Advertencia", WARNING_MESSAGE);
            }
            MenuInicioAdmin menuAdmin = new MenuInicioAdmin();
            menuAdmin.setVisible(true);
            this.dispose(); 
        }
            
            
        }else if(controladores.Usuarios.checkUsuario(usr, pass).equals("Cajero")){
            List<Ingredientes> ing= new ArrayList<>();
        cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select cant_Disp,nombre from Ingredientes", Ingrediente.class);;
        
        largo = cant_disp.size();
        int l=0;
        String[] array = new String[100]; 
        for(int i=0;i<largo;i++){
        Ingrediente in = (Ingrediente) cant_disp.get(i);
        System.out.println("cant_disp = " + in.getCant_disp());
        
            if(Float.parseFloat(in.getCant_disp().toString())<=1000){
            array[i] = "-" + in.getNombre();
            l++;
            }
        }
        if(l>=8){
                   JOptionPane.showMessageDialog(null, "¡Tiempo de resurtir!", "Advertencia", WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, array, "Ingredientes Conflicto", WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "¡Porfavor avise al administrador!\n"
                                                          + "O no se podra realizar ninguna venta :C", "Advertencia", WARNING_MESSAGE);
                   MenuInicio menuCajero = new MenuInicio(1);
                   menuCajero.setVisible(true);
                    this.dispose();
        }else{
            if(l>0){
                JOptionPane.showMessageDialog(null, "¡Hay ingredientes a punto de acabarce o sin existencias!", "Advertencia", WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, array, "Ingredientes Conflicto", WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, "¡Porfavor avise al administrador!", "Advertencia", WARNING_MESSAGE);
                
            }
            MenuInicio menuCajero = new MenuInicio();
            menuCajero.setVisible(true);
            this.dispose();
              }
            
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
        }
        }
    }//GEN-LAST:event_txtContraKeyPressed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        usr = txtUsuario.getText();
        pass = txtContra.getText();
        String checkUser = controladores.Usuarios.checkUsuario(usr, pass);
        if(checkUser.equals("Administrador")){
            MenuInicioAdmin menuAdmin = new MenuInicioAdmin();
            menuAdmin.setVisible(true);
            this.dispose();
            
        }else if(checkUser.equals("Cajero")){
            MenuInicio menuCajero = new MenuInicio();
            menuCajero.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
        }
        
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        usr = txtUsuario.getText();
        pass = txtContra.getText();
        if(controladores.Usuarios.checkUsuario(usr, pass).equals("admin")){
            MenuInicioAdmin menuAdmin = new MenuInicioAdmin();
            menuAdmin.setVisible(true);
            this.dispose();
            
        }else if(controladores.Usuarios.checkUsuario(usr, pass).equals("Cajero")){
            MenuInicio menuCajero = new MenuInicio();
            menuCajero.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
        }
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
