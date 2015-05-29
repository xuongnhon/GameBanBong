package net.game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class ChonLevelActivity extends Activity {
	Button level01, level02, level03, level04, level05,
			level06, level07, level08, level09;
	Bundle bundle = new Bundle();
	SharedPreferences preferences;
	int unlocklevel = 1;
	int[] idbutton = {R.id.ButtonLevel01,
			R.id.ButtonLevel02,
			R.id.ButtonLevel03,
			R.id.ButtonLevel04,
			R.id.ButtonLevel05,
			R.id.ButtonLevel06,
			R.id.ButtonLevel07,
			R.id.ButtonLevel08,
			R.id.ButtonLevel09
			};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.chonlevel);
        
        preferences = getSharedPreferences(CaiDatActivity.SETTINGS, MODE_PRIVATE);
        unlocklevel = preferences.getInt(CaiDatActivity.LEVEL, 1);
        for(int i = 0; i < 9; i++)
        {
        	if(unlocklevel < (i + 1))
        	{
        		Button Temp = (Button)findViewById(idbutton[i]);
        		Temp.setEnabled(false);
        		Temp.setText("");
        		Temp.setBackgroundResource(R.drawable.lock);
        	}
        }
        bundle.putInt("CheDo", 1);
        
        level01 = (Button)findViewById(R.id.ButtonLevel01);
        level01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 1);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
        level02 = (Button)findViewById(R.id.ButtonLevel02);
        level02.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 2);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
        level03 = (Button)findViewById(R.id.ButtonLevel03);
        level03.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 3);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
        level04 = (Button)findViewById(R.id.ButtonLevel04);
        level04.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 4);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
        level05 = (Button)findViewById(R.id.ButtonLevel05);
        level05.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 5);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
        level06 = (Button)findViewById(R.id.ButtonLevel06);
        level06.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 6);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
        level07 = (Button)findViewById(R.id.ButtonLevel07);
        level07.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 7);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
        level08 = (Button)findViewById(R.id.ButtonLevel08);
        level08.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 8);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
        level09 = (Button)findViewById(R.id.ButtonLevel09);
        level09.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bundle.putInt("Level", 9);
				Intent intent = new Intent(ChonLevelActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonLevelActivity.this.finish();
			}
		});
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    switch(keyCode){
	    case KeyEvent.KEYCODE_BACK:
	        // do something here 
	    	Intent intent = new Intent(ChonLevelActivity.this, ChoiQuaManActivity.class);
			startActivity(intent);
			ChonLevelActivity.this.finish();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}