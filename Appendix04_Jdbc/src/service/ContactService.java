package service;

public interface ContactService { 
	public void addContact(); // 사용자들이 사용할 서비스 이름들은 대부분 정해져있는 이름들이 있음(= 사용자 친화적 이름들)
	public void removeContact();// 삭제메소드 /이름 delete와 구분
	public void modifyContact(); // 수정메소드
	public void findContactsByname(); // 조회메소드(이름으로 조회)
	public void findAllContacts(); // 조회메소드

}
