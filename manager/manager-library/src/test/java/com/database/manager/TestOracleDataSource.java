
package com.database.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.manager.utils.QueryEnum;

public class TestOracleDataSource {
	
	public static void getData() {
		
        final String SQL_QUERY = QueryEnum.CLIENT_BANKS.getQuery();
        
        // Open a connection
        try (Connection con = OracleDataSource.getConnection("digital", "password", "ORCLCDB", "localhost" ,1521); PreparedStatement pst = con.prepareStatement(SQL_QUERY); ResultSet rs = pst.executeQuery();) {
        	
        	// Collect column names
        	List<String> columnNames = new ArrayList<>();
        	ResultSetMetaData rsmd = rs.getMetaData();
        	for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        	    columnNames.add(rsmd.getColumnLabel(i));
        	}
        	
        	StringBuilder sb = new StringBuilder("[");
        	int rowIndex = 0;
        	
        	// Extract data from result set
        	while (rs.next()) {	
        		
        	    rowIndex++;
        	    
        	    // Collect row data as objects in a List
        	    List<Object> rowData = new ArrayList<>();
        	    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        	        rowData.add(rs.getObject(i));
        	    }
     
        	    sb.append("{");
        	    
        	    for (int colIndex = 0; colIndex < rsmd.getColumnCount(); colIndex++) {
        	        String objType = "null";
        	        String objString = "";
        	        Object columnObject = rowData.get(colIndex);
        	        if (columnObject != null) {
        	            objString = columnObject.toString() + " ";
        	            objType = columnObject.getClass().getName();
        	        }
        	       
        	        sb.append("\"" + columnNames.get(colIndex).toLowerCase() + "\"" + ":" );
        	        if (objType.equals("java.math.BigDecimal")) {
        	        	sb.append(objString + ", ");
        	        } else {
        	        	sb.append("\"" + objString + "\" ,");
        	        }
        	   
        	    }
        	    sb.append("},");
        	}
        	
        	sb.append("]");
        	
        	System.out.printf("Cantidad de Filas: " + rowIndex + "%n");
        	System.out.printf(sb.toString());
        	
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		getData();
	}

}
