import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestPrinter2 {
    public static void main(String[] args) throws IOException {
        String s = "C:\\Users\\huawei\\Desktop\\Java\\Homeworks\\Tests2\\ttest51.txt";
        FileOutputStream fos = new FileOutputStream(s);
        PrintWriter pw = new PrintWriter(fos);
        Random random = new Random();
        int h = 10000;
        pw.println(h);
        for (int i = 1; i <= h; i++) {
            pw.print(random.nextInt(100) + 1 + " ");
        }
        pw.close();
    }
}
