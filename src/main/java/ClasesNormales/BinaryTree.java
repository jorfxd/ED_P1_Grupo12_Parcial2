package ClasesNormales;

import java.util.Stack;

public class BinaryTree<E> {
    private NodeBinaryTree<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E content) {
        this.root = new NodeBinaryTree<>(content);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isLeaf() {
        if (!this.isEmpty()) {
            return root.getLeft() == null && root.getRight() == null;
        }
        return false;
    }

    public NodeBinaryTree<E> getRoot() {
        return root;
    }

    public void setRoot(NodeBinaryTree<E> root) {
        this.root = root;
    }
}