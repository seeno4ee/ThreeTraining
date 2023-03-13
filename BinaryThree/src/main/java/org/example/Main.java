package org.example;

public class Main {
    public static void main(String[] args) {
        Three three = new Three(1,new Three(1,null,null),new Three(1,null,null));
        System.out.println(three.sum());
    }
}