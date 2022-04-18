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

public class PercentResult extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		String birthday = request.getParameter("birthday");
		List<PercentDTO> list = perlist(birthday);
		
		request.setAttribute("list", list);
		
		return mapping.findForward("success");
		
	}
	
	public List<PercentDTO> perlist(String birthday){
		
		List<PercentDTO> list = new ArrayList<PercentDTO> ();
		
		try {
			
			Connection conn = DBUtil.getConnection();
			
			//운세명과 각각의 운세 개수, 운세의 비율을 위한 SQL문 작성
			//    →(ROUND() 구문 : , SUM() OVER() 구문 : 누적 합)
			//運勢名、それぞれの運勢数、運勢の割合のためのSQL文を作成
			
			String count_sql = "SELECT g1.unseiname AS unseiname, "
									+ "COUNT(g1.unseiname) AS cnt,"
									+ "ROUND((100 * COUNT(g1.unseiname) / SUM(COUNT(g1.unseiname)) OVER()::numeric), 2) AS per "
					+ "FROM public.unseiresult u "
					+ "JOIN (SELECT o.omikujicode AS omkjcode, f.unseicode AS code, f.unseiname AS unseiname "
							+ "FROM public.fortunemaster f "
							+ "RIGHT OUTER JOIN public.omikujii o "
							+ "ON f.unseicode = o.unseicode) AS g1 "
					+ "ON u.omikujicode = g1.omkjcode "
					+ "WHERE birthday = ? "
					+ "GROUP BY g1.unseiname, g1.code "
					+ "ORDER BY g1.code asc";
			PreparedStatement pstmt2 = conn.prepareStatement(count_sql);
			pstmt2.setString(1, birthday);
			
			ResultSet rs2 = pstmt2.executeQuery();
			
			while(rs2.next()) {
				PercentDTO perdto = new PercentDTO();
				
				perdto.setUnseiname(rs2.getString("unseiname"));
				perdto.setCnt(rs2.getInt("cnt"));
				perdto.setPer(rs2.getInt("per"));
				list.add(perdto);
				
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		return list;
		
	}
}















