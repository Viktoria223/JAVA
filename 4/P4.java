/*import java.util.*;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> list = new ArrayList<>();
        String seq = sc.next();
        boolean isTrue = true;
        for (int i = 0; i < seq.length(); i++) {
            char j = seq.charAt(i);
            list.add(j);
        }
        Stack<Character> stack = new Stack<>();
        for (Character i : list) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else {
                if (i == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                    if (stack.peek() != '(' || stack.empty()) {
                        isTrue = false;
                        break;
                    }
                }
                if (i == ']') {
                    if (stack.peek() != '[' || stack.empty()) {
                        stack.pop();
                    } else {
                        isTrue = false;
                        break;
                    }
                }
                if (i == '}') {
                    if (stack.peek() != '{' || stack.empty()) {
                        stack.pop();
                    } else {
                        isTrue = false;
                        break;
                    }
                }
            }
        }
        if (!stack.empty()) {
            isTrue = false;
        }
        if (isTrue) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}*/