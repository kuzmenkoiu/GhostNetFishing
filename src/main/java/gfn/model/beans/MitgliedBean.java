package gfn.model.beans;

import java.io.Serializable;
import java.util.List;

import gfn.controller.beans.LoginformularController;
import gfn.model.daos.MitgliedDAO;
import gfn.model.entity.Mitglied;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class MitgliedBean implements Serializable {
	
	private static MitgliedBean instance = new MitgliedBean();
	private Mitglied neuesMitglied = new Mitglied();
	private MitgliedDAO mitgliedDao = new MitgliedDAO();
	private Mitglied user;
	
	
	
	public MitgliedBean() {
	}
	
	public static MitgliedBean getInstance() {
		return instance;
	}

//-----------------------------------------------------------------------Datenübermittlung in Richtung Controller-------------------------------------------------------------------------------------------------------		
	
	public Mitglied getNeuesMitglied() {
		return neuesMitglied;
	}
	
	public List<Mitglied> getMitglieder() {
		return mitgliedDao.findAll();
	}	
	
	public Mitglied getUser() {
		this.user = LoginformularController.getAnmeldeinfo();
		return user;
	}		
	
//-----------------------------------------------------------------------Datenübermittlung in Richtung Datenbank--------------------------------------------------------------------------------------------------------
	
	public void saveNeuesMitglied() {
		mitgliedDao.create(getNeuesMitglied());
		neuesMitglied = new Mitglied();
	}
	
}
