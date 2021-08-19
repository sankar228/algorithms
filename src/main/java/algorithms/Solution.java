package algorithms;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int result = obj.solution(new int[]{6,1,4,6,3,2,7,4}, 3, 2);

        System.out.println(result);

        LinkedList<Integer> l = new LinkedList<>();;
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);

        System.out.println(l.remove());
    }
    public int solution(int[] A, int K, int L) {

        // write your code in Java SE 8
        if((K + L) > A.length) return -1;
        int result = 0;
        for(int i =0; i <= (A.length - (K + L)); i++){
            int fsum = consicutiveApples(A, i, K);
            int sum = 0;
            for(int j =(i + K); j <= (A.length - L); j++){
                sum = fsum + consicutiveApples(A, j, L);
                if(result < sum){
                    result = sum;
                }
            }
        }

        for(int i =0; i <= (A.length - (K + L)); i++){
            int fsum = consicutiveApples(A, i, L);
            int sum = 0;
            for(int j =(i + L); j <= (A.length - K); j++){
                sum = fsum + consicutiveApples(A, j, K);

                if(result < sum){
                    result = sum;
                }
            }
        }

        return result;
    }

    public int consicutiveApples(int[] A, int inx, int len){

        int count = 0;
        for(int i = inx; i < (inx + len); i++){
            count += A[i];
        }

        return count;
    }
}
