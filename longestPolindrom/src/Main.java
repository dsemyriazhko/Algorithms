public class Main {
    public static void main(String[] args) {
        String input = "bacaba";

        char[] arr = input.toCharArray();

        int left = -1;
        int max = 0;
        int counter = 0;
        String strMax = null;

        for (int i = 0; i < arr.length; i++) {
            if (left >= 0 && arr[left - (i - left)] == arr[i]) {
                counter++;
            }

            if(left >= 0) {
                if (arr[left - (i - left)] != arr[i]) {
                    if (counter > max) {
                        max = counter;
                        strMax = input.substring(left - (i - left)+1, i);
                    }

                    left=-1;
                    counter=0;
                }
                if (i == arr.length-1) {
                    if (counter > max) {
                        max = counter;
                        strMax = input.substring(left - (i - left), i+1);
                    }

                    left=-1;
                    counter=0;
                }
            }

            if (i + 2 < arr.length && arr[i] == arr[i + 2]) {
                left = i + 1;
                i++;
            }
        }

        System.out.println("Result: " + strMax);
        System.out.println("Max: " + max);
    }
}
