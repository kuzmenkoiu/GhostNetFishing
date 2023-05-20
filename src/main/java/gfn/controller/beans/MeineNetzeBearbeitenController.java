package gfn.controller.beans;

import java.io.Serializable;
import java.util.List;


import gfn.model.beans.NetzBean;
import gfn.model.entity.Netz;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MeineNetzeBearbeitenController implements Serializable {
	
	private static Netz netz = new Netz();
	private static Netz netzId;
	
	public Netz getNetz() {	
		return netz;
	}
	
	public static Netz getIndex() {
		List<Netz> prüfliste = NetzBean.getInstance().getNetzeVar4();
		for (Netz n : prüfliste) {
			if (n.equals(netz)) {
				netzId = n;
				netzId.setStatus(netz.getStatus());
			}
		}	
		return netzId;
	}
	
	public String zurueckZuHome() {
		return "mitgliederbereich.xhtml";
	}
	
	public String netzUpdate() {
		NetzBean.getInstance().updateNetzVar2();
		return "mitgliederbereich.xhtml";
	}

}
