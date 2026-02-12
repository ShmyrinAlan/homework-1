package com.narxoz.rpg.equipment;

public class NoArmor implements Armor {

    private final int defense;
    private final String material;
    private final String type;

    public NoArmor() {
        this.defense = 0;
        this.material = "None";
        this.type = "None";
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public String getArmorInfo() {
        return "No armor equipped";
    }

    @Override
    public String getArmorType() {
        return type;
    }

    @Override
    public String getArmorMaterial() {
        return material;
    }

    public void displayInfo() {
        System.out.println("Armor: " + getArmorInfo());
        System.out.println("Defense: " + defense);
        System.out.println("Type: " + type);
        System.out.println("Material: " + material);
    }
}

