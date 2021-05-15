package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.PlayerException;


public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	
	
	// Contructer
	public CompactDisc() {
		
	}
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
		 //System.out.println("This track has been added!");
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
	public void play() throws PlayerException{
		if(this.getLengthCD() > 0) {
			Iterator<Track> iter = tracks.iterator();
			Track nexTrack;
			while(iter.hasNext()) {
				nexTrack = iter.next();
				try {
					nexTrack.play();
				} catch (Exception e) {
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	
	@Override
	public int compareTo(Media media) {
		if(this == media) return 0;
		
		if(media instanceof CompactDisc) {
			
			CompactDisc CD = (CompactDisc)media;
			
			if(this.tracks.size() > CD.tracks.size()) {
				return 1;
			}else if(this.tracks.size() < CD.tracks.size()) {
				return -1;
			}else {
				if(this.getLengthCD() > CD.getLengthCD()) {
					return 1;
				}else if (this.getLengthCD() < CD.getLengthCD()) {
					return -1;
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
		System.out.printf("CD:   ID: %-5dTitle: %-15sCategory: %-20sCost: %1.2f$\n",
				this.getId(), this.getTitle(),this.getCategory(),this.getCost());
	}
}
