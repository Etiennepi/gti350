package ca.etsmtl.gti350e14equipe10.calendarets;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public final class Calendrier {

	private final List<Travail> travaux;
	
	private Calendrier() {
		travaux = new ArrayList<Travail>();
	}
	
	public void ajouterTravail(Travail t) {
		this.travaux.add(t);
	}
	
	public static final class Travail {
		private String notes;
		private String titre;
		private GregorianCalendar datetime;

		public Travail(String titre, GregorianCalendar datetime, String notes) {
			super();
			this.notes = notes;
			this.titre = titre;
			this.datetime = datetime;
		}
		
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public GregorianCalendar getDatetime() {
			return datetime;
		}
		public void setDatetime(GregorianCalendar datetime) {
			this.datetime = datetime;
		}
		
	}
	
	private static final Calendrier singleton = new Calendrier();

	public static Calendrier getInstance() {
		return singleton;
	}
}
