class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
            right[n-i-1] = Math.max(right[n-i], height[n-i]);
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            int h = Math.min(left[i], right[i]) - height[i];
            if (h < 0) {
                h = 0;
            }
            result += h;
        }
        return result;
    }
}