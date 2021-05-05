	package hust.soict.hedspi.aims;
 
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;


public class Aims {
		//additional method
		public static int EnterID(Order order,Scanner scanner) {
			int iD;
			do {
				System.out.println("Enter id:");
				iD = scanner.nextInt();
				if(order.checkifIdExist(iD))
					System.out.println("This id is existed.Please try again!");
				else return iD;
			}while(true);
		}
		
		public static void showMenu() {
			System.out.println("Order Management Application: ");
			System.out.println("--------------------------------");
			System.out.println("1. Create new order");
			System.out.println("2. Add item to the order");
			System.out.println("3. Delete item by id");
			System.out.println("4. Display the items list of order");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
	}
		public static void chooseItemtoAdd() {
			System.out.println("Please choose the type of item you want to add!");
			System.out.println("---------------------------------");
			System.out.println("1.CD");
			System.out.println("2.DVD");
			System.out.println("3.Book");
			System.out.println("---------------------------------");
		};
		
		public static void addCD(Order order,Scanner scanner) {
		 	int iD = EnterID(order, scanner);
			System.out.println("Enter title(CD):");
			String title = scanner.next();
			System.out.println("Enter category(CD):");
			String category = scanner.next();
			System.out.println("Enter cost(CD):");
			float cost = scanner.nextFloat();
			System.out.println("Enter director(CD):");
			String director = scanner.next();
			CompactDisc CD = new CompactDisc(iD, title, category, cost, director);
			boolean k =true;
			System.out.println("Enter some track:(Press X on title to end)");
			  while(k) {
			     System.out.println("Enter title of track:");
			     String titleT = scanner.next();
			     if(titleT.compareToIgnoreCase("X") == 0) 
			    	 {
			    	 	k = false;
			    	 	break;
			    	 }
			     System.out.println("Enter length of track(int):");
			     int length = scanner.nextInt();
			     Track track = new Track(titleT, length);
			     CD.addTrack(track);
			}
			
		    order.addMedia(CD);
		    
		    System.out.println("Do you want to play it?(Y/N)");
		    char c = scanner.next().charAt(0);
		    	if(c=='Y') CD.play();
		}
		
		public static void addDVD(Order order, Scanner scanner) {
			int id = EnterID(order, scanner);
			System.out.println("Enter title(DVD):");
			String title = scanner.next();
			System.out.println("Enter category(DVD):");
			String category = scanner.next();
			System.out.println("Enter cost(DVD):");
			float cost = scanner.nextFloat();
			System.out.println("Enter length(DVD):");
			float length = scanner.nextFloat();
			System.out.println("Enter director(DVD):");
			String director = scanner.next();
			DigitalVideoDisc DVD = new DigitalVideoDisc(id, title, category, cost, length, director);
			
			order.addMedia(DVD);
			
			System.out.println("Do you want to play it?(Y/N)");
		    char c = scanner.next().charAt(0);
		    	if(c=='Y') DVD.play();
		}
		
		public static void addBook(Order anOrder,Scanner scanner) {
			int id = EnterID(anOrder, scanner);
			System.out.println("Enter title(Book):");
			String title = scanner.next();
			System.out.println("Enter category(Book):");
			String category = scanner.next();
			System.out.println("Enter cost(Book):");
			float cost = scanner.nextFloat();
			
			Book book = new Book(id, title, category,cost);
			boolean k= true;
			System.out.println("Enter some authors:(press X to end!)");
			while(k) {
			     System.out.println("Enter authorName:");
			     String authorName = scanner.next();
			     if(authorName.compareToIgnoreCase("X") == 0) 
			    	 {
			    	 	k = false;
			    	 	break;
			    	 }
			     book.addAuthor(authorName);
			}
			
		    anOrder.addMedia(book);
		}

		//main
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Order anOrder = new Order();
			
			while(true) {
				showMenu();
				int choose = sc.nextInt();
				switch (choose){
					case 0:
						sc.close();
						System.out.println("Exited!! Bye.");
						break;
					case 1: 
						System.out.println("Create new order successfull!");
						break;
					case 2:
						chooseItemtoAdd();
						int key = sc.nextInt();
						switch (key) {
							case 1:
								addCD(anOrder,sc);
								break;
							case 2:
								addDVD(anOrder,sc);
								break;
							case 3:
								addBook(anOrder,sc);
								break;
							default:
								throw new IllegalArgumentException("Unexpected value: " + key );
							}
						break;
					case 3:
	                    System.out.print("Enter id to remove:");
	                    int id = sc.nextInt();
	                    anOrder.removeMediaById(id);
	                    break;
				    
					case 4:
	                    anOrder.ListOfOrder();
	                    break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + choose);
				}
			}	
   }	
}