import java.io.*;
import java.util.*;

public class Class12 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\huawei\\Desktop\\Java\\Homeworks\\C12\\test.txt");
        /*Scanner sc = new Scanner(fos);
        String line = sc.nextLine();
        String[] numbers = line.split(" ");
        for(int i = 0; i < 3; i++) {
            System.out.println(numbers[i]);
        }*/
        PrintWriter pw = new PrintWriter(fos);
        pw.print('5');
        pw.close();
    }
}
