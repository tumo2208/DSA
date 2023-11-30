package SomeGoodExercises;

import java.io.*;
import java.util.*;

public class CastleOnTheGrid {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static int minimumMoves(List<String> arr, int startX, int startY, int goalX, int goalY) {
        Queue<Integer> xPos = new ArrayDeque<>();
        Queue<Integer> yPos = new ArrayDeque<>();
        Queue<Integer> counterQ = new ArrayDeque<>();
        boolean[][] visit = new boolean[arr.size()][arr.size()];
        for (int i = 0; i < arr.size(); ++i) {
            for (int j = 0; j < arr.size(); ++j) {
                visit[i][j] = false;
            }
        }
        xPos.add(startX);
        yPos.add(startY);
        counterQ.add(0);
        int[] xMove = {0, 0, 1, -1};
        int[] yMove = {1, -1, 0, 0};
        while (!xPos.isEmpty()) {
            int x = xPos.remove();
            int y = yPos.remove();
            int count = counterQ.remove();
            count++;
            for (int i = 0; i < 4; ++i) {
                int xNew = x;
                int yNew = y;
                while (true) {
                    xNew += xMove[i];
                    yNew += yMove[i];
                    if (xNew < 0 || xNew >= arr.size() ||
                    yNew <0 || yNew >= arr.size() ||
                    arr.get(xNew).charAt(yNew) == 'X') {
                        break;
                    } else {
                        if (xNew == goalX && yNew == goalY) {
                            return count;
                        }
                        if (!visit[xNew][yNew]) {
                            visit[xNew][yNew] = true;
                            xPos.add(xNew);
                            yPos.add(yNew);
                            counterQ.add(count);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        int n = SCANNER.nextInt();

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String gridItem = SCANNER.next();
            grid.add(gridItem);
        }

        int startX = SCANNER.nextInt();

        int startY = SCANNER.nextInt();

        int goalX = SCANNER.nextInt();

        int goalY = SCANNER.nextInt();

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println(result);
    }
}
