public class Main {
    public static void main(String[] args) {
        permuteString("", "12", "31", 26);
    }

    public static void permuteString(
        String beginningString,
        String endingString, String second, int result
    ) {
        if (endingString.length() <= 1) {
            permuteString2("", second, Long.valueOf(beginningString + endingString), result);
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    permuteString(beginningString + endingString.charAt(i), newString, second,
                        result);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void permuteString2(
        String beginningString,
        String endingString,
        long first, int result
    ) {
        if (endingString.length() <= 1) {
            long sum = Long.valueOf(beginningString + endingString) + first;

            if(sum == result) {
                System.out.println("YES: " + Long.valueOf(beginningString + endingString) + " " + first);
            } else {
                System.out.println("NO: " + Long.valueOf(beginningString + endingString) + " " + first);
            }

        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    permuteString2(beginningString + endingString.charAt(i), newString, first,
                        result);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
