package omikuji;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HalfDTO implements Serializable{
	
	private String uranaidate;
	private String birthday;
	private String omikujicode;
	private String renewalwriter;
	private String renewaldate;
	private String unseiwriter;
	private String unseiwritedate;
	
	public HalfDTO() {
		super();
	}
	
	public HalfDTO(String uranaidate, String birthday, String omikujicode, String renewalwriter, String renewaldate, String unseiwriter, String unseiwritedate) {
		super();
		this.uranaidate = uranaidate;
		this.birthday = birthday;
		this.omikujicode = omikujicode;
		this.renewalwriter = renewalwriter;
		this.renewaldate = renewaldate;
		this.unseiwriter = unseiwriter;
		this.unseiwritedate = unseiwritedate;
	}
	
	public String getUranaidate() {
		return uranaidate;
	}
	
	public void setUranaidate(String uranaidate) {
		this.uranaidate = uranaidate;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getOmikujicode() {
		return omikujicode;
	}
	
	public void setOmikujicode(String omikujicode) {
		this.omikujicode = omikujicode;
	}
	
	public String getRenewalwriter() {
		return renewalwriter;
	}
	
	public void setRenewalwriter(String renewalwriter) {
		this.renewalwriter = renewalwriter;
	}
	
	public String getRenewaldate() {
		return renewaldate;
	}
	
	public void setRenewaldate(String renewaldate) {
		this.renewaldate = renewaldate;
	}
	
	public String getUnseiwriter() {
		return unseiwriter;
	}
	
	public void setUnseiwriter(String unseiwriter) {
		this.unseiwriter = unseiwriter;
	}
	
	public String getUnseiwritedate() {
		return unseiwritedate;
	}
	
	public void setUnseiwritedate(String unseiwritedate) {
		this.unseiwritedate = unseiwritedate;
	}
	
	public java.util.Date getUranai(){
		java.util.Date uranai = null;
		
		if(uranaidate == null || uranaidate.isEmpty()) {	
		} else {
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				return format.parse(uranaidate);			
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return uranai;
	}
	
	public java.util.Date getBday(){
		java.util.Date bday = null;
		
		if(birthday == null || birthday.isEmpty()) {	
		} else {
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				return format.parse(birthday);			
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return bday;
	}
	
	public java.util.Date getRndate(){
		java.util.Date rndate = null;
		
		if(renewaldate == null || renewaldate.isEmpty()) {	
		} else {
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				return format.parse(renewaldate);			
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return rndate;
	}
	
	public java.util.Date getUsdate(){
		java.util.Date usdate = null;
		
		if(unseiwritedate == null || unseiwritedate.isEmpty()) {	
		} else {
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				return format.parse(unseiwritedate);			
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return usdate;
	}
}







