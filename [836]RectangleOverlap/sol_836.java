package LeetCode;

public class sol_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // when rec2 is located at the right hand of rec1
        if (rec2[0] >= rec1[2]) return false;
        // when rec2 is located at the top of rec1
        if (rec2[1] >= rec1[3]) return false;
        // when rec2 is located at the left hand of rec1
        if (rec2[2] <= rec1[0]) return false;
        // when rec2 is located at the bottom of rec1
        if (rec2[3] <= rec1[1]) return false;
        return true;
    }
}
