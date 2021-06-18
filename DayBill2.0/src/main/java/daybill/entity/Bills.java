package daybill.entity;

public class Bills {
	private int no;
	private float dress;
	private float food;
	private float live;
	private float transportation;
	private float study;
	private float sum;
	private String date;
	public Bills(float dress, float food, float live, float transportation, float study, float sum, String date, int no) {
		super();
		this.dress = dress;
		this.food = food;
		this.live = live;
		this.transportation = transportation;
		this.study = study;
		this.sum = sum;
		this.date = date;
		this.no = no;
	}
	public Bills(float dress, float food, float live, float transportation, float study, float sum,
			String date) {
		super();
		this.dress = dress;
		this.food = food;
		this.live = live;
		this.transportation = transportation;
		this.study = study;
		this.sum = sum;
		this.date = date;
	}
	public float getDress() {
		return dress;
	}
	public void setDress(float dress) {
		this.dress = dress;
	}
	public float getFood() {
		return food;
	}
	public void setFood(float food) {
		this.food = food;
	}
	public float getLive() {
		return live;
	}
	public void setLive(float live) {
		this.live = live;
	}
	public float getTransportation() {
		return transportation;
	}
	public void setTransportation(float transportation) {
		this.transportation = transportation;
	}
	public float getStudy() {
		return study;
	}
	public void setStudy(float study) {
		this.study = study;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public String getDate() {
		return date;
	}
	public void setData(String date) {
		this.date = date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}
