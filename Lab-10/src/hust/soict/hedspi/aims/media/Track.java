package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable , Comparable<Track>	{
	
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track() {
	
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	@Override
	public void play() throws PlayerException {
		if (this.length>0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("track length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this== obj) return true;
		
		if(obj instanceof Track) {
			Track track = (Track)obj;
			if((this.title.equals(track.title))&&(this.length==track.length)) 
				return true;
			else return false;
		}else {
			System.out.print("Cannot cast to track class");
			return false;
		}
		
	}

	@Override
	public int compareTo(Track track) {
		if(this == track) return 0;
			
		if(track instanceof Track) {
			return this.title.compareTo(track.title);
		}else {
			System.out.print("Cannot cast to track class");
			return 123;
		}
	}
	
}
