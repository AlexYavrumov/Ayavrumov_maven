package HW_to_Lesson18;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private Main() {
    }

    public static double getAverage(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<String> changeCollection(List<String> list) {
        return list.stream().
                filter(word -> word.matches("[AEOUIYaeouiy].*"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<String> filterCollection(List<String> list) {
        return list.stream()
                .filter(str -> str.length() == 4 && str.equals(str.toLowerCase()))
                .collect(Collectors.toList());
    }
}