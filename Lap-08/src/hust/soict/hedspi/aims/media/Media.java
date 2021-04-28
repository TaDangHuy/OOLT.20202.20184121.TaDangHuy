package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable<Media> {

	private int id;
	private String title;
	private String category;
	private float cost;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	public Media(String title) {
		this.title = title;
	}
	
	public Media(int id,String title, String category) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
	}

	public Media(int id,String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this== obj) return true;
		
		if(obj instanceof Media) {
			Media media = (Media)obj;
			if(this.id==media.id) return true;
			else return false;
		}else {
			System.out.print("Cannot cast to media class");
			return false;
		}
		
	}

	public abstract void print();
	
	
}
