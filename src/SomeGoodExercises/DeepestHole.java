package SomeGoodExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeepestHole {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int _max = 0;
        int[][] arr = new int[n][2];
        int[] road = new int[10];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 10; ++i) {
            road[i] = 0;
        }
        for (int i = 0; i < n; ++i) {
            road[arr[i][0]]++;
            road[arr[i][1] + 1]--;
        }
        res.add(road[0]);
        for (int i = 1; i < 10; ++i) {
            int temp = road[i] + res.get(i - 1);
            res.add(temp);
        }
        for (int i = 0; i < 10; ++i) {
            if (res.get(i) > _max) {
                _max = res.get(i);
            }
        }
        System.out.println(_max);
    }
}
