package ex02_List;

public class User {

	private String id;
	private String fw;

	public User() {

	}

	public User(String id, String fw) {
		super();
		this.id = id;
		this.fw = fw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFw() {
		return fw;
	}

	public void setFw(String fw) {
		this.fw = fw;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, fw=%s]", id, fw);
	}
}
