package sakila.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBHelper {
	// db를 연결해주는 메서드
	public Connection getConnection() throws Exception {
		// 예외는 DBHelper 를 호출하는 쪽에서 try catch 를 사용하여 처리
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/sakila","root","java1234");
		return conn;
	}
	// db연결에 사용된 객체를 종료하는 메서드
	public void close(ResultSet rs , PreparedStatement stmt , Connection conn) throws SQLException{
		rs.close();
		stmt.close();
		conn.close();
	}
	
}
