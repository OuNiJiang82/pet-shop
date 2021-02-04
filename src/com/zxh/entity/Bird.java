package com.zxh.entity;

public class Bird extends Animal {
    public Bird(int id, double price) {
        super(id, price);
    }

    @Override
    public String toString() {
        return "小鸟[" + id + "]";
    }
}
