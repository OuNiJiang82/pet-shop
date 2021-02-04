package com.zxh.entity;

public class SetMeat {
    private int id;
    private int animalId;
    private int vaccineId;
    private double price;

    @Override
    public String toString() {
        return "套餐[" + id + "]";
    }

    public SetMeat(int id, int animalId, int vaccineId, double price) {
        this.id = id;
        this.animalId = animalId;
        this.vaccineId = vaccineId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
