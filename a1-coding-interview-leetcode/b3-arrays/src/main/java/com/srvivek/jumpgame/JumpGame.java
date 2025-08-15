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
     * Determines if it's possible to reach the last index of the array by jumping.
     * <br/>
     * This greedy algorithm iterates forward from the start of the array,
     * tracking the farthest index that can be reached at any given point.
     *
     * @param arr The array where each element represents the maximum jump length.
     * @return {@code true} if the last index is reachable, {@code false} otherwise.
     */
    public boolean canJumpSol1(int[] arr) {
        // Edge case: A null or empty array is considered un-jumpable.
        // Note:, a single-element array is always reachable.
        if (arr == null || arr.length == 0) {
            return false;
        }

        // `maxReachable` stores the farthest index we can currently reach.
        int maxReachable = 0;

        for (int i = 0; i < arr.length; i++) {
            // If the current index `i` is beyond what we can reach,
            // it means we're stuck and cannot proceed.
            if (i > maxReachable) {
                return false;
            }

            // Update the farthest reachable index. We take the maximum
            // of the current `maxReachable` and the new potential reach
            // from our current position (`i + arr[i]`).
            maxReachable = Math.max(maxReachable, i + arr[i]);

            // If the farthest reachable index is at or past the end of the array,
            // we've found a valid path.
            if (maxReachable >= arr.length - 1) {
                return true;
            }
        }

        // If the loop completes without reaching the last index,
        // it means a path does not exist.
        return false;
    }
}