import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
 
class Main {

 
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        int a = 1;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a = a+a;
            }
        }

        
        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초"); //실행 시간 계산 및 출력
    }

}