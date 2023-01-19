package ex03_hash;

public class User {
	
	// 필드
	private String id;
	private String pw;

	// 생성자 Source > using fild
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}


	@Override
	public String toString() {
		return String.format("User [id=%s, pw=%s]", id, pw);
	}
	
	
	@Override // hashCode id만 생성 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
