import java.util.*;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> openBraces = new Stack<>();
        int countOpen = 0;
        int countClosed = 0;
        boolean f = false;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                openBraces.push(s.charAt(i));
                countOpen++;

            } else countClosed++;
            if (!openBraces.empty()) {
                if (s.charAt(i) == ')' && openBraces.peek() == '(') {
                    openBraces.pop();
                }
                if (s.charAt(i) == ']' && openBraces.peek() == '[') {
                    openBraces.pop();
                }
                if (s.charAt(i) == '}' && openBraces.peek() == '{') {
                    openBraces.pop();
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                f = true;
                break;
            } else f = false;
        }
        if (openBraces.empty() && countClosed == countOpen) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}