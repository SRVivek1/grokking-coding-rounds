package com.srvivek.jumpgame;

import java.util.Arrays;

public class JumpGame {

    /**
     * This algo starts from last index and checks if we can there's any index + value combination >= target index value.
     * If yes change target index to current index and now resolve the same problem from current index.
     * @param arr
     * @return
     */
    public boolean canJumpSol2(int[] arr) {

        // we can not iterate null or empty array
        if(arr == null || arr.length == 0) return false;

        int goal = arr.length - 1;

        // check if we can reach to last index from 2nd last index to 0th index
        for(int i = arr.length - 2; i >= 0; i--) {
            // calculate jump from 2nd last index
            int jump = i + arr[i];
            if(jump >= goal) {
                // Greedy algo - now consider current index as goal and check if it's reachable
                goal = i;
            }
        }

        // if goal is 0 means we reach 0th index and hence true.
        return goal == 0;
    }


    /**
     * This implementation starts from 0 index and checks we we cna reach to last index which is array length - 1.
     *
     * @param arr
     * @return
     */
    public boolean canJumpSol1(int[] arr) {
        if(arr == null || arr.length == 0) return false;

        int maxReachable = 0;

        for(int i = 0 ; i < arr.length; i++) {
            if(i > maxReachable) return false;

            maxReachable = Math.max(maxReachable, i + arr[i]);

            if(maxReachable >= arr.length - 1) return true;
        }

        return true;
    }
}