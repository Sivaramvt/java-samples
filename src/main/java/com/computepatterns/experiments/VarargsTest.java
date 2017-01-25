package com.computepatterns.experiments;

/**
 * Trying out variable arguments.
 */
public class VarargsTest {

    public static void main(String[] args) {
        new VarargsTest().testVariableArgs("Five", "Ten", "Twenty");
    }

    public void testVariableArgs(String... args){
        args[0] = "one";
        for(String arg:args){
            System.out.println(arg);
        }
    }
}
