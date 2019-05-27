package com.luba.todo.recycler;



public class Item {
    private String text1, text2;
    private int type;
    public final static int TYPE1=1;
    public final static int TYPE2=2;
    public final static int TYPE3=3;

    public Item(String text1, String text2, int type)
    {
        this.text1 = text1;
        this.text2 = text2;
        this.type = type;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public int getType() {
        return type;
    }
}
