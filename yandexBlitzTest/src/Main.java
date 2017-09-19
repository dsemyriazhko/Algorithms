import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ZERO;

        try (Scanner scanner = new Scanner(Paths.get("input.txt"))) {
            scanner.useDelimiter("\\s");
            a = scanner.nextBigInteger();
            b = scanner.nextBigInteger();
        } catch (Exception e) {
            System.out.println("Exception while reading input " + e.getMessage());
        }

        BigInteger sum = a.add(b);

        try(PrintWriter printWriter = new PrintWriter("output.txt")) {
            printWriter.println(sum.toString());
        } catch (Exception e) {
            System.out.println("Exception while writing output " + e.getMessage());
            e.printStackTrace();
        }

        return;
    }
}



//        List<String> lines = Arrays.asList(sum.toString());
//
//        try {
//            Files.write(Paths.get("output.txt"), lines);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }