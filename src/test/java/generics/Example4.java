package generics;

import lombok.Data;

public class Example4 {

    public static void main(String[] args) {
        // getMethods
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
