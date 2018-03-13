/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.Inicio;
import GUI.MenuInicioAdmin;
import controladores.Ingredientes;
import controladores.Recetas;
import controladores.Usuarios;
import datos.Ingrediente;
import java.util.ArrayList;
import java.util.List;
import oraclegeneral.Conexion;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoffeeTree_Test {
    String[] args = {};
    
    @Test
    public void usuarioNuevoDBTest(){
        System.out.println("----------------------/////////----------------------");
        System.out.println("---------------------- usuarioNuevoDBTest ----------------------");
        System.out.println("----------------------/////////----------------------");
        //Supongamos que tenemos un nuevo usuario
        String newUser = "Coffeehh";
        String newPass = "abcd1234";
        
        Conexion.usuario = newUser;
        Conexion.contrasena = newPass;
        //la clase inicial es "InicioSistema", dentro de oraclegeneral
        //el metodo main de la clase debe ser capaz de determinar 
        //si un usuario es nuevo o no
        // como este metodo es un void no puedo regresar nada
        
//        InicioSistema.main(args); ----> aqui puedo ejecutar esto y los demas 
                                        //comentado, pero solo puedo verificar
                                        // si el usuario ya existe 
//        assertFalse(Conexion.creacionUsuario() == true);
//        assertFalse(Conexion.creacionBase(newUser, newPass)== true);
//        assertTrue(Conexion.verificarUsuario());
        // asi que saque ese codigo y lo probe aqui
        // lo esperado en esta prueba es
        // 1. checar si el usuario existe 
        if(Conexion.verificarUsuario()==true){
            System.out.println("USUARIO: " + Conexion.usuario);
            Inicio in = new Inicio(); 
             in.setVisible(true);
            System.out.println("El usuario ya existe en la BD");
            System.out.println("Se abre ventana inicio");
            assertFalse(Conexion.verificarUsuario().equals(false));
            try{
            assertTrue(Conexion.getDBConexion().isValid(0));
            }catch(Exception e){
            }    
        }else{
        // o si no existe, entonces verificar su creacion y su db    
            if((Conexion.creacionUsuario() == true) && (Conexion.creacionBase(newUser,newPass)== true)){
                //si lo anterior se cumple, entonces 
                // nuestro usuario ya existe
                // como ademas la conexion a su db es exitosa
            assertTrue(Conexion.verificarUsuario());
            assertFalse(Conexion.getDBConexion()==null);
            System.out.println("El usuario nuevo ya fue creado en la DB asi como su DB");
            System.out.println("Se abre ventana inicio");
            Inicio in = new Inicio(); 
            in.setVisible(true);
            }
        }
     }
        
        @Test
      public void usuarioInicioOKTest(){   
        System.out.println("----------------------/////////----------------------");
        System.out.println("---------------------- usuarioInicioOKTest ----------------------");
        System.out.println("----------------------/////////----------------------");
        //-------------------------------------------------
        // Prueba del boton "OK"
        // Como ya se comprobo que el usuario existe/crea, entonces se procede al ingreso
        // del sistema
        // Pasaremos a hacer una "Emulación" de este ingreso
        // esto es, porque no encontre la manera de testear la gui
        // pero básicamente es lo mismo, solo que sin la interfaz grafica
        
        
        // Primero ingresaremos como administrador
        InicioGUI inGui = new InicioGUI();
        inGui.ingresoOk("Administrador", "123");
        // como se ejecuto con exito hay que suponer que
        //Al checar al usuario se pudo comprobar que con esos datos
        // por medio de un select comprobamos que era el administrador
        String us = Usuarios.checkUsuario("Administrador", "123");
        //assertTrue(us.equals("Administrador"));
        assertFalse(us.isEmpty());
        
//        String query = "select * from usuarios where rol like '"+"Administrador"+"' and contrasena like '"+"123"+"'";
//        List<Usuario> usuarios = (List<Usuario>) Usuarios.select(Conexion.getDBConexion(), query, Usuario.class);
//        
        // Ingreso como cajero
        inGui.ingresoOk("Cajero", "321");
        String usC = Usuarios.checkUsuario("Cajero", "321");
        assertFalse(usC.isEmpty());
        assertTrue(usC.equals("Cajero"));
        //No se ingreso contraseña
        inGui.ingresoOk("admin", "");
        String usA = Usuarios.checkUsuario("admin", "");
        assertTrue(usA.equals(""));
        assertTrue(usA.isEmpty());
        assertFalse(usA.length()>0);
        //No se ingreso usuario
        inGui.ingresoOk("", "123");
        String usE = Usuarios.checkUsuario("", "123");
        assertTrue(usA.equals(""));
        assertTrue(usA.isEmpty());
        assertFalse(usA.length()>0);        

    }
      
      @Test
    public void usuarioInicioEnterTest(){
        System.out.println("----------------------/////////----------------------");
        System.out.println("---------------------- usuarioInicioEnterTest ----------------------");
        System.out.println("----------------------/////////----------------------");
        int returnMock;
        String adminNom = "Administrador";
        String contraAdmin = "123";
        
    // Testearemos los siguintes casos/alarmas que se pueden disparar al unicio
    // Todo en relacion a las cantidades disnonibles del inventario
        // --> Mock que si se ingresan ciertos datos el return debe ser 1
        // con esto comprobamos qu ingresa
    System.out.println("Cuando estan todos los ingredientes y eres admin");
            //Supongamos que un solo ingrediente ya quedo CASI sin existencias
            Recetas.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp= 5000 where cant_disp <= 1000"));
            // ahora hacemos la ejecución como admin
            // debemos esperar que el return sea 1 ya que es primer caso
            InicioGUI inMock = new InicioGUI();
            returnMock = inMock.ingresoEnterTXT(adminNom, contraAdmin);
            //assertTrue(returnMock == 3);
            String query = "Select * from ingredientes where cant_disp <= 1000";
            List<Ingredientes> ing = (List<Ingredientes>) Ingredientes.select(Conexion.getDBConexion(), query, Ingrediente.class);
            assertTrue(ing.isEmpty());    
            assertFalse(ing.size()>0);
            assertTrue(returnMock == 3);
            
            System.out.println("----------------------/////////----------------------");
            System.out.println("Cuando entras como admin y hay que resurtir un ingrediente");
            System.out.println("Menos de 8 ingredientes y la cantDisp > 0, return debe ser 2");
                //Supongamos que un solo ingrediente ya quedo CASI sin existencias
            Recetas.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp=1 where ingrediente_id like 1"));
                // ahora hacemos la ejecución como admin
                // debemos esperar que el return sea 2 ya que es lo que se deberia regresar
            returnMock = inMock.ingresoEnterTXT(adminNom, contraAdmin);
            assertTrue(returnMock == 2);
    //-------------------------------------------------//
    //-------------------------------------------------//
    System.out.println("----------------------/////////----------------------");
    System.out.println("Cuando entras como admin y hay que resurtir urgentemente");
    System.out.println("mas de 8 ingredientes casi por acabarse, return debe ser 1");
    
    MenuInicioAdmin menuAdmin2 = new MenuInicioAdmin();
    for (int i = 0; i < 10; i++) {
          Recetas.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp=1 where ingrediente_id like " + i ));
          
    }
        //Supongamos mas de 8 ingredientes ya quedaron CASI sin existencias
       // ahora hacemos la ejecución como admin
        // debemos esperar que el return sea 1 ya que es una alarma de resurtido
    InicioGUI inMock2 = new InicioGUI();
    returnMock = inMock2.ingresoEnterTXT(adminNom, contraAdmin);
    assertTrue(returnMock == 1);
    
    }
    
@Test
public void usuarioInicioEnterCajeroTest(){
    int returnMock;
    String cajeNom = "Cajero";
    String cajePass = "321";
    System.out.println("----------------------/////////----------------------");
    System.out.println("---------------------- usuarioInicioEnterCajeroTest ----------------------");
    System.out.println("----------------------/////////----------------------");
   
    System.out.println("Cuando entras como cajero y hay que resurtir menos de 8");
    System.out.println("ingredientes, de nuevo se avisa con menos urgencia");
    System.out.println("y de nuevo indica que le digas al admin, return debe ser 10");
    MenuInicioAdmin menuCaje1 = new MenuInicioAdmin();
    Recetas.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp=10000 where cant_disp <= 1000 "));
    Recetas.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp=1 where ingrediente_id = 1 "));
        //Supongamos mas de 8 ingredientes ya quedaron CASI sin existencias
       // ahora hacemos la ejecución como admin
        // debemos esperar que el return sea 1 ya que es una alarma de resurtido
    InicioGUI inMock2 = new InicioGUI();
    returnMock = inMock2.ingresoEnterTXT(cajeNom, cajePass);
    assertTrue(returnMock == 20);
    
    //-------------------------------------------------//
    //-------------------------------------------------//
    System.out.println("----------------------/////////----------------------");
    System.out.println("Cuando entras como Cajero y hay que resurtir urgentemente");
    System.out.println("se te avisara que informe a un administrador, return debe ser 20");
    for (int i = 0; i < 10; i++) {
          Recetas.executeQuery(Conexion.getDBConexion(), String.format("update ingredientes set cant_disp=1 where ingrediente_id like " + i ));
          
    }
        //Supongamos mas de 8 ingredientes ya quedaron CASI sin existencias
       // ahora hacemos la ejecución como admin
        // debemos esperar que el return sea 1 ya que es una alarma de resurtido
    returnMock = inMock2.ingresoEnterTXT(cajeNom, cajePass);
    assertTrue(returnMock == 10);
    
    }
      
@Test
public void usuarioInicioEnterVacioTest(){
    int returnMock;
    String nom = "";
    String pass = "";
    System.out.println("----------------------/////////----------------------");
    System.out.println("---------------------- usuarioInicioEnterVacioTest ----------------------");
    System.out.println("----------------------/////////----------------------");
    System.out.println("----------------------/////////----------------------");
    
    System.out.println("Cuando entras como Cajero y hay que resurtir urgentemente");
    System.out.println("se te avisara que informe a un administrador, return debe ser 20");
    InicioGUI inMock2 = new InicioGUI();
    returnMock = inMock2.ingresoEnterTXT(nom, pass);
    assertTrue(returnMock == 0);
}
      
      
// Esta clase "emula" los contenidos de la GUI
// en mi jframe de Inicio tengo 2 tipos de eventos
// click al boton de "OK" y un enter
// los dos tienen diferente codigo, asi que se prueban los dos
public class InicioGUI{

    public InicioGUI() {
    }
        
    public void ingresoOk(String usuario,String contrasena){
            
        String usr = usuario;
            String pass = contrasena;
            String checkUser = controladores.Usuarios.checkUsuario(usr, pass);
            
            if(controladores.Usuarios.checkUsuario(usr, pass).equals("Administrador")){
                System.out.println("Felicidades!, entraste como admin!");
                System.out.println("Se abre menuAdmin");
//                MenuInicioAdmin menuAdmin = new MenuInicioAdmin();
//                menuAdmin.setVisible(true);

            }else if(controladores.Usuarios.checkUsuario(usr, pass).equals("Cajero")){
                System.out.println("Felicidades!, entraste como cajero!");
                System.out.println("Se abre menuCajero");
//                MenuInicio menuCajero = new MenuInicio();
//                menuCajero.setVisible(true);
            }else{
                System.out.println("Te quivocaste ;w;");
            }
        }
        
    public int ingresoEnterTXT(String us,String pw){
        
        int largo;
        List<Ingrediente> cant_disp = new ArrayList<Ingrediente>();
        if(controladores.Usuarios.checkUsuario(us, pw).equals("Administrador")){
            System.out.println("Comprobración de inventario como Administrador");
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
                    System.out.println("Comprobración de inventario como Administrador");
                    System.out.println( "¡Tiempo de resurtir!");
                    System.out.println( "Ingredientes Conflicto: "+ array);
                    System.out.println("¡Porfavor resurta!\n"
                                                              + "O no se podra realizar ninguna venta :C");
//                    MenuInicioAdmin menuAdmin = new MenuInicioAdmin(1);
//                    menuAdmin.setVisible(true);
                    //this.dispose();
                    return 1;
            }else{
                if(l>0){
                    System.out.println("¡Hay ingredientes a punto de acabarce o sin existencias!");
                    System.out.println( "Ingredientes Conflicto: "+ array);
                    System.out.println("¡Porfavor revise la disponibilidad!");
                    return 2;
                }
                return 3;
//                MenuInicioAdmin menuAdmin = new MenuInicioAdmin();
//                menuAdmin.setVisible(true);
                //this.dispose(); 
            }
            
            
        }else if(controladores.Usuarios.checkUsuario(us, pw).equals("Cajero")){
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
                    System.out.println("Comprobración de inventario como Cajero");
                    System.out.println("¡Tiempo de resurtir! Advertencia");
                    System.out.println("Ingredientes Conflicto: " + array);
                    System.out.println("¡Porfavor avise al administrador!\n"
                                      + "O no se podra realizar ninguna venta :C");
//                   MenuInicio menuCajero = new MenuInicio(1);
//                   menuCajero.setVisible(true);
                    //this.dispose();
                    return 10;
        }else{
            if(l>0){
                System.out.println("¡Hay ingredientes a punto de acabarce o sin existencias!");
                System.out.println("Ingredientes Conflicto: " + array);
                System.out.println("¡Porfavor avise al administrador!");
                return 20;
            }
//            MenuInicio menuCajero = new MenuInicio();
//            menuCajero.setVisible(true);
            //this.dispose();
            return 30;
              }
            
        }else{
            System.out.println("Usuario o contraseña incorrecta");
            return 0;
        }
        }
    }
        
}


