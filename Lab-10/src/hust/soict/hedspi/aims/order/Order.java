package hust.soict.hedspi.aims.order;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order { 

	public static final int MAX_NUMBERS_ORDERS = 2;
	public static final int MAX_NUMBERS_ITEMS  = 3;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	private static int nbOrdered = 0;
	private int nbItems = 0;
	
	private MyDate dateOrdered = new MyDate();
	
	public Order() throws LimitExceededException{
		if(nbOrdered++ > MAX_NUMBERS_ORDERS ) {
			throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
		}else {
			System.out.println("nbOrdered " + nbOrdered);
		}
		
	}
	
	public void addMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			System.out.println(media.getTitle() + " is existed! ");
		}
		else if(nbItems <= MAX_NUMBERS_ITEMS){
			nbItems++;
			itemsOrdered.add(media);
			System.out.println("Add " + media.getTitle() + " successfull!");
		}
		else {
			System.out.println("The items are limited!!");
		}
	}
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " has been removed!!");
		}
		else {
			System.out.println(media.getTitle() + " is not existed!!");
		}
	}
	
	public boolean checkifIdExist(int id) {
		 for(int i=0;i<itemsOrdered.size();i++)
	            if(itemsOrdered.get(i).getId() == id)
	            	return true;
		 return false;
	}
	
	public void removeMediaById(int id)
    {
        for(int i=0;i<itemsOrdered.size();i++)
        {
            if(itemsOrdered.get(i).getId() == id){
                System.out.println(itemsOrdered.get(i).getTitle()+ " has been removed!!");
                itemsOrdered.remove(itemsOrdered.get(i));
                return;
            }
        }
        System.out.println("Media of this id is not existed!!");
    }
	
	public float totalCost() {
		float total = 0 ;
		int len = itemsOrdered.size();
		for(int i = 0; i< len ; i++) {
			total += itemsOrdered.get(i).getCost();
		}
		return total;
	}
	
	public void ListOfOrder() {
		// TODO Auto-generated method stub
		System.out.print("Date: ");
        dateOrdered.print();
       if(itemsOrdered.size()<=0)
    	   System.out.println("No have order");
       else {
    	   System.out.println("List of Items: ");
           System.out.printf("%-10s%-10s%-10s%-10s\n","id","title","category","cost");
           for(int i=0;i<itemsOrdered.size();i++)
           {
               System.out.printf("%-10d%-10s%-10s%-10.4f\n",
               				itemsOrdered.get(i).getId(),itemsOrdered.get(i).getTitle(),itemsOrdered.get(i).getCategory(),itemsOrdered.get(i).getCost());
           }
           System.out.println("Total cost: "+ totalCost());
   		}
    }
	
	public Media getLuckyItem() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the threshold of number:");
		int thresholdNumber = sc.nextInt();
		System.out.println("Enter the threshold of cost:");
		int thresholdcost = sc.nextInt();
		
		sc.close();
		
		float xs = (float) (Math.random());
		
		if (xs < (float)1/itemsOrdered.size() ) 
			if ( (itemsOrdered.size() > thresholdNumber)&&(this.totalCost() > thresholdcost) ) {
				int rm = (int)(Math.random() * (nbItems) ) ;// random from (0 to qtyOrderd-1)
				itemsOrdered.get(rm).setCost(0);
				return itemsOrdered.get(rm);
		}
		
		return null;
		
	}
	
	

}

