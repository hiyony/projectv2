package omikuji;

import java.text.SimpleDateFormat;

public class Checkbirthday {
	public static Boolean checkbday(String birthday) {
		while(true) {
			SimpleDateFormat datefp;
			
			try {
				datefp = new SimpleDateFormat("yyyyMMdd");
				datefp.setLenient(false);
				datefp.parse(birthday);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}
