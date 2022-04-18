package omikuji;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class PercentForm extends ActionForm{
	
	protected List<PercentDTO> perresultlist;

	public List<PercentDTO> getPerresultlist() {
		return perresultlist;
	}

	public void setPerresultlist(List<PercentDTO> perresultlist) {
		this.perresultlist = perresultlist;
	}
}
