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
			
			String count_sql = "SELECT DISTINCT f.unseicode, f.unseiname, r.cnt, r.per "
					+ "FROM (SELECT u.birthday, f.unseiname AS usname, COUNT(f.unseiname) AS cnt, "
								  + "ROUND((100 * COUNT(f.unseiname) / SUM(COUNT(f.unseiname)) OVER()::numeric), 2) AS per "
							+ "FROM omikujii o "
							+ "RIGHT OUTER JOIN fortunemaster f ON o.unseicode = f.unseicode "
							+ "RIGHT OUTER JOIN unseiresult u ON o.omikujicode = u.omikujicode "
							+ "WHERE birthday = ? "
							+ "GROUP BY u.birthday, f.unseiname, f.unseicode) AS r "
					+ "RIGHT OUTER JOIN fortunemaster f ON f.unseiname = r.usname "
					+ "ORDER BY f.unseicode ASC;";
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















