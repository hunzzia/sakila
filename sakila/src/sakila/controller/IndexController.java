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
	private CountryDao countryDao;
	private CityDao cityDao;
	private AddressDao addressDao;
	private CustomerDao customerDao;
	private PaymentDao paymentDao;
	private RentalDao rentalDao;
	private StaffDao staffDao;
	private StoreDao storeDao;
	private ActorDao actorDao;
	private CategoryDao categoryDao;
	private FilmDao filmDao;
	private FilmActorDao filmActorDao;
	private FilmCategoryDao filmCategoryDao;
	private FilmTextDao filmTextDao;
	private InventoryDao inventoryDao;
	private LanguageDao languageDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		// List<Integer> list = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		countryDao = new CountryDao();
		cityDao = new CityDao();
		addressDao = new AddressDao();
		customerDao = new CustomerDao();
		paymentDao = new PaymentDao();
		rentalDao = new RentalDao();
		staffDao = new StaffDao();
		storeDao = new StoreDao();
		actorDao = new ActorDao();
		categoryDao = new CategoryDao();
		filmDao = new FilmDao();
		filmActorDao = new FilmActorDao();
		filmCategoryDao = new FilmCategoryDao();
		filmTextDao = new FilmTextDao();
		inventoryDao = new InventoryDao();
		languageDao = new LanguageDao();
		
		int countryRow = countryDao.selectCountryCount();
		// list.add(countryRow); // autoboxing
		map.put("countryRow", countryRow);
		
		int cityRow = cityDao.selectCityCount();
		// list.add(cityRow);
		map.put("cityRow", cityRow);
		
		int addressRow = addressDao.selectAddressCount();
		map.put("addressRow", addressRow);
		
		int customerRow = customerDao.selectCustomerCount();
		map.put("customerRow", customerRow);
		
		int paymentRow = paymentDao.selectPaymentCount();
		map.put("paymentRow", paymentRow);
		
		int rentalRow = rentalDao.selectRentalCount();
		map.put("rentalRow", rentalRow);
		
		int staffRow = staffDao.selectStaffCount();
		map.put("staffRow", staffRow);
		
		int storeRow = storeDao.selectStoreCount();
		map.put("storeRow", storeRow);
		
		int actorRow = actorDao.selectActorCount();
		map.put("actorRow", actorRow);
		
		int categoryRow = categoryDao.selectCategoryCount();
		map.put("categoryRow", categoryRow);
		
		int filmRow = filmDao.selectFilmCount();
		map.put("filmRow", filmRow);
		
		int filmActorRow = filmActorDao.selectFilmActorCount();
		map.put("filmActorRow", filmActorRow);
		
		int filmCategoryRow = filmCategoryDao.selectFilmCategoryCount();
		map.put("filmCategoryRow", filmCategoryRow);
		
		int filmTextRow = filmTextDao.selectFilmTextCount();
		map.put("filmTextRow", filmTextRow);
		
		int inventoryRow = inventoryDao.selectInventoryCount();
		map.put("inventoryRow", inventoryRow);
		
		int languageRow = languageDao.selectLanguageCount();
		map.put("languageRow", languageRow);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		
		response.getWriter().write(jsonStr);
	}
}







