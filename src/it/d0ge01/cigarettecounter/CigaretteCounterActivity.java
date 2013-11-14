package it.d0ge01.cigarettecounter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class CigaretteCounterActivity extends FragmentActivity implements MenuFragment.OnMenufragListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cigarette_counter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cigarette_counter, menu);
		return true;
	}
	// MenuFragment listener
	public void onMenufrag(String s) {
	    
		// get body fragment (native method is getFragmentManager)
	    BodyFragment fragment = (BodyFragment) getSupportFragmentManager().findFragmentById(R.id.bodyFragment);
	    
	    // if fragment is not null and in layout, set text, else launch BodyActivity
	    if ((fragment!=null)&&fragment.isInLayout()) {
	    	if ( s.equals("Buona fumata :)")) {
	    		fragment.setText(s);
	    		fragment.setImage(4);
	    	}
	    	else {
		    	int n = Integer.valueOf(s);
		    	fragment.setText("hai fumato " + n + "Sigarette :)");
		    	if ( n >= 10 && n <= 20 )
		    		fragment.setImage(2);
		    	if ( n < 10 )
		    		fragment.setImage(1);
		    	if ( n > 20 )
		    		fragment.setImage(3);
	    	}
	    } else {
	    	if ( s.equals("Buona fumata :)")) {
		        Intent intent = new Intent(this,BodyActivity.class);
		        intent.putExtra("value",s); // Another way to cast to String
		        intent.putExtra("image", "4");
		        startActivity(intent);
	    	} else {
		        Intent intent = new Intent(this,BodyActivity.class);
		        intent.putExtra("value","Hai fumato " + s + " Sigarette :)"); // Another way to cast to String
		        int n = Integer.valueOf(s);
		    	if ( n >= 10 && n <= 20 )
		    		intent.putExtra("image", "2");
		    	if ( n < 10 )
		    		intent.putExtra("image", "1");
		    	if ( n > 20 )
		    		intent.putExtra("image", "3");
		        startActivity(intent);
	    	} 
	    }  
	}

	@Override
	public void onMenufrag(int n) {
		// TODO Auto-generated method stub
		
	}
}
