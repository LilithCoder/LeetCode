package LeetCode;

public class sol_67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        while (m >= 0 || n >= 0) {
            int sum = carry;
            if (m >= 0) {
                sum += a.charAt(m--) - '0';
            }
            if (n >= 0) {
                sum += b.charAt(n--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
