//Importing all util package
import java.util.*;
import java.io.*;

class Main { 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();


        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++){

            arr[i] = scan.nextInt();
            sum += arr[i];

            
        }

        // 1  평균
        int avg = sum / n;

        System.out.println(avg);

        // 2. 중간 값

        Arrays.sort(arr);

        if (n % 2 == 0){

            System.out.println(arr[(n/2) - 1]);

        } else {

            System.out.println(arr[n/2]);
            
        }
                

        // 3. 최빈값



    }
 
    
}

