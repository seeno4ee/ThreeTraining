package org.example;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(1,new Tree(2,new Tree(3,null,null),new Tree(4,null,null)),new Tree(5,new Tree(6,null,null),new Tree(7,null,null)));
        System.out.println(tree.sum(tree));
    }

}