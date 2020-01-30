 //Importing all util package
 import java.util.*;


 class baekjun_1152 { 
 
     public static void main(String[] args) {
 
         Scanner scan = new Scanner(System.in);
 
         String line = scan.nextLine();
         
         String[] words = line.split(" ");
 
         int answer = words.length;
 
         for (int i = 0; i < words.length; i++){
 
             if (words[i].trim().equals("")){
                 answer--;
             }
 
         }
         
         System.out.println(answer);
 
     }
  
     
 }
 
 