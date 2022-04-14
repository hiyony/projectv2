package omikuji;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SelectMenu extends Action{
	
	public ActionForward execute(ActionMapping mapping) {
		
		String birthday = InputForm.getBirthday();
		SelectForm.setBirthday(birthday);
		
		return mapping.findForward("success");
	}

}
