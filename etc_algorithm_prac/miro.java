
////////////////////////////////////////////////////////////////
//
// 제목        :   미로찾기
// 파일이름     :   miro.java
// 작성자      :   장준우
// 
////////////////////////////////////////////////////////////////

//Importing all util package
import java.util.*;
import java.io.*;

/**
  * 미로의 최단거리 찾기
  * 미로의 맵은 array of array로, 갈 수 있는 길은 1, 없는 길은 0으로 표현.
  * 맵의 rows, cols는 사용자가 scanner로 직접 입력하거나, 
  * 같은 디렉토리의 miro_map.txt로 입력. 첫 줄은 row col (예: 6 6)
  * 두 번째 줄 부터는 row col 수에 맞는, 지도로 입력 (예: 1 1 1 0 0 1 ..)
  * 시작점은 (0, 0) 그리고 끝점은 (row, col).
  * 한 칸은, Coord라는 class로 표현. 최단 거리를 재기 위해 Coord는 거리 정보를 
  * 포함하고 있음. 
  * 
  * 지도 정보를 먼저 int [][] map에 넣고, bfs를 이용하여 최단거리를 구한다.
  *
  * [디버깅]들을 코멘팅 처리하면 최단거리만 간단히 프린트.
  */

public class miro { 

    // File input을 위한 Exception처리
    public static void main(String[] args) throws IOException {

        // input 파일 불러오기 (직접 입력시 코멘팅 처리)
        System.setIn(new FileInputStream("miro_map.txt"));
        
        // 스캐너
        Scanner scan = new Scanner(System.in);
                
        // 테스트 수 
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        
        // 맵정보
        int [][] map = new int[rows][cols];
        
        // 맵정보 저장
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < cols; k++) {
                map[j][k] = scan.nextInt();
            }
        }

        // [디버깅] 맵의 row, column 프린트
        System.out.println("Row : " + map.length);
        System.out.println("Col : " + map[0].length + "\n");
        
        // [디버깅] 맵 프린트
        System.out.println("맵");
        for (int j = 0; j < rows; j++) {
            System.out.println(Arrays.toString(map[j]));
        }
        System.out.println();

        // 결과물 프린트
        System.out.println("최단거리 : " + bfs(map, rows, cols));
  
    }
 
    // Search the 'map' and return the depth of shortest path
    /**
      *
      * BFS Method
      * input: map, rows, cols
      *        지도정보와 그 지도의 row, col수 
      * output: ret
      *        지도의 최단거리
      * 
      * Coord의 Linked List, 즉 큐를 만든다.
      * 시작점 (0, 0) 그리고 거리가 1 인 Coord를 만들어서, 큐에 add한다.
      * 
      * 큐가 empty일 때 까지 while 룹에 돌린다.
      * 그 룹에는 
      * 큐에서 맨 앞 Coord를 빼온다 (Coord 체크) 
      * 이 current Coord의 거리를 최단거리로 지정한다. 그리고, 다시 돌아올 수 없게 0으로 바꿈
      * 혹시 이 Current Coord가 목적지인 (rows, cols)라면 룹을 종료한다.
      * 그리고 맵에서 Current Coord의 이웃 (위,아래,양 옆) 중 1 인 이웃들의 row, col 와
      * Current Coord의 거리 + 1을 이용하여 새로운 Coord를 만들어서 큐에 넣는다.
      * 이러한 BFS로 최단거리를 리턴한다.
      */
    private static int bfs(int[][] map, int rows, int cols) {

        // 리턴 할 최단거리 변수
        int ret = 0;
        
        // 시작점 (0,0)
        int curRow = 0;        // 현재 row
        int curCol = 0;        // 현재 col
        int curDist = 1;    // 현재 이동한 거리
        
        
        // Queue for bfs
        LinkedList<Coord> queue = new LinkedList<Coord>();

        // Add current node, which is (0,0)
        queue.add(new Coord(curRow, curCol, curDist));
          
        // 큐가 empty일 때까지 룹을 돌린다
        while(!queue.isEmpty()) {



            // 큐 맨 앞에서 Coord를 빼와서 그 Coord = current Coord.
            Coord coord = (Coord) queue.poll();
            // Current Coord의 좌표 및 위치정보.
            curRow = coord.row;
            curCol = coord.col;
            curDist = coord.dist;

           

            // Current Coord의 거리정보가 최단거리로 지정.
            ret = curDist;

            // 지나간 길 다시 안오게끔 0으로 바꾸기
            map[curRow][curCol] = 0;
            
            // 목적지에 도착하면 현재 Current Coord의 거리가 최단거리로 루핑 종료
            if(curRow == rows - 1 && curCol == cols - 1) {
                break;
            }
            
            // 위로 갈수 있는 길이 있으면, 큐에 넣기 (curRow-1, curCol)
            if(curRow-1 >= 0 && map[curRow-1][curCol] == 1) {
                queue.add(new Coord(curRow-1, curCol, curDist+1));
            }
            // 아래로 갈수 있는 길이 있으면, 큐에 넣기 (curRow+1, curCol)
            if(curRow+1 < rows && map[curRow+1][curCol] == 1) {
                queue.add(new Coord(curRow+1, curCol, curDist+1));
            }
            // 왼쪽으로 갈수 있는 길이 있으면, 큐에 넣기 (curRow, curCol-1)
            if(curCol-1 >= 0 && map[curRow][curCol-1] == 1) {
                queue.add(new Coord(curRow, curCol-1, curDist+1));
            }
            // 오른쪽으로 갈수 있는 길이 있으면, 큐에 넣기 (curRow, curCol+1)
            if(curCol+1 < cols && map[curRow][curCol+1] == 1) {
                queue.add(new Coord(curRow, curCol+1, curDist+1));
            }

             // [디버깅] 큐 프린트: 마지막 큐 안의 맨 윗줄이 5, 5, 최단거리가 있으면 제대로 된것.
            System.out.println("---------------------- Queue ----------------------\n"); 

            System.out.println(queue);

            System.out.println("\nCurrent Coord= " +
                coord.toString() + "\n---------------------------------------------------\n\n");



            


        }
        
        // 큐 클리어 space 아끼기
        queue.clear();
        
        // 최단거리 리턴
        return ret;

    }
    
    // 이동하는 위치정보 및 거리정보 저장
    /**
    * Coord Class
    * 변수 : row, col, dist
    * 
    * 맵에서의 한칸의 위치 및 거리정보 
    * 위치: (row, col) 좌표
    * 거리: 1칸에 1씩.
    */
    public static class Coord {
        // 좌표 및 거리정보
        int row, col, dist;
        
        // Build Coord-Method 
        public Coord(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            
        }

        // 큐 프린트 디버깅에서 Coord 정보를 프린트 할때 쓸 toString
        @Override
        public String toString(){
            return("    Row: " + row + "    Col: " + col + "    거리: "+ dist + "\n");
        }
    }
}

