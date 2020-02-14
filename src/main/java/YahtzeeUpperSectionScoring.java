public class YahtzeeUpperSectionScoring {

    private static int roll() {
        return (int)(Math.random()*6) + 1;
    }

    public static int[] performRolls() {
        System.out.println("Dice rolls:");
        System.out.print("[");
        int[] dice = new int[5];
        for(int i = 0; i < dice.length; i++) {
            dice[i] = roll();
            System.out.print(dice[i]);
            if(i < dice.length - 1) System.out.print(",");
        }
        System.out.println("]");
        return dice;
    }

    public static int[] getNumberRollCounts(int[] dice) {
        int[] rollCount = { 0, 0, 0, 0, 0, 0 }; // One for each possible number
        for(int i = 0; i < dice.length; i++) {
            rollCount[dice[i] - 1] += 1; // How many times did we roll x?
        }

        return rollCount;
    }

    public static int[] calculatePossibleScores(int[] rollCount) {
        int[] possibleScores = { 0, 0, 0, 0, 0, 0 };
        for(int i = 0; i < rollCount.length; i++) {
            possibleScores[i] = rollCount[i] * (i + 1); // e.g. if we rolled three 2s, would calculate 3 * 2
            if(rollCount[i] != 0) {
                System.out.println("Number of " + (i + 1) + "s rolled: " + rollCount[i]
                        + " - Score: " + possibleScores[i]);
            }
        }

        return possibleScores;
    }

    public static int calculateMaxPossibleScore(int[] possibleScores) {
        // Get highest score
        int highest = 0;
        for(int i = 0; i < possibleScores.length; i++) {
            if(possibleScores[i] > highest)
                highest = possibleScores[i];
        }

        return highest;
    }

    public static void main(String[] a) {
        int[] dice = performRolls();
        int[] rollCount = getNumberRollCounts(dice);
        int[] possibleScores = calculatePossibleScores(rollCount);
        int highest = calculateMaxPossibleScore(possibleScores);

        System.out.println("Highest score: " + highest);
    }
}
