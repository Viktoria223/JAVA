import java.util.*;


public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int u = 0;
        boolean isTrue = true;
        for (int z = 0; z < seq.length(); z++) {
            char i = seq.charAt(z);
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    if (i == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                    if (i == ']' && stack.peek() == '[') {
                        stack.pop();
                    }
                    if (i == '}' && stack.peek() == '{') {
                        stack.pop();
                    }
                } else {
                    u++;
                }
            }
        }
        if (!stack.empty()) {
            isTrue = false;
        }
        if (u != 0) {
            isTrue = false;
        }
        if (isTrue) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
