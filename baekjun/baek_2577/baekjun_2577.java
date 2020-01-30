//Importing all util package
import java.util.*;


class baekjun_2577 { 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int one = scan.nextInt();
        scan.nextLine();
        int two = scan.nextInt();
        scan.nextLine();
        int three = scan.nextInt();
        scan.nextLine();

        int int_ans = one * two * three;

        int[] answer = {0,0,0,0,0,0,0,0,0,0};

        String str_ans = Integer.toString(int_ans);

      

        for(int i = 0; i < str_ans.length(); i++){
            int a = (int)str_ans.charAt(i);
            a -= 48;
            // System.out.println(answer[a]);
            answer[a] = answer[a] + 1;
            // System.out.println(answer[a]);

        }

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
 
    
}

