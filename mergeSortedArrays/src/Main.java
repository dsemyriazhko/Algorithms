public class Main {
    public static void main(String[] args) {
        Integer[] A = {1, 3, 5, 7, null, null, null};
        Integer[] B = {2, 4, 8};

        int k=A.length-B.length;
        for (int i=0; i<B.length; i++){
            A[k+i]=B[i];
        }

        Integer[] result = insertionSort(A, B);
        for (int i=0; i<result.length; i++){
            System.out.print(result[i]);
        }

        System.out.println();
    }

    public static Integer[] insertionSort(Integer[] a, Integer[] b)
    {
        Integer in, out;
        for(out=a.length-b.length-1; out<a.length; out++)
        {
            Integer temp = a[out];
            in = out;
            while(in>0 && a[in-1] >= temp)
            {
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }

        return a;
    }

}
