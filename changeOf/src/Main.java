public class Main {
    public static void main(String[] arg) {
        int changeOf = 10;

        int[] values = {1, 3, 7};

//        for (int i=0; i<values.length; i++) {
//            int n = values[i] + get(changeOf-values[i], values);
//        }
    }

    public static int get(int changeOf, int[] values, StringBuilder result) {

        if (changeOf <= 0)
            return 0;

        for (int i=0; i<values.length; i++) {
            int n = values[i] + get(changeOf-values[i], values, result);
        }


    }
}
