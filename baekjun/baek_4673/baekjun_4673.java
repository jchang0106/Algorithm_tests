//Importing all util package
import java.util.*;


class baekjun_4673 { 

    public static void main(String[] args) {
        
        // 셀프넘버인 수를 저장해논 리스트
        ArrayList<Integer> isSelfNum = new ArrayList<Integer>();

        // isNotSelfNum을 완성시킨다.
        for (int i = 0; i < 10000; i++) {
            String num = String.valueOf(i);

            // 셀프넘버 = 23 + 2 + 3
            int selfNum = i;

            for (int n = 0; n < num.length(); n++) {

                selfNum += Integer.parseInt(num.substring(n, n+1));

            }

            isSelfNum.add(selfNum);

        }



        for (int i = 0; i < 10000; i++){

            if (!isSelfNum.contains(i)) {
                System.out.println(i);
            }


        }



        
  
    }
 
    
}

