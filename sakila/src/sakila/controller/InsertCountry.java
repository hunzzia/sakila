package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.model.CountryDao;
import sakila.vo.Country;



@WebServlet("/address/InsertCountry")
public class InsertCountry extends HttpServlet {
	private CountryDao countryDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		System.out.println("---insertAddress Servlet실행---");
		System.out.println("requestParameter : " + country);
		
		countryDao = new CountryDao();
		Country c = new Country();
		c.setCountry(country);
		countryDao.insertCountry(c);
	}
}



















