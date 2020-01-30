//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_2439 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan the integer n
		int n = scan.nextInt();
		
		for (int i = 1; i <= n; i++){
			for (int u = 0; u < n-i; u++){
					System.out.print(" ");
			}
			for (int j = 0; j < i; j++){

				System.out.print("*");
			}
			System.out.println();
		}

	}

}

