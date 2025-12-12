import year2025.day1.Day1;
import year2025.day2.Day2;
import year2025.utils.Range;
import year2025.utils.ReadFile;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> inputList = ReadFile.readFileList("src/year2025/day1/input.txt");

        Day1 day1 = new Day1();
        int countPart1 = day1.countPart1(inputList);
        int countPart2 = day1.countPart2(inputList);

        System.out.println("-----------------Day1------------------");
        System.out.println("Count for part one is: " + countPart1);
        System.out.println("Count for part two is: " + (countPart2));
        System.out.println("-------------------------------------");

        List<Range> input = ReadFile.readRangeList("src/year2025/day2/input.txt");

        Day2 day2 = new Day2();
        long count2Part1 = day2.partOne(input);
        System.out.println("-----------------Day2-------------------");
        System.out.println("Count for part one is: " + count2Part1);
        System.out.println("Count for part two is: ");
        System.out.println("-------------------------------------");
    }
}