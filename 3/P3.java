import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        String seq = sc.next();
        boolean isTrue = true;
        for (int i = 0; i < seq.length(); i++) {
            char j = seq.charAt(i);
            list.add(j);
            list2.add(j);
        }
        Stack<Character> stack = new Stack<>();
        for (Character i : list) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
                list2.remove(i);
            } else {
                if (stack.empty()) {
                    isTrue = false;
                    break;
                }
                if (i == ')') {
                    if (stack.pop() == '(') {
                        list2.remove(i);
                    } else {
                        isTrue = false;
                        break;
                    }
                }
                if (i == ']') {
                    if (stack.pop() == '[') {
                        list2.remove(i);
                    } else {
                        isTrue = false;
                        break;
                    }
                }
                if (i == '}') {
                    if (stack.pop() == '{') {
                        list2.remove(i);
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
        if (!list2.isEmpty()) {
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

