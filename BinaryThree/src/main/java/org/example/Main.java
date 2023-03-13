package org.example;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(1,new Tree(2,null,null),new Tree(3,null,null));
        System.out.println(tree.sum(tree));
    }

}