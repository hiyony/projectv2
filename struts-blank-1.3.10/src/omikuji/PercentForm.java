package omikuji;

import org.apache.struts.action.ActionForm;

public class PercentForm extends ActionForm{
	protected static String unseiname;
	protected static String birthday;
	protected static Integer cnt;
	
	public static String getBirthday() {
		return birthday;
	}
	
	public static void setBirthday(String birthday) {
		PercentForm.birthday = birthday;
	}
	
	public static String getUnseiname() {
		return unseiname;
	}
	
	public static void setUnseiname(String unseiname) {
		PercentForm.unseiname = unseiname;
	}
	
	public static Integer getCnt() {
		return cnt;
	}
	
	public static void setCnt(Integer cnt) {
		PercentForm.cnt = cnt;
	}	
}
