package com.loggerfactory.main;

import com.loggerfactory.utils.Utils;

public class Panel {
	private Utils utils = new Utils();
	private int counter = 0;
	private final int MAX_COUNTER = 50000;
	
	public Utils getUtils() {
		return utils;
	}

	public void setUtils(Utils utils) {
		this.utils = utils;
	}

	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void addCounter() {
		this.counter++;
	}

	public int getMAX_COUNTER() {
		return MAX_COUNTER;
	}
}
