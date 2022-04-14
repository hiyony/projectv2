package omikuji;


import java.util.List;

import org.apache.struts.action.ActionForm;

public class HalfForm extends ActionForm{

	protected List<HalfDTO> hfresultlist;

	public void setHfresultlist(List<HalfDTO> hfresultlist) {
		this.hfresultlist = hfresultlist;
	}
	
	public List<HalfDTO> getHfresultlist() {
		return hfresultlist;
	}
}
