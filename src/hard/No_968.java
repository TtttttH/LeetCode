package hard;

import hard.TreeNode;

/**
 * No.968 Binary Tree Cameras
 */
public class No_968 {
    int result = 0;
    private int traversal (TreeNode root) {
        if (root == null) { //空节点，默认已经被覆盖
            return 2;
        }

        int left = traversal(root.left);
        int right = traversal(root.right);

        if (left == 2 && right == 2) { //当前左子节点和右子节点均被摄像头覆盖，则当前节点没有被覆盖
            return 0;
        }

        if (left == 0 || right == 0) { //当前左子节点或右子节点有未覆盖，则当前节点需要安装摄像头
            result ++;
            return 1;
        }

        if (left == 1 || right == 1) { //左子节点或右子节点有摄像头，则当前节点已经被覆盖
            return 2;
        }
        return -1;
    }

    public int minCameraCover(TreeNode root) {
        if (traversal(root) == 0) {
            result ++;
        }
        return result;
    }
}
