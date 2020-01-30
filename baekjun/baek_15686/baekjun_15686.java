import java.io.*;
import java.util.*;


class baekjun_15686 {
	static int n, m;
	static int[][] map;
	static ArrayList<Dot> house_loc, chicken_loc;
	static int shortest;
	static boolean[] visited;
	static int[] output;


	static long start;
	static int count1;
	static int count2;
	
	
	// TODO 겹치는 부분에 대하여.

	public static void main(String[] args) throws Exception {
		

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_15686.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// 테스트케이스 
		// int testCase = scan.nextInt();

		// // Test Case 돌리기 
		// for (int tc = 1; tc <= 1; tc++){
		// }

		// 방 지도 그리기
		n = scan.nextInt();
		m = scan.nextInt();
		map = new int[n][n];

		house_loc = new ArrayList<Dot>();
		chicken_loc = new ArrayList<Dot>();

		// map intailize + 치킨 집 위치 저장, 집 위치 저장, 치킨집 갯수 저장.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++){

				int newNum = scan.nextInt();
				map[i][j] = newNum;
				if (newNum == 1) {
					house_loc.add(new Dot(i,j));
				} else if (newNum == 2){
					chicken_loc.add(new Dot(i,j));
				}

			}
		}
		// // map테스트 프린트
		// for (int i = 0; i < n; i ++){
		// 	for (int j = 0; j < n; j++){
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		// 집, 치킨 위치 테스트프린ㅌ 
		// for (int i = 0; i < house; i++){
		// 	System.out.println("house: " +i);
		// 	System.out.println("house i: " +house_loc[i][0]);
		// 	System.out.println("house j: " +house_loc[i][1]);
		// }
		// for (int i = 0; i < chicken_loc.size(); i++){
		// 	System.out.println("chiken: " +i);
		// 	System.out.println("chiken i: " +chicken_loc.get(i).x);
		// 	System.out.println("chiken j: " +chicken_loc.get(i).y);
		// }

		// System.out.println(m);
		shortest = Integer.MAX_VALUE;
		output = new int[chicken_loc.size()];
		visited = new boolean[chicken_loc.size()];
		start = System.currentTimeMillis();
		for (int i = 0; i < chicken_loc.size(); i++){
			visited[i] = true;
			chicken_selection(i, 0);
			visited[i] = false;
		}
		


		System.out.println(shortest);
		// System.out.println(count1);
		// System.out.println(count2);
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		// System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초"); //실행 시간 계산 및 출력
		
	}

	// cur_m 사이즈의 치킨집을 선택하여, "돌려본다 TODO"
	public static void chicken_selection(int start, int depth){
		output[depth] = start + 1;

		

		if(depth == m-1){
			count2++;
			// for (int x = 0; x < chicken_list.size(); x++){
			// 	System.out.println(chicken_list.get(x));
			// }

			int all_house_dist = 0;
			// 집들 전체 
			for(int i = 0; i < house_loc.size(); i++){
				int cur_house_dist = Integer.MAX_VALUE;
				// i집이랑 선택된 치킨집 전체 돌아서 최소거리 구하기
				for (int j = 0; j < m; j++){
					Dot chi = chicken_loc.get(output[j] - 1);
					Dot hou = house_loc.get(i);
					cur_house_dist = Math.min(dist(chi, hou), cur_house_dist);
					// if (cur_house_dist > shortest){
					// 	return;
					// }
				}

				all_house_dist += cur_house_dist;
				// if (all_house_dist > shortest){
				// 	return;
				// }
			}
			shortest = Math.min(all_house_dist, shortest);


			return;
		}

		for (int i = 0; i < chicken_loc.size(); i++){
			if (visited[i]) continue;
			count1++;
			visited[i] = true;
			chicken_selection(i, depth+1);
			visited[i] = false;

		}

		



		// if (m == cur_chi) {
		// 	count2++;
		// 	int house_sum = 0;
		// 	for (int i = 0; i < house; i++){
		// 		int cur_house_min = Integer.MAX_VALUE;
		// 		for (int j = 0; j < cur_chi; j++){

		// 			int cur_dist = dist(chicken_loc[selected.get(j)][0],
		// 			chicken_loc[selected.get(j)][1],
		// 			house_loc[i][0],
		// 			house_loc[i][1]);
		// 			if (house_sum >= shortest){
		// 				return;
		// 			}
		// 			cur_house_min = Math.min(cur_dist, cur_house_min);

		// 		}
		// 		house_sum += cur_house_min;
		// 		if (house_sum >= shortest) {
		// 			return;
		// 		}
		// 	}
		// 	long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		// 	System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초"); //실행 시간 계산 및 출력

		// 	shortest = Math.min(house_sum, shortest);
		// 	return;
		// }

		// for (int i = 0; i < chicken; i++){
		// 	if (!visited[i]){
		// 		count1++;
		// 		visited[i] = true;
		// 		selected.add(selected.size(), i);
		// 		chicken_selection(cur_chi+1);
		// 		selected.remove(selected.size()-1);
		// 		visited[i] = false;
		// 	}
			
		// }
	}


	public static int dist(Dot one, Dot two) {
		return Math.abs(one.x - two.x) + Math.abs(one.y - two.y);
	}

}

class Dot {
    int x;
    int y;
 
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
} 