// https://leetcode.com/problems/partition-array-for-maximum-sum/

// Time Complexity : O(n*k)
// Space Complexity : o (n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// To get the best sum ending at i, you can try:

//      A partition of size 1 ending at i
//      A partition of size 2 ending at i
//      ... so on
//         A partition of size up to k ending at i (as long as it fits)
// For each partition, you find the maximum element and compute:

//       max value * size of partition + best sum before this partition
//You pick the best among all these options for dp[i]


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int [] dp = new int [arr.length];
        for(int i=0;i<arr.length;i++){
            int max = arr[i];
            for(int j=1;j<=k && i-j+1>=0; j++){
                max=Math.max(arr[i-j+1],max);
                if(i-j>=0) dp[i]=Math.max(dp[i], j*max + dp[i-j]);
                else dp[i]=Math.max(dp[i], j*max);
            }
        }
        return dp[arr.length-1];
    }
}