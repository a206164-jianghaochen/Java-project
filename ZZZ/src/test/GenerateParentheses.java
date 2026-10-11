package test;
import java.util.ArrayList;
import java.util.List;
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(result, "", 0, 0, n);
        return result;
    }
    private void generateCombinations(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            generateCombinations(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateCombinations(result, current + ")", open, close + 1, max);
        }
    }
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
        System.out.println(gp.generateParenthesis(1));
    }
}
