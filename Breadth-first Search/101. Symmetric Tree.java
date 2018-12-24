
/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3

*/

/*

O(n),O(logn)

*/

public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetric(root.left, root.right);
}

private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null || right == null) return left == right;
    if (left.val != right.val) return false;
    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
}


/*

O(n),O(n)

*/

public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(root.left);
    deque.offerLast(root.right);
    while (!deque.isEmpty()) {
        TreeNode right = deque.pollLast();
        TreeNode left = deque.pollLast();
        if (left == null && right == null) continue;
        if (left == null || right == null || left.val != right.val) return false;
        deque.offerLast(left.left);
        deque.offerLast(right.right);
        deque.offerLast(right.left);
        deque.offerLast(left.right);
    }
    return true;
}




