package net.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;

public class ChonCheDoActivity extends Activity {
	Button choitudo, choiquaman;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.chonchedochoi);
        
        choitudo = (Button)findViewById(R.id.ButtonChoiTuDo);
        choitudo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putInt("CheDo", 2);
				Intent intent = new Intent(ChonCheDoActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChonCheDoActivity.this.finish();
			}
		});
        
        choiquaman = (Button)findViewById(R.id.ButtonChoiQuaMan);
        choiquaman.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChonCheDoActivity.this, ChoiQuaManActivity.class);
				startActivity(intent);
				ChonCheDoActivity.this.finish();
			}
		});
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    switch(keyCode){
	    case KeyEvent.KEYCODE_BACK:
	        // do something here 
	    	Intent intent = new Intent(ChonCheDoActivity.this, BanBongActivity.class);
			startActivity(intent);
			ChonCheDoActivity.this.finish();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}