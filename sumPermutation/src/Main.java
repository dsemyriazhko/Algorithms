import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static Boolean result = false;
    public static Long x = Long.MAX_VALUE;
    public static Long y = Long.MAX_VALUE;

    public static void main(String[] args) {
        String a = "";
        String b = "";
        long c = 0;

        try (Scanner scanner = new Scanner(Paths.get("INPUT.TXT"))) {
            scanner.useDelimiter("\\s");
            a = scanner.next();
            b = scanner.next();
            c = scanner.nextLong();
        } catch (Exception e) {
            System.out.println("Exception while reading input " + e.getMessage());
            e.printStackTrace();
        }

        permuteString("", a, b, c);

        try(PrintWriter printWriter = new PrintWriter("OUTPUT.TXT")) {
            printWriter.println(result ? "YES" : "NO");
            if (result)
                printWriter.println(x + " " + y);
        } catch (Exception e) {
            System.out.println("Exception while writing output " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void permuteString(
            String beginningString,
            String endingString,
            String second,
            long result
    ) {
        if (endingString.length() <= 1) {
            final Long first = Long.valueOf(beginningString + endingString);
            if (first <= result && first < x) {
                System.out.println("first: " + first);
                permuteString2("", second, first, result);
            }
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    final String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    permuteString(
                            beginningString + endingString.charAt(i),
                            newString,
                            second,
                            result
                    );
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void permuteString2(
            String beginningString,
            String endingString,
            long first,
            long result
    ) {
        if (endingString.length() <= 1) {
            Long second = Long.valueOf(beginningString + endingString);
            if (second <= result) {
                System.out.println("second: " + second);
                final long sum = first + second;

                if (sum == result) {
                    Main.result = true;
                    x = first;
                    y = second;
                }
            }
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    final String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    permuteString2(
                            beginningString + endingString.charAt(i),
                            newString,
                            first,
                            result);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}