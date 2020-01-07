package sakila.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelp;
import sakila.vo.Address;
import sakila.vo.City;
import sakila.vo.Country;

public class AddressDao {
	// 리스트
	public List<Address> selectAddressList() {
		/*
		 * city inner join country 
		 */
		List<Address> list = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT c.country_id, c.country, ci.city_id, ci.city, "
				+ "ad.address_id, ad.address, ad.address2, ad.district, ad.postal_code, ad.phone, ad.last_update "
				+ "FROM address ad INNER JOIN city ci INNER JOIN country c ON ad.city_id = ci.city_id AND ci.country_id = c.country_id "
				+ "ORDER BY ad.address_id DESC LIMIT 100";
		
		try {
			conn = DBHelp.getConncetion();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Address address = new Address();
				address.setCity(new City());
				address.getCity().setCountry(new Country());
				address.getCity().getCountry().setCountryId(rs.getInt("c.country_id"));
				address.getCity().getCountry().setCountry(rs.getString("c.country"));
				address.getCity().setCityId(rs.getInt("ci.city_id"));
				address.getCity().setCity(rs.getString("ci.city"));
				address.setAddressId(rs.getInt("ad.address_id"));
				address.setAddress(rs.getString("ad.address"));
				address.setAddress2(rs.getString("ad.address2"));
				address.setDistrict(rs.getString("ad.district"));
				address.setPostalCode(rs.getString("ad.postal_code"));
				address.setPhone(rs.getString("ad.phone"));
				address.setLastUpdate(rs.getString("ad.last_update"));
				list.add(address);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelp.close(rs, stmt, conn);
		}
		return list;
	}
		
	
	// cityId받기
	public List<Address> selectCityListByCountry(int countryId) {
		List<Address> list = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT address_id, address FROM address where city_id = ?";
		
		try {
			conn = DBHelp.getConncetion();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, countryId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Address address = new Address();
				address.setAddressId(rs.getInt("address_id"));
				address.setAddress(rs.getString("address"));
				list.add(address);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelp.close(rs, stmt, conn);
		}
		return list;
	}
	
	// 전체 행의 갯수
	public int selectAddressCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM address";
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
	
	// 도시 추가
	public void insertAddress(Address address) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO address(address, address2, district, city_id, postal_code, phone, last_update) VALUES (?,?, ?, ?, ?, ?, now())";
		try {
			conn = DBHelp.getConncetion();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, address.getAddress());
			stmt.setString(2, address.getAddress2());
			stmt.setString(3, address.getDistrict());
			stmt.setInt(4, address.getCity().getCityId());
			stmt.setString(5, address.getPostalCode());
			stmt.setString(6, address.getPhone());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelp.close(null, stmt, conn);
		}
	}
}
