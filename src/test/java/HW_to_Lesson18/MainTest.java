package HW_to_Lesson18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MainTest {

    @Test
    void should_calculate_average() {
        List<Integer> list = new ArrayList<>();
        int size = 10;

        double expectedAverage = 0;
        for (int i = 0; i < size; i++) {
            list.add(i);
            expectedAverage += i;
        }
        expectedAverage /= size;

        double actualAverage = Main.getAverage(list);
        Assertions.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    void should_change_collection() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("Yellow");

        List<String> listExpected = new ArrayList<>();
        listExpected.add("APPLE");
        listExpected.add("YELLOW");

        list = Main.changeCollection(list);

        Assertions.assertEquals(listExpected, list);
    }

    @Test
    void should_filter_collection() {
        List<String> listToFilter = new ArrayList<>();
        listToFilter.add("size");
        listToFilter.add("sIze");
        listToFilter.add("one");
        listToFilter.add("OnE");
        listToFilter.add("stream");
        listToFilter.add("Stream");

        List<String> listExpected = new ArrayList<>();
        listExpected.add("size");

        listToFilter = Main.filterCollection(listToFilter);

        Assertions.assertEquals(listExpected, listToFilter);
    }
}