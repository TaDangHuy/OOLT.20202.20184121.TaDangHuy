package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.disc.DigitalVideoDiscWapper;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle" , "Animal", "TDH", 20, 89f);
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella" , "Animal", "TDH", 20, 89f);
		
		DigitalVideoDiscWapper jungleWapper = new DigitalVideoDiscWapper(jungleDVD);
		DigitalVideoDiscWapper cinderellWapper = new DigitalVideoDiscWapper(cinderellaDVD);
		
		swapv2(jungleWapper , cinderellWapper );
		System.out.println("jungle dvd title:" + jungleWapper.d.getTitle());
		System.out.println("cinderella dvd title: " + cinderellWapper.d.getTitle());
		
		//changeTitle(jungleDVD, cinderellaDVD.getTitle());
		//System.out.println("jungle dvd title:: " + jungleDVD.getTitle());
		
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void swapv2(DigitalVideoDiscWapper a, DigitalVideoDiscWapper b) {
		DigitalVideoDisc tmp = a.d;
		a.d = b.d;
		b.d = tmp;
	}

	//public static void changeTitle(DigitalVideoDisc3 dvd, String title){
	//	String oldTitle = dvd.getTitle();
	//	dvd.setTitle(title);
	//	dvd = new DigitalVideoDisc3(oldTitle);
	//}
}
