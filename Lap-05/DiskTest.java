

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {
	public static void main(String[] argv) {
		//Test for search()
		DigitalVideoDisc dvd = new DigitalVideoDisc("Harry Poter and friends", "Animal", "TDH", 20, 89f);
		
		System.out.println( dvd.search("Harry friends")); //true
		System.out.println( dvd.search("Stark"));   //false
		System.out.println( dvd.search("Harry with")); //false
		
		//Test for getLuckyItem()
		Order anOrder = new Order();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avenger", "Animal", "TDH", 20, 89f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("EndGame", "Animal", "TDH", 20, 90f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star War", "Animal", "TDH", 20, 91f);
	 	
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println(anOrder.getLuckyItem().getTitle());;
	}
	
}
