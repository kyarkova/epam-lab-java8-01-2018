package lambda.part1.example;

import lambda.data.Person;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings({"unused", "ComparatorCombinators"})
public class Example9 {

    private static class ComparatorPersonsByLastName implements Comparator<Person>, Serializable {

        @Override
        public int compare(Person left, Person right) {
            return left.getLastName().compareTo(right.getLastName());
        }
    }

    @Test
    public void serializeTree() {
        Set<Person> treeSet = new TreeSet<>(
                (Comparator<Person> & Serializable)(left, right) -> Integer.compare(left.getAge(), right.getAge()));
//        Set<Person> treeSet = new TreeSet<>(new ComparatorPersonsByLastName());
        treeSet.add(new Person("Иван", "Мельников", 33));
        treeSet.add(new Person("Алексей", "Игнатенко", 1));
        treeSet.add(new Person("Сергей", "Лопатин", 3));

        System.out.println(treeSet);

        // TODO сериализовать дерево в массив байт
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(treeSet);

            byte[] bytes = outputStream.toByteArray();
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
