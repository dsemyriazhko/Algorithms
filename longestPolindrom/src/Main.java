public class Main {
    public static void main(String[] args) {
        String input = "dcbanabc";

        char[] arr = input.toCharArray();

        int left = -1;
        int max = 0;
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (left >= 0 && arr[left - (left - i)] == arr[i]) {
                counter++;
            } else {
                left = -1;
            }

            if (i + 2 < arr.length && arr[i] == arr[i + 2]) {
                left = i + 1;
                i++;
            }

            if (counter > max) {
                max = counter;
            }
        }

        System.out.println("Max: " + max);
    }
}
