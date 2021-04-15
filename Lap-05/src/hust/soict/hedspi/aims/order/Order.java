package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Order {

	public static final int MAX_NUMBERS_ORDERS = 10;
	
	private DigitalVideoDisc itemsOrder[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
	
	private int qtyOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		// TODO Auto-generated method stub
		if (qtyOrdered == 10) System.out.println("The order is almost full!"); 
		else {
			itemsOrder[qtyOrdered++] = disc;
			System.out.println("The order has title " + disc.getTitle() + " has been added!");
		}
	}
	
	public void removeDigitalVideoDisc(String title){
		int i=0;
		int index = 0;
		int count = 0;
		for(DigitalVideoDisc x: itemsOrder) {
			i++;
			if(x.getTitle() == title) 
			{
				index = i;
				count++;
				break;
			}
		}
		if(count!=0) {
			for(i = index ; i < qtyOrdered ; i++) {
				itemsOrder[i]= itemsOrder[i+1];
			}
		
			qtyOrdered--;
			System.out.println("Remove " + title +" succesfull!");
		}else {
			System.out.println("Don't have Disc named " + title);
		}
	}
	public float totalCost() {
		float total = 0;
		for(int j =0; j <qtyOrdered ; j++) {
			total += itemsOrder[j].getCost();
		}
		return total;
		}
	public DigitalVideoDisc getLuckyItem() {
		int rm = (int)(Math.random() * (qtyOrdered) ) ;// random from (0 to qtyOrderd-1)
		itemsOrder[rm].setCost(0);
		return itemsOrder[rm];
	}
}

