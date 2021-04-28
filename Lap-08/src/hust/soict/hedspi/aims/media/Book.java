package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	//Contructer method
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(int id,String title, String category) {
		super(id,title,category);
	}
	
	public Book(int id,String title, String category, float cost) {
		super(id,title,category,cost);
	}
	
	public Book(int id,String title, String category , List<String> authors) {
		super(id,title ,category);
		this.authors = authors;
	}
	
	//method
	public void addAuthor(String authorName) {
		for(String author: authors) {
			if(author.equalsIgnoreCase(authorName))
			{
				System.out.println("Author name is existed!!");
			    return;
			}
		}
		authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		for(String author: authors) {
			if (author.equalsIgnoreCase(authorName)) {
				authors.remove(author);
				return;
			}
		}
		System.out.println("Don't find author name");
	}
	
	public void printAuthors() {
		for(String author: authors) {
			System.out.println(author);
		}
	}

	@Override
	public int compareTo(Media media) {
		if(this == media) return 0;
			
		if(media instanceof Book) {
			Book book = (Book)media;
			return this.getTitle().compareTo(book.getTitle());
		}else {
			return -1;
		}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("Book: ID: %-5dTitle: %-15sCategory: %-20sCost: %1.2f$\n",
				this.getId(), this.getTitle(),this.getCategory(),this.getCost());
	}

}
