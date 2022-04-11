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

public class HalfResult extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		String select_sql = "SELECT * from public.unseiresult u "
						+ "WHERE (SELECT CAST(u.uranaidate AS date) AS uradate) "
						+ "BETWEEN CURRENT_TIMESTAMP - INTERVAL '6 months' "
						+ "AND CURRENT_TIMESTAMP "
						+ "AND birthday = '?' "
						+ "ORDER BY u.uranaidate ASC";
		InputForm inputform = (InputForm)form;
		HalfForm halfform = (HalfForm)form;
		String birthday = inputform.getBirthday();
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select_sql);
			pstmt.setString(1, birthday);
			ResultSet rs = pstmt.executeQuery();
			
			
			
			
			while(rs.next()) {
				halfform.setUranaidate(rs.getString("uranaidate"));
				halfform.setBirthday(rs.getString("birthday"));
				halfform.setOmikujicode(rs.getString("omikujicode"));
				halfform.setRenewaldate(rs.getString("renewaldate"));
				halfform.setRenewalwriter(rs.getString("renewalwriter"));
				halfform.setUnseiwriter(rs.getString("unseiwriter"));
				halfform.setUnseiwritedate(rs.getString("unseiwritedate"));
			}
			
			request.setAttribute("resultset", rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("success");
		
	}

}
