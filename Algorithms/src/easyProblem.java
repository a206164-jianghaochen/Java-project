public class easyProblem {
    public static void main(String[] args) {
    	int i,j;
    	for(i = 1; i <= 9; i++) {
    		for(j = 1; j < i + 1; j++) {
    			System.out.print(i + "*" + j + "=" + i * j + " ");
    		}
    		System.out.println();
    	} 	  	
    }
}
