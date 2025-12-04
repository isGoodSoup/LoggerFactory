package com.loggerfactory.main;

import com.loggerfactory.interfaces.Initiable;

public class AppLogger implements Initiable {
	private final Panel panel = new Panel();
	
	public AppLogger() {}
	
	public AppLogger(int lines) {
		super();
		panel.setMaxCounter(lines);
	}

	@Override
	public void init() {
		panel.getUtils().clearLogFile();
		for(int i = 0; i < panel.getMaxCounter(); i++) {
			panel.getUtils().genLog();
			panel.addCounter();
		}
		System.out.println("Logs completed. Completed: " + panel.getCounter());
	}
}
