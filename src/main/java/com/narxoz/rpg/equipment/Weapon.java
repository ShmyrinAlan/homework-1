package com.narxoz.rpg.equipment;

/**
 * Interface for all weapon types in the game.
 *
 * Abstract Factory Pattern:
 * This is one of the "Product" interfaces in an Abstract Factory.
 * Each equipment theme (Medieval, Magic, Ranger) will have its own concrete weapon.
 *
 * TODO: Define what all weapons have in common
 * Think: What information should every weapon provide?
 * Examples: damage, weapon type, special properties, etc.
 */
public interface Weapon {

    // TODO: Add weapon behavior methods
    // Consider:
    // - int getDamage()
    // - String getWeaponInfo()
    // - String getWeaponType()
    // - any theme-specific properties?
     int getDamage();
     void displayInfo();
     String getWeaponInfo();
     String getWeaponType();
     String getWeaponElement();

}
