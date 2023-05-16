package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.Evento;

public class EventoDAO {

	private final EntityManager em;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Evento one) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(one);
		transaction.commit();
		System.out.println("evento salvato");
	}

	public Evento getById(long id) {
		Evento found = em.find(Evento.class, id);
		return found;
	}

	public void delete(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("evento con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
}
