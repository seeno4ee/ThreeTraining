package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    char value;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(char value) {
        this.value = value;
    }


    public void insert(String data) {
        if (data.length() == 0)
            return;

        char c = data.charAt(0);
        TreeNode child = findNodeByChar(c);
        if (child == null) {
            child = new TreeNode(c);
            children.add(child);
        }
        child.insert(data.substring(1));
    }


    private TreeNode findNodeByChar(char c) {
        for (TreeNode node : children
        ) {
            if (node.value == c)
                return node;
        }
        return null;
    }


    //Поиск строки в дереве
    public boolean containString(String str) {
        TreeNode current = this;
        for (int i = 0; i < str.length(); i++) {
            current = current.findNodeByChar(str.charAt(i));
            if (current == null)
                return false;
        }
        return true;
    }


    public void getAllNumbers(String path, List<String> result) {
        if (value != ' ')//Если не корневой элемент
            path += value;
        for (TreeNode node : children)
            node.getAllNumbers(path, result);
        result.add(path);
    }


    //Запись дерева в файл
    public void writeToFile(PrintWriter writer) {
        writer.write(value);
        for (TreeNode node : children)
            node.writeToFile(writer);
        writer.write('}');
    }


    public void readFromFile(FileReader reader) throws IOException {
        char ch;
        while ((ch = (char) reader.read()) != '}') {
            TreeNode treeNode = new TreeNode(ch);
            treeNode.readFromFile(reader);
            children.add(treeNode);
        }
    }
}
