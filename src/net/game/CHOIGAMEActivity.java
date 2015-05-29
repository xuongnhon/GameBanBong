package net.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class CHOIGAMEActivity extends Activity {
	CheDoChoiQuaMan QuaMan;
	CheDoChoiTuDo TuDo;
	int CheDo = 1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        BanDo.initMaps();
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("DuLieu");
        
        if(bundle != null)
        {
        	CheDo = bundle.getInt("CheDo");
        	if(CheDo == 1)
        	{
        		QuaMan = new CheDoChoiQuaMan(this);
        		QuaMan.level = bundle.getInt("Level");
        		QuaMan.KhoiTaoLai();
            	setContentView(QuaMan);
        	}
        	else
        	{
        		TuDo = new CheDoChoiTuDo(this);
        		TuDo.KhoiTaoLai();
            	setContentView(TuDo);
        	}
        }
        else
        {
        	bundle = intent.getBundleExtra("Resume");
        	if(bundle != null)
        	{
        		CheDo = bundle.getInt("CheDo");
        		if(CheDo == 1)
        		{
        			QuaMan = new CheDoChoiQuaMan(this);
            		QuaMan.level = bundle.getInt("Level");
            		QuaMan.KhoiTaoLai(bundle);
                	setContentView(QuaMan);
        		}
        		else
        		{
        			TuDo = new CheDoChoiTuDo(this);
            		TuDo.KhoiTaoLai(bundle);
                	setContentView(TuDo);
        		}
        	}
        	else
        	{
        		finish();
            	System.exit(0);
        	}
        }        
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    switch(keyCode){
	    case KeyEvent.KEYCODE_BACK:
	        // do something here 
	    	if(CheDo == 1)
	    	{
	    		Bundle bundle = new Bundle(CheDoChoiQuaMan.BackupCheDoChoiQuaMan());
	    		CheDoChoiQuaMan.thread.StopDangChay();
	    		
		    	Intent intent = new Intent(CHOIGAMEActivity.this, ResumeActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				CHOIGAMEActivity.this.finish();
	    	}
	    	else
	    	{
	    		Bundle bundle = new Bundle(CheDoChoiTuDo.BackupCheDoChoiTuDo());
		    	CheDoChoiTuDo.thread.StopDangChay();
		    	
		    	Intent intent = new Intent(CHOIGAMEActivity.this, ResumeActivity.class);
				intent.putExtra("DuLieu", bundle);
				startActivity(intent);
				CHOIGAMEActivity.this.finish();
	    	}
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}
