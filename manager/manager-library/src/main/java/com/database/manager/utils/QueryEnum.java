package com.database.manager.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueryEnum {
	
	USER("select * from users"),
	CLIENT_BANKS("select * from client_banks");
	
	private String query;
	
}
