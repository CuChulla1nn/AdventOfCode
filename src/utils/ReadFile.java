package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFile {
    public static List<String> readFileList(Path path) throws IOException {
        return Files.readString(path)
                .lines().toList();
    }
}
