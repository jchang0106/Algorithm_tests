package SWExpertAcademy;

import java.util.Scanner;

public class Test_A {

	static int N, K;
	static int [][] map;
	static int[] Pos = new int[2];
	static int[][] barePos = new int[900][2];
	static int bareCnt;
	static int cnt;
	static boolean[][] mark;
	static int[][] draw;
	static int[][] n_Map;
	static boolean[][] way;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TestCase = sc.nextInt();
		
		for(int tc=1; tc<=TestCase; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			bareCnt = 0;
			cnt=0;
			mark = new boolean[N][N];
			draw = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					
					if(map[i][j] != 1 && map[i][j] != 2) mark[i][j] = true;
					
					if(map[i][j] == 4) {
						Pos[0] = i;
						Pos[1] = j; 
					}
					
					if(map[i][j] == 2) {
						barePos[bareCnt][0] = i;
						barePos[bareCnt++][1] = j; 	
					}
				}
			}
			n_Map = new int[N][N];
			way = new boolean[N][N];
			
			for(int k=0; k<bareCnt; k++) {
				draw = new int[N][N];
				mark = new boolean[N][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j] != 1 && map[i][j] != 2) {
							mark[i][j] = true;
						}
					}
				}
				check(k,K,0,0);
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {n_Map[i][j] += draw[i][j];}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					way[i][j] = true;
					
					if(map[i][j] == 1 || map[i][j] == 2) way[i][j] = false;
					if(n_Map[i][j] == 1) way[i][j] = false;
				}
			}
	
			dfs(Pos[0],Pos[1]);
		}
		
		System.out.println("#"+TestCase+" "+cnt);
	}
	public static void dfs(int x, int y) {
		if(map[x][y] == 3) cnt++;
		//상
		if(x>0 && way[x-1][y]) {
			way[x-1][y] = false;
			dfs(x-1,y);
		}
		//하
		if(x<N-1 && way[x+1][y]) {
			way[x+1][y] = false;
			dfs(x+1,y);
		}
		//좌
		if(y>0 && way[x][y-1]) {
			way[x][y-1] = false;
			dfs(x,y-1);
		}
		//우
		if(y<N-1 && way[x][y+1]) {
			way[x][y+1] = false;
			dfs(x,y+1);
		}
	}
	
	public static void check(int b, int move, int x, int y) {
		if(b==bareCnt) {
			return;
		}
		if(move!=0) {
			if(move == K) {
				x=barePos[b][0];
				y=barePos[b][1];
			}
			//상
			if(x>0 && mark[x-1][y]) {
				mark[x-1][y] = false;
				draw[x-1][y] = 1;
				check(b, move-1, x-1, y);
				mark[x-1][y] = true;
			}
			//하
			if(x<N-1 && mark[x+1][y]) {
				mark[x+1][y] = false;
				draw[x+1][y] = 1;
				check(b, move-1, x+1, y);
				mark[x+1][y] = true;
			}
			//좌
			if(y>0 && mark[x][y-1]) {
				mark[x][y-1] = false;
				draw[x][y-1] = 1;
				check(b, move-1, x, y-1);
				mark[x][y-1] = true;
			}
			//우
			if(y<N-1 && mark[x][y+1]) {
				mark[x][y+1] = false;
				draw[x][y+1] = 1;
				check(b, move-1, x, y+1);
				mark[x][y+1] = true;
			}
		}
	}
}