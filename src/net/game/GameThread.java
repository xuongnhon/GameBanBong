package net.game;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

@SuppressLint("WrongCall")
public class GameThread extends Thread{
	private SurfaceHolder surfaceholder;
	private CheDoChoiQuaMan quaman;
	private CheDoChoiTuDo tudo;
	int chedo = 1;
	private boolean dangchay = true;
	Canvas canvas;
	
	public GameThread(SurfaceHolder surfaceholder, CheDoChoiQuaMan quaman) {
		super();
		this.surfaceholder = surfaceholder;
		this.quaman = quaman;
		this.chedo = 1;
	}
	
	public GameThread(SurfaceHolder surfaceholder, CheDoChoiTuDo tudo) {
		super();
		this.surfaceholder = surfaceholder;
		this.tudo = tudo;
		this.chedo = 2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (dangchay) {
			canvas = null;
			try {
				canvas = this.surfaceholder.lockCanvas();
				synchronized (surfaceholder) {
					if(chedo == 1)
						this.quaman.onDraw(canvas);
					else
						this.tudo.onDraw(canvas);
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} finally {
				if (canvas != null) {
					surfaceholder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
	
	public void StopDangChay() {
        this.dangchay = false;
    }
}