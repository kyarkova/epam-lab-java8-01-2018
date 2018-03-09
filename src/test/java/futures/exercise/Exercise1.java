package futures.exercise;

import lambda.data.Employee;
import lambda.data.Person;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;
import java.util.Collections;
import java.util.concurrent.*;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unused", "UnnecessaryLocalVariable", "ConstantConditions", "UnusedAssignment"})
public class Exercise1 {

    @Test
    public void vanillaFutureExample() throws Exception {
        test(() -> {
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            Future<Employee> future = executorService.submit(() -> getEmployee(getPerson("Дмитрий", "Сашков")));
            Employee result = future.get();
            return result;
        });
    }

    @Test
    public void completableFutureExample() throws Exception {
        test(() -> {
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            CompletableFuture<Employee> cf = getEmployeeInFuture(getPerson("Дмитрий", "Сашков"));
            Employee result = cf.get();
            return result;
        });
    }

    private static void test(Callable<Employee> task) throws Exception {
        ByteArrayInputStream input = new ByteArrayInputStream(("Дмитрий Сашков" + lineSeparator()).getBytes());

        Employee actual = performWithCustomSystemIn(task, input);

        assertEquals(new Employee(new Person("Дмитрий", "Сашков", 25), Collections.emptyList()), actual);
    }

    private static <T> T performWithCustomSystemIn(Callable<T> task, InputStream input) throws Exception {
        InputStream original = System.in;
        try {
            System.setIn(input);
            return task.call();
        } finally {
            System.setIn(original);
        }
    }

    @SneakyThrows
    private static String getPersonNameAndSurnameFromUser() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }

    @SneakyThrows
    private static Person getPerson(String name, String surname) {
        Person person;
        // For example load from another service
        TimeUnit.SECONDS.sleep(2);
        return person = new Person(name, surname, 25);
    }

    // TODO использовать в vanillaFutureExample
    @SneakyThrows
    private static Employee getEmployee(Person person) {
        Employee employee;
        TimeUnit.SECONDS.sleep(2);
        // For example load from another service
        return employee = new Employee(person, Collections.emptyList());
    }

    // TODO использовать в completableFutureExample
    @SneakyThrows
    private static CompletableFuture<Employee> getEmployeeInFuture(Person person) throws InterruptedException {
        Employee employee;
        TimeUnit.SECONDS.sleep(2);
        // For example load from another service
        return CompletableFuture.completedFuture(getEmployee(person));
    }
}
