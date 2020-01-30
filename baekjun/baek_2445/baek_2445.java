//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_2445 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan the integer n
		int n = scan.nextInt();

		

    
		// Ascending order	
		for (int i = 1; i <= n; i++){
			

			// print correct amount of stars
			for (int j = 0; j < i; j++){

				System.out.print("*");
			}

			// controll space areas
			for (int u = 0; u < n-i; u++){
					System.out.print("  ");
			}

			// print correct amount of stars
			for (int j = 0; j < i; j++){

				System.out.print("*");
			}
			
			// Line change
			System.out.println();
		}

		// Descending order
		for (int i = n-1; i > 0; i--){
			


			
			for (int j = 0; j < i; j++){

				System.out.print("*");
			}

			for (int u = 0; u < n-i; u++){
					System.out.print("  ");
			}

			for (int j = 0; j < i; j++){

				System.out.print("*");
			}



			
			System.out.println();
		}


		
	}

}

