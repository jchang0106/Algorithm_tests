import java.io.*;
import java.util.*;


class baekjun_2156 {
	static int[] wine;
	static int[] memo;

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_2156.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		// 포도주양
		wine = new int[n];
		// n번째 max값 저장해놓기.
		memo = new int[n];
		// 포도주양 스캔
		for(int i = 0; i < n; i++) {
			wine[i] = scan.nextInt();
		}

		System.out.println(wine_max(n));
	} 

	public static int wine_max(int n){

		// n이 3이였으면 n-3 = 0이 됨.
		if(n == 0){
			return 0;
		}
		// 와인이 총 1잔일때 
		if(n == 1){
			return wine[1-1];
		}
		// 와인이 총 2잔일때 
		if(n == 2){
			return wine[1-1] + wine[2-1];
		}
		// 메모이제이션 
		if(memo[n-1] > 0){
			return memo[n-1];
		}
		// n, n-1, n-2번째 와인잔 세개를 봤을때 oox, oxo, xoo인 경우 max구하기.
		memo[n-1] = Math.max(wine_max(n-1), Math.max(wine_max(n-2) + wine[n-1], wine_max(n-3) + wine[n-1] + wine[n-2]));

		return memo[n-1];

	}
}