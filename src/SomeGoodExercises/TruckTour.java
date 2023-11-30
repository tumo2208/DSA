package SomeGoodExercises;

import java.util.Scanner;

public class TruckTour {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[] petrol = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                arr[i][j] = sc.nextInt();
            }
            petrol[i] = arr[i][0] - arr[i][1];
        }
        int sumPetrol = 0;
        int res = 0;
        int i = 0;
        while (i < n) {
            sumPetrol += petrol[i];
            if (sumPetrol < 0) {
                res = i + 1;
                sumPetrol = 0;
            }
            i++;
        }
        System.out.println(res);
    }
}
