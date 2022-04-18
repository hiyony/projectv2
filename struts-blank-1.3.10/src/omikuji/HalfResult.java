package omikuji;

import java.io.IOException;
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
import org.postgresql.util.PSQLException;

public class HalfResult extends Action{
	

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
			throws IOException, SQLException, RuntimeException{
		
		String birthday = request.getParameter("birthday");
		
		//SQL문으로 뽑아낸 결과를 담을 list 생성
		//
		List<HalfDTO> list = rslist(birthday);
		
		request.setAttribute("list", list);
		

		return mapping.findForward("success");
	}

	public List<HalfDTO> rslist(String birthday) throws IOException, PSQLException {
		
		List<HalfDTO> list = new ArrayList<HalfDTO>();

		try {
			
			Connection conn = DBUtil.getConnection();
			
			//SQL문을 작성해주고 WHERE 조건절의 변수에 birthday 지정
			//SQL文を作成してWHERE条件の変数にbirthdayを指定する
			
			//Dateデータのタイプの種類
			//1. date : yyyy/MM/dd
			//2. timestamp : yy/MM/dd hh:mm:ss
			//3. timestamp with timezone : yy/MM/dd hh:mm:ss +00:00
			//4. interval : 日の期間を保存するタイプ
			String select_sql = "SELECT * FROM public.unseiresult AS u "
					+ "WHERE (SELECT CAST(u.uranaidate AS date) AS uradate) BETWEEN CURRENT_TIMESTAMP - INTERVAL '6 months' AND CURRENT_TIMESTAMP "
					+ "AND birthday = ?"
					+ "ORDER BY u.uranaidate ASC";
			PreparedStatement pstmt = conn.prepareStatement(select_sql);
			pstmt.setString(1, birthday);
			
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet에 저장된 결과를 HalfDTO를 통해 받아주고, HalfDTO형의 List에 저장
			//ResultSetに保存している結果をHalfDTOを通じて受け入れて、HalfDTO型のListにaddする
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
			}
			
		} catch(RuntimeException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
	



















