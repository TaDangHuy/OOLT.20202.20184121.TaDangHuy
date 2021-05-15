package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class TestMediaCompareTo {
	public static void main(String[] args) {
		List<Media> medias = new ArrayList<Media>();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "DVD1111", "Animation", 30f, 20f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "DVD22", "Animation", 10f, 40f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "DVD333", "Animation", 50f, 60f);
		
		Book book1 = new Book(4, "Book1", "Animation", 20f);
		Book book2 = new Book(5, "Book222", "Animation", 30f);
		Book book3 = new Book(6, "Book33", "Animation", 40f);
		Book book4 = new Book(7, "Book4444", "Animation", 50f);
		
		CompactDisc cd1 = new CompactDisc(8, "CD11", "Animation", 10f);
		CompactDisc cd2 = new CompactDisc(9, "CD222", "Animation", 20f);
		CompactDisc cd3 = new CompactDisc(10, "CD3", "Animation", 30f);
		
		Track track1 = new Track("Track1", 10);
		Track track2 = new Track("Track2", 20);
		Track track3 = new Track("Track3", 30);
		Track track4 = new Track("Track4", 40);
		Track track5 = new Track("Track5", 50);
		Track track6 = new Track("Track6", 60);
		
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track3);
		
		cd2.addTrack(track3);
		cd2.addTrack(track4);
		
		cd3.addTrack(track5);
		cd3.addTrack(track6);
		cd3.addTrack(track1);
		cd3.addTrack(track2);
		
		
		medias.add(dvd1);
		medias.add(dvd2);
		medias.add(dvd3);
		
		medias.add(book1);
		medias.add(book2);
		medias.add(book3);
		medias.add(book4);
		
		medias.add(cd1);
		medias.add(cd2);
		medias.add(cd3);
		
		Collections.sort(medias);
		for(Media media: medias) {
			media.print();
		}
	}
}
