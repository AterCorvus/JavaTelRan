package library;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.PublisherCountry;
import enumerations.Title;

public class LibraryMaps extends Library{

	private Map<Long, Book> library;

	private LibraryMaps(Map<Long, Book> library) {
		super();
		this.library = library;
	}

	public LibraryMaps() {
		super();
		this.library = new HashMap<>();
	}
	
	@Override
	public boolean addBook(Book book) {
		if (library.containsKey(book.getIsbn()))
				return false;
		library.put(book.getIsbn(), book);
		return true;
	}

	@Override
	public Library createLibrary(int numBooks) {
		Map<Long, Book> library = new HashMap<>();
		for (int i = 0; i < numBooks; i++) {
			Book book = Book.randomBook();
			library.put(book.getIsbn(), book);
		}
		return new LibraryMaps(library);
	}

	@Override
	public Book getBookByISBN(long isbn) {
		return library.get(isbn);
	}

	@Override
	public Iterable<Book> getAllBooks() {
		Set<Book> books = new HashSet<>();
		for(Entry<Long, Book> entry : library.entrySet())
			books.add(entry.getValue());
		return books;
	}

	@Override
	public List<Book> getAllBooksAsList() {
		
	}

	@Override
	public Set<Book> getAllBooksAsSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<Book> getAllBooksAsStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksOfAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksByTitle(Title title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksInPublishingDatesRange(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksByPublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksByPublisherCountry(PublisherCountry country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksInPriceRange(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPublishingDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

}
