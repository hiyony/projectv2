package omikuji;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HalfResult extends Action{
	

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		HalfForm halfform = (HalfForm) form;

		String birthday = InputForm.getBirthday();
		List<HalfDTO> list = rslist(birthday);
		
		halfform.setHfresultlist(list);
		request.setAttribute("list", list);
		
		
//		HalfForm hfform = (HalfForm) form;
//		List<HalfDTO> Halflist = new ArrayList<HalfDTO> ();
//		
//		try {
//			
//			Connection conn = DBUtil.getConnection();
//			String select_sql = "SELECT * from public.unseiresult u "
//			+ "WHERE (SELECT CAST(u.uranaidate AS date) AS uradate) "
//			+ "BETWEEN CURRENT_TIMESTAMP - INTERVAL '6 months' "
//			+ "AND CURRENT_TIMESTAMP "
//			+ "AND birthday = '?' "
//			+ "ORDER BY u.uranaidate ASC";
//			PreparedStatement pstmt = conn.prepareStatement(select_sql);
//			pstmt.setString(1, birthday);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Halflist.add(new HalfDTO(rs.getString("uranaidate"), rs.getString("birthday"), rs.getString("omikujicode"),
//						rs.getString("renewalwriter"), rs.getString("renewaldate"), rs.getString("unseiwriter"), rs.getString("unseiwritedate")));
//				hfform.setHfresultlist(Halflist);
//			}
//			

		return mapping.findForward("success");
	}

	public List<HalfDTO> rslist(String birthday) {
		
		List<HalfDTO> list = new ArrayList<HalfDTO>();
		System.out.println("hi1");
		
		try {
			
			Connection conn = DBUtil.getConnection();
			String select_sql = "SELECT * from public.unseiresult u "
					+ "WHERE (SELECT CAST(u.uranaidate AS date) AS uradate) BETWEEN CURRENT_TIMESTAMP - INTERVAL '6 months' AND CURRENT_TIMESTAMP "
					+ "AND birthday = '?' "
					+ "ORDER BY u.uranaidate ASC";
			PreparedStatement pstmt = conn.prepareStatement(select_sql);
			pstmt.setString(1, birthday);
			
			System.out.println("hi2");
			
			ResultSet rs = pstmt.executeQuery();
			
			
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
	



















