import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        HashSet<Integer> set = new HashSet<>();

        // Find min, max and store elements in HashSet
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        // Check every number in the range
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}