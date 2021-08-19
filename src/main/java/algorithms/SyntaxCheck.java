package algorithms;

import java.util.Stack;

public class SyntaxCheck {
    public static void main(String[] args){
        SyntaxCheck obj = new SyntaxCheck();

        String str = "[{[{]}}]";
        System.out.println(obj.isSyntaxValid(str));
    }

    public boolean isSyntaxValid(String str){
        char[] strChars = str.toCharArray();
        Stack<Character> compilerStack = new Stack();
        for(int i=0; i<strChars.length; i++){
            if(strChars[i] == '{' || strChars[i] == '['){
                compilerStack.push(strChars[i]);
            }else if(strChars[i] == '}' || strChars[i] == ']'){
                if((strChars[i] == '}' && compilerStack.peek() == '{')
                || (strChars[i] == ']' && compilerStack.peek() == '[')){
                    compilerStack.pop();
                }else{
                    return false;
                }
            }
        }

        if(compilerStack.isEmpty()){
            return true;
        }
        return false;
    }
}
