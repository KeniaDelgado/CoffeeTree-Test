package controladores;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import utils.StringUtils;

public class BaseController {
    
    /**
     * Metodo generico que mapea las consultas de tipo select a una lista.
     * Necesita:
     * <ul>
     * <li><b>BigDecimal: </b> Para datos numericos</li>
     * <li><b>String: </b> Para datos de cadena</li>
     * <li><b>Timestamp: </b>Para datos de tipo Date</li>
     * </ul>
     * @param connection
     * @param sql
     * @param clase
     * @return Lista con los elementos que devuelva el select
     */
    public static List<?> select(Connection connection, String sql, Class clase) {
        System.out.println(connection);
        List objects = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                Integer columnCount = rsmd.getColumnCount();
                while (rs.next()) {
                    Object object = clase.newInstance();
                    //System.out.println("object = " + object);
                    for (int i = 1; i <= columnCount; i++) {

                        String name = rsmd.getColumnName(i).toLowerCase();
                        name = String.format("set%s", StringUtils.capitalize(name));

                        Class[] params = new Class[1];
                        Object obj = rs.getObject(i);
                        params[0] = obj.getClass();
                        Method method = clase.getDeclaredMethod(name, params);
                        method.invoke(object, obj);
                    }
                    objects.add(object);
                }
                ps.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("e = 1: " + e);
                ps.close();
                connection.close();
            }

        } catch (Exception e) {
            System.out.println("e = 2: " + e);
        }
        return objects;
        
    }


    public static void executeQuery(Connection connection, String sql) {
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      
    
}
