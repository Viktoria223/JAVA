import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P10 {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("input.txt"));
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        lines.forEach(list::add);
        for (String s : list) {
            String[] words = s.split(" ");
            list2.addAll(Arrays.asList(words));
        }
        ArrayList<String> list3 = list2.stream()
                .filter(x -> x.charAt(0) == 'e' || x.charAt(0) == 'u' || x.charAt(0) == 'i' || x.charAt(0) == 'o' || x.charAt(0) == 'a')
                .collect(Collectors.toCollection(ArrayList::new));
        PrintWriter pw = new PrintWriter("output.txt");
        list3.forEach(pw::println);
        pw.close();
    }
}
