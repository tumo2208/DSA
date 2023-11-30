package SomeGoodExercises;

import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants {
    public static class Plant {
        public int poison;
        public int day; //Days survive. 0 means always 1 means the plant will die after day 1

        public Plant(int poison, int day) {
            this.poison = poison;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] poison = new int[n];

        for (int i = 0; i < n; i++) {
            poison[i] = sc.nextInt();
        }

        Stack<Plant> stack = new Stack<>();
        int max = 0;

        // Plant 0 will always survive
        stack.push(new Plant(poison[0], 0));

        for (int i = 1; i < n; i++) {

            if (stack.isEmpty()) {
                stack.push(new Plant(poison[i], 0));
            } else if (stack.peek().poison < poison[i]) {
                // plant i will be dead in first day
                stack.push(new Plant(poison[i], 1));
                max = Math.max(max, 1);
            } else {
                // Days until i is killed
                int maxDaysUntilSurvived = 0;

                while (!stack.isEmpty() && stack.peek().poison >= poison[i]) {
                    // stack.peek().poison >= poison[i]
                    // So plants which are located left of i and have more poison then
                    // i'th plant will not have any effect to the plants which are located right of i.
                    // We pop these plants and remember the maximum of the day when these
                    // plants are dead
                    // i must have survive until this day and might be killed next day

                    maxDaysUntilSurvived = Math.max(maxDaysUntilSurvived, stack.pop().day);
                }

                if(stack.isEmpty()) {
                    // No more plants located left to i which can kill i ( have more poison than i)
                    stack.push(new Plant(poison[i], 0));
                } else {
                    // i'th plant is killed by the plant top of the stack and it will be killed
                    // one day after all the plant between i'th plant and plant currently top of the stack
                    stack.push(new Plant(poison[i], maxDaysUntilSurvived + 1));

                    // What is the max of all such days
                    max = Math.max(max, maxDaysUntilSurvived + 1);
                }
            }
        }

        System.out.println(max);
    }
}