import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String expr = "][";
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<expr.length(); i++) {
            final char current = expr.charAt(i);
            if (current == '[' || current == '(' || current == '{') {
                stack.push(current);
            }

            if (areTheSame(stack, current, ']', '[')) {
                return;
            }

            if (areTheSame(stack, current, ')', '(')) {
                return;
            }

            if (areTheSame(stack, current, '}', '{')) {
                return;
            }
        }

        System.out.println("true");
    }

    private static boolean areTheSame(Stack<Character> stack, char current, char currentExpected, char lastToCheck) {
        if (current == currentExpected) {
            if(stack.pop() != lastToCheck) {
                System.out.println("false");
                return true;
            }
        }
        return false;
    }
}
