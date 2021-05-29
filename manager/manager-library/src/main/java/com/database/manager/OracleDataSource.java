package com.database.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariDataSource;

public class OracleDataSource {
	
	private OracleDataSource() {
		throw new IllegalStateException("Utility DataSource Class");
	}
   
    private static HikariDataSource configurationDataSource(String user, String password, String databaseName, String serverName, int portNumber) {
        final var hikariDataSource = new HikariDataSource(); // Local-Variable Type Inference.
        hikariDataSource.setMaximumPoolSize(100); // Máximo número de conexiones en el pool.
        hikariDataSource.setMinimumIdle(10); // Mínimo número de conexiones inactivas mantenidas por HikariCP en el pool de conexiones.
        hikariDataSource.setMaxLifetime(1000); // Tiempo de vida máximo en milisegundos de una conexión en el pool después de que se cierra.
        hikariDataSource.setConnectionTestQuery("SELECT 1 FROM DUAL");
        hikariDataSource.setDataSourceClassName("oracle.jdbc.pool.OracleDataSource");

        var properties = new Properties();
        properties.put("user", user);
        properties.put("password", password);
        properties.put("databaseName", databaseName);
        properties.put("serverName", serverName);
        properties.put("portNumber", portNumber);
        properties.put("driverType", "thin");
        
        hikariDataSource.setDataSourceProperties(properties);
        return hikariDataSource;
    }
   
    public static Connection getConnection(String user, String password, String databaseName, String serverName, int portNumber) throws SQLException {
        return configurationDataSource(user, password, databaseName, serverName, portNumber).getConnection();
    }

}
