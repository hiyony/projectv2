package omikuji;

import org.apache.struts.action.ActionForm;

public class InputForm extends ActionForm{
	private static String birthday;
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public static String getBirthday() {
		return birthday;
	}
}
