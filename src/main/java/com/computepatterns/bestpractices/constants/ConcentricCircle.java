package com.computepatterns.bestpractices.constants;

public class ConcentricCircle implements ICircle{
	private int centerX;
	private int centerY;
	private int numberOfCircles;
	private int diffInRadius;
	
	public ConcentricCircle(int numberOfCircles, double diffInRadius, int centerX, int centerY){
		this.centerX = centerX;
		this.centerY = centerY;
	}

	public double computeArea() {
		// Put not implemented exception.
		return 0;
	}

}
