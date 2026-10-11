package dataStructureExercise;
import java.util.*;
public class Test08 {
	public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		BST2 bst = new BST2();
		  input = input.replaceAll("[.,?!]", "");
		  String[] words = input.split("\\s+");		  
		  for(String word : words) {
			  if(!word.isEmpty()) {
			  bst.insert(word);			  			  
		               }
	               }		  
			bst.printTree();  	
                }	
             }
    class BST2{
    	class Node{
    		String word;
    		Node left,right;
    		public Node(String word) {
    			this.word = word;
    			left = right = null;
    		}
    	}
         Node root;
              public BST2() {
        	 root = null;      	 
         }
         public void insert(String word) {
        	 root = insertRec(root, word);
         } 
        	 public Node insertRec(Node root, String word) {
        		 if(root == null) {
        			 root = new Node(word);
        			 return root;       			 
        		 }
        		 if(word.compareTo(root.word) < 0) {
        				root.left = insertRec(root.left, word);       				
        			}
        		 else if(word.compareTo(root.word) > 0) {       			 
        			   root.right = insertRec(root.right, word);		 
        		 }
        		 return root;		    		
    	}  
         public void printTree() {
        	 System.out.println(printRec(root));        	 
         }
         public String printRec(Node root) {
        	 if(root == null) {
        		 return "";
        	 }
       String leftSubtree = printRec(root.left); 	 
       String rightSubtree = printRec(root.right); 	 
        	return "(" + root.word + (leftSubtree.isEmpty() ? "()" : leftSubtree) +
        	(rightSubtree.isEmpty() ? "()" : rightSubtree) + ")";		      	 
         }     	 
    }