// 문제 링크
// https://programmers.co.kr/learn/challenge_codes/79

class FifoScheduling {
	public int getCoreNumber(int n, int[] core) {
		int answer = 0;
    
    
    int[] coreRemain = new int[core.length];
    
    // Initialize all to ZERO.
    for (int i = 0; i < coreRemain.length; i++){
    	coreRemain[i] = 0;
    }

    System.out.println("n: " + n);
    System.out.println("coreRemain length: " + coreRemain.length);
    System.out.println("0: " + coreRemain[0]);
    System.out.println("1: " + coreRemain[1]);
    System.out.println("2: " + coreRemain[2]);
    
    while(n > 0) {
      
    	for (int i = 0; i < coreRemain.length; i++) {
      	if (coreRemain[i] == 0) {

        

          n--;
          coreRemain[i] = core[i];
          System.out.println("11111111");
          System.out.println("n: " + n);
          System.out.println("i: " + i);
          System.out.println("coreRemain[i]: "+ coreRemain[i]);
          System.out.println();

        } else {
          // coreReamin 전체가 각각 -1
          if (i == 2){
            for (int j = 0; j < coreRemain.length; j++){
              coreRemain[j] = coreRemain[j]-1;
            }
            i = -1;

            System.out.println("222222222");
            System.out.println("i: " + i);
            System.out.println("coreRemain[0]: "+ coreRemain[0]);
            System.out.println("coreRemain[1]: "+ coreRemain[1]);
            System.out.println("coreRemain[2]: "+ coreRemain[2]);

            System.out.println();
          }

          
        }

        if (n == 0) {
          System.out.println("END");
          answer = i+1;
          break;
        }
        
      }
    	
      
    }

		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		FifoScheduling fifo = new FifoScheduling();
		int[] core = { 1, 2, 3 };
		System.out.println(fifo.getCoreNumber(10, core));
	}
}
