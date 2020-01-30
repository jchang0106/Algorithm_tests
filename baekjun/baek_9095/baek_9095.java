import java.io.*;
import java.util.*;

class baek_9095 {
	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		// System.setIn(new FileInputStream("input_hanoi.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// 테스트케이스 갯수
		int tc = scan.nextInt();

		// 테스트 케이스 갯수만큼
		for (int i = 0; i < tc; i++){

			// n을 스캔
			int n = scan.nextInt();

			// sumNum(n)
			System.out.println(sumNum(n));

		}
	}

	// n을 1,2,3의 합으로 구할 수 있는 경우의 수 구하기
	public static int sumNum(int n) {


		// 1은 1번, 2는 2번, 3은 3번의 경우의수가 있다
		if(n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (n == 3) {
			return 4;
		}

		// sumNum(n) = sumNum(n-1) + sumNum(n-2) + sumNum(n-3)
		return sumNum(n-1) + sumNum(n-2) + sumNum(n-3);

	
	}
}


