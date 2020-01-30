import java.io.*;
import java.util.*;


class expert_3282_dp {
	static int[][] dp_Map;

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_3282_dp.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// 테스트케이스 
		int testCase = scan.nextInt();

		// Test Case 돌리기 
		for (int tc = 1; tc <= testCase; tc++){

			//물건 갯수, 가방 무게, 물건무게와 가치 다 찾기.
			int n = scan.nextInt();
			int bag_weight = scan.nextInt();

			int[] weight = new int[n+1];
			int[] value = new int[n+1];

			dp_Map = new int[n+1][bag_weight+1];

			//무게, 가치 넣어놓기.
			for (int i = 1; i < n+1; i++){
				weight[i] = scan.nextInt();
				value[i] = scan.nextInt();
			}

			// 기본 베이스 케이스
			for (int i = 0; i < n+1; i++) {
				dp_Map[i][0] = 0;
			}
			for (int i = 0; i < bag_weight+1; i++){
				dp_Map[0][i] = 0;
			}

			

			// dp지도 채워넣기
			for (int i = 1; i < n+1; i++) {
				for (int w = 0; w < bag_weight+1; w++){
					// 만약 weight[i]가 w보다 크면, 포함 될 수 없다.
					if (weight[i] > w){
						dp_Map[i][w] = dp_Map[i-1][w];
						test = 1;
					} 
					// 포함 시킬 수 있으면,
					else {
						// weight[i]가 들어갔을때 value가 더 크면, i번 아이템 포함 
						if (dp_Map[i-1][w] < value[i] + dp_Map[i-1][w - weight[i]]) {
							dp_Map[i][w] = value[i] + dp_Map[i-1][w - weight[i]];
						} 
						// i번 아이템 포함 안시킴.
						else {
							dp_Map[i][w] = dp_Map[i-1][w];
						}
					}

					// 테스터
					// if (i == 3 && w == 1){
					// 	System.out.println("i: " + i);
					// 	System.out.println("w: " + w);
					// 	System.out.println("dp_map[i][w]: " + dp_Map[i][w]);
					// 	System.out.println("dp_Map[i-1][w] " + dp_Map[i-1][w]);
					// 	System.out.println("dp_Map[i-1][w - weight[i]]: " + dp_Map[i-1][w - weight[i]]);
					// 	System.out.println("value[i]: " + value[i]);
					// 	System.out.println(test);
					// }
				}
			}


			// 맵 프린트 테스터
			for(int i = 0; i < n+1; i++){
				for(int j = 0; j < bag_weight+1; j++){
					System.out.print(dp_Map[i][j] + " ");
					if (dp_Map[i][j] < 10) System.out.print(" ");
				}
				System.out.println();
			}
			
			System.out.println("#" + tc+ " " + dp_Map[n][bag_weight]);
			
		}

	} 


	







	


}