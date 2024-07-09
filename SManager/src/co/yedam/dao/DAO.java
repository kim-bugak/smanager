package co.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DB connection 기능

public class DAO {
	Connection conn = null;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;

	
		public Connection getConn() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 접속 주소
			String driver = "oracle.jdbc.driver.DracleDriver";
			String user = "jsp";
			String pass = "jsp";

			try {
				conn = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}

	}

