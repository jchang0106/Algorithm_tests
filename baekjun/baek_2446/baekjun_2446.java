//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_2446 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan the integer n
		int n = scan.nextInt();

		

    
		// Ascending order	
		for (int i = n; i > 0; i--){
			
			// controll space areas
			for (int u = n-i; u > 0; u--){
					System.out.print(" ");
			}


			// print correct amount of stars
			for (int j = i; j > 0; j--){

				System.out.print("*");
			}

			
			// print correct amount of stars
			for (int j = i-1; j > 0; j--){

				System.out.print("*");
			}
			
			// Line change
			System.out.println();
		}


		// Descending order
		for (int i = 2; i <= n; i++){
			
			for (int u = 0; u < n-i; u++){
					System.out.print(" ");
			}


			for (int j = 0; j < i; j++){

				System.out.print("*");
			}

			for (int j = 0; j < i-1; j++){

				System.out.print("*");
			}
			
			System.out.println();
		}


		
	}

}

