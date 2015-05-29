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

public class ResumeActivity extends Activity {
	Button tieptuc, vemenuchinh, caidat;
	CheDoChoiTuDo TuDo;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.resume);
        
        tieptuc = (Button)findViewById(R.id.ButtonTiepTuc);
        tieptuc.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = getIntent();
		        Bundle bundle = intent.getBundleExtra("DuLieu");
		        if(bundle != null)
		        {
			    	intent = new Intent(ResumeActivity.this, CHOIGAMEActivity.class);
					intent.putExtra("Resume", bundle);
					startActivity(intent);
					ResumeActivity.this.finish();
		        }
		        else
		        {
		        	finish();
		        	System.exit(0);
		        }
			}
		});
        
        vemenuchinh = (Button)findViewById(R.id.ButtonVeMenuChinh);
        vemenuchinh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ResumeActivity.this, BanBongActivity.class);
				startActivity(intent);
				ResumeActivity.this.finish();
			}
		});
        
        caidat = (Button)findViewById(R.id.ButtonCaiDatResume);
        caidat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ResumeActivity.this, CaiDatActivity.class);
				startActivity(intent);
			}
		});
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    switch(keyCode){
	    case KeyEvent.KEYCODE_BACK:
	        // do something here 
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}