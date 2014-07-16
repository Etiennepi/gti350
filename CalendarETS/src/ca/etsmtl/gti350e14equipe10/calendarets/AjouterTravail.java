package ca.etsmtl.gti350e14equipe10.calendarets;

import java.util.GregorianCalendar;

import ca.etsmtl.gti350e14equipe10.calendarets.Calendrier.Travail;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AjouterTravail extends Activity { 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Activity ajouterTravailActivity = this;
		setContentView(R.layout.activity_ajouter_travail);
		
		Button btn = (Button) findViewById(R.id.ajouter_travail_bouton_enregistrer);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String notes = "";
				String titre = "";
				GregorianCalendar dateheure = (GregorianCalendar) GregorianCalendar.getInstance();
				
				Travail t = new Travail(titre, dateheure, notes);
				Calendrier.getInstance().ajouterTravail(t);
				
				Intent intent = new Intent(ajouterTravailActivity, VueSemaine.class);
				startActivity(intent);
			}
			
		});
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ajouter_travail, menu);
		return true;
	}
*/

}
