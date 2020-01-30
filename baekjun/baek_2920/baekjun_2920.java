//Importing all util package
import java.util.*;


class baekjun_2920 { 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int [] answer = new int[8];

        int [] result = new int[3];
        result[0] = 0;
        result[1] = 0;
        result[2] = 0;
        
        for (int i = 1; i <= 8; i++){

            int t = scan.nextInt();
            answer[i-1] = t;

            if (i == 1){

                if(t == 1){
                    result[0] = 1;
                }
                else if (t == 8){
                    result[1] = 1;
                } else {
                    result[2] = 1;
                }

            }


            if (t == i){
                if (result[0] == 1){
                    continue;
                } else {
                    result[2] = 1;
                    break;
                }
            } 
            else if (t == (9-i)) {
                if (result[1] == 1){
                    continue;
                } else {
                    result[2] = 1;
                    break;
                }
            } else {

                result[2] = 1;
                break;
                
            }

        }

        if (result[2] == 1) {
            System.out.println("mixed");
        } else if (result[0] == 1){
            System.out.println("ascending");
        } else if (result[1] == 1){

            System.out.println("descending");
        }






    }
 
    
}

