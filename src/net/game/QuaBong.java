package net.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class QuaBong {
	Bitmap hinh = null;
	int x = 0, y = 0, maubong = 0;
	boolean phahuy = true, kiemtracotreo = false;
	int sotang = 0;
	
	boolean ok = false;
	
	public QuaBong()
	{
		x = 0;
		y = 0;
		phahuy = true;
		kiemtracotreo = false;
		sotang = 0;
	}
	
	public QuaBong(QuaBong QuaBongB)
	{
		x = QuaBongB.x;
		y = QuaBongB.y;
		hinh = QuaBongB.hinh;
		maubong = QuaBongB.maubong;
		phahuy = QuaBongB.phahuy;
		kiemtracotreo = QuaBongB.kiemtracotreo;
		sotang = QuaBongB.sotang;
	}
	
	public QuaBong(Bitmap hinh, int x, int y)
	{
		this.hinh = hinh;
		this.x = x;
		this.y = y;
		maubong = 0;
		phahuy = false;
	}
	
	public QuaBong(int x, int y, int maubong, boolean kiemtracotreo)
	{
		this.x = x;
		this.y = y;
		this.maubong = maubong;
		phahuy = false;
		this.kiemtracotreo = kiemtracotreo;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(hinh, x - (hinh.getWidth() / 2), y - (hinh.getHeight() / 2), null);
	}
}
