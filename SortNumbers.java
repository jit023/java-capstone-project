import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(78);
        numbers.add(23);

        System.out.println("Before Sorting: " + numbers);


        Collections.sort(numbers);

        System.out.println("After Sorting: " + numbers);
    }
}