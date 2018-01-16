package generics;

import java.util.ArrayList;
import java.util.List;

public class Example6 {

    public static void main(String[] args) {
//        List<String>[] list1 = new ArrayList<String>[10];
        List<?>[] list2 = new ArrayList<?>[10];


    }

    @SafeVarargs
    private static void varargsMethod(List<String>...lists) {

    }
}
