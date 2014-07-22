package ca.etsmtl.gti350e14equipe10.calendarets;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

public class AjouterChangementHorraire extends FragmentActivity { 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Activity ajouterChangementHorraireActivity = this;
		setContentView(R.layout.activity_ajouter_changement_horraire);
		
		Spinner spinner = (Spinner) findViewById(R.id.changerHorraireJourSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.jour_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		Button btn = (Button) findViewById(R.id.ajouter_changement_bouton_enregistrer);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
			}
			
		});
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
			String date = new StringBuilder().append(month+11).append("-").append(day).append("-").append(year).toString();
			Button bouton = (Button)findViewById(R.id.changement_pick_date_button);
			bouton.setText(date);
		}

	}
	
}
