//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_10992 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan the integer n
		int n = scan.nextInt();

		

    
		// Ascending order	
		for (int i = 1; i <= n; i++){
			
			// controll space areas
			for (int u = 0; u < n-i; u++){
					System.out.print(" ");
			}

			if (i == 1 || i == n){
				// print correct amount of stars
				for (int j = 0; j < i; j++){

					System.out.print("*");
					
				}

				
				// print correct amount of stars
				for (int j = i-1; j > 0; j--){

					System.out.print("*");
					
				}
			} else {
				// print correct amount of stars
				for (int j = 0; j < i; j++){

					if (j == 0){
						System.out.print("*");					
					} else {
						System.out.print(" ");
					}
					
				}

				
				// print correct amount of stars
				for (int j = i-1; j > 0; j--){
					if (j == 1){
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
					
				}
			}
			
			// Line change
			System.out.println();
		}


		// // Descending order
		// for (int i = n-1; i > 0; i--){
			
		// 	for (int u = 0; u < n-i; u++){
		// 			System.out.print(" ");
		// 	}


		// 	for (int j = 0; j < i; j++){

		// 		System.out.print("*");
		// 	}

		// 	for (int j = 0; j < i-1; j++){

		// 		System.out.print("*");
		// 	}
			
		// 	System.out.println();
		// }


		
	}

}

