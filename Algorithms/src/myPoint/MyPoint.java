package myPoint;

public class MyPoint {
     private double x;
     private double y;
     private static double px = 1.0;
     private static double py = 2.0;
     public MyPoint(double x, double y) {
    	 this.x = x;
    	 this.y = y;
     }
     public double getX() {
    	 return x;
     }
     public double getY() {
    	 return y;
     }
     public double getDistance() {
    	 double mid = Math.pow(x - px, 2) + Math.pow(y - py, 2);
    	 double distance = Math.sqrt(mid);
    	 return distance;
     }
     
     
     
     
}
