package com.computepatterns.bestpractices.constants;

/***
 * Scenario: A constant which is used within the scope of a class.
 *
 */
public class Circle {
	/**
	 * Constant which is immutable, accessible only within the inheritance
	 * hierarchy. Take note of the naming convention (used all upper case).
	 */
	protected static final double PI = 3.14159;
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public double computeArea() {
		return PI * radius * radius;
	}
}
