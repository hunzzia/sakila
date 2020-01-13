package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sakila.vo.Address;
import sakila.model.AddressDao;
import sakila.model.StoreDao;
import sakila.vo.Customer;
import sakila.model.CustomerDao;
import sakila.db.DBHelp;
// 커낵션을호출해 트랜잭션 처리 , 예외를 처리 = > dao 는 커낵션을 호출할수 없음
public class CustomerService { // 두개의 요청을 처리하는 클레스
	private AddressDao addressDao;
	private CustomerDao customerDao;
	private Customer customer;
	private StoreDao storeDao;
	public List<Customer> selectCustomerList(){
		List<Customer> list = null;
		Connection conn = null;
		try {
			conn = DBHelp.getConncetion();
			customerDao = new CustomerDao();
			list = customerDao.selectCustomerList(conn);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelp.close(null, null, conn);
		}
		return list;
		
	}
	
	public void insertCustomer(Address address , Customer customer) {
		Connection conn = null;
		try {
			conn = DBHelp.getConncetion();
			conn.setAutoCommit(false); // 자동커밋 
			addressDao = new AddressDao();
			int addressId = addressDao.insertAddress(address); // conn 을 넘겨줌으로서 dao 가 역할을 할수있게함
			customerDao = new CustomerDao();
			customer.getAddress().setAddressId(addressId);
			customerDao.insertCustomerWithAddress(conn ,customer);
			conn.commit();
		}catch(Exception e){
			try {
			conn.rollback();
			}catch(SQLException e1) {}
			e.printStackTrace();
		}finally {
			DBHelp.close(null, null, conn);
		}
	}
	
}
