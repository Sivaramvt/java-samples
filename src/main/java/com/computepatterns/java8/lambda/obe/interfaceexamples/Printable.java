package com.computepatterns.java8.lambda.obe.interfaceexamples;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 8 introduces default and static methods for interface. Default methods are automatically inherited by the
 * implementing classes. The difference with abstract method is that default methods doesn't force implementations to
 * override it. Static method could easily serve as utilities.
 */
public interface Printable {

    /**
     * Default method. New in Java 8.
     */
    default void printState() {
        System.out.println("Msg from default method");
    }

    /**
     * Static method in interface. New in Java 8.
     *
     * @param printableList
     */
    static void printStates(List<Printable> printableList) {
        printableList.forEach(printable -> printable.printState());
    }
}

/**
 * Sample implementation
 */
class PrintableImpl implements Printable {
    public static void main(String[] args) {
        List<Printable> printables = new ArrayList<Printable>();
        printables.add(new PrintableImpl());
        Printable.printStates(printables);
    }
}
