import java.io.*;
import java.util.*;

class baek_14501 {
	public static int answer;
	public static boolean[] check;
	public static int n;
	public static int[] T;
	public static int[] P;

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_14501.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// n일
		n = scan.nextInt();

		T = new int[n];
		P = new int[n];
		check = new boolean[n];
		// T, P값 받아오기
		for(int i = 0; i < n; i++){
			T[i] = scan.nextInt();
			P[i] = scan.nextInt();
		}
		
		answer = 0;
		process(0, 0);
		System.out.println(answer);
	}

	public static void process(int cur_n, int cur_ans){
		
		// 끝나는 값
		if(cur_n == n){
			answer = Math.max(cur_ans, answer);
			return;
		}

		
		for(int i = cur_n; i < n; i++){
			// 이날 일 하기로 되어있다면 패스 
			if (check[i]){
				continue;
			}
			//이번 cur_n 상담을 포함한다면 
			//이번 상담의 걸리는 모든날을 true로 만든다.
			
			if(i+T[i] <= n) {
				for(int j = 0; j < T[i]; j++){
					check[i + j] = true;
				}
				process(i+T[i], cur_ans+P[i]);
				//이번 상담을 포함 안한다면, check를 다서 uncheck
				for(int j = 0; j < T[i]; j++){
					check[i + j] = false;
				}	
			} 
			//이번 상담 포함 안하기	
			if(i+1 <= n){
				process(i+1, cur_ans);
			}
		}



	}

}


