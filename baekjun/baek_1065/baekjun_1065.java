//Importing all util package
import java.util.*;


class baekjun_1065 { 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        if (input < 100) {

            System.out.println(input);


        } else {


            int hanNumCount = 99;
            for (int i = 100; i <= input; i++) {

                

                String num = String.valueOf(i);


                int tempNum = 0;
                boolean isNotHan = false;

                for (int n = 0; n < num.length()-1; n++){

                    if (n == 0) {
                        tempNum = Integer.parseInt(num.substring(n, n+1)) 
                                    - Integer.parseInt(num.substring(n+1, n+2));
                    } else {
                        int compNum = Integer.parseInt(num.substring(n, n+1)) 
                                        - Integer.parseInt(num.substring(n+1, n+2));
                        if (tempNum != compNum) {
                            isNotHan = true;
                            break;
                        }
                    }

                }

                if (!isNotHan) {
                    hanNumCount++;
                }

            }

            System.out.println(hanNumCount);
        }   

        

        
  
    }
 
    
}

