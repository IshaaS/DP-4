// https://leetcode.com/problems/maximal-square/

// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// start from bottom right, 
// for each element ==1 check if right, diagonal buttom, buttom has a square made out of it, if yes, take min 
// add 1 cause that much big sqaure can be made for current 1.

// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n=matrix[0].length;
//         int result =0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]=='1') {
//                     boolean flag = true;
//         int len = 1;
//         while(i+len <m && j+len<n && flag){
//             //column left
//             for(int k =i+len; k>=i;k--){
//                 if(matrix[k][j+len]=='0'){
//                     flag=false;
//                     break;
//                 }
//             }
//             //row up
//             for(int k =j+len; k>=j;k--){
//                 if(matrix[i+len][k]=='0'){
//                     flag=false;
//                     break;
//                 }
//             }
//             if(flag) len++;
//         }
//         result = Math.max(result,len);
//                 }
//             }
//         }
//         return result*result;
//     }
// }

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n=matrix[0].length;
        int result =0;
        int [] dp = new int[n+1];
        for(int i=m-1;i>=0;i--){
            int diagDown=0;
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1') {
                    int temp = dp[j];
                    dp[j]=1+Math.min(dp[j+1],Math.min(dp[j], diagDown));
                    diagDown=temp;
                    result = Math.max(result,dp[j]);
                } else dp[j]= 0;
            }
        }
        return result*result;
    }
}