package library;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.PublisherCountry;
import enumerations.Title;

public class LibraryStreams extends Library{

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Library createLibrary(int numBooks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookByISBN(long isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooksAsList() {
		// TODO Auto-generated method stub
		return null;
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
