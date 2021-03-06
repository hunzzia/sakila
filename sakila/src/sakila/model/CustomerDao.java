package sakila.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.vo.Customer;
import sakila.db.DBHelp;

public class CustomerDao {
	public List<Customer> selectCustomerList(Connection conn) throws Exception{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT customer_id , first_name , last_name , email  FROM customer";
		List<Customer> list = new ArrayList<Customer>();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customer_id"));
			customer.setFirstName(rs.getString("first_name"));
			customer.setLastName(rs.getString("last_name"));
			customer.setEmail(rs.getString("email"));
			list.add(customer);
		}
		
		return list;
		
	}
	// 고객입력 
	public void insertCustomerWithAddress(Connection conn  , Customer customer) throws Exception{ // 각자의 역할을 나누기위해 address dao 에 따로 지정
		//Connection conn =null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO customer("
				+"store_id , first_name , last_name , email , address_id , active , create_date ,last_update) "
				+ "VALUES(?,?,?,?,?,1,NOW(),NOW())";
			//conn= DBHelp.getConncetion();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,customer.getStore().getStoreId());
			stmt.setString(2,customer.getFirstName());
			stmt.setString(3,customer.getLastName());
			stmt.setString(4,customer.getEmail());
			stmt.setInt(5,customer.getAddress().getAddressId());

			stmt.executeUpdate();
	
	}
	
	// 전체 행의 갯수
	public int selectCustomerCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM customer";
		try {
			conn = DBHelp.getConncetion();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		} catch(Exception e) {
			
		} finally {
			DBHelp.close(rs, stmt, conn);
		}
		return count;
	}
}
