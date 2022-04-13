package omikuji;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PercentResult extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		String birthday = InputForm.getBirthday();
		
		try {
			
			Connection conn = DBUtil.getConnection();
			
			String count_sql = "SELECT u.birthday AS bday, g1.unseiname AS unseiname, COUNT(g1.unseiname) AS cnt "
					+ "FROM public.unseiresult u "
					+ "JOIN (SELECT o.omikujicode AS omkjcode, f.unseicode AS code, f.unseiname AS unseiname"
							+ "FROM public.fortunemaster f "
							+ "RIGHT OUTER JOIN public.omikujii o "
							+ "ON f.unseicode = o.unseicode) AS g1 "
					+ "ON u.omikujicode = g1.omkjcode "
					+ "WHERE birthday = '?' "
					+ "GROUP BY u.birthday, g1.unseiname, g1.code "
					+ "ORDER BY g1.code asc";
			PreparedStatement pstmt = conn.prepareStatement(count_sql);
			pstmt.setString(1, birthday);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PercentForm.setBirthday(rs.getString("birthday"));
				PercentForm.setUnseiname(rs.getString("unseiname"));;
				PercentForm.setCnt(rs.getInt("cnt"));;
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}















