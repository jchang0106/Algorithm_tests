//Importing all util package
import java.util.*;
import java.io.*;

class baekjun_2750 { 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();


        int[] arr = new int[n];

        for (int i = 0; i < n; i++){

            arr[i] = scan.nextInt();

            
        }


        Arrays.sort(arr);

        for (int elem : arr){
            System.out.println(elem);
        }
        


    }
 
    
}

