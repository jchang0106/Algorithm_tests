//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_2440 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan the integer n
		int n = scan.nextInt();

		for (int i = n; i > 0; i--){
			for (int j = i; j > 0; j--){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

