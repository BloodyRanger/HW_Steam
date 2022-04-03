package Steam1;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> positiveList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        for (int i : intList) {
            if (i > 0) {
                positiveList.add(i);
            }
        }
        for (int i : positiveList) {
            if (i % 2 == 0) {
                evenList.add(i);
            }
        }

        System.out.println("Исходный список:");
        for (int i : intList) {
            System.out.print(i + " ");
        }
        Collections.sort(evenList);

        System.out.println("\nРезультат:");
        for (int i : evenList) {
            System.out.print(i + " ");
        }
    }
}