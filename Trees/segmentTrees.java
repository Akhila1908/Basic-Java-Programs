class Main {
    static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
            this.data = 0; 
        }
    }
    private Node root;
    // Constructor initializes the Segment Tree with the input array
    public Main(int[] arr) {
        if (arr != null && arr.length > 0) {
            this.root = constructTree(arr, 0, arr.length - 1);
        } else {
            System.out.println("Invalid array: array is null or empty");
        }
    }
    // Recursively construct the segment tree
    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            // Leaf node will have a single element
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        // Recursively create child nodes
        int mid = (start + end) / 2;
        Node node = new Node(start, end);
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }
    // Display the segment tree (for debugging)
    public void display() {
        display(this.root);
    }
    private void display(Node node) {
        if (node == null) return;
        String str = "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " => ";
        if (node.left != null) {
            str += "Left Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " | ";
        } else {
            str += "No left child | ";
        }

        if (node.right != null) {
            str += "Right Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str += "No right child";
        }

        System.out.println(str);

        // Recursively display left and right children
        display(node.left);
        display(node.right);
    }

    // Query the sum of elements in the range [queryStart, queryEnd]
    public int rangeQuery(int queryStart, int queryEnd) {
        return rangeQuery(root, queryStart, queryEnd);
    }

    // Helper method for the range query
    private int rangeQuery(Node node, int queryStart, int queryEnd) {
        // If the current node's range is completely within the query range, return its data
        if (node.startInterval >= queryStart && node.endInterval <= queryEnd) {
            return node.data;
        }

        // If the current node's range is completely outside the query range, return 0
        if (node.endInterval < queryStart || node.startInterval > queryEnd) {
            return 0;
        }

        // Otherwise, split the query range into the left and right child nodes
        int leftQuery = rangeQuery(node.left, queryStart, queryEnd);
        int rightQuery = rangeQuery(node.right, queryStart, queryEnd);

        return leftQuery + rightQuery;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};

        // Create the Segment Tree
        Main segmentTree = new Main(arr);
        segmentTree.display();
int sum = segmentTree.rangeQuery(1, 3); 
        System.out.println("Sum of elements in range [1, 3]: " + sum);
    }
}
