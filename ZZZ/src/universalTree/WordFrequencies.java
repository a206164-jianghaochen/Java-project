package universalTree;
import java.util.*;
class TreeNode {
    String word;
    int frequency;
    TreeNode left, right;
    public TreeNode(String word) {
        this.word = word;
        this.frequency = 1;
        this.left = this.right = null;
    }
}
class WordFrequencyBST {
    TreeNode root;
    public WordFrequencyBST() {
        this.root = null;
    }
    public void addWord(String word) {
        root = addWordRecursive(root, word);
    }
    private TreeNode addWordRecursive(TreeNode node, String word) {
        if (node == null) {
            return new TreeNode(word);
        }
        int cmp = word.compareTo(node.word);
        if (cmp < 0) {
            node.left = addWordRecursive(node.left, word);
        } else if (cmp > 0) {
            node.right = addWordRecursive(node.right, word);
        } else {
            node.frequency++;
        }
        return node;
    }
    public void deleteWord(String word) {
        root = deleteWordRecursive(root, word);
    }
    private TreeNode deleteWordRecursive(TreeNode node, String word) {
        if (node == null) {
            return null;
        }
        int cmp = word.compareTo(node.word);
        if (cmp < 0) {
            node.left = deleteWordRecursive(node.left, word);
        } else if (cmp > 0) {
            node.right = deleteWordRecursive(node.right, word);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            TreeNode temp = findMin(node.right);
            node.word = temp.word;
            node.frequency = temp.frequency;
            node.right = deleteWordRecursive(node.right, temp.word);
        }
        return node;
    }
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public void searchWord(String word) {
        TreeNode result = searchWordRecursive(root, word);
        if (result != null) {
            System.out.println("The word " + word + " appears " + result.frequency + " times.");
        } else {
            System.out.println("The word " + word + " is not in the passage.");
        }
    }
    public TreeNode searchWordRecursive(TreeNode node, String word) {
        if (node == null) {
            return null;
        }
        int cmp = word.compareTo(node.word);
        if (cmp < 0) {
            return searchWordRecursive(node.left, word);
        } else if (cmp > 0) {
            return searchWordRecursive(node.right, word);
        } else {
            return node;
        }
    }
    public void printAllWords() {
        printAllWordsRecursive(root);
    }
    private void printAllWordsRecursive(TreeNode node) {
        if (node != null) {
            printAllWordsRecursive(node.left);
            System.out.println(node.word + ": " + node.frequency);
            printAllWordsRecursive(node.right);
        }
    }
}
public class WordFrequencies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordFrequencyBST bst = new WordFrequencyBST();
        String passage = scanner.nextLine();
        String[] words = passage.replaceAll("[.,!?]", "").toLowerCase().split("\\s+");
        for (String word : words) {
            bst.addWord(word);
        }
        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Add new word.");
                System.out.println("2. Delete word.");
                System.out.println("3. Search word.");
                System.out.println("4. Print all words and its frequency.");
                System.out.println("5. Exit.");
                System.out.println();
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid code, Enter code 1-5.");
                    scanner.nextLine(); 
                    continue;
                }
                int code = scanner.nextInt();
                switch (code) {
                    case 1:
                        System.out.print("Enter new word: ");
                        String addWord = scanner.nextLine().toLowerCase();
                        bst.addWord(addWord);
                        break;
                    case 2:
                         System.out.println("Input code: 2");
                     
                        String deleteWord = scanner.next().toLowerCase();
                        if (bst.searchWordRecursive(bst.root, deleteWord) != null) {
                            bst.deleteWord(deleteWord);
                            System.out.print("Enter word to be deleted: " + deleteWord + "\n");
                            System.out.println("The word" + deleteWord + "has been deleted.");
                        } else {    
                            System.out.print("Enter word to be deleted: " + deleteWord + "\n");
                            System.out.println("The word " + deleteWord + " is not in the passage.");
                            System.out.println();
                        }
                        break;
                    case 3:
                        System.out.print("Enter word to search: ");
                        String searchWord = scanner.nextLine().toLowerCase();
                        bst.searchWord(searchWord);
                        break;
                    case 4:
                        bst.printAllWords();
                        break;
                    case 5:
                        System.out.println("Input code: 5");
                        System.out.println("Bye..");
                        scanner.close();
                        return;
                    default:
                         System.out.println("Input code: " + code);
                        System.out.println("Invalid code, Enter code 1-5.");
                        System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine();
            }
        }
    }
}