package model;

public class Book {
	private Long isbn;
	private String aouthor;
	private String tittle;
	private Integer year;
	private Double price;
	private Boolean pictures;
	
	public Book() {
		
		super();
	}
	
	public Book(Long isbn, String aouthor, String tittle, Integer year, Double price, Boolean pictures) {
		super();
		this.isbn = isbn;
		this.aouthor = aouthor;
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
	public String getAouthor() {
		return aouthor;
	}
	public void setAouthor(String aouthor) {
		this.aouthor = aouthor;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getPictures() {
		return pictures;
	}
	public void setPictures(Boolean pictures) {
		this.pictures = pictures;
	}
	
	
}
