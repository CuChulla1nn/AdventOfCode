package year2025.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    static BufferedReader reader;

    public static List<String> readFileList(String path) throws IOException {
        reader = new BufferedReader(new FileReader(path));
        return reader.lines().toList();
    }

    public static List<Range> readRangeList(String path) throws IOException {
        reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();

        String[] splits = line.split(",");

        List<Range> ranges = new ArrayList<>();

        for (String split : splits) {
            String[] splited = split.split("-");
            long start = Long.parseLong(splited[0]);
            long end = Long.parseLong(splited[1]);
            ranges.add(new Range(start, end));
        }

        return ranges;
    }
}
