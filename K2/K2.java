import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class K2 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Path path = Paths.get("input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> ar = list.stream().flatMap(x -> {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (String s:
                    x.split(" ")) {
                if (Integer.parseInt(s) < min) {
                    min = Integer.parseInt(s);
                }
            }
            sum += min;
            return Stream.of(String.valueOf(sum));
        }).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> v = new ArrayList<>();
        for (String s : ar) {
            v.add(Integer.valueOf(s));
        }
        v.sort(Comparator.reverseOrder());
        FileWriter pw = new FileWriter("output.txt", false);
        String s = String.valueOf(v.get(0));
        pw.write(s);
        pw.flush();
        pw.close();
    }
}