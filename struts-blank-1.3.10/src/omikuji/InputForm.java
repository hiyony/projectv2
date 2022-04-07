package omikuji;

import org.apache.struts.action.ActionForm;

public class InputForm extends ActionForm{
	private String birthday;
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthday() {
		return birthday;
	}
}
