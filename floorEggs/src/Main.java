public class Main {
    public static void main(String[] args) {
        System.out.println(getMinFloors(4, 2));
    }

    private static int getMinFloors(int floors, int eggs) {
        System.out.println(floors + ", " + eggs);
        if (floors == 1 || floors == 0 || eggs == 1) {
            return floors;
        }

        int min = Integer.MAX_VALUE;

        for (int p = 1; p <= floors; p++) {
            int temp = Math.max(getMinFloors(p-1, eggs), getMinFloors(floors-p, eggs));

            if (temp < min) {
                min = temp;
            }
        }

        System.out.println("min: " + min);
        return min + 1;
    }
}
