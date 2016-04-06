package com.computepatterns.java8.lambda.obe.predicate;

import com.computepatterns.java8.lambda.obe.Gender;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 */
public class RoboCallTest {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();

        Predicate<Person> allMaleGT25 = person -> person.getGender() == Gender.MALE && person.getAge() > 25;
        Predicate<Person> allWomenTean = person -> person.getGender() == Gender.FEMALE && person.getAge() < 20 && person.getAge() > 15;

        new RoboContactLambda().mailContacts(personList, allMaleGT25);
    }
}
