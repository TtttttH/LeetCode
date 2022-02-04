package middle.dp;

/**
 * No.337 打家劫舍III
 */
public class No_337 {
    public int rob(TreeNode root) {
        int[] resultArray = robTree(root);
        return Math.max(resultArray[0], resultArray[1]);
    }

    private int[] robTree(TreeNode node) {
        int[] res = new int[2];
        if(node == null) {
            return res;
        }

        int[] left =  robTree(node.left);
        int[] right = robTree(node.right);

        //不偷node
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //偷node
        res[1] = node.val + left[0] + right[0];

        return res;
    }
}
