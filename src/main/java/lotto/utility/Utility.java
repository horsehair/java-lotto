package lotto.utility;

import java.util.List;
import java.util.stream.Collectors;

public class Utility {
    public static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> numbersSorted = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return numbersSorted;
    }
}
