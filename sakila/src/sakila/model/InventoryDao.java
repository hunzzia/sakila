package sakila.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.db.DBHelp;

public class InventoryDao {
	// 전체 행의 갯수
	public int selectInventoryCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM inventory";
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
