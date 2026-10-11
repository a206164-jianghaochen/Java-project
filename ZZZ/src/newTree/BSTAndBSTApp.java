package newTree;
import java.util.*;
public class BSTAndBSTApp {
      public static void main(String[] args) {    	  
    Scanner sc = new Scanner(System.in);
   	   BST bst = new BST();
   	   int num;	   
   	   while((num = sc.nextInt()) != 0) {
   		   bst.insert(num);	   
   	   }
    	  bst.preorder();
          bst.inorder();
    	  bst.postorder();
          bst.findMinimum();
          bst.findMaximum();
          System.out.println();                     
          System.out.println("Minimum Element in tree is : " + bst.findMinimum());
          System.out.println("Maximum Element in tree is : " + bst.findMaximum());
        }                                             
    }
   class BST { 
   class Node {
   int key;
     Node left, right;
      public Node(int item) {
    key = item;
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
 		if(data < root.key) {
 			root.left = insertRec(root.left, data);   			
 		}else if(data > root.key) {
 			root.right = insertRec(root.right, data);  			
 		}
 		return root;
 	}		
 	void inorder() {
        System.out.print("Inorder : ");
 		printInorder(root);
        System.out.println();
 	}
 	void printInorder(Node root) {
 		if(root != null) {
 			printInorder(root.left);
 			System.out.print(root.key + " ");
 			printInorder(root.right);
 		}
 	}
 	   void preorder() {
           System.out.print("Preorder : ");
 		   printPreorder(root); 
           System.out.println();
 	   }
 	  void printPreorder(Node root) {
 		  if(root != null) { 			  
 			 System.out.print(root.key + " ");
 			printPreorder(root.left);
 			 printPreorder(root.right);             
 		  }
 	  }
 	  void postorder() {
          System.out.print("Postorder : ");
 		  printPostorder(root);
 	  }
 	   void printPostorder(Node root) {
 		   if(root != null) {
 			   printPostorder(root.left);
 			  printPostorder(root.right);
 			 System.out.print(root.key + " ");
 		   }
	  }
       int findMinimum() {
       return findMinimumRec(root);
    }
       int findMinimumRec(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }
          int findMaximum(){
          return findMaximumRec(root);
          }
       int findMaximumRec(Node root){
       while (root.right != null) {
            root = root.right;
        }
        return root.key;
       }  
   }