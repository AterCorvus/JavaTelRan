package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.PublisherCountry;
import enumerations.Title;

public class LibraryMaps extends Library{

	private Map<Long, Book> library;
	private HashMap<Publisher, Set<Book>> allByPublish;
	private HashMap<String, Set<Book>> allByPC;
	private TreeMap<Set<Author>, Set<Book>> sortAuthor;
	private TreeMap<String, Set<Book>> sortTittle;
	private TreeMap<LocalDate, Set<Book>> sortPD;
	private TreeMap<Integer, Set<Book>> sortPrice;

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
		return library.values();
	}

	@Override
	public List<Book> getAllBooksAsList() {
		return new ArrayList<>(library.values());
	}

	@Override
	public Set<Book> getAllBooksAsSet() {
		return new HashSet<>(library.values());
	}

	@Override
	public Stream<Book> getAllBooksAsStream() {
		return library.values().stream();
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
		Set<Book> result = new LinkedHashSet<Book>();
		for(Set<Book> aBooks : sortAuthor.values())
			result.addAll(aBooks);
		return result;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByTitle() {
		Set<Book> result = new LinkedHashSet<Book>();
		for(Set<Book> tBooks : sortTittle.values())
			result.addAll(tBooks);
		return result;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPublishingDate() {
		Set<Book> result = new LinkedHashSet<Book>();
		for(Set<Book> pDBooks : sortPD.values())
			result.addAll(pDBooks);
		return result;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPrice() {
		Set<Book> result = new LinkedHashSet<Book>();
		for(Set<Book> pBooks : sortPrice.values())
			result.addAll(pBooks);
		return result;
	}

}
