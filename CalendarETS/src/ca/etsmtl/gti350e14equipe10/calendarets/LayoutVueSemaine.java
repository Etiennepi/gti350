package ca.etsmtl.gti350e14equipe10.calendarets;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.etsmtl.gti350e14equipe10.calendarets.Calendrier.ChangementHorraire;
import ca.etsmtl.gti350e14equipe10.calendarets.Calendrier.Cour;
import ca.etsmtl.gti350e14equipe10.calendarets.Calendrier.Travail;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class LayoutVueSemaine extends TableLayout {

	public LayoutVueSemaine(Context context, AttributeSet attrs) {
		super(context, attrs);

		final GregorianCalendar dateInitiale = (GregorianCalendar) GregorianCalendar.getInstance();
		GregorianCalendar dateCourante = (GregorianCalendar) GregorianCalendar.getInstance();
		final int MAX_HEURES = 24;
		final int MAX_JOURS = 7;
		final int DAY_COLUMN_WIDTH = 100;
		final int TIME_COLUMN_WIDTH = 80;
		
		final int[] COULEUR_COURS = {
				Color.argb(50, 190, 214, 97),
				Color.argb(50, 137, 232, 148),
				Color.argb(50, 120, 213, 227),
				Color.argb(50, 122, 245, 245),
				Color.argb(50, 52, 221, 221),
				Color.argb(50, 147, 226, 213)
		};

        int i;

        TableRow rowDates = new TableRow(context);
        TableRow rowJours = new TableRow(context);
        TextView[][] plagesHoraires = new TextView[MAX_JOURS][MAX_HEURES];
        rowDates.addView(new TextView(context));
        rowJours.addView(new TextView(context));
        this.addView(rowJours);
        this.addView(rowDates);
        
        // Initialize les rangees qui donnent les heures
        TableRow[] rows = new TableRow[MAX_HEURES];
        for(i=0; i<MAX_HEURES; i++) {
        	TableRow row = new TableRow(context);
        	this.addView(row);

        	rows[i] = row;
        	TextView heure = new TextView(context);
        	heure.setText(Integer.toString(i) + ":00");
        	heure.setWidth(TIME_COLUMN_WIDTH);

        	row.addView(heure);
        	
        }

        // initialize les jours
        for(i=0; i<MAX_JOURS; i++) {
        	//String jourCourant = dateCourante.getDisplayName(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.LONG, Locale.CANADA_FRENCH);
        	//jourCourant = new StringBuilder().append(jourCourant).append(" ").append(dateCourante.get(GregorianCalendar.DAY_OF_MONTH)).append(' ').append(dateCourante.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.SHORT, Locale.CANADA_FRENCH)).toString();

        	TextView labelJour = new TextView(context);
        	TextView labelDate = new TextView(context);
        	
        	rowJours.addView(labelJour);
        	rowDates.addView(labelDate);

        	labelJour.setText(dateCourante.getDisplayName(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.LONG, Locale.CANADA_FRENCH));
        	labelJour.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            labelJour.setWidth(DAY_COLUMN_WIDTH);
            
            labelDate.setText(new StringBuilder().append(dateCourante.get(GregorianCalendar.DAY_OF_MONTH)).append(' ').append(dateCourante.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.SHORT, Locale.CANADA_FRENCH)).toString());
            labelDate.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            labelDate.setWidth(DAY_COLUMN_WIDTH);
        	
            
            for(int j=0; j<MAX_HEURES; j++) {
            	TextView heure = new TextView(context);
            	rows[j].addView(heure);
            	plagesHoraires[i][j] = heure;
            }
            
            dateCourante.add(GregorianCalendar.HOUR, 24);
        }
        
        // afficher les cours
        dateCourante = (GregorianCalendar) GregorianCalendar.getInstance();
        for(i=0; i<MAX_JOURS; i++) {
        	
        	for(Travail travail : Calendrier.getInstance().getTravaux() ) {
        		GregorianCalendar remise = travail.getDatetime();
        		int anneeA = remise.get(GregorianCalendar.YEAR);
        		int anneeB = dateCourante.get(GregorianCalendar.YEAR);
        		int moisA = remise.get(GregorianCalendar.MONTH);
        		int moisB = dateCourante.get(GregorianCalendar.MONTH);
        		int jourA = remise.get(GregorianCalendar.DAY_OF_MONTH);
        		int jourB = dateCourante.get(GregorianCalendar.DAY_OF_MONTH);
        		
        		if( anneeA == anneeB && moisA == moisB && jourA == jourB ) {
        			plagesHoraires[i][remise.get(GregorianCalendar.HOUR_OF_DAY)].append(travail.getTitre());
        		}
        		
        	}
        	
        	
        	String journee = dateCourante.getDisplayName(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.LONG, Locale.CANADA_FRENCH).toLowerCase(Locale.CANADA_FRENCH);
        	
        	// considerer les changements d'horaire
        	for( ChangementHorraire changement : Calendrier.getInstance().getChangementsHoraires() ) {
        		GregorianCalendar dateDeChangement = changement.getDatetime();
        		int anneeA = dateDeChangement.get(GregorianCalendar.YEAR);
        		int anneeB = dateCourante.get(GregorianCalendar.YEAR);
        		int moisA = dateDeChangement.get(GregorianCalendar.MONTH);
        		int moisB = dateCourante.get(GregorianCalendar.MONTH);
        		int jourA = dateDeChangement.get(GregorianCalendar.DAY_OF_MONTH);
        		int jourB = dateCourante.get(GregorianCalendar.DAY_OF_MONTH);
        		
        		if( anneeA == anneeB && moisA == moisB && jourA == jourB ) {
        			journee = changement.getJournee().toLowerCase(Locale.CANADA_FRENCH);
        			// plagesHoraires[i][remise.get(GregorianCalendar.HOUR_OF_DAY)].append(travail.getTitre());
        		}
        	}
        	
        	int idCours = 0;
        	for(Cour cour : Calendrier.getInstance().getCours()) {
        		if( cour.getJournee().toLowerCase(Locale.CANADA_FRENCH).equals(journee)) {
        			int heureDebut = parseHeure(cour.getHeureDebut());
        			int heureFin = parseHeure(cour.getHeureFin());
        			
        			String infoCours = new StringBuilder().append(cour.getTitre()).append('\n').append(cour.getLocal()).toString();
        			
        			plagesHoraires[i][heureDebut].append(infoCours);
        			
        			if( heureDebut >= 0 && heureFin >= heureDebut ) {
        				for(int k=heureDebut; k<=heureFin && k<MAX_HEURES; k++) {
        					plagesHoraires[i][k].setBackgroundColor(COULEUR_COURS[idCours % COULEUR_COURS.length]);
        				}
        			}
        		}
        		idCours++;
        	}
        	
        	
        	
        	dateCourante.add(GregorianCalendar.HOUR, 24);
        }
	}

	private static int parseHeure(String heure) {
		Pattern p = Pattern.compile("^(\\d\\d?):(\\d\\d?)$");
		Matcher m = p.matcher(heure);
		if( m.matches() ) {
			return Integer.parseInt(m.group(1));
		}
		return -1;
	}
}