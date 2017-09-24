import java.util.Stack;
/**
 * Created by atindramardikar on 19/09/17.
 */

public class InfixToPostfix {

    static int prec(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    static String infixToPostfix(String expr){
        StringBuilder result = new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<expr.length();i++){
            char c = expr.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }else {
                if (st.empty() || prec(c) > prec(st.peek())) {
                    st.push(c);
                } else {
                    while (prec(c) <= prec(st.peek())) {
                        result.append(st.pop());
                        if(st.empty())
                            break;
                    }
                    st.push(c);
                }
            }
            if(c=='('){
                st.push(c);
            }else if(c==')') {
                while (st.peek() != '(')
                    result.append(st.pop());
                result.append(st.pop());
            }
        }
        while(!st.empty()){
            result.append(st.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*c+d"));
    }
}
