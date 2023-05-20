package gfn.model.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import gfn.model.entity.Mitglied;

public class MitgliedDAO {
	
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	
	public void create(Mitglied mitgliedobjekt) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		em.merge(mitgliedobjekt);
		em.flush();
		t.commit();
		em.close();
	}
	
	public List<Mitglied> findAll() {
		EntityManager em = emf.createEntityManager();
		Query abfrage = em.createQuery("select a from Mitglied as a");
		List<Mitglied> alleMitglieder = abfrage.getResultList();
		em.close();
		return alleMitglieder;
	}

}
