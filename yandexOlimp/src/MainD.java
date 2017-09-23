import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class MainD {
    public static void main(String[] args) {
        int count = 0;
        long[] input = new long[0];
        long answer = 0;

        try (Scanner scanner = new Scanner(Paths.get("input.txt"))) {
            scanner.useDelimiter(System.lineSeparator());
            count = scanner.nextInt();

            input = new long[count];
            scanner.useDelimiter("\\s");
            for (int i = 0; i<count; i++) {
                input[i] = scanner.nextLong();
            }

            scanner.useDelimiter(System.lineSeparator());
            answer = scanner.nextLong();
        } catch (Exception e) {
            System.out.println("Exception while reading input " + e.getMessage());
        }

        if(check(input, 0, new LinkedList<>(), answer)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean check(long[] input, int index, LinkedList<Long> result, long answer) {
        if (index >= input.length) {
            return sum(result) == answer;
        }

        LinkedList list = new LinkedList(result);
        list.add(input[index]);
        if (check(input, index+1, list, answer)) {
            return true;
        }

        for (int i = index-1; i>=0; i--) {
            list = new LinkedList(result);
            list.add(input[index] - input[i]);
            if (check(input, index+1, list, answer)) {
                return true;
            }
        }

        long el = input[index];
        for (int i = index-1; i>=0; i--) {
            list = new LinkedList(result);
            el -= input[i];
            list.add(el);
            if (check(input, index+1, list, answer)) {
                return true;
            }
        }

        return false;
    }

    private static long sum(LinkedList<Long> list) {
        long sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum;
    }
}
