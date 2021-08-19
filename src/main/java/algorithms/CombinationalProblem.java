package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationalProblem {
    public static void main(String[] args) {
        CombinationalProblem obj = new CombinationalProblem();
        List<Integer> input = Arrays.asList(new Integer[]{1,2,3,4,5});

        List<List<Integer>> result = obj.combinations(input , 3);
        System.out.println(result);
    }

    private List<List<Integer>> combinations(List<Integer> input, int k) {

        // three number in the sub array
        List<List<Integer>> result = new ArrayList();
        //combinations(result, input, 3, new ArrayList<Integer>(), 0);

        if(input.size() < k){
            return result;
        }
        if(input.size() == k){
            result.add(input);
            return result;
        }

        for(int i =0 ; i < (input.size() - k); i++){
            for(int j = i+1 ; j <(input.size() - k -1); j++){
                List<Integer> subset = new ArrayList<>();
                subset.add(input.get(i));
                subset.add(input.get(j));
                int m = j +1;
                int n = i + k;
                while(m < n) {
                    subset.add(input.get(m));
                    m++;
                }
                if(subset.size() == k){
                    result.add(subset);
                }
            }

        }
        return result;
    }

    private void combinations(List<List<Integer>> result, List<Integer> input, int L, List<Integer> vset, int inx) {
        if(input.size() <= L) {
            result.add(new ArrayList<>());
            return;
        }

        if(inx == L){
            result.add(new ArrayList(vset));

            return;
        }

        for(int i =inx; i < input.size(); i++) {
            vset.add(input.get(i));
            combinations(result, input, L, vset, inx + 1);
            vset.remove(vset.size() - 1);
        }

    }
}
