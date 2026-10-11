package driver;
import java.text.*; 
public class FoodApp {
	public static void main(String[] args){
		Food[] a = {new Beverage("Coffe Latte",15.00, "Hot","Large"),
		new Beverage("Manggo Juice",10.50 ,"Cold","Small"), 
		new Beverage("Strawberry Shake",12.50,"Cold"), 
		new Beverage("Chrysanthemum Tea","Hot")};
		for(int i=0; i<a.length; i++)
		System.out.println(a[i]);
		}
		}

class Food {
String menuName; 
double price;
DecimalFormat df = new DecimalFormat("###0.00");
public Food(String a, double b) {
menuName = a;
price = b;
}
public Food(String a){
menuName = a;
price = 8.0;
}
public String toString() {
return " Menu: " + menuName +"\n Price: RM" +
df.format(price) + "\n";
}
}

class Beverage extends Food{
String typeofDrink; 
String size;
public Beverage(String a, double d, String b, String c) {
super(a, d);
typeofDrink = b; 
size= c;
}
public Beverage(String a, double b, String c){
super(a, b);
   typeofDrink = c; 
  size = "Regular";
}
public Beverage(String a,String b) {
   super(a);
   typeofDrink = b; 
   size = "Regular";
}
public String toString(){
return super.toString()+ " Hot/Cold:"+ typeofDrink +
"\n Size:" + size + "\n";
}
}


