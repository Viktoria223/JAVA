import java.io.*;
import java.util.*;

public class Class7 {
    public static void main(String[] args) throws Exception {
        FileReader fis = new FileReader("vin1.txt");
        Scanner sc = new Scanner (fis);
        Map<String, Integer> map = new TreeMap<>();
        while(sc.hasNextLine()) {
            //String[] mas = fis.split(" ");
        }

        
        fis.close();
    }
}
