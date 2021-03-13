import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq = sc.next();
        int uOpen = 0;
        int uClose = 0;
        boolean isTrue = true;
        Stack<Character> stack = new Stack<>();
        for (int z = 0; z < seq.length(); z++) {
            //char i = seq.charAt(z);
            if (seq.charAt(z) == '(' || seq.charAt(z) == '[' || seq.charAt(z) == '{') {
                stack.push(seq.charAt(z));
                uOpen++;
            } else {
                uClose++;
            }
            if (!stack.empty()) {
                if (seq.charAt(z) == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                if (seq.charAt(z) == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                if (seq.charAt(z) == '}' && stack.peek() == '{') {
                    stack.pop();
                }
            }
        }
        if(stack.empty() && uClose == uOpen) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}

