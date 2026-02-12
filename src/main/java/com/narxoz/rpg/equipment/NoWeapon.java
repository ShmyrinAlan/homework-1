package com.narxoz.rpg.equipment;

public class NoWeapon implements Weapon {

    private final int damage;
    private final String weaponType;
    private final String weaponElement;

    public NoWeapon() {
        this.damage = 0;
        this.weaponType = "None";
        this.weaponElement = "None";
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public String getWeaponInfo() {
        return "No weapon equipped";
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

