package test;
import java.util.*;
class BST {
    class Node {
        String word;
        Node left, right;

        public Node(String word) {
            this.word = word; 
            left = right = null;
        }
    }
    Node root;
    BST() {
        root = null;
    }
    public void insert(String word) {
        root = insertRec(root, word);
    }
    public Node insertRec(Node root, String word) {
        if (root == null) {
            root = new Node(word);
            return root;
        }
        if (word.compareTo(root.word) < 0) {
            root.left = insertRec(root.left, word);
        } else if (word.compareTo(root.word) > 0) {
            root.right = insertRec(root.right, word);
        }
        return root;
    }
    public void printTree() {
        System.out.println(printTreeRec(root));
    }
    public String printTreeRec(Node root) {
        if (root == null) {
            return "";
        }
        String leftSubtree = printTreeRec(root.left);
        String rightSubtree = printTreeRec(root.right);
        return "(" + root.word + 
               (leftSubtree.isEmpty() ? "()" : leftSubtree) + 
               (rightSubtree.isEmpty() ? "()" : rightSubtree) + ")";
    }
}
public class TreeWithParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the passage:");
        String passage = sc.nextLine();
        sc.close();
        passage = passage.replaceAll("[.,?!]", "");
        String[] words = passage.split("\\s+");
        BST bst = new BST();
        for (String word : words) {
            if (!word.isEmpty()) {
                bst.insert(word);
            }
        }
        bst.printTree();
    }
}