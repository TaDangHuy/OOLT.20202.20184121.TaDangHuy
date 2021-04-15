
public class Aims {

	public static void main(String[] args) {
		// Initial Order 1
		Order Order1 = new Order(new MyDate());
		//Create a new dvd object and set the fields
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion king");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		//add the dvd to the order
		Order1.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		Order1.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		//add the dvd to the order
		Order1.addDigitalVideoDisc(dvd3);
		//test method removeDigitalVideoDisc
		Order1.removeDigitalVideoDisc(dvd3);

		Order1.listOfOrder();
		
		// Initial Order 2
		Order Order2 = new Order(new MyDate(2,4,2021));
		//Create a new dvd object and set the fields
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avenger 3");
		dvd4.setCategory("Animation");
		dvd4.setCost(19.95f);
		dvd4.setDirector("Roger Allers");
		dvd4.setLength(87);
		//add the dvd to the order
		Order2.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Naruto");
		dvd5.setCategory("Science Fiction");
		dvd5.setCost(24.95f);
		dvd5.setDirector("George Lucas");
		dvd5.setLength(124);
		Order2.addDigitalVideoDisc(dvd5);
		
		Order2.listOfOrder();
		
		//Initial Order 3
		Order Order3 = new Order(new MyDate(3,4,2021));
		//Create a new dvd object and set the fields
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Thor");
		dvd6.setCategory("Animation");
		dvd6.setCost(19.95f);
		dvd6.setDirector("Roger Allers");
		dvd6.setLength(87);
		//add the dvd to the order
		Order3.addDigitalVideoDisc(dvd6);
		
		Order3.listOfOrder();
		
		//Initial Order 4
		Order Order4 = new Order(new MyDate(5,4,2021));
		//Create a new dvd object and set the fields
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Iron Man");
		dvd7.setCategory("Science Fiction");
		dvd7.setCost(24.95f);
		dvd7.setDirector("George Lucas");
		dvd7.setLength(124);
		Order4.addDigitalVideoDisc(dvd7);
		
		Order4.listOfOrder();
	}

}
