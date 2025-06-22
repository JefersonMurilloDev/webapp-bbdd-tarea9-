package org.jmurillo.apiservlet.jdbc.tarea.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBaseDatos {
    private static String url;
    private static String username;
    private static String password;
    private static Connection connection;

    static {
        Properties props = new Properties();
        try (InputStream input = ConexionBaseDatos.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("No se pudo encontrar el archivo config.properties en el classpath");
            }
            props.load(input);
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");
        } catch (IOException ex) {
            throw new RuntimeException("Error al cargar las propiedades de la base de datos", ex);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
