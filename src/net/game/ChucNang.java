package net.game;

import java.io.IOException;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Vibrator;

public class ChucNang {
	private Context context;
	MediaPlayer mediaPlayer = new MediaPlayer();	
	
	Vibrator vibrator;
	
	private boolean monhac = false;
	private boolean morung = false;
	
	SharedPreferences preferences;
	
	public ChucNang(Context context)
	{
		this.context = context;
		preferences = context.getSharedPreferences(CaiDatActivity.SETTINGS, context.MODE_PRIVATE);
	}
	
	public void ChoiNhac(int id)
	{
		monhac = preferences.getBoolean(CaiDatActivity.MO_NHAC, true);
		int idnhac = 0;
		if(monhac)
		{
			switch(id)
			{
				case 1:
					idnhac = R.raw.nhacdungbong;
					break;
				case 2:
					idnhac = R.raw.nhacroibong;
					break;
				case 3:
					idnhac = R.raw.nhacthua;
					break;
				case 4:
					idnhac = R.raw.nhacdatdiemcao;
					break;
				case 5:
					idnhac = R.raw.nhacdungtuong;
					break;
				case 6:
					idnhac = R.raw.nhacketthucchoiquaman;
					break;
				case 7:
					idnhac = R.raw.nhacthembong;
					break;
				case 8:
					idnhac = R.raw.nhacthangquaman;
					break;
				case 9:
					idnhac = R.raw.nhacnen;
					break;
			}
			Player(idnhac);
		}
	}
	
	private void Player(int id){
	    MediaPlayer mp = new MediaPlayer();
	    try {
	    	AssetFileDescriptor audioFileDescriptor = context.getResources().openRawResourceFd(id);
			mp.setDataSource(audioFileDescriptor.getFileDescriptor(),audioFileDescriptor.getStartOffset(),audioFileDescriptor.getLength());
			mp.prepare();
			mp.start();
			mp.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
					// TODO Auto-generated method stub
					mp.release();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Rung(long thoigian)
	{
		morung = preferences.getBoolean(CaiDatActivity.MO_RUNG, true);
		if(morung)
		{
			vibrator = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
			vibrator.vibrate(thoigian);
		}
	}
	
	public void DiemCaoNhat(long diem)
	{
		long diemhientai = preferences.getLong(CaiDatActivity.DIEM_CAONHAT, 0);
		if(diemhientai < diem)
		{
			Editor editor = preferences.edit();
			editor.putLong(CaiDatActivity.DIEM_CAONHAT, diem);
			editor.commit();
		}
	}
	
	public long DiemCaoNhat()
	{
		long diemhientai = preferences.getLong(CaiDatActivity.DIEM_CAONHAT, 0);
		return diemhientai;
	}
	
	public void UnlockLevel(int level)
	{
		int levelhientai = preferences.getInt(CaiDatActivity.LEVEL, 1);
		if(levelhientai < level && level <= 9)
		{
			Editor editor = preferences.edit();
			editor.putInt(CaiDatActivity.LEVEL, level);
			editor.commit();
		}
	}	
}
