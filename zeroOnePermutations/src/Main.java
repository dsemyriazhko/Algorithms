public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 7;

        int result = findZeroOnesStringsWithNumberOfZeroes(a, b);

        System.out.println(result);
    }

    private static int findZeroOnesStringsWithNumberOfZeroes(int a, int b) {
        if (a - b > 1) {
            return 0;
        }

        if (a == 0) {
            return 1;
        }

        return findZeroOnesStringsWithNumberOfZeroes(a-1, b-1) + findZeroOnesStringsWithNumberOfZeroes(a, b-1);
    }
}
