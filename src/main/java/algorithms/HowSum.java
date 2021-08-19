package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        HowSum obj = new HowSum();

        System.out.println(obj.howSum(7, new int[] {2,3}, new HashMap<Integer, List<Integer>>()));
        System.out.println(obj.howSum(7, new int[] {5,3,4,7}, new HashMap<Integer, List<Integer>>()));
        System.out.println(obj.howSum(7, new int[] {2,4}, new HashMap<Integer, List<Integer>>()));
        System.out.println(obj.howSum(8, new int[] {2,3,5}, new HashMap<Integer, List<Integer>>()));
        System.out.println(obj.howSum(300, new int[] {7,293}, new HashMap<Integer, List<Integer>>()));
    }

    public List<Integer> howSum(int targetSum, int[] input, Map<Integer, List<Integer>> memo){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0){
            return new ArrayList<>();
        }
        if(targetSum < 0) return null;

        for(int i=0; i < input.length; i++){
            int remainder = targetSum - input[i];
            List<Integer> returnedResult = howSum(remainder, input, memo);
            if(returnedResult != null) {
                returnedResult.add(input[i]);
                memo.put(targetSum, returnedResult);
                return memo.get(targetSum);
            }
        }

        memo.put(targetSum, null);
        return memo.get(targetSum);
    }
}
