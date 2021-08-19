package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AllConstruct {
    public static void main(String[] args) {
        AllConstruct obj = new AllConstruct();

        System.out.println(obj.allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    }

    public List<Deque<String>> allConstruct(String target, String[] wordbank){
            if("".equals(target)){
                Deque<String> sufway = new LinkedList<>();
                List<Deque<String>> ways = new ArrayList<>();
                ways.add(sufway);
                return ways;
            }

            List<Deque<String>> result = new ArrayList<>();
            for(String word : wordbank){
                if(target.startsWith(word)){
                    String suffix = target.substring(word.length());
                    List<Deque<String>> sufways = allConstruct(suffix, wordbank);

                    for(Deque<String> subway : sufways){
                        subway.addFirst(word);
                    }

                    result.addAll(sufways);
                }
            }

            return  result;
    }
}
