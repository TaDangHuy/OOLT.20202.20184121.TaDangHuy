package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
	
	public static void main(String[] args) {
		Book book = new Book(4, "Book", "Animation", 20f);
		book.setContent("Suppose, you are trying to make an uneven and penculiar-shaped container for selling. \r\n"
				+ "From top view, the container has a rectangular shape with an area of n*m . This rectangular container is formed by bonding 1*1*aij square shape solid bars,with vertices of ij. \r\n"
				+ "The container's package needs to display the volume of the container. The container is suck straight into the of water  and lifted it up afterward. Now it is needed to calculate the amount of water stored in the container.");
		
		System.out.println(book.toString());
	}

}
