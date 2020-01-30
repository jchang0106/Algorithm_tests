//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_10818 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan the integer n
		int n = scan.nextInt();
		
		// Get rid of the "\n"
		scan.nextLine();


		// Initialize max and min with max,min value of integer
		int max = -1000000;
		int min = 1000000;

		int i = 0;

		while(n != 0){
			i = scan.nextInt();

			if (i > max){
				max = i;
			}

			if (i < min){
				min = i;
			}
			n--;
		}
		
		System.out.print(min);
		System.out.print(" ");
		System.out.println(max);


		

	}

}

