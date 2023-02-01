package practice;

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

	private void deleteBook() { // RuntimeException은 UnChecked-Exception이므로 RuntimeException을 생략할 수 있다.
		System.out.println("=== 책 삭제하기 ====");
		try {// 예외처리1 : 책이 1권도 없는데 제거하려고 할때
			if (books.isEmpty()) { // if(books.size() ==0 || books.isEmpty()) 동일
				throw new RuntimeException("등록된 책이 없습니다.");
			}
			System.out.println("삭제할 isbn >>>");// 삭제할 책 찾기
			String isbn = sc.next();
			if (isbn.isEmpty() == false) {
				/* 객체 기반 삭제(Book 객체 간 동등 비교가 필요하기 때문에 equals 메소드를 오버라이드 해야한다.) */
				for(Book book : books) {
					if(isbn.equals(book.getIsbn())) {
						books.remove(book); // equals 메소드가 내부에서 사용된다
						System.out.println(book + "책이 삭제되었습니다.");
						return;
					}
					
				}
				
				/*
				 인덱스 기반 삭제
				for (int i = 0; i < books.size(); i++) { // 지울때 index정보를 알아야 하기때문, 향상for문은 사용X 일반 for문 사용
					Book book = books.get(i); // i 저장된 책 한권 한권
					if (isbn.equals(book.getIsbn())) {
						Book deletedBook = books.remove(i); // remove(i)는 삭제된 요소(Book)를 반환 / 동일한 식 books.remove(i);
						System.out.println(deletedBook + "책이 삭제되었습니다."); // 위 동일식으로 할 경우 System.out.println(book + "책이
																			// 삭제되었습니다.");
						return;
					}
				}  */
			}
			throw new RuntimeException(isbn + "isbn을 가진 책이 없습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage()); // "등록된 책이 없습니다."이라고 출력
		}
	}

	private void findBook() { // 예외처리2 : 삭제하고자 하는 책이 없다
		System.out.println("=== 책 조회하기 ===");
		try {
			if (books.isEmpty()) {
				throw new RuntimeException("등록된 책이 없습니다.");
			}
			System.out.println("조회할 isbn >>>");
			String isbn = sc.next();
			if (!isbn.isEmpty()) { // !쓰지 말라고 할때도 있음 그럴땐 (isbn.isEmpty() == false로 하기
				for (Book book : books) {// 향상 for문(index필요X)
					if (isbn.equals(book.getIsbn())) {
						System.out.println("조회결과 : " + book);
						return;
					}
				}

			}
			throw new RuntimeException(isbn + " isbn을 가진 책이 없습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void printAllBooks() {
		System.out.println("=== 전체 조회하기 ===");
		try {
			if (books.isEmpty()) {
				throw new RuntimeException("등록된 책이 없습니다.");
			}
			for (Book book : books) {
				System.out.println(book);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void manage() {
		
		while(true) {
			
			try {
			
				System.out.print("1.추가 2.삭제 3.조회 4.전체 0.종료 >>> ");
				String choice = sc.next();
				
				switch(choice) {
				case "1":
					addBook();
					break;
				case "2":
					deleteBook();
					break;
				case "3":
					findBook();
					break;
				case "4":
					printAllBooks();
					break;
				case "0":
					System.out.println("도서관리 프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못된 입력입니다. 다시 시도하세요.");
				}
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
}