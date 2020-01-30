//Importing all util package
import java.util.*;

// Main class for BaekJoon website
class baekjun_11721 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Get the line
		String l = scan.nextLine();

		// Print every ten characters
		for (int i = 0; i < l.length(); i += 10){
			if (i+10 > l.length()){
				System.out.println(l.substring(i,l.length()));
			} else {
				System.out.println(l.substring(i,i+10));
			}
		}


	}

}

