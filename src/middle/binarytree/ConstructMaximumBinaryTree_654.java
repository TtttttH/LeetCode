package middle.binarytree;

/**
 *  No.654 最大二叉树
 */
public class ConstructMaximumBinaryTree_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length -1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxPosition = getMaxPosition(nums, left, right);
        int rootValue = nums[maxPosition];
        TreeNode root = new TreeNode(rootValue);

        root.left = helper(nums, left, maxPosition - 1);
        root.right = helper(nums, maxPosition + 1, right);

        return root;
    }

    private int getMaxPosition(int[] nums, int left, int right) {

        int position = left;
        for (int i = left; i <= right; i ++) {
            if (nums[position] < nums[i]) {
                position = i;
            }
        }

        return position;
    }
}
