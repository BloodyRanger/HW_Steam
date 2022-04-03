package Steam1;
import java.util.*;

public class StreamMain {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        System.out.println("Исходный список:");
        intList.stream()
                .forEach(x -> System.out.print(x + " "));
        System.out.println("\nРезультат:");

        intList.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted()
                .forEach(x -> System.out.print(x + " "));
    }
}