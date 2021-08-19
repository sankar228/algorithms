package algorithms;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        System.out.println("abcd".substring(0,2));
        System.out.println(obj.isPalindrome("abcbads"));
    }

    public boolean isPalindrome(String str){

      char[] c_str = str.toCharArray();
      for(int i=0, j= c_str.length -1; i <= j; i++, j--){
            if(c_str[i] != c_str[j]){
                return false;
            }
      }

        return true;
    }
}
