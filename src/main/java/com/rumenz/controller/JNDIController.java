package com.rumenz.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JNDIController {
		
	@Autowired
	private DataSource dataSource;
	
	@GetMapping("/test")
	public String test() {
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT id,name FROM qq limit 1";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int id  = rs.getInt("id");
				String name = rs.getString("name");
				System.out.print("id: " + id);
				System.out.println(", name: " + name);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
