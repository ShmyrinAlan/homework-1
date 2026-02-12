package com.narxoz.rpg.equipment;

public class GendalfsStick implements Weapon{
    private final int damage;
    private final String weaponType;
    private final String weaponElement;

    public GendalfsStick() {
        this.damage = 10;
        this.weaponType = "Magic Stick";
        this.weaponElement = "Light";
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public String getWeaponInfo() {
        return "Gendalf's stick - an old stick";
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
