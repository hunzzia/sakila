package sakila.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBHelper {
	// db�� �������ִ� �޼���
	public Connection getConnection() throws Exception {
		// ���ܴ� DBHelper �� ȣ���ϴ� �ʿ��� try catch �� ����Ͽ� ó��
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/sakila","root","java1234");
		return conn;
	}
	// db���ῡ ���� ��ü�� �����ϴ� �޼���
	public void close(ResultSet rs , PreparedStatement stmt , Connection conn) throws SQLException{
		rs.close();
		stmt.close();
		conn.close();
	}
	
}
