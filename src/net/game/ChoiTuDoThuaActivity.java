package net.game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class ChoiTuDoThuaActivity extends Activity {
	Button choilai, vemenuchinh;
	SharedPreferences preferences;
	long diemcaonhat = 0;
	long diem = 0;
	TextView title, tongket;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choitudothua);
        
        preferences = getSharedPreferences(CaiDatActivity.SETTINGS, MODE_PRIVATE);
        diemcaonhat = preferences.getLong(CaiDatActivity.DIEM_CAONHAT, 0);
        
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Data");
        if(bundle != null)
        {
        	ChucNang chucnang = new ChucNang(this);
        	//diemcaonhat  = chucnang.DiemCaoNhat();
        	diem = bundle.getLong("Diem");
        	title = (TextView)findViewById(R.id.TextViewTitle);
    		tongket = (TextView)findViewById(R.id.TextViewTongKet);
        	if(diem > diemcaonhat)
        	{
        		chucnang.ChoiNhac(4);
        		title.setText("Chúc Mừng Đây Là Điểm Số Cao Nhất");
        	}
        	else
        	{
        		chucnang.ChoiNhac(3);
        		title.setText("Số Điểm Đạt Được");
        	}
        	tongket.setText(String.valueOf(diem));
        }
        
        choilai = (Button)findViewById(R.id.ButtonCTDThuaChoiLai);
        choilai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putInt("CheDo", 2);
				Intent intent = new Intent(ChoiTuDoThuaActivity.this, CHOIGAMEActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				ChoiTuDoThuaActivity.this.finish();
			}
		});
        
        vemenuchinh = (Button)findViewById(R.id.ButtonCTDThuaVeMenuChinh);
        vemenuchinh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChoiTuDoThuaActivity.this, BanBongActivity.class);
				startActivity(intent);
				ChoiTuDoThuaActivity.this.finish();
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