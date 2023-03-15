package org.example;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.example.Huffman.huffman;
import static org.example.Huffman.huffmanDecode;

public class Main {
    public static void main(String[] args) {
        String message = "Проверка алгоритма Хаффмана";
        TreeMap<Character, Integer> freq = CountFrequency.countFrequency(message);

        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : freq.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, freq.get(c)));
        }

        CodeTreeNode treeNode = huffman(codeTreeNodes);

        TreeMap<Character, String> codes = new TreeMap<>();
        for (Character c : freq.keySet()
        ) {
            codes.put(c, treeNode.getCodeForCharacter(c, ""));
        }
        System.out.println("Таблица преффиксных кодов: " + codes);

        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encoded.append((codes.get(message.charAt(i))));
        }
        System.out.printf("Размер исходной строки: %d бит \n", message.getBytes().length * 8);
        System.out.printf("Размер сжатой строки: %d бит \n", encoded.length());
        System.out.printf("Биты сжатой строки: %s \n", encoded);

        String decoded = huffmanDecode(encoded.toString(), treeNode);

        System.out.printf("Расшифровано: %s", decoded);
    }


}