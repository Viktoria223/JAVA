import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P9 {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("input.txt"));
        ArrayList<String> list = new ArrayList<>();
        lines.forEach(list::add);
        ArrayList<String> list2 = list.stream()
                .filter(x -> x.length() < 80).collect(Collectors.toCollection(ArrayList::new));
        PrintWriter pw = new PrintWriter("output.txt");
        for (String s : list2) {
            String reverse = new StringBuffer(s).reverse().toString();
            pw.print(reverse);
            pw.print('\n');
        }
        pw.close();
    }
}
