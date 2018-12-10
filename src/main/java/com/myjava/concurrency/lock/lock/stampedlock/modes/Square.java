package com.myjava.concurrency.lock.lock.stampedlock.modes;

/**
 * @author johnybasha
 *
 */
public class Square {

	private int x;

	private int y;

	public Square() {
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Square [x=" + x + ", y=" + y + "]";
	}

}