//TK2053-A206164-JiangHaochen-tutorial3-2AK2-SK-ST
package BMICalculation;
public class Member {
    String name;
	int age;
	private double weight;
	private double height;
   public Member(String name, int age) {
	   this.name = name;
	   this.age = age;   
   }
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public double getHeight() {
	return height;
}
public void setHeight(double height) {
	this.height = height;
}
	public String calculateBMI() {				
		double BMI = weight / (height * height);
		if(BMI < 18.5) {
			return "Underweight";
		}else if(BMI >= 18.5 && BMI < 25) {
			return "Normal weight";
		}else if(BMI >= 25 && BMI <30) {
			return "Overweight";
		}else {
			return "Obesity";
		}		
	}
   public void displayInfo() {
	   System.out.println("Name : " + this.name);
		 System.out.println("Age : " + this.age);
		 System.out.println("Weight : " + this.weight + " kg");
		 System.out.println("Height : " + this.height + " m");
		 double BMI = weight / (height * height);
		 System.out.println("BMI : " + BMI);
		 System.out.println("BMI category: " + this.calculateBMI());	   
   }	
}
