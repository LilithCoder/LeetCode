package LeetCode;

public class sol_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // declare stringbuilder row by row
        StringBuilder[] sbArray = new StringBuilder[numRows];
        // initialize every element of sbArray with stringbuilder object
        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i] = new StringBuilder();
        }
        int indexOfStringBuilder = 0;
        // increment of indexOfStringBuilder, 1 if move down, -1 if move up
        int increment = 1;
        for (int i = 0; i < s.length(); i++) {
            sbArray[indexOfStringBuilder].append(s.charAt(i));
            // locate at the uppermost row, convert the direction of increment to down
            if (indexOfStringBuilder == 0) increment = 1;
            // locate at the uppermost row, convert the direction of increment to down
            if (indexOfStringBuilder == numRows - 1) increment = -1;
            indexOfStringBuilder += increment;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: sbArray) {
            result.append(sb.toString());
        }
        return result.toString();
    }
}
