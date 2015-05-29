package net.game;

import java.util.Random;

public class BanDo {
	static int [][] bandos;
	
	static void initMaps(){
		bandos = new int[9][];
		int [] bandolv1 = {0,0,1,1,2,2,1,2,
				0,0,1,1,2,2,2,2,
				2,1,0};
		int [] bandolv2 = {0,0,1,1,2,2,0,2,
				0,0,1,1,2,2,0,2,
				2,0,1,0,0,1,1,2,
				2,1,0,0,1,1
				};
		int [] bandolv3 = {0,0,0,0,0,0,0,0,
				1,1,1,1,1,1,1,1,
				2,2,2,2,2,2,2,2,
				3,3,3
				};
		int [] bandolv4 = {-1,-1,-1,0,0,0,-1,-1,
				-1,-1,-1,0,0,-1,-1,-1,
				-1,-1,-1,-1,1,-1,-1,-1,
				-1,-1,-1,2,-1,-1,-1,-1,
				-1,-1,-1,-1,3,-1,-1,-1,
				-1,-1,-1,4,-1,-1,-1,-1,
				-1,-1,-1,-1,4,-1,-1,-1
				};
		int [] bandolv5 = {-1,0,0,0,0,0,0,-1,
				-1,1,1,1,1,1,-1,-1,
				-1,-1,2,2,2,2,-1,-1,
				-1,-1,-1,3,-1,-1,-1,-1,
				-1,-1,-1,4,4,-1,-1,-1,
				-1,-1,-1,0,-1,-1,-1,-1,
				-1,-1,-1,3,3,-1,-1,-1
				};
		int [] bandolv6 = {-1,-1,0,-1,-1,0,-1,-1,
				-1,-1,1,1,1,-1,-1,-1,
				-1,-1,-1,2,2,-1,-1,-1,
				-1,-1,3,3,3,-1,-1,-1,
				-1,-1,-1,4,4,-1,-1,-1,
				-1,-1,0,1,0,-1,-1,-1,
				-1,-1,-1,1,1,-1,-1,-1,
				-1,-1,-1,5,-1,-1,-1,-1
				};
		int [] bandolv7 = {0,-1,-1,-1,-1,-1,-1,0,
				1,1,1,1,1,1,1,-1,
				2,-1,-1,-1,-1,-1,-1,2,
				3,3,4,4,4,3,3,-1,
				-1,-1,-1,5,-1,-1,-1,-1
				};
		int [] bandolv8 = {-1,1,1,1,1,1,1,-1,
				0,-1,-1,-1,-1,2,-1,-1,
				4,-1,-1,-1,-1,0,3,3,
				4,5,5,6,3,-1,2,-1,
				1,1,1,2,3,-1,-1,-1
				};
		int [] bandolv9 = {-1,0,-1,1,-1,2,-1,3,
				1,2,-1,3,1,-1,3,-1,
				1,-1,3,-1,5,-1,6,-1,
				4,4,-1,3,3,-1,0,-1,
				-1,7,-1,2,-1,3,-1,1,
				6,6,-1,2,2,-1,1,-1,
				1,-1,1,-1,1,-1,1,-1,
				3,3,-1,1,1,-1,7,-1,
				-1,0,-1,0,-1,3,-1,3
				};
		
		XaoTron(bandolv1, 3);
		XaoTron(bandolv2, 3);
		XaoTron(bandolv3, 4);
		XaoTron(bandolv4, 5);
		XaoTron(bandolv5, 5);
		XaoTron(bandolv6, 6);
		XaoTron(bandolv7, 6);
		XaoTron(bandolv8, 7);
		XaoTron(bandolv9, 8);
		
		bandos[0] = bandolv1;
		bandos[1] = bandolv2;
		bandos[2] = bandolv3;
		bandos[3] = bandolv4;
		bandos[4] = bandolv5;
		bandos[5] = bandolv6;
		bandos[6] = bandolv7;
		bandos[7] = bandolv8;
		bandos[8] = bandolv9;
	}
	
	static void XaoTron(int[] bando, int somau)
	{
		int[] mang = new int[somau];
		for(int i = 0; i < somau; i++)
			mang[i] = i;
		int temp = 0;
		int index1 = 0;
		int index2 = 0;
		Random rand = new Random();
		for(int i = 0; i <= 10; i++)
		{
			index1 = rand.nextInt(somau);
			index2 = rand.nextInt(somau);
			temp = mang[index2];
			mang[index2] = mang[index1];
			mang[index1] = temp;
		}
		for(int i = 0; i < bando.length; i++)
		{
			if(bando[i] != -1)
			{
				bando[i] = mang[bando[i]];
			}
		}
	}
}
