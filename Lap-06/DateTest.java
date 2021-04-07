package hust.soict.hedspi.test.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;


public class DateTest {

	public static void main(String[] args) {
		
	MyDate date = new MyDate("nineteenth","February","2020");
	//MyDate date = new MyDate();
	//date.accept();
	
	date.printInformat();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
		
		LocalDate date1 = LocalDate.parse("February 5 2017", formatter);
		LocalDate date2 = LocalDate.parse("February 6 2020", formatter);
		LocalDate date3 = LocalDate.parse("January 31 2020", formatter);
		LocalDate[] arrofDates = {date1,date2,date3};
 		
		DateUtils.CompareTwoDates(date1,date3);
		DateUtils.SortDates(arrofDates);
		
	}

}
