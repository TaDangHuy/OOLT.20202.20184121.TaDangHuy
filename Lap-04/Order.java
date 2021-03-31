
public class Order {

	public static final int MAX_NUMBERS_ORDERS = 10;// Max elements of a orders
	
	private DigitalVideoDisc itemsOrder[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
	
	private int qtyOrdered;
	
	public static final int MAX_LIMITTED_ORDERS = 3;// Max numbers of orders

	private static int nbOrders ;

	public Order(MyDate dateOrdered) {
		if(nbOrders < MAX_LIMITTED_ORDERS) {
			nbOrders++;
			this.dateOrdered = dateOrdered;
		}
		else {
			System.out.println("MAX LIMITTED ORDERS!");
			System.exit(0);
		}
		
	}
	
	public void listOfOrder() {
		System.out.println("***********************Order*****************");
			System.out.print("Date: ");
			this.dateOrdered.print();
			System.out.println("Ordered Items:");
			for(int i=0;i<qtyOrdered;i++) {
				System.out.println(i + "." + " DVD -" + itemsOrder[i].getTitle() + " - "+ 
							itemsOrder[i].getCategory() + " - " + 
							itemsOrder[i].getDirector() + " - " +
							itemsOrder[i].getLength()   + " : " +
							itemsOrder[i].getCost() + "$");
		}
		System.out.println("Total cost:" + this.totalCost());
		System.out.println("**********************************************");
	}
	
	private MyDate dateOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
		if (qtyOrdered == 10) 
			System.out.println("Cannot add DigitalVideoDisc because full!"); 
		else {
			itemsOrder[qtyOrdered++] = disc;
		}
	}
	
	//DigitalVideoDisc with array
//	void addDigitalVideoDisc(DigitalVideoDisc[] discs) {
//		//check if discs don't have elements
//		if (discs.length <0) return; 
//		
//		//solution
//		for(int i = 0; i < discs.length ; i++) {
//			if (qtyOrdered < 10) {
//				itemsOrder[qtyOrdered++] = discs[i];
//				System.out.println("Add " + discs[i].getTitle() + "successful!");
//			}
//			else {
//				System.out.printf("The items cannot add are: ");
//				for (int j = i; j < discs.length; j++ ) {
//					System.out.printf(" %s ",discs[i].getTitle());
//				}			
//				break;
//			}
//		}
//	}
		
	//DigitalVideoDisch with arbitrary number of arguments
	void addDigitalVideoDisc(DigitalVideoDisc ...discs) {
		//check if discs don't have elements
		if (discs.length <0) return; 
		
		//solution
		for(int i = 0; i < discs.length ; i++) {
			if (qtyOrdered < 10) {
				itemsOrder[qtyOrdered++] = discs[i];
				System.out.println("Add " + discs[i].getTitle() + "successful!");
			}
			else {
				System.out.printf("The items cannot add are: ");
				for (int j = i; j < discs.length; j++ ) {
					System.out.printf(" %s ",discs[i].getTitle());
				}			
				break;
			}
		}
	}
	
	//DigitalVideoDisc with 2 arguments
	void addDigitalVideoDisc(DigitalVideoDisc dvd1 ,DigitalVideoDisc dvd2) {
		if (qtyOrdered == 10) 
			System.out.println("The item quantitu has reached its limit !"); 
		else {
			itemsOrder[qtyOrdered++] = dvd1;
			System.out.println("Add " + dvd1.getTitle() + "successful!");
		}
		
		if (qtyOrdered == 10) 
			System.out.println("The dvd " + dvd2.getTitle() + " could not be added!"); 
		else {
			itemsOrder[qtyOrdered++] = dvd2;
			System.out.println("Add " + dvd2.getTitle() + "successful!");
		}	
	}
	
	void removeDigitalVideoDisc(DigitalVideoDisc disc){
		int i=0;
		int index = 0;
		for(DigitalVideoDisc x: itemsOrder) {
			i++;
			if(x == disc) 
			{
				index = i;
				break;
			}
		}
		
		for(i = index ; i < qtyOrdered ; i++) {
			itemsOrder[i]= itemsOrder[i+1];
		}
		
		qtyOrdered--;
	}
	
	public float totalCost() {
		float total = 0;
		for(int j =0; j <qtyOrdered ; j++) {
			total += itemsOrder[j].getCost();
		}
		return total;
		}
}

