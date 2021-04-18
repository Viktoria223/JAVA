import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestPrinter {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("test51.txt");
        PrintWriter pw = new PrintWriter(fos);
        Random random = new Random();
        pw.println(10000);
        for (int i = 1; i <= 10000; i++) {
            pw.print(random.nextInt(100) + 1 + " ");
        }
        pw.println();
        pw.println(random.nextInt(100000));
        pw.close();
    }
}

