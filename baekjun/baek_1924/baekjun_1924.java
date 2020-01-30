//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_1924 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Scan month and date
		int m = scan.nextInt();
		int d = scan.nextInt();


		
		// Calculate total day
		int totalDay = 0;

		// Add all days before "m" month
		for(int i = 1; i < m; i++){
			// Set the month which has 31 to be true
			Boolean is31 = (i == 1) || (i == 3) || (i == 5) || (i == 7) 
			|| (i == 8) || (i == 10) || (i == 12);

			// Calculate the correct Num of days and add it to total.
			if (is31){
				totalDay += 31;
			} else if (i == 2){
				totalDay += 28;
			} else {
				totalDay += 30;
			}
			
		}

		// Add this month's days
		totalDay += d;

		// Caculate what day it is and print it.
		switch(totalDay % 7) {
			case 0:
				System.out.println("SUN");
				break;
			case 1:
				System.out.println("MON");
				break;
			case 2:
				System.out.println("TUE");
				break;
			case 3:
				System.out.println("WED");
				break;
			case 4:
				System.out.println("THU");
				break;
			case 5:
				System.out.println("FRI");
				break;
			case 6:
				System.out.println("SAT");	
		}
		

	}

}

