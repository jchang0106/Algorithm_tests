import java.io.*;
import java.util.*;

class expert_1486 {

	public static int[] peo_height;
	public static int min_ans;
	public static int shelf_height;
	public static int peo_num;

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_1486.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();

		// Test Case
		for (int tc = 1; tc <= testCase; tc++){

			peo_num = scan.nextInt();
			shelf_height = scan.nextInt();

			peo_height = new int[peo_num];
			min_ans = Integer.MAX_VALUE;

			for(int i = 0; i < peo_num; i++){
				peo_height[i] = scan.nextInt();
				if (shelf_height == peo_height[i]) {
					min_ans = 0;
				}
			}

			if(min_ans != 0){
				process(0, 0);
			}
			System.out.println("#" + tc + " " + min_ans);
		}
	}


	public static void process(int cur_index, int cur_total_height){

		if(cur_total_height >= shelf_height){
			min_ans = Math.min(cur_total_height - shelf_height, min_ans);
			return;
		}

		for(int i = cur_index; i < peo_num; i++){
			// i인덱스 포함
			process(i+1, cur_total_height + peo_height[i]);
			// i인덱스 포함X
		}


		return;

	}
}