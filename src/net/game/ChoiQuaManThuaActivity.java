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

public class ChoiQuaManThuaActivity extends Activity {
	Button choilai, vemenuchinh;
	CheDoChoiQuaMan QuaMan;
	int level = 1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choiquamanthua);
        
        ChucNang chucnang = new ChucNang(this);
        chucnang.ChoiNhac(3);
        
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Data");
        if(bundle != null)
        	level = bundle.getInt("Level");
        
        choilai = (Button)findViewById(R.id.ButtonCQMThuaChoiLai);
        choilai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putInt("Level", level);
				bundle.putInt("CheDo", 1);
				Intent intent = new Intent(ChoiQuaManThuaActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChoiQuaManThuaActivity.this.finish();
			}
		});
        
        vemenuchinh = (Button)findViewById(R.id.ButtonCQMThuaVeMenuChinh);
        vemenuchinh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChoiQuaManThuaActivity.this, BanBongActivity.class);
				startActivity(intent);
				ChoiQuaManThuaActivity.this.finish();
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