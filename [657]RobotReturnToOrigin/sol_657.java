package LeetCode;

public class sol_657 {
    public boolean judgeCircle(String moves) {
        int LR = 0;
        int UD = 0;
        for (char c: moves.toCharArray()) {
            if (c == 'R') {
                LR++;
            }
            if (c == 'L') {
                LR--;
            }
            if (c == 'U') {
                UD++;
            }
            if (c == 'D') {
                UD--;
            }
        }
        return LR == 0 && UD == 0;
    }
}
