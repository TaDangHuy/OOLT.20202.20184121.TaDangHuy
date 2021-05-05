package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable<Media> {

	private int id;
	private String title;
	private String category;
	private float cost;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
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
		
		Media media = (Media)obj;
		
		if(media instanceof Media) {
			
			if(this.id==media.id) return true;
			else return false;
		}else {
			System.out.print("Cannot cast to media class");
			return false;
		}
		
	}
	
	@Override
	public int compareTo(Media media) {
		if(media.title.compareTo(this.title) >0) {
			return -1;
		}else if(media.title.compareTo(this.title)<0) {
			return 1;
		}else
			return 0;
	}
	

	public abstract void print();
	
	
}
