import java.io.*;
import java.util.*;

class expert_3282 {

	// 가방에 들어갈 수 있는 부피 K
	static int knapsack_vol;
	// 가방에 넣을 수 있는 가장 큰 가치 (정답)
	static int max_val;

	static Stuff[] stuffs;


	// 물건 객체 
	static class Stuff {

		// 물건의 가치와 부피
		int value;
		int volume;

		// 물건의 가치와 부피를 initialize
		public Stuff(int volume, int value) {
			this.value = value;
			this.volume = volume;
		}

		// 물건과 가치를 리턴
		public int getValue(){
			return this.value;
		}
		public int getVolume(){
			return this.volume;
		}


	}
	
	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_3282.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();

		// Test Case 10 개
		for (int tc = 1; tc <= testCase; tc++){

			// 총 물건 갯수
			int stuff_num = scan.nextInt();
			// 가방 부피
			knapsack_vol = scan.nextInt();

			// 물건 객채들의 배열
			stuffs = new Stuff[stuff_num];

			// 물건 객체들을 만들어서, 배열에 넣어줌 
			for (int i = 0; i < stuff_num; i++) {

				int volume = scan.nextInt();
				int value = scan.nextInt();
				stuffs[i] = new Stuff(volume, value);

			}
			// 테스트
			// for (int i = 0; i < stuff_num; i++) {

			// 	System.out.println(i 	+ " : " + stuffs[i].getValue() + ", " + stuffs[i].getVolume());
			// }

			int cur_vol = 0;
			int cur_val = 0;
			int cur_idx = -1;
			boolean[] dup_check = new boolean[stuff_num];
			maxValueCheck(cur_idx, cur_vol, cur_val, dup_check);

			System.out.println("#" + tc + " " + max_val);


		}

	}


	public static void maxValueCheck(int cur_idx, int cur_vol, int cur_val, boolean[] dup_check) {

		if (knapsack_vol <= cur_vol){
			int real_val = cur_val;
			if (knapsack_vol < cur_vol) {
				real_val = cur_val - stuffs[cur_idx].getValue();
			}
			if (max_val < real_val) {
				max_val = real_val;
				// 테스트 
				// if (real_val==4) {
				// 	System.out.println(cur_idx);
				// 	for(int i = 0; i < dup_check.length; i++){
				// 		System.out.println(i +"DUP : " + dup_check[i]);
				// 	}
				// }
			}
			return;
		} 
		
		boolean[] cur_dup_check = dup_check.clone();

		for (int i = 0; i < stuffs.length; i++){

			if (!cur_dup_check[i]){

				cur_dup_check[i] = true;
				cur_idx = i;
				maxValueCheck(cur_idx, cur_vol+stuffs[i].getVolume(), cur_val+stuffs[i].getValue(), cur_dup_check);

			}


		}




	}



}