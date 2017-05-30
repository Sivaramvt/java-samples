package com.computepatterns.experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Fancy sort.
 * Evaluate the expression and sort the input based on the expression's result.
 * If 2 expression's result match, follow natural sorting of the expression string.
 */
public class FancySort {
    /*
     * POJO containing expression and its results.
     */
    static class ExpressionEntry {
        private Integer result;
        private String expn;

        public ExpressionEntry(int result, String expn) {
            this.result = result;
            this.expn = expn;
        }
    }

    static void fancySort(String[] exps) {
        // Sort the input to deal with secondary sorting condition
        Arrays.sort(exps);

        // Evaluate expression one by one
        List<ExpressionEntry> expressionEntryList = new ArrayList<>();
        for (String exp : exps) {
            String[] tokens = exp.split(",");
            // Evaluate and add result to the list
            try {
                int result = evaluate(tokens[0], Arrays.copyOfRange(tokens, 1, tokens.length));
                expressionEntryList.add(new ExpressionEntry(result, exp));
            } catch (NumberFormatException e) {
                // Ignore the expression in case of invalid expressions
            }
        }

        // Sort the list based on the result - primary sorting criteria
        expressionEntryList.sort((e1, e2) -> e1.result.compareTo(e2.result));

        // Print the result
        for (ExpressionEntry entry : expressionEntryList) {
            System.out.println(entry.expn);
        }
    }


    private static int evaluate(String operator, String[] operands) throws NumberFormatException {
        switch (operator) {
            case "ADD":
                return Arrays.stream(operands).mapToInt(i -> Integer.parseInt(i)).sum();
            case "SUBTRACT":
                int first = Integer.parseInt(operands[0]);
                return first + Arrays.stream(Arrays.copyOfRange(operands, 1, operands.length))
                        .mapToInt(i -> {
                            int temp = Integer.parseInt(i);
                            return temp * -1;
                        }).sum();
            case "MULTIPLY":
                return Arrays.stream(operands).mapToInt(i -> Integer.parseInt(i)).reduce(1, (x, y) -> x * y);
            case "DIVIDE":
                int result = Integer.parseInt(operands[0]);
                for (String s : Arrays.copyOfRange(operands, 1, operands.length)) {
                    result /= Integer.parseInt(s);
                }
                return result;
            case "MIN":
                return Arrays.stream(operands).mapToInt(Integer::parseInt).min().getAsInt();
            case "MAX":
                return Arrays.stream(operands).mapToInt(Integer::parseInt).max().getAsInt();
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"ADD,1,2,3", "SUBTRACT,1,2,3", "MULTIPLY,1,2,3", "DIVIDE,100,25,2", "MIN,10,3,4", "MAX, 5, 3, 20"};
        fancySort(input);
    }
}
