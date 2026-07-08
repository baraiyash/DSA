class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        long[] val = new long[n + 1];        // val[i] = concatenated nonzero digits of s[0..i-1], mod p
        int[] count = new int[n + 1];        // count[i] = number of nonzero digits in s[0..i-1]
        long[] sumPrefix = new long[n + 1];  // sumPrefix[i] = sum of digits in s[0..i-1]
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = pow10[i - 1] * 10 % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                val[i + 1] = (val[i] * 10 + d) % MOD;
                count[i + 1] = count[i] + 1;
                sumPrefix[i + 1] = sumPrefix[i] + d;
            } else {
                val[i + 1] = val[i];
                count[i + 1] = count[i];
                sumPrefix[i + 1] = sumPrefix[i];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];

            int k = count[r + 1] - count[l]; // number of nonzero digits in [l, r]
            long xmod;
            if (k == 0) {
                xmod = 0;
            } else {
                xmod = ((val[r + 1] - val[l] * pow10[k] % MOD) % MOD + MOD) % MOD;
            }

            long sum = sumPrefix[r + 1] - sumPrefix[l];
            long sumMod = sum % MOD;

            ans[i] = (int) ((xmod * sumMod) % MOD);
        }

        return ans;
    }
}