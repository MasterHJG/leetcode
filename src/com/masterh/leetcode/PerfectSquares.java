package com.masterh.leetcode;

import java.util.Arrays;

public class PerfectSquares {
    /**
     * 四平方和定理
     * 任意一个正整数均可表示为4个整数的平方和
     * 也就是返回结果为1、2、3、4
     * 首先将数字化简一下，可以把因子4去掉，并不影响结果
     *
     */
    public int numSquares(int n) {
        while(n%4==0)
            n/=4;
        //该判断可以证明
        if(n%8==7)
            return 4;
        for(int i=0;i*i<=n;i++) {
            int j=(int) Math.sqrt(n-i*i);
            if(i*i+j*j==n)
                return i==0||j==0?1:2;
        }
        return 3;
    }

    /**
     * dp[i]代表组成的i的最少平方数的个数
     * 状态转移方程：dp[x+y*y]=min(dp[x+y*y],dp[x]+1)
     * @param n
     * @return
     */
    public int numSquares_1(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=1;i*i<=n;i++)
            dp[i*i]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;i+j*j<=n;j++){
                dp[i+j*j]=Math.min(dp[i+j*j],dp[i]+1);
            }
        }
        return dp[n];
    }
}
