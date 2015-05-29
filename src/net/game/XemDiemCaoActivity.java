package net.game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class XemDiemCaoActivity extends Activity {
	long diem;
	TextView TextViewSoDiem;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.xemdiemcao);
        
        SharedPreferences preferences = getSharedPreferences(CaiDatActivity.SETTINGS, MODE_PRIVATE);
        diem = preferences.getLong(CaiDatActivity.DIEM_CAONHAT, 0);
        TextViewSoDiem = (TextView)findViewById(R.id.TextViewSoDiem);
        TextViewSoDiem.setText(String.valueOf(diem));
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    switch(keyCode){
	    case KeyEvent.KEYCODE_BACK:
	        // do something here 
	    	Intent intent = new Intent(XemDiemCaoActivity.this, BanBongActivity.class);
			startActivity(intent);
			XemDiemCaoActivity.this.finish();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}