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

public class ChoiQuaManKetThucActivity extends Activity {
	Button vemenuchinh;
	ChucNang chucnang;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choiquamanketthuc);
        
        chucnang = new ChucNang(this);
        //chucnang.ChoiNhac(6);
        
        vemenuchinh = (Button)findViewById(R.id.ButtonCQMKTVeMenuChinh);
        vemenuchinh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChoiQuaManKetThucActivity.this, BanBongActivity.class);
				startActivity(intent);
				ChoiQuaManKetThucActivity.this.finish();
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