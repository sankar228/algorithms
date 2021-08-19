package algorithms;

import java.util.*;

public class FindDuplicateWords {
    public static void main(String[] args) {
        String input = "The dog is the best";
        String[] result = findDuplicates(input);
        System.out.println(Arrays.asList(result));
    }

    public static String[] findDuplicates(String input) {
        String[] inputwords = input.split(" ");
        Map<String, Integer> result = new HashMap();


        int totalDuplicatewords = 0;
        for(int i=0; i < inputwords.length; i++){
            String checkword = inputwords[i].toLowerCase();
            if (result.get(checkword) == null) {
                result.put(checkword, 0);
            } else {
                if(result.get(checkword) == 0){
                    totalDuplicatewords ++;
                }
                result.put(checkword, result.get(checkword) + 1);

            }
        }

        String[] finalresult = new String[totalDuplicatewords];
        int i =0;
        for(Map.Entry<String, Integer> r : result.entrySet()){
            if(r.getValue() > 0){
                finalresult[i] = r.getKey();
                i++;
            }
        }
        return finalresult;
    }

}
