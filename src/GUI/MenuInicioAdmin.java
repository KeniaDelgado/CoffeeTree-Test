package GUI;

import controladores.Ingredientes;
import controladores.Recetas;
import datos.Ingrediente;
import datos.Receta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import oraclegeneral.Conexion;

public class MenuInicioAdmin extends javax.swing.JFrame {
    float total = 0;
    int z = 0;
    int largo=0;
    int[] anchos = {40, 175 ,50, 50,60};
    DefaultTableModel mod;
    DefaultTableModel cantidades_reg;
    int filas = 0;
    private List<Ingrediente> cant_disp = new ArrayList<Ingrediente>();
    //test
   
    
    
    
    public MenuInicioAdmin() {
        setUndecorated(true);
        initComponents();
        this.setSize(1086, 726);
        this.setLocationRelativeTo(null);
        lblTotal.setText(String.valueOf(total));
        model.setDefaultEditor(Object.class, null);
        for(int i = 0; i < model.getColumnCount(); i++) {
                model.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
        mod = (DefaultTableModel)this.model.getModel();
        //Cantidades disponibles de los ingredientes
        cantidades_reg = (DefaultTableModel)this.tableCant_Disp.getModel();
        List<Ingredientes> ing= new ArrayList<>();
        cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select cant_Disp,nombre from Ingredientes", Ingrediente.class);;
        largo = cant_disp.size();
        int l=0;
        String[] array = new String[100]; 
        for(int i=0;i<largo;i++){
        Ingrediente in = (Ingrediente) cant_disp.get(i);
        System.out.println("cant_disp = " + in.getCant_disp());
        int fila = cantidades_reg.getRowCount();
        cantidades_reg.addRow(new Object[fila]);
        cantidades_reg.setValueAt(in.getCant_disp(),fila,0);
            if(Float.parseFloat(in.getCant_disp().toString())<=1000){
            array[i] = "-" + in.getNombre();
            l++;
            }
        }
        
      
    }
    
    public MenuInicioAdmin(int bloq) {
        setUndecorated(true);
        initComponents();
        this.setSize(1086, 726);
        this.setLocationRelativeTo(null);
        lblTotal.setText(String.valueOf(total));
        model.setDefaultEditor(Object.class, null);
        for(int i = 0; i < model.getColumnCount(); i++) {
                model.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
        mod = (DefaultTableModel)this.model.getModel();
        //Cantidades disponibles de los ingredientes
        cantidades_reg = (DefaultTableModel)this.tableCant_Disp.getModel();
        List<Ingredientes> ing= new ArrayList<>();
        cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select cant_Disp,nombre from Ingredientes", Ingrediente.class);;
        largo = cant_disp.size();
        int l=0;
        String[] array = new String[100]; 
        for(int i=0;i<largo;i++){
        Ingrediente in = (Ingrediente) cant_disp.get(i);
        System.out.println("cant_disp = " + in.getCant_disp());
        int fila = cantidades_reg.getRowCount();
        cantidades_reg.addRow(new Object[fila]);
        cantidades_reg.setValueAt(in.getCant_disp(),fila,0);
            if(Float.parseFloat(in.getCant_disp().toString())<=1000){
            array[i] = "-" + in.getNombre();
            l++;
            }
        }
        if(bloq == 1){
        btnCrepas.setEnabled(false);
        btnBebCal.setEnabled(false);
        btnBebFrias.setEnabled(false);
        }
      
    }
    
    public MenuInicioAdmin(DefaultTableModel mod,DefaultTableModel cant){
         setUndecorated(true);
        initComponents();
        this.setSize(1086, 726);
        this.setLocationRelativeTo(null);
        this.model.setDefaultEditor(Object.class, null);
        this.filas = mod.getRowCount()+1;
        this.mod = mod;
        this.model.setModel(mod);
        
        for(int i = 0; i < model.getColumnCount(); i++) {

                model.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);

            }
        
        total = 0;
        if(mod.getRowCount()!=0){
        System.out.println(String.valueOf(mod.getValueAt(z,2)));
        for(z = 0;z<=mod.getRowCount()-1;z++){
        mod.setValueAt((Float.parseFloat(String.valueOf(mod.getValueAt(z,2)))*(Float.parseFloat(String.valueOf(mod.getValueAt(z,3))))), z , 4);
        total = Float.parseFloat(String.valueOf(mod.getValueAt(z,4))) + total;
        }
        }
        
        lblTotal.setText(String.valueOf(total));
        
        this.cantidades_reg = cant;
        cantidades_reg = (DefaultTableModel)this.tableCant_Disp.getModel();
        List<Ingredientes> ing= new ArrayList<>();
        cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select cant_Disp from Ingredientes", Ingrediente.class);;
        largo = cant_disp.size();
        for(int i=0;i<largo;i++){
        Ingrediente in = (Ingrediente) cant_disp.get(i);
        System.out.println("cant_disp = " + in.getCant_disp());
        int fila = cantidades_reg.getRowCount();
        cantidades_reg.addRow(new Object[fila]);
        cantidades_reg.setValueAt(in.getCant_disp(),fila,0);
         
        }
        
    }
    
    public MenuInicioAdmin(DefaultTableModel mod){
         setUndecorated(true);
        initComponents();
        this.setSize(1086, 726);
        this.setLocationRelativeTo(null);
        this.model.setDefaultEditor(Object.class, null);
        this.filas = mod.getRowCount()+1;
        this.mod = mod;
        this.model.setModel(mod);
        
        for(int i = 0; i < model.getColumnCount(); i++) {

                model.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);

            }
        
        total = 0;
        if(mod.getRowCount()!=0){
        System.out.println(String.valueOf(mod.getValueAt(z,2)));
        for(z = 0;z<=mod.getRowCount()-1;z++){
        mod.setValueAt((Float.parseFloat(String.valueOf(mod.getValueAt(z,2)))*(Float.parseFloat(String.valueOf(mod.getValueAt(z,3))))), z , 4);
        total = Float.parseFloat(String.valueOf(mod.getValueAt(z,4))) + total;
        }
        }
        
        lblTotal.setText(String.valueOf(total));
        
        cantidades_reg = (DefaultTableModel)this.tableCant_Disp.getModel();
        List<Ingredientes> ing= new ArrayList<>();
        cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select cant_Disp from Ingredientes", Ingrediente.class);;
        largo = cant_disp.size();
        for(int i=0;i<largo;i++){
        Ingrediente in = (Ingrediente) cant_disp.get(i);
        System.out.println("cant_disp = " + in.getCant_disp());
        int fila = cantidades_reg.getRowCount();
        cantidades_reg.addRow(new Object[fila]);
        cantidades_reg.setValueAt(in.getCant_disp(),fila,0);
         
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCant_Disp = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnBloquear = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnCrepas = new javax.swing.JButton();
        btnBebCal = new javax.swing.JButton();
        btnBebFrias = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnEliminarProducto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        model = new javax.swing.JTable();
        lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(10, 650, 200, 70);

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setFocusable(false);
        jScrollPane2.setOpaque(false);

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

        btnAdmin.setBorderPainted(false);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin);
        btnAdmin.setBounds(50, 350, 280, 220);

        btnCrepas.setBorderPainted(false);
        btnCrepas.setContentAreaFilled(false);
        btnCrepas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrepas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrepasActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrepas);
        btnCrepas.setBounds(52, 76, 282, 220);

        btnBebCal.setBorderPainted(false);
        btnBebCal.setContentAreaFilled(false);
        btnBebCal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBebCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebCalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBebCal);
        btnBebCal.setBounds(382, 76, 282, 220);

        btnBebFrias.setBorderPainted(false);
        btnBebFrias.setContentAreaFilled(false);
        btnBebFrias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBebFrias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebFriasActionPerformed(evt);
            }
        });
        getContentPane().add(btnBebFrias);
        btnBebFrias.setBounds(380, 350, 282, 220);

        btnPagar.setBorderPainted(false);
        btnPagar.setContentAreaFilled(false);
        btnPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPagar);
        btnPagar.setBounds(702, 568, 190, 160);

        lblTotal.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");
        getContentPane().add(lblTotal);
        lblTotal.setBounds(930, 635, 140, 50);

        btnEliminarProducto.setBackground(new java.awt.Color(153, 153, 0));
        btnEliminarProducto.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setText("X");
        btnEliminarProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(153, 153, 0)));
        btnEliminarProducto.setContentAreaFilled(false);
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnEliminarProducto.setOpaque(true);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarProducto);
        btnEliminarProducto.setBounds(1020, 130, 50, 50);

        jPanel1.setOpaque(false);

        model.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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
        model.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        model.setRowHeight(25);
        model.setSelectionBackground(new java.awt.Color(161, 212, 212));
        model.setSelectionForeground(new java.awt.Color(102, 102, 102));
        model.setShowVerticalLines(false);
        model.getTableHeader().setResizingAllowed(false);
        model.getTableHeader().setReorderingAllowed(false);
        model.setUpdateSelectionOnSort(false);
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

        lbl.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setText("$");
        getContentPane().add(lbl);
        lbl.setBounds(900, 640, 30, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu_principal.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1089, 726);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
       //mod = (DefaultTableModel)this.model.getModel();
       if((this.mod.getRowCount()!=0)&&(this.model.getSelectedRowCount() > 0)){
           total = Float.parseFloat(lblTotal.getText());
       float totalcompra =  (float) mod.getValueAt(this.model.getSelectedRow(), 4);
        System.out.println("totalcompra = " + totalcompra);
       total = total - totalcompra;
        System.out.println("totalcompra = " + total);
       lblTotal.setText(String.valueOf(total));
        mod.removeRow(this.model.getSelectedRow());
       }else{
       JOptionPane.showMessageDialog(null,"¡¡No hay nada seleccionado!!");
       }
       
  
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnBebCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebCalActionPerformed
        this.setVisible(false);
        BebidasCalientesAdmin bc = new BebidasCalientesAdmin(this.mod);
        bc.setVisible(true);
    }//GEN-LAST:event_btnBebCalActionPerformed

    private void btnBebFriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebFriasActionPerformed
        this.setVisible(false);
        BebidasFriasAdmin bf = new BebidasFriasAdmin(this.mod);
        bf.setVisible(true);
    }//GEN-LAST:event_btnBebFriasActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        this.setVisible(false);
        Administrar bf = new Administrar();
        bf.setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int p;
        int up; 
        int i=0;
        String[] array = new String[100]; 
       if(Float.parseFloat(lblTotal.getText())!=0){
        //Ciclo for para recorrer toda la tabla y hacer las validaciones apropiadas
        int opc = JOptionPane.showConfirmDialog(null,"¿Seguro?","Alerta",JOptionPane.YES_NO_OPTION);
        if(opc == JOptionPane.YES_OPTION){
            for(p=0;p<mod.getRowCount();p++){
                List<Receta> rec = new ArrayList<>();
                List<Ingrediente> cantI = new ArrayList<>();
                rec= (List<Receta>) Recetas.select(Conexion.getDBConexion(), String.format("select ingrediente_id,cant from recetas where producto_id = %s",mod.getValueAt(p, 0)), Receta.class);
                System.out.println("rec.size() = " + rec.size());
                for(up=0;up<rec.size();up++){  
                Receta cant_rec = (Receta) rec.get(up);
                cantI= (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), String.format("select cant_disp,ingrediente_id from ingredientes where ingrediente_id like '%s'",cant_rec.getIngrediente_id()), Ingrediente.class);
                Ingrediente cant_ing = (Ingrediente) cantI.get(0);
                System.out.println("cant_ing = " + mod.getValueAt(p, 2));
                int cel_disp = Integer.parseInt(cant_ing.getIngrediente_id().toString())-1;
                    System.out.println("cel_disp = " + cel_disp);
                float cant_ingrediente = Float.parseFloat(cantidades_reg.getValueAt(cel_disp, 0).toString());//Valor de la celda donde se encuentra la cantidad de producto disp x ing
                    System.out.println("cant_ingrediente = " + cant_ingrediente);
                float cant_receta = Float.parseFloat(cant_rec.getCant().toString());
                    System.out.println("cant_receta = " + cant_receta);
                float cant_ingresada = Float.parseFloat(mod.getValueAt(p, 2).toString());
                 
                if(cant_ingrediente-(cant_receta*cant_ingresada)<0){
                    System.out.println("Cantidad no disponible :C");
                    array[i] = "- "+mod.getValueAt(p, 1).toString();
                    i++;
                
                }else{
                    if(cant_ingrediente-(cant_receta*cant_ingresada)>=0){
                    cantidades_reg.setValueAt(cant_ingrediente-(cant_receta*cant_ingresada), cel_disp, 0);
                    }
                }
                }
        }
            
            if(i>0){
                    JOptionPane.showMessageDialog(rootPane, "¡No hay ingredientes suficientes para ciertos productos!", "Advertencia", WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(rootPane, array, "Productos Conflicto", WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(rootPane, "Porfavor resurta ingredientes o elimine producto", "Advertencia", WARNING_MESSAGE);
                List<Ingredientes> ing= new ArrayList<>();
                cant_disp = (List<Ingrediente>) Ingredientes.select(Conexion.getDBConexion(), "select cant_Disp from Ingredientes", Ingrediente.class);;
                largo = cant_disp.size();
                for(int o=0;o<largo;o++){
                    cantidades_reg.removeRow(0);
                }
                for(int o=0;o<largo;o++){
                    Ingrediente in = (Ingrediente) cant_disp.get(o);
                    System.out.println("cant_disp = " + in.getCant_disp());
                    int fila = cantidades_reg.getRowCount();
                    cantidades_reg.addRow(new Object[fila]);
                    cantidades_reg.setValueAt(in.getCant_disp(),fila,0);
         
                }
            }else{
                 this.setVisible(false);
                 PagoAdmin pag = new PagoAdmin(mod,cantidades_reg);
                 pag.setVisible(true);
            }
           
            
        }
        else if(opc == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Ok");
        }
        }else{
            JOptionPane.showMessageDialog(null, "No hay nada ha pagar");
        }
        
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnCrepasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrepasActionPerformed
        this.setVisible(false);
        CrepasAdmin cp = new CrepasAdmin(this.mod);
        cp.setVisible(true);
    }//GEN-LAST:event_btnCrepasActionPerformed

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
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Recetario rc = new Recetario();
        rc.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicioAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnBebCal;
    private javax.swing.JButton btnBebFrias;
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrepas;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable model;
    private javax.swing.JTable tableCant_Disp;
    // End of variables declaration//GEN-END:variables
}
