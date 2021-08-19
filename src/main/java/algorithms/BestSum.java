package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        BestSum obj = new BestSum();

        //System.out.println(obj.bestSum(7, new int[] {2,3}));
        //System.out.println(obj.bestSum(7, new int[] {5,3,4,7}, new HashMap<>()));
        //System.out.println(obj.bestSum(8, new int[] {2,3,5}, new HashMap<>()));
        System.out.println(obj.bestSum(8, new int[] {1,4, 5}, new HashMap<>()));
        //System.out.println(obj.bestSum(100, new int[] {1,2,5,25}, new HashMap<>()));

        /*System.out.println(obj.bestSum(7, new int[] {2,3}, new HashMap<Integer, List<Integer>>()));
        System.out.println(obj.bestSum(7, new int[] {5,3,4,7}, new HashMap<Integer, List<Integer>>()));
        System.out.println(obj.bestSum(7, new int[] {2,4}, new HashMap<Integer, List<Integer>>()));
        System.out.println(obj.bestSum(8, new int[] {2,3,5}, new HashMap<Integer, List<Integer>>()));
        System.out.println(obj.bestSum(300, new int[] {7,293}, new HashMap<Integer, List<Integer>>()));*/
    }

    public List<Integer> bestSum(int targetSum, int[] input, Map<Integer, List<Integer>> memo){

        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;

        List<Integer> shortSumPath = null;
        for(int i=0; i < input.length; i++){
            int remainder = targetSum - input[i];

            List<Integer> sumPath = bestSum(remainder, input, memo);
            if(sumPath != null){
                sumPath.add(input[i]);

                if(shortSumPath == null || sumPath.size() < shortSumPath.size()){
                    shortSumPath = sumPath;
                }
            }
        }

        memo.put(targetSum, shortSumPath);
        return memo.get(targetSum);
    }
}
