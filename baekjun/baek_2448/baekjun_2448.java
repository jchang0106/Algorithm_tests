//Importing all util package
import java.util.*;


class baekjun_2448 { 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // N = 3 * 2^k

        // Scan N
        int n = scan.nextInt();


        // Calculate k
        int k = 0;
        int n_copy = n/3;

        while(n_copy != 1){
            k++;
            n_copy = n_copy / 2; 
        }        

       

        ArrayList<String> base = new ArrayList<String>();
        base.add("  *   ");
        base.add(" * *  ");
        base.add("***** ");

        ArrayList<String> triangle = new ArrayList<String>();
        triangle.addAll(base);



        for (int i = 0; i < k; i++){
            String space = "   ";
            for (int j = 0; j < base.size(); j++){
                String thisSpace = "";
                for (int p = 0; p < Math.pow(2,i); p++){
                    thisSpace += space;
                }
                triangle.add(base.get(j) + base.get(j));
                triangle.set(j, thisSpace + base.get(j) + thisSpace);
            }
            base = new ArrayList<String>();
            base.addAll(triangle);
 
        }
        
        

        for (int i = 0; i < base.size(); i++){
            System.out.println(base.get(i));
        }


        


        
  
    }
 
    
}

