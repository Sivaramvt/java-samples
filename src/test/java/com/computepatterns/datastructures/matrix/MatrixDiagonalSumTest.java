package com.computepatterns.datastructures.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for the matrix problem.
 */
public class MatrixDiagonalSumTest {
    @Test
    public void test_computeDiagonalSum() throws Exception {
        int input[][] = new int[][]{{11,2,4},{4,5,6},{10,8,-12}};
        int result = MatrixDiagonalSum.computeDiagonalSum(input,3);
        assertEquals(15, result);
    }

}