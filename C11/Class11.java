import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Class11 {
    public static void main(String[] args) throws IOException {
        /*Files.list(Paths.get(args[0]))
                .flatMap(p -> {
                    if (Files.isRegularFile(p))
                        return Stream.of(p);
                    else
                        return Files.list(p);
                } catch (IOException)*/
    }
}
