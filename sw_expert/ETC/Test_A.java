import java.util.*;

public class Test_A {
	// 0=빈곳, 1 = 돌, 2 = 곰, 3 = 약초, 4 = 약초꾼


	// 지도 길이 N, 곰이 움직일 수 있는 범위 K
	static int N;
	static int K;

	// 안전지대에 약초꾼이 갈 수 있는 약초의 갯수
	static int answer;
	
	// 지도 정보
	static int[][] map;
	// 곰들 위치
	static ArrayList<Integer> bearX;
	static ArrayList<Integer> bearY;
	// 약초꾼들 위치
	static ArrayList<Integer> peopX;
	static ArrayList<Integer> peopY;

	// 안전지대(0,1일때 안전지대)와 곰 영향권
	static int[][] safe_area;
	static int[][] cur_bear_area;

	// 동서남북 
	static int[] row_dir = {0, 0, 1, -1};
	static int[] col_dir = {1, -1, 0, 0};

	// 약초꾼이 가본 곳을 기억하는 
	static boolean[][] mem;


	/* 
	* 각 test case 마다
	* 곰의 영향권을 dfs로 계산하여 safe_area를 확보한다.
	* 그 후 안전지대 중에서도 약초꾼이 access가능한 곳에
	* 있는 약초의 수를 구한다. 
	*/ 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		// Test Case 
		for(int tc = 1; tc <= testCase; tc++) {

			// N,K값 받아오기
			N = sc.nextInt();
			K = sc.nextInt();

			// 모든 variable 선언
			map = new int[N][N];
			bearX = new ArrayList<Integer>();
			bearY = new ArrayList<Integer>();
			peopX = new ArrayList<Integer>();
			peopY = new ArrayList<Integer>();
			safe_area = new int[N][N];
			mem = new boolean[N][N];


			// 지도 정보 넣기. 
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){

					int val = sc.nextInt();
					map[i][j] = val;
					// 곰 위치 파악
					if (val == 2) {
						bearX.add(i);
						bearY.add(j);
					}
					// 약초꾼 위치 파악
					if (val == 4) {
						peopX.add(i);
						peopY.add(j);
					}

					// 돌 위치를 안전지대에서 빼기
					if (val == 1) {
						safe_area[i][j] = 1;
					}
				}
			} 



			// 곰 영향권 알아내기
			// 각 위치에 몇마리에 곰이 지나갔는 지 알아내기
			// 1이나 0인곳은 곰의 영향권이 아님.

			// 각 곰이 dfs로 K번 움직일 수 있는 모든 곳을 알아내어 safe_area에 업데이트
			for(int i = 0; i < bearX.size(); i++) {

				cur_bear_area = new int[N][N];
				bear_area_cal(0, bearX.get(i), bearY.get(i));

				// cur_bear_area에 1이상인 곳은 이번 곰이 지나간 곳이니까
				// safe_area에 업데이트 해준다
				for (int row = 0; row < N; row++){
					for(int col = 0; col < N; col++){
						if(cur_bear_area[row][col] > 0) {
							safe_area[row][col]++;
						}
					}
				}
			}

			// 프린트 테스트
			// System.out.println();
			// for(int i = 0; i < N; i++){
			// 	for(int j = 0; j < N; j++){
			// 		System.out.print(safe_area[i][j] + " ");
			// 	}
			// 	System.out.println();
			// }


			// 안전지대 safe_area가 valid함. 0,1인 곳을 약초꾼들이 
			// dfs로 모든 곳을 가보게 하여서 약초가 있는 곳을 찾는다. 
			for(int i = 0; i < peopX.size(); i++) {
				safeGrassCal(peopX.get(i), peopY.get(i));
			}

			// 정답 프린트 
			System.out.println("#" + tc + " " + answer);

			
		}

	}

	//DFS로 cur_step이 K번 일때 까지 갈 수 있는 모든 곳에 가서 cur_bear_area 를 업데이트
	public static void bear_area_cal(int cur_step, int cur_row, int cur_col){

		// 이번 위치 업데이트 
		cur_bear_area[cur_row][cur_col]++;
		//K 번이면 리턴 
		if(cur_step == K){
			return;
		}

		// 다음 번 step의 row, col 
		int nextRow;
		int nextCol;

		// 동서남북 
		for(int dir = 0; dir < 4; dir++){
			nextRow = cur_row + row_dir[dir];
			nextCol = cur_col + col_dir[dir];

			// 곰은 바위가 없으면서 맵 안쪽이면서, 다른 곰이 아닌 곳을 갈 수 있따.
			if( nextPosCheck(nextRow, nextCol) && map[nextRow][nextCol] != 2){
				bear_area_cal(cur_step + 1, nextRow, nextCol);
			}
		}

	}


	// 약초꾼부터 시작하여 안전지대 안에서 움직이면서, 약초가 있다면 정답++
	public static void safeGrassCal(int cur_row, int cur_col){
		// 지금 자리에 와봤다는 것 업데이트
		mem[cur_row][cur_col] = true;
		// 지금 자리가 안전지대가 아니면 바로 return. (약초꾼이 안전지대에 없는 경우)
		if(safe_area[cur_row][cur_col] == 1){
			return;
		}
		// 지금 자리에 약초가 있다면, answer++
		if(map[cur_row][cur_col] == 3){
			answer++;
		}

		// 다음 번 step의 row, col 
		int nextRow;
		int nextCol;

		// 동서남북 
		for(int dir = 0; dir < 4; dir++){
			nextRow = cur_row + row_dir[dir];
			nextCol = cur_col + col_dir[dir];

			// 약초꾼이 갈 수 있는 곳인지 체크 
			// (돌이 있거나 맵 밖에 있으면 갈 수 없음) && (안전지대 밖이면 갈 수 없음) && (약초꾼이 가본 적 없음)
			if( nextPosCheck(nextRow, nextCol) && safe_area[nextRow][nextCol] != 1 
					&& !mem[nextRow][nextCol]){
				safeGrassCal(nextRow, nextCol);
			}
		}
	}


	// 돌이 있거나 맵 밖에 있으면 갈 수 없음 
	public static boolean nextPosCheck(int row, int col){

		// 맵 밖에 있으면 갈 수 없음 
		if(row < 0 || row >= N || col < 0 || col >=N){
			return false;
		}	

		// 돌이 있으면 갈 수 없음 
		if(map[row][col] == 1){
			return false;
		}

		return true;
	}

}