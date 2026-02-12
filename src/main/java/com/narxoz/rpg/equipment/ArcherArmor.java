package com.narxoz.rpg.equipment;

public class ArcherArmor implements Armor {
    private final int defense;
    private final String material;
    private final String type;

    public ArcherArmor() {
        defense = 8;
        material = "Leather";
        type = "Light Armor";
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public String getArmorInfo() {
        return "Archer Armor - lightweight armor for mobility and precision";
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

