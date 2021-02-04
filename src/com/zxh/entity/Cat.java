package com.zxh.entity;

public class Cat extends Animal {
    public Cat(int id, double price) {
        super(id, price);
    }

    @Override
    public String toString() {
        return "小猫[" + id + "]";
    }
}
