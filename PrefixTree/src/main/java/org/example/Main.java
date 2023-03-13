package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //Строим дерево из списка
        List<String> lines = Files.readAllLines(Paths.get("src\\main\\resources\\numbers.txt"));
        TreeNode root = new TreeNode(' ');
        for (String line : lines
        ) {
            root.insert(line);
        }


        //Читаем из дерева все номера
        List<String> extractedFromTree1 = new ArrayList<>();
        root.getAllNumbers("", extractedFromTree1);


        //Пишем дерево в файл
        writeTreeToFile("src\\main\\resources\\out.txt", root);


        //Пишем из файла в дерево
        List<String> extractedFromTree2 = new ArrayList<>();
        TreeNode treeNode = readFromFile("src\\main\\resources\\out.txt");
        treeNode.getAllNumbers("", extractedFromTree2);


        System.out.println(extractedFromTree1.equals(extractedFromTree2));
    }

    //Пишем дерево в файл
    public static void writeTreeToFile(String path, TreeNode root) {
        try {
            PrintWriter out = new PrintWriter(path);
            root.writeToFile(out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static TreeNode readFromFile(String path) {
        TreeNode root = new TreeNode(' ');
        try {
            FileReader reader = new FileReader(path);
            reader.read();
            root.readFromFile(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return root;
    }
}