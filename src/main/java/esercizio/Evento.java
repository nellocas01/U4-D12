package esercizio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "gestioneventi")
@Getter
@Setter
@ToString

public class Evento {

	@Id
	@GeneratedValue // Obbligatorio usarlo se si vuol fare gestire gli id al db
	// private UUID id;
	private long id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	private String tipoEvento; // [pubblico, privato]
	private int numeroMassimoPartecipanti;

	public Evento() {
	}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, String tipoEvento,
			int numeroMassimoPartecipanti) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}
}
