package gfn.model.entity;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mitglied")
public class Mitglied implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mitgliedId;
	
	private String mitgliedName;
	private String mitgliedVorname;
	private String email;
	private String mitgliedTelefonnummer;
	private String passwort;	
	
	public Mitglied() {
	}
	
	public Mitglied(String email2, String value) {
		this.setEmail(email2);
		this.setPasswort(value);
	}
	
	public Mitglied(String mitgliedName, String mitgliedVorname, String email, String mitgliedTelefonnummer, String passwort) {
		this.setMitgliedName(mitgliedName);
		this.setMitgliedVorname(mitgliedVorname);
		this.setEmail(email);
		this.setMitgliedTelefonnummer(mitgliedTelefonnummer);
		this.setPasswort(passwort);
	}
	
	public int getMitgliedId() {
		return mitgliedId;
	}
	public void setMitgliedId(int mitgliedId) {
		this.mitgliedId = mitgliedId;
	}
	
	public String getMitgliedName() {
		return mitgliedName;
	}
	public void setMitgliedName(String mitgliedName) {
		this.mitgliedName = mitgliedName;
	}

	public String getMitgliedVorname() {
		return mitgliedVorname;
	}
	public void setMitgliedVorname(String mitgliedVorname) {
		this.mitgliedVorname = mitgliedVorname;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMitgliedTelefonnummer() {
		return mitgliedTelefonnummer;
	}
	public void setMitgliedTelefonnummer(String mitgliedTelefonnummer) {
		this.mitgliedTelefonnummer = mitgliedTelefonnummer;
	}

	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Mitglied) {
			Mitglied m = (Mitglied) obj;
			if (m.getEmail().equals(this.email) && m.getPasswort().equals(this.passwort))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Mitglied [mitgliedId=" + mitgliedId + "]";
	}
	
	
}
