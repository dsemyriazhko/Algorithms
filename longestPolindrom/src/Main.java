public class Main {
    public static void main(String[] args) {
        String input = "bacaba";

        int left = -1;
        int max = 0;
        int counter = 0;
        String strMax = null;

        for (int i = 0; i < input.length(); i++) {
            if (isInsidePolindrom(input, left, i)) {
                counter++;
            }

            if(left >= 0) {
                if (isOutsidePolindrom(input, left, i)) {
                    if (counter > max) {
                        max = counter;
                        strMax = input.substring(left - (i - left)+1, i);
                    }

                    left=-1;
                    counter=0;
                }
                if (isLastCharacter(input, i)) {
                    if (counter > max) {
                        max = counter;
                        strMax = input.substring(left - (i - left), i+1);
                    }

                    left=-1;
                    counter=0;
                }
            }

            if (isCenterOfPolindrom(input, i)) {
                left = i + 1;
                i++;
            }
        }

        System.out.println("Result: " + strMax);
        System.out.println("Max length: " + max);
    }

    private static boolean isCenterOfPolindrom(String input, int i) {
        return i + 2 < input.length() && input.charAt(i) == input.charAt(i + 2);
    }

    private static boolean isLastCharacter(String input, int i) {
        return i == input.length()-1;
    }

    private static boolean isOutsidePolindrom(String input, int left, int i) {
        return input.charAt(left - (i - left)) != input.charAt(i);
    }

    private static boolean isInsidePolindrom(String input, int left, int i) {
        return left >= 0 && input.charAt(left - (i - left)) == input.charAt(i);
    }
}
