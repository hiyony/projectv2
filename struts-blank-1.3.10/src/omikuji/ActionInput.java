package omikuji;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionInput extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
//		response.setContentType("text/html; charset = UTF-8");
		
		//InputForm으로부터 생일 파라미터 받아오기
		//InputFormから誕生日を受け入れる
		ValidateForm validateform = (ValidateForm) form;
		validateform.setBirthday(request.getParameter("birthday"));
		
		//생일을 String으로 저장
		//誕生日を受け取れて新しいString型の変数で保存
		String birthday = validateform.getBirthday();
//		Boolean checkbday = Checkbirthday.checkbday(birthday);
		request.setAttribute("birthday", birthday);

		//입력받은 생일이 올바른지 체크, 올바를 경우 OmkjResult.jsp로 이둉(success)
		//入力された誕生日が合ってるかをチェックして、会っている場合はOmkjResult.jspへ移動(success)
//		if(checkbday.equals(true)) {
			return mapping.findForward("success");
//		} else {
			
			//그 외의 경우 에러메세지 출력
			//他の場合はエラーメッセージを出力する
//			ActionMessages errors = new ActionMessages();
//			errors.add("errmsg.1", new ActionMessage("errmsg.num","ERROR!"));
//			saveMessages(request, errors);
//			
//			return mapping.findForward("fail");
//		}
		
	}

}
