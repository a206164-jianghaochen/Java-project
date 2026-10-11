package driver;
import java.util.Scanner;
import java.util.Stack;
public class Palindrome {
        public static void main(String[] args) {
        	Scanner sc = new Scanner(System.in);
        	int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
        	String str = sc.next();
        if(isPalindrome(str)) {
        	System.out.println("It is a Palindrome");
        }else {
        	System.out.println("Not a Palindrome");
        }
        	
        	
        	
        }
        }	
        public static boolean isPalindrome(String str) {
        	Stack<Character> stack = new Stack<>();
        	for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));
            }
        	for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
        			
        			
        			
        		}
        		
        		
        		
        		
        		
        		
        	
        	
        	
        	
        	
        	
        

