package ca.etsmtl.gti350e14equipe10.calendarets;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public final class Calendrier {

	private final List<Travail> travaux;
	private final List<ChangementHorraire> changementHorraire;
	private final List<Cour> cours;
	
	private Calendrier() {
		travaux = new ArrayList<Travail>();
		changementHorraire = new ArrayList<ChangementHorraire>();
		cours = new ArrayList<Cour>();
	}
	
	public void ajouterTravail(Travail t) {
		this.travaux.add(t);
	}
	
	public void ajouterChangementHorraire(ChangementHorraire c) {
		this.changementHorraire.add(c);
	}
	
	public void ajouterCour(Cour c) {
		this.cours.add(c);
	}
	
	public Iterator<Travail> getTravaux() {
		return this.travaux.iterator();
	}
	
	public Iterator<Cour> getCours() {
		return this.cours.iterator();
	}
	
	public Iterator<ChangementHorraire> getChangementsHoraires() {
		return this.changementHorraire.iterator();
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
	
	public static final class ChangementHorraire {
		private String titre;
		private GregorianCalendar datetime;
		private String journee;
		
		public ChangementHorraire(String titre, GregorianCalendar datetime, String journee) {
			super();
			this.titre = titre;
			this.datetime = datetime;
			this.journee = journee;
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
		
		public String getJournee() {
			return journee;
		}
		
		public void setJournee(String journee) {
			this.journee = journee;
		}
	}
	
	public static final class Cour {
		
		private String titre;
		private String journee;
		private String local;
		private String heureDebut;
		private String heureFin;
		
		public Cour(String titre, String journee, String local, String heureDebut, String heureFin){
			super();
			this.titre = titre;
			this.journee = journee;
			this.local = local;
			this.heureDebut = heureDebut;
			this.heureFin = heureFin;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getJournee() {
			return journee;
		}

		public void setJournee(String journee) {
			this.journee = journee;
		}

		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}

		public String getHeureDebut() {
			return heureDebut;
		}

		public void setHeureDebut(String heureDebut) {
			this.heureDebut = heureDebut;
		}

		public String getHeureFin() {
			return heureFin;
		}

		public void setHeureFin(String heureFin) {
			this.heureFin = heureFin;
		}
		
	}
	
	private static final Calendrier singleton = new Calendrier();

	public static Calendrier getInstance() {
		return singleton;
	}
}
