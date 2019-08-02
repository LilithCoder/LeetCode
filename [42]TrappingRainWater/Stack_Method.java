import java.util.Stack;

public class Stack_Method {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int currentIndex = 0;
        while (currentIndex < height.length) {

            //make sure the stack is not empty since there might the boundary case
            //where height decrease, store the index inside the stack
            //otherwise not
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
}
