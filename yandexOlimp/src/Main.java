import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        final Queue<Long> cards = new LinkedList<>();
        long count = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useDelimiter(System.lineSeparator());
            count = scanner.nextInt();

            scanner.useDelimiter("\\s");
            for (int i = 0; i<count; i++) {
                long card = scanner.nextLong();
                cards.add(card);
            }
        } catch (Exception e) {
            System.out.println("Exception while reading input " + e.getMessage());
        }

        final Stack<Long> petya = new Stack<>();
        final Stack<Long> vasya = new Stack<>();

        petya.push(cards.remove());
        vasya.push(cards.remove());

        while (!cards.isEmpty()){
            if (petya.peek() < vasya.peek()) {
                petya.push(cards.remove());
            } else {
                vasya.push(cards.remove());
            }
        }

        if (sum(petya) > sum(vasya)) {
            System.out.println("Petya");
        } else {
            System.out.println("Vasya");
        }

//        try(PrintWriter printWriter = new PrintWriter("output.txt")) {
//            if (sum(petya) > sum(vasya)) {
//                printWriter.print("Petya");
//            } else {
//                printWriter.print("Vasya");
//            }
//        } catch (Exception e) {
//            System.out.println("Exception while writing output " + e.getMessage());
//            e.printStackTrace();
//        }
    }

    private static int sum(Stack<Long> c) {
        int sum = 0;

        while (!c.isEmpty()) {
            sum += c.pop();
        }

        return sum;
    }
}
