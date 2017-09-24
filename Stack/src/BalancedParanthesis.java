import java.util.Stack;
/**
 * Created by atindramardikar on 19/09/17.
 */
public class BalancedParanthesis {
    static boolean compareBrackets(char c1, char c2){
        if(c1=='{' && c2=='}')
            return true;
        if(c1=='(' && c2==')')
            return true;
        if(c1=='[' && c2==']')
            return true;
        return false;
    }
    static boolean balancedParanthesis(String expr) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                st.push(c);
            } else if (!compareBrackets(st.pop(), c)) {
                return false;
            }

        }
        if(st.empty())
        return true;

        return false;
    }
    public static void main(String[] args) {
        System.out.println(balancedParanthesis("{[]"));
    }
}
