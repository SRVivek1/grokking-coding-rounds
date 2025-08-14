package com.srvivek.jumpgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    private final JumpGame jumpGame = new JumpGame();

    @Test
    void testCanJumpSol1() {
        // Test cases for the forward-moving greedy algorithm

        // 1. Standard cases where jump is possible
        assertTrue(jumpGame.canJumpSol1(new int[]{2, 3, 1, 1, 4}));
        assertTrue(jumpGame.canJumpSol1(new int[]{2, 0, 0}));
        assertTrue(jumpGame.canJumpSol1(new int[]{0}));
        assertTrue(jumpGame.canJumpSol1(new int[]{1, 1, 1, 1}));
        assertTrue(jumpGame.canJumpSol1(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));

        // 2. Standard cases where jump is not possible
        assertFalse(jumpGame.canJumpSol1(new int[]{3, 2, 1, 0, 4}));
        assertFalse(jumpGame.canJumpSol1(new int[]{1, 1, 0, 1}));

        // 3. Edge cases
        assertFalse(jumpGame.canJumpSol1(new int[]{})); // Empty array
        assertTrue(jumpGame.canJumpSol1(new int[]{0})); // Single element array
        assertTrue(jumpGame.canJumpSol1(new int[]{5})); // Single element with non-zero value
        assertFalse(jumpGame.canJumpSol1(new int[]{0, 1})); // Stuck at the beginning
        assertFalse(jumpGame.canJumpSol1(new int[]{1, 0, 1})); // Stuck at a zero
        assertFalse(jumpGame.canJumpSol1(new int[]{1, 2, 0, 0, 4})); // Stuck before the end
        assertFalse(jumpGame.canJumpSol1(null)); // Null array
    }

    @Test
    void testCanJumpSol2() {
        // Test cases for the backward-moving greedy algorithm

        // 1. Standard cases where jump is possible
        assertTrue(jumpGame.canJumpSol2(new int[]{2, 3, 1, 1, 4}));
        assertTrue(jumpGame.canJumpSol2(new int[]{2, 0, 0}));
        assertTrue(jumpGame.canJumpSol2(new int[]{0}));
        assertTrue(jumpGame.canJumpSol2(new int[]{1, 1, 1, 1}));
        assertTrue(jumpGame.canJumpSol2(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));

        // 2. Standard cases where jump is not possible
        assertFalse(jumpGame.canJumpSol2(new int[]{3, 2, 1, 0, 4}));
        assertFalse(jumpGame.canJumpSol2(new int[]{1, 1, 0, 1}));

        // 3. Edge cases
        assertFalse(jumpGame.canJumpSol2(new int[]{})); // Empty array (should be false)
        assertTrue(jumpGame.canJumpSol2(new int[]{0})); // Single element array
        assertTrue(jumpGame.canJumpSol2(new int[]{5})); // Single element with non-zero value
        assertFalse(jumpGame.canJumpSol2(new int[]{0, 1})); // Stuck at the beginning
        assertFalse(jumpGame.canJumpSol2(new int[]{1, 0, 1})); // Stuck at a zero
        assertFalse(jumpGame.canJumpSol2(new int[]{1, 2, 0, 0, 4})); // Stuck before the end
        assertFalse(jumpGame.canJumpSol2(null)); // Null array
    }
}