package ca.etsmtl.gti350e14equipe10.calendarets;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

public class AjouterCour extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Activity ajouterCourActivity = this;
		setContentView(R.layout.activity_ajouter_cours);
		
		//Rendre le spinner fonctionnel et y ajouter les journees
		Spinner spinner = (Spinner) findViewById(R.id.ajouterCourJourSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.jour_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		Button btn = (Button) findViewById(R.id.ajouter_cour_bouton_enregistrer);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				
				Intent intent = new Intent(ajouterCourActivity, VueSemaine.class);
				startActivity(intent);
			}
			
		});
	}
	
	public void showDebutTimePickerDialog(View v) {
		DebutTimePickFragment newFragment = new DebutTimePickFragment();
	    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
	    newFragment.show(fm, "timePicker");
	}
	
	public void showFinTimePickerDialog(View v) {
		FinTimePickFragment newFragment = new FinTimePickFragment();
	    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
	    newFragment.show(fm, "timePicker");
	}
	
	public class DebutTimePickFragment extends DialogFragment implements OnTimeSetListener {


	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	        // Use the current time as the default values for the picker
	        final Calendar c = Calendar.getInstance();
	        int hour = c.get(Calendar.HOUR_OF_DAY);
	        int minute = c.get(Calendar.MINUTE);

	        // Create a new instance of TimePickerDialog and return it
	        return new TimePickerDialog(getActivity(), this, hour, minute,
	                DateFormat.is24HourFormat(getActivity()));
	    }

	    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
	    	String heure = new StringBuilder().append(hourOfDay).append(":").append(minute).toString();
	    	Button bouton = (Button)findViewById(R.id.ajouter_cour_bouton_heure_debut);
	        bouton.setText(heure);
	    }

	}
	
	public class FinTimePickFragment extends DialogFragment implements OnTimeSetListener {


	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	        // Use the current time as the default values for the picker
	        final Calendar c = Calendar.getInstance();
	        int hour = c.get(Calendar.HOUR_OF_DAY);
	        int minute = c.get(Calendar.MINUTE);

	        // Create a new instance of TimePickerDialog and return it
	        return new TimePickerDialog(getActivity(), this, hour, minute,
	                DateFormat.is24HourFormat(getActivity()));
	    }

	    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
	    	String heure = new StringBuilder().append(hourOfDay).append(":").append(minute).toString();
	    	Button bouton = (Button)findViewById(R.id.ajouter_cour_bouton_heure_fin);
	        bouton.setText(heure);
	    }

	}
	
}
