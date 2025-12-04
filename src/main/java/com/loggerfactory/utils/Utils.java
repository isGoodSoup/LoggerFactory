package com.loggerfactory.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

/**
 * Utility class for generating log entries with random data.
 * Generates log entries with various fields such as date, log level,
 * Java class, name, age, department, salary, UUID, boolean value,
 * IP address, and date.
 * @version 1.0
 */
public class Utils {
	private final File LOG_FILE = new File(".\\app.log");
	private FileWriter fw;
	private BufferedWriter bw;
	private static Random r = new Random();
	
	public Utils() {
		try {
			this.fw = new FileWriter(LOG_FILE, true);
			this.bw = new BufferedWriter(fw);
		} catch (IOException e) {
			printException(e);
		}
	}
	
	private String genLocalDate() {
	    int year = r.nextInt(1990, 2024);
	    int month = r.nextInt(1, 13);
	    int day = r.nextInt(1, 29);

	    int hour = r.nextInt(0, 24);
	    int minute = r.nextInt(0, 60);
	    int second = r.nextInt(0, 60);

	    return String.format("%04d-%02d-%02d %02d:%02d:%02d",
	            year, month, day, hour, minute, second);
	}

	private String genLogLevel() {
		String[] levels = {"INFO ", "DEBUG", "WARN ", "ERROR", "FATAL"};
		return levels[r.nextInt(levels.length)];
	}
	
	private String genJavaClass() {
		String[] classes = { "java.lang.String", "java.lang.Integer", "java.util.List", "java.util.Map", 
				"java.io.File", "java.io.InputStream", "java.net.URL", "java.util.Date" };
		return classes[r.nextInt(classes.length)];
	}
	
	private String genName() {
		String[] firstNames = {
				"James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael", "Linda",
				"William", "Elizabeth", "David", "Barbara", "Richard", "Susan", "Joseph", "Jessica",
				"Thomas", "Sarah", "Charles", "Karen", "Christopher", "Nancy", "Daniel", "Lisa",
				"Matthew", "Betty", "Anthony", "Margaret", "Mark", "Sandra", "Donald", "Ashley",
				"Steven", "Kimberly", "Paul", "Emily", "Andrew", "Donna", "Joshua", "Michelle",
				"Kenneth", "Dorothy", "Kevin", "Carol", "Brian", "Amanda", "George", "Melissa",
				"Edward", "Deborah", "Ronald", "Stephanie", "Timothy", "Rebecca", "Jason",
				"Sharon", "Jeffrey", "Laura", "Ryan", "Cynthia", "Jacob", "Kathleen",
				"Gary", "Amy", "Nicholas", "Shirley", "Eric", "Angela", "Jonathan",
				"Helen", "Stephen", "Anna", "Larry", "Brenda", "Justin", "Pamela",
				"Scott", "Nicole", "Brandon", "Emma", "Benjamin", "Samantha",
				"Samuel", "Katherine", "Gregory", "Christine", "Frank", "Debra"
		};
		
		String[] lastNames = {
				"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
				"Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
				"Thomas", "Taylor", "Moore", "Jackson", "Martin", "Lee", "Perez", "Thompson",
				"White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson",
				"Walker", "Young", "Allen", "King", "Wright", "Scott", "Torres",
				"Nguyen", "Hill", "Flores", "Green", "Adams", "Nelson", "Baker",
				"Hall", "Rivera", "Campbell", "Mitchell", "Carter", "Roberts",
				"Gomez", "Phillips", "Evans", "Turner", "Diaz", "Parker",
				"Cruz", "Edwards", "Collins", "Reyes", "Stewart", "Morris",
				"Morales", "Murphy", "Cook", "Rogers", "Gutierrez", "Ortiz",
				"Morgan", "Cooper", "Peterson", "Bailey"
		};
		String firstName = firstNames[r.nextInt(firstNames.length)];
		String lastName = lastNames[r.nextInt(lastNames.length)];
	    return firstName + " " + lastName;
	}
	
	private int genAge() {
		return r.nextInt(1, 100);
	}
	
	private String genDepartment() {
		String[] departments = {"HR", "Finance", "IT", "Marketing", "Sales", "Operations", "Customer Service", "R&D"};
		return departments[r.nextInt(departments.length)];
	}
	
	private String genEmail(String name) {
		name.replace(" ", "");
		String[] domains = {
				"gmail.com", "yahoo.com", "outlook.com",
				"hotmail.com", "aol.com", "icloud.com",
				"mail.com", "protonmail.com", "zoho.com",
				"proton.me", "passinbox.com", "yahoo.co.uk"
		};
		String domain = domains[r.nextInt(domains.length)];
		String emailName = name.toLowerCase().replace(" ", ".");
		return emailName + "@" + domain;
	}
	
	private String genPercent() {
		double percent = Math.round((r.nextDouble() * 100) * 100.0) / 100.0;
		return percent + "%";
	}
	
	private double genSalary() {
		return Math.round((30000 + (r.nextDouble() * 120000)) * 100.0) / 100.0;
	}
	
	private String genUUID() {
		StringBuilder sb = new StringBuilder();
		String hexChars = "0123456789abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < 32; i++) {
			sb.append(hexChars.charAt(r.nextInt(hexChars.length())));
		}
		return sb.toString();
	}
	
	private boolean genBoolean() {
		return r.nextBoolean();
	}
	
	private String genIP() {
		String ip = r.nextInt(0, 256) + "." + r.nextInt(0, 256) + "." + r.nextInt(0, 256) + "." + r.nextInt(0, 256);
		return ip;
	}
	
	private String genDate() {
		int year = r.nextInt(1990, 2024);
		int month = r.nextInt(1, 13);
		int day = r.nextInt(1, 29);
		return LocalDate.of(year, month, day).toString();
	}
	
	public void genLog() {
		try (FileWriter fw = new FileWriter(LOG_FILE, true);
		         BufferedWriter bw = new BufferedWriter(fw)) 
		{
			String separator = " | ";
			String name = genName();
			bw.append(
				genLocalDate() + separator + 
				"[main]" + separator +
				genLogLevel() + separator + 
				genJavaClass() + separator +
				name + separator + 
				genAge() + separator + 
				genDepartment() + separator + 
				genEmail(name) + separator +
				genPercent() + separator +
				genSalary() + separator +
				genUUID() + separator +
				genBoolean() + separator +
				genIP() + separator +
				genDate() + "\n");
		} catch (IOException e) {
			printException(e);
		}
	}
	
	public void clearLogFile() {
		try {
			if(LOG_FILE.exists()) {
				fw = new FileWriter(LOG_FILE, false);
				bw = new BufferedWriter(fw);
				bw.write("");
				bw.flush();
			}
		} catch (IOException e) {
			printException(e);
		}
	}
	
	public int getRandomNumber(int min, int max) {
		return r.nextInt(min, max);
	}
	
	public void printException(Exception e) {
		System.err.println(e.getClass().getSimpleName() + " at line " 
						+ e.getStackTrace()[0].getLineNumber() + ": " + e.getMessage());
	}
}
