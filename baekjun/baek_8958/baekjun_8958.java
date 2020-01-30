//Importing all util package
import java.util.*;


class baekjun_8958 { 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        
        int tc_num = scan.nextInt();

        scan.nextLine();

        ArrayList<String> ox = new ArrayList<String>();

        for(int i = 0; i < tc_num; i++){

            ox.add(scan.nextLine());


        }

        // [디버깅] ox 프린트
        // for(int i = 0; i < ox.size(); i++){

        //     System.out.println(ox.get(i));


        // }


        // ox Iteration

        for (int i = 0; i < ox.size(); i++){

            String line = ox.get(i);

            int prev_score = 0;
            int answer = 0;

            // char in line iteration
            for (int j = 0; j < line.length(); j++){

                

                if (line.charAt(j) == 'O'){
                    
                    answer += prev_score + 1;

                    prev_score += 1;

                } 

                else {
                    prev_score = 0;

                }




            }
            System.out.println(answer);





        }



    }
 
    
}

