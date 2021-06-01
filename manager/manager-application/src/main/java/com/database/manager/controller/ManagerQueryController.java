package com.database.manager.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.manager.utils.QueryEnum;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = { "v1/manager/query" }, produces = APPLICATION_JSON_VALUE)
public class ManagerQueryController {
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<String> getAll() {
		
		var sb = new StringBuilder("[");
		var dataSeparator = "";
		
		for(QueryEnum qe : QueryEnum.values()) {
			sb.append(dataSeparator);
			sb.append("{\"" +qe.name() + "\"" + ": \"" + qe.getQuery()+ "\"}");
			dataSeparator = ", ";
		}
		
		sb.append("]");
		
		log.info(sb.toString());
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
		
	}

}
