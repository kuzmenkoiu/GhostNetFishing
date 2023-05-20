package gfn.model.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import gfn.model.beans.NetzBean;
import gfn.model.entity.Mitglied;
import gfn.model.entity.Netz;

public class NetzDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	
	public void create(Netz netzobjekt) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		em.merge(netzobjekt);
		em.flush();
		t.commit();
		em.close();
	}
	
	public List<Netz> findAll() {
		EntityManager em = emf.createEntityManager();
		Query abfrage = em.createQuery("select a from Netz as a");
		List<Netz> alleNetze = abfrage.getResultList();
		em.close();
		return alleNetze;
	}
	
	public List<Netz> findGemeldet() {
		EntityManager em = emf.createEntityManager();
		Query abfrage = em.createQuery("select a from Netz as a where a.status='gemeldet'");
		List<Netz> alleNetze = abfrage.getResultList();
		em.close();
		return alleNetze;
	}
	
	public List<Netz> findMeineNetze() {
		Netz fremdschlüssel = NetzBean.getInstance().getNetzwerte();
		Mitglied fknr = fremdschlüssel.getMitglied();
		EntityManager em = emf.createEntityManager();
		Query abfrage = em.createQuery("select a from Netz as a where a.mitgliedId='" + fknr.getMitgliedId() + "'");
		List<Netz> alleNetze = abfrage.getResultList();
		em.close();
		return alleNetze;
	}
	
	public List<Netz> findInBergung() {
		EntityManager em = emf.createEntityManager();
		Query abfrage = em.createQuery("select a from Netz as a where a.status='Bergung bevorstehend'");
		List<Netz> alleNetze = abfrage.getResultList();
		em.close();
		return alleNetze;
	}
}
