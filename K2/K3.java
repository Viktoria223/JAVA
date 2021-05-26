import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class K3 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Path path = Paths.get("input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(list::add);
        } catch (IOException g) {
            g.printStackTrace();
        }
        ArrayList<String> list2 = list.stream().flatMap(x -> Stream.of(x.split(" ")))
                .filter(x -> Integer.parseInt(x) >= 110)
                .limit(5)
                .collect(Collectors.toCollection(ArrayList::new));
        FileWriter fw = new FileWriter("output.txt", false);
        for (int i = 0; i < list2.size(); i++) {
            if (i == list2.size() - 1) {
                fw.write(list2.get(i));
                break;
            }
            fw.write(list2.get(i));
            fw.write(",");
        }
        fw.flush();
        fw.close();
    }
}


