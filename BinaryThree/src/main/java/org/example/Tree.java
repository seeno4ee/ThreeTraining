package org.example;

import java.util.Stack;

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
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        int result = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            System.out.println(node.value);
            result += node.value;
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }
}
