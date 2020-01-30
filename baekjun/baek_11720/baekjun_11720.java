import java.util.*; //Importing all util package

// Main class for BaekJoon website
class baekjun_11720 {

	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		// Scan the N, number of numers to sum
		int n = scan.nextInt();
		// To get rid of "\n"
		scan.nextLine();

		// Scan the numbers as string
		String line = scan.nextLine();
	

		// Declare int var for sum
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += (int) line.charAt(i);
			sum -= 48;

		}
		System.out.println(sum);

	}

}

