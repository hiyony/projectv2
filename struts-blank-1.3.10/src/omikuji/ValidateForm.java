package omikuji;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class ValidateForm extends ValidatorForm{
	
	private String birthday;
	

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		Boolean checkbday = Checkbirthday.checkbday(birthday);
		
		if(checkbday.equals(false)) {
			errors.add("", new ActionMessage("errmsg.num", "Error! "));
		}
		
		return errors;
	}
}
