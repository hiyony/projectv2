package omikuji;

import org.apache.struts.action.ActionForm;

public class ResultForm extends ActionForm{
	protected static String unsei;
	protected static String negaigoto;
	protected static String akinai;
	protected static String gakumon;
	protected String omikujicode;
	
	public void setUnsei() {
		
	}
	
	public static String getUnsei() {
		return unsei;
	}
	
	public void setUnsei(String unsei) {
		ResultForm.unsei = unsei;
	}
	
	public static String getNegaigoto() {
		return negaigoto;
	}
	
	public void setNegaigoto(String negaigoto) {
		ResultForm.negaigoto = negaigoto;
	}
	
	public static String getAkinai() {
		return akinai;
	}
	
	public void setAkinai(String akinai) {
		ResultForm.akinai = akinai;
	}
	
	public static String getGakumon() {
		return gakumon;
	}
	
	public void setGakumon(String gakumon) {
		ResultForm.gakumon = gakumon;
	}
}
