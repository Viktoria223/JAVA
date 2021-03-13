/*import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int uOpen = 0;
        int uClose = 0;
        boolean isTrue = true;
        for (int z = 0; z < seq.length(); z++) {
            //char i = seq.charAt(z);
            if (seq.charAt(z) == '(' || seq.charAt(z) == '[' || seq.charAt(z) == '{') {
                stack.push(seq.charAt(z));
                uOpen++;
            } else uClose++;
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
}*/

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