class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int v, TreeNode l, TreeNode r) {
        val = v;
        left = l;
        right = r;
    }
}

public class Main {
    public static void main(String[] args) {
        final TreeNode tree = new TreeNode(
            10,
            new TreeNode(
                5,
                new TreeNode(
                    4,
                    new TreeNode(
                        1,
                        null,
                        null
                    ),
                    null
                ),
                new TreeNode(
                    8,
                    null,
                    null
                )
            ),
            new TreeNode(
                20,
                new TreeNode(
                    14,
                    null,
                    new TreeNode(
                        12,
                        null,
                        null
                    )
                ),
                new TreeNode(
                    40,
                    null,
                    null
                )
            )
        );

        System.out.println(order(tree, 7));
    }

    public static int order(TreeNode node, int n) {
        if (node == null) {
            return 0;
        }

        int i = 0;
        i += order(node.left, n);

        if (node.val < n) {
            i++;
        }

        i += order(node.right, n);

        return i;
    }
}