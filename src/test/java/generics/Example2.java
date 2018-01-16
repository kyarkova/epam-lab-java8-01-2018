package generics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example2 {

    @SuppressWarnings("unchecked, UnusedAssignment")
    public static void main(String[] args) {
        Holder<Integer> intHolder = new Holder<>(42);

        Holder objectHolder = new Holder(0);

        objectHolder = intHolder;
        objectHolder.setValue(100.5);
        System.out.println(intHolder.getValue());

        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        Integer max = Collections.max(values);
        System.out.println(max);
    }
}

@Data
@AllArgsConstructor
class Holder<T extends Number & Comparable<T>> {
    private T value;
}