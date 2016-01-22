package com.computepatterns.bestpractices.constants;

/**
 * Scenario: A constant which is used across the implementations of a type.
 */
public interface ICircle {
	/**
	 * Constant which is immutable, used within the implementation hierarchy.
	 * Take note of the naming convention (used all upper case). In interface,
	 * all variables are static finals.
	 */
	double PI = 3.14159;
	
	/**
	 * Compute area of the circle.
	 * @return
	 */
	double computeArea();

}
