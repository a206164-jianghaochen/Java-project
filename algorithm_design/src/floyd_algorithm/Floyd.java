package floyd_algorithm;
public class Floyd {
	public static void main(String[] args) {
		int inf = 1000000000;
		int[][] D = {
    		  {0, 1, inf, inf, inf},
    		  {inf, 0, 2, 7, inf},
    		  {2, inf, 0, 3, inf},
    		  {inf,  inf, inf, 0, inf},
    		  {5, inf, 1, inf, 0},
		};
		int n = D.length;
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					D[i-1][j-1] = Math.min(D[i-1][j-1], D[i-1][k-1]+D[k-1][j-1]);
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(D[i][j] >= inf / 2) {
					System.out.print("inf\t");
				}else {
				System.out.print(D[i][j]+ "\t");
				}
			}
			System.out.println();
		}
	}

}
