import java.util.Arrays;

public class Mastermind {
    public String[] colors = {"Rot", "Grün", "Blau", "Weiß", "Orange", "Grau"};

    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;
    public static final int WHITE = 3;
    public static final int ORANGE = 4;
    public static final int GREY = 5;

    public int[] code;

    public String[] chosen_colors = new String[4];
    private int numMove;

    public Mastermind(int c1, int c2, int c3, int c4) {
        this.code = new int[4];
        code[0] = c1;
        chosen_colors[0] = colors[0];
        code[1] = c2;
        chosen_colors[1] = colors[1];
        code[2] = c3;
        chosen_colors[2] = colors[2];
        code[3] = c4;
        chosen_colors[3] = colors[3];
        this.numMove = 0;
    }

    private int correctColorsAndPositions(int[] colors) {
        int count = 0;
        for (int i = 0; i < code.length; i++) {
            if (code[i] == colors[i]) {
                count = count + 1;
            }
        }
        return count;
    }

    public int correctColors(int[] colors) {
        int count = 0;
        for (int i = 0; i < code.length; i++) {
            for (int x = 0; x < colors.length; x++){
                if (code[i] == colors[x]) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    public int[] guess(int c1, int c2, int c3, int c4) {
        int[] colors = {c1, c2, c3, c4};
        int cc = 0;
        int ccap = 0;
        cc = correctColors(colors);
        ccap = correctColorsAndPositions(colors);
        numMove = numMove + 1;

        int[] results = {cc,ccap};

        return results;
    }
}