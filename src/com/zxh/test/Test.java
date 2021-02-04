package com.zxh.test;

import com.zxh.entity.*;
import com.zxh.shop.MyPetShop;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyPetShop myPetShop = new MyPetShop(5, 1000);
        MyPetShop myPetShop1 = new MyPetShop(5, 100);

        Cat cat = new Cat(1, 50);
        Dog dog = new Dog(2, 80);
        Bird bird = new Bird(3, 36);
        Bird bird1 = new Bird(4, 44);
        Dog dog1 = new Dog(5, 82);

        Vaccine vaccine1 = new Vaccine(1, 20);
        Vaccine vaccine2 = new Vaccine(2, 30);
        Vaccine vaccine3 = new Vaccine(3, 50);
        myPetShop.setVaccineList(Arrays.asList(vaccine1, vaccine2, vaccine3));

        // 宠物进货
        myPetShop.stockAnimals(cat, dog, bird); // 进货成功
        myPetShop1.stockAnimals(cat, dog, bird); // 进货失败 钱不够

        // 出售套餐
        SetMeat setMeat1 = new SetMeat(1, 1, 1, 100);
        SetMeat setMeat2 = new SetMeat(2, 1, 1, 100);
        myPetShop.sellSetMeat(setMeat1); // 出售成功
        myPetShop.sellSetMeat(setMeat2); // 出售失败 没有1号动物

        // 寄养宠物
        myPetShop.adopt(bird1, 5);

        // 打疫苗
        myPetShop.vaccinate(dog1, 2); // 接种成功
        myPetShop.vaccinate(dog1, 5); // 接种失败 没有5号疫苗
    }
}
