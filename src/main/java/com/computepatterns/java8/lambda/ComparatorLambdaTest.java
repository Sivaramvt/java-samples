package com.computepatterns.java8.lambda;

import java.util.*;

/**
 * Sample of Lamda with Comparator interface.
 */
public class ComparatorLambdaTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Gnana"));
        personList.add(new Person("Khana"));
        personList.add(new Person("Twana"));

        // Using anonymous innner class.
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        System.out.println(Arrays.toString(personList.toArray()));

        // Using lambda - Concise and clean.
        Collections.sort(personList, (o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
        System.out.println(Arrays.toString(personList.toArray()));
    }

}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
