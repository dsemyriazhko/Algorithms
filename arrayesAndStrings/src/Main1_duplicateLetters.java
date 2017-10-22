/**
 * Duplicate chars in string.
 */
public class Main1_duplicateLetters {
    public static void main(String[] args) {
        String input = "abcad";

        char startPosition = 'A';
        char endPosition = 'z';

        boolean[] checkList = new boolean[endPosition - startPosition];

        for (int i = 0; i<input.length(); i++) {
            int position = endPosition - input.charAt(i);

            if (checkList[position]) {
                System.out.println("true");
                return;
            }

            checkList[position] = true;
        }

        System.out.println("false");
    }
}
