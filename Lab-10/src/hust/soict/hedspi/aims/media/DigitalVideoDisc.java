package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(int id,String title, String category, float cost, float length) {
		super(id,title,category,cost,length);	
	}
	
	public DigitalVideoDisc(int id,String title, String category, float cost, float length, String director) {
		super(id,title,category,cost,length,director);			
	}

	@Override
	public void play() throws PlayerException{
		if(this.getLength() >0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: DVD Length is non-positive!");
		}
	}
	
	@Override
	public int compareTo(Media media) {
		if(this == media) return 0;
		
		DigitalVideoDisc DVD = (DigitalVideoDisc)media;
		
		if(DVD instanceof DigitalVideoDisc) {
			
			if(this.getCost() < DVD.getCost()) {
				return -1;
			}else if (this.getCost() > DVD.getCost()) {
				return 1;
			}else {
				if(this.getLength() < DVD.getLength()) {
					return -1;
				}else if(this.getLength() > DVD.getLength()) {
					return 1;
				}else {
					return super.compareTo(media);
				}
			}
		}else {
			return 101;
			
		}
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("DVD:  ID: %-5dTitle: %-15sCategory: %-20sCost: %1.2f$\n",
				this.getId(), this.getTitle(),this.getCategory(),this.getCost());
	}
}