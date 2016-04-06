package com.computepatterns.java8.lambda.obe;

import java.util.*;

/**
 * Sample of Lamda with Comparator interface.
 */
public class ComparatorLambdaTest {

    public static void main(String[] args) {
        List<PersonSample> personSampleList = new ArrayList<>();
        personSampleList.add(new PersonSample("Gnana"));
        personSampleList.add(new PersonSample("Khana"));
        personSampleList.add(new PersonSample("Twana"));

        // Using anonymous innner class.
        Collections.sort(personSampleList, new Comparator<PersonSample>() {
            @Override
            public int compare(PersonSample o1, PersonSample o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        System.out.println(Arrays.toString(personSampleList.toArray()));

        // Using lambda - Concise and clean.
        Collections.sort(personSampleList, (o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
        System.out.println(Arrays.toString(personSampleList.toArray()));
    }

}

class PersonSample {
    private String name;

    public PersonSample(String name) {
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
