import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YahtzeeUpperSectionScoringTests {

    @Test
    public void performRolls_BasicTest() {
        YahtzeeUpperSectionScoring scoring = new YahtzeeUpperSectionScoring();

        int[] result = scoring.performRolls();

        for(int i = 0; i < result.length; i++) {
            // Rolls are random, so just make sure they're in range
            assertTrue(result[i] > 0 && result[i] < 7);
        }
    }

    @Test
    public void getNumberRollCounts_BasicTest() {
        YahtzeeUpperSectionScoring scoring = new YahtzeeUpperSectionScoring();
        int[] dice = { 1, 2, 6, 6, 1, 3 };

        int[] rollCount = scoring.getNumberRollCounts(dice);

        assertEquals(rollCount[0], 2);
        assertEquals(rollCount[1], 1);
        assertEquals(rollCount[2], 1);
        assertEquals(rollCount[3], 0);
        assertEquals(rollCount[4], 0);
        assertEquals(rollCount[5], 2);
    }

    @Test
    public void calculatePossibleScores_BasicTest() {
        YahtzeeUpperSectionScoring scoring = new YahtzeeUpperSectionScoring();
        int[] rollCount = { 2, 1, 1, 0, 0, 2 };

        int[] scores = scoring.calculatePossibleScores(rollCount);

        assertEquals(scores[0], 2);
        assertEquals(scores[1], 2);
        assertEquals(scores[2], 3);
        assertEquals(scores[3], 0);
        assertEquals(scores[4], 0);
        assertEquals(scores[5], 12);
    }

    @Test
    public void calculateMaxPossibleScore_BasicTest() {
        YahtzeeUpperSectionScoring scoring = new YahtzeeUpperSectionScoring();
        int[] scores = { 2, 2, 3, 0, 0, 12 };

        int highest = scoring.calculateMaxPossibleScore(scores);

        assertEquals(highest, 12);
    }
}
