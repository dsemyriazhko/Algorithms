import java.math.BigInteger;
import java.util.Scanner;

public class Main_ReadFromTerminal {
    public static void main(String[] args) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ZERO;

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useDelimiter("\\s");
            a = scanner.nextBigInteger();
            b = scanner.nextBigInteger();
            scanner.close();
        } catch (Exception e) {
            System.out.println("Exception while reading input " + e.getMessage());
        }

        System.out.println(a.add(b));
        return;
    }
}
