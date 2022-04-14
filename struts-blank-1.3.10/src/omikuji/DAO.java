package omikuji;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private DAO() {}
	
	private static DAO obj;
	
	public static DAO sharedInstance() {
		if(obj == null) {
			obj = new DAO();
		}
		return obj;
	}
	
	private Connection conn = DBUtil.getConnection();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public List<HalfDTO> rslist(String birthday) {
		
		List<HalfDTO> list = null;
		String select_sql = "SELECT * from public.unseiresult u "
					+ "WHERE (SELECT CAST(u.uranaidate AS date) AS uradate) BETWEEN CURRENT_TIMESTAMP - INTERVAL '6 months' AND CURRENT_TIMESTAMP "
					+ "AND birthday = '?' "
					+ "ORDER BY u.uranaidate ASC";
		
		try {
			
			pstmt = conn.prepareStatement(select_sql);
			pstmt.setString(1, birthday);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<HalfDTO> ();
			
			while(rs.next()) {
				HalfDTO halfdto = new HalfDTO();
				
				halfdto.setUranaidate(rs.getString("uranaidate"));
				halfdto.setBirthday(rs.getString("birthday"));
				halfdto.setOmikujicode(rs.getString("omikujicode"));
				halfdto.setRenewalwriter(rs.getString("renewalwriter"));
				halfdto.setRenewaldate(rs.getString("renewaldate"));
				halfdto.setUnseiwriter(rs.getString("unseiwriter"));
				halfdto.setUnseiwritedate(rs.getString("unseiwritedate"));
				list.add(halfdto);

				
//				list.add(new HalfDTO(rs.getString("uranaidate"), rs.getString("birthday"), rs.getString("omikujicode"),
//						rs.getString("renewalwriter"), rs.getString("renewaldate"), rs.getString("unseiwriter"), rs.getString("unseiwritedate")));
//				
			}
			
			System.out.println("hi3");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
