package ca.etsmtl.gti350e14equipe10.calendarets;

import java.util.GregorianCalendar;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VueSemaine extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vue_semaine);

        GregorianCalendar dateCourante = (GregorianCalendar) GregorianCalendar.getInstance();

        
        int[] jours = { R.id.jour1_label, R.id.jour2_label, R.id.jour3_label , R.id.jour4_label , R.id.jour5_label , R.id.jour6_label, R.id.jour7_label  };
        
        for( int id : jours ) {
        	String jourCourant = dateCourante.getDisplayName(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.LONG, Locale.CANADA_FRENCH);
            TextView label = (TextView) findViewById(id);
            label.setText(jourCourant);
        	
            dateCourante.add(GregorianCalendar.HOUR, 24);
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vue_semaine, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
    	Intent intent = null;
    	
        switch (item.getItemId()) {
            case R.id.action_ajouter_changementhoraire:
                intent = new Intent(this, AjouterChangementHorraire.class);
                break;
            case R.id.action_ajouter_cours:
                intent = new Intent(this, AjouterCour.class);
                break;
            case R.id.action_ajouter_examen:
                // composeMessage();
                return true;
            case R.id.action_ajouter_travaux:
            	intent = new Intent(this, AjouterTravail.class);
            	break;
        }
        if( intent != null ) {
        	startActivity(intent);
        	return true;
        }
        else {
        	return super.onOptionsItemSelected(item);
        }
    }
    
    public class VueJour extends LinearLayout {

		public VueJour(Context context, AttributeSet attrs) {
			super(context, attrs);
		}
    	
    	
    }
}
