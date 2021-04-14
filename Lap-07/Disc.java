package hust.soict.hedspi.aims.media;

public class Disc extends Media{

	private float length;
	private String director;
	
	public float getLength() {
		return length;
	}
	
	public String getDirector() {
		return director;
	}

	public Disc() {
		// TODO Auto-generated constructor stub
	}
	
	public Disc(int id, String title, String category, float cost){
		super(id, title, category, cost);
	}
	
	public Disc(int id, String title, String category, float cost, float length) {
		super(id, title, category, cost);
		this.length= length;
	}
	
	public Disc(int id, String title, String category, float cost, float length, String director) {
		super(id,title,category,cost);
		this.length= length;
		this.director=director;
	}
 
	public Disc(int id, String title, String category, float cost, String director) {
		super(id,title,category,cost);
		this.director=director;
	}
	
}
