package dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import config.Config;
import enumerations.Title;
import randomlib.RandomLib;

public class Book implements Comparable<Book> {

	private static final int ISBN_SIZE = 13;
	
	private long isbn; // 13 digits
	private Set<Author> authors;
	private Title title;
	private LocalDate publishingDate;
	private Publisher publisher;
	private double price; // 2 digits after dot

	private static int digitsCount (long num) {
		int count = 0;
        while(num > 0)
        {
            num /= 10;
            ++count;
        }
        
        return count;
	}
	
	public Book(long isbn, Set<Author> authors, Title title, LocalDate publishingDate, Publisher publisher,
			double price) {
		super();

		if (digitsCount(isbn) != ISBN_SIZE)
			throw new IllegalArgumentException("Isbn should be exactly 13 digits");

		this.isbn = isbn;

		// Author number check
		if (authors.size() > Config.MAX_AUTHORS_NUMBER)
			throw new IllegalArgumentException("It's should't be more than " + Config.MAX_AUTHORS_NUMBER + " authors");
		this.authors = authors;

		this.title = title;
		// Publishing date check
		if (publishingDate.isBefore(Config.MIN_PUBLISHING_DATE))
			throw new IllegalArgumentException("Publishing date shuld't be earlier than" + Config.MIN_PUBLISHING_DATE);
		else if (publishingDate.isAfter(Config.MIN_PUBLISHING_DATE))
			throw new IllegalArgumentException("Publishing date shuld't be later than" + Config.MAX_PUBLISHING_DATE);
		this.publishingDate = publishingDate;

		this.publisher = publisher;

		// Price check
		if (price < Config.MIN_PRICE)
			throw new IllegalArgumentException("Price should't be less than" + Config.MIN_PRICE);
		else if (price > Config.MAX_PRICE)
			throw new IllegalArgumentException("Price shuld't be more than" + Config.MAX_PRICE);
		// Round up to 2 decimal places
		this.price = (double) Math.round(price * 100) / 100;
	}
	
	@Override
	public int compareTo(Book b) {
		int result = 0;

		// Author compare
		Iterator<Author> iterAu = authors.iterator();
		Iterator<Author> outIterAu = b.authors.iterator();
		while ((result == 0) && (iterAu.hasNext()) && (outIterAu.hasNext())) {
			Author author = iterAu.next();
			Author oAuthor = outIterAu.next();
			result = author.compareTo(oAuthor);
		}

		if (result != 0)
			return result;

		// Tittle compare
		result = title.compareTo(b.title);
		if (result != 0)
			return result;

		// Publishing Date compare
		result = publishingDate.compareTo(b.publishingDate);
		if (result != 0)
			return result;

		// Price compare
		return Double.compare(price, b.price);
	}
	
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		// Round up to 2 decimal places
		this.price = (double) Math.round(price * 100) / 100;
	}

	public long getIsbn() {
		return isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public LocalDate getPublishingDate() {
		return publishingDate;
	}

	public Publisher getPublisher() {
		return publisher;
	}
	
	public static Book randomBook(){
		long isbn = RandomLib.gen.nextLong();
		int digNum = digitsCount(isbn);
		while (digNum < ISBN_SIZE) {
			isbn += RandomLib.gen.nextLong();
			digNum = digitsCount(isbn);
		}
		if (digNum > ISBN_SIZE)
			isbn /= (digNum - ISBN_SIZE) * 10;
		
		Set<Author> authors = new HashSet<Author>();
		int authNum = RandomLib.gen.nextInt(3);
		for (int i = 0; i < authNum; i++) {
			authors.add(Author.random());
		}
				
		Title title = RandomLib.randomOfArray(Title.values());
		
		LocalDate publishingDate = RandomLib.randomLocalDate(Config.MIN_PUBLISHING_DATE, Config.MAX_PUBLISHING_DATE);
		
		Publisher publisher = Publisher.random();
		
		double price = RandomLib.nextDoubleRange(Config.MIN_PRICE, Config.MAX_PRICE);
		
		return new Book(isbn, authors, title, publishingDate, publisher, price);
	}
}
