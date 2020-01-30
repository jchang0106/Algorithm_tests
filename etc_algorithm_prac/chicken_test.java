import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
 
class Main {
    static int N;
    static int M;
    static int[][] arr;
    static ArrayList<Dot> chicken;
    static ArrayList<Dot> person;
    static int[] output;
    static boolean[] visited;
    static int result;
    static int count1;
    static int count2;
 
    public static void main(String[] args) throws Exception {
        
        System.setIn(new FileInputStream("input_15686.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][N];
        result = Integer.MAX_VALUE;
        chicken = new ArrayList<Dot>();
        person = new ArrayList<Dot>();
 
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] == 1) {
                    //1일때는 사람 list에 추가
                    person.add(new Dot(i, j));
                } else if (arr[i][j] == 2) {
                    //2일때는 치킨 list에 추가
                    chicken.add(new Dot(i, j));
                }
            }
        }
        //-------입력부-------//
        
        //치킨 집 선택을 위한 배열 visited, output
        visited = new boolean[chicken.size()];
        output = new int[chicken.size()];
        count1 = 0;
        count2 = 0;
        long start = System.currentTimeMillis();
        //치킨 집 선택
        for (int i = 0; i < chicken.size(); i++) {
            visited[i] = true;
            ChickenSelection(i, 0);
            visited[i] = false;
            count1++;
        }
        System.out.println(result);
        System.out.println(count1);
        System.out.println(count2);
        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초"); //실행 시간 계산 및 출력
        
    }
    
    //치킨집 선택을 위한 함수
    public static void ChickenSelection(int start, int depth) {
        output[depth] = start + 1;

        //치킨집이 선택되었을 경우
        //(치킨집이 최대 M개 이므로 depth은 M-1 이 되어야한다. 0부터 시작했으니깐)
        if (depth == M - 1) {
            count2++;
            int sum = 0;
            int currentM = 0;
            //사람이 갈수 있는 치킨집의 경우중 가장 최소값을 선택한다.
            //person 한명씩 모든 Chicken 집을 선택하여 최소값을 비교한다.
            for (int i = 0; i < person.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    currentM = Calc(person.get(i), chicken.get(output[j] - 1));
                    min = Math.min(min, currentM);
                }
                //최소값일 경우 더한다.
                sum = sum + min;
            }
            //치킨집 경우의 수마다 다른 최소거리중 가장 작은 최소거리를 선택한다.
            result = Math.min(result, sum);
            return;
        }
        
        for (int i = start; i < chicken.size(); i++) {
            if (visited[i])
                continue;
            count1++;
            visited[i] = true;
            ChickenSelection(i, depth + 1);
            visited[i] = false;

        }
        
    }
    
    //위치 거리 계산 함수
    public static int Calc(Dot d1, Dot d2) {
        return Math.abs(d1.x - d2.x) + Math.abs(d1.y - d2.y);
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
