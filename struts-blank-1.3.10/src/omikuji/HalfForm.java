package omikuji;


import java.util.List;

import org.apache.struts.action.ActionForm;

public class HalfForm extends ActionForm{
	
	//결과값들을 저장하기 위한 List 만들기
	//結果値を保存するためのListを作る

	protected List<HalfDTO> hfresultlist;

	public void setHfresultlist(List<HalfDTO> hfresultlist) {
		this.hfresultlist = hfresultlist;
	}
	
	public List<HalfDTO> getHfresultlist() {
		return hfresultlist;
	}
}
