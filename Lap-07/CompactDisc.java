package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;


public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	// Contructer
	public CompactDisc(String artist, List<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(int id,String title, String category, float cost) {
		super(id,title,category,cost);	
	}
	
	public CompactDisc(int id,String title, String category, float cost, String director) {
		super(id,title,category,cost,director);			
	}
	
	// method
	public void addTrack(Track track) {
		for(Track tmp: tracks) {
			if(compareTrack(tmp, track)) {
				System.out.println("This track is existed!!");
				return;
			} 
		}
		 tracks.add(track);
		 System.out.println("This track has been added!");
	}
	
	public void removeTrack(Track track) {
		for(Track tmp: tracks) {
			if(compareTrack(tmp, track)) {
				tracks.remove(track);
				System.out.println("Remove track successfull!");
				return;
			} 
		}
		 System.out.println("This track is not exist!");
	}
	
	public int getLengthCD() {
		int total = 0;
		
		for (Track track: tracks) {
			total+= track.getLength();
		}
		return total;
	}
	
	//additional method
	private boolean compareTrack(Track track1, Track track2) {
		if(!track1.getTitle().equalsIgnoreCase(track2.getTitle())) 
			  return false;
		  else if(track1.getLength() != track2.getLength()) return false;
		return true;
	}

	//Override method
	@Override
	public void play() {
		for(Track track: tracks) {
			track.play();
		}
	}

}
