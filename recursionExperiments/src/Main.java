public class Main {
    public static void main(String[] args) {
//        System.out.println(fact(4));
//        System.out.println(next(5));
        System.out.println(isPrime(11, 2));
    }

    public static Boolean isPrime(int n, int i) {
        if (n % i == 0)
            return false;
        if (i >= Math.sqrt(n))
            return true;

        return isPrime(n, i+1);
    }

    public static String next(int n) {
        if (n == 0)
            return "";

        return next(n-1) + " " + n;
    }

    public static int fact(int n) {
        if (n == 1)
            return 1;

        return fact(n-1) * n;
    }
}
