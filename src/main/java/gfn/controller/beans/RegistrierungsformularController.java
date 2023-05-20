package gfn.controller.beans;

import java.io.Serializable;

import gfn.model.beans.MitgliedBean;
import gfn.model.entity.Mitglied;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class RegistrierungsformularController implements Serializable {
	
//-----------------------------------------------------------------------Datenaustausch zwischen View und Controller-------------------------------------------------------------------------------------------------------		

	public Mitglied getMitglied() {
		return MitgliedBean.getInstance().getNeuesMitglied();
	}

//-----------------------------------------------------------------------Methoden zum Senden von Benutzereingaben----------------------------------------------------------------------------------------------------------		
	
	public String speichern() {
		MitgliedBean.getInstance().saveNeuesMitglied();
		return "startseite.xhtml";
	}

//-----------------------------------------------------------------------Methoden zur Navigation---------------------------------------------------------------------------------------------------------------------------	
	
	public String zurueckZurStartseite() {
		return "startseite.xhtml";
	}
}
