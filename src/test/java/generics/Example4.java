package generics;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Example4 {

    @SuppressWarnings("JavaReflectionMemberAccess")
    public static void main(String[] args) throws NoSuchMethodException {
        // getMethodsUsingReflection

        Arrays.stream(Person.class.getDeclaredMethods()).forEach(System.out::println);

        Method compareTo = Person.class.getDeclaredMethod("compareTo", Object.class);
        System.out.println(compareTo);
    }

    @Data
    private static class Person implements Comparable<Person> {

        private final String name;
        private final String surname;
        private final int age;

        @Override
        public int compareTo(Person other) {
            return Integer.compare(age, other.age);
        }
    }
}
