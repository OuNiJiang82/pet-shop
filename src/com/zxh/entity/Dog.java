package com.zxh.entity;

public class Dog extends Animal {
    public Dog(int id, double price) {
        super(id, price);
    }

    @Override
    public String toString() {
        return "小狗[" + id + "]";
    }
}
