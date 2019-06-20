package book;

import java.util.Random;

import randomLib.RandomLib;

public class Book {
	private static final String[] AUTHORS = {"Pushkin", "Oscar Wilde", "Tolkien", "Donald Knut", "Mcconnell", "Nill Donald Walsh", "Tolstoy", "Alexander Duma", "Gomer"};
	private static final int MIN_YEAR = -900;
	private static final int MAX_YEAR = 2019;
	private static final double MIN_PRICE = 100.;
	private static final double MAX_PRICE = 10000.0;
	private static final double PICTURES_PROBABIL = 0.7;
	private Long isbn;
	private String author;
	private String tittle;
	private int year;
	private double price;
	private boolean pictures;
	
	private static Random gen = new Random();
	
	public Book() {
		super();
	}
	
	public Book(Long isbn, String author, String tittle, int year, double price, boolean pictures) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.tittle = tittle;
		this.year = year;
		this.price = price;
		this.pictures = pictures;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPictures() {
		return pictures;
	}

	public void setPictures(boolean pictures) {
		this.pictures = pictures;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", tittle=" + tittle + ", year=" + year + ", price="
				+ String.format("%.2f", price) + ", picture=" + pictures + "]";
	}
	
	public static Book randomBook() {
		Long isbn = Math.abs(gen.nextLong() / 1000000);
		String author = RandomLib.randomStringFromSet(AUTHORS);
		String tittle = RandomLib.randomString(10);
		int year = RandomLib.nextInRange(MIN_YEAR, MAX_YEAR);
		double price = RandomLib.nextInRange(MIN_PRICE, MAX_PRICE);
		boolean pictures = year > 1657 ? RandomLib.randomBool(PICTURES_PROBABIL) : false;
		
		return new Book(isbn, author, tittle, year, price, pictures);
	}
}