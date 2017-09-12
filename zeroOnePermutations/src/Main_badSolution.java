import java.util.HashSet;

public class Main_badSolution {
    private static HashSet<String> cache = new HashSet<>();

    public static void main(String[] args) {
        int a = 2;
        int b = 1;

        StringBuilder input = new StringBuilder(a+b);
        for (int i=0; i<a; ++i) {
            input.append('0');
        }
        for (int i=0; i<b; ++i) {
            input.append('1');
        }

        permuteString("", input.toString());
    }

    private static void permuteString(String beginningString, String endingString) {
        if (endingString.length() <= 1) {
            String result = beginningString + endingString;
            if (!cache.contains(result) && isEndingAnotherChar(beginningString, endingString.charAt(0))) {
                System.out.println(result);
                cache.add(result);
            }
        }
        else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    if (isEndingAnotherChar(beginningString, endingString.charAt(i)))
                        permuteString(beginningString + endingString.charAt(i), newString);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    private static boolean isEndingAnotherChar(String baseString, char value) {
        return "".equals(baseString) || baseString.charAt(baseString.length()-1) != value;
    }
}
