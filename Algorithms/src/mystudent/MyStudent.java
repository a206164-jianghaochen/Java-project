package mystudent;

public class MyStudent {
    private String sid;
	private String sname;
	private double maths;
	private double English;
	private double computer;
	
	public MyStudent(String id, String name, double math, double english, double computer) {
		this.setSid(id);
		this.setSname(name);
		this.setMaths(math);
		this.setEnglish(english);
		this.setComputer(computer);
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getMaths() {
		return maths;
	}

	public void setMaths(double maths) {
		this.maths = maths;
	}

	public double getEnglish() {
		return English;
	}
	public void setEnglish(double english) {
		English = english;
	}

	public double getComputer() {
		return computer;
	}

	public void setComputer(double computer) {
		this.computer = computer;
	}
	public double calculateAverage() {
		double ave = (maths + English + computer) / 3;		
		return ave;
	}
	public double calculateTotal() {
		double total = maths + English + computer;		
		return total;
	}
	public double getMaxScore() {		
		double MaxScore = Math.max(Math.max(maths, English), computer);
		return MaxScore;
	}	
}
