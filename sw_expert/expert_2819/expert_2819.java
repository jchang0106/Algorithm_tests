import java.io.*;
import java.util.*;

class expert_2819 {
	static int[][] map;
	static HashSet<String> ans_set;

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_2819.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// 테스트케이스 
		int testCase = scan.nextInt();

		// Test Case 돌리기 
		for (int tc = 1; tc <= testCase; tc++){

			// 맵 만들기 
			map = new int[4][4];

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = scan.nextInt();
				}
			}

			// 중복 없는 정답셋
			ans_set = new HashSet<String>();

			//7자리 숫자가 될 num
			String num = "";
			// 7자리 까지 세볼 count
			int count = 0;

			// 시작점은 모든 곳에서 해봐야함 (임)
			for(int x = 0; x < 4; x++){
				for (int y = 0; y < 4; y++){
					search(num, count, x, y);
				}
			}

			// 정답 출력
			System.out.println("#" + tc + " " + ans_set.size());


		}


	}


	public static void search(String num, int count, int x, int y){

		// 7번째면, 정답을 ans_set에 넣고 끝냄
		if(count >= 7){
			ans_set.add(num);
			return;
		}

		// 위 아래 양옆 4방향으로 가서 search.
		if( 0 <= x+1 && x+1 < 4 ) search(num + map[x+1][y], count+1, x+1, y);
		if( 0 <= x-1 && x-1 < 4 ) search(num + map[x-1][y], count+1, x-1, y);
		if( 0 <= y+1 && y+1 < 4 ) search(num + map[x][y+1], count+1, x, y+1);
		if( 0 <= y-1 && y-1 < 4 ) search(num + map[x][y-1], count+1, x, y-1);


	}


}

