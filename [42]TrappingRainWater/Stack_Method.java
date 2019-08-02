import java.util.Stack;

public class Stack_Method {

    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int currentIndex = 0;
        while (currentIndex < height.length) {
            
            while(!stack.isEmpty() && height[currentIndex] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int heightLower = Math.min(height[currentIndex], height[stack.peek()]) - height[top];
                int distance = currentIndex - stack.peek() - 1;
                res += heightLower * distance;
            }

            stack.push(currentIndex);
            currentIndex++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {2,1,0,0,2,3};
        System.out.println(trap(test));
    }
}
