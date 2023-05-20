package gfn.controller.beans;

import java.io.Serializable;

import gfn.model.beans.NetzBean;
import gfn.model.entity.Netz;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MeldeformularController implements Serializable {

//-----------------------------------------------------------------------Datenaustausch zwischen View und Controller-------------------------------------------------------------------------------------------------------		
	
	public Netz getNetz() {
		return NetzBean.getInstance().getNeuesNetz();
	}

//-----------------------------------------------------------------------Methoden zum Senden von Benutzereingaben----------------------------------------------------------------------------------------------------------		

	public String speichern() {
		NetzBean.getInstance().saveNeuesNetz();
		return "startseite.xhtml";
	}

//-----------------------------------------------------------------------Methoden zur Navigation---------------------------------------------------------------------------------------------------------------------------	
		
	public String zurueckZurStartseite() {
		return "startseite.xhtml";
	}
	
}
