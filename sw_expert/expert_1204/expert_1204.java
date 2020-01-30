import java.io.*;
import java.util.*;

class expert_1204 {

	public static void main(String[] args) throws Exception {
		
		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_1204.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// Test Case 
		for (int tc = 1; tc <= 10; tc++) {
			
			// Test Case번호
			int tc_num = scan.nextInt();

			// 점수 0점 ~ 100점 
			int[] score = new int[101];

			// 중복이 가장 많은 점수
			int maxScore = 0;

			// 학생 점수 1000개
			for (int i = 0; i < 1000; i++){
				// 점수를 읽어와서
				int cur_score = scan.nextInt();

				// score배열에 점수 위치에 +1 시켜줌
				score[cur_score]++;

				// 여태까지 중복이 가장 많은 수보다 현재 점수가 중복이 많으면, 바꿔줌 
				if (score[maxScore] < score[cur_score]) {

					maxScore = cur_score;

				} 
				
				// 두가지 숫자가 동시에 중복이 많으면, 그 중 점수가 큰 숫자를 max로 함
				else if (score[maxScore] == score[cur_score]) {

					if (maxScore < cur_score) {
						maxScore = cur_score;
					}

				}
			}

			// 결과값 프린트
			System.out.println("#" + String.valueOf(tc_num) 
					+ " " + String.valueOf(maxScore));


		}

	}

}