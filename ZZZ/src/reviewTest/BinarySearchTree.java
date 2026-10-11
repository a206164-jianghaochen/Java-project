package reviewTest;
import java.util.*;
public class BinarySearchTree {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   BST bst = new BST();
	   int num;	   
	   while((num = sc.nextInt()) != 0) {
		   bst.insert(num);	   
	   }
	   int searchNum = sc.nextInt();
	   if(bst.search(searchNum)) {
		   System.out.println("Number " + searchNum + " is FOUND in the BST.");
	   }else {
           System.out.println("Number " + searchNum + " is NOT FOUND in the BST.");
       } 
   }
}
    class BST{
    	class Node{
    		int data;
    	Node left, right;	
    	public Node(int item) {
    	data = item;
    	left = right = null;
    	}   	
    }
    	Node root;
    	BST(){
    		root = null;
    	}
    	void insert(int data) {
    		root = insertRec(root,data);   		
    	}
    	Node insertRec(Node root, int data) {
    		if(root == null) {
    			root = new Node(data);
    			return root;
    		}
    		if(data < root.data) {
    			root.left = insertRec(root.left, data);   			
    		}else if(data > root.data) {
    			root.right = insertRec(root.right, data);  			
    		}
    		return root;
    	}	
    		boolean search(int data) {
    			return searchRec(root, data);    			
    		}
    		boolean searchRec(Node root, int data) {
    			if(root == null) {
    				return false;    				
    			}
    			if(root.data == data) {
    				return true;    				   				
    			}
    			if(data < root.data) {
    				return searchRec(root.left, data);    				
    			}
    			return searchRec(root.right, data);   			   			
    		}	
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	