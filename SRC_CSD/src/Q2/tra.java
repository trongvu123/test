/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.io.RandomAccessFile;

/**
 *
 * @author Admin
 */
public class tra {
    Node root;

    public BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    Node search(Node p, int x) {
        if (p == null) {
            return null;
        }
        if (p.info == x) {
            return p;
        }
        if (x < p.info) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }

    }

    Node insert(Node p, int x) {
        if (p == null) {
            p = new Node(x);
            return p;
        }
        if (p.info == x) {
            System.out.println(x + " is exist!");
            return p;
        }
        if (x < p.info) {
            p.left = insert(p.left, x);
        } else {
            p.right = insert(p.right, x);
        }
        return p;
    }

    void insert(int x) {
        root = insert(root, x);
    }

    void insert2(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p; // f la father cua b
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println(x + " is exist!");
                return;
            }
            f = p; // gan bo bang thang con hien tai
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert2(a[i]);
        }
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    //(10)
    void breadth(Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void deleteByCopy(Node x) {
    if (root == null) {
        System.out.println("The tree is empty");
        return;
    }
    Node f, p; // f will be the father of p;
    f = null;
    p = root;
    while (p != null) {
        if (p.info.sound == x.info.sound) {
            break; // found the node to delete
        }
        f = p;
        if (x.info.sound < p.info.sound) {
            p = p.left;
        } else {
            p = p.right;
        }
    }
    if (p == null) {
        System.out.println("The key " + x + " does not exist, no deletion");
        return;
    } // Not found
    // Case 1: p is a leaf node
    if (p.left == null && p.right == null) {
        if (f == null) { // p is root
            root = null;
        } else {
            if (p == f.left) {
                f.left = null;
            } else {
                f.right = null;
            }
        }
        return;
    }
    // Case 2: p has a left child node
    if (p.left != null && p.right == null) {
        if (f == null) {
            root = p.left;
        } else {
            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
        return;
    }
    // Case 3: p has a right child node
    if (p.left == null && p.right != null) {
        if (f == null) {
            root = p.right;
        } else {
            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }
        return;
    }
    // Case 4: p has two children
    if (p.left != null && p.right != null) {
        Node q = p.left;
        Node fr, rp;
        fr = null;
        rp = q;
        while (rp.right != null) {
            fr = rp;
            rp = rp.right;
        }
        p.info = rp.info;
        if (fr == null) {
            p.left = q.left;
        } else {
            fr.right = rp.left;
        }
    }
}

    void deleteByMerging(int x) {
        if (isEmpty()) {
            return;
        }
        // find the parent and the node to be deleted
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        // if the node is not found
        if (p == null) {
            return; // Not found
        }

        // if p is a leaf node
        if (p.left == null && p.right == null) {
            // if p is the root
            if (f == null) {
                root = null;
                return;
            }
            // if p is a left child
            if (p == f.left) {
                f.left = null;
            } else { // if p is a right child
                f.right = null;
            }
            return;
        }

        // if p only has a left child
        if (p.left != null && p.right == null) {
            if (f == null) { // if p is the root
                root = p.left;
            } else if (p == f.left) { // if p is a left child
                f.left = p.left;
            } else { // if p is a right child
                f.right = p.left;
            }
            return;
        }

        // if p only has a right child
        if (p.left == null && p.right != null) {
            if (f == null) { // if p is the root
                root = p.right;
            } else if (p == f.left) { // if p is a left child
                f.left = p.right;
            } else { // if p is a right child
                f.right = p.right;
            }
            return;
        }

        // if p has both left and right children
        if (p.left != null && p.right != null) {
            Node tmp = p.left; // find the rightmost node in the left subtree of p
            while (tmp.right != null) {
                tmp = tmp.right;
            }

            tmp.right = p.right; // attach the right subtree of p to the rightmost node in the left subtree of p

            if (f == null) { // if p is the root
                root = p.left;
            } else if (p == f.left) { // if p is a left child
                f.left = p.left;
            } else { // if p is a right child
                f.right = p.left;
            }
        }
    }

    //(12) balence the tree ( can bang cay nhi phan)
    void inOrderToSort(ArrayList<Integer> t, Node p) {
        if (p == null) {
            return;
        }
        //left
        inOrderToSort(t, p.left);
        t.add(p.info);
        inOrderToSort(t, p.right);
    }

    void balanceAlgorithm(ArrayList<Integer> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;// phan tu o giua
        insert(t.get(k));
        balanceAlgorithm(t, i, k - 1);
        balanceAlgorithm(t, k + 1, j);
    }

    void balanceCallback() {
        ArrayList<Integer> t = new ArrayList<>();
        inOrderToSort(t, root);
        int n = t.size();
        clear();
        balanceAlgorithm(t, 0, n - 1);

    }

    //13
    void rotateRight(int x) {
        if (isEmpty()) {
            return;
        }
        // find the parent and the node to be rotated
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        // if the node is not found or has no left child
        if (p == null || p.left == null) {
            return; // Cannot rotate
        }

        // if p has a left child
        Node q = p.left; // the left child of p
        Node r = q.right; // the right child of q

        q.right = p; // make p the right child of q
        p.left = r; // make r the left child of p

        if (f == null) { // if p is the root
            root = q;
        } else if (p == f.left) { // if p is a left child
            f.left = q;
        } else { // if p is a right child
            f.right = q;
        }
    }

    //14                        
    void rotateLeft(int x) {
        if (isEmpty()) {
            return;
        }
        // find the parent and the node to be rotated
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        // if the node is not found or has no right child
        if (p == null || p.right == null) {
            return; // Cannot rotate
        }

        // if p has a right child
        Node q = p.right; // the right child of p
        Node r = q.left; // the left child of q

        q.left = p; // make p the left child of q
        p.right = r; // make r the right child of p

        if (f == null) { // if p is the root
            root = q;
        } else if (p == f.left) { // if p is a left child
            f.left = q;
        } else { // if p is a right child
            f.right = q;
        }
    }

    Node searchParent(Node a) {
        if (a == null) {
            return null;
        }
        Node p = root, f = null;
        while (p != null && p != a) {
            f = p;
            if (p.info > a.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return f;
    }

    int height(Node p) {
        if (p == null) {
            return 0;
        }
        int leftHeight = height(p.left);
        int rightHeight = height(p.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    Node find5thNodeInOrder(Node p, int[] count) {
        if (p == null) {
            return null;
        }
        Node left = find5thNodeInOrder(p.left, count);
        if (left != null) {
            return left;
        }
        count[0]++;
        if (count[0] == 5) {
            return p;
        }
        return find5thNodeInOrder(p.right, count);
    }

    Node find5thNodePreOrder(Node p,RandomAccessFile f, int[] count) {
        if (p == null) {
            return null;
        }
        count[0]++;
        if (count[0] == 5) {
            return p;
        }
        Node left = find5thNodePreOrder(p.left, count);
        if (left != null) {
            return left;
        }
        return find5thNodePreOrder(p.right, count);
    }

    Node find5thNodePostOrder(Node p,RandomAccessFile f, int[] count) {
        if (p == null) {
            return null;
        }
        Node left = find5thNodePostOrder(p.left, count);
        if (left != null) {
            return left;
        }
        Node right = find5thNodePostOrder(p.right, count);
        if (right != null) {
            return right;
        }
        count[0]++;
        if (count[0] == 5) {
            return p;
        }
        return null;
    }

    Node find5thNodeBreadthFirst(Node root,RandomAccessFile f, int[] count) {
        if (root == null) {
            return null;
        }
        Queue q = new Queue();
        q.enqueue(root);
        while (!queue.isEmpty()) {
            Node p = queue.dequeue();
            count[0]++;
            if (count[0] == 5) {
                return p;
            }
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
        }
        return null;
    }
    
    //BALANCE THE TREE
    public void balanceTree() {
        ArrayList<Node> nodes = new ArrayList<Node>();
        storeBSTNodes(root, nodes);
        int n = nodes.size();
        root = buildTreeUtil(nodes, 0, n - 1);
    }

    void storeBSTNodes(Node root, ArrayList<Node> nodes) {
        if (root == null) {
            return;
        }
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    Node buildTreeUtil(ArrayList<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);
        return node;
    }
}
