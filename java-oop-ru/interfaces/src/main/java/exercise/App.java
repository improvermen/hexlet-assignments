package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        if (homes == null) {
            throw new IllegalArgumentException("Homes list cannot be null");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Number of elements cannot be negative");
        }

        Collections.sort(homes, Comparator.comparingDouble(Home::getArea));

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n && i < homes.size(); i++) {
            result.add(homes.get(i).toString());
        }

        return result;
    }
}
// END
