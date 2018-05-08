import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the climbingLeaderboard function below.
     */
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        List<Integer> rankScores = distinctScores(scores);

        List<Integer> result = new ArrayList<>(alice.length);
        int j=rankScores.size()-1;

        for (int i=0; i<alice.length; i++) {
            for (;j>=0;) {
                if (rankScores.get(j) > alice[i]) {
                    final int rank = j + 1;
                    result.add(rank + 1);
                    break;
                }
                if (rankScores.get(j) == alice[i]) {
                    final int rank = j + 1;
                    result.add(rank);
                    break;
                }
                else {
                    j--;
                }
            }

            if (j < 0) {
                result.add(1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static List<Integer> distinctScores(int[] scores) {
        List<Integer> rankScores = new ArrayList<>();

        for (int i=0; i<scores.length; i++) {
            if (i>0 && scores[i-1] == scores[i]) {
                continue;
            }

            rankScores.add(scores[i]);
        }
        return rankScores;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int scoresCount = Integer.parseInt(scanner.nextLine().trim());

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");

        for (int scoresItr = 0; scoresItr < scoresCount; scoresItr++) {
            int scoresItem = Integer.parseInt(scoresItems[scoresItr].trim());
            scores[scoresItr] = scoresItem;
        }

        int aliceCount = Integer.parseInt(scanner.nextLine().trim());

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

        for (int aliceItr = 0; aliceItr < aliceCount; aliceItr++) {
            int aliceItem = Integer.parseInt(aliceItems[aliceItr].trim());
            alice[aliceItr] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.print("\n");
            }
        }

        System.out.println();
    }
}
