package esercizio;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDAO;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Main1 {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);

		// ************************ SAVE *********************
		Evento one = new Evento("Buon Compleanno", LocalDate.now(), "18esimo compleanno", "disco", 50);
		ed.save(one);

		// ************************ FIND BY ID *********************

		System.out.println(ed.getById(0));

		// ************************ DELETE *********************
		ed.delete(0);

		// ************************ REFRESH ********************
		ed.refresh(7);
		em.close();

		emf.close();
	}

}
