package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
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
	
	@Override
	public int compareTo(Media media) {
		if(this == media) return 0;
			
		if(media instanceof DigitalVideoDisc) {
			DigitalVideoDisc DVD = (DigitalVideoDisc)media;
			return this.getTitle().compareTo(DVD.getTitle());
		}else {
			return -1;
			
		}
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("DVD:  ID: %-5dTitle: %-15sCategory: %-20sCost: %1.2f$\n",
				this.getId(), this.getTitle(),this.getCategory(),this.getCost());
	}
}