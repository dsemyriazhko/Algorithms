package rambler.algorithms.shortestsubstring;

public class Main {
    public static void main(String[] args) {
        String input = "aabbccba";
        String alphabet = "abc";

        char[] inputCharArray = input.toCharArray();
        char[] alphabetCharArray = alphabet.toCharArray();
        String result = null;

        for (int i = 0; i < inputCharArray.length; i++) {
            String subStr = nearest(i, inputCharArray, alphabetCharArray);

            if (result == null || result.length() > subStr.length()) {
                result = subStr;
            }
        }

        System.out.println(result);
    }

    private static String nearest(int i, char[] charArray, char[] alphabetCharArray) {
        int left = -1;
        int right = -1;

        for (char a : alphabetCharArray) {
            for (int j=0; j<charArray.length; j++){
                if(charArray.length > i+j && charArray[i+j] == a) {
                    if(right < i+j)
                        right = i+j;
                    break;
                } else if (i-j >= 0 && charArray[i-j] == a) {
                    if (left > i-j || left == -1)
                        left = i-j;
                    break;
                }
            }
        }

        if (left == -1)
            left = i;
        if (right == -1)
            right = i;

        return getSubstring(charArray, left, right);
    }

    private static String getSubstring(char[] charArray, int left, int right) {
        StringBuilder builder = new StringBuilder();
        for (int c = left; c <= right; c++) {
            builder.append(charArray[c]);
        }

        return builder.toString();
    }
}
