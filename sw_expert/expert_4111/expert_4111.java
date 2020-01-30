import java.io.*;
import java.util.*;


class expert_4111
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("input_4111.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);

		int T;

		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 카메라 갯수 N, 수신기 갯수 K를 읽어옵니다. 
			int N = sc.nextInt();
			int K = sc.nextInt();

			// 카메라 위치를 읽어옵니다.
			int[] cam_loc = new int[N];

			for(int i = 0; i < N; i++){

				cam_loc[i] = sc.nextInt();

			}

			// 카메라 위치 중복된 숫자를 제거하고 오름차순 정렬된 리스트 만들기
			List<Integer> sort_cam_loc = new ArrayList<Integer>();

			for(int i = 0; i < N; i++){

				if(!sort_cam_loc.contains(cam_loc[i])){
					sort_cam_loc.add(cam_loc[i]);
				}

			}


			Collections.sort(sort_cam_loc);

			// 카메라 사이의 거리를 구해서 오름차순 정렬 리스트
			List<Integer> dist = new ArrayList<Integer>();

			for (int i = 1; i < sort_cam_loc.size(); i++){

				dist.add(sort_cam_loc.get(i) - sort_cam_loc.get(i-1));

			}

			Collections.sort(dist);

			// Cam_Loc TESTING
			// for(int i = 0; i < dist.size(); i++){

			// 	System.out.println(dist.get(i));
			// }

			
			int ans = 0;

			// 거리들 갯수 중 가장 큰 K-1개의 거리를 제외한 나머지들을 더함
			// K >= N 일때는 자동적으로 답이 0이 됨 	
			for (int i = 1; i <= dist.size() - (K - 1); i++) {

				ans += dist.get(i-1);

			}

			System.out.println("#" + String.valueOf(T) + " " + String.valueOf(ans));
			

		}
		sc.close();
	}
}