
import java.util.Arrays;
import java.util.Scanner;

public class donghyun_4111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int k=1; k<=N; k++) {
			int cameraCnt = sc.nextInt();
			int receiveCnt = sc.nextInt();
			
			int[] camera = new int[cameraCnt];
			
			for(int i=0; i<cameraCnt; i++) {
				camera[i] = sc.nextInt();
			}
			
			Arrays.sort(camera);
			int sum=0;
			if(cameraCnt<=receiveCnt) sum = 0;
			else {
				int[] check = new int[cameraCnt-1];
				for(int i=0; i<cameraCnt-1; i++) {
					check[i] = camera[i+1] - camera[i];
				}
				
				for(int i=0; i<cameraCnt-1-receiveCnt-1; i++) {
					sum+= check[i];
					System.out.println(check[i]);

				}
			}
			
			System.out.println("#"+k+" "+sum);

		}
	}

}