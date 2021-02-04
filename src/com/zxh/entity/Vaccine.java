package com.zxh.entity;

public class Vaccine {
    private int id;
    private double price;

    public Vaccine(int id, double price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "疫苗[" + id + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
