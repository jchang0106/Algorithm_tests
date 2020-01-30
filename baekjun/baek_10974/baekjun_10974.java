import java.io.*;
import java.util.*;


class baekjun_10974 {

	public static void main(String[] args) {

		// N 	    
		Scanner scan = new Scanner(System.in);

		// N
		int n = scan.nextInt();

		// Array declare
		int [] array = new int[n];

		// Array init
		for (int i = 0; i < n; i++){

			array[i] = i + 1;

		}

		boolean done = false;

		while(!done){

			// Print the current array
			for(int i = 0; i < array.length; i++){
				System.out.print(array[i] + " ");
			}
			System.out.println("");


			int i = array.length - 1;
			// i = largest index such that array[i-1] < array[i]
			while (i > 0 && array[i - 1] >= array[i]){
				i--;
			}
			// If no such array, current array is the last permutation
			if (i <= 0) {
				done = true;
				continue;
			}

			// j = largest index j such that i >= j and array[j] > array[i-1]
			int j = array.length - 1;
			while (array[j] <= array[i-1]){
				j--;
			}
			// Swap i and j index of the array
			int temp = array[i-1];
			array[i-1] = array[j];
			array[j] = temp;

			// Reverse the suffix starting at array[i] for order
			int r = array.length - 1;
			while(i < r){

				temp = array[i];
				array[i] = array[r];
				array[r] = temp;
				i++;
				r--;

			}
			

		}





	}
}
	