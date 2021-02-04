package com.zxh.shop;

import com.zxh.entity.Animal;
import com.zxh.entity.SetMeat;

import java.util.List;

public interface PetShop {
    void sellSetMeat(SetMeat setMeat);
    void stockAnimals(Animal... animals);
    void stockAnimals(List<Animal> animals);
}
