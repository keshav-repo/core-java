package org.learning.generic;

class Box<T> {
    private T content;

    public T getContent() {
        return content;
    }
    public void setContent(T content) {
        this.content = content;
    }
}
public class BoxDemo{
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setContent(10);
        int value = intBox.getContent();
        System.out.println(value);

        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello world");
        System.out.println(stringBox.getContent());

        Number  number;
        Integer integer;
    }
}
