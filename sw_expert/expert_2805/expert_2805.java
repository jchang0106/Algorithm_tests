import java.io.*;
import java.util.*;

class expert_2805 {

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_2805.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// 테스트케이스 
		int testCase = scan.nextInt();

		// Test Case 돌리기 
		for (int tc = 1; tc <= testCase; tc++){

			// 홀수 n
			int n = scan.nextInt();

			// 홀수 n의 반 (내림)  예: 5/2 = 2
			int half_pt = (n/2);

			// 정답
			int ans = 0;

			// n개의 가로줄
			for (int i = 0; i < n; i++){

				// 가로줄 받아오기
				String line = scan.next();
	
				// abs(half-i) 부터 n - abs(half-i) -1까지 돌려서 더하기
				for (int j = Math.abs(half_pt - i); j < n-Math.abs(half_pt-i); j++) {
			
					ans += line.charAt(j) - '0';

				}


			}

			// 정답 출력
			System.out.println("#" + tc + " " + ans);


		}



	}

}

