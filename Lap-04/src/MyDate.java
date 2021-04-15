

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	void accept() {
		System.out.println("Please enter the date(String) :");
		Scanner keyboard = new Scanner(System.in);
		
		String dateInString = keyboard.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
		LocalDate dateTime = LocalDate.parse(dateInString, formatter);
		
		this.day = dateTime.getDayOfMonth();
		
		this.month = dateTime.getMonthValue();
		
		this.year = dateTime.getYear();
		
		keyboard.close();
 	}
	
	void print() {
		System.out.println("The date is: " + 
				this.day + "-" + this.month + "-" +this.year);
	}
	
	public void printInformat(){
		String[] options = {"1.yyyy-MM-dd",
							"2.d/M/yyyy",
							"3.dd-MMM-yyyy",
							"4.MMM d yyyy",
							"5.mm-dd-yyyy"};

		String input = (String)(JOptionPane.showInputDialog(null,
										"Please choose one format:",
										"Print in format",JOptionPane.INFORMATION_MESSAGE,null,options,options[0]));
		LocalDate date = LocalDate.of(this.year, this.month, this.day) ;
	 
		if(input.matches(options[0])) 
		{
			String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) ;
			JOptionPane.showMessageDialog(null, formattedDate ,
						options[0], JOptionPane.INFORMATION_MESSAGE);
		}else if(input.matches(options[1])) 
		{
			String formattedDate = date.format(DateTimeFormatter.ofPattern("d/M/yyyy")) ;
			JOptionPane.showMessageDialog(null, formattedDate ,
						options[1], JOptionPane.INFORMATION_MESSAGE);
		}else if(input.matches(options[2])) 
		{
			String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")) ;
			JOptionPane.showMessageDialog(null, formattedDate ,
						options[2], JOptionPane.INFORMATION_MESSAGE);
		}else if(input.matches(options[3])) 
		{
			String formattedDate = date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) ;
			JOptionPane.showMessageDialog(null, formattedDate ,
						options[3], JOptionPane.INFORMATION_MESSAGE);
		}else if(input.matches(options[4])) 
		{
			String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) ;
			JOptionPane.showMessageDialog(null, formattedDate ,
						options[4], JOptionPane.INFORMATION_MESSAGE);
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy", Locale.ENGLISH);
		LocalDate dateTime = LocalDate.parse(dateInString, formatter);
		
		this.day = dateTime.getDayOfMonth();
		
		this.month = dateTime.getMonthValue();
		
		this.year = dateTime.getYear();
	}
	
	public MyDate(String day, String month, String year) {

		int dayI   = convertStringToInt(day);
		
		int monthI = convertStringToInt(month);
		
		int yearI  = convertYear(year);
		
		
		String dateInString = convertMonth(monthI) + " " +String.valueOf(dayI)+ " " + String.valueOf(yearI);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
		LocalDate dateTime = LocalDate.parse(dateInString, formatter);
		
		this.day = dateTime.getDayOfMonth();
		
		this.month = dateTime.getMonthValue();
		
		this.year = dateTime.getYear();
		
	}
	
	public void printC() {
		LocalDate currentdate = LocalDate.now();
		
		int dayt = currentdate.getDayOfMonth();
		
		int montht = currentdate.getMonthValue();
		
		int yeart = currentdate.getYear();
		
		System.out.println(convertMonth(montht) + " " + convertDay(dayt) + " " + yeart);
	}
	
	private String convertDay(int d) {
		switch(d%10) {
		case 1: return String.valueOf(d)  + "st";
		case 2: return String.valueOf(d)  + "nd";
		case 3: return String.valueOf(d)  + "rd";
		default:
			return String.valueOf(d) + "th";
		}
	}
	
	private int convertYear(String s) {
		String[] arrS = s.split(" ");
		if (arrS.length !=2 ) {
			System.out.println("Strinng for Year is unvalid!");
			System.exit(0);
		}
		if (arrS[1].compareTo("hundred") ==0 ) return convertStringToInt(arrS[0])*100;
		else return ( convertStringToInt(arrS[0])*100 + convertStringToInt(arrS[1]) );
	}
	
	private String convertMonth(int m) {
		switch (m) {
		case 1: return "January";
		case 2: return "February";
		case 3: return "March";
		case 4: return "April";
		case 5: return "May";
		case 6: return "June"; 
		case 7: return "July";
		case 8: return "August";
		case 9: return "September";
		case 10:return "October";
		case 11:return "November";
		case 12:return "December";
		default:
			throw new IllegalArgumentException("Unexpected value for month: " + m);
		}
			
	}
	
	private int convertStringToInt(String input) 
	    { 
	    	 boolean isValidInput = true;
	    	    int result = 0;
	    	    List<String> allowedStrings = Arrays.asList
	    	    (
	    	    "zero","one","two","three","four","five","six","seven",
	    	    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
	    	    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
	    	    "thirty","first","second","third"
	    	    );
	    	 
	    	    if(input != null && input.length()> 0)
	    	    {
	    	    	input = input.replaceAll("th", "");
	    	        input = input.toLowerCase().replaceAll(" and", "");
	    	        String[] splittedParts = input.trim().split("\\s+");

	    	        for(String str : splittedParts)
	    	        {
	    	            if(!allowedStrings.contains(str))
	    	            {
	    	                isValidInput = false;
	    	                System.out.println("Invalid word found : "+str);
	    	                break;
	    	            }
	    	        }
	    	        if(isValidInput)
	    	        {
	    	            for(String str : splittedParts)
	    	            {
	    	                if(str.equalsIgnoreCase("zero")) {
	    	                    result += 0;
	    	                }
	    	                else if(str.equalsIgnoreCase("one")) {
	    	                    result += 1;
	    	                }
	    	                else if(str.equalsIgnoreCase("two")) {
	    	                    result += 2;
	    	                }
	    	                else if(str.equalsIgnoreCase("three")) {
	    	                    result += 3;
	    	                }
	    	                else if(str.equalsIgnoreCase("four")) {
	    	                    result += 4;
	    	                }
	    	                else if(str.equalsIgnoreCase("five")) {
	    	                    result += 5;
	    	                }
	    	                else if(str.equalsIgnoreCase("six")) {
	    	                    result += 6;
	    	                }
	    	                else if(str.equalsIgnoreCase("seven")) {
	    	                    result += 7;
	    	                }
	    	                else if(str.equalsIgnoreCase("eight")) {
	    	                    result += 8;
	    	                }
	    	                else if(str.equalsIgnoreCase("nine")) {
	    	                    result += 9;
	    	                }
	    	                else if(str.equalsIgnoreCase("ten")) {
	    	                    result += 10;
	    	                }
	    	                else if(str.equalsIgnoreCase("eleven")) {
	    	                    result += 11;
	    	                }
	    	                else if(str.equalsIgnoreCase("twelve")) {
	    	                    result += 12;
	    	                }
	    	                else if(str.equalsIgnoreCase("thirteen")) {
	    	                    result += 13;
	    	                }
	    	                else if(str.equalsIgnoreCase("fourteen")) {
	    	                    result += 14;
	    	                }
	    	                else if(str.equalsIgnoreCase("fifteen")) {
	    	                    result += 15;
	    	                }
	    	                else if(str.equalsIgnoreCase("sixteen")) {
	    	                    result += 16;
	    	                }
	    	                else if(str.equalsIgnoreCase("seventeen")) {
	    	                    result += 17;
	    	                }
	    	                else if(str.equalsIgnoreCase("eighteen")) {
	    	                    result += 18;
	    	                }
	    	                else if(str.equalsIgnoreCase("nineteen")) {
	    	                    result += 19;
	    	                }
	    	                else if(str.equalsIgnoreCase("twenty")) {
	    	                    result += 20;
	    	                }
	    	                else if(str.equalsIgnoreCase("thirty")) {
	    	                    result += 30;
	    	                }
	    	                if(str.equalsIgnoreCase("first")) {
	    	                    result += 1;
	    	                }
	    	                if(str.equalsIgnoreCase("second")) {
	    	                    result += 2;
	    	                }
	    	                if(str.equalsIgnoreCase("third")) {
	    	                    result += 3;
	    	                }
	    	            }
	    	        }
	    	    }
				return result;
	    } 

}
	
	