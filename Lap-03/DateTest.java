package ex8;

public class DateTest {

	public static void main(String[] args) {
		
	MyDate curDate = new MyDate();
	System.out.printf("Today is:");
	curDate.print();
	
	MyDate setDateInt = new MyDate(15,8,2000);
	System.out.printf("The date(int) is:");
	setDateInt.print();
	
	MyDate setDateString = new MyDate("August 15th 2000");
	System.out.printf("The date(String) is:");
	setDateString.print();
		
	MyDate date = new MyDate();
	date.accept();
	date.print();
	}

}	
