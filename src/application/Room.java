package application;

public class Room {
	private String type;
	private int oneStar,twoStar,threeStar;
	
	public Room(){
		this.type = "";
		this.oneStar = 0;
		this.twoStar = 0;
		this.threeStar = 0;
	}
	public Room(String type,int oneStar,int twoStar,int threeStar) {
		this.type = type;
		this.oneStar = oneStar;
		this.twoStar = twoStar;
		this.threeStar = threeStar;
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getOneStar() {
		return oneStar;
	}
	public void setOneStar(int oneStar) {
		this.oneStar = oneStar;
	}
	public int getTwoStar() {
		return twoStar;
	}
	public void setTwoStar(int twoStar) {
		this.twoStar = twoStar;
	}
	public int getThreeStar() {
		return threeStar;
	}
	public void setThreeStar(int threeStar) {
		this.threeStar = threeStar;
	}
	

}
