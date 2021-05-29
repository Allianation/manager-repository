package com.database.manager.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.manager.OracleDataSource;
import com.database.manager.model.Connection;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = { "v1/manager/oracle" }, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ManagerOracleController {
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<String> getConnection(@RequestBody Connection connection) {

		final var SQL_QUERY = "SELECT 1 FROM DUAL";

		try (var con = OracleDataSource.getConnection(connection.getUser(), connection.getPassword(), connection.getDatabaseName(), connection.getServerName(), connection.getPortNumber());
				PreparedStatement pst = con.prepareStatement(SQL_QUERY);
				ResultSet rs = pst.executeQuery();) {

			log.info("Connection was successful!");

			return ResponseEntity.status(HttpStatus.OK).body("Connection was successful!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Connection not found!!!");

	}

}
