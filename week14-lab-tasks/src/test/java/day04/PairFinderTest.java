package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {
    @Test
    void pairTest(){
        int[] testArr={5, 1, 4, 5};
        int[] testArr1={7, 1, 5, 7, 3, 3, 5, 7, 6, 7};

        assertEquals(1,new PairFinder().findPairs(testArr));
        assertEquals(4,new PairFinder().findPairs(testArr1));
    }
}