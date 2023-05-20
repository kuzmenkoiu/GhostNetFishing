package gfn.controller.beans;

import java.io.Serializable;
import java.util.List;

import gfn.model.beans.MitgliedBean;
import gfn.model.beans.NetzBean;
import gfn.model.entity.Mitglied;
import gfn.model.entity.Netz;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

@Named
@ViewScoped
public class MeineNetzeController implements Serializable {
	
	private static Mitglied mitglied = new Mitglied();
	private static Mitglied mitgliederId;
	
	
	public Mitglied getMitglied() {
		mitglied = MitgliedBean.getInstance().getUser();
		return mitglied;
	}
	
	public static Mitglied getMitgliedId() {
		List<Mitglied> prüfliste = MitgliedBean.getInstance().getMitglieder();
		for (Mitglied m : prüfliste) {
			if (m.equals(mitglied)) {
				mitgliederId = m;
			}
		}
		return mitgliederId;	
	}
	
	public List<Netz> getMeineListe() {
		return NetzBean.getInstance().getNetzeVar2();
	}
		
	
	public String zuNetzBearbeiten() {
		return "meinenetzebearbeiten.xhtml";
	}
	
	public String home() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "mitgliederbereich.xhtml";
	}
	
	public String bergen() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "bergeformular.xhtml";
	}
	
	public String netzanmeldungen() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "meinenetze.xhtml";
	}
}
