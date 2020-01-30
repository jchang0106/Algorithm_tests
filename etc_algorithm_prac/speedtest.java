import java.io.*;
import java.util.*;


class Main {
	

	
	
	// TODO 겹치는 부분에 대하여.

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();

		// Input.txt 파일 적용 for 테스트 케이스 
		System.setIn(new FileInputStream("input_15686.txt"));

		// 스캐너
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초"); //실행 시간 계산 및 출력


	}
}