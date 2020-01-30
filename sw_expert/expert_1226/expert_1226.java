import java.io.*;
import java.util.*;

class expert_1226 {

	public static class Dot{

		int row;
		int col;

		public Dot(int row, int col){
			this.row = row;
			this.col = col;
		}

	}

	//오아왼위 
	public static int[][] map;
	public static Dot start;
	public static Dot end;
	public static int[] dirRow = {0, 1, 0, -1};
	public static int[] dirCol = {1, 0, -1, 0};

	public static HashMap<Integer, ArrayList<Integer>> check;
	

	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_1226.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		// Test Case
		for (int tc = 1; tc <= 10; tc++){
			int test = scan.nextInt();

			map = new int[16][16];
			check = new HashMap<Integer, ArrayList<Integer>>();
	

			for(int r = 0; r < 16; r++){
				String rLine = scan.next();
				for(int c = 0; c < 16; c++){
					int newInt = rLine.charAt(c) - '0';
					map[r][c] = newInt;

					if (newInt == 2){
						start = new Dot(r,c);
					} else if(newInt == 3) {
						end = new Dot(r,c);
					}

				}
			}

			// // 맵이랑 시작점, 끝점 프린트 
			// for(int r = 0; r < 16; r++){
			// 	for(int c = 0; c < 16; c++){
			// 		System.out.print(map[r][c]);

			// 	}
			// 	System.out.println();
			// }
			// System.out.println(start.row + " " + start.col);
			// System.out.println("END:    " + end.row + " " + end.col);


			boolean answer = mazeSolve(start.row, start.col);
			int ans_num = 0;
			if(answer){
				ans_num = 1;
			}
			System.out.println("#" + tc + " " + ans_num);
			// System.out.println(answer);
		}

	}

	// 뒤에 길이 있고 결국 끝점을 만나면 return true. 끝이 없으면 return false.
	public static boolean mazeSolve(int row, int col){

		// System.out.println("row: " + row + "    col: " + col);

		boolean answer = false;

		if (row == end.row && col == end.col){
			return true;
		}
		// 만약 뒤에 갈 길이 남아 있지 않다면 return false;
		// 오 = 0    아 = 1    왼 = 2   위 = 3	
		if (map[row+dirRow[0]][col+dirCol[0]] != 1 && !find(row+dirRow[0], col+dirCol[0]) ) {
			add(row+dirRow[0], col+dirCol[0]);
			answer = mazeSolve(row+dirRow[0], col+dirCol[0]);
			if (answer) {
				return answer;
			}
		}
		if (map[row+dirRow[1]][col+dirCol[1]] != 1 && !find(row+dirRow[1], col+dirCol[1]) ) {
			add(row+dirRow[1], col+dirCol[1]);
			answer = mazeSolve(row+dirRow[1], col+dirCol[1]);
			if (answer) {
				return answer;
			}
		}
		if (map[row+dirRow[2]][col+dirCol[2]] != 1 && !find(row+dirRow[2], col+dirCol[2]) ) {
			add(row+dirRow[2], col+dirCol[2]);
			answer = mazeSolve(row+dirRow[2], col+dirCol[2]);
			if (answer) {
				return answer;
			}
		}
		if (map[row+dirRow[3]][col+dirCol[3]] != 1 && !find(row+dirRow[3], col+dirCol[3]) ) {
			add(row+dirRow[3], col+dirCol[3]);
			answer = mazeSolve(row+dirRow[3], col+dirCol[3]);
			if (answer) {
				return answer;
			}
		}


		return answer;


	}

	// Check find and add
	public static boolean find(int row, int col){
		if (check.containsKey(row)){
			if ( (check.get(row)).contains(col) ){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void add(int row, int col){
		if (!check.containsKey(row)) {
			check.put(row, new ArrayList<Integer>());
		} 
		check.get(row).add(col);
	}

}