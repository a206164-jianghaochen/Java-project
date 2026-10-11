package driver;

public class pattern {

	public static void main(String[] arg) {
	 
		
		for(int i = 1; i <= 4; i++) {
			
			for(int j = 1; j <= 4-i; j++) {
				System.out.print(" ");
			}
			for(int z = 1; z <= 2*i - 1; z++) {
				System.out.print("*");
			}
			System.out.println();
		}


        
for(int i = 3; i >= 1; i--) {
	
	for(int j = 1; j <= 4-i; j++) {
		System.out.print(" ");
	}
	for(int z = 1; z <= 2*i - 1; z++) {
		System.out.print("*");
	}
	System.out.println();
}
}
}