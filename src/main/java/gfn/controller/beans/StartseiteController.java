package gfn.controller.beans;
import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class StartseiteController implements Serializable {
	
	public String zumMelden() {
		return "meldeformular.xhtml";
	}
	
	public String zumRegistrieren() {
		return "registrierungsformular.xhtml";
	}
	
	public String zumAnmelden() {
		return "loginformular.xhtml";
	}

}
