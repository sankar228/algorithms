package algorithms;

public class StringCompress {
    public static void main(String[] args) {
        StringCompress obje = new StringCompress();

        System.out.println(obje.stringCompress("aabccccaaddd"));
    }

    public String stringCompress(String input){
        StringBuilder output = new StringBuilder();
        char posChar = input.charAt(0);
        int countConsecChar = 1;
        for(int i =1; i<input.length(); i++){
            if(input.charAt(i) == posChar){
                countConsecChar ++;
            }else{
                output.append(posChar+""+countConsecChar);

                countConsecChar = 1;
                posChar = input.charAt(i);
            }
        }
        output.append(posChar+""+countConsecChar);

        return output.toString().length() < input.length() ? output.toString() : input;
    }
}
