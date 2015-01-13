package com.example.homework2;

import com.example.homework2.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class otherActivity extends Activity implements OnClickListener{
	Button add;
	EditText textBox;
	String text;
	SharedPreferences preferences;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other_activity);
	
	add = (Button) findViewById(R.id.enter);
	textBox = (EditText) findViewById(R.id.text);
	add.setOnClickListener(this);
	}
	
	public void onClick(View view) {
		text = textBox.getText().toString();
		

		//preferences = PreferenceManager.getDefaultSharedPreferences(this);
		//text = preferences.getString("text", "");
		
		 Intent returnIntent = new Intent();
		 returnIntent.putExtra("text",text);
		 setResult(RESULT_OK,returnIntent);     
		 finish();
	}

}
