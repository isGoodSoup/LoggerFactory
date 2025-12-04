package com.loggerfactory.main;

import com.loggerfactory.utils.Utils;

public class Panel {
	private Utils utils = new Utils();
	private int counter = 0;
	private int maxCounter = 1000;
	
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

	public int getMaxCounter() {
		return maxCounter;
	}

	public void setMaxCounter(int maxCounter) {
		this.maxCounter = maxCounter;
	}
}
