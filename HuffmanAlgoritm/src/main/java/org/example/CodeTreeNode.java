package org.example;

public class CodeTreeNode implements Comparable<CodeTreeNode> {
    Character content;
    int weight;
    CodeTreeNode left;
    CodeTreeNode right;

    public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
        this.content = content;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public CodeTreeNode(Character content, int weight) {
        this.content = content;
        this.weight = weight;
    }

    public String getCodeForCharacter(Character c, String parentPath) {
        if (content == c)
            return parentPath;
        else {
            if (left != null) {
                String path = left.getCodeForCharacter(c, parentPath + 0);
                if (path != null)
                    return path;
            }
            if (left != null) {
                return right.getCodeForCharacter(c, parentPath + 1);
            }
        }
        return null;
    }

    @Override
    public int compareTo(CodeTreeNode o) {
        return o.weight - weight;
    }
}
