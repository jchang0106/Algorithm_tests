import java.io.*;
import java.util.*;


class baek_11052 {
	static int n;
	static int[] set;
	static int[] max_val;

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_11052.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// 테스트케이스 
		// int testCase = scan.nextInt();

		// // Test Case 돌리기 
		// for (int tc = 1; tc <= testCase; tc++){
		// }

		// 붕어빵 갯수
		n = scan.nextInt();

		// 붕어빵 세트 가격
		set = new int[n];
		for (int i = 0; i < n; i++){
			set[i] = scan.nextInt();
		}

		max_val = new int[n];
		for (int i = 0; i < n; i++){
			max_val[i] = -1;
		}

		System.out.println(recursion(n));

		for (int i = 0; i < n; i++){
			System.out.print(max_val[i] + "  ");

		}
		System.out.println();
		for (int i = 0; i < n; i++){
			System.out.print(set[i] + "  ");
			
		}
			// System.out.pr??int(set[i] + "  ");

	}


	public static int recursion(int cur_val){


		if (cur_val == 1){
			if (max_val[cur_val-1] == -1){
				max_val[cur_val-1] = set[cur_val-1];
			}
			return set[cur_val-1];
		} 

		ArrayList<Integer> toCompare = new ArrayList<Integer>();


		int halfPt = 0;

		if (cur_val % 1 == 0){
			halfPt = cur_val/2;
		} else {
			halfPt = (cur_val/2) +1;
		}

		for (int i = 1; i <= halfPt; i++){

			int a = cur_val-1;
			int b = cur_val-(cur_val-i);
			int recur_a = 0;
			int recur_b = 0;

			if (max_val[a-1] != -1) {
				recur_a = max_val[a-1];
			} else {
				recur_a = recursion(cur_val-i);
			}

			if (max_val[b-1] != -1) {
				recur_b = max_val[b-1];
			} else {
				recur_b = recursion(cur_val-(cur_val-i));
			}

			toCompare.add( recur_a + recur_b );

		}

		toCompare.add(set[cur_val-1]);
		if (cur_val == 4){
			for (int i = 0; i < toCompare.size(); i++){
				System.out.println(toCompare.get(i));
			}
		}

		System.out.println();
		int max = Collections.max(toCompare);

		// System.out.println();
		// System.out.println(max);
		// System.out.println();
		max_val[cur_val-1] = max;

		return max_val[cur_val-1];
		// return Math.max(set[cur_val-1], recursion(cur_val-1) + recursion(cur_val-(cur_val-1));





	}

}
