//Importing all util package
import java.util.*;


class baekjun_10039 { 

    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);

        int answer = 0;


        for(int i = 0; i < 5; i++){

            int score = scan.nextInt();

            if (score < 40) {
                score = 40;
            }

            answer += score;


        }

        answer = answer / 5;

        System.out.println(answer);

        




    }
 


    
}

