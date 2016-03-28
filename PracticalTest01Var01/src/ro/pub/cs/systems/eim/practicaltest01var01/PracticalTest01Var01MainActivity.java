package ro.pub.cs.systems.eim.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends Activity {

	public static final int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	public static int sum_cached = -1000;
	public static String string_cached = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var01_main);

		MyListener listener = new MyListener();
		Button add_button = (Button) findViewById(R.id.add);
		add_button.setOnClickListener(listener);
		Button compute_button = (Button) findViewById(R.id.compute);
		compute_button.setOnClickListener(listener);

		EditText allTerms = (EditText) findViewById(R.id.all_terms);
		allTerms.setText("");
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		sum_cached = resultCode;
		Toast.makeText(this, "The activity returned with result " + resultCode,
				Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var01_main, menu);
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

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putString("sum_cached", String.valueOf(sum_cached));
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.containsKey("sum_cached")) {
			sum_cached = Integer.parseInt(savedInstanceState
					.getString("sum_cached"));
		}
	}

	private class MyListener implements Button.OnClickListener {

		@Override
		public void onClick(View v) {
			EditText number = (EditText) findViewById(R.id.next_term);
			EditText allTerms = (EditText) findViewById(R.id.all_terms);
			switch (v.getId()) {
			case R.id.add:
				// if ()
				if (!allTerms.getText().toString().equals("")) {
					allTerms.setText(allTerms.getText().toString() + "+"
							+ number.getText().toString());
				} else {
					allTerms.setText(number.getText().toString());
				}
				string_cached = allTerms.getText().toString();
				break;
			case R.id.compute:
				if (string_cached.equals(allTerms.getText().toString())) {
					Log.d("[Message]", "Test1");
					Toast.makeText(PracticalTest01Var01MainActivity.this, sum_cached, Toast.LENGTH_LONG).show();
				} else {
					Log.d("[Message]", "Test2");
					Intent intent = new Intent(
							"ro.pub.cs.systems.eim.intent.action.PracticalTest01Var01SecondaryActivity");
					intent.putExtra("string_to_compute", allTerms.getText()
							.toString());
					startActivityForResult(intent,
							SECONDARY_ACTIVITY_REQUEST_CODE);
				}
				break;
			default:
				break;
			}

		}

	}
}
