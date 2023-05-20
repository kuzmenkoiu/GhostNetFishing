package gfn.controller.beans;

import java.io.Serializable;
import java.util.List;

import gfn.model.beans.MitgliedBean;
import gfn.model.entity.Mitglied;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.event.PostValidateEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LoginformularController implements Serializable {
	
	private String email;
	private static Mitglied mitglied = new Mitglied();
	private static Mitglied anmeldeinfo = new Mitglied();

//-----------------------------------------------------------------------Datenaustausch zwischen View und Controller-------------------------------------------------------------------------------------------------------		
	
	public Mitglied getMitglied() {
		return mitglied;
	}

//-----------------------------------------------------------------------Datenaustausch zwischen Controller und Model-------------------------------------------------------------------------------------------------------		
	
	public static Mitglied getAnmeldeinfo() {
		anmeldeinfo = mitglied;
		return anmeldeinfo;
	}

//-----------------------------------------------------------------------Methoden zur Navigation---------------------------------------------------------------------------------------------------------------------------	
	
	public String login() {
		List<Mitglied> prüfliste = MitgliedBean.getInstance().getMitglieder();
		for (Mitglied m : prüfliste) {
			if (m.equals(this.mitglied)) {
				return "mitgliederbereich.xhtml";
			}
		}
		return "loginformular.xhtml";	
	}
	
	public String zurueckZurStartseite() {
		return "startseite.xhtml";
	}
	
//-----------------------------------------------------------------------Methoden zur Validierung---------------------------------------------------------------------------------------------------------------------------	
	
	public void postValidateMail(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput)ev.getComponent();
		this.email = (String)temp.getValue();
	}
	
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		List<Mitglied> prüfliste = MitgliedBean.getInstance().getMitglieder();
		for (Mitglied m : prüfliste) {
			Mitglied temp = new Mitglied(this.email, (String) value);
			if(m.equals(temp))
				return;
		}
		throw new ValidatorException(new FacesMessage("E-Mail oder Passwort falsch!!!"));
	}
	
	
}
