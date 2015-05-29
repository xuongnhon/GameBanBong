package net.game;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.view.View;

public class CaiDatActivity extends Activity {
	CheckBox MoNhac, MoRung;
	boolean monhac, morung;
	SharedPreferences preferences;
	public static final String SETTINGS = "net.game.settings";
	public static final String MO_NHAC = "net.game.monhac";
	public static final String MO_RUNG = "net.game.morung";
	public static final String DIEM_CAONHAT = "net.game.diemcaonhat";
	public static final String LEVEL = "net.game.level";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.caidat);
        
        preferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        monhac = preferences.getBoolean(MO_NHAC, true);
        morung = preferences.getBoolean(MO_RUNG, true);
        
        MoNhac = (CheckBox)findViewById(R.id.CheckBoxAmThanh);
        if(monhac)
        	MoNhac.setChecked(true);
        MoNhac.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Editor editor = preferences.edit();
				if(MoNhac.isChecked())
					editor.putBoolean(MO_NHAC, true);
				else
					editor.putBoolean(MO_NHAC, false);
				editor.commit();
			}
		});

        MoRung = (CheckBox)findViewById(R.id.CheckBoxRung);
        if(morung)
        	MoRung.setChecked(true);
        MoRung.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Editor editor = preferences.edit();
				if(MoRung.isChecked())
					editor.putBoolean(MO_RUNG, true);
				else
					editor.putBoolean(MO_RUNG, false);
				editor.commit();
			}
		});
    }
}