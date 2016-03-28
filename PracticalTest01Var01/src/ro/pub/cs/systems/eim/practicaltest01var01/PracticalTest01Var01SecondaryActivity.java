package ro.pub.cs.systems.eim.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PracticalTest01Var01SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_practical_test01_var01_secondary);
		
		int suma = 0;
		Intent intent = getIntent();
	    if (intent != null) {
	      String toCompute = intent.getStringExtra("string_to_compute");
	      if (!toCompute.equals("")) {
	    	  String[] parts = toCompute.split("\\+");
	    	  for (int i = 0; i < parts.length; i++)
	    		  suma += Integer.parseInt(parts[i]);
	    	  setResult(suma, new Intent());
	      } else {
	    	  setResult(-1000, new Intent());
	      }
	      finish();
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var01_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
