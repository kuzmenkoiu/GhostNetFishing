package gfn.model.beans;

import java.io.Serializable;
import java.util.List;

import gfn.controller.beans.BergeformularController;
import gfn.controller.beans.MeineNetzeBearbeitenController;
import gfn.controller.beans.MeineNetzeController;
import gfn.model.daos.NetzDAO;
import gfn.model.entity.Mitglied;
import gfn.model.entity.Netz;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Named;

@Named
@ApplicationScoped
public class NetzBean implements Serializable {
	
	private static NetzBean instance = new NetzBean();
	private Netz neuesNetz = new Netz("","","","","","","gemeldet", null);
	private Netz gesuchtesNetz = new Netz();
	private NetzDAO netzDao = new NetzDAO();
	private Mitglied gesuchtesMitglied;
	
	public NetzBean() {
	}
	
	public static NetzBean getInstance() {
		return instance;
	}

//-----------------------------------------------------------------------Datenübermittlung in Richtung Controller-------------------------------------------------------------------------------------------------------		
	
	public Netz getNeuesNetz() {
		return neuesNetz;
	}
	
	public List<Netz> getNetzeVar1() {
		return netzDao.findGemeldet();
	}
	
	public List<Netz> getNetzeVar2() {
		return netzDao.findMeineNetze();
	}
	
	public List<Netz> getNetzeVar3() {
		return netzDao.findInBergung();
	}
	
	public List<Netz> getNetzeVar4() {
		return netzDao.findAll();
	}
	
//-----------------------------------------------------------------------Datenverarbeitung------------------------------------------------------------------------------------------------------------------------------
	
	public Netz getNetzinformationAnpassenVar1() {
		gesuchtesNetz = BergeformularController.getIndex();
		gesuchtesMitglied = BergeformularController.getMitgliedId();
		gesuchtesNetz.setStatus("Bergung bevorstehend");
		gesuchtesNetz.setMitglied(gesuchtesMitglied);
		return gesuchtesNetz;
	}
	
	public Netz getNetzinformationAnpassenVar2() {
		gesuchtesNetz = MeineNetzeBearbeitenController.getIndex();
		Netz vergleichswert = new Netz();
		vergleichswert.setStatus("gemeldet");
		if(gesuchtesNetz.getStatus().equals(vergleichswert.getStatus())) {
			gesuchtesNetz.setMitglied(null);
			return gesuchtesNetz;
		}
		return gesuchtesNetz;
	}
	
	public Netz getNetzwerte() {
		Mitglied mitglied = MeineNetzeController.getMitgliedId();
		gesuchtesNetz.setMitglied(mitglied);
		return gesuchtesNetz;
	}

//-----------------------------------------------------------------------Datenübermittlung in Richtung Datenbank--------------------------------------------------------------------------------------------------------
	
	
	public void saveNeuesNetz() {
		if (neuesNetz.getTelefonnummer() == "") {
				neuesNetz.setTelefonnummer("anonym");
			} 
		netzDao.create(getNeuesNetz());		
	}
	
	public void updateNetzVar1() { 
		netzDao.create(getNetzinformationAnpassenVar1());		
	}
	
	public void updateNetzVar2() { 
		netzDao.create(getNetzinformationAnpassenVar2());		
	}

}
