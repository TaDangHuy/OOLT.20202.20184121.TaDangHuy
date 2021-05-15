package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media{

	private float length;
	private String director;
	
	

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
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
