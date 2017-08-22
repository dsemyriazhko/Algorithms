import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        String input = "ABCD";

        Stack<String> stack = new Stack<>();
        stack.push("");
        stack.push(input);

        while (!stack.empty()) {
            String rest = stack.pop();
            String base = stack.pop();

            for (int i = 0; i < rest.length(); i++) {
                String currentBase = base + rest.charAt(i);
                String currentRest = rest.substring(0, i) + rest.substring(i + 1);

                if (currentRest.length() > 1) {
                    stack.push(currentBase);
                    stack.push(currentRest);
                }
                else
                    System.out.println(currentBase + currentRest);
            }
        }
    }

//    public static void permuteString(String beginningString, String endingString) {
//        if (endingString.length() <= 1)
//            System.out.println(beginningString + endingString);
//        else
//            for (int i = 0; i < endingString.length(); i++) {
//                try {
//                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
//
//                    permuteString(beginningString + endingString.charAt(i), newString);
//                } catch (StringIndexOutOfBoundsException exception) {
//                    exception.printStackTrace();
//                }
//            }
//    }
}