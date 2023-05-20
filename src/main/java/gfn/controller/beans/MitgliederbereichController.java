package gfn.controller.beans;

import java.io.Serializable;
import java.util.List;

import gfn.model.beans.NetzBean;
import gfn.model.entity.Netz;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

@Named
@ViewScoped
public class MitgliederbereichController implements Serializable {

//-----------------------------------------------------------------------Datenaustausch zwischen View und Controller-------------------------------------------------------------------------------------------------------		
	
	public List<Netz> getNetzliste() {
		return NetzBean.getInstance().getNetzeVar3();
	}

//-----------------------------------------------------------------------Methoden zur Navigation---------------------------------------------------------------------------------------------------------------------------	
	
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
	
	public String ausloggen() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "startseite.xhtml";
	}
	
}
