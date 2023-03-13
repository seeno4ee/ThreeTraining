package org.example;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> {
    List<T> list = new ArrayList<>();
   public void add(T tree){
        list.add(tree);
    }
   public T remove(){
       return list.remove(0);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
