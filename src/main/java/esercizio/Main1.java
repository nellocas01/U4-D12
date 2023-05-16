package esercizio;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.tools.javac.Main;

import dao.EventoDAO;
import utils.JpaUtil;

public class Main1 {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		logger.info("prova");
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
