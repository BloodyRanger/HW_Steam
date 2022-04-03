package Steam2;

import java.util.*;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));
        }

        long countMinor = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("В данном списке " + countMinor + " несовершеннолетних.");

        List<Person> conscript = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27 && person.getSex() == Sex.MAN)
                .collect(Collectors.toList());
        System.out.println(conscript);

        List<Person> workingPeople = persons.stream()
                .filter(person -> (person.getAge() >= 18 && person.getAge() < 62 && person.getSex() == Sex.MAN) || (person.getAge() >= 18 && person.getAge() < 57 && person.getSex() == Sex.WOMAN))
                .filter(person -> person.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .collect(Collectors.toList());
        System.out.println(workingPeople);
    }
}
