package year2025.day1;

import java.util.List;

public class Day1 {

    int dial;
    int count = 0; //amount the dial stops on 0
    int countPass = 0; //amount the dial stops on 0 and passes 0

    public int countPart1(List<String> inputList) {
        reset();
        for (String input : inputList) {
            stepRotation(input, false);
        }
        return count;
    }

    public int countPart2(List<String> inputList) {
        reset();
        for (String input : inputList) {
            stepRotation(input, true);
        }
        return countPass;
    }

    private void stepRotation(String input, boolean countDuring) {
        char direction = input.charAt(0);
        int steps = Integer.parseInt(input.substring(1));

        for (int i = 0; i < steps; i++) {
            if (direction == 'R') {
                dial = (dial + 1) % 100;
            } else {
                dial = (dial - 1 + 100) % 100;
            }

            if (countDuring && dial == 0) {
                countPass++;
            }
        }

        if (dial == 0) {
            count++;
            if (!countDuring) {
                countPass++; // part 2 includes final stop too
            }
        }
    }

    private void reset() {
        dial = 50;
        count = 0;
        countPass = 0;
    }
}