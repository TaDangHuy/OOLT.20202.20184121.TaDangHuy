import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTest {

	public static void main(String[] args) {
		
	//Test for Mydate() 
	MyDate Curdate = new MyDate();
	Curdate.printInformat();
	
	//Test for printC()
	MyDate c = new MyDate();
	c.printC();
	
	//Test for MyDate(String,String,String)
	MyDate date = new MyDate("twenty first","two","twenty twenty");
    date.print();
	
    //Create the Formater to use
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
	
	//Create some date to test 
	LocalDate date1 = LocalDate.parse("February 5 2017", formatter);
	LocalDate date2 = LocalDate.parse("February 6 2020", formatter);
	LocalDate date3 = LocalDate.parse("January 31 2020", formatter);
	LocalDate[] arrofDates = {date1,date2,date3};
 		
	DateUtils.CompareTwoDates(date1,date3);
	DateUtils.SortDates(arrofDates);
		
	}

}
