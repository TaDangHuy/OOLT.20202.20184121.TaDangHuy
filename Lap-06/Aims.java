package hust.soict.hedspi.aims;
 
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	
		public static void showMenu() {
			System.out.println("Order Management Application: ");
			System.out.println("--------------------------------");
			System.out.println("1. Create new order");
			System.out.println("2. Add item to the order");
			System.out.println("3. Delete item by id");
			System.out.println("4. Display the items list of order");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
	}

		public static void main(String[] args) {
			Order anOrder = new Order();
			Scanner sc = new Scanner(System.in);
			while(true) {
				showMenu();
				int choose = sc.nextInt();
				switch (choose){
					case 1: 
						System.out.println("Create new order successfull!");
						break;
					case 2:
						System.out.print("Title: ");
	                    String title = sc.next();
	                    System.out.print("Id: ");
	                    String id = sc.next();
	           
	                    System.out.print("Category: ");
	                    String category = sc.next();
	             
	                    System.out.print("Cost: ");
	                    float cost = sc.nextFloat();
	   
	                    Media item = new Media(id,title,category,cost);
	                    
	                    anOrder.addMedia(item);
	                    System.out.println("Add successfull!!");
	                    break;
	                    
					case 3:
	                    System.out.print("Enter id:");
	                    id = sc.next();
	                    anOrder.removeMediaById(id);
	                    break;
				    
					case 4:
	                    anOrder.ListOfOrder();
	                    break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + choose);
				}
				//sc.close();
			}	
   }	
}