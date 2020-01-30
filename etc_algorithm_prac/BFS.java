import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
 
public class BFS {
    // 최단거리 구하기
    public static int rows = 0;    // 행수
    public static int cols = 0;    // 열수    
    public static int[][] map = null;    // 맵정보
    public static String path = "";        // 이동경로
    
    public static void main(String[] args) throws FileNotFoundException {
        // 입력정보 텍스트 파일
        System.setIn(new FileInputStream("BFS.txt"));
        Scanner scanner = new Scanner(System.in);
        
        long begin = System.currentTimeMillis();
        
        // 테스트 수 
        int testCnt = scanner.nextInt();
        
        for (int i = 1; i <= testCnt; i++) {
            rows = scanner.nextInt();    // 행수
            cols = scanner.nextInt();    // 열수
            
            // 맵정보
            map = new int[rows][cols];
            
            // 맵정보 저장
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    map[j][k] = scanner.nextInt();
                }
            }
            // 디버깅 map 출력
//            for (int j = 0; j < rows; j++) {
//                System.out.println(Arrays.toString(map[j]));
//            }
            
            int dap = 0;
            path = "";
            dap = bfs();
            System.out.println("#" + i + " " + dap + " " + path);
            
            map = null;
        }
        
        long end = System.currentTimeMillis();
        System.out.printf("%.3f (secs)", (end-begin)/1000.0);
        
        scanner.close();
    }
 
    private static int bfs() {
        int ret = 0;
        
        int curRow = 0;        // 현재 row
        int curCol = 0;        // 현재 col
        int curDist = 1;    // 현재 이동한 거리
        String curPath = "";    // 현재까지 이동경로
        
        // BFS에서는 큐에 시작정보(0,0) 세팅
        LinkedList<Coord> queue = new LinkedList<Coord>();
        queue.add(new Coord(curRow, curCol, curDist, curPath));
        
        // 큐가 empty일 때까지 루핑
        while(!queue.isEmpty()) {
            Coord coord = (Coord) queue.poll();
            curRow = coord.row;
            curCol = coord.col;
            curDist = coord.dist;
            curPath = coord.path;
            path = curPath;
            ret = curDist;
            map[curRow][curCol] = 0;
            
            // 목적지에 도착하면 루핑 종료
            if(curRow == rows - 1 && curCol == cols - 1) {
                break;
            }
            
            // 위로 갈수 있으면
            if(curRow-1 >= 0 && map[curRow-1][curCol] == 1) {
                queue.add(new Coord(curRow-1, curCol, curDist+1, curPath));
            }
            // 아래로 갈수 있으면
            if(curRow+1 < rows && map[curRow+1][curCol] == 1) {
                queue.add(new Coord(curRow+1, curCol, curDist+1, curPath));
            }
            // 왼쪽으로 갈수 있으면
            if(curCol-1 >= 0 && map[curRow][curCol-1] == 1) {
                queue.add(new Coord(curRow, curCol-1, curDist+1, curPath));
            }
            // 오른쪽으로 갈수 있으면
            if(curCol+1 < cols && map[curRow][curCol+1] == 1) {
                queue.add(new Coord(curRow, curCol+1, curDist+1, curPath));
            }
        }
        
        // 큐 클리어
        queue.clear();
        
        return ret;
    }
    
    // 이동하는 위치정보 및 거리정보 저장
    public static class Coord {
        int row, col, dist;
        String path;
        public Coord(int row, int col, int dist, String oldPath) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            if("".equals(oldPath)) {
                this.path = "(" + row + ", " + col + ")"; 
            }
            else {
                this.path = oldPath + " -> " + "(" + row + ", " + col + ")"; 
            }
        }
    }
}

