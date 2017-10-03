public class MainDP {
    public static void main(String[] args) {
        final String input = "anna"; //"severanna90";
        int n = input.length();

        int[][] table = new int[n][n];

        for (int i = 0; i<n; i++) {
            table[i][i] = 1;
        }

        for (int k=2; k<=n; k++) {
            for (int i = 0; i<n-k+1; i++) {
                int j = i+k-1;

                if (input.charAt(i) == input.charAt(j) && k == 2) {
                    table[i][j] = 2;
                } else if(input.charAt(i) == input.charAt(j)) {
                    table[i][j] = table[i+1][j-1] + 2;
                } else {
                    table[i][j] = Math.max(table[i][j-1], table[i+1][j]);
                }
            }
        }

        System.out.println(table[0][n-1]);
    }
}
