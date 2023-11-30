package SomeGoodExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleArea {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int i = 0;
        int peek = 0;
        int topArea = 0;
        int res = 0;
        List<Integer> arr = new ArrayList<>();
        for (i = 0; i < n; ++i) {
            arr.add(sc.nextInt());
        }
        i = 0;
        Stack<Integer> st = new Stack<>();
        while(i < n) {
            if (st.isEmpty() || arr.get(st.peek()) < arr.get(i)) {
                st.push(i++);
            } else {
                peek = st.pop();
                topArea = arr.get(peek) * (st.isEmpty() ? i : i - st.peek() - 1);
                if (topArea > res) {
                    res = topArea;
                }
            }
        }
        while (!st.isEmpty()) {
            peek = st.pop();
            topArea = arr.get(peek) * (st.isEmpty() ? i : i - st.peek() - 1);
            if (topArea > res) {
                res = topArea;
            }
        }
        System.out.println(res);
    }
}
