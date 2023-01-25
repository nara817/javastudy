package practice_cpoy;

public class Book {
	
	public Book(String isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	private String isbn; // 책 넘버 : isbn
	private String title; // 책 제목 
	private String author; // 책 저자 
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSuthor() {
		return author;
	}
	public void setSuthor(String suthor) {
		this.author = suthor;
	}
	@Override
	public String toString() {
		return String.format("Book [isbn=%s, title=%s, author=%s]", isbn, title, author);
	}
	
	

}
