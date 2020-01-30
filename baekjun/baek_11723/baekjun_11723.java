//Importing all util package
import java.util.*;
import java.io.*;

class baekjun_11723 { 

    public static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        try {

        
            int leng = Integer.parseInt(br.readLine());    
            
            

            int bit_set = 0;

            String[] line = new String[2];

            // int test = (int) Math.pow(2,2);

            // int test2 = (int)Math.pow(2,2);

            // int test3 = test | test2;

            // System.out.println(Integer.toBinaryString(test3));
            // System.out.println(Integer.toBinaryString(test3 & ~test));

            // int answer = 0;
            // for (int i = 1; i <= 20; i++){

            //     answer += (int) Math.pow(2,i-1);


            // }
            // System.out.println(answer);
            // System.out.println(Integer.toBinaryString(answer));

            // ArrayList<String> checkList = new ArrayList<String>();

            
            for (int i = 0; i < leng; i++){

                
                line = br.readLine().split(" ");    
                

                

                if(line[0].equals("add")) {

                    bit_set = bit_set | (int) Math.pow(2,(Integer.parseInt(line[1])-1));
                    // System.out.println(bit_set);
                    // System.out.println(Integer.toBinaryString(bit_set));

                }

                else if (line[0].equals("remove")) {

                    bit_set = bit_set & ~((int) Math.pow(2,(Integer.parseInt(line[1])-1)));
                    // System.out.println(bit_set);
                    // System.out.println(Integer.toBinaryString(bit_set));

                }

                else if (line[0].equals("check")) {

                    if((bit_set & ((int) Math.pow(2,(Integer.parseInt(line[1])-1)))) != 0){
                        // System.out.println(1);
                        // checkList.add("1");
                        wr.write("1\n");

                    }

                    else {
                        // System.out.println(0);
                        // checkList.add("0");
                        wr.write("0\n");
                    }

                    // System.out.println(bit_set & ((int) Math.pow(2,(Integer.parseInt(line[1])-1))));
                    // System.out.println(Integer.toBinaryString(bit_set & ((int) Math.pow(2,(Integer.parseInt(line[1])-1)))));
                    

                }

                else if (line[0].equals("toggle")) {

                    bit_set = bit_set ^ ((int) Math.pow(2,(Integer.parseInt(line[1])-1)));
                    // System.out.println(bit_set);
                    // System.out.println(Integer.toBinaryString(bit_set));


                }

                else if (line[0].equals("all")) {

                    bit_set = 1048575;

                }

                else if (line[0].equals("empty")) {

                    bit_set = 0;

                }


            }

            br.close();
            wr.close();


            // for(int i = 0; i < checkList.size(); i++){
            //     System.out.println(checkList.get(i));
            // }

        } catch(Exception e) {
            e.printStackTrace();
        }


    }
 
    
}

