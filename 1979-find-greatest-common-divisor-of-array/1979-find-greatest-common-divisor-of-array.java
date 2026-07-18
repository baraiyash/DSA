import java.util.Arrays;

class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        int low = nums[0];
        int high = nums[nums.length - 1];

        return gcd(low, high);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}