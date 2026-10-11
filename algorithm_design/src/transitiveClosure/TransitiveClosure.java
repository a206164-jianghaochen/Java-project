package transitiveClosure;

public class TransitiveClosure {

	public static void main(String[] args) {
		int[][] D= {
				{0,1,0,0},
				{0,0,1,0},
				{0,0,0,1},
				{0,0,0,0},
				};
		int n = D.length;
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					D[i][j] = (D[i][j] == 1 || (D[i][k] == 1 && D[k][j] == 1)) ? 1 : 0;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(D[i][j] + "\t");
			}
			System.out.println();
		}	
	}
}
