package net.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class ChoiQuaManActivity extends Activity {
	Button choimoi, chonlevel;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choiquaman);

        choimoi = (Button)findViewById(R.id.ButtonChoiMoi);
        choimoi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putInt("Level", 1);
				bundle.putInt("CheDo", 1);
				Intent intent = new Intent(ChoiQuaManActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChoiQuaManActivity.this.finish();
			}
		});
        
        chonlevel = (Button)findViewById(R.id.ButtonChonLevel);
        chonlevel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChoiQuaManActivity.this, ChonLevelActivity.class);
				startActivity(intent);
				ChoiQuaManActivity.this.finish();
			}
		});
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    switch(keyCode){
	    case KeyEvent.KEYCODE_BACK:
	        // do something here 
	    	Intent intent = new Intent(ChoiQuaManActivity.this, ChonCheDoActivity.class);
			startActivity(intent);
			ChoiQuaManActivity.this.finish();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}