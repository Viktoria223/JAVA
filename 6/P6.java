import java.util.Scanner;
import java.io.*;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;


public class P6 {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("input.txt");
        Scanner sc = new Scanner(file);
        boolean isTrue = true;
        boolean isTrue2 = false;
        boolean isTrueTab = false;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            boolean f = false;
            for (int i = 0; i < str.length(); i++) {
                if (!f && str.charAt(i) == '\t') {
                    isTrueTab = true;
                }
                if (!f && str.charAt(i) == ' ') {
                    isTrue2 = true;
                }
                if (str.charAt(i) != '\t' && str.charAt(i) != ' ') {
                    f = true;
                }
                if (isTrue2 && isTrueTab) {
                    isTrue = false;
                }
            }
        }
        FileOutputStream fis = new FileOutputStream("output.txt");
        PrintWriter wr = new PrintWriter(fis);
        if (isTrue) {
            wr.println("YES");
        } else {
            wr.println("NO");
        }
        wr.close();
    }
}
