class SegmentTree {

    int[] tree;
    int n;

    // Constructor
    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[4 * n]; // size = 4*n
        build(nums, 0, n - 1, 1);
    }

    // 🔹 Build function
    void build(int[] nums, int start, int end, int node) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        // left child
        build(nums, start, mid, 2 * node);

        // right child
        build(nums, mid + 1, end, 2 * node + 1);

        // merge
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // 🔹 Query (range sum)
    int query(int start, int end, int node, int left, int right) {

        // No overlap
        if (start > right || end < left) {
            return 0;
        }

        // Complete overlap
        if (start >= left && end <= right) {
            return tree[node];
        }

        // Partial overlap
        int mid = (start + end) / 2;

        int leftSum = query(start, mid, 2 * node, left, right);
        int rightSum = query(mid + 1, end, 2 * node + 1, left, right);

        return leftSum + rightSum;
    }

    // 🔹 Update (point update)
    void update(int start, int end, int node, int index, int value) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(start, mid, 2 * node, index, value);
        } else {
            update(mid + 1, end, 2 * node + 1, index, value);
        }

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
}

class Main {
    public static void main(String[] args) {

        int[] nums = {2, 1, 4, 3, 6};

        SegmentTree st = new SegmentTree(nums);

        // Query sum from index 1 to 4
        int ans = st.query(0, nums.length - 1, 1, 1, 4);
        System.out.println("range from 1 to 4: "+ ans); // output: 14

        // Update index 2 → value 5
        st.update(0, nums.length - 1, 1, 2, 5);

        // Query again
        int ans2 = st.query(0, nums.length - 1, 1, 1, 4);
        System.out.println(ans2); // updated result
    }
}
