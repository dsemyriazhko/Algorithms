public class MainDP {
    public static void main(String[] arg) {
        int changeOf = 10;
        int[] values = {1, 2, 11};

        int[] resultArr = new int[changeOf+1];

        for (int i = 1; i<=changeOf; i++) {
            resultArr[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i<=changeOf; i++) {
            for (int j = 0; j<values.length; j++) {
                if (values[j] <= i) {
                    int temp = resultArr[i - values[j]];
                    if (temp != Integer.MAX_VALUE && temp+1 < resultArr[i]) {
                        resultArr[i] = temp+1;
                    }
                }
            }
        }

        System.out.println("result: " + resultArr[changeOf]);
    }
}
