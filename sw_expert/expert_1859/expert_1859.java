import java.io.*;
import java.util.*;

class expert_1859 {

	// 전역 변수들 선언
	static long ans;
	static long[] price;
	static int startIndex;
	static int endIndex;

	public static void main(String[] args) throws Exception {
		
		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// Test Case 수
		int testCase = scan.nextInt();

		// Test Case 
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 날짜 수
			int days = scan.nextInt();

			// 가격 배열
			price = new long[days];

			// 각 날의 수 배열에 넣기
			for (int i = 0; i < days; i++) {
				price[i] = (long) scan.nextInt();
			}

			// Initializng
			startIndex = 0;
			endIndex = -1;
			ans = 0;

			// 시작index가 맨 마지막일때까지
			while(startIndex != price.length){

				// 시작 index부터 끝까지 최대값의 index를 endIndex로 지정
				endIndex = firstMaxIndex(startIndex);
	
				// start인덱스날 부터 endIndex-1날까지 사서, endIndex날 팔아서 값 ans에 더하기
				sell(startIndex, endIndex);

				// 그 다음번 iteration을 위해, startIndex를 다음날로 지정
				startIndex = endIndex + 1;

			}
			
			// 결과값 프린트
			System.out.println("#" + String.valueOf(tc) 
					+ " " + String.valueOf(ans));


		}

	}

	// startIndex부터 끝까지 검색해서 Max값을 가지는 index를 리턴
	public static int firstMaxIndex(int startIndex){

		// 일단 제일 첫번째 인덱스를 Max로 임의지정
		int maxIndex = startIndex;

		// 현재인덱스가 Max보다 크면, 현재인덱스를 새로운 Max인덱스로 지정
		for(int i = startIndex + 1; i < price.length; i++){

			if (price[maxIndex] < price[i]){
				maxIndex = i;
			}

		}

		// 리턴 maxIndex between startIndex ~ price.length-1인덱스 
		return maxIndex;
	}

	// startIndex ~ endIndex-1 까지 물건을 매일 사고, 마지막에 파는것
	public static void sell(int startIndex, int endIndex){

		for(int i = startIndex; i < endIndex; i++) {

			ans += price[endIndex] - price[i];

		}

	}

}