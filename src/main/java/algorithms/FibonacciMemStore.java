package algorithms;

import java.util.Arrays;

public class FibonacciMemStore {
    public static void main(String[] args) {
        FibonacciMemStore obj = new FibonacciMemStore();
        //obj.allFib(10);
        System.out.println(obj.fib(6));
    }

    void allFib(int n){
        for(int i =0; i < n; i++) {
            int[] memo = new int[n + 1];
            System.out.println(i + ":" + fib(i, memo));
        }
    }

    int fib(int i, int[] memo){
        if (i <= 0) return 0;
        else if (i == 1) return 1;
        else if (memo[i] > 0) return memo[i];

        return memo[i] = fib(i -1, memo) + fib(i -2, memo);
    }

    int fib(int n){
        int[] table = new int[n + 1];
        Arrays.fill(table, 0);

        table[1] = 1;

        for(int i=2; i<=n; i++){
            table[i] = table[i -1] + table[i -2];
        }
        return table[n];
    }
}
