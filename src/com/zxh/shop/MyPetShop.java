package com.zxh.shop;

import com.zxh.entity.Animal;
import com.zxh.entity.SetMeat;
import com.zxh.entity.Vaccine;
import com.zxh.exception.NoAnimalException;
import com.zxh.exception.NoVaccineException;
import com.zxh.util.DateTimeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyPetShop implements PetShop {
    private List<Animal> animalList = new ArrayList<>();
    private List<Vaccine> vaccineList = new ArrayList<>();
    private double oneDayAdoptPrice;
    private double balance;

    public MyPetShop(double oneDayAdoptPrice, double balance) {
        this.oneDayAdoptPrice = oneDayAdoptPrice;
        this.balance = balance;
    }

    public Animal getAnimalById(int id) throws NoAnimalException {
        for (Animal animal : animalList) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        throw new NoAnimalException();
    }

    public Vaccine getVaccineById(int id) throws NoVaccineException {
        for (Vaccine vaccine : vaccineList) {
            if (vaccine.getId() == id) {
                return vaccine;
            }
        }
        throw new NoVaccineException();
    }

    public void printInfo(String info) {
        System.out.println(DateTimeUtil.now() + " " + info);
    }

    /**
     * 出售套餐
     * @param setMeat
     */
    @Override
    public void sellSetMeat(SetMeat setMeat) {
        int animalId = setMeat.getAnimalId();
        int vaccineId = setMeat.getVaccineId();
        try {
            Animal animal = getAnimalById(animalId);
            Vaccine vaccine = getVaccineById(vaccineId);
            animalList.remove(animal);
            balance += setMeat.getPrice();
            printInfo("出售成功 " + setMeat + "的" + animal + "和" + vaccine +
                    "已出售 收入:" + setMeat.getPrice() + " 余额:" + balance);
        } catch (NoAnimalException e) {
            printInfo("出售失败 没有该动物");
        } catch (NoVaccineException e) {
            printInfo("出售失败 没有该疫苗");
        }
    }

    /**
     * 宠物进货
     * @param animals
     */
    @Override
    public void stockAnimals(Animal... animals) {
        stockAnimals(Arrays.asList(animals));
    }

    @Override
    public void stockAnimals(List<Animal> animals) {
        double totalPrice = animals.stream().mapToDouble(Animal::getPrice).sum();
        if (balance < totalPrice) {
            printInfo("进货失败 余额不足 余额:" + balance);
        } else {
            balance -= totalPrice;
            animalList.addAll(animals);
            printInfo("进货成功 价格:" + totalPrice + " 余额:" + balance);
        }
    }

    /**
     * 寄养宠物
     * @param day
     */
    public void adopt(Animal animal, int day) {
        balance += oneDayAdoptPrice * day;
        printInfo("寄养" + animal + day + "天 收入:" + oneDayAdoptPrice * day + "余额:" + balance);
    }

    /**
     * 打疫苗
     * @param animal
     * @param vaccineId
     */
    public void vaccinate(Animal animal, int vaccineId) {
        try {
            Vaccine vaccine = getVaccineById(vaccineId);
            balance += vaccine.getPrice();
            printInfo("接种成功 已为" + animal + "接种" + vaccine + " 收入:" +
                    vaccine.getPrice() + " 余额:" + balance);
        } catch (NoVaccineException e) {
            printInfo("接种失败 没有该疫苗");
        }
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public List<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(List<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }

    public double getOneDayAdoptPrice() {
        return oneDayAdoptPrice;
    }

    public void setOneDayAdoptPrice(double oneDayAdoptPrice) {
        this.oneDayAdoptPrice = oneDayAdoptPrice;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
