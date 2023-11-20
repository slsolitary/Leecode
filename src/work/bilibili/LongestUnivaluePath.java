package work.bilibili;

/**
 * @author heyao
 * @date 2023-08-29 19:34
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tmp = root;
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root = root.left;
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root = tmp.right;
        root.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(tmp));
    }
    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    static int ans;
    public static int longestUnivaluePath (TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        int lp = 0;
        int lr = 0;
        if(root.left != null && root.left.val == root.val){
            lp = L+1;
        }
        if(root.right != null && root.right.val == root.val){
            lr = R+1;
        }
        ans = Math.max(ans,lr+lp);
        return Math.max(L,R);
    }
}

