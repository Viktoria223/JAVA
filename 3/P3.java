import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> list = new ArrayList<>();
        String seq = sc.next();
        boolean isTrue = true;
        /*for (int i = 0; i < seq.length(); i++) {
            char j = seq.charAt(i);
            list.add(j);
        }*/
        Stack<Character> stack = new Stack<>();
        for (int z = 0; z < seq.length(); z++) {
            char i = seq.charAt(z);
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else {
                if (stack.empty() && (i == ')' || i == ']' || i == '}')) {
                    isTrue = false;
                    break;
                }
                if (i == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                if (i == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                if (i == '}' && stack.peek() == '{') {
                    stack.pop();
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
}

        /*for (Character i : list) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            }
            if (i == ')' && stack.empty()) {
                isTrue = false;
                break;
            }
            if (i == ']' && stack.empty()) {
                isTrue = false;
                break;
            }
            if (i == '}' && stack.empty()) {
                isTrue = false;
                break;
            }
            if (i == ')' && stack.pop() != '(') {
                isTrue = false;
                break;
            }
            if (i == ']' && stack.pop() != '[') {
                isTrue = false;
                break;
            }
            if (i == '{' && stack.pop() != '}') {
                isTrue = false;
                break;
            }
        }*/
