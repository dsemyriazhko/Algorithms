public class Main {
    public static void main(String[] args) {
//        int[] temp = {5, -2, 3, 8, 6};
        int[] temp = {-1, 8, -9, 12, 3};

        int left = 0;
        int right = temp.length-1;

        int winterMax = temp[left++];
        int summerMin = temp[right--];

        while (left<right) {
            while (temp[left] <= winterMax)
                left++;
            while (temp[right] >= summerMin)
                right--;

            if (temp[left] >= summerMin)
                left++;

            if (temp[right] <= winterMax)
                right--;
        }

        System.out.println("Answer: " + (left-1));
    }
}
