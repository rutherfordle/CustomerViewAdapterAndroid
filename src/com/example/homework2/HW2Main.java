package com.example.homework2;

import java.util.ArrayList;
import java.util.List;

import com.example.homework2.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.graphics.PorterDuff;

public class HW2Main extends Activity implements OnClickListener{
	public static final int GREEN = 0xff00ff00;
	public static final int MAG = 0xffff00ff;
	public static final int YELLOW = 0xffffff00;
    public static final int RED = 0xffff0000;
	Button one, two, three, other;
	ListView lv;
	List<ListViewItem> items;
	int b1 = 0, b2 = 0, b3 = 0; 
	
	//ArrayList<String> items;
	ArrayAdapter<String> itemAdapter;
	String TitleList[];
	String[] curr = {"button1","button2","button3"};
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hw2_main);
		items = new ArrayList<HW2Main.ListViewItem>();

		one =(Button)findViewById(R.id.button1);
		two = (Button)findViewById(R.id.button2);
		three = (Button)findViewById(R.id.button3);
		other = (Button)findViewById(R.id.button4);
		one.getBackground().setColorFilter(GREEN,PorterDuff.Mode.MULTIPLY);
		two.getBackground().setColorFilter(RED,PorterDuff.Mode.MULTIPLY);
		three.getBackground().setColorFilter(YELLOW,PorterDuff.Mode.MULTIPLY);
		
		lv = (ListView)findViewById(R.id.view);

		CustomListViewAdapter adapter = new CustomListViewAdapter(this, items);
		lv.setAdapter(adapter);
		
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		other.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {

		switch(v.getId()){
		
			case R.id.button1:	
				items.add(0,new ListViewItem()
				{{
					ThumbnailResource = R.drawable.hunter;
					Title = curr[0];
				}});
				CustomListViewAdapter adapter = new CustomListViewAdapter(this, items);
				lv.setAdapter(adapter);
				b1++;
				break;
			case R.id.button2:
				
				items.add(0,new ListViewItem()
				{{
					ThumbnailResource = R.color.RED;
					Title = curr[1];
				}});
				adapter = new CustomListViewAdapter(this, items);
				lv.setAdapter(adapter);
				b2++;
				break;
			case R.id.button3:
		
				items.add(0, new ListViewItem()
				{{
					ThumbnailResource = R.color.YELLOW;
					Title = curr[2];
				}});
				adapter = new CustomListViewAdapter(this, items);
				lv.setAdapter(adapter);
				b3++;
				break;
			case R.id.button4:
				/*used startActivityForResult instead of Shared preferences. 
				Better for just getting information accross activities.*/
				Intent intent1 = new Intent("com.example.homework2.OTHERACTIVITY");
				startActivityForResult(intent1, 1);
				
				};
		}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == 1) {

		     if(resultCode == RESULT_OK){

		      String text = data.getStringExtra("text");
		      if (!text.equals(curr[0]) && !text.equals(curr[1]) && !text.equals(curr[2])) {
					if (b1 <= b2 && b1 <= b3){
						one.setText(text);
						curr[0] = text;
					}
					if (b2 < b1 && b2 <= b3){
						two.setText(text);
						curr[1] = text;
		      		}
					if (b3 < b2 && b3 < b1){
						three.setText(text);
						curr[2] = text;
					}
		      } else {
		    	  Toast.makeText(getApplicationContext(),"Error: Will not repeat",Toast.LENGTH_LONG).show();
		      }
		}

		if (resultCode == RESULT_CANCELED) {

		     //Write your code on no result return 

		}
		}//onAcrivityResult
	}
	class ListViewItem{
		public int ThumbnailResource;
		public String Title;
	}
}
	

