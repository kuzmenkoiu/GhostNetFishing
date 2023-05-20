package gfn.model.entity;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "netz")
public class Netz implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int netzId;
	
	private String breitengrad;
	private String laengengrad;
	private String nameDesMelders;
	private String vornameDesMelders;
	private String groeße;
	private String telefonnummer;
	private String status;	
	
	@ManyToOne
	@JoinColumn(name="mitgliedId")
	private Mitglied mitgliedId;
	
	public Netz() {
	}

	public Netz(String breitengrad, String laengengrad, String nameDesMelders, String vornameDesMelders, String groeße,
			String telefonnummer, String status, Mitglied mitgliedId) {
		this.breitengrad = breitengrad;
		this.laengengrad = laengengrad;
		this.nameDesMelders = nameDesMelders;
		this.vornameDesMelders = vornameDesMelders;
		this.groeße = groeße;
		this.telefonnummer = telefonnummer;
		this.status = status;
		this.mitgliedId = mitgliedId;
	}

	public int getNetzID() {
		return netzId;
	}
	public void setNetzID(int netzId) {
		this.netzId = netzId;
	}

	public String getBreitengrad() {
		return breitengrad;
	}
	public void setBreitengrad(String breitengrad) {
		this.breitengrad = breitengrad;
	}

	public String getLaengengrad() {
		return laengengrad;
	}
	public void setLaengengrad(String laengengrad) {
		this.laengengrad = laengengrad;
	}

	public String getNameDesMelders() {
		return nameDesMelders;
	}
	public void setNameDesMelders(String nameDesMelders) {
		this.nameDesMelders = nameDesMelders;
	}

	public String getVornameDesMelders() {
		return vornameDesMelders;
	}
	public void setVornameDesMelders(String meldervornameDesMelders) {
		this.vornameDesMelders = meldervornameDesMelders;
	}

	public String getGroeße() {
		return groeße;
	}
	public void setGroeße(String groeße) {
		this.groeße = groeße;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Mitglied getMitglied() {
		return mitgliedId;
	}
	public void setMitglied(Mitglied mitgliedId) {
		this.mitgliedId = mitgliedId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Netz) {
			Netz n = (Netz) obj;
			if (n.getNetzID()==(this.netzId))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Netz [netzId=" + netzId + ", breitengrad=" + breitengrad + ", laengengrad=" + laengengrad
				+ ", nameDesMelders=" + nameDesMelders + ", vornameDesMelders=" + vornameDesMelders + ", groeße="
				+ groeße + ", telefonnummer=" + telefonnummer + ", status=" + status + ", mitgliedId=" + mitgliedId.toString() +"]";
	}
	
	
	
}
