package sakila.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.model.AddressDao;
import sakila.vo.Address;


@WebServlet("/selectAddressList")
public class SelectAddressList extends HttpServlet {
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: SelectAddressList 실행 :::");
		response.setContentType("/application/json;charset=utf-8");
		
		// 첫페이지는 1
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		addressDao = new AddressDao();
		List<Address> list = addressDao.selectAddressList(currentPage);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		System.out.println(jsonStr);
		
		response.getWriter().write(jsonStr);
		
		System.out.println("::: SelectAddressList 종료 :::");
	}
}
