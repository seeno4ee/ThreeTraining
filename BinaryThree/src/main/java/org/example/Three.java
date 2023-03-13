package org.example;

public class Three {
    int value;
    Three left;
    Three right;

    public Three(int value, Three left, Three right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    int sum() {
        int result = value;
        if (left != null)
            result += left.sum();
        if (right != null)
            result += right.sum();
        return result;
    }
}
