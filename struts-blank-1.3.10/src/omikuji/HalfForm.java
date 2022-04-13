package omikuji;


import java.util.List;

import org.apache.struts.action.ActionForm;

public class HalfForm extends ActionForm{
//	protected static String uranaidate;
//	protected static String birthday;
//	protected static String omikujicode;
//	protected static String renewalwriter;
//	protected static String renewaldate;
//	protected static String unseiwriter;
//	protected static String unseiwritedate;
	
	protected List<HalfDTO> hfresultlist;
	
	public void setHfresultlist(List<HalfDTO> hfresultlist) {
		this.hfresultlist = hfresultlist;
	}
	
	public List<HalfDTO> getHfresultlist() {
		return hfresultlist;
	}

//	public void setUranaidate(String uranaidate) {
//		HalfForm.uranaidate = uranaidate;
//	}
//	
//	public static String getUranaidate() {
//		return uranaidate;
//	}
//	
//	public void setBirthday(String birthday) {
//		HalfForm.birthday = birthday;
//	}
//	
//	public static String getBirthday() {
//		return birthday;
//	}
//	
//	public void setOmikujicode(String omikujicode) {
//		HalfForm.omikujicode = omikujicode;
//	}
//	
//	public static String getOmikujicode() {
//		return omikujicode;
//	}
//	
//	public void setRenewaldate(String renewaldate) {
//		HalfForm.renewaldate = renewaldate;
//	}
//	
//	public static String getRenewaldate() {
//		return renewaldate;
//	}
//	
//	public void setRenewalwriter(String renewalwriter) {
//		HalfForm.renewalwriter = renewalwriter;
//	}
//	
//	public static String getRenewalwriter() {
//		return renewalwriter;
//	}
//	
//	public void setUnseiwriter(String unseiwriter) {
//		HalfForm.unseiwriter = unseiwriter;
//	}
//	
//	public static String getUnseiwriter() {
//		return unseiwriter;
//	}
//	
//	public void setUnseiwritedate(String unseiwritedate) {
//		HalfForm.unseiwritedate = unseiwritedate;
//	}
//	
//	public static String getUnseiwritedate() {
//		return unseiwritedate;
//	}
}
