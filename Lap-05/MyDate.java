

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
			this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if((month>0)&&(month<13))
			this.month = month;
		else System.out.println("Month is invalid!");
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
		
	void accept() {
		System.out.println("Please enter the dateString(dd/mm/yy) :");
		Scanner keyboard = new Scanner(System.in);
		
		String dateInString = keyboard.nextLine();
	
		String[] arrOfstr = dateInString.split("/");
		
		this.day = Integer.valueOf(arrOfstr[0]);
		
		this.month = Integer.valueOf(arrOfstr[1]);
		
		this.year = Integer.valueOf(arrOfstr[2]);
		
		keyboard.close();
 	}
	
	public void print() {
		try {
			LocalDate date = LocalDate.of(this.year, this.month, this.day) ;
			String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) ;
			System.out.println(formattedDate);
		}catch (Exception e) {
			System.out.println("-->eror:" + e.getMessage());
		}
	}

	public MyDate(){
		LocalDate currentdate = LocalDate.now();
		
		this.day = currentdate.getDayOfMonth();
		
		this.month = currentdate.getMonthValue();
		
		this.year = currentdate.getYear();
	}

	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate(String dateInString) {
		
		dateInString = dateInString.replaceAll("[0-9](?:st|nd|rd|th)", "");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
		LocalDate dateTime = LocalDate.parse(dateInString, formatter);
		
		this.day = dateTime.getDayOfMonth();
		
		this.month = dateTime.getMonthValue();
		
		this.year = dateTime.getYear();
	}
}
