package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.model.AddressDao;

@WebServlet("/selectAddressCount")
public class SelectAddressCount extends HttpServlet {
	private AddressDao addressDao;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: SelectAddressList 실행 :::");
		response.setContentType("/application/json;charset=utf-8");
		
		addressDao = new AddressDao();
		
		int count = addressDao.selectAddressCount();
		
		Gson gson = new Gson();
		String jsonCount = gson.toJson(count);
		System.out.println(jsonCount);
		
		response.getWriter().write(jsonCount);
	}

}
