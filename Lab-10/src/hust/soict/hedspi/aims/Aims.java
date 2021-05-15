	package hust.soict.hedspi.aims;
 
	import java.util.ArrayList;
import java.util.Scanner;
	import javax.naming.LimitExceededException;
	
	import hust.soict.hedspi.aims.media.Book;
	import hust.soict.hedspi.aims.media.CompactDisc;
	import hust.soict.hedspi.aims.media.DigitalVideoDisc;
	import hust.soict.hedspi.aims.media.Track;
	import hust.soict.hedspi.aims.order.Order;


public class Aims {
		//additional method
	
	    //Method Nhap cho den khi duoc 1 so nguyen duong
	    public static int parseIntInput(Scanner scanner) { 
	    	while(true) {
	    		try {
	    			String input = scanner.next();
					int result = Integer.parseInt(input);
					if( result<0 ) 
						System.out.println("Input cannot negative.Try Again!");
					else return result;
				}catch (NumberFormatException e) {
					System.out.println("Cannot parse input to Integer.Try again!");
				}
	    	}
	    }
	  
	    //Method Nhap cho den khi duoc 1 so thuc duong
	    public static Float parseFloatInput(Scanner scanner) {
	    	while(true) {
	    		try {
	    			String input = scanner.next();
					Float result = Float.parseFloat(input);
					if( result<0 ) 
						System.out.println("Input cannot negative.Try Again!");
					else return result;
				}catch (NumberFormatException e) {
					System.out.println("Cannot parse input to Double.Try again!");
				}
	    	}
	    }
	    
		public static int EnterID(Order order,Scanner scanner) {
				while(true) {
					System.out.println("Enter id:");
					int id = parseIntInput(scanner);
						
					if(order.checkifIdExist(id))
						System.out.println("This id is existed.Please try again!");
					else return id;
				}
		}
		
		public static void showMenu1() {
			System.out.println("Order Management Application: ");
			System.out.println("--------------------------------");
			System.out.println("1. Create new order");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
		}
		
		public static void showMenu2() {
			System.out.println("|  |  |  |  |  |  |  |  |  |  |  |");
			System.out.println("--------------------------------");
			System.out.println("1. Add item to the order");
			System.out.println("2. Delete item by id");
			System.out.println("3. Display the items list of order");
			System.out.println("0. Back");
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
			Float cost = parseFloatInput(scanner);
			
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
			     int length = parseIntInput(scanner);
			     Track track = new Track(titleT, length);
			     CD.addTrack(track);
			}
			
		    order.addMedia(CD);
		    
		    System.out.println("Do you want to play it?(Y/N)");
		    char c = scanner.next().charAt(0);
		    	if(c=='Y') {
		    		try {
		    			CD.play();
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
		    	}
		}
		
		public static void addDVD(Order order, Scanner scanner) { 
			int id = EnterID(order, scanner);
			
			System.out.println("Enter title(DVD):");
			String title = scanner.next();
			
			System.out.println("Enter category(DVD):");
			String category = scanner.next();
			
			System.out.println("Enter cost(DVD):");
			float cost = parseFloatInput(scanner);
			
			System.out.println("Enter length(DVD):");
			float length = parseFloatInput(scanner);
			
			System.out.println("Enter director(DVD):");
			String director = scanner.next();
			
			DigitalVideoDisc DVD = new DigitalVideoDisc(id, title, category, cost, length, director);
			
			order.addMedia(DVD);
			
			System.out.println("Do you want to play it?(Y/N)");
		    char c = scanner.next().charAt(0);
		    	if(c=='Y') {
		    		try {
		    			DVD.play();
					} catch (Exception e) {
						System.err.println(e.getMessage() );
					}
		    	}
		    		
		}
		
		public static void addBook(Order anOrder,Scanner scanner) {
			int id = EnterID(anOrder, scanner);
			
			System.out.println("Enter title(Book):");
			String title = scanner.next();
			
			System.out.println("Enter category(Book):");
			String category = scanner.next();
			
			System.out.println("Enter cost(Book):");
			float cost = parseFloatInput(scanner);
			
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
			ArrayList<Order> orders = new ArrayList<Order>();
			Order anOrder ;
			while(true) {
			
				showMenu1();
			
				try {
					Scanner sc = new Scanner(System.in);
				
					int choose = parseIntInput(sc);
						switch (choose){
							case 0:
								sc.close();
								System.out.println("Exited!! Bye.");
								System.exit(0);
								break;
							case 1: 
								anOrder = new Order();
								System.out.println("Create new order successfull!");
							
								while(true) {
									showMenu2();
									choose = parseIntInput(sc);
									if(choose==0) break;
									
									switch (choose) {
										case 0:
											break;
										case 1:
											chooseItemtoAdd();
											int key = parseIntInput(sc);
										
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
										case 2:
											System.out.print("Enter id to remove:");
											int id = parseIntInput(sc);
											anOrder.removeMediaById(id);
											break;
							    
										case 3:
											anOrder.ListOfOrder();
											break;
										default:
											throw new IllegalArgumentException("Unexpected value: " + choose);
									}
								
								}
								orders.add(anOrder);
								break;
						
							default:
								throw new IllegalArgumentException("Unexpected value: " + choose);
						}
				}catch (LimitExceededException e) {
				//System.out.println(e.getMessage());
					System.out.println("Max number of Orders. Bye!");
					System.exit(0);
				}
		}			
   }	
}