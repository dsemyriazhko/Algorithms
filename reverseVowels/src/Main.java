public class Main {

    public static void main(String[] args) {
	    System.out.println(reverseVowels("hello"));
	    System.out.println("holle");
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int leftPtr = -1;
        int rightPtr = arr.length;

        while(true) {
            for(leftPtr=leftPtr+1; leftPtr<arr.length && "aeiou".indexOf(arr[leftPtr]) < 0; leftPtr++) {}
            for(rightPtr=rightPtr-1; rightPtr>0 && "aeiou".indexOf(arr[rightPtr]) < 0; rightPtr--) {}

            if(leftPtr>=rightPtr) {
                return new String(arr);
            }

            swap(arr, leftPtr, rightPtr);
        }
    }

    private static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
