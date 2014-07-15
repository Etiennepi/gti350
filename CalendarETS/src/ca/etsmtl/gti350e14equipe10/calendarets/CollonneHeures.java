package ca.etsmtl.gti350e14equipe10.calendarets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CollonneHeures extends LinearLayout {

	public CollonneHeures(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setOrientation(LinearLayout.VERTICAL);
		this.setShowDividers(SHOW_DIVIDER_MIDDLE);
		this.addView( new Division(context, " ") );
		this.addView( new Division(context, "6:00") );
		this.addView( new Division(context, "7:00") );
		this.addView( new Division(context, "8:00") );
		this.addView( new Division(context, "9:00") );
		this.addView( new Division(context, "10:00") );
		this.addView( new Division(context, "11:00") );
		this.addView( new Division(context, "12:00") );
		this.addView( new Division(context, "13:00") );
		this.addView( new Division(context, "14:00") );
		this.addView( new Division(context, "15:00") );
		this.addView( new Division(context, "16:00") );
		this.addView( new Division(context, "17:00") );
		this.addView( new Division(context, "18:00") );
		this.addView( new Division(context, "19:00") );
		this.addView( new Division(context, "20:00") );
		this.addView( new Division(context, "21:00") );
		this.addView( new Division(context, "22:00") );
		
		this.setGravity(Gravity.FILL_VERTICAL);
		
		// this.setBackgroundColor(0x33000000);
		// throw new RuntimeException("here!!!");
	}
/*
	public ViewJour(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ViewJour(Context context) {
		super(context);
		
		
		
	}
*/
	public static class Division extends LinearLayout {

		private final TextView label;
		private final View rightBar;
		private final View leftBar;
		
		public Division(Context context, String text) {
			super(context);
			
			this.setOrientation(HORIZONTAL);
			this.setLayoutParams(new ViewGroup.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
			
			this.label =  new TextView(context);
			this.rightBar = new View(context);
			this.leftBar = new View(context);

			//this.addView( this.leftBar);
			this.setShowDividers(SHOW_DIVIDER_BEGINNING);
			this.addView( this.label );
			//this.addView( this.rightBar);

			this.label.setText(text);
			Division.setupRuler(this.leftBar);
			Division.setupRuler(this.rightBar);
		}
		
		private static final void setupRuler(View ruler) {
			ruler.setBackgroundColor(0xFFFFFFFF);
		}
		
	}
}
