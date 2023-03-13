package org.example;
public class Tree {
    int value;
    Tree left;
    Tree right;

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    int sum(Tree root) {
        MyQueue<Tree> queue = new MyQueue<>();
        queue.add(root);
        int result = 0;

        while (!queue.isEmpty()) {
            Tree node = queue.remove();
            System.out.println(node.value);
            result += node.value;
            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);
        }
        return result;
    }
}
