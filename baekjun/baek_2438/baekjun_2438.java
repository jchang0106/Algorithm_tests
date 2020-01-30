//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_2438 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan the integer n
		int n = scan.nextInt();
		
		for (int i = 1; i <= n; i++){
			for (int j = 0; j < i; j++){
				System.out.print("*");
			}
			System.out.println();
		}

		

	}

}

