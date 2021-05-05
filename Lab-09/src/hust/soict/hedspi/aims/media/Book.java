package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	private String content;
	
	public List<String> contentTokens = new ArrayList<String>();
	
	public Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

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

	public void processContent() {
		this.contentTokens.addAll(Arrays.asList(this.content.split("[\\p{Punct}\\s]+")));
		System.out.println("           aaa     "+contentTokens.size());
		Collections.sort(contentTokens);
		
		Iterator<String> iterator = contentTokens.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			if(wordFrequency.containsKey(str)==false) {
				wordFrequency.put(str, 1);
			}else {
				int count = wordFrequency.get(str);
				count++;
				wordFrequency.put(str,count);
			}
		}
	}
	
	@Override
	public String toString() {
		
		String str = "";
		str += "id: "+this.getId()+"\n";
		str += "title: "+this.getTitle()+"\n";
		str += "authors: ";
		if(authors.size()==0) 
			str += "No have author!!";
		else {
			for (String author : this.authors) {
				str += author + ", ";
			}
		}
		
		str += "\n";
		str += "cost: "+this.getCost()+"$\n";
		str += "number of tokens: " + contentTokens.size() + "\n";
		for (Map.Entry<String, Integer> c : this.wordFrequency.entrySet()) {
			str += c.getKey() + " : "+ c.getValue() + "\n";
		}
		
		return str;
	}
	
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("Book: ID: %-5dTitle: %-15sCategory: %-20sCost: %1.2f$\n",
				this.getId(), this.getTitle(),this.getCategory(),this.getCost());
	}

}
