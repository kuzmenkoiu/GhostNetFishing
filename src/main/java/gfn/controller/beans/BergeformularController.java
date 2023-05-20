package gfn.controller.beans;

import java.io.Serializable;
import java.util.List;

import gfn.model.beans.NetzBean;
import gfn.model.beans.MitgliedBean;
import gfn.model.entity.Mitglied;
import gfn.model.entity.Netz;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

@Named
@ViewScoped
public class BergeformularController implements Serializable {
	
	private static Netz netz = new Netz();
	private static Mitglied mitglied = new Mitglied();
	private static Netz netzId;
	private static Mitglied mitgliederId;
	private Netz ausgabe;
	
	@Inject
	private MitgliedBean user;

//-----------------------------------------------------------------------Datenaustausch zwischen View und Controller-------------------------------------------------------------------------------------------------------		

	public Netz getNetz() {
		netz.setNetzID(0);		
		return netz;
	}

	public Netz getNetzdaten() {
		ausgabe = BergeformularController.getIndex();
		if(netz.getNetzID() == 0) {
			netz.setBreitengrad("Bitte NetzID wählen!");
			netz.setLaengengrad("Bitte NetzID wählen!");
			netz.setGroeße("Bitte NetzID wählen!");
			return netz;
		}
		return ausgabe;
	}
	
	public Mitglied getMitglied() {
		mitglied = MitgliedBean.getInstance().getUser();
		return mitglied;
	}

//-----------------------------------------------------------------------Datenaustausch zwischen Controller und Model-------------------------------------------------------------------------------------------------------		

	public static Netz getIndex() {
		List<Netz> prüfliste = NetzBean.getInstance().getNetzeVar1();
		for (Netz n : prüfliste) {
			if (n.equals(netz)) {
				netzId = n;
			}
		}	
		return netzId;
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
	
	public List<Netz> getNetzliste() {
		return NetzBean.getInstance().getNetzeVar1();
	}	

//-----------------------------------------------------------------------Methoden zum Senden von Benutzereingaben----------------------------------------------------------------------------------------------------------		

	public String netzUpdate() {
		NetzBean.getInstance().updateNetzVar1();
		return "mitgliederbereich.xhtml";
	}

//-----------------------------------------------------------------------Methoden zur Navigation---------------------------------------------------------------------------------------------------------------------------	
	
	public String zumBergeformular() {
		return "bergeformular2.xhtml";
	}
	
	public String zurueckZuHome() {
		return "mitgliederbereich.xhtml";
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
