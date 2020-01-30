import java.io.*;
import java.util.*;

class Hanoi {
	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		// System.setIn(new FileInputStream("input_hanoi.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		hanoi(n, 1,2,3);
	}

	public static void hanoi(int n, int from, int stop_by, int to) {

		if (n == 1){
			System.out.println("From " + from + " to " + to + "    (plate" + n + ")");
			return;
		}

		hanoi(n-1, from, to, stop_by);
		System.out.println("From " + from + " to " + to + "    (plate" + n + ")");
		hanoi(n-1, stop_by, from, to);

	}
}


