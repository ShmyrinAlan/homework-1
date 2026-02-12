package com.narxoz.rpg.equipment;

public class ElvenBow implements Weapon {
    private final int damage;
    private final String weaponType;
    private final String weaponElement;

    public ElvenBow() {
        this.damage = 15;
        this.weaponType = "Bow";
        this.weaponElement = "Wind";
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public String getWeaponInfo() {
        return "Elven Bow - a finely crafted bow of the forest";
    }

    @Override
    public String getWeaponType() {
        return weaponType;
    }

    @Override
    public String getWeaponElement() {
        return weaponElement;
    }

    public void displayInfo() {
        System.out.println("Weapon: " + getWeaponInfo());
        System.out.println("Damage: " + damage);
        System.out.println("Type: " + weaponType);
        System.out.println("Element: " + weaponElement);
    }
}

