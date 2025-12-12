package tests.year2025.day1;

import org.junit.jupiter.api.Test;
import year2025.day1.Day1;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {
    @Test
    void example_part1_shouldReturn3() {
        Day1 day1 = new Day1();
        List<String> input = List.of(
                "L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82"
        );
        int result = day1.countPart1(input);
        assertEquals(3, result, "Example part 1 result should be 3");
    }

    @Test
    void example_part2_shouldReturn6() {
        Day1 day1 = new Day1();
        List<String> input = List.of(
                "L68", // pass 1
                "L30",
                "R48", // stop at 0
                "L5",
                "R60", // pass 1
                "L55", // stop at 0
                "L1",
                "L99", // stop at 0
                "R14",
                "L82"  // pass 1
        );
        int result = day1.countPart2(input);
        assertEquals(6, result, "Example part 2 result should be 6");
    }

    @Test
    void smallEdge_caseEndsExactlyOnZero_singlePass() {
        // Start 50, move R50 → 0 (no wrap)
        Day1 day1 = new Day1();
        List<String> input = List.of("R50");
        //assertEquals(1, day1.countPart1(input));
        assertEquals(1, day1.countPart2(input));
    }

    @Test
    void largeMoves_multipleZeroPasses() {
        // Start 50, move R250 → passes 0 twice + landing
        Day1 day1 = new Day1();
        List<String> input = List.of("R250");

        //assertEquals(1, day1.countPart1(input), "Part1: only endpoint counts");
        assertEquals(3, day1.countPart2(input), "Part2: 2 passes + 1 landing = 3");
    }

    @Test
    void negativeLargeMoves_multipleZeroPasses() {
        // Start 50, move L250 → same pass pattern
        Day1 day1 = new Day1();
        List<String> input = List.of("L250");

        assertEquals(1, day1.countPart1(input));
        assertEquals(3, day1.countPart2(input));
    }
}
