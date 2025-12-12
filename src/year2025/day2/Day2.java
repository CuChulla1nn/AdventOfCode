package year2025.day2;

import year2025.utils.Range;

import java.util.List;

public class Day2 {

    public long partOne(List<Range> rangeList){

        long count = 0;

        for(Range range: rangeList){
            long start = range.start();
            long end = range.end();
            for (long i = start; i <= end; i++) {
                String value = String.valueOf(i);
                if(value.length() % 2 != 0){
                    continue;
                }
                int mid = value.length() / 2;
                long first = Long.parseLong(value.substring(0, mid));
                long second = Long.parseLong(value.substring(mid));

                if(first == second){
                    count += i;
                }
            }
        }

        return count;
    }
}
