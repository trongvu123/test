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
public class nodeMIN_MAX {

    public Node getLargestPriceNode() {
        return getLargestPriceNode(root);
    }
    int count = 0;

    private Node getLargestPriceNode(Node node) {
        if (node == null) {
            return null;
        }

        Node max = node;

        while (node != null) {
            if (node.info.price > max.info.price) {
                max = node;
            }
            node = node.right;
        }

        return max;
    }

    void breadth2(Node p, RandomAccessFile f, int[] count) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r == getLargestPriceNode()) {
                count[0]++;
            }
            if (r == getLargestPriceNode() && count[0] == 1) {
                deleteByCopy(r);
                break;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
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
Node PreOrder2(Node p, RandomAccessFile f, int[] count) {
    if (p == null) {
        return null;
    }
    if (p == getLargestPriceNode()) {
        count[0]++;
    }
    if (p == getLargestPriceNode() && count[0] == 2) {
        deleteByCopy(p);
        return p; // If you want to return the deleted node
    }
    Node left = PreOrder2(p.left, f, count);
    if (left != null) {
        return left;
    }
    return PreOrder2(p.right, f, count);
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
}
