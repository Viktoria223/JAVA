import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j < Math.sqrt(n) + 1; j++) {
                if (n % i == 0) {
                    prime = false;
                }
                if (prime) {
                    a.add(i);
                }
            }

        }
        System.out.println(a);
    }
}
