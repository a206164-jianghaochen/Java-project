package bookApps;
public class Book {
       private String title;
	   private String author;
	   private double price;	
	public Book(String title, String author) {
		     this.title = title;
		     this.author = author;				
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public double calculateDiscountPrice(double discountPercentage) {
		return price - (price * discountPercentage / 100);
	}	
	public void displayInfo(double discountPercentage) {
		double discountedPrice = calculateDiscountPrice(discountPercentage);
		System.out.println("\n--- Book Info ---");
		System.out.println("Title:" + this.title);
		System.out.println("Author:" + this.author);
		System.out.println("Original Price: RM" + this.price);
		System.out.printf("Discounted Price (%.2f%%): RM%.2f", discountPercentage, discountedPrice);
	}		
}
