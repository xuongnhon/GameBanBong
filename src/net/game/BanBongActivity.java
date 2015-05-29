package net.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;

public class BanBongActivity extends Activity {
	Button choigame, xemdiemcao, caidat, thoatgame;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        
        choigame = (Button)findViewById(R.id.ButtonChoiGame);
        choigame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BanBongActivity.this, ChonCheDoActivity.class);
				startActivity(intent);
				BanBongActivity.this.finish();
			}
		});
        
        xemdiemcao = (Button)findViewById(R.id.ButtonDiemCao);
        xemdiemcao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BanBongActivity.this, XemDiemCaoActivity.class);
				startActivity(intent);
				BanBongActivity.this.finish();
			}
		});
        
        caidat = (Button)findViewById(R.id.ButtonCaiDat);
        caidat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BanBongActivity.this, CaiDatActivity.class);
				startActivity(intent);
			}
		});
        
        thoatgame = (Button)findViewById(R.id.ButtonThoatGame);
        thoatgame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				System.exit(0);
			}
		});
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    switch(keyCode){
	    case KeyEvent.KEYCODE_BACK:
	        // do something here 
	    	finish();
			System.exit(0);
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}