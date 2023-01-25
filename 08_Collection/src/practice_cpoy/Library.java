package practice_cpoy;

// try catch 3번 사용하지 않고, 처리할 수 있는 다른 방법 풀이

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Library {

	private List<Book> books;
	private Scanner sc;

	public Library() {
		books = new ArrayList<Book>(); // 책 배열
		sc = new Scanner(System.in);
	}

	private void addBook() {
		System.out.println("===책 추가하기===");
		System.out.println("isbn >>>");
		String isbn = sc.next();
		System.out.println("isbn >>>");
		String title = sc.next();
		System.out.println("isbn >>>");
		String author = sc.next();
		Book book = new Book(isbn, title, author);
		books.add(book);
		System.out.println(title + "책이 추가되었습니다.");

	}

	private void deleteBook() throws RuntimeException {
		throw new RuntimeException("등록된 책이 없습니다.");
	}

	private void findBook() {
		throw new RuntimeException("등록된 책이 없습니다.");
	}

	private void printAllBooks() {
		throw new RuntimeException("등록된 책이 없습니다.");
	}

	public void manage() {
		try {
			deleteBook();
			findBook();
			printAllBooks();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}
