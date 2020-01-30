import java.io.*;
import java.util.*;

class baekjun_14891 {
	public static int[][] wheels; 

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_14891.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		wheels = new int[4][8];

		// // 톱니바퀴 
		for(int i = 0; i < wheels.length; i++){
			String str = scan.next();
			for(int j = 0; j < wheels[i].length; j++){
				wheels[i][j] = str.charAt(j) - '0';
			}

		}
		
		int k = scan.nextInt();

		// System.out.println("ORIGINAL");
		// for(int i = 0; i < wheels.length; i++){
		// 	for (int j = 0; j < wheels[i].length; j++){
		// 		System.out.print(wheels[i][j]);
		// 	}
		// 	System.out.println();
		// }
		// System.out.println();

		for(int i = 0; i < k; i++){
			int wheel_num = scan.nextInt();
			int turn_num = scan.nextInt();
			// System.out.println("wheel_num: " + (wheel_num-1));
			// System.out.println("turn_num: " + turn_num);
			// direction: 0-turnLeft 1-right 2-both
			process(wheel_num-1, turn_num);
		}

		// System.out.println("ANSWER");

		// for(int i = 0; i < wheels.length; i++){
		// 	for (int j = 0; j < wheels[i].length; j++){
		// 		System.out.print(wheels[i][j]);
		// 	}
		// 	System.out.println();
		// }

		System.out.println(calc());


		
	}

	public static void process(int wheel_num, int turn_num){

		// 다 돌렷으면 끝내기
		if (turn_num == 0){
			return;
		}

		// 왼쪽으로 돌려야할지, 오른쪽으로 돌려야할지.
		boolean turnLeft = false;
		if (turn_num < 0){
			turnLeft = true;
		}
		// System.out.println("turnLeft: " + turnLeft);


		//leftWheel들 돌려 
		if (wheel_num-1 >= 0){
			if(wheels[wheel_num][6] != wheels[wheel_num-1][2]){
				goLeft(wheel_num-1, !turnLeft);
			}
		}

		//rightWheel들 돌려
		if (wheel_num+1 <= 3){
			if(wheels[wheel_num][2] != wheels[wheel_num+1][6]){
				goRight(wheel_num+1, !turnLeft);
			}
		}

		//바퀴 돌려 
		if(turnLeft){
			turnLeft(wheel_num);
		} else{
			turnRight(wheel_num);
		}

		

		if (turn_num < 0){
			process(wheel_num, turn_num+1);
		} else {
			process(wheel_num, turn_num-1);
		}

		


	}

	public static void turnLeft(int wheel_num){
		// System.out.println();
		// System.out.println("wheel_num: " + wheel_num);
		// System.out.println("turn Left");
		// System.out.println();
		
		// 반시계방향, 왼쪾으로 돌리기 
		int temp_idx_0 = wheels[wheel_num][0];
		for (int i = 0; i < 7; i++){
			wheels[wheel_num][i] = wheels[wheel_num][i+1];
		}
		wheels[wheel_num][7] = temp_idx_0;
		return;
		
	}
	public static void turnRight(int wheel_num){
		// System.out.println();
		// System.out.println("wheel_num: " + wheel_num);
		// System.out.println("turn Right");
		// System.out.println();
		
		// 시계방향, 오른쪽으로 돌리기.
		int temp_idx_7 = wheels[wheel_num][7];
		for (int i = 7; i > 0; i--){
			wheels[wheel_num][i] = wheels[wheel_num][i-1];
		}
		wheels[wheel_num][0] = temp_idx_7;		
		return;
	}

	public static void goLeft(int wheel_num, boolean turnLeft){
		if(wheel_num == 0){
			if(turnLeft){
				turnLeft(wheel_num);
			} else {
				turnRight(wheel_num);
			}
			return;

		} else {
			//leftWheel들 돌려 
			if (wheel_num-1 >= 0){
				if(wheels[wheel_num][6] != wheels[wheel_num-1][2]){
					goLeft(wheel_num-1, !turnLeft);
				}
			}
			
			if(turnLeft){
				turnLeft(wheel_num);
			} else {
				turnRight(wheel_num);
			}
			return;
		}
	}

	public static void goRight(int wheel_num, boolean turnLeft){
		if(wheel_num == 0){
			if(turnLeft){
				turnLeft(wheel_num);
			} else {
				turnRight(wheel_num);
			}
			return;

		} else {
			//rightWheel들 돌려
			if (wheel_num+1 <= 3){
				if(wheels[wheel_num][2] != wheels[wheel_num+1][6]){
					goRight(wheel_num+1, !turnLeft);
				}
			}
			
			if(turnLeft){
				turnLeft(wheel_num);
			} else {
				turnRight(wheel_num);
			}
			return;
		}
	}


	public static int calc(){
		int ans = 0;
		int factor = 1;
		for(int i = 0; i < wheels.length; i++){
			
			double cur = wheels[i][0] * Math.pow(2,i);
			ans += cur;
		}
		return ans;
	}
}


