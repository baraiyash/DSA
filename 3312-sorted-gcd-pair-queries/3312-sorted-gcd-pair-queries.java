class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] exact = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long cnt = 0;

            for (int m = g; m <= max; m += g)
                cnt += freq[m];

            long pairs = cnt * (cnt - 1) / 2;

            for (int m = g * 2; m <= max; m += g)
                pairs -= exact[m];

            exact[g] = pairs;
        }

        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++)
            prefix[i] = prefix[i - 1] + exact[i];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;

            int lo = 1;
            int hi = max;

            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (prefix[mid] >= target)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            ans[i] = lo;
        }

        return ans;
    }
}