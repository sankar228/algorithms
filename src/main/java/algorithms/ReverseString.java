package algorithms;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString obj = new ReverseString();

        String reversedStr = obj.reveseStringUsingRecursion("abcd");
        System.out.println(reversedStr);
    }

    public String reveseStringUsingRecursion(String str){
        if(str.equals("")){
            return "";
        }

        return str.charAt(str.length() -1 ) + reveseStringUsingRecursion(str.substring(0, str.length() -1));
    }
}
