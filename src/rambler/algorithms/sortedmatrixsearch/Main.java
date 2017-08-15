package rambler.algorithms.sortedmatrixsearch;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static class Clip {
        private int left;
        private int right;
        private int top;
        private int bottom;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateSortedMatrix(3, 3);
        int searchedElement = inputSearchedElement();

        //проверка на экстремумы
        if(searchedElement < matrix[0][0] || matrix[matrix.length-1][matrix[matrix.length-1].length-1] < searchedElement) {
            System.out.println("Not found");
            return;
        }

	    Clip clip = trimByRange(matrix, searchedElement);
        if (clip == null) {
            System.out.println("Not found");
            return;
        }

	    for (int i=clip.getTop(); i<=clip.getBottom(); i++){
	        int j = binarySearch(matrix[i], clip.getLeft(), clip.getRight(), searchedElement);

	        if (j>=0){
	            System.out.println("Find the element " + searchedElement + " in: " + i + ", " + j);
	            break;
            }
        }
    }

    private static int binarySearch(int[] array, int left, int right, int element) {
        int middle = (left+right)/2;

        if (array[middle] == element) {
            return middle;
        }

        if (left>=right) {
            return -1;
        }

        if (element < array[middle]){
            return binarySearch(array, left, middle-1, element);
        }

        return binarySearch(array, middle+1, right, element);
    }

    private static Clip trimByRange(int[][] matrix, int element) {
        Clip result = new Clip();
        for (int i=0; i<matrix[0].length && (element < matrix[0][i] || matrix[matrix.length-1][i] < element); i++){
            result.setLeft(i+1);
        }

        result.setRight(matrix[0].length-1);
        for (int i=matrix[0].length-1; i>0 && (element < matrix[0][i] || matrix[matrix.length-1][i] < element); i--){
            result.setRight(i);
        }

        if (result.getLeft() > result.getRight())
            return null;

        for (int i=0; i<matrix.length && (element < matrix[i][result.getLeft()] || matrix[i][result.getRight()] < element); i++){
            result.setTop(i+1);
        }

        result.setBottom(matrix.length-1);
        for (int i=matrix.length-1; i>0 && (element < matrix[i][result.getLeft()] || matrix[i][result.getRight()] < element); i--){
            result.setBottom(i);
        }

        return result;
    }

    private static int[][] generateSortedMatrix(int m, int n) {
//        int[][] matrix = new int[m][n];
//
//        Random generator = new Random();
//        for (int i=0; i<m; i++){
//            for (int j=0; j<n; j++) {
//                matrix[i][j] = generator.nextInt(10) + 10 * j + 100 * i;
//                System.out.print(matrix[i][j] + "\t");
//            }
//            System.out.println();
//        }

        int[][] ints = new int[2][2];

        ints[0][0]=1;
        ints[0][1]=4;
        ints[1][0]=2;
        ints[1][1]=5;
//        ints[0][2]=3;
//        ints[0][3]=13;
//
//        ints[1][0]=4;
//        ints[1][1]=5;
//        ints[1][2]=6;
//        ints[1][3]=14;
//
//        ints[2][0]=7;
//        ints[2][1]=8;
//        ints[2][2]=9;
//        ints[2][3]=15;
//
//        ints[3][0]=10;
//        ints[3][1]=11;
//        ints[3][2]=12;
//        ints[3][3]=16;

        return ints;
    }

    private static int inputSearchedElement() {
        System.out.print("Enter search element: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
