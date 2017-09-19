public class Main {
    public static void main(String[] args) {
        final Node first = new Node(
                5,
                new Node(
                        3,
                        new Node(
                                20,
                                new Node(6, null, null),
                                null
                        ),
                        null
                ),
                new Node(
                        10,
                        new Node(1, null, null),
                        new Node(
                                15,
                                new Node(
                                        30,
                                        null,
                                        new Node(9, null, null)
                                ),
                                new Node(8, null, null)
                        )
                )
        );

        int zigzagLength = getZigzagLength(0, first, null);

        System.out.println(zigzagLength);
    }

    private static int getZigzagLength(int currentCount, Node node, Boolean isLeft) {
        return Math.max(
                node.getLeft() != null
                        ? getZigzagLength(
                            isLeft != null && !isLeft ? currentCount+1 : currentCount,
                            node.getLeft(),
                            true)
                        : currentCount,
                node.getRight() != null
                        ? getZigzagLength(
                            isLeft != null && isLeft ? currentCount+1 : currentCount,
                            node.getRight(),
                            false)
                        : currentCount);
    }

    private static class Node {
        private int key;
        private Node left;
        private Node right;

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public int getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
