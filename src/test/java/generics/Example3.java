package generics;

import java.util.Arrays;
import java.util.List;

public class Example3 {

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static void main(String[] args) {
        // Ковариантность
        String[] arr = {"a", "b", "c"};
//        Object[] objectArr = arr;
//        objectArr[0] = 1;

        // Инвариантность
        List<String> list = Arrays.asList("a", "b", "c");
//        List<Object> objectList = list;
//        objectList.set(0, 1);

        // checkedCollections
    }
}
