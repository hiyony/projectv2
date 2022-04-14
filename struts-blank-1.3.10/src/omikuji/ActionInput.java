package omikuji;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class ActionInput extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset = UTF-8");
		
		InputForm inputform = (InputForm) form;
		inputform.setBirthday(request.getParameter("birthday"));
		
		String button = request.getParameter("btn");
		String birthday = InputForm.getBirthday();
		Boolean checkbday = Checkbirthday.checkbday(birthday);
		request.setAttribute("birthday", birthday);

		if(button.equals("click1")) {
			return mapping.findForward("test1");
		} else if(button.equals("click2")) {
			return mapping.findForward("test2");
		} else {
			if(checkbday.equals(true)) {
				return mapping.findForward("success");
			} else {
				//request.setAttribute("msg", "入力された形式が正しくありません。yyyyMMdd形式の８文字でお願いします。");
				ActionMessages errors = new ActionMessages();
				errors.add("errmsg.1", new ActionMessage("errmsg.num","ERROR!"));
				saveMessages(request, errors);
					
				return mapping.findForward("fail");
			}
		}
	}

}
