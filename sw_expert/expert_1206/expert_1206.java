import java.io.*;
import java.util.*;

class expert_1206 {
	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// 조망권 있는 세대 수 (정답)
		int prospect = 0;

		// Test Case 10 개
		for (int tc = 1; tc <= 10; tc++){

			// 빌딩 수 
			int build_num = scan.nextInt();

			// Map<빌딩번호, 세대 수(높이)>
			// 빌딩번호 범위 : 1 ~ 빌딩 수
			HashMap<Integer, Integer> buildings 
				= new HashMap<Integer, Integer>();


			// Buildings initializing
			for (int i = 1; i <= build_num; i++) {

				buildings.put(i, scan.nextInt());

			}



			// //맵 테스트 프린트
			// for (int i = 1; i <= build_num; i++) {

			// 	System.out.println(String.valueOf(i) + 
			// 		" : " + String.valueOf(buildings.get(i)));

			// }


			/* 
				맨 앞 2개, 맨 뒤 2개의 빌딩을 제외한 나머지 빌딩 iterate해서
				해당빌딩의 right,left 각각 2개의 높이를 확인하여,
				4개 중 가장 높은 빌딩의 수를 adjacent로 저장한다.
				해당빌딩 높이 > adjacet면, 
				(해당 빌딩의 높이 - adjacent)를 prospect에 더하고,
				그렇지 않으면 continue				
			*/ 
			for (int i = 3; i <= build_num - 2; i++) {


				// 인접 4개 건물의 높이 중 Max
				ArrayList<Integer> adj_list = new ArrayList<Integer>();
				adj_list.add(buildings.get(i-2));
				adj_list.add(buildings.get(i-1));
				adj_list.add(buildings.get(i+1));
				adj_list.add(buildings.get(i+2));
				int adjacent = Collections.max(adj_list);
				
				if (buildings.get(i) >= adjacent) {

					prospect += buildings.get(i) - adjacent;

				}

				// // 테스트 프린트
				// System.out.println("building : " + String.valueOf(i));
				// System.out.println("adjacent : " + String.valueOf(adjacent));
				// System.out.println("prospect : " + String.valueOf(prospect));
				// System.out.println("_______________________");

			}

			// 결과값 출력 "#테스트케이스 조망권세대수"
			System.out.println("#" + String.valueOf(tc) 
				+ " " + String.valueOf(prospect));

			prospect = 0;

		}		
	}
}


	

