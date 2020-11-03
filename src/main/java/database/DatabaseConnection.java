package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection<inputStream, prop> {

    Properties properties = new Properties();
    String propFileName = "databaseconfig.properties";

    public Properties getDatabaseProperties() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream == null) {
            System.out.println(("Input Stream is null"));
            return null;
        } else {
            Properties properties = new Properties();
            try {
                properties.load(inputStream);
                return properties;
            } catch (Exception e) {
                System.out.println("Error occured while reading property file");
                return null;
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                {

                }
            }
        }

    }

    public Connection getConnection() {
        Properties properties = getDatabaseProperties();
        if (properties == null) {
            return null;
        }
        try {
            String username = properties.getProperty("datasource.username");
            String databaseUrl = properties.getProperty("datasource.url");
            String password = properties.getProperty("datasource.password");
            Connection connection = DriverManager.getConnection(databaseUrl, username, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
