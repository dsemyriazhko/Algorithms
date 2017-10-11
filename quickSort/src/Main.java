public class Main {
    public static void main(String[] args) {
        int[] array = {4, 2, 6, 1, 5, 8, 7, 3, 9};

        quickSort(array, 0, array.length-1);

        for (int i : array) {
            System.out.print(i + ", ");
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[right];
        int partition = partitionIt(array, left, right, pivot);

        quickSort(array, left, partition-1);
        quickSort(array, partition+1, right);
    }

    private static int partitionIt(int[] array, int left, int right, int pivot) {
        int leftPtr = left-1;
        int rightPrt = right;

        while (true) {
            while (array[++leftPtr] < pivot);
            while (rightPrt > 0 && array[--rightPrt] > pivot);

            if (leftPtr >= rightPrt) {
                break;
            }

            swap(array, leftPtr, rightPrt);
        }

        swap(array, leftPtr, right);

        return leftPtr;
    }

    private static void swap(int[] array, int leftPtr, int rightPrt) {
        int temp = array[leftPtr];
        array[leftPtr] = array[rightPrt];
        array[rightPrt] = temp;
    }
}
