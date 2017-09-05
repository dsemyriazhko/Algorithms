public class Main {
    private static int[][] maze = {{0,0,0},{1,0,1},{1,0,0}};
    private static int allStepCount = 6;
    private static int recursiveCount = 0;

    public static void main(String[] args) {
        System.out.print(getPathCount(0, 0, 0));
    }

    public static int getPathCount(int line, int column, int step) {
        System.out.println(++recursiveCount + ": " + line + " " + column + " " + step);

        if (isOutOfMaze(line) || isOutOfMaze(column) || step > allStepCount || maze[line][column] == 1) {
            return 0;
        }
        if (isEndOfMaze(line, column) && step == allStepCount) {
            return 1;
        }

        ++step;

        return getPathCount(line+1, column, step) +
                getPathCount(line, column+1, step) +
                getPathCount(line-1, column, step) +
                getPathCount(line, column-1, step);
    }

    private static boolean isEndOfMaze(int line, int column) {
        return line == maze.length - 1 && column == maze.length - 1;
    }

    private static boolean isOutOfMaze(int point) {
        return point >= maze.length || point < 0;
    }
}
