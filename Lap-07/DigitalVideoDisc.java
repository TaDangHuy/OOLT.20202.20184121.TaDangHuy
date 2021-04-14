package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(int id,String title, String category, float cost, float length) {
		super(id,title,category,cost,length);	
	}
	
	public DigitalVideoDisc(int id,String title, String category, float cost, float length, String director) {
		super(id,title,category,cost,length,director);			
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
}