package net.game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CheDoChoiTuDo extends SurfaceView implements SurfaceHolder.Callback {
	static public GameThread thread;
	static private QuaBong[][] danhsachquabong;
	static private Bitmap[] danhsachhinhquabong = new Bitmap[8];
	static private Bitmap hinhbackground;
	
	static Queue<Point> vitriquabongdehuy;
	static int maubongkiemtra = 0;
	
	static int width;
	static int height;
	static int quabongwidth;
	static int quabongheight;
	
	static int soluongquabong = 0;
	static QuaBong[] danhsachquabongcho;
	static final int soluongquabongcho = 4;
	static QuaBong quabongdangdichuyen;
	static float dotangY;
	static float dotangX = 0;
	static boolean dangdichuyen = false;
	static final int sobuoc = 10;
	static boolean chothaydoi = false;
	static int sotang = 0;
	
	static int thoigian = 0;
	static int thoigiansuptang;
	static int thoigiangiam = 500;
	static int demthoigiangiam = 0;
	static int giam = 0;
	static int soluongmau = 3;
	
	static private int Ybandau = 60;
	static private int Xbandau = 50;

	static Random random = new Random();
	static Paint paint;
	static long diem = 0;
	static boolean thua = false;
	
	static Bitmap hinhthuacuoc;
	static Bitmap hinhthang;
	static Bitmap hinhsuptang;
	static Bitmap hinhchucmung;
	
	static int[] danhsachmauhientai;
	
	static int chuyendoiqualai = 0;
	static ChucNang chucnang;
	
	private void KhoiTaoGame() {
		danhsachquabong = new QuaBong[25][8];
		danhsachquabongcho = new QuaBong[4];
		vitriquabongdehuy = new LinkedList<Point>();
		quabongheight = danhsachquabong.length;
		quabongwidth = danhsachquabong[0].length;
		danhsachmauhientai = new int[8];
		
		BitmapFactory.Options options = new BitmapFactory.Options();

		danhsachhinhquabong[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.bong_1, options);
		danhsachhinhquabong[1] = BitmapFactory.decodeResource(getResources(),
				R.drawable.bong_2, options);
		danhsachhinhquabong[2] = BitmapFactory.decodeResource(getResources(),
				R.drawable.bong_3, options);
		danhsachhinhquabong[3] = BitmapFactory.decodeResource(getResources(),
				R.drawable.bong_4, options);
		danhsachhinhquabong[4] = BitmapFactory.decodeResource(getResources(),
				R.drawable.bong_5, options);
		danhsachhinhquabong[5] = BitmapFactory.decodeResource(getResources(),
				R.drawable.bong_6, options);
		danhsachhinhquabong[6] = BitmapFactory.decodeResource(getResources(),
				R.drawable.bong_7, options);
		danhsachhinhquabong[7] = BitmapFactory.decodeResource(getResources(),
				R.drawable.bong_8, options);

		hinhbackground = BitmapFactory.decodeResource(getResources(),
				R.drawable.background, options);
		hinhthuacuoc = BitmapFactory.decodeResource(getResources(),
				R.drawable.lose_panel, options);
		hinhthang = BitmapFactory.decodeResource(getResources(),
				R.drawable.win_panel, options);
		hinhsuptang = BitmapFactory.decodeResource(getResources(),
				R.drawable.compressor, options);
		
		paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setTextSize(20);

		quabongdangdichuyen = new QuaBong();
	}
	
	public static void KhoiTaoLai() {
		sotang = 0;
		diem = 0;
		soluongquabong = 0;

		thoigiansuptang = 1000;
		thoigian = 0;
		demthoigiangiam = 0;
		dangdichuyen = false;
		chothaydoi = false;
		int soluongquabongtao = 0;
		chuyendoiqualai = 1;
		
		int index = 0;
		int[] bandohientai = BanDo.bandos[1];
		
		for (int i = 0; i < quabongheight; i++)
		{
			for (int j = 0; j < quabongwidth; j++)
			{
				if (soluongquabongtao < bandohientai.length)
				{
					index = bandohientai[soluongquabongtao];
					if (index != -1)
					{
						danhsachmauhientai[index]++;
						if (i % 2 == chuyendoiqualai)
						{
							if (danhsachquabong[i][j] == null)
							{
								danhsachquabong[i][j] = new QuaBong(
										danhsachhinhquabong[index],
										Xbandau + (int) j * 30,
										Ybandau + i * 30);
							}
							else
							{
								danhsachquabong[i][j].x = Xbandau + (int) j * 30;
								danhsachquabong[i][j].y = Ybandau + i * 30;
								danhsachquabong[i][j].hinh = danhsachhinhquabong[index];
								danhsachquabong[i][j].phahuy = false;
								danhsachquabong[i][j].sotang = 0;
								danhsachquabong[i][j].kiemtracotreo = false;
							}
						}
						else
						{
							if(danhsachquabong[i][j] ==null)
							{
								danhsachquabong[i][j] = new QuaBong(danhsachhinhquabong[index],
										Xbandau + 15 + (int) j * 30,
										Ybandau + i * 30);
							}
							else
							{
								danhsachquabong[i][j].x = Xbandau + 15 + (int) j * 30;
								danhsachquabong[i][j].y = Ybandau + i * 30;
								danhsachquabong[i][j].hinh = danhsachhinhquabong[index];
								danhsachquabong[i][j].phahuy = false;
								danhsachquabong[i][j].sotang = 0;
								danhsachquabong[i][j].kiemtracotreo = false;	
							}
						}
						danhsachquabong[i][j].maubong = index;
						soluongquabong++;
					}
					else
					{
						danhsachquabong[i][j] = new QuaBong();
					}
				}
				else
				{
					danhsachquabong[i][j] = new QuaBong();
				}
				soluongquabongtao++;
			}
		}
	}
	
	public static void KhoiTaoLai(Bundle bundle) {
		if(bundle != null)
		{
			dangdichuyen = false;
			chothaydoi = false;
			sotang = bundle.getInt("SoTang");
			diem = bundle.getLong("Diem");
			soluongquabong = 0;
			thoigiansuptang = bundle.getInt("ThoiGianSupTang");
			giam = bundle.getInt("Giam");
			demthoigiangiam = bundle.getInt("DemThoiGianGiam");
			int soluongquabongtao = 0;
			soluongmau = bundle.getInt("SoLuongMau");
			chuyendoiqualai = bundle.getInt("ChuyenDoiQuaLai");
			
			int index = 0;
			int[] bandohientai = bundle.getIntArray("ArrayQuaBong");
			int[] danhsachbongcho = bundle.getIntArray("ArrayQuaBongCho");
			
			for (int i = 0; i < quabongheight; i++)
			{
				for (int j = 0; j < quabongwidth; j++)
				{
					if (soluongquabongtao < bandohientai.length)
					{
						index = bandohientai[soluongquabongtao];
						if (index != -1)
						{
							danhsachmauhientai[index]++;
							if (i % 2 == chuyendoiqualai)
							{
								if (danhsachquabong[i][j] == null)
								{
									danhsachquabong[i][j] = new QuaBong(
											danhsachhinhquabong[index],
											Xbandau + (int) j * 30,
											Ybandau + i * 30);
								}
								else
								{
									danhsachquabong[i][j].x = Xbandau + (int) j * 30;
									danhsachquabong[i][j].y = Ybandau + i * 30;
									danhsachquabong[i][j].hinh = danhsachhinhquabong[index];
									danhsachquabong[i][j].phahuy = false;
									danhsachquabong[i][j].sotang = 0;
									danhsachquabong[i][j].kiemtracotreo = false;
								}
							}
							else
							{
								if(danhsachquabong[i][j] ==null)
								{
									danhsachquabong[i][j] = new QuaBong(danhsachhinhquabong[index],
											Xbandau + 15 + (int) j * 30,
											Ybandau + i * 30);
								}
								else
								{
									danhsachquabong[i][j].x = Xbandau + 15 + (int) j * 30;
									danhsachquabong[i][j].y = Ybandau + i * 30;
									danhsachquabong[i][j].hinh = danhsachhinhquabong[index];
									danhsachquabong[i][j].phahuy = false;
									danhsachquabong[i][j].sotang = 0;
									danhsachquabong[i][j].kiemtracotreo = false;	
								}
							}
							danhsachquabong[i][j].maubong = index;
							soluongquabong++;
						}
						else
						{
							danhsachquabong[i][j] = new QuaBong();
						}
					}
					else
					{
						danhsachquabong[i][j] = new QuaBong();
					}
					soluongquabongtao++;
				}
			}
			for (int i = 0; i < soluongquabongcho; i++) {

				QuaBong temp = new QuaBong(danhsachhinhquabong[danhsachbongcho[i]],
						2 * Xbandau + i * 30,
						height - Ybandau);
				temp.maubong = danhsachbongcho[i];
				danhsachquabongcho[i] = temp;
			}
		}
		
	}
	
	public static void KhoiTaoLai(QuaBong[] bandohientai) {
		sotang = 0;
		soluongquabong = 0;
		int soluongquabongtao = 0;
		
		int index = 0;
		for (int i = 0; i < quabongheight; i++)
		{
			for (int j = 0; j < quabongwidth; j++)
			{
				if (soluongquabongtao < bandohientai.length)
				{
					index = bandohientai[soluongquabongtao].maubong;
					if (index != -1)
					{
						danhsachmauhientai[index]++;
						if (i % 2 == chuyendoiqualai)
						{
							if (danhsachquabong[i][j] == null)
							{
								danhsachquabong[i][j] = new QuaBong(
										danhsachhinhquabong[index],
										Xbandau + (int) j * 30,
										Ybandau + i * 30);
							}
							else
							{
								danhsachquabong[i][j].x = Xbandau + (int) j * 30;
								if(bandohientai[soluongquabongtao].phahuy && bandohientai[soluongquabongtao].kiemtracotreo)
									danhsachquabong[i][j].y = bandohientai[soluongquabongtao].y;
								else
									danhsachquabong[i][j].y = Ybandau + i * 30;
								danhsachquabong[i][j].hinh = danhsachhinhquabong[index];
								danhsachquabong[i][j].phahuy = bandohientai[soluongquabongtao].phahuy;
								danhsachquabong[i][j].sotang = 0;
								danhsachquabong[i][j].kiemtracotreo = bandohientai[soluongquabongtao].kiemtracotreo;
							}
						}
						else
						{
							if(danhsachquabong[i][j] ==null)
							{
								danhsachquabong[i][j] = new QuaBong(danhsachhinhquabong[index],
										Xbandau + 15 + (int) j * 30,
										Ybandau + i * 30);
							}
							else
							{
								danhsachquabong[i][j].x = Xbandau + 15 + (int) j * 30;
								if(bandohientai[soluongquabongtao].phahuy && bandohientai[soluongquabongtao].kiemtracotreo)
									danhsachquabong[i][j].y = bandohientai[soluongquabongtao].y;
								else
									danhsachquabong[i][j].y = Ybandau + i * 30;
								danhsachquabong[i][j].hinh = danhsachhinhquabong[index];
								danhsachquabong[i][j].phahuy = bandohientai[soluongquabongtao].phahuy;
								danhsachquabong[i][j].sotang = 0;
								danhsachquabong[i][j].kiemtracotreo = bandohientai[soluongquabongtao].kiemtracotreo;
							}
						}
						danhsachquabong[i][j].maubong = index;
						soluongquabong++;
					}
					else
					{
						danhsachquabong[i][j] = new QuaBong();
					}
				}
				else
				{
					danhsachquabong[i][j] = new QuaBong();
				}
				soluongquabongtao++;
			}
		}
	}
	
	public CheDoChoiTuDo(Context context) {
		super(context);
		KhoiTaoGame();
		width = 300;
		height = 500;
		chucnang = new ChucNang(context);

		getHolder().addCallback(this);		
		KhoiTaoLai();
		int index = 0;

		for (int i = 0; i < soluongquabongcho; i++) {
			index = random.nextInt(8);
			while (danhsachmauhientai[index] <= 0) {
				index = random.nextInt(8);
			}
			QuaBong temp = new QuaBong(danhsachhinhquabong[index],
					2 * Xbandau + i * 30,
					height - Ybandau);
			temp.maubong = index;
			danhsachquabongcho[i] = temp;
		}
	
		thread = new GameThread(getHolder(), this);
		setFocusable(true);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height){
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.start();
	}
	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean thulai = true;
		while (thulai)
		{
			try
			{
				thread.join();
				thulai = false;
			}
			catch (InterruptedException e)
			{

			}
		}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (thua)
		{
			thua = false;
		}
		else
		{
			if (soluongquabong == 0)
			{
				try
				{
					TangThemQuaBong(soluongmau, 3);
				}
				catch(Exception ex)
				{
					
				}
			}
			else
			{
				if (!dangdichuyen)
				{
					float Ymongmuon = event.getY();
					if (Ymongmuon - danhsachquabongcho[soluongquabongcho - 1].y > -5)
					{

					}
					else
					{
						QuaBong quabongloaibo = danhsachquabongcho[soluongquabongcho - 1];
						quabongdangdichuyen.hinh = danhsachhinhquabong[quabongloaibo.maubong];
						quabongdangdichuyen.x = quabongloaibo.x;
						quabongdangdichuyen.y = quabongloaibo.y;
						quabongdangdichuyen.maubong = quabongloaibo.maubong;
						quabongdangdichuyen.phahuy = false;
						
						synchronized (danhsachquabongcho) {
							for (int i = soluongquabongcho - 2; i >= 0; i--) {
								danhsachquabongcho[i + 1].maubong = danhsachquabongcho[i].maubong;
								danhsachquabongcho[i + 1].hinh = danhsachhinhquabong[danhsachquabongcho[i + 1].maubong];
							}
						}

						int index = random.nextInt(8);
						while (danhsachmauhientai[index] == 0) {
							index = random.nextInt(8);
						}
						danhsachquabongcho[0].maubong = index;
						danhsachquabongcho[0].hinh = danhsachhinhquabong[index];

						float Xmongmuon = event.getX();
						dotangX = ((Xmongmuon - quabongdangdichuyen.x) / sobuoc);
						dotangY = (Ymongmuon - quabongdangdichuyen.y)
								/ (Xmongmuon - quabongdangdichuyen.x);
						dangdichuyen = true;
					}
				}
			}
		}
		try
		{
			GameThread.sleep(16);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		
		canvas.drawBitmap(hinhbackground,
				165 - (hinhbackground.getWidth() / 2),
				10, null);
		canvas.drawText("Điểm", 20, height - 70, paint);
		canvas.drawText(diem + "", 30, height - 50, paint);
		if (soluongquabong == 0)
		{
			for (int i = 0; i < danhsachmauhientai.length; i++)
			{
				danhsachmauhientai[i] = 0;
			}
			try
			{
				TangThemQuaBong(soluongmau, 3);
			}
			catch(Exception ex)
			{
				
			}
			canvas.drawBitmap(hinhsuptang, 5,
					-30 + (30 * sotang),
					paint);
		}
		else
		{
			if (!thua)
			{
				VeQuaBong(canvas);
				if (!quabongdangdichuyen.phahuy)
					quabongdangdichuyen.draw(canvas);
				CapNhat();
				canvas.drawBitmap(hinhsuptang, 5,
						-30 + (30 * sotang),
						paint);
			}
			else
			{
				for (int i = 0; i < danhsachmauhientai.length; i++)
				{
					danhsachmauhientai[i] = 0;
				}
				
				try
				{
					thread.StopDangChay();
					chucnang.DiemCaoNhat(diem);
					Activity activity = (Activity) getContext();
					Bundle bundle = new Bundle();
					bundle.putLong("Diem", diem);
					Intent intent = new Intent(activity, ChoiTuDoThuaActivity.class);
					intent.putExtra("Data", bundle);
					getContext().startActivity(intent);
					thua = false;
					activity.finish();
				}
				catch(Exception ex)
				{
					
				}
			}
		}
	}
	
	static private void KiemTraBongDeHuy() {
		int soluongbongkiemtra = 1;
		while (vitriquabongdehuy.size() > 0) {
			Point curr = vitriquabongdehuy.poll();
			int posX = curr.x;
			int posY = curr.y;
			
			//Phai
			if (posX < quabongwidth - 1)
			{
				if (!danhsachquabong[posY][posX + 1].phahuy
						&& !danhsachquabong[posY][posX + 1].kiemtracotreo)
				{
					if (danhsachquabong[posY][posX + 1].maubong == maubongkiemtra)
					{
						danhsachquabong[posY][posX + 1].kiemtracotreo = true;
						vitriquabongdehuy.add(new Point(posX + 1, posY));
						soluongbongkiemtra++;
					}
				}
			}
			//Trai
			if (posX > 0)
			{
				if (!danhsachquabong[posY][posX - 1].phahuy
						&& !danhsachquabong[posY][posX - 1].kiemtracotreo)
				{
					if (danhsachquabong[posY][posX - 1].maubong == maubongkiemtra) {
						danhsachquabong[posY][posX - 1].kiemtracotreo = true;
						vitriquabongdehuy.add(new Point(posX - 1, posY));
						soluongbongkiemtra++;
					}
				}
			}
			//Tren, Duoi
			if (posY % 2 == chuyendoiqualai)
			{
				if (posY < quabongheight - 1)
				{
					//Duoi Phai
					if (!danhsachquabong[posY + 1][posX].phahuy
							&& !danhsachquabong[posY + 1][posX].kiemtracotreo)
					{
						if (danhsachquabong[posY + 1][posX].maubong == maubongkiemtra)
						{
							danhsachquabong[posY + 1][posX].kiemtracotreo = true;
							vitriquabongdehuy.add(new Point(posX, posY + 1));
							soluongbongkiemtra++;
						}
					}
					//Duoi Trai
					if (posX > 0)
					{
						if (!danhsachquabong[posY + 1][posX - 1].phahuy
								&& !danhsachquabong[posY + 1][posX - 1].kiemtracotreo)
						{
							if (danhsachquabong[posY + 1][posX - 1].maubong == maubongkiemtra)
							{
								danhsachquabong[posY + 1][posX - 1].kiemtracotreo = true;
								vitriquabongdehuy.add(new Point(posX - 1, posY + 1));
								soluongbongkiemtra++;
							}
						}
					}
				}

				if (posY > 0)
				{
					//Trai Phai
					if (!danhsachquabong[posY - 1][posX].phahuy
							&& !danhsachquabong[posY - 1][posX].kiemtracotreo)
					{
						if (danhsachquabong[posY - 1][posX].maubong == maubongkiemtra)
						{
							danhsachquabong[posY - 1][posX].kiemtracotreo = true;
							vitriquabongdehuy.add(new Point(posX, posY - 1));
							soluongbongkiemtra++;
						}
					}
					//Tren Trai
					if (posX > 0) {
						if (!danhsachquabong[posY - 1][posX - 1].phahuy
								&& !danhsachquabong[posY - 1][posX - 1].kiemtracotreo) {
							if (danhsachquabong[posY - 1][posX - 1].maubong == maubongkiemtra) {
								danhsachquabong[posY - 1][posX - 1].kiemtracotreo = true;
								vitriquabongdehuy.add(new Point(posX - 1, posY - 1));
								soluongbongkiemtra++;
							}
						}
					}
				}
			}
			else
			{
				if (posY < quabongheight - 1)
				{
					//Duoi Phai
					if (posX < quabongwidth - 1)
					{
						if (!danhsachquabong[posY + 1][posX + 1].phahuy
								&& !danhsachquabong[posY + 1][posX + 1].kiemtracotreo)
						{
							if (danhsachquabong[posY + 1][posX + 1].maubong == maubongkiemtra)
							{
								danhsachquabong[posY + 1][posX + 1].kiemtracotreo = true;
								vitriquabongdehuy.add(new Point(posX + 1, posY + 1));
								soluongbongkiemtra++;
							}
						}
					}
					//Duoi Trai
					if (!danhsachquabong[posY + 1][posX].phahuy
							&& !danhsachquabong[posY + 1][posX].kiemtracotreo)
					{
						if (danhsachquabong[posY + 1][posX].maubong == maubongkiemtra)
						{
							danhsachquabong[posY + 1][posX].kiemtracotreo = true;
							vitriquabongdehuy.add(new Point(posX, posY + 1));
							soluongbongkiemtra++;
						}
					}
				}
				if (posY > 0)
				{
					//Tren Phai
					if (posX < quabongwidth - 1)
					{
						if (!danhsachquabong[posY - 1][posX + 1].phahuy
								&& !danhsachquabong[posY - 1][posX + 1].kiemtracotreo)
						{
							if (danhsachquabong[posY - 1][posX + 1].maubong == maubongkiemtra)
							{
								danhsachquabong[posY - 1][posX + 1].kiemtracotreo = true;
								vitriquabongdehuy.add(new Point(posX + 1, posY - 1));
								soluongbongkiemtra++;
							}
						}
					}
					//Tren Trai
					if (!danhsachquabong[posY - 1][posX].phahuy
							&& !danhsachquabong[posY - 1][posX].kiemtracotreo)
					{
						if (danhsachquabong[posY - 1][posX].maubong == maubongkiemtra)
						{
							danhsachquabong[posY - 1][posX].kiemtracotreo = true;
							vitriquabongdehuy.add(new Point(posX, posY - 1));
							soluongbongkiemtra++;
						}
					}
				}
			}
		}

		//Huy
		if (soluongbongkiemtra > 2) {
			diem = diem + soluongbongkiemtra;
			chucnang.ChoiNhac(2);
			chucnang.Rung(200);
			for (int i = 0; i < quabongheight; i++)
			{
				for (int j = 0; j < quabongwidth; j++)
				{
					if (!danhsachquabong[i][j].phahuy && danhsachquabong[i][j].kiemtracotreo)
					{
						danhsachquabong[i][j].phahuy = true;
						soluongquabong--;
						danhsachmauhientai[danhsachquabong[i][j].maubong]--;
					}
				}
			}
			//Bong Tu Do
			for (int i = 0; i < quabongheight; i++)
			{
				for (int j = 0; j < quabongwidth; j++)
				{
					if(!danhsachquabong[i][j].phahuy)
					{
						if(i == 0)
						{
							danhsachquabong[i][j].ok = true;
							QuetOk(i, j);
						}
						else
						{
							if(danhsachquabong[i][j].ok == true)
								QuetOk(i, j);
						}
					}
				}
				for(int k = quabongwidth - 1; k >= 0; k--)
				{
					if(!danhsachquabong[i][k].phahuy)
					{
						if(i == 0)
						{
							danhsachquabong[i][k].ok = true;
							QuetOk(i, k);
						}
						else
						{
							if(danhsachquabong[i][k].ok == true)
								QuetOk(i, k);
						}
					}
				}
			}
			for(int i = 0; i < quabongheight; i++)
			{
				for(int j = 0; j < quabongwidth; j++)
				{
					if(!danhsachquabong[i][j].phahuy)
					{
						if(danhsachquabong[i][j].ok)
						{
							danhsachquabong[i][j].ok = false;
						}
						else
						{
							danhsachquabong[i][j].phahuy = true;
							danhsachquabong[i][j].kiemtracotreo = true;
							danhsachmauhientai[danhsachquabong[i][j].maubong]--;
							soluongquabong--;
						}
					}
				}
			}
		}
		else
		{
			for (int i = 0; i < quabongheight; i++)
			{
				for (int j = 0; j < quabongwidth; j++)
				{
					if (!danhsachquabong[i][j].phahuy)
					{
						danhsachquabong[i][j].kiemtracotreo = false;
					}
				}
			}
		}
		
		boolean check;
		int index;
		for(int k = 0; k < danhsachquabongcho.length; k++)
		{
			check = true;
			for(int i = 0; i < quabongheight; i++)
			{
				for(int j = 0; j < quabongwidth; j++)
				{
					if(danhsachquabong[i][j].maubong == danhsachquabongcho[k].maubong && !danhsachquabong[i][j].phahuy)
					{
						check = false;
						break;
					}
				}
				if(!check)
					break;
			}
			if(check)
			{
				danhsachmauhientai[danhsachquabongcho[k].maubong] = 0;
				boolean checkdanhsach = true;
				for(int i = 0; i < danhsachmauhientai.length; i++)
				{
					if(danhsachmauhientai[i] != 0)
					{
						checkdanhsach = false;;
						break;
					}
				}
				if(checkdanhsach)
				{
					index = danhsachquabongcho[k].maubong;
				}
				else
				{
					index = random.nextInt(8);
					while (danhsachmauhientai[index] == 0) {
						index = random.nextInt(8);
					}
				}
				danhsachquabongcho[k].maubong = index;
				danhsachquabongcho[k].hinh = danhsachhinhquabong[index];
			}
		}
	}
	
	static void CapNhat()
	{
		if (!quabongdangdichuyen.phahuy)
		{
			if (dangdichuyen) {
				if (quabongdangdichuyen.x >= Xbandau + 30 * quabongwidth)
				{
					dotangX = -dotangX;
					chucnang.ChoiNhac(5);
				}
				if (quabongdangdichuyen.x <= Xbandau + 5) {
					dotangX = -dotangX;
					chucnang.ChoiNhac(5);
				}

				quabongdangdichuyen.x = (int) (quabongdangdichuyen.x + dotangX);
				int Y = Math.abs((int) (dotangY * dotangX));
				quabongdangdichuyen.y = quabongdangdichuyen.y - Y;
				KiemTraVaCham();
				KiemTraBongDeHuy();
			}
		}
		KiemTraThua();
		int sotang = SoTangBong();
		if(sotang < 3 && soluongquabong != 0)
		{
			try
			{
				TangThemQuaBong(soluongmau, 3 - sotang);
			}
			catch(Exception ex)
			{
				
			}
		}
	}
	
	static private void KiemTraThua()
	{
		for (int i = quabongheight - 1; i >= 0; i--)
		{
			for (int j = quabongwidth - 1; j >= 0; j--)
			{
				if (!danhsachquabong[i][j].phahuy) {
					if ((height - Ybandau - danhsachquabong[i][j].y) < 70) {
						thua = true;
					}
				}
			}
		}
	}
	
	private void VeQuaBong(Canvas canvas) {
		boolean change = false;
		if (demthoigiangiam >= thoigiangiam && demthoigiangiam % thoigiangiam == 0)
		{
			demthoigiangiam = 0;
			if(soluongmau < 8)
				soluongmau++;
			giam += 50;
			thoigiansuptang = thoigiansuptang - giam;
			if(thoigiansuptang < 50)
				thoigiansuptang = 50;
		}
		if (thoigian >= thoigiansuptang && thoigian % thoigiansuptang == 0)
		{
			thoigian = 0;
			try
			{
				TangThemQuaBong(soluongmau, 1);
			}
			catch(Exception ex)
			{
				
			}
		}
		for (int i = 0; i < quabongheight; i++)
		{
			for (int j = 0; j < quabongwidth; j++)
			{
				if (!danhsachquabong[i][j].phahuy)
				{
					if (change)
					{
						danhsachquabong[i][j].sotang = 1;
						danhsachquabong[i][j].y += danhsachquabong[i][j].sotang * 30;
					}
					danhsachquabong[i][j].draw(canvas);
				}
				else
				{
					if (danhsachquabong[i][j].kiemtracotreo && danhsachquabong[i][j].y < 2000)
					{
						danhsachquabong[i][j].y = danhsachquabong[i][j].y + 15;
						danhsachquabong[i][j].draw(canvas);
					}
				}
			}
		}
		
		if (!chothaydoi)
		{
			synchronized (danhsachquabongcho)
			{
				for (int i = 0; i < danhsachquabongcho.length; i++)
				{
					danhsachquabongcho[i].draw(canvas);
				}
			}
		}
		thoigian++;
		demthoigiangiam++;
	}
	
	private static void KiemTraVaCham()
	{
		if (dangdichuyen) {
			if (quabongdangdichuyen.y <= (Ybandau + (sotang * 30)))
			{
				int posX = (quabongdangdichuyen.x - 30) / 30;
				
				if (posX < 0)
				{
					posX = 0;
				}
				if (posX < quabongwidth)
				{
					if (danhsachquabong[0][posX].phahuy) {
						danhsachquabong[0][posX].phahuy = false;
						danhsachquabong[0][posX].hinh = danhsachhinhquabong[quabongdangdichuyen.maubong];
						if (0 % 2 == chuyendoiqualai)
							danhsachquabong[0][posX].x = posX * 30 + Xbandau;
						else
							danhsachquabong[0][posX].x = posX * 30 + Xbandau + 15;
						
						danhsachquabong[0][posX].kiemtracotreo = true;
						danhsachquabong[0][posX].y = Ybandau + (sotang * 30);
						danhsachquabong[0][posX].maubong = quabongdangdichuyen.maubong;
						danhsachquabong[0][posX].sotang = sotang;
						dangdichuyen = false;
						quabongdangdichuyen.phahuy = true;
						soluongquabong++;
						
						vitriquabongdehuy.add(new Point(posX, 0));
						maubongkiemtra = quabongdangdichuyen.maubong;
						chucnang.ChoiNhac(1);
						danhsachmauhientai[quabongdangdichuyen.maubong]++;
					}
				}
			}
			for (int i = quabongheight - 1; i >= 0 && dangdichuyen; i--)
			{
				for (int j = quabongwidth - 1; j >= 0 && dangdichuyen; j--)
				{
					QuaBong curr = danhsachquabong[i][j];
					if (!curr.phahuy)
					{
						if ((curr.y + 30) >= quabongdangdichuyen.y)
						{
							if (i < quabongheight - 1)
							{
								if ((quabongdangdichuyen.x - curr.x) >= -15
										&& (quabongdangdichuyen.x - curr.x) <= 15)
								{
									if (i % 2 == chuyendoiqualai)
									{
										if (j > 0)
										{
											if (danhsachquabong[i + 1][j - 1].phahuy)
											{
												danhsachquabong[i + 1][j - 1].hinh = danhsachhinhquabong[quabongdangdichuyen.maubong];
												danhsachquabong[i + 1][j - 1].phahuy = false;
												danhsachquabong[i + 1][j - 1].x = curr.x - 15;
												danhsachquabong[i + 1][j - 1].y = curr.y + 30;
												
												danhsachquabong[i + 1][j - 1].kiemtracotreo = true;
												danhsachquabong[i + 1][j - 1].maubong = quabongdangdichuyen.maubong;
												dangdichuyen = false;
												quabongdangdichuyen.phahuy = true;
												soluongquabong++;
												vitriquabongdehuy.add(new Point(j - 1, i + 1));
												maubongkiemtra = quabongdangdichuyen.maubong;
												chucnang.ChoiNhac(1);
												danhsachmauhientai[quabongdangdichuyen.maubong]++;
											}
										}
									}
									else
									{
										if (danhsachquabong[i + 1][j].phahuy)
										{
											danhsachquabong[i + 1][j].phahuy = false;
											danhsachquabong[i + 1][j].hinh = danhsachhinhquabong[quabongdangdichuyen.maubong];
											danhsachquabong[i + 1][j].x = curr.x - 15;
											danhsachquabong[i + 1][j].y = curr.y + 30;
											
											danhsachquabong[i + 1][j].maubong = quabongdangdichuyen.maubong;
											danhsachquabong[i + 1][j].kiemtracotreo = true;
											dangdichuyen = false;
											quabongdangdichuyen.phahuy = true;
											soluongquabong++;
											vitriquabongdehuy.add(new Point(j, i + 1));
											maubongkiemtra = quabongdangdichuyen.maubong;											//
											chucnang.ChoiNhac(1);
											danhsachmauhientai[quabongdangdichuyen.maubong]++;
										}
									}
								}
								else
								{
									if ((quabongdangdichuyen.x - curr.x) >= 15 &&
											(quabongdangdichuyen.x - curr.x) <= 30)
									{
										if (i % 2 == chuyendoiqualai)
										{
											if (danhsachquabong[i + 1][j].phahuy)
											{
												danhsachquabong[i + 1][j].phahuy = false;
												danhsachquabong[i + 1][j].hinh = danhsachhinhquabong[quabongdangdichuyen.maubong];
												danhsachquabong[i + 1][j].x = curr.x + 15;
												danhsachquabong[i + 1][j].y = curr.y + 30;
												
												danhsachquabong[i + 1][j].kiemtracotreo = true;
												danhsachquabong[i + 1][j].maubong = quabongdangdichuyen.maubong;
												dangdichuyen = false;
												quabongdangdichuyen.phahuy = true;
												soluongquabong++;
												vitriquabongdehuy.add(new Point(j, i + 1));
												maubongkiemtra = quabongdangdichuyen.maubong;
												chucnang.ChoiNhac(1);
												danhsachmauhientai[quabongdangdichuyen.maubong]++;
											}
										}
										else
										{
											if (j < quabongwidth - 1)
											{
												if (danhsachquabong[i + 1][j + 1].phahuy)
												{
													danhsachquabong[i + 1][j + 1].phahuy = false;
													danhsachquabong[i + 1][j + 1].hinh = danhsachhinhquabong[quabongdangdichuyen.maubong];
													danhsachquabong[i + 1][j + 1].x = curr.x + 15;
													danhsachquabong[i + 1][j + 1].y = curr.y + 30;
													danhsachquabong[i + 1][j + 1].maubong = quabongdangdichuyen.maubong;
													danhsachquabong[i + 1][j + 1].kiemtracotreo = true;
													dangdichuyen = false;
													quabongdangdichuyen.phahuy = true;
													soluongquabong++;
													vitriquabongdehuy.add(new Point(j + 1, i + 1));
													maubongkiemtra = quabongdangdichuyen.maubong;
													chucnang.ChoiNhac(1);
													danhsachmauhientai[quabongdangdichuyen.maubong]++;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private static void TangThemQuaBong(int soluongmau, int soluongtang)
	{
		int count = 0;
		boolean dautien = true;
		chuyendoiqualai = 0;
		QuaBong[] bandomoi = new QuaBong[quabongheight*quabongwidth + soluongtang*quabongwidth];
		
		for (int i = 0; i < soluongtang*quabongwidth; i++)
		{
			bandomoi[i] = new QuaBong();
			bandomoi[i].maubong = random.nextInt(soluongmau);
			bandomoi[i].phahuy = false;
			bandomoi[i].kiemtracotreo = false;
		}
		for (int i = 0; i < quabongheight; i++)
		{
			for (int j = 0; j < quabongwidth; j++)
			{
				bandomoi[count + soluongtang*quabongwidth] = new QuaBong(danhsachquabong[i][j]);
				if(dautien)
				{
					if((danhsachquabong[i][j].x - Xbandau) % 30 == 0)
						chuyendoiqualai = 1;
					dautien = false;
				}
				count++;
			}
		}
		if(soluongtang % 2 == 0)
		{
			if(chuyendoiqualai == 1)
				chuyendoiqualai = 0;
			else
				chuyendoiqualai = 1;
		}

		KhoiTaoLai(bandomoi);
	}
	
	private static int SoTangBong()
	{
		int sotang = 0;
		for (int i = quabongheight - 1; i >= 0; i--)
		{
			for (int j = 0; j < quabongwidth; j++)
			{
				if(!danhsachquabong[i][j].phahuy)
				{
					sotang = i + 1;
					break;
				}
			}
			if(sotang != 0)
				break;
		}
		return sotang;
	}
	
	public static Bundle BackupCheDoChoiTuDo()
	{
		Bundle bundle = new Bundle();
		int count = 0;
		int[] danhsachbonghientai = new int[quabongheight*quabongwidth];
		int[] danhsachbongcho = new int[danhsachquabongcho.length];
		
		for (int i = 0; i < quabongheight; i++)
		{
			for (int j = 0; j < quabongwidth; j++)
			{
				if(!danhsachquabong[i][j].phahuy)
				{
					danhsachbonghientai[count] = danhsachquabong[i][j].maubong;
				}
				else
					danhsachbonghientai[count] = -1;
				count++;
			}
		}
		for(int i = 0; i < danhsachquabongcho.length; i++)
			danhsachbongcho[i] = danhsachquabongcho[i].maubong;
		
		bundle.putIntArray("ArrayQuaBong", danhsachbonghientai);
		bundle.putIntArray("ArrayQuaBongCho", danhsachbongcho);
		bundle.putInt("CheDo", 2);
    	bundle.putLong("Diem", diem);
    	bundle.putInt("SoTang", sotang);
    	bundle.putInt("ThoiGianSupTang", thoigiansuptang);
    	bundle.putInt("Giam", giam);
    	bundle.putInt("DemThoiGianGiam", demthoigiangiam);
    	bundle.putInt("SoLuongMau", soluongmau);
    	bundle.putInt("ChuyenDoiQuaLai", chuyendoiqualai);
		return bundle;
	}
	
	private static void QuetOk(int i, int j)
	{
		if(j < quabongwidth - 1)
		{
			if (!danhsachquabong[i][j + 1].phahuy)
			{
				danhsachquabong[i][j + 1].ok = true;
			}
		}
		if (j > 0)
		{
			if (!danhsachquabong[i][j - 1].phahuy)
			{
				danhsachquabong[i][j - 1].ok = true;
			}
		}
		if (i % 2 == chuyendoiqualai)
		{
			if (i < quabongheight - 1)
			{
				if (!danhsachquabong[i + 1][j].phahuy)
				{
					danhsachquabong[i + 1][j].ok = true;
				}
				if (j > 0)
				{
					if (!danhsachquabong[i + 1][j - 1].phahuy)
					{
						danhsachquabong[i + 1][j - 1].ok = true;
					}
				}
			}
			
			if (i > 0)
			{
				if (!danhsachquabong[i - 1][j].phahuy)
				{
					danhsachquabong[i - 1][j].ok = true;
					if(i - 2 >= 0)
					{
						if (!danhsachquabong[i - 2][j].phahuy)
						{
							danhsachquabong[i - 2][j].ok = true;
						}
						if(j < quabongwidth - 1)
						{
							if (!danhsachquabong[i - 2][j + 1].phahuy)
							{
								danhsachquabong[i - 2][j + 1].ok = true;
							}
						}
					}
				}
				if (j > 0)
				{
					if (!danhsachquabong[i - 1][j - 1].phahuy)
					{
						danhsachquabong[i - 1][j - 1].ok = true;
						if(i - 2 >= 0)
						{
							if (!danhsachquabong[i - 2][j].phahuy)
							{
								danhsachquabong[i - 2][j].ok = true;
							}
							if (!danhsachquabong[i - 2][j - 1].phahuy)
							{
								danhsachquabong[i - 2][j - 1].ok = true;
							}
						}
					}
				}
			}
		}
		else
		{
			if (i < quabongheight - 1)
			{
				if (j < quabongwidth - 1)
				{
					if (!danhsachquabong[i + 1][j + 1].phahuy)
					{
						danhsachquabong[i + 1][j + 1].ok = true;
					}
				}
				if (!danhsachquabong[i + 1][j].phahuy)
				{
					danhsachquabong[i + 1][j].ok = true;
				}
			}
			
			if (i > 0)
			{
				if (j < quabongwidth - 1)
				{
					if (!danhsachquabong[i - 1][j + 1].phahuy)
					{
						danhsachquabong[i - 1][j + 1].ok = true;
						if(i - 2 >= 0)
						{
							if (!danhsachquabong[i - 2][j].phahuy)
							{
								danhsachquabong[i - 2][j].ok = true;
							}
							if (!danhsachquabong[i - 2][j + 1].phahuy)
							{
								danhsachquabong[i - 2][j + 1].ok = true;
							}
						}
					}
				}
				if (!danhsachquabong[i - 1][j].phahuy)
				{
					danhsachquabong[i - 1][j].ok = true;
					if(i - 2 >= 0)
					{
						if (!danhsachquabong[i - 2][j].phahuy)
						{
							danhsachquabong[i - 2][j].ok = true;
						}
						if(j > 0)
						{
							if (!danhsachquabong[i - 2][j - 1].phahuy)
							{
								danhsachquabong[i - 2][j - 1].ok = true;
							}
						}
					}
				}
			}
		}
	}
}
