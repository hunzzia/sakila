package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.model.AddressDao;
import sakila.vo.Address;
import sakila.vo.City;

@WebServlet("/insertAddress")
public class InsertAddress extends HttpServlet {
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("/application/json;charset=utf-8");
		System.out.println("::: InsertAddress 실행 :::");
		
		
		// 입력값 request
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String district = request.getParameter("district");
		String postalCode = request.getParameter("postalCode");
		String phone = request.getParameter("phone");
		
		System.out.println("request val.. : " + cityId + address + address2 + district + postalCode + phone);
		
		addressDao = new AddressDao();
		Address add = new Address();
		add.setCity(new City());
		add.getCity().setCityId(cityId);
		add.setAddress(address);
		add.setAddress2(address2);
		add.setDistrict(district);
		add.setPostalCode(postalCode);
		add.setPhone(phone);
		
		int count = addressDao.insertAddress(add);
		
		Gson gson = new Gson(); String jsonStr = gson.toJson(count);
		 
		response.getWriter().write(jsonStr);
		 
		
		System.out.println("::: InsertAddress 종료 :::");
	}
}
