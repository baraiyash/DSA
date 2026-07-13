import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";

        // length of numbers (2 to 9 digits)
        for (int len = 2; len <= 9; len++) {
            for (int i = 0; i + len <= 9; i++) {
                String sub = digits.substring(i, i + len);
                int num = Integer.parseInt(sub);

                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}