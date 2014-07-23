package ca.etsmtl.gti350e14equipe10.calendarets;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ca.etsmtl.gti350e14equipe10.calendarets.Calendrier.Travail;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class AjouterTravail extends FragmentActivity { 
	private GregorianCalendar dateheure = (GregorianCalendar) GregorianCalendar.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Activity ajouterTravailActivity = this;
		setContentView(R.layout.activity_ajouter_travail);
		
		Button btn = (Button) findViewById(R.id.ajouter_travail_bouton_enregistrer);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				EditText textNotes = (EditText) findViewById(R.id.editText2);
				String notes = textNotes.getText().toString();
				EditText textTitre = (EditText) findViewById(R.id.editText1);
				String titre = textTitre.getText().toString();
				
				Travail t = new Travail(titre, dateheure, notes);
				Calendrier.getInstance().ajouterTravail(t);
				
				Intent intent = new Intent(ajouterTravailActivity, VueSemaine.class);
				startActivity(intent);
			}
			
		});
	}
	
	public void showDebutTimePickerDialog(View v) {
		TimePickFragment newFragment = new TimePickFragment();
	    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
	    newFragment.show(fm, "timePicker");
	}
	
	public class TimePickFragment extends DialogFragment implements OnTimeSetListener {


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
	    	Button bouton = (Button)findViewById(R.id.ajouter_travail_bouton_heure);
	        bouton.setText(heure);
	        int year = dateheure.get(Calendar.YEAR);
	        int month = dateheure.get(Calendar.MONTH);
	        int day = dateheure.get(Calendar.DAY_OF_MONTH);
	        dateheure.set(year, month, day, hourOfDay, minute);
	    }

	}
	
	
	public void showDatePickerDialog(View v) {
	    DialogFragment newFragment = new DatePickerFragment();
	    newFragment.show(getSupportFragmentManager(), "datePicker");
	}
	
	public class DatePickerFragment extends DialogFragment implements OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			
			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}
		
		public void onDateSet(DatePicker view, int year, int month, int day) {
			
			String date = new StringBuilder().append(month+1).append("-").append(day).append("-").append(year).toString();
			Button bouton = (Button)findViewById(R.id.travail_pick_date_button);
			bouton.setText(date);
			dateheure.set(year, month, day);
			
		}

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
