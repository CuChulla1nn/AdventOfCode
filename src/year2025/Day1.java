package year2025;

import utils.ReadFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Day1 {

    int dial;
    int count = 0; //amount the dial stops on 0
    int countPass = 0; //amount the dial stops on 0 and passes 0

    Boolean started = false;

    public void getAnswer() throws IOException {
        Path path = Path.of("src/year2025/files/input1.txt");
        List<String> inputList = ReadFile.readFileList(path);

        for (String input : inputList) {
            char inputDirection = input.charAt(0);
            int number = Integer.parseInt(input.substring(1));

            switch (inputDirection) {
                case 'R' -> setDialPosition(number, true);
                case 'L' -> setDialPosition(number, false);
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
            started = true;
        }
        System.out.println("Count for part one is: " + count);
        System.out.println("Count for part two is: " + (count + countPass));
    }

    private void setDialPosition(int number, boolean add) {
        int start = started ? dial : 50;
        if (add) {
            //clockwise - addition
            //calculate position
            int total = start + number;
            dial = total % 100;
        } else {
            //counterclockwise - subtraction
            //reduce number by modulo to calculate dial position
            dial = (start - (number % 100) + 100) % 100;
        }
        //when stopping on 0 count +1
        if (dial == 0) {
            count++;
        }
    }
}
