import java.io.*;
import java.util.*;

class expert_1244 {

	static int max_ans;
	static int max_change;
	static boolean[][] check;
	static int countcount;
	static int countt;

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_1244.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// Test Case 수
		int testCase = scan.nextInt();

		// Test Case 
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 전광판 숫자를 String으로, 바꿀 기회 스캐너로 받기
			String number = scan.next();
			max_change = scan.nextInt();

			// 처음은 정답을 0으로 배정
			max_ans = 0;


			// 전광판 숫자를 int Array로 바꿔주기
			int[] num = new int[number.length()];
			for (int i = 0; i < num.length; i++) {
				// [char -> int] 아스키 숫자 이용해서 int로 바꾸는 
				num[i] = number.charAt(i) - '0';
			}

			// [count][getInt(num)] == true/false
			check = new boolean[max_change+1][1000000];

			// // 만약 교환횟수가 절반 이상이라면, 그냥 최대값을 찾아주면 됨. XXXX
			// // 만약 교환횟수가 너무 크면 줄여준다. 생략가능
			// if (max_change > num.length-1) {
			// 	max_change = num.length-1;
			// 	//num = maxNum(num);
				

			// 	// 만약 max_change - num.length/2 가 홀수라면,
			// 	// 마지막 두자리를 바꿔준다
				
			// 		빠진부분: 만약 같은수가 하나라도 있다면 할 필요 없음.
				
			// 	// if ((max_change - num.length/2) % 2 == 1) {
			// 	// 	int temp = num[num.length-2];
			// 	// 	num[num.length-2] = num[num.length-1];
			// 	// 	num[num.length-1] = temp;
			// 	// }

			// 	// 최대값을 정답으로 지정
			// 	// max_ans = getInt(num);

			// }

			
			// 전광판 숫자를 max_change만큼 바꾸는 모든 경우의 수를
			// 테스트 해보기. 현재 바꾼 수는 0.
			numProcess(num, 0);

						
			System.out.println(countcount);
			System.out.println(countt);

			// 결과값 프린트
			System.out.println("#" + String.valueOf(tc) 
					+ " " + String.valueOf(max_ans));
		}
		
	}

	/*
		num 배열의 숫자를 max_change - count 만큼 바꾸는 
		모든 경우의 수를 테스트해서, 현재까지 나온 max_ans보다 크면, 
		그걸 max_ans로 바꿔주기.
		[모든 경우의 수를 다 따져서, 최대값구하기]

		만약 바꿀 기회를 다 쓴 iteration이면, result와 비교하고 바로 리턴
		아니라면
		모든 자릿수를 다 바꿔서 recursion	
	*/
	public static void numProcess(int[] num, int count){
		

		// 만약 바꿀 기회를 다 썼다면
		if (count == max_change) {
			// if(count == 10){ countcount++;}

			// 이번 결과물이 앞에서 나온 answer보다 크면 바꾼다.
			if (max_ans < getInt(num)) {
				max_ans = getInt(num);
			}
			// Method 끝
			return;
		}

		// 만약 아직 바꿀 기회가 남아있다면 (count < max_change)
		// 모든 자릿수를 다 바꿔본다. Count는 1개 늘려서 recursion.
		for (int pos_1 = 0; pos_1 < num.length; pos_1++){
			for (int pos_2 = num.length-1; pos_2 >= 0; pos_2--) {

				if (pos_1 == pos_2) {
					continue;
				}

				// 자리를 한번 바꾼후에
				int[] swappedNum = swapNum(num, pos_1, pos_2);	

				// count번쨰 바꿨을때, 이 숫자를 돌려보지 않았으면
				if (!check[count][getInt(swappedNum)]){

					// 이제 돌렸다고 표시해주고.
					check[count][getInt(swappedNum)] = true;
					

					// // 백트랙 테스터기 
					if (count == 3) {
						countcount++;
						// System.out.println("Count: " + count);
						// System.out.println("Num: " + getInt(num));
						// System.out.println("SwappedNum: " + getInt(swappedNum));
						// System.out.println("___________________________________");
					}
					// 돌려본다.
					numProcess(swappedNum, count + 1);

				} 			

				

			}
		}

	}

	// num Array 를 정수로 바꾸준다
	public static int getInt(int[] num){

		int result = 0;
		// 각 자리를 알맞는 10^x를 곱해줌으로 답을 구함 
		for (int i = 0; i < num.length; i++) {
			result += num[i] * Math.pow(10, num.length - (i+1));
		}

		return result;
	}

	// num 배열의 pos_1, pos_2 인덱스 숫자를 서로 바꾼 배열을 리턴
	public static int[] swapNum(int[] num, int pos_1, int pos_2){
		
		
		
		countt++;
		// 새로운 배열을 카피해서 만들고, 그 배열을 swap후에 넘겨준다. 
		int[] tempNum = num.clone();
		int temp = tempNum[pos_1];
		tempNum[pos_1] = tempNum[pos_2];
		tempNum[pos_2] = temp;
		return tempNum;
	}

	// // 그냥 이 전광판의 최대값 구해서 배열로 리턴
	// public static int[] maxNum(int[] num){

	// 	int[] tempNum = num.clone();

	// 	Arrays.sort(tempNum);

	// 	int temp;
	// 	for (int i = 0; i < tempNum.length / 2; i++) {
 //      		temp = tempNum[i];
 //      		tempNum[i] = tempNum[(tempNum.length - 1) - i];
 //      		tempNum[(tempNum.length - 1) - i] = temp;
 //    	}

	// 	return tempNum;
	// }

}


	

