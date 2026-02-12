package com.narxoz.rpg.equipment;

public class Helmet implements Armor{
    private final int defense;
    private final String material;
    private final String type;

    public Helmet() {
        defense = 10;
        material = "Iron";
        type = "Default";
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public String getArmorInfo() {
        return "Metal Helmet - protect head";
    }

    @Override
    public String getArmorType() {
        return type;
    }

    @Override
    public String getArmorMaterial() {
        return material;
    }

    @Override
    public void displayInfo() {
        System.out.println("Armor: " + getArmorInfo());
        System.out.println("Defense: " + defense);
        System.out.println("Type: " + type);
        System.out.println("Material: " + material);
    }
}
