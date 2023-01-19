package ex05_exception;

/*
 	예외 클래스 만들기
★★★ 1. Exception 클래스를 상속 받는다.(★필수)
 	2. Exception 클래스의 슈퍼클래스인 Throwable 클래스가 Serialilzble 인터페이스를 구현하기 때문에 SerialiVersionUID 값을 가질 수 있다.(선택)
 	> 부모가 이미 Serialilzble(직렬화) 인터페이스를 구현해서, 자식들도 영향을 받는다
 	큰덩이가 쪼개져서 직렬화 > 쪼개진게 결국 하나의 값이라는걸 증명 ? 그게 SerialiVersionUID
 */

public class GunException extends Exception {

	private static final long serialVersionUID = -5772183622648755667L; // 타인과 다른값 나올 수 있음
	
	//필드값
	private String exceptionCode;
	
	public GunException(String message, String exceptionCode) {
		super(message);
		this.exceptionCode = exceptionCode;
		
	}
	// getter setter
	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

}
