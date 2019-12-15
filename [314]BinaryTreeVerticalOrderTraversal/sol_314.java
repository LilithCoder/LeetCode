package LeetCode;

import java.util.*;

public class sol_314 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> distanceQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        distanceQueue.add(0);
        nodeQueue.add(root);
        // use bfs traverse the whole tree and map each treenode with its distance
        // away from the root node horizontally
        while(!distanceQueue.isEmpty() && !nodeQueue.isEmpty()) {
            int distance = distanceQueue.remove();
            TreeNode node = nodeQueue.remove();
            map.putIfAbsent(distance, new ArrayList<>());
            map.get(distance).add(node.val);
            if (node.left != null) {
                distanceQueue.add(distance - 1);
                nodeQueue.add(node.left);
            }
            if (node.right != null) {
                distanceQueue.add(distance + 1);
                nodeQueue.add(node.right);
            }
        }
        // traverse the map, add the node value based on the ascending distance
        for (int key: new TreeSet<Integer>(map.keySet())) {
            result.add(map.get(key));
        }
        return result;
    }
}
