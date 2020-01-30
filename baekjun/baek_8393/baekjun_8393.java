//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_8393 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan the integer n
		int n = scan.nextInt();
		int sum = 0;

		for (int i = 1; i <= n; i++){
			sum += i;
		}
		System.out.println(sum);
		

	}

}

