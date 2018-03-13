package controladores;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import datos.Usuario;
import oraclegeneral.Conexion;


public class Usuarios extends BaseController{
    
    public static String checkUsuario(String usuario, String contra){
        String query = "select * from usuarios where rol like '"+usuario+"' and contrasena like '"+contra+"'";
        List<Usuario> usuarios = (List<Usuario>) Usuarios.select(Conexion.getDBConexion(), query, Usuario.class);
        
        if(!usuarios.isEmpty()){
            try{
            if(usuarios.get(0).getRol().equals(usuario) && usuarios.get(0).getContrasena().equals(contra)){
                if(usuarios.get(0).getRol().equals("Administrador")){
                    return "Administrador";
                    }else{
                    return "Cajero";
                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Acceso como Cajero.");
                return "Cajero";
            }
        }else{
            return "";
        }
        return "";
    }
    
    
}
