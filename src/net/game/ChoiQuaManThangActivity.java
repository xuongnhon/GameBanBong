package net.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;

public class ChoiQuaManThangActivity extends Activity {
	Button choilai, nextlevel;
	CheDoChoiQuaMan QuaMan;
	int level = 1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choiquamanthang);
        
        ChucNang chucnang = new ChucNang(this);
        chucnang.ChoiNhac(8);
        
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Data");
        if(bundle != null)
        {
        	level = bundle.getInt("Level");
        	chucnang.UnlockLevel(level + 1);
        }
        
        choilai = (Button)findViewById(R.id.ButtonCQMThangNextLevel);
        choilai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putInt("Level", level + 1);
				bundle.putInt("CheDo", 1);
				Intent intent = new Intent(ChoiQuaManThangActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChoiQuaManThangActivity.this.finish();
			}
		});
        
        nextlevel = (Button)findViewById(R.id.ButtonCQMThangVeMenuChinh);
        nextlevel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChoiQuaManThangActivity.this, BanBongActivity.class);
				startActivity(intent);
				ChoiQuaManThangActivity.this.finish();
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