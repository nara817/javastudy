package api;

public class Weather {

	private int temp;
	private String wfKor;
	private int hour;
	
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getWfKor() {
		return wfKor;
	}
	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	@Override
	public String toString() {
		return "온도" + temp + "°" +" 날씨" + wfKor + "시간" + hour + "\n";
	}
	
	
	
	
	
}
