package sakila.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.model.AddressDao;
import sakila.model.CityDao;
import sakila.model.CountryDao;
import sakila.model.PaymentDao;
import sakila.model.RentalDao;
import sakila.model.StaffDao;
import sakila.model.StoreDao;
import sakila.model.CustomerDao;
import sakila.model.ActorDao;
import sakila.model.CategoryDao;
import sakila.model.FilmActorDao;
import sakila.model.FilmCategoryDao;
import sakila.model.FilmDao;
import sakila.model.FilmTextDao;
import sakila.model.InventoryDao;
import sakila.model.LanguageDao;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}







