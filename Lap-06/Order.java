package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {

	public static final int MAX_NUMBERS_ORDERS = 10;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	private int nbOrdered = 0;
	
	private MyDate dateOrdered = new MyDate();
	
	public void addMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			System.out.println(media.getTitle() + " is existed! ");
		}
		else {
			itemsOrdered.add(media);
			System.out.println("Add " + media.getTitle() + " successfull!");
		}
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
	
	public void removeMediaById(String id)
    {
        for(int i=0;i<itemsOrdered.size();i++)
        {
            if(itemsOrdered.get(i).getId() == String.valueOf(id)){
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
        System.out.println("List of Items: ");
        for(int i=0;i<itemsOrdered.size();i++)
        {
            System.out.println(i+1+". DVD - "+itemsOrdered.get(i).getTitle()+" - "+itemsOrdered.get(i).getCategory()+" : "+itemsOrdered.get(i).getCost()+" $");
        }
        System.out.println("Total cost: "+ totalCost());
	}
}

