import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class ConnectionSingleton {
    private static Connection connection = null;

    private ConnectionSingleton(){
        return;
    }

    public static Connection getInstance(){
        Map<String,String> mappa = letturaFile();
        try {
            String driver = (String)mappa.get("driver");
            Class.forName(driver);
            String url = "";
            connection = DriverManager.getConnection(url,mappa.get("username"),mappa.get("password"));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Errore metodo getInstance()");
        }
        return connection;
    }

    public static Map<String,String> letturaFile(){
        Map<String,String> mappa = new HashMap<String,String>();
        try {
            Properties properties = new Properties(); //Properties ci da la possibilita' di leggere da file con estensione .properties
            InputStream input = Files.newInputStream(Paths.get("config.properties"));
            properties.load(input);

            mappa.put("user", properties.getProperty("db.username"));
            mappa.put("password", properties.getProperty("db.password"));
            mappa.put("driver", properties.getProperty("db.driver"));

            }
        catch (IOException e){
            System.out.println("Errore");
        }
        return mappa;
    }
}
