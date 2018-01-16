package generics;

import java.util.ArrayList;
import java.util.List;

public class Example7 {

    public static void main(String[] args) {
        List<? extends Number> list1 = new ArrayList<Long>();
        list1.add(null);
        Object number = list1.get(0);

        List<? super Number> list2 = new ArrayList<Object>();
        list2.add(1);
        list2.add(1D);
        list2.add(1f);
        list2.add(1L);
        Number num = 1;
        list2.add(num);

        // Producer
        // Extends

        // Consumer
        // Super

    }
}
