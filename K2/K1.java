import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class K1 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Stream<String> lines = Files.lines(Paths.get("input.txt"));
        lines.forEach(list::add);
        ArrayList<String> list2 = list.stream().filter(x -> {
            int k = 0;
            boolean isTrue = false;
            for (String string : x.split(" ")) {
                if(!string.equals(""))
                    if (Integer.parseInt(string) < 100) {
                        k++;
                    }
            }
            if (k < 6) {
                isTrue = true;
            }
            return isTrue;
        }).collect(Collectors.toCollection(ArrayList::new));
        FileWriter writer = new FileWriter("output.txt", false);
        for (String string : list2) {
            writer.write(string + " " + "\n");
        }
        writer.flush();
        writer.close();
    }
}
