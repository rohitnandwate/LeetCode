package com.rhn.algorithms;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if ((height == null) || (height.length == 0)) return 0;
        final int N = height.length;
        int[] s = new int[N + 1];
        int i, top = 0, hi, area = 0;
        s[0] = -1;
        for (i = 0; i < N; i++) {
            hi = height[i];
            while ((top > 0) && (height[s[top]] > hi)) {
                area = Math.max(area, height[s[top]] * (i - s[top - 1] - 1));
                top--;
            }
            s[++top] = i;
        }
        while (top > 0) {
            area = Math.max(area, height[s[top]] * (N - s[top -1] - 1));
            top--;
        }
        return area;
    }
}
