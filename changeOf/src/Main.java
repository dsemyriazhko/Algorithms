public class Main {
    public static void main(String[] arg) {
        int changeOf = 10;
        int[] values = {1, 3, 7};

        getCharge(changeOf, values, "");
    }

    public static void getCharge(int changeOf, int[] values, String result) {
        if (changeOf == 0) {
            System.out.println(result);
            return;
        }
        if (changeOf <= 0) {
            return;
        }

        for (int i=0; i<values.length; i++) {
            getCharge(changeOf-values[i], values, result + values[i] + ", ");
        }

        return;
    }
}
