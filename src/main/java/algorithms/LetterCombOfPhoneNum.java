package algorithms;

import java.util.*;

public class LetterCombOfPhoneNum {
    public static void main(String[] args) {
        LetterCombOfPhoneNum obj = new LetterCombOfPhoneNum();

        Map<Integer, String> keywords = new HashMap<>();

        keywords.put(1, "abc");
        keywords.put(2, "def");
        keywords.put(7, "stu");
        List<String> result = new ArrayList<>();;

        char[] input = "112".toCharArray();

        //obj.letterCombinationOfPhoneNumber(Arrays.asList(new Integer[]{1,7,1,7}), keywords);
        //System.out.println(obj.letterCombinationsDynamic("2"));
        System.out.println(obj.letterCombinations("223"));
    }

    /* Iterative method */
    public void letterCombinationOfPhoneNumber (List<Integer> input, Map<Integer, String> keywords) {

        char[] wordChars = keywords.get(input.get(0)).toCharArray();
        List<String> midStrList = new ArrayList<>();
        for(int i =0; i<wordChars.length; i++){
            midStrList.add(String.valueOf(wordChars[i]));
        }

        for(int j = 1; j < input.size(); j++){
            midStrList = joinwithNextwordChar(midStrList, keywords.get(input.get(j)));
        }

        System.out.println(midStrList);
    }

    public List<String> joinwithNextwordChar(List<String> midStrList, String word){
        List<String> newWordList = new ArrayList<>();
        char[] chars = word.toCharArray();
        for(String str : midStrList){
            for(int i=0; i < chars.length; i++){
                newWordList.add(str + chars[i]);
            }
        }

        return newWordList;
    }

    /*Recursive method*/

    List<String> letterCombinations(String digits) {
        int n = digits.length();
        String[] keys =  {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();;
        if(n==0) return result;

        combination(result, keys, digits, 0, "");

        return result;
    }

    private void combination(List<String> result, String[] keys, String digits, int i, String s) {

        if(i == digits.length()){
            result.add(s);
            return;
        };

        for(char c : keys[digits.charAt(i) - '0'].toCharArray()){
            combination(result, keys, digits, i + 1, s + String.valueOf( c));
        }
    }

    List<String> letterCombinationsDynamic(String digits) {
        int n = digits.length();
        String[] keys =  {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();;
        if(n==0) return result;

        LinkedList<String> queue = new LinkedList<>();
        for(int i =0; i < digits.length(); i++){
            char[] chars = keys[digits.charAt(i) - '0'].toCharArray();

            if(i == 0){

                for(int j = 0; j <chars.length; j++){
                    if(String.valueOf(chars[j]).length() == digits.length()){
                        result.add(String.valueOf(chars[j]));
                    }else {
                        queue.add(String.valueOf(chars[j]));
                    }
                }
            }else{
                int qsize = queue.size();
                for(int k =0; k < qsize; k++){
                    String item = queue.pop();
                    for(int j = 0; j <chars.length; j++){
                        String nextval =item+String.valueOf(chars[j]);
                        if(nextval.length() == digits.length())
                            result.add(nextval);
                        else
                            queue.add(nextval);
                    }
                }
            }
        }

        return result;
    }
}
