import java.io.*;
import java.util.*;

class Ant {

	// 전역변수들.
	static char cur_char;
	static String cur_line;
	static String next_line;
	static int count;

	// input_ant에 테스트 케이스 수와, 몇번째 개미수열까지 프린트할껀지 넣어줘.

	public static void main(String[] args) throws Exception {
		
		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_ant.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// 현재 라인. 받을 라인.
		cur_line = "1";
		// 다음 라인.
		next_line = "";
	
		int lineNum = scan.nextInt();

		// O(nm), lineNum = n
		for (int i = 0; i < lineNum; i++) {

			// 현재라인을 프린트
			System.out.print(cur_line);
			System.out.println();

			// 다음 라인을 만들고
			// O(m), m = cur_line.length()
			process();

			// 다음 차례를 위해 cur_line을 새로운 다음라인으로 바꿔줌.
			cur_line = next_line;
			next_line = "";

		}

	}

	// 현재라인을 읽어서 새로운 다음라인을 만든다.
	public static void process(){

		//카운트는 0
		count = 0;
		// 현재 캐릭터는 맨 앞자리
		cur_char = cur_line.charAt(0);

		for (int i = 0; i < cur_line.length(); i++) {
			// 이번자리가 현재캐릭터만 같으면, 카운트만 늘려줘.
			if (cur_char == cur_line.charAt(i)) {
				count++;
			}

			// 이번자리캐릭터랑 cur_char이 다르면, 다음라인에 정보 넘기고, 
			// cur_char을 이번자리 캐릭터로 바꿔줘.
			else {
				next_line += cur_char;
				next_line += count + "";
				cur_char = cur_line.charAt(i);
				count = 1;
			}

			// 마지막 캐릭터라면, nextline에 업데이트
			if (i == cur_line.length()-1) {
				next_line += cur_char;
				next_line += count +"";
			}
		}

	}

	
}