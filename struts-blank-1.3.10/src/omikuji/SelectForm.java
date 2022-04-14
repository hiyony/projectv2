package omikuji;

import org.apache.struts.action.ActionForm;

public class SelectForm extends ActionForm{
	
	protected static String birthday;

	public static String getBirthday() {
		return birthday;
	}

	public static void setBirthday(String birthday) {
		SelectForm.birthday = birthday;
	}

}
