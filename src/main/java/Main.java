import java.util.*;

public class Main {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    class BinaryTree {
        Node root;

        /* This function traverses the skewed binary tree and
           stores its nodes pointers in ArrayList nodes[] */
        void storeBSTNodes(Node root, List<Node> nodes) {
            // Base case
            if (root == null)
                return;

            // Store nodes in Inorder (which is sorted
            // order for BST)
            storeBSTNodes(root.left, nodes);
            nodes.add(root);
            storeBSTNodes(root.right, nodes);
        }

        /* Recursive function to construct binary tree */
        Node buildTreeUtil(List<Node> nodes, int start, int end) {
            // base case
            if (start > end)
                return null;

            /* Get the middle element and make it root */
            int mid = (start + end) / 2;
            Node node = nodes.get(mid);

        /* Using index in Inorder traversal, construct
           left and right subtrees */
            node.left = buildTreeUtil(nodes, start, mid - 1);
            node.right = buildTreeUtil(nodes, mid + 1, end);

            return node;
        }

        // This function converts an unbalanced BST to
        // a balanced BST
        Node buildTree(Node root) {
            // Store nodes of given BST in sorted order
            List<Node> nodes = new ArrayList<>();
            storeBSTNodes(root, nodes);

            // Constructs BST from nodes[]
            int n = nodes.size();
            return buildTreeUtil(nodes, 0, n - 1);
        }

        /* Function to do preorder traversal of tree */
        void preOrder(Node node) {
            if (node == null)
                return;
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        // Driver program to test the above functions
        public void main(String[] args) {
         /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(10);
            tree.root.left = new Node(8);
            tree.root.left.left = new Node(7);
            tree.root.left.left.left = new Node(6);
            tree.root.left.left.left.left = new Node(5);

            tree.root = tree.buildTree(tree.root);
            System.out.println("Preorder traversal of balanced BST is :");
            tree.preOrder(tree.root);
        }
    }

    public void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.main(args);

/* A binary tree node has data, pointer to left child
   and a pointer to right child */




// This code has been contributed by Mayank Jaiswal(mayank_24)

    }
}
