package com.narxoz.rpg.equipment;

public class MageRobe implements Armor {
    private final int defense;
    private final String material;
    private final String type;

    public MageRobe() {
        defense = 5;
        material = "Cloth";
        type = "Magic Robe";
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public String getArmorInfo() {
        return "Mage Robe - enchanted robe that enhances magical abilities";
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

