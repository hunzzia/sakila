package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.vo.Address;

import sakila.model.AddressDao;
import sakila.vo.City;
import sakila.vo.Store;
import sakila.vo.Customer;
import sakila.model.CustomerDao;
import sakila.service.CustomerService;


@WebServlet("/InsertCustomer")
public class InsertCustomer extends HttpServlet {
	//private AddressDao addressDao;
	//private CustomerDao customerDao;
	// customerDao 와  addressDao 의 사이에 하나의 계층(레이아웃필요) dao 는 각자를 필요로 하지만 다른 dao 를 출력할수 없기 때문 
	private CustomerService customerService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// address 관련 request.getParameter("")
		System.out.println(":::: InsertCustomer 실행 ::::::");
		Address add = new Address();
		//address.set...
		//addressDao = new AddressDao();
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String district = request.getParameter("district");
		String postalCode = request.getParameter("postalCode");
		String phone = request.getParameter("phone");
		System.out.println("request val.. address: " + cityId + address + address2 + district + postalCode + phone);
		
		add.setCity(new City());
		add.getCity().setCityId(cityId);
		add.setAddress(address);
		add.setAddress2(address2);
		add.setDistrict(district);
		add.setPostalCode(postalCode);
		add.setPhone(phone);
		
		//addressDao.insertAddressWithCustomer(add);
		
		
		// customer 관련 request.getParameter("")
		Customer customer = new Customer();
		//customerDao = new CustomerDao();
		//customer set..
		
		
		int  storeId = Integer.parseInt(request.getParameter("storeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("emailName");
		
		System.out.println("request val..customer : " +storeId+firstName+lastName+email);
		
		customer.setAddress(new Address());
		customer.setStore(new Store());
		customer.getStore().setStoreId(storeId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		
		
		//customerDao.insertCustomerWithAddress(customer);
		customerService = new CustomerService();
		customerService.insertCustomer(add, customer); // 두개의 요청을 받는 다른 서비스를 생성후 그서비스를 호출 dao 와 다른개념
		System.out.println(":::: InsertCustomer 종료 ::::::");
	}

}
