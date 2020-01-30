import java.io.*;
import java.util.*;


class baekjun_1012 {
	static int[][] map;
	static int garo;
	static int sero;

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_1012.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		int tc = scan.nextInt();

		for(int test = 0; test < tc; test++){

			// 가로 세로줄 수 받아오기
			garo = scan.nextInt();
			sero = scan.nextInt();
			map = new int[garo][sero];

			int n = scan.nextInt();
			// map에 배추가 있는지 없는지 표시
			for (int i = 0; i < n; i++){
				map[scan.nextInt()][scan.nextInt()] = 1;
			}

			// 맵 프린트
			// for (int i = 0; i < garo; i++){
			// 	for (int j = 0; j < sero; j++){
			// 		System.out.print(map[i][j] + " ");
			// 	}
			// 	System.out.println();
			// }
			// 지렁이수
			int count = 0;

			for (int i = 0; i < garo; i++){
				for (int j = 0; j < sero; j++){
					//1이면 배추 돌리고, 지렁이 한마리. 
					if(map[i][j] == 1){
						baeChoo(i,j);
						// 테스트 프린트.
						// System.out.println("i: " + i + " j: " + j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	// x,y 인접한 곳에 배추가 있으면 없애 버림. 0으로 바꿈. 
	public static void baeChoo(int x, int y){

		for(int i = 0; i < 4; i++){

			int nextX = x;
			int nextY = y;

			if (i == 0) nextX += 1;
			else if(i == 1) nextX -= 1;
			else if(i == 2) nextY += 1;
			else if(i == 3) nextY -= 1;

			if (nextX < 0 || nextY < 0 || nextX >= garo || nextY >=sero ){
				continue;
			}
			// 테스트프린트.
			// System.out.println(nextX + "     " + nextY);

			if(map[nextX][nextY] == 1){
				map[nextX][nextY] = 0;
				baeChoo(nextX, nextY);
			}

		}

	}
}