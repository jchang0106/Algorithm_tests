import java.io.*;
import java.util.*;

class expert_1824 {

	// Dot마다 memory와 direction을 기억하기 위해 만든 객
	public static class Dot{

		int row;
		int col;
		HashMap<Integer, ArrayList<Integer>> mem_dir = new HashMap<Integer, ArrayList<Integer>>();

		public Dot(int row, int col){
			this.row = row;
			this.col = col;
		}

		public boolean find(int mem, int dir){
			if (mem_dir.containsKey(dir)){
				if ( (mem_dir.get(dir)).contains(mem) ){
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		}

		public void add(int mem, int dir){
			if (!mem_dir.containsKey(dir)) {
				mem_dir.put(dir, new ArrayList<Integer>());
				mem_dir.get(dir).add(mem);
 			} else {
 				mem_dir.get(dir).add(mem);
 			}
			
		}

	}

	public static char[][] map;
	public static int[] row_dir = {0, -1, 0, 1}; //왼 위 오른 아래
	public static int[] col_dir = {-1, 0, 1, 0}; //왼 위 오른 아래
	public static int row;
	public static int col;
	public static Dot[][] dot_list;


	public static void main(String[] args) throws Exception {

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_1824.txt"));

		// 스캐너
		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();


		// Test Case
		for (int tc = 1; tc <= testCase; tc++){

			row = scan.nextInt();
			col = scan.nextInt();

			map = new char[row][col];
			// check_dir = new int[row][col];
			// check_mem = new int[row][col];
			dot_list = new Dot[row][col];

			boolean endExist = false;

			// 맵에 넣기 
			for (int r = 0; r < row; r++){
				String str = scan.next();
				for (int c = 0; c < col; c++){
					if (str.charAt(c) == '@'){
						endExist = true;
					}
					map[r][c] = str.charAt(c);
					dot_list[r][c] = new Dot(r,c);

				}
			}
			
			// 	// 맵 프린트 
			// for (int r = 0; r < row; r++){
			// 	for (int c = 0; c < col; c++){

			// 		System.out.print(map[r][c]);
			// 	}
			// 	System.out.println();
			// }
			// System.out.println();
			boolean ans;
			if (endExist){
				ans = process(0,0,2,0);
			} else {
				ans = false;
			}
			

			// 정답 프린트 
			System.out.print("#" + tc + " ");
			if (ans){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	// direction 0:왼 1:위 2:오른 3:아래  

	//True -> 멈춤, False -> 안멈춤
	public static boolean process(int cur_row, int cur_col, int cur_dir, int mem){
		
		// System.out.println(map[cur_row][cur_col] + "     mem:" + mem + "     dir:" +cur_dir);	

		

		char cur_char = map[cur_row][cur_col];

		if(cur_char == '@'){
			return true;
		} 

		// 이 cur_row,cur_col자리에 왔을때 같은 mem, direction이 었으면 바로 false
		Dot cur_dot = dot_list[cur_row][cur_col];
		if(cur_dot.find(mem, cur_dir)) {
			return false;
		} else {
			cur_dot.add(mem, cur_dir);
		}
	

		int next_dir = cur_dir;
		int next_mem = mem;

		// 다음 방향을 정한다 
		if(cur_char == '<'){
			next_dir = 0;
		} 
		if(cur_char == '>'){
			next_dir = 2;
		} 
		if(cur_char == '^'){
			next_dir = 1;
		} 
		if(cur_char == 'v'){
			next_dir = 3;
		} 
		if(cur_char == '_'){
			if(next_mem == 0) {
				next_dir = 2;
			}
			else {
				next_dir = 0;
			}
		} 
		if(cur_char == '|'){
			if(next_mem == 0) {
				next_dir = 3;
			}
			else {
				next_dir = 1;
			}
		} 
		if(cur_char == '.'){
			//Nothing
		} 
		if(cur_char == '+'){
			next_mem = (next_mem + 1) % 16;
		}
		if(cur_char == '-'){
			next_mem = (next_mem - 1);
			if(next_mem < 0) {
				next_mem = 15;
			}
		} 
		if(cur_char <= 57 && cur_char >= 48) {
			next_mem = map[cur_row][cur_col] - '0';
		}

		// System.out.println("Next_dir: " + next_dir);

		if(cur_char == '?'){
			for(int ran_dir = 0; ran_dir < 4; ran_dir++){
				next_dir = ran_dir;
				if (process(next_row(cur_row, next_dir), next_col(cur_col, next_dir), next_dir, next_mem)) {
					return true;
				}
			}
		} else {
			// not '?'
			if (process(next_row(cur_row, next_dir), next_col(cur_col, next_dir), next_dir, next_mem)) {
				return true;
			}
		} 
		return false;

	}

	// 이번 row랑 directino을 주면 다음 row를 리턴 
	public static int next_row(int cur_row, int dir){
		int next_row = cur_row + row_dir[dir];
		if (next_row >= row) {
			next_row = 0;
		} else if (next_row < 0){
			next_row = row - 1;
		}
		// System.out.println("Next_row: " + next_row);
		return next_row;
	}

	// 이번 col이랑 direction을 주면 다음 col을 리턴
	public static int next_col(int cur_col, int dir){
		int next_col = cur_col + col_dir[dir];
		if (next_col >= col) {
			next_col = 0;
		} else if (next_col < 0){
			next_col = col - 1;
		}
		// System.out.println("Next_col: " + next_col);
		return next_col;
	}


}



